
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
// Utilizando a estratégia JOINED para promover uma estrutura mais normalizada dos dados.
@Inheritance (strategy = InheritanceType.JOINED)
public class Submissao implements Serializable {
	private static final long serialVersionUID = 1L ;
	
	// Utilizando a estratégia de geração de identidade (identity)
	//devido ao uso do MySQL, permitindo uma atribuição automática e
	// incremental de valores para a chave primária "idsubmissao".
	@Id
	@Column(name = "idsubmissao", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	//anotação Enumerated com EnumType.STRING é utilizada para mapear a propriedade "Situacao" como uma coluna ENUM no banco de dados.
	@Enumerated( EnumType.STRING )
	private util.Situacao Situacao;

	@Column(name = "titulo")
	private String titulo;
	
	//A anotação Temporal com TemporalType.DATE é utilizada para mapear a propriedade "data" como uma data no banco de dados.
    @Temporal( TemporalType.DATE )
    @Column(name = "data")
	private Date data;
    
    //Optei por não utilizar a estratégia MERGE nesta configuração, pois ela poderia resultar na criação
    //de uma nova submissão no banco de dados durante operações de atualização (merge). Ao invés disso,
    //escolhi as estratégias PERSIST e REMOVE para controlar explicitamente a persistência e remoção
    //das entidades relacionadas (autores) ao lidar com operações de persistência na entidade principal (submissão)
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
	
	public util.Situacao getSituacao()
	{
		return Situacao ;
	}

	public void setSituacao( util.Situacao situacao )
	{
		Situacao = situacao ;
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
