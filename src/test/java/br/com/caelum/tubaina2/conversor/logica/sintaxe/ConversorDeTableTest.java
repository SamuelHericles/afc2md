package br.com.caelum.tubaina2.conversor.logica.sintaxe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConversorDeTableTest {

	private ConversorDeSintaxe conversor;

	@Before
	public void setUp() {
		conversor = new ConversorDeTable();
	}
	
	@Test
	public void tableComDuasColunas() {
		String tabela = "[table]\n"+
						"	[row]\n"+
						"		[col]**JPA**[/col]\n"+
						"		[col]**Hibernate**[/col]\n"+
						"	[/row]\n"+
						"	[row]\n"+
						"		[col]`persist`[/col]\n"+
						"		[col]`save`[/col]\n"+
						"	[/row]\n"+
						"	[row]\n"+
						"		[col]`merge`[/col]\n"+
						"		[col]`update`[/col]\n"+
						"	[/row]\n"+
						"	[row]\n"+
						"		[col]`remove`[/col]\n"+
						"		[col]`delete`[/col]\n"+
						"	[/row]\n"+
						"	[row]\n"+
						"		[col]`getReference`[/col]\n"+
						"		[col]`load`[/col]\n"+
						"	[/row]\n"+
						"	[row]\n"+
						"		[col]`find`[/col]\n"+
						"		[col]`get`[/col]\n"+
						"	[/row]\n"+
						"	[row]\n"+
						"		[col]`refresh`[/col]\n"+
						"		[col]`refresh`[/col]\n"+
						"	[/row]\n"+
						"[/table]\n";

		
		String convertido = conversor.converte(tabela);

		String esperado =   "\n|**JPA**|**Hibernate**|\n"+
							"|-|\n"+
							"|`persist`|`save`|\n"+
							"|`merge`|`update`|\n"+
							"|`remove`|`delete`|\n"+
							"|`getReference`|`load`|\n"+
							"|`find`|`get`|\n"+
							"|`refresh`|`refresh`|\n\n";
		
		Assert.assertEquals(esperado, convertido);
	}


}
