package br.com.caelum.tubaina2.conversor.logica.sintaxe;

public class ConversorDeInlineCode implements ConversorDeSintaxe {

	private static final String REGEX_INLINE_CODE = "(?s)%%(.*?)%%";
	private static final String REPLACEMENT_INLINE_CODE = "`$1`";
	
	@Override
	public String converte(String sintaxe) {
		return sintaxe.replaceAll(REGEX_INLINE_CODE, REPLACEMENT_INLINE_CODE);
	}

}
