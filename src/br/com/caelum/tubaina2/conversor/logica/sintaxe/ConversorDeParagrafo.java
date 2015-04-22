package br.com.caelum.tubaina2.conversor.logica.sintaxe;

public class ConversorDeParagrafo implements ConversorDeSintaxe {

	private static final String CODIGO = "```";

	@Override
	public String converte(String sintaxe) {
		return trimEmTudoOQueNaoForCode(sintaxe);
	}

	public String trimEmTudoOQueNaoForCode(String sintaxe) {
		String[] linhas = sintaxe.split("\\n");
		StringBuffer sb = new StringBuffer();
		boolean dentroDeCode = false;
		for (String linha : linhas) {
			boolean achouAberturaOuFechamentoDeCode = false;
			String linhaSemEspacos = linha.trim();
			if(linhaSemEspacos.equals(CODIGO) || (linhaSemEspacos.startsWith(CODIGO) && !linhaSemEspacos.endsWith(CODIGO))) {
				dentroDeCode = ! dentroDeCode;
				achouAberturaOuFechamentoDeCode = true;
			}
			if(!dentroDeCode || achouAberturaOuFechamentoDeCode) {
				linha = linhaSemEspacos;
			}
			sb.append(linha + "\n");
		}
		
		return sb.toString();
	}

}
