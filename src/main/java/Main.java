

import java.util.ArrayList ;
import java.util.Date ;
import java.util.List ;

import contatos.Telefone ;
import daos.* ;
import daos.DaoSubmissao ;
import daos.DaoTelefone ;
import locais.Instituicao ;
import pessoas.Autor ;
import submissoes.Artigo ;
import submissoes.Curso ;
import submissoes.Submissao ;
import util.Situacao ;

public class Main {
	
	public static void main( String[] args )
	{
		
		ArrayList<String> emails = new ArrayList<String>();
		List<Autor> autores = new ArrayList<Autor>();
		Artigo artigo = new Artigo();
		Autor obj = new Autor("marvin", emails);
		emails.add( "xx" );
		emails.add( "xxx.xxx" );
		emails.add( "xxxxxx" );
		Instituicao instituicao = new Instituicao("kkk","afkljasjkfjka");
		obj.setInstituicao( instituicao );
		obj.setTelefone( new Telefone(5151L, 1244242) );
		
		autores.add( obj );
		instituicao.setAutores( autores );
		artigo.setData( new Date() );
		artigo.setAbstract1( "asjfdasljkfklas" );
		artigo.setAutores( autores );		
		artigo.setTitulo( "titulo" );
		artigo.setResumo( "blablabal" );
		artigo.setSituacao( Situacao.ACEITA );
		DaoArtigo dao = new DaoArtigo();
		if(dao.salvar( artigo ))
		{
			System.out.println( "sucesso" ) ;
		}else
		{
			System.out.println( "fracasso" ) ;
		}

		
		
	}
	
}
