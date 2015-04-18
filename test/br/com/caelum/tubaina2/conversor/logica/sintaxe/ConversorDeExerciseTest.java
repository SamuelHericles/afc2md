package br.com.caelum.tubaina2.conversor.logica.sintaxe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConversorDeExerciseTest {

	private static final String TEXTO_EXERCICIO = "[question]\n"
												+ "Substitua o `<h:selectOneMenu>` na tela de adição de itens na nota fiscal\n"
												+ " pelo componente de Autocomplete do primefaces.\n"
												+ "[/question]";
	private ConversorDeSintaxe convesor;

	@Before
	public void setUp() {
		convesor = new ConversorDeExercise();
	}

	@Test
	public void emUmaLinha() {
		String questao = "[exercise]\n"+
						 TEXTO_EXERCICIO+
						 "[/exercise]\n";
		Assert.assertEquals("\n"+TEXTO_EXERCICIO+"\n", convesor.converte(questao));
	}

	@Test
	public void maiusculo() {
		String questao = "[EXERCISE]\n"+
				 TEXTO_EXERCICIO+
				 "[/EXERCISE]\n";
		Assert.assertEquals("\n"+TEXTO_EXERCICIO+"\n", convesor.converte(questao));
	}

}
