public class Endereco {
	private String logradouro;
	private int numero;
	private String bairro;
	private int cep;
	private Cidade cidade;
	private Estado estado;
	
	
	/**
	 * @return
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @return
	 */
	public int getCep() {
		return cep;
	}

	/**
	 * @return
	 */
	public Cidade getCidade() {
		return cidade;
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
	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * @return
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param string
	 */
	public void setBairro(String string) {
		bairro = string;
	}

	/**
	 * @param i
	 */
	public void setCep(int i) {
		cep = i;
	}

	/**
	 * @param cidade
	 */
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
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
	public void setLogradouro(String string) {
		logradouro = string;
	}

	/**
	 * @param i
	 */
	public void setNumero(int i) {
		numero = i;
	}

}