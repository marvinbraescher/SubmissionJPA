

import java.util.ArrayList ;
import java.util.Date ;
import java.util.List ;

import contatos.Telefone ;
import daos.* ;
import daos.DaoSubmissao ;
import daos.DaoTelefone ;
import pessoas.Autor ;
import submissoes.Artigo ;
import submissoes.Curso ;
import submissoes.Submissao ;

public class Main {
	
	public static void main( String[] args )
	{
		DaoArtigo dao = new DaoArtigo();

		Artigo obj = new Artigo( "Objetivo", "material");
		
		if(dao.salvar( obj ))
		{
			System.out.println( "sucesso" ) ;
		}else
		{
			System.out.println( "fracasso" ) ;
		}

		
		
	}
	
}
