
package submissoes ;

import java.io.Serializable ;
import javax.persistence.* ;

/**
 * Entity implementation class for Entity: Artigo
 *
 */
@ Entity
@ Table ( name = "artigo" )
@PrimaryKeyJoinColumn(name = "idartigo", referencedColumnName =
"idsubmissao")
public class Artigo extends Submissao implements Serializable {
	
	private static final long serialVersionUID = 1L ;
	
	@ Column ( name = "resumo" , nullable = false )
	private String resumo ;
	
	@ Column ( name = "abstract" , nullable = false )
	private String abstract1 ;
	
	
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
		return "Artigo [resumo=" + resumo + ", abstract1=" + abstract1 + "]" ;
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
