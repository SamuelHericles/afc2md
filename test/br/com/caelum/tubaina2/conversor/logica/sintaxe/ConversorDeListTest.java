package br.com.caelum.tubaina2.conversor.logica.sintaxe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConversorDeListTest {

	private ConversorDeSintaxe conversor;

	@Before
	public void setUp() {
		conversor = new ConversorDeList();
	}
	
	@Test
	public void normal() {
		
		String sintaxe =  "[list]\n"+
						  "* responder o que é Java;\n"+
						  "* mostrar as vantagens e desvantagens do Java;\n"+
						  "* entender bem o conceito de máquina virtual;\n"+
						  "* compilar e executar um programa simples.\n"+
						  "[/list]\n";
		
		String convertido = conversor.converte(sintaxe);
		
		String esperado = "\n"+
						  "* responder o que é Java;\n"+
						  "* mostrar as vantagens e desvantagens do Java;\n"+
						  "* entender bem o conceito de máquina virtual;\n"+
						  "* compilar e executar um programa simples.\n"+
						  "\n";
		Assert.assertEquals(esperado, convertido);
	}

	@Test
	public void comNumber() {
		
		String sintaxe =  "[list number]\n"+
						  "	* Procure um colega, ou algum conhecido, que esteja em um projeto Java. Descubra porque Java \n"+
						  "	foi escolhido como tecnologia. O que é importante para esse projeto e o que acabou fazendo \n"+
						  "	do Java a melhor escolha?\n"+
						  "[/list]\n";
		
		String convertido = conversor.converte(sintaxe);
		
		String esperado = "\n"+
						  "	* Procure um colega, ou algum conhecido, que esteja em um projeto Java. Descubra porque Java \n"+
						  "	foi escolhido como tecnologia. O que é importante para esse projeto e o que acabou fazendo \n"+
						  "	do Java a melhor escolha?\n"+
						  "\n";
		Assert.assertEquals(esperado, convertido);
	}
	
	@Test
	public void comLetter(){
		String sintaxe =  "[list letter]\n"+
						  "* Crie uma classe chamada %%BalancoTrimestral%% com um bloco main, como nos \n"+
						  "exemplos anteriores;\n"+
						  "* Dentro do %%main%% (o miolo do programa), declare uma variável inteira chamada \n"+
						  "%%gastosJaneiro%% e inicialize-a com 15000;\n"+
						  "* Crie também as variáveis %%gastosFevereiro%% e %%gastosMarco%%, inicializando-as \n"+
						  "com 23000 e 17000, respectivamente, utilize uma linha para cada declaração;\n"+
						  "[/list]\n";

		String convertido = conversor.converte(sintaxe);
		
		String esperado = "\n"+
						  "* Crie uma classe chamada %%BalancoTrimestral%% com um bloco main, como nos \n"+
						  "exemplos anteriores;\n"+
						  "* Dentro do %%main%% (o miolo do programa), declare uma variável inteira chamada \n"+
						  "%%gastosJaneiro%% e inicialize-a com 15000;\n"+
						  "* Crie também as variáveis %%gastosFevereiro%% e %%gastosMarco%%, inicializando-as \n"+
						  "com 23000 e 17000, respectivamente, utilize uma linha para cada declaração;\n"+
						  "\n";
		Assert.assertEquals(esperado, convertido);

	}
	
	@Test
	public void comCerquilha(){
		String sintaxe = "[list #]\n"+
						 "	* Arrays podem ter mais de uma dimensão. Isto é, em vez de termos uma array de \n"+
						 "	10 contas, podemos ter uma array de 10 por 10 contas e você pode acessar a conta \n"+
						 "	na posição da coluna x e linha y. Na verdade, uma array bidimensional em Java é \n"+
						 "	uma array de arrays. Pesquise sobre isso.\n"+
						 "\n"+
						 "	[img images/arrays/referencia_matriz_quadrada.png w=60%]\n"+
						 "\n"+
						 "* Uma array bidimensional não precisa ser retangular, isto é, cada linha pode ter um número \n"+
						 "  diferente de colunas. Como? Porque?\n"+
						 "\n"+
						 "      [img images/arrays/referencia_matriz_variavel.png w=60%]\n"+
						 "[/list]\n";

		String convertido = conversor.converte(sintaxe);
		
		String esperado = "\n"+
						  "	* Arrays podem ter mais de uma dimensão. Isto é, em vez de termos uma array de \n"+
						  "	10 contas, podemos ter uma array de 10 por 10 contas e você pode acessar a conta \n"+
						  "	na posição da coluna x e linha y. Na verdade, uma array bidimensional em Java é \n"+
						  "	uma array de arrays. Pesquise sobre isso.\n"+
						  "\n"+
						  "	[img images/arrays/referencia_matriz_quadrada.png w=60%]\n"+
						  "\n"+
						  "* Uma array bidimensional não precisa ser retangular, isto é, cada linha pode ter um número \n"+
						  "  diferente de colunas. Como? Porque?\n"+
						  "\n"+
						  "      [img images/arrays/referencia_matriz_variavel.png w=60%]\n"+
						  "\n";
		Assert.assertEquals(esperado, convertido);

	}

}
