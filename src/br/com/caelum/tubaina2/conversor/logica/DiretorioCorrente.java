package br.com.caelum.tubaina2.conversor.logica;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.tubaina2.conversor.modelo.AFC;
import br.com.caelum.tubaina2.conversor.modelo.MarkDown;

public class DiretorioCorrente {

	private Path diretorio = Paths.get("").toAbsolutePath();

	public List<AFC> buscarArquivosAFC() throws IOException {
		List<AFC> afcs = new ArrayList<AFC>();

		File[] files = diretorio.toFile().listFiles((dir, nome) -> nome.endsWith(".afc"));
		for (File file : files) {
			Path path = Paths.get(file.getAbsolutePath());
			String conteudo = new String(Files.readAllBytes(path));
			
			afcs.add(new AFC(path, conteudo));
		}

		return afcs;
	}

	public void criaArquivoMD(MarkDown md) throws IOException {
		Files.write(md.path(), md.conteudo().getBytes());
	}

}
