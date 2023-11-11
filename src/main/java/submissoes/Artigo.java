
package submissoes ;

import java.io.Serializable ;
import javax.persistence.* ;

/**
 * Entity implementation class for Entity: Artigo
 *
 */
@ Entity
@ Table ( name = "artigo" )
public class Artigo implements Serializable {
	
	private static final long serialVersionUID = 1L ;
	
	@ Id
	@ Column ( name = "idartigo" , nullable = false )
	@ GeneratedValue ( strategy = GenerationType.IDENTITY )
	private Long id ;
	
	@ Column ( name = "resumo" , nullable = false )
	private String resumo ;
	
	@ Column ( name = "abstract" , nullable = false )
	private String abstract1 ;
	
	public Long getId()
	{
		return id ;
	}
	
	public void setId( Long id )
	{
		this.id = id ;
	}
	
	
	public String getResumo()
	{
		return resumo ;
	}

	
	public void setResumo( String resumo )
	{
		this.resumo = resumo ;
	}

	
	public String getAbstract1()
	{
		return abstract1 ;
	}

	
	public void setAbstract1( String abstract1 )
	{
		this.abstract1 = abstract1 ;
	}

	@ Override
	public String toString()
	{
		return "Artigo [id=" + id + ", resumo=" + resumo + ", abstract1=" + abstract1 + "]" ;
	}

	public Artigo()
	{
		super() ;
	}
	
	public Artigo( String resumo , String abstract1 )
	{
		super();
		this.abstract1 = abstract1;
		this.resumo = resumo;
	}
	
}
