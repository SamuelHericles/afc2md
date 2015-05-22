package br.com.caelum.tubaina2.conversor.logica.sintaxe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConversorDeExerciseTest {

	private static final String QUESTOES = "[question]\n"
												+ "Substitua o %%selectOneMenu>%% na tela de adição de itens na nota fiscal\n"
												+ " pelo componente de Autocomplete do primefaces.\n"
												+ "[/question]";
	private ConversorDeSintaxe conversor;

	@Before
	public void setUp() {
		conversor = new ConversorDeExercise();
	}

	@Test
	public void emUmaLinha() {
		String exercicio = "[exercise]\n"+
							QUESTOES+
							"[/exercise]\n";
		Assert.assertEquals("\n"+QUESTOES+"\n", conversor.converte(exercicio));
	}

	@Test
	public void maiusculo() {
		String exercicio = "[EXERCISE]\n"+
							 QUESTOES+
							"[/EXERCISE]\n";
		Assert.assertEquals("\n"+QUESTOES+"\n", conversor.converte(exercicio));
	}

}
