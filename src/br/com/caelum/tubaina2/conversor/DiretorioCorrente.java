package br.com.caelum.tubaina2.conversor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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

}
