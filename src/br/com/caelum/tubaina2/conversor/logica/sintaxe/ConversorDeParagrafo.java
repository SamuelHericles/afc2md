package br.com.caelum.tubaina2.conversor.logica.sintaxe;

public class ConversorDeParagrafo implements ConversorDeSintaxe {

	@Override
	public String converte(String sintaxe) {
		return trimEmTudoOQueNaoForCode(sintaxe);
	}

	public String trimEmTudoOQueNaoForCode(String sintaxe) {
		StringBuffer textoConvertido = new StringBuffer();
		
		String[] linhas = sintaxe.split("\\n");
		
		AjudanteDeParsingDeCode code = new AjudanteDeParsingDeCode();
		
		for (String linha : linhas) {
			
			code.emNovaLinha();
			
			code.verificaSeEstaDentro(linha);
			
			if(code.naoEstaDentroNemAbrindoNemFechando()) {
				linha = tiraEspacosETabsDaFrente(linha);
			}
			textoConvertido.append(linha + "\n");
		}
		
		return textoConvertido.toString();
	}

	public String tiraEspacosETabsDaFrente(String linha) {
		return linha.trim();
	}

	static class AjudanteDeParsingDeCode {
		private static final String CODE = "```";

		boolean dentro;
		boolean achouAberturaOuFechamento;
		
		AjudanteDeParsingDeCode() {
			this.dentro = false;
			this.achouAberturaOuFechamento = false;
		}
		
		void emNovaLinha(){
			this.achouAberturaOuFechamento = false;
		}

		void verificaSeEstaDentro(String linha) {
			if(linhaSoComAberturaOuFechamentoDeCodeENadaMais(linha) || linhaQueComecaAbrindoEFechandoCode(linha)) {
				this.dentro = !this.dentro;
				this.achouAberturaOuFechamento = true;
			}
		}

		boolean naoEstaDentroNemAbrindoNemFechando() {
			return !this.dentro || this.achouAberturaOuFechamento;
		}

		private boolean linhaQueComecaAbrindoEFechandoCode(String linha) {
			String linhaSemEspacos = linha.trim();
			return linhaSemEspacos.startsWith(CODE) && !linhaSemEspacos.endsWith(CODE);
		}

		private boolean linhaSoComAberturaOuFechamentoDeCodeENadaMais(String linha) {
			return CODE.equals(linha.trim());
		}

	}
	
}
