
_"Nem todos os caminhos são para todos os caminhantes" -- Johann Wolfgang von Goethe_

## Exercícios: primeira página
1. Em `WebContent`, através do menu **File -> New -> Other -> HTML** crie um
	arquivo chamado **index.xhtml** .
	Após definir o nome do arquivo clique em _Next_ e você verá a seguinte tela:

	![ {w=60%}](imagens/nocoes-basicas/transitional.png)

	Selecione a mesma opção da imagem acima.

	Implemente nosso primeiro código JSF com um campo de texto e um botão:

	``` xml
			<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
			"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
			<html xmlns="http://www.w3.org/1999/xhtml"
			      xmlns:f="http://java.sun.com/jsf/core"      
			      xmlns:h="http://java.sun.com/jsf/html">

				<h:head>
					<title>Sistema de Notas Fiscais</title>
				</h:head>

				<h:body>
					<h:form>
						<h:inputText />
						<h:commandButton value="Clique-me" />
					</h:form>
			    </h:body>
			</html>
	```
1. Inicie o Glassfish e acesse a URL:
	`http://localhost:8080/fj26-notas-fiscais/index.xhtml`
	O resultado deve ser esse:

	![ {w=35}](imagens/nocoes-basicas/helloworld.png)
1. Verifique o código fonte gerado pela página. Repare que não é nada mais que simples HTML.


<!--
No exercício, faça eles verem o código fonte HTML da pagina inicialmente, aí
preencha a caixa de texto e clique no botão. Observar que os dados são
mantidos. Aí abre-se o HTML depois do submit e observa-se o value no source.
Explicar que o JSF manteve o estado automaticamente, sem fazermos nada. Se
fosse o mesmo exemplo em HTML puro, o campo viria vazio depois do submit.
-->
