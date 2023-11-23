package daos;

import java.util.List ;

import javax.persistence.EntityManager ;
import javax.persistence.TypedQuery ;

import submissoes.Curso ;
import jpautil.JPAUtil ;

public class DaoCurso {
	
EntityManager em ;
	
	public boolean salvar( Curso curso )
	{
		try
		{
			em = JPAUtil.getEntityManager() ;
			em.getTransaction().begin() ;
			em.persist( curso ) ;
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
	
	public boolean atualizar( Curso curso )
	{
		try
		{
			em = JPAUtil.getEntityManager() ;
			em.getTransaction().begin() ;
			em.merge( curso ) ;
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
	
	public Curso buscarID( long id )
	{
		try
		{
			em = JPAUtil.getEntityManager() ;
			Curso curso = em.find( Curso.class , id ) ;
			return curso ;
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
			Curso entity = em.find( Curso.class , id ) ;
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
	
	public List < Curso > buscarTodos()
	{
		try
		{
			em = JPAUtil.getEntityManager() ;
			TypedQuery < Curso > query = em.createQuery( "SELECT obj FROM Curso obj" , Curso.class ) ;
			List < Curso > cursos = query.getResultList() ;
			return cursos ;
		} catch ( RuntimeException e )
		{
			return null ;
		}
	}
}
