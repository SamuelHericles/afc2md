package br.com.caelum.tubaina2.conversor.logica;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.caelum.tubaina2.conversor.modelo.AFC;
import br.com.caelum.tubaina2.conversor.modelo.MarkDown;
import br.com.caelum.tubaina2.conversor.modelo.Summary;

public class Diretorio {

	private final Path diretorio;

	public Diretorio(String dir) {
		diretorio = Paths.get(dir).toAbsolutePath();
	}

	public List<AFC> buscarArquivosAFC() throws IOException {
		List<AFC> afcs = new ArrayList<AFC>();

		File[] files = buscaFilesAFC();
		
		criaAFCs(afcs, files);

		ordenaPorPath(afcs);

		identificaReadme(afcs);
		
		return afcs;
	}

	public void criaArquivoMD(MarkDown md) throws IOException {
		Files.write(md.path(), md.conteudo().getBytes());
	}
	
	public void criaSummaryMD(Summary summary) throws IOException{
		Path path = diretorio.resolve(Summary.NOME_MD);
		MarkDown summaryMD = new MarkDown(path, summary.conteudo(), Summary.TITULO_MD);
		criaArquivoMD(summaryMD);
	}

	public void copiaArquivosEstaticos() throws IOException, URISyntaxException {
		URI arquivosURI = Diretorio.class.getResource("/arquivos").toURI();
		Path arquivos = Paths.get(arquivosURI);
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
		return files;
	}
	
	private void criaAFCs(List<AFC> afcs, File[] files) throws IOException {
		for (File file : files) {
			Path path = Paths.get(file.getAbsolutePath());
			String conteudo = new String(Files.readAllBytes(path));
			afcs.add(new AFC(path, conteudo));
		}
	}
	private void ordenaPorPath(List<AFC> afcs) {
		Collections.sort(afcs, new Comparator<AFC>() {
			public int compare(AFC o1, AFC o2) {
				return o1.path().compareTo(o2.path());
			}
		});
	}

	private void identificaReadme(List<AFC> afcs) {
		if(!afcs.isEmpty()){
			afcs.get(0).tornaReadme();
		}
	}

	private void copiaTodosOsArquivos(final Path arquivos) throws IOException {
		Files.walkFileTree(arquivos, new FileVisitor<Path>() {
			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
				return FileVisitResult.CONTINUE;
			}
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				Path target = diretorio.resolve(file.getFileName());
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

}
