
package br.com.caelum.tubaina2.conversor.logica;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;

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
	public void notesComCodeEInlineCode() throws IOException, URISyntaxException {
		verificaConversaoDeAFCemMD("notes_com_code_e_inline_code");
	}

	@Test
	public void exerciseQuestionsEAnswers() throws IOException, URISyntaxException {
		verificaConversaoDeAFCemMD("exercise_questions_e_answers");
	}
	
	@Test
	public void exerciseComQuestionsEmVariasLinhas() throws IOException, URISyntaxException {
		verificaConversaoDeAFCemMD("exercise_com_questions_em_varias_linhas");
	}
	
	@Test
	public void codeEmUmaLinhaComTabsDentroDeQuestions() throws IOException, URISyntaxException {
		verificaConversaoDeAFCemMD("texto_com_tabs_code_em_uma_linha_e_em_varias_linhas");
	}

	@Test
	public void variosBoxesConsecutivosComVariasLinhasECode() throws IOException, URISyntaxException {
		verificaConversaoDeAFCemMD("varios_boxes_consecutivos_com_varias_linhas_e_code");
	}

	@Test
	public void textoComImgSeguidoPorIndex() throws IOException, URISyntaxException {
		verificaConversaoDeAFCemMD("texto_com_img_seguido_por_index");
	}

	@Test
	public void codeEmExercicioSemIdentacao() throws IOException, URISyntaxException {
		verificaConversaoDeAFCemMD("code-em-exercicio-sem-identacao");
	}
	
	
	private void verificaConversaoDeAFCemMD(String arquivo) throws URISyntaxException, IOException{
		AFC afc = criaAfcAPartirDoArquivo("/exemplos/afc/"+arquivo+".afc");
		
		MarkDown md = conversor.converte(afc);
		String conteudoMD = md.conteudo();

		String conteudoEsperadoMD = obtemMdEsperadoDoArquivo("/exemplos/md/"+arquivo+".md");
		Assert.assertEquals(conteudoEsperadoMD, conteudoMD);
	}

	private AFC criaAfcAPartirDoArquivo(String nomeAFC) throws URISyntaxException, IOException {
		Path pathAFC = Diretorio.getResourceAsPath(nomeAFC);
		String conteudoAFC = Diretorio.getPathContents(pathAFC);
		return new AFC(pathAFC, conteudoAFC);
	}

	private String obtemMdEsperadoDoArquivo(String nomeMD) throws URISyntaxException, IOException {
		Path pathMD = Diretorio.getResourceAsPath(nomeMD);
		return Diretorio.getPathContents(pathMD);
	}

}
