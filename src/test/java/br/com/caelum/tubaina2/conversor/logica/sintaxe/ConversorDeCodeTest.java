package br.com.caelum.tubaina2.conversor.logica.sintaxe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConversorDeCodeTest {

	private ConversorDeSintaxe conversor;

	@Before
	public void setUp() {
		conversor = new ConversorDeCode();
	}

	@Test
	public void emUmaLinha() {
		String codigo = "[code]javap -c MeuPrograma[/code]";
		
		String convertido = conversor.converte(codigo);
		
		String esperado =   "```javap -c MeuPrograma```";
		
		Assert.assertEquals(esperado, convertido);
	}

	@Test
	public void maiusculo() {
		String codigo = "[CODE]java NomeDaClasse[/CODE]";
		
		String convertido = conversor.converte(codigo);
		
		String esperado =   "```java NomeDaClasse```";
		
		Assert.assertEquals(esperado, convertido);
	}
	
	@Test
	public void mantemLinguagem() {
		String codigo = "[code java]\n" +
						"	public class Main {\n" +
						"		public static void main(String... args){}\n" +
						"	}\n" +
						"[/code]";
		
		String convertido = conversor.converte(codigo);
		
		String esperado = 	"``` java\n" +
							"	public class Main {\n" +
							"		public static void main(String... args){}\n" +
							"	}\n" +
							"```";
		
		Assert.assertEquals(esperado, convertido);
	}

	@Test
	public void removeHighlightQuandoForAtributoDeCode() {
		String codigo = "[code java h=3]\n" +
						"	public class UsuarioDao {\n" +
						"		@PersistenceContext\n" +
						"		private EntityManager manager;\n" +
						"	}\n" +
						"[/code]";
		
		String convertido = conversor.converte(codigo);
		
		String esperado = "``` java\n" +
						"	public class UsuarioDao {\n" +
						"		@PersistenceContext\n" +
						"		private EntityManager manager;\n" +
						"	}\n" +
						"```";
		
		Assert.assertEquals(esperado, convertido);
	}

	@Test
	public void removeHighlightSemSinalDeIgual() {
		String codigo = "[code java h 3]\n" +
						"    CriteriaBuilder builder = em.getCriteriaBuilder();\n" +
						"    CriteriaQuery<Movimentacao> criteria = builder.createQuery(Movimentacao.class);\n" +
						"    criteria.from(Movimentacao.class);\n" +
						"[/code]";
		
		String convertido = conversor.converte(codigo);
		
		String esperado = "``` java\n" +
						"    CriteriaBuilder builder = em.getCriteriaBuilder();\n" +
						"    CriteriaQuery<Movimentacao> criteria = builder.createQuery(Movimentacao.class);\n" +
						"    criteria.from(Movimentacao.class);\n" +
						"```";
		
		Assert.assertEquals(esperado, convertido);
	}

	@Test
	public void removeHighlightSemSinalDeIgualNemEspaco() {
		String codigo = "[code java h3]\n" +
						"	//no JPQL select m.valor ...\n" +
						"	Path<BigDecimal> caminho = root.<BigDecimal>get(\"valor\");\n" +
						"	criteria.select(caminho);\n" +
						"[/code]";
		
		String convertido = conversor.converte(codigo);
		
		String esperado = "``` java\n" +
						"	//no JPQL select m.valor ...\n" +
						"	Path<BigDecimal> caminho = root.<BigDecimal>get(\"valor\");\n" +
						"	criteria.select(caminho);\n" +
						"```";
		
		Assert.assertEquals(esperado, convertido);
	}
	
	@Test
	public void naoRemoverHForaDeCode() {
		String trecho = "O namespace padrão dos componentes JSF é "
						+ "%%xmlns:h=\"http://java.sun.com/jsf/html\"%% e "
						+ "%%xmlns:f=\"http://java.sun.com/jsf/core\"%%.\n";
		
		String convertido = conversor.converte(trecho);
		
		Assert.assertEquals(trecho, convertido);
	}

	@Test
	public void naoRemoveHQueEstiverDentroDeCode() {
		String codigo = "	[code html]\n"+
						"		<html xmlns=\"http://www.w3.org/1999/xhtml\"\n"+
						"		      xmlns:ui=\"http://java.sun.com/jsf/facelets\"\n"+
						"		      xmlns:h=\"http://java.sun.com/jsf/html\"\n"+
						"		      xmlns:f=\"http://java.sun.com/jsf/core\">\n"+
						"		</html>\n"+
						"	[/code]";
		
		String convertido = conversor.converte(codigo);
		
		String esperado =   "	``` html\n"+
							"		<html xmlns=\"http://www.w3.org/1999/xhtml\"\n"+
							"		      xmlns:ui=\"http://java.sun.com/jsf/facelets\"\n"+
							"		      xmlns:h=\"http://java.sun.com/jsf/html\"\n"+
							"		      xmlns:f=\"http://java.sun.com/jsf/core\">\n"+
							"		</html>\n"+
							"	```";
		
		Assert.assertEquals(esperado, convertido);
	}

	@Test
	public void removeCerquilha() {
		String codigo = "[code java #]\n" +
						"	class MeuPrograma {\n" +
						"		public static void main(String[] args) {\n" +
									"System.out.println(\"Minha primeira aplicação Java!!\");\n" +
						"		}\n" +
						"	}\n" +
						"[/code]";
		
		String convertido = conversor.converte(codigo);
		
		String esperado = 	"``` java\n" +
							"	class MeuPrograma {\n" +
							"		public static void main(String[] args) {\n" +
										"System.out.println(\"Minha primeira aplicação Java!!\");\n" +
							"		}\n" +
							"	}\n" +
							"```";
		
		Assert.assertEquals(esperado, convertido);
	}

}

