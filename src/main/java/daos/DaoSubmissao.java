
package daos ;

import java.util.List ;

import javax.persistence.EntityManager ;
import javax.persistence.TypedQuery ;

import jpautil.JPAUtil ;
import submissoes.Submissao ;

public class DaoSubmissao {
	
	EntityManager em;
	
	public boolean salvar( Submissao sumissao )
	{
		try
		{
			
			em = JPAUtil.getEntityManager() ;
			em.getTransaction().begin() ;
			em.persist( sumissao ) ;
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
	
	public boolean atualizar( Submissao submissao )
	{
		try
		{
			em = JPAUtil.getEntityManager() ;
			em.getTransaction().begin() ;
			em.merge( submissao ) ;
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
	
	public Submissao buscarID( int id )
	{
		try
		{
			em = JPAUtil.getEntityManager() ;
			Submissao usuario = em.find( Submissao.class , id ) ;
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
			Submissao entity = em.find( Submissao.class , id ) ;
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
	
	public List < Submissao > buscarTodos()
	{
		try
		{
			em = JPAUtil.getEntityManager() ;
			TypedQuery < Submissao > query = em.createQuery( "SELECT obj FROM Submissao obj" , Submissao.class ) ;
			List < Submissao > usuarios = query.getResultList() ;
			return usuarios ;
		} catch ( RuntimeException e )
		{
			return null ;
		}
	}
	
}
