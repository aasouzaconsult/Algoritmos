public class Cidade {
	private int codigo;
	private String nome;
	private Estado estado;


	
	/**
	 * @return
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @return
	 */
	public Estado getEstado() {
		return estado;
	}

	/**
	 * @return
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param i
	 */
	public void setCodigo(int i) {
		codigo = i;
	}

	/**
	 * @param estado
	 */
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	/**
	 * @param string
	 */
	public void setNome(String string) {
		nome = string;
	}

}