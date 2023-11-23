
package locais ;

import java.io.Serializable ;
import java.util.List ;

import javax.persistence.* ;

import pessoas.Autor ;

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
    
    @OneToMany (mappedBy = "instituicao", cascade ={ CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name="idautor")
    private List< Autor > autores;

    @Column(name = "nome", nullable = false)
    private String nome;
    

    @ Override
	public String toString()
	{
		return "Instituicao [id=" + id + ", endereco=" + endereco + ", autores=" + autores + ", nome=" + nome + "]" ;
	}

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
	
	public List < Autor > getAutores()
	{
		return autores ;
	}
	
	
	public void setAutores( List < Autor > autores )
	{
		this.autores = autores ;
	}
}
