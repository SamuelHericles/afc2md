package br.com.caelum.tubaina2.conversor.logica.sintaxe;

public class ConversorDeTable implements ConversorDeSintaxe {
	
	private static final String REGEX_REMOVE_ESPACOS_ANTES_DO_COL = "\\s+\\[col\\]";
	private static final String REPLACEMENT_REMOVE_ESPACOS_ANTES_DO_COL = "\\[col\\]";
	
	private static final String REGEX_PRIMEIRA_ROW = "(?s)(\\[table\\]\\s+\\[row\\].*?\\[/row\\])";
	private static final String REPLACEMENT_PRIMEIRA_ROW = "$1\n|-|";

	private static final String REGEX_ABERTURA_TABLE = "\\[table\\]";
	private static final String REPLACEMENT_ABERTURA_TABLE = "";
	
	private static final String REGEX_FECHAMENTO_TABLE = "\\[/table\\]";
	private static final String REPLACEMENT_FECHAMENTO_TABLE = "";
	
	private static final String REGEX_ABERTURA_ROW = "[ \\t]*\\[row\\]";
	private static final String REPLACEMENT_ABERTURA_ROW = "";
	
	private static final String REGEX_ULTIMO_COL = "(?s)\\[/col\\]\\s*?\\[/row\\]";
	private static final String REPLACEMENT_ULTIMO_COL = "|";
	
	private static final String REGEX_ABERTURA_COL = "\\[col\\]";
	private static final String REPLACEMENT_ABERTURA_COL = "|";
	
	private static final String REGEX_FECHAMENTO_COL = "(?s)\\[/col\\].*?\\|";
	private static final String REPLACEMENT_FECHAMENTO_COL = "|";

	@Override
	public String converte(String sintaxe) {
		return sintaxe
				.replaceAll(REGEX_REMOVE_ESPACOS_ANTES_DO_COL, REPLACEMENT_REMOVE_ESPACOS_ANTES_DO_COL)
				.replaceAll(REGEX_PRIMEIRA_ROW, REPLACEMENT_PRIMEIRA_ROW)
				.replaceAll(REGEX_ABERTURA_TABLE, REPLACEMENT_ABERTURA_TABLE)
				.replaceAll(REGEX_FECHAMENTO_TABLE, REPLACEMENT_FECHAMENTO_TABLE)
				.replaceAll(REGEX_ABERTURA_ROW, REPLACEMENT_ABERTURA_ROW)
				.replaceAll(REGEX_ULTIMO_COL, REPLACEMENT_ULTIMO_COL)
				.replaceAll(REGEX_ABERTURA_COL, REPLACEMENT_ABERTURA_COL)
				.replaceAll(REGEX_FECHAMENTO_COL, REPLACEMENT_FECHAMENTO_COL)
		;
	}

}
