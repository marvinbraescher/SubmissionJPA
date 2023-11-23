
package pessoas ;

import java.io.Serializable ;
import java.util.ArrayList ;
import java.util.List ;

import javax.persistence.* ;

import contatos.Telefone ;
import locais.Instituicao ;
import submissoes.Submissao ;

/**
 * Entity implementation class for Entity: Autor
 *
 */
@Entity
@Table(name = "autor")
public class Autor implements Serializable {
	
	private static final long serialVersionUID = 1L ;
	
	@Id
	@Column(name = "idautor", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	@OneToOne (cascade = {CascadeType.PERSIST,CascadeType.MERGE,
			CascadeType.REMOVE})
	@JoinColumn (name="idtelefone")
	private Telefone telefone;
	
	@ManyToOne( cascade ={ CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE} )
	@JoinColumn(name="idinstituicao")
	private Instituicao instituicao;
	
	@ElementCollection
	@CollectionTable( name="autor_emails" )
	private List<String> emails;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	
	@ManyToMany (mappedBy="autores")
	private List<Submissao> submissoes;

	public Telefone getTelefone()
	{
		return telefone ;
	}

	public void setTelefone( Telefone telefone )
	{
		this.telefone = telefone ;
	}


	
	public Instituicao getInstituicao()
	{
		return instituicao ;
	}

	public void setInstituicao( Instituicao instituicao )
	{
		this.instituicao = instituicao ;
	}
	
	
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
		return "Autor [ telefone=" + telefone + ", instituicao=" + instituicao + ", emails=" + emails
				+ ", nome=" + nome + "]" ;
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
