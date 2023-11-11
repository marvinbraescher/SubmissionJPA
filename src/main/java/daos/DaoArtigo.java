package daos;

import java.util.List ;

import javax.persistence.EntityManager ;
import javax.persistence.TypedQuery ;

import jpautil.JPAUtil ;
import submissoes.Artigo ;

public class DaoArtigo {
	
	EntityManager em;
	
	public boolean salvar( Artigo artigo )
	{
		try
		{
			em = JPAUtil.getEntityManager() ;
			em.getTransaction().begin() ;
			em.persist( artigo ) ;
			em.getTransaction().commit() ;

			return true ;
		} catch ( RuntimeException e )
		{
			if ( em.getTransaction().isActive() )
			{
				em.getTransaction().rollback() ;
			}
			return false ;
		}
	}
	
	public boolean atualizar( Artigo artigo )
	{
		try
		{
			em = JPAUtil.getEntityManager() ;
			em.getTransaction().begin() ;
			em.merge( artigo ) ;
			em.getTransaction().commit() ;
			return true ;
		} catch ( RuntimeException e )
		{
			if ( em.getTransaction().isActive() )
			{
				em.getTransaction().rollback() ;
			}
			return false ;
		}
	}
	
	public Artigo buscarID( int id )
	{
		try
		{
			em = JPAUtil.getEntityManager() ;
			Artigo usuario = em.find( Artigo.class , id ) ;
			return usuario ;
		} catch ( RuntimeException e )
		{
			if ( em.getTransaction().isActive() )
			{
				em.getTransaction().rollback() ;
			}
			return null ;
		}
	}
	
	public boolean remover( long id )
	{
		try
		{
			em = JPAUtil.getEntityManager() ;
			em.getTransaction().begin() ;
			Artigo entity = em.find( Artigo.class , id ) ;
			em.remove( entity ) ;
			em.getTransaction().commit() ;
			return true ;
		} catch ( RuntimeException e )
		{
			if ( em.getTransaction().isActive() )
			{
				em.getTransaction().rollback() ;
			}
			return false ;
		}
	}
	
	public List < Artigo > buscarTodos()
	{
		try
		{
			em = JPAUtil.getEntityManager() ;
			TypedQuery < Artigo > query = em.createQuery( "SELECT obj FROM artigo obj" , Artigo.class ) ;
			List < Artigo > artigos = query.getResultList() ;
			return artigos ;
		} catch ( RuntimeException e )
		{
			return null ;
		}
	}
}
