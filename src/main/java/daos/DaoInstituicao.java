
package daos ;

import java.util.List ;

import javax.persistence.EntityManager ;
import javax.persistence.TypedQuery ;

import jpautil.JPAUtil ;
import locais.Instituicao ;

public class DaoInstituicao {
	
	EntityManager em ;
	
	public boolean salvar( Instituicao instituicao )
	{
		try
		{
			em = JPAUtil.getEntityManager() ;
			em.getTransaction().begin() ;
			em.persist( instituicao ) ;
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
	
	public boolean atualizar( Instituicao instituicao )
	{
		try
		{
			em = JPAUtil.getEntityManager() ;
			em.getTransaction().begin() ;
			em.merge( instituicao ) ;
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
	
	public Instituicao buscarID( int id )
	{
		try
		{
			em = JPAUtil.getEntityManager() ;
			Instituicao usuario = em.find( Instituicao.class , id ) ;
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
			Instituicao entity = em.find( Instituicao.class , id ) ;
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
	
	public List < Instituicao > buscarTodos()
	{
		try
		{
			em = JPAUtil.getEntityManager() ;
			TypedQuery < Instituicao > query = em.createQuery( "SELECT obj FROM instituicao obj" , Instituicao.class ) ;
			List < Instituicao > autores = query.getResultList() ;
			return autores ;
		} catch ( RuntimeException e )
		{
			return null ;
		}
	}
	
}
