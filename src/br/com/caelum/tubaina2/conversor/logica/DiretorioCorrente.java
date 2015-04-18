package br.com.caelum.tubaina2.conversor.logica;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.caelum.tubaina2.conversor.modelo.AFC;
import br.com.caelum.tubaina2.conversor.modelo.MarkDown;

public class DiretorioCorrente {

	private Path diretorio = Paths.get("").toAbsolutePath();

	public List<AFC> buscarArquivosAFC() throws IOException {
		List<AFC> afcs = new ArrayList<AFC>();

		File[] files = buscaFilesAFC();
		
		criaAFCs(afcs, files);

		identificaReadme(afcs);
		
		return afcs;
	}

	public File[] buscaFilesAFC() {
		File[] files = diretorio.toFile().listFiles(new FilenameFilter() {
			public boolean accept(File dir, String nome) {
				return nome.endsWith(".afc");
			}
		});
		return files;
	}
	
	public void criaAFCs(List<AFC> afcs, File[] files) throws IOException {
		for (File file : files) {
			Path path = Paths.get(file.getAbsolutePath());
			String conteudo = new String(Files.readAllBytes(path));
			afcs.add(new AFC(path, conteudo));
		}
		ordenaPorPath(afcs);
	}

	public void criaArquivoMD(MarkDown md) throws IOException {
		Files.write(md.path(), md.conteudo().getBytes());
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

}
