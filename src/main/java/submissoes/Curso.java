package submissoes;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Curso
 *
 */
@Entity
@Table(name="curso")
//A anotação PrimaryKeyJoinColumn, em conjunto com a estratégia JOINED,
//é utilizada para mapear a coluna "idcurso" como chave primária e estrangeira referenciando a coluna "idsubmissao"
//na tabela correspondente, promovendo uma estrutura mais normalizada dos dados.
@PrimaryKeyJoinColumn(name = "idcurso", referencedColumnName =
"idsubmissao")
public class Curso extends Submissao implements Serializable {

	// Ausência da anotação @Id devido à herança do
	//tipo JOINED, onde a chave primária é tratada nas tabelas 
	//específicas para cada subclasse.

	private static final long serialVersionUID = 1L;

    @Column(name = "justificativa", nullable = false)
	private String justificativa;
    
    @Column(name = "material", nullable = false)
	private String material;
    
    @Column(name = "objetivo", nullable = false)
	private String objetivo;
    
    @Column(name = "duracao", nullable = false)
   	private Double duracao;
	
	public String getJustificativa()
	{
		return justificativa ;
	}

	
	public void setJustificativa( String justificativa )
	{
		this.justificativa = justificativa ;
	}

	
	public String getMaterial()
	{
		return material ;
	}

	
	public void setMaterial( String material )
	{
		this.material = material ;
	}

	
	public String getObjetivo()
	{
		return objetivo ;
	}

	
	public void setObjetivo( String objetivo )
	{
		this.objetivo = objetivo ;
	}

	
	public Double getDuracao()
	{
		return duracao ;
	}

	
	public void setDuracao( Double duracao )
	{
		this.duracao = duracao ;
	}

	@ Override
	public String toString()
	{
		return "Curso [ justificativa=" + justificativa + ", material=" + material + ", objetivo="
				+ objetivo + ", duracao=" + duracao + "]" ;
	}

	public Curso() {
		super();
	}
	
	public Curso(String justificativa , String material, String objetivo, Double duracao) {
		super();
		this.justificativa = justificativa;
		this.material = material;
		this.objetivo = objetivo;
		this.duracao = duracao;
	}
   
}
