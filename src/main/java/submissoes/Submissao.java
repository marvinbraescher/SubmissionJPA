
package submissoes ;

import java.io.Serializable ;
import java.util.Date ;

import javax.persistence.* ;

/**
 * Entity implementation class for Entity: Submissao
 *
 */
@Entity
@Table(name="submissao")
public class Submissao implements Serializable {
	
//a

	private static final long serialVersionUID = 1L ;
	
	@Id
	@Column(name = "idsubmissao", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
    @Column(name = "titulo", nullable = false)
	private String titulo;
	
    @Temporal( TemporalType.DATE )
    @Column(name = "data", nullable = false)
	private Date data;

	
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
	
	@ Override
	public String toString()
	{
		return "Submissao [id=" + id + ", titulo=" + titulo + ", data=" + data + "]" ;
	}

}
