package br.com.caelum.tubaina2.conversor.logica;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import br.com.caelum.tubaina2.conversor.modelo.AFC;
import br.com.caelum.tubaina2.conversor.modelo.MarkDown;

public class Diretorio {

	private final Path diretorio;

	public Diretorio(String dir) {
		diretorio = Paths.get(dir).toAbsolutePath();
	}

	public List<AFC> buscarArquivosAFC() throws IOException {
		List<AFC> afcs = new ArrayList<AFC>();

		File[] files = buscaFilesAFC();
		
		criaAFCs(afcs, files);

		return afcs;
	}

	public void criaArquivoMD(MarkDown md) throws IOException {
		Path path = diretorio.resolve(String.format("%02d", md.numero())+"-"+filename(md.titulo())+".md");
		Files.write(path, md.conteudo().getBytes());
	}
	
	public void copiaArquivosEstaticos() throws IOException, URISyntaxException {
		Path arquivos = getResourceAsPath("/arquivos");
		copiaTodosOsArquivos(arquivos);
	}

	@Override
	public String toString() {
		return diretorio.toString();
	}

	private File[] buscaFilesAFC() {
		File[] files = diretorio.toFile().listFiles(new FilenameFilter() {
			public boolean accept(File dir, String nome) {
				return nome.endsWith(".afc");
			}
		});
		if(files == null) {
			return new File[0];
		}
		Arrays.sort(files);
		return files;
	}
	
	private void criaAFCs(List<AFC> afcs, File[] files) throws IOException {
		for (File file : files) {
			Path path = Paths.get(file.getAbsolutePath());
			String conteudo = getPathContents(path);
			afcs.add(new AFC(path, conteudo));
		}
	}

	private void copiaTodosOsArquivos(final Path arquivos) throws IOException {
		Files.walkFileTree(arquivos, new FileVisitor<Path>() {
			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
				return FileVisitResult.CONTINUE;
			}
			//veja http://fgaliegue.blogspot.com.br/2014/03/working-with-java-7-file-api-recursive.html
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				Path absolutePath = file.toAbsolutePath();
				Path relativePath = arquivos.relativize(absolutePath);
				Path target = diretorio.resolve(relativePath.toString());
				Files.copy(file, target, StandardCopyOption.REPLACE_EXISTING);
				return FileVisitResult.CONTINUE;
			}
			public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
				return FileVisitResult.TERMINATE;
			}
			public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
				return FileVisitResult.CONTINUE;
			}
		});
	}
	
	public static String filename(String title){
		return Normalizer.normalize(title, Normalizer.Form.NFD)
			.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "")
			.toLowerCase()
			.replaceAll("[\\p{Punct}]", " ")
			.trim()
			.replaceAll("\\s+", "-");
	}

	public static Path getResourceAsPath(String resource) throws URISyntaxException, IOException {
		URI uri = Diretorio.class.getResource(resource).toURI();
		if(isResourceInJar(uri)){
			return getResourceFromJar(uri);
		} else {
			return Paths.get(uri);
		}
	}

	private static boolean isResourceInJar(URI uri) {
		return uri.toString().contains("!");
	}

	public static Path getResourceFromJar(URI fullURI) throws IOException {
		//veja http://stackoverflow.com/a/22605905
		String[] uriParts = fullURI.toString().split("!");
		URI jarURI = URI.create(uriParts[0]);
		FileSystem fs = FileSystems.newFileSystem(jarURI, new HashMap<String, String>());
		String resourceURI = uriParts[1];
		return fs.getPath(resourceURI);
	}

	public static String getPathContents(Path path) throws IOException {
		return new String(Files.readAllBytes(path));
	}

}
