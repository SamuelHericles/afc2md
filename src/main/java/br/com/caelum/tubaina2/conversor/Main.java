package br.com.caelum.tubaina2.conversor;

import java.util.List;

import br.com.caelum.tubaina2.conversor.logica.ConversorMarkDown;
import br.com.caelum.tubaina2.conversor.logica.Diretorio;
import br.com.caelum.tubaina2.conversor.modelo.AFC;
import br.com.caelum.tubaina2.conversor.modelo.MarkDown;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Diretorio diretorio = new Diretorio(obtemArgumentoDeDiretorio(args));
		ConversorMarkDown conversor = new ConversorMarkDown();
		
		List<AFC> afcs = diretorio.buscarArquivosAFC();
		verificaSeEncontrouAFCs(diretorio, afcs);
		
		for (AFC afc : afcs) {
			MarkDown md = conversor.converte(afc);
			diretorio.criaArquivoMD(md);
		}

		diretorio.copiaArquivosEstaticos();
		
		System.out.println("Arquivos afc convertidos para md com sucesso.");
	}

	public static String obtemArgumentoDeDiretorio(String[] args) {
		String diretorio = "";
		if (args.length >= 2 && "-d".equals(args[0])) {
			diretorio = args[1]; 
		}
		return diretorio;
	}

	public static void verificaSeEncontrouAFCs(Diretorio diretorio, List<AFC> afcs) {
		if(afcs.isEmpty()){
			System.err.println("Não foi encontrado nenhum arquivo .afc no diretório: " + diretorio.toString());
			System.err.println("Considere utilizar a opção: -d [diretório]");
			System.exit(1);
		}
	}

}
