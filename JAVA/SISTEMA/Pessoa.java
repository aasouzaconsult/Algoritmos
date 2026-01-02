
public class Pessoa {
	
	private String nome;
	private int     codigo;
	private String sexo;
	private String tipo;
	private Endereco endereco;

	/**
	 * @return
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @return
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * @return
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param i
	 */
	public void setCodigo(int i) {
		codigo = i;
	}

	/**
	 * @param string
	 */
	public void setNome(String string) {
		nome = string;
	}

	/**
	 * @param string
	 */
	public void setSexo(String string) {
		sexo = string;
	}

	/**
	 * @param string
	 */
	public void setTipo(String string) {
		tipo = string;
	}

	/**
	 * @return
	 */
	public Endereco getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
