
_"Computadores são inúteis, eles apenas dão respostas" -- Picasso_

## Para saber mais: como é o bytecode?

O `MeuPrograma.class` gerado não é legível por seres humanos (não que seja impossível).

Podemos ler os mnemônicos utilizando a ferramenta javap que acompanha o JDK:

```javap -c MeuPrograma```

É o código acima, que a JVM sabe ler. É o "código de máquina", da máquina virtual.

## Exercícios: Modificando o Hello World


1. Altere seu programa para imprimir uma mensagem diferente.

1. Altere seu programa para imprimir duas linhas de texto usando duas linhas de código System.out.

1. Sabendo que os caracteres `\n` representam uma quebra de linhas, imprima duas linhas de texto
usando uma única linha de código `System.out`.

