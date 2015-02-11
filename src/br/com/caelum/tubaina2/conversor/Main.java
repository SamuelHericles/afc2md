package br.com.caelum.tubaina2.conversor;

import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		DiretorioCorrente diretorio = new DiretorioCorrente();
		ConversorMarkDown conversor = new ConversorMarkDown();

		List<AFC> afcs = diretorio.buscarArquivosAFC();
		for (AFC afc : afcs) {
			MarkDown md = conversor.converte(afc);
			diretorio.criaArquivoMD(md);
		}
	}

}
