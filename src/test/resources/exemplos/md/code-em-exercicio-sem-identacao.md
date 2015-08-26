# Relacionamento bidirecional e Lazyness

## Exercício: Criando um relacionamento Muitos-Para-Muitos
1. Agora vamos alterar a classe `Movimentacao` adicionando o atributo
	`categorias` do tipo `List<Categoria>`. Para que possamos indicar
	que este atributo representa um relacionamento de **muitos para muitos**
	com a classe `Categoria` vamos também adicionar a anotação
	`@ManyToMany`.

	``` java
	@Entity
	public class Movimentacao {
	    //outros atributos...

	    @ManyToMany
	    private List<Categoria> categorias = new ArrayList<Categoria>();

	}
	```

	Não esqueça dos getters e setters do novo atributo.
1. Reinicie o WildFly. Após subir, o banco de dados deve ser atualizado.
	(Caso precise, faça um _Full Publish_ do projeto
	`fj25-financas-web`)

	Acesse o MySQL para verificar o resultado. As tabelas `Categoria` e
	`Movimentacao_Categoria` devem ter sido criadas.
1. Antes de cadastrar as categorias associadas a cada movimentação,
	é preciso preparar os dados para a tela. Precisamos listar
	todas as categorias e buscar uma categoria pelo id.
	Para isolar essa operação, vamos criar um _DAO_ para a categoria.
	No pacote `br.com.caelum.financas.dao` crie a classe
	`CategoriaDao`, use a anotação `@Stateless` para indicar um
	Session Bean e injete o `EntityManager` com a anotação
	`@PersistenceContext`:

	``` java
	package br.com.caelum.financas.dao;

	@Stateless
	public class CategoriaDao implements Serializable {

	    @PersistenceContext
	    private EntityManager manager;

	    public Categoria procura(Integer id) {
	        //busca pela id
	    }

	    public List<Categoria> lista() {
	        //retorna todas as categorias
	    }

	}
	```
