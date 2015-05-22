### Configurações básicas

É importante nos identificarmos para o Git, informando nosso nome e
e-mail. Em um terminal, execute os comandos a seguir:

```
$ git config --global user.name "Fulano da Silva"
$ git config --global user.email fulanodasilva.git@gmail.com
```

Claro, utilize **seu nome e e-mail**!

> **A linha de comando**
>
> A maneira mais comum de usar Git é pela linha de comando, acessível
> através de um terminal. É o jeito que a maior parte dos bons
> profissionais do mercado utiliza o Git e será nossa escolha nesse livro.

<!-- comentario para separar quotes adjacentes -->


> **GitHub for Windows**
>
> A maioria dos usuários do Windows não tem o hábito de utilizar
> o prompt de comandos, e perfere instalar alguma aplicação visual
> para trabalhar com o Git.
>
> Uma destas aplicações é o **GitHub for Windows**, e mostraremos
> como utilizá-la no capítulo .

<!-- comentario para separar quotes adjacentes -->


## Criando um arquivo texto para versionarmos
Antes de utilizarmos o Git, vamos criar na sua **pasta pessoal**, um
diretório chamado `citacoes` com um arquivo `filmes.txt`.

Dentro do arquivo `filmes.txt`, coloque o seguinte conteúdo:

```
"Não há certezas, apenas oportunidades." (V de Vingança)
"Diga 'olá' para meu pequeno amigo!" (Scarface)
```

> **Pasta pessoal**
>
> A pasta pessoal (_ou home directory_, em inglês) é o local dos arquivos
> de usuário como documentos, fotos, músicas etc.
>
> Se você não souber onde é a pasta pessoal, digite o seguinte comando em
> um terminal:
>
> ```
> 	$ echo ~
> ```
>
> No Windows Vista, 7 ou 8, será algo como `C:\Users\Fulano\` ou, no Git
> Bash, `/c/Users/Fulano/`.
>
> No Windows 2000, XP ou 2003, será algo como `C:\Documents and
> Settings\Fulano\` ou, no Git Bash, `/c/Documents and Settings/Fulano`.
>
> No Linux, será `/home/fulano` e no Mac OS X `/Users/Fulano`.

<!-- comentario para separar quotes adjacentes -->
