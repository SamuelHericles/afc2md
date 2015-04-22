
_"Computadores são inúteis, eles apenas dão respostas" -- Picasso_

## Compilando o primeiro programa

Vamos para o nosso primeiro código! O programa que imprime uma linha simples.

Para mostrar uma linha, podemos fazer:

``` java
	System.out.println("Minha primeira aplicação Java!");
```

Mas esse código não será aceito pelo  compilador java. O Java é uma linguagem
bastante burocrática, e precisa de mais do que isso para iniciar uma execução.
Veremos os detalhes e os porquês durante os próximos capítulos. O mínimo que
precisaríamos escrever é algo como:

``` java
	class MeuPrograma {
		public static void main(String[] args) {
			System.out.println("Minha primeira aplicação Java!");
		}
	}
```

> **Notação**
Todos os códigos apresentados na apostila estão formatados com recursos visuais para auxiliar a
leitura e compreensão dos mesmos. Quando for digitar os códigos no computador, trate os códigos
como texto simples.


Após digitar o código acima, grave-o como **MeuPrograma.java** em algum diretório. Para compilar, você
deve pedir para que o compilador de Java da Oracle, chamado `javac`, gere o bytecode correspondente ao
seu código Java.

![ {w=80%}](images/oqueejava/compilando.png)

## Para saber mais: como é o bytecode?

O `MeuPrograma.class` gerado não é legível por seres humanos (não que seja impossível). Ele está
escrito no formato que a virtual machine sabe entender e que foi especificado que ela entendesse.

É como um assembly, escrito para esta máquina em específico. Podemos ler os mnemônicos utilizando
a ferramenta javap que acompanha o JDK:

```javap -c MeuPrograma```

E a saída:

```
	MeuPrograma();
	  Code:
	   0:   aload_0
	   1:   invokespecial   #1; //Method java/lang/Object."<init>":()V
	   4:   return
	
	public static void main(java.lang.String[]);
		Code:
		0:	getstatic	#2; //Field java/lang/System.out:Ljava/io/PrintStream;
		3:   ldc     #3; //String Minha primeira aplicação Java!!
		5:   invokevirtual   #4; //Method java/io/PrintStream.println:
									(Ljava/lang/String;)V
		8:   return
	
	}
```

É o código acima, que a JVM sabe ler. É o "código de máquina", da máquina virtual.
