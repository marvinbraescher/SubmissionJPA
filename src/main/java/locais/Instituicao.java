
package locais ;

import java.io.Serializable ;
import javax.persistence.* ;

/**
 * Entity implementation class for Entity: Instituicao
 *
 */
@ Entity
@Table(name = "instituicao")
public class Instituicao implements Serializable {
	
	private static final long serialVersionUID = 1L ;
	
	@ Id
	@ Column ( name = "idinstituicao" , nullable = false )
	@ GeneratedValue ( strategy = GenerationType.IDENTITY )
	private Long id ;
	
    @Column(name = "endereco", nullable = false)
    private String endereco;
    
    @ Override
	public String toString()
	{
		return "Instituicao [id=" + id + ", endereco=" + endereco + ", nome=" + nome + "]" ;
	}

	@Column(name = "nome", nullable = false)
    private String nome;
	
	public Long getId()
	{
		return id ;
	}
	
	public void setId( Long id )
	{
		this.id = id ;
	}
	
	public Instituicao()
	{
		super() ;
	}
	
	
	
	public String getEndereco()
	{
		return endereco ;
	}

	
	public void setEndereco( String endereco )
	{
		this.endereco = endereco ;
	}

	
	public String getNome()
	{
		return nome ;
	}

	
	public void setNome( String nome )
	{
		this.nome = nome ;
	}

	public Instituicao( String nome, String endereco )
	{
		super() ;
		this.nome = nome;
		this.endereco = endereco;
	}
	
}
