
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
	
	// Utilizando a estratégia de geração de identidade (identity)
	//devido ao uso do MySQL, permitindo uma atribuição automática e
	// incremental de valores para a chave primária "idsubmissao".
	@Id
	@Column(name = "idautor", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	//Mantive 1 pra 1 pois no enunciado pedia. Poderia ser um oneToMany unidirecional também
	//Utilizei persist merge e remove pois não faz sentido salvar o telefone de um autor que foi excluido merge utilizei.
	@OneToOne (cascade = {CascadeType.PERSIST,CascadeType.MERGE,
			CascadeType.REMOVE})
	@JoinColumn (name="idtelefone")
	private Telefone telefone;
	
	// A anotação @ManyToOne, com a opção cascade para PERSIST, MERGE e REMOVE,
	// é utilizada para mapear a relação muitos-para-um entre a entidade atual e a entidade relacionada (Instituicao),
	// atualizando a instituição sempre que uma operação de salvar, atualizar ou remover for realizada.
	@ManyToOne( cascade ={ CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE} )
	@JoinColumn(name="idinstituicao")
	private Instituicao instituicao;
	
	// Utiliza a anotação @ElementCollection para mapear uma coleção de elementos simples (List<String>)
	// como uma tabela separada no banco de dados.
	@ElementCollection
	@CollectionTable( name="autor_emails" )
	private List<String> emails;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	// Mapeia a relação muitos-para-muitos entre a entidade atual (Autor) e
	// a entidade relacionada (Submissao), utilizando a propriedade "autores" na entidade Submissao
	// como o lado proprietário da relação.
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
	public Long getId()
	{
		return id ;
	}

	
	public void setId( Long id )
	{
		this.id = id ;
	}

	
	public List < Submissao > getSubmissoes()
	{
		return submissoes ;
	}

	
	public void setSubmissoes( List < Submissao > submissoes )
	{
		this.submissoes = submissoes ;
	}
}
