
package daos ;

import java.util.List ;

import javax.persistence.EntityManager ;
import javax.persistence.TypedQuery ;

import contatos.Telefone ;
import jpautil.JPAUtil ;


public class DaoTelefone {
	
	EntityManager em ;
	
	public boolean salvar( Telefone telefone )
	{
		try
		{
			em = JPAUtil.getEntityManager() ;
			em.getTransaction().begin() ;
			em.persist( telefone ) ;
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
	
	public boolean atualizar( Telefone telefone )
	{
		try
		{
			em = JPAUtil.getEntityManager() ;
			em.getTransaction().begin() ;
			em.merge( telefone ) ;
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
	
	public Telefone buscarID( int id )
	{
		try
		{
			em = JPAUtil.getEntityManager() ;
			Telefone usuario = em.find( Telefone.class , id ) ;
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
			Telefone entity = em.find( Telefone.class , id ) ;
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
	
	public List < Telefone > buscarTodos()
	{
		try
		{
			em = JPAUtil.getEntityManager() ;
			TypedQuery < Telefone > query = em.createQuery( "SELECT obj FROM telefone obj" , Telefone.class ) ;
			List < Telefone > telefones = query.getResultList() ;
			return telefones ;
		} catch ( RuntimeException e )
		{
			return null ;
		}
	}
	
}
