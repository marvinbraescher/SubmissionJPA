

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
	
	//Prof eu tenho 1 falta a mais não são duas!! Adorei aprender JPA e JDBC contigo! ❤️❤️❤️❤️❤️❤️❤️❤️❤️ XOXO
	
	//DIAGRAMA IMPLEMENTADO POR MARVIN MATHEUS BRAESCHER
	
	//REMOVER está comentado para aparecer os dados no banco
	
	public static void main( String[] args )
	{
		//ARTIGO TESTE DAO
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
		
		//SALVA ARTIGO
		if(dao.salvar( artigo ))
		{
			System.out.println( "salvou ARTIGO" ) ;
		}else
		{
			System.out.println( "fracasso ARTIGO" ) ;
		}
		
		//BUSCA ARTIGO POR ID
		System.out.println("BUSCAR ARTIGO POR ID: "+ dao.buscarID( artigo.getId() ) ) ;
		
		//ATUALIZAR ARTIGO
		artigo.setAbstract1( "atualizeiiiiii" );
		
		if(dao.atualizar( artigo ))
		{
			System.out.println( "ATUALIZOU ARTIGO" ) ;
		}else
		{
			System.out.println( "ATUALIZACAO DO ARTIGO: fracasso" ) ;
		}
		
		//BUSCA TODOS ARTIGOS
		List<Artigo>artigos = dao.buscarTodos();
		for ( Artigo artigo1 : artigos )
		{
			System.out.println("BUSCAR TODOS ARTIGOS: "+ artigo1.toString() ) ;
		}
//				
//		//REMOVE ARTIGO POR ID
//		if(dao.remover( artigo.getId() ))
//		{
//			System.out.println( "REMOVEU ARTIGO" ) ;
//		}else
//		{
//			System.out.println( "REMOÇAO DO ARTIGO: fracasso" ) ;
//		}
		
		//TESTE CURSO DAO
		ArrayList<String> emails2 = new ArrayList<String>();
		List<Autor> autores2 = new ArrayList<Autor>();
		Curso curso = new Curso();
		Autor autor2 = new Autor("marvin", emails);
		emails2.add( "xx" );
		emails2.add( "xxx.xxx" );
		emails2.add( "xxxxxx" );
		Instituicao instituicao2 = new Instituicao("kkk","afkljasjkfjka");
		autor2.setInstituicao( instituicao2 );
		autor2.setTelefone( new Telefone(5151L, 1244242) );
		
		autores2.add( autor2 );
		instituicao.setAutores( autores2 );
		curso.setData( new Date() );
		curso.setDuracao( 10.0 );
		curso.setJustificativa( "justificativa?????" );
		curso.setObjetivo( "quero morrer" );
		curso.setMaterial( "arma de corte" );
		curso.setAutores( autores2 );		
		curso.setSituacao( Situacao.ACEITA );
		
		DaoCurso daoCurso = new DaoCurso();
		//SALVA CURSO
		if(daoCurso.salvar( curso ))
		{
			System.out.println( "SALVOU CURSO" ) ;
		}else
		{
			System.out.println( "fracasso" ) ;
		}
		//BUSCA POR ID DO CURSO
		System.out.println("BUSCAR CURSO POR ID: "+ daoCurso.buscarID( curso.getId() ) ) ;
		
		//ATUALIZAR CURSO
		curso.setJustificativa( "ATUALIZEIIII" );
		
		if(daoCurso.atualizar( curso ))
		{
			System.out.println( "ATUALIZOU CURSO" ) ;
		}else
		{
			System.out.println( "ATUALIZACAO DO CURSO: fracasso" ) ;
		}
		
		//BUSCA TODOS CURSOS
		List<Curso>cursos = daoCurso.buscarTodos();
		for ( Curso curso1 : cursos )
		{
			System.out.println("BUSCAR TODOS CURSOS: "+ curso1.toString() ) ;
		}
		
//		//REMOVE CURSO POR ID
//		if(daoCurso.remover( curso.getId() ))
//		{
//			System.out.println( "REMOVEU CURSO" ) ;
//		}else
//		{
//			System.out.println( "REMOÇAO DO CURSO: fracasso" ) ;
//		}
		
		//TESTA AUTOR DAO		
		ArrayList<String> emails3 = new ArrayList<String>();
		emails3.add( "123123@123123.com" );
		emails3.add( "33333@3333.com" );
		emails3.add( "444444@44444.com" );
		Autor autor3 = new Autor("silvia", emails3);
		Instituicao instituicao3 = new Instituicao("INSTITUTO FEDERAL DO RIO GRANDE DO SUL","POA CENTRO");
		autor3.setInstituicao( instituicao3 );
		autor3.setTelefone( new Telefone(51L, 00000000) );
		
		DaoAutor daoAutor = new DaoAutor();
		
		//SALVA AUTOR
		if(daoAutor.salvar( autor3 ))
		{
			System.out.println( "SALVOU AUTOR" ) ;
		}else
		{
			System.out.println( "fracasso" ) ;
		}
		
		//BUSCA PELO ID DO AUTOR
		System.out.println("BUSCAR AUTOR POR ID: "+ daoAutor.buscarID( autor3.getId() ) ) ;
		
		//ATUALIZAR AUTOR
		autor3.setNome( "ATUALIZEI" );
		
		if(daoAutor.atualizar( autor3 ))
		{
			System.out.println( "ATUALIZOU AUTOR" ) ;
		}else
		{
			System.out.println( "ATUALIZACAO DO AUTOR: fracasso" ) ;
		}
		
		//BUSCA TODOS PELO ID DO AUTOR
		List<Autor>autores3= daoAutor.buscarTodos();
		for ( Autor autor33 : autores3 )
		{
			System.out.println("BUSCAR TODOS AUTORES: "+ autor33.toString() ) ;
		}
		
//		//REMOVE AUTOR PELO ID
//		if(daoAutor.remover( autor3.getId() ))
//		{
//			System.out.println( "REMOVEU CURSO" ) ;
//		}else
//		{
//			System.out.println( "REMOÇAO DO CURSO: fracasso" ) ;
//		}
		
	}
	
}
