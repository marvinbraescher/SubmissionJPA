package contatos;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Telefone
 *
 */
@Entity
@Table(name="telefone")
public class Telefone implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Utilizando a estratégia de geração de identidade (identity)
	// devido ao uso do MySQL, permitindo uma atribuição automática e
	// incremental de valores para a chave primária "idsubmissao".
	@ Id
	@Column(name = "idtelefone", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
    @Column(name = "ddd", nullable = false)
    private int ddd;
    
    @Column(name = "numero", nullable = false)
    private Long numero;
	
	public Long getId()
	{
		return id ;
	}
	
	
	public int getDdd()
	{
		return ddd ;
	}

	
	public void setDdd( int ddd )
	{
		this.ddd = ddd ;
	}

	
	public Long getNumero()
	{
		return numero ;
	}

	
	public void setNumero( Long numero )
	{
		this.numero = numero ;
	}

	@ Override
	public String toString()
	{
		return "Telefone [id=" + id + ", ddd=" + ddd + ", numero=" + numero + "]" ;
	}

	public void setId( Long id )
	{
		this.id = id ;
	}
	
	public Telefone() {
		super();
	}
	
	public Telefone(Long numero, int ddd) {
		super();
		this.ddd = ddd;
		this.numero = numero;
	}
   
}
