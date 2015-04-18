package br.com.caelum.tubaina2.conversor;

import java.util.List;

import br.com.caelum.tubaina2.conversor.logica.ConversorMarkDown;
import br.com.caelum.tubaina2.conversor.logica.DiretorioCorrente;
import br.com.caelum.tubaina2.conversor.modelo.AFC;
import br.com.caelum.tubaina2.conversor.modelo.MarkDown;
import br.com.caelum.tubaina2.conversor.modelo.Summary;

public class Main {

	public static void main(String[] args) throws Exception {
		DiretorioCorrente diretorio = new DiretorioCorrente();
		ConversorMarkDown conversor = new ConversorMarkDown();
		Summary summary = new Summary();
		
		List<AFC> afcs = diretorio.buscarArquivosAFC();
		for (AFC afc : afcs) {
			MarkDown md = conversor.converte(afc);
			summary.adiciona(md);
			diretorio.criaArquivoMD(md);
		}

		diretorio.criaArquivoMD(summary.emMd());
	}


}
