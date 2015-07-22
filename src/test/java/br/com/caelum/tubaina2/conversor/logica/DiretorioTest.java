package br.com.caelum.tubaina2.conversor.logica;

import org.junit.Assert;
import org.junit.Test;


public class DiretorioTest {

	@Test
	public void normal(){
		Assert.assertEquals("como-aprender-java", Diretorio.filename("Como Aprender Java"));
	}

	@Test
	public void comAcento(){
		Assert.assertEquals("o-que-e-java", Diretorio.filename("O que é Java"));
	}
	
	@Test
	public void comVirgula(){
		Assert.assertEquals("heranca-reescrita-e-polimorfismo", Diretorio.filename("Herança, reescrita e polimorfismo"));
	}	
	
	@Test
	public void comHifen(){
		Assert.assertEquals("pacotes-organizando-suas-classes-e-bibliotecas", Diretorio.filename("Pacotes - Organizando suas classes e bibliotecas"));
	}	

	@Test
	public void comDoisPontos(){
		Assert.assertEquals("ferramentas-jar-e-javadoc", Diretorio.filename("Ferramentas: jar e javadoc"));
	}	

	@Test
	public void comPonto(){
		Assert.assertEquals("o-pacote-java-lang", Diretorio.filename("O pacote java.lang"));
	}	

	@Test
	public void comInterrogacao(){
		Assert.assertEquals("e-agora", Diretorio.filename("E agora?"));
	}	
	
	@Test
	public void comCifraoParentesesEMais(){
		Assert.assertEquals("jquery-o-d", Diretorio.filename("jQuery, o $() d+"));
	}	
}
