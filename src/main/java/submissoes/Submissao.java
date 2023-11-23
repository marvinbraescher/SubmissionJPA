
package submissoes ;

import java.io.Serializable ;
import java.util.Date ;
import java.util.List ;

import javax.persistence.* ;

import pessoas.Autor ;

/**
 * Entity implementation class for Entity: Submissao
 * @param <Situacao>
 *
 */
@Entity
@Inheritance (strategy = InheritanceType.JOINED)
public class Submissao implements Serializable {
	
	
	public util.Situacao getSituacao()
	{
		return Situacao ;
	}

	
	public void setSituacao( util.Situacao situacao )
	{
		Situacao = situacao ;
	}

	private static final long serialVersionUID = 1L ;
	
	@Id
	@Column(name = "idsubmissao", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	@Enumerated( EnumType.STRING )
	private util.Situacao Situacao;

	@Column(name = "titulo")
	private String titulo;
	
    @Temporal( TemporalType.DATE )
    @Column(name = "data")
	private Date data;
    
    //Não utilizei MERGE por que ele cria uma outra submissao no banco
    @ManyToMany (cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinTable( name="sub_rel_autor",
    joinColumns={ @JoinColumn(name="idsubmissao")},
    inverseJoinColumns={@JoinColumn(name="idautor")})
    private List<Autor> autores;

	public Long getId()
	{
		return id ;
	}

	public void setId( Long id )
	{
		this.id = id ;
	}
	
	public Submissao()
	{
		super() ;
	}
	
	public Submissao(String titulo, Date data)
	{
		super() ;
		this.titulo = titulo;
		this.data = data;
	}

	
	public String getTitulo()
	{
		return titulo ;
	}

	
	public void setTitulo( String titulo )
	{
		this.titulo = titulo ;
	}

	
	public Date getData()
	{
		return data ;
	}

	public void setData( Date data )
	{
		this.data = data ;
	}
	public List < Autor > getAutores()
	{
		return autores ;
	}
	
	
	public void setAutores( List < Autor > autores )
	{
		this.autores = autores ;
	}
	
	@ Override
	public String toString()
	{
		return "Submissao [id=" + id + ", titulo=" + titulo + ", data=" + data + ", autores=" + autores + "]" ;
	}

}
