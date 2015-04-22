package br.com.caelum.tubaina2.conversor.logica.sintaxe;

import br.com.caelum.tubaina2.conversor.logica.sintaxe.ConversorDeParagrafo.AjudanteDeParsingDeCode;


public class ConversorDeQuestion implements ConversorDeSintaxe {

	private static final String ABERTURA_QUESTION = "[question]";
	private static final String FECHAMENTO_QUESTION = "[/question]";

	AjudanteDeParsingDeQuestion question;
	AjudanteDeParsingDeCode code;
	
	@Override
	public String converte(String sintaxe) {
		question = new AjudanteDeParsingDeQuestion();
		code = new AjudanteDeParsingDeCode();

		StringBuilder convertido = new StringBuilder();
		
		String[] linhas = sintaxe.split("\\n");
		
		for (String linha : linhas) {
			
			question.verificaSeEstaNaPrimeiraLinha();
			
			question.emNovaLinha();
			code.emNovaLinha();
			
			question.verificaSeEstaAbrindoOuFechando(linha); 

			if(question.naoEstaAbrindoNemFechando()){
				processaLinha(convertido, linha);
			}
		}
				
		return removeDuasOuMaisQuebrasDeLinhasSeguidasAntesDeQuestion(convertido.toString());
	}

	private String removeDuasOuMaisQuebrasDeLinhasSeguidasAntesDeQuestion(String convertido) {
		//No Markdown, se uma lista numerada tiver duas ou mais quebras de linha, a contagem recomeça.
		return convertido.replaceAll("(?s)\n{2,}1.", "\n1.");
	}

	private void processaLinha(StringBuilder convertido, String linha) {
		if(question.naoEstaDentroDeQuestion()){
			adicionaLinhaSemAlterar(convertido, linha);
		} else {
			processaLinhaQueEstaDentroDeQuestion(convertido, linha);
		}
	}

	public void processaLinhaQueEstaDentroDeQuestion(StringBuilder convertido, String linha) {
		if(question.estaNaPrimeiraLinha()){
			adicionaPrimeiraLinhaDeQuestion(convertido, linha);
		} else {
			processaOutrasLinhasDeQuestion(convertido, linha);
		}
	}

	public void processaOutrasLinhasDeQuestion(StringBuilder convertido, String linha) {
		if(linhaEstaVazia(linha)){
			adicionaLinhaSemEspacosETabsNaFrente(convertido, linha);
		} else {
			code.verificaSeEstaDentro(linha);
			if(code.naoEstaDentroNemAbrindoNemFechando()) {
				adicionaLinhaComApenasUmTabNaFrente(convertido, linha);
			} else {
				adicionaLinhaSemAlterar(convertido, linha);
			}
		}
	}

	public boolean linhaEstaVazia(String linha) {
		return linha.trim().isEmpty();
	}

	public StringBuilder adicionaLinhaComApenasUmTabNaFrente(StringBuilder convertido, String linha) {
		return convertido.append("\t" + linha.trim() + "\n");
	}

	private void adicionaPrimeiraLinhaDeQuestion(StringBuilder convertido, String linha) {
		convertido.append("1. " + linha.trim() + "\n");
	}

	private void adicionaLinhaSemAlterar(StringBuilder convertido, String linha) {
		convertido.append(linha+"\n");
	}

	private void adicionaLinhaSemEspacosETabsNaFrente(StringBuilder convertido, String linha) {
		convertido.append(linha.trim()+"\n");
	}

	static class AjudanteDeParsingDeQuestion {
		private boolean dentro;
		private boolean achouAbertura;
		private boolean achouFechamento;
		private boolean naPrimeiraLinha ;

		AjudanteDeParsingDeQuestion() {
			dentro = false;
			achouAbertura = false;
			achouFechamento = false;
			naPrimeiraLinha = false;
		}
		
		void verificaSeEstaNaPrimeiraLinha() {
			naPrimeiraLinha = false;
			if(achouAbertura){
				naPrimeiraLinha = true;
			}
		}

		void emNovaLinha() {
			achouAbertura = false;
			achouFechamento = false;
		}

		void verificaSeEstaAbrindoOuFechando(String linha) {
			String linhaSemEspacos = linha.trim();
			if(ABERTURA_QUESTION.equalsIgnoreCase(linhaSemEspacos)) {
				dentro = true;
				achouAbertura = true;
			} else if(FECHAMENTO_QUESTION.equalsIgnoreCase(linhaSemEspacos)){
				dentro = false;
				achouFechamento = true;
			}
		}

		boolean naoEstaAbrindoNemFechando() {
			return !achouAbertura && !achouFechamento;
		}

		boolean naoEstaDentroDeQuestion() {
			return !dentro;
		}
		
		boolean estaNaPrimeiraLinha(){
			return naPrimeiraLinha;
		}
	}
	
}


