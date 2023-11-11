
package daos ;

import java.util.List ;

import javax.persistence.EntityManager ;
import javax.persistence.TypedQuery ;

import jpautil.JPAUtil ;
import pessoas.Autor ;


public class DaoAutor {
	
	EntityManager em;
	
	public boolean salvar( Autor autor )
	{
		try
		{
			em = JPAUtil.getEntityManager() ;
			em.getTransaction().begin() ;
			em.persist( autor ) ;
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
	
	public boolean atualizar( Autor autor )
	{
		try
		{
			em = JPAUtil.getEntityManager() ;
			em.getTransaction().begin() ;
			em.merge( autor ) ;
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
	
	public Autor buscarID( int id )
	{
		try
		{
			em = JPAUtil.getEntityManager() ;
			Autor usuario = em.find( Autor.class , id ) ;
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
			Autor entity = em.find( Autor.class , id ) ;
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
	
	public List < Autor > buscarTodos()
	{
		try
		{
			em = JPAUtil.getEntityManager() ;
			TypedQuery < Autor > query = em.createQuery( "SELECT obj FROM autor obj" , Autor.class ) ;
			List < Autor > autores = query.getResultList() ;
			return autores ;
		} catch ( RuntimeException e )
		{
			return null ;
		}
	}
	
}
