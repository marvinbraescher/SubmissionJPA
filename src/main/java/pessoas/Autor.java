
package pessoas ;

import java.io.Serializable ;
import java.util.ArrayList ;
import java.util.List ;

import javax.persistence.* ;

/**
 * Entity implementation class for Entity: Autor
 *
 */
@ Entity
@Table(name = "autor")
public class Autor implements Serializable {
	
	private static final long serialVersionUID = 1L ;
	
	@ Id
	@Column(name = "idautor", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	

	@ElementCollection
    @CollectionTable( name="autor_emails" )
    private List<String> emails;
    
    @Column(name = "nome", nullable = false)
    private String nome;
	
	
	public List < String > getEmails()
	{
		return emails ;
	}

	
	public void setEmails( List < String > emails )
	{
		this.emails = emails ;
	}

	
	public String getNome()
	{
		return nome ;
	}

	
	public void setNome( String nome )
	{
		this.nome = nome ;
	}

	@ Override
	public String toString()
	{
		return "Autor [id=" + id + ", emails=" + emails + ", nome=" + nome + "]" ;
	}

	public Long getId()
	{
		return id ;
	}
	
	public void setId( Long id )
	{
		this.id = id ;
	}
	
	public Autor()
	{
		super() ;
	}
	public Autor(String nome, ArrayList<String> emails)
	{
		super() ;
		this.nome = nome;
		this.emails = emails;
	
	}
}
