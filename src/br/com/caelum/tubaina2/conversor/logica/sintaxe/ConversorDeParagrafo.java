package br.com.caelum.tubaina2.conversor.logica.sintaxe;

public class ConversorDeParagrafo implements ConversorDeSintaxe {

	@Override
	public String converte(String sintaxe) {
		String[] linhas = sintaxe.split("\\n");
		StringBuffer sb = new StringBuffer();
		boolean dentroDeCode = false;
		for (String linha : linhas) {
			boolean achouAberturaOuFechamentoDeCode = false;
			if(linha.trim().startsWith("```")) {
				dentroDeCode = ! dentroDeCode;
				achouAberturaOuFechamentoDeCode = true;
			}
			if(!dentroDeCode || achouAberturaOuFechamentoDeCode) {
				linha = linha.trim();
			}
			sb.append(linha + "\n");
		}
		
		return sb.toString();
	}

}
