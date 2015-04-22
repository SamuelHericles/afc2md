package br.com.caelum.tubaina2.conversor.logica;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.tubaina2.conversor.modelo.AFC;
import br.com.caelum.tubaina2.conversor.modelo.MarkDown;

public class ConversorMarkDownTest {

	private ConversorMarkDown conversor;

	@Before
	public void setUp(){
		conversor = new ConversorMarkDown();
	}

	@Test
	public void obtemTituloEmUmaLinha() throws IOException {
		String conteudoAFC = "[chapter AJAX com JSF 2]\n";
		AFC afc = new AFC(Paths.get(""), conteudoAFC, false);

		MarkDown md = conversor.converte(afc);
		
		String titulo = md.titulo();
		Assert.assertEquals("AJAX com JSF 2", titulo);
	}

	@Test
	public void obtemTituloComEspacosNaFrente() throws IOException {
		String conteudoAFC = "[chapter       AJAX com JSF 2]\n";
		AFC afc = new AFC(Paths.get(""), conteudoAFC, false);

		MarkDown md = conversor.converte(afc);
		
		String titulo = md.titulo();
		Assert.assertEquals("AJAX com JSF 2", titulo);
	}

	@Test
	public void obtemTituloComQuebraDeLinhaTabsEEspacosNaFrente() throws IOException {
		String conteudoAFC = "[chapter\n   \t\t \n   AJAX com JSF 2]\n";
		AFC afc = new AFC(Paths.get(""), conteudoAFC, false);

		MarkDown md = conversor.converte(afc);
		
		String titulo = md.titulo();
		Assert.assertEquals("AJAX com JSF 2", titulo);
	}

	@Test
	public void notesComCodeEInlineCode() throws IOException, URISyntaxException {
		String afc = "notes_com_code_e_inline_code.afc";
		String md = "notes_com_code_e_inline_code.md";
		verificaConversaoDeAFCemMD(afc, md);
	}

	@Test
	public void exerciseQuestionsEAnswers() throws IOException, URISyntaxException {
		String afc = "exercise_questions_e_answers.afc";
		String md = "exercise_questions_e_answers.md";
		verificaConversaoDeAFCemMD(afc, md);
	}
	
	
	@Test
	public void codeEmUmaLinhaComTabsDentroDeQuestions() throws IOException, URISyntaxException {
		String afc = "code_em_uma_linha_com_tabs_dentro_de_questions.afc";
		String md = "code_em_uma_linha_com_tabs_dentro_de_questions.md";
		verificaConversaoDeAFCemMD(afc, md);
	}
	
	private void verificaConversaoDeAFCemMD(String arquivoAFC, String arquivoMD) throws URISyntaxException, IOException{
		AFC afc = criaAfcAPartirDoArquivo("/exemplos/afc/"+arquivoAFC);
		
		MarkDown md = conversor.converte(afc);
		String conteudoMD = md.conteudo();

		String conteudoEsperadoMD = obtemMdEsperadoDoArquivo("/exemplos/md/"+arquivoMD);
		Assert.assertEquals(conteudoEsperadoMD, conteudoMD);
	}

	private AFC criaAfcAPartirDoArquivo(String nomeAFC) throws URISyntaxException, IOException {
		Path pathAFC = Diretorio.getResourceAsPath(nomeAFC);
		String conteudoAFC = Diretorio.getPathContents(pathAFC);
		return new AFC(pathAFC, conteudoAFC, false);
	}

	private String obtemMdEsperadoDoArquivo(String nomeMD) throws URISyntaxException, IOException {
		Path pathMD = Diretorio.getResourceAsPath(nomeMD);
		return Diretorio.getPathContents(pathMD);
	}

}
