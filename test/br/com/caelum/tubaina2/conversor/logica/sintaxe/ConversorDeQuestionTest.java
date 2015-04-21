package br.com.caelum.tubaina2.conversor.logica.sintaxe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConversorDeQuestionTest {

	private static final String TEXTO_QUESTAO = "Entre no diretório %%Caelum/26/%% e copie os jars da pasta %%jars%% para a pasta %%WEB-INF/lib%% do seu projeto.\n";
	private ConversorDeSintaxe conversor;

	@Before
	public void setUp() {
		conversor = new ConversorDeQuestion();
	}

	@Test
	public void soComUm() {
		String questao = "[question]\n"+
						 "\t\t"+TEXTO_QUESTAO+
						 "[/question]\n";
		Assert.assertEquals("1. "+TEXTO_QUESTAO+"\n", conversor.converte(questao));
	}

	@Test
	public void maiusculo() {
		String questao = "[QUESTION]\n"+
						 "\t\t"+TEXTO_QUESTAO+
						 "[/QUESTION]\n";
		Assert.assertEquals("1. "+TEXTO_QUESTAO+"\n", conversor.converte(questao));
	}

}
