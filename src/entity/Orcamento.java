package entity;

public class Orcamento {

	private String horarioDeEntrega;
	private Integer precoDoServico;
	private Integer precoDoProduto;
	private String nomeDoServicoContratado;
	private String nomeDoProduto;
	private Integer unidadesDoProduto;
	private Integer precoDoMaterial;
	private Integer Metro;
	private String emailDeConfirmacao;
	private String statusDoOrcamento;
	private String observacao;
	private Integer valorTotal;
	private Long id;
	
	public Orcamento() {
		
	}

	public Orcamento(String horarioDeEntrega, Integer precoDoServico, Integer precoDoProduto,
			String nomeDoServicoContratado, String nomeDoProduto, Integer unidadesDoProduto, Integer precoDoMaterial,
			Integer precoPorMetro, String emailDeConfirmacao, String statusDoOrcamento, String observacao,
			Integer valor) {
		this.horarioDeEntrega = horarioDeEntrega;
		this.precoDoServico = precoDoServico;
		this.precoDoProduto = precoDoProduto;
		this.nomeDoServicoContratado = nomeDoServicoContratado;
		this.nomeDoProduto = nomeDoProduto;
		this.unidadesDoProduto = unidadesDoProduto;
		this.precoDoMaterial = precoDoMaterial;
		this.Metro = precoPorMetro;
		this.emailDeConfirmacao = emailDeConfirmacao;
		this.statusDoOrcamento = statusDoOrcamento;
		this.observacao = observacao;
		this.valorTotal = valor;
		this.id = System.currentTimeMillis();
	}

	public String toString() {
		return "Horario De Entrega: " + this.horarioDeEntrega + "\n" + " Preço Do Serviço: " + this.precoDoServico
				+ "\n" + " Preço Do Produto: " + this.precoDoProduto + "\n" + " Serviço Contratado: "
				+ this.nomeDoServicoContratado + "\n" + " Produto: " + this.nomeDoProduto + "\n" + " Unidades: "
				+ this.unidadesDoProduto + " Preço Do Material Por Metro: " + this.precoDoMaterial + "\n"
				+ " Metros Comprados: " + this.Metro + "\n" + " Email da realização do orçamento: "
				+ this.emailDeConfirmacao + "\n" + " Status Do Orçamento: " + this.statusDoOrcamento + "\n"
				+ " Valor Total: " + this.valorTotal + "\n" + " Numero Do Pedido: " + this.id;
	}

	public String getHorarioDeEntrega() {
		return horarioDeEntrega;
	}

	public void setHorarioDeEntrega(String horarioDeEntrega) {
		this.horarioDeEntrega = horarioDeEntrega;
	}

	public Integer getPrecoDoServico() {
		return precoDoServico;
	}

	public void setPrecoDoServico(Integer precoDoServico) {
		this.precoDoServico = precoDoServico;
	}

	public Integer getPrecoDoProduto() {
		return precoDoProduto;
	}

	public void setPrecoDoProduto(Integer precoDoProduto) {
		this.precoDoProduto = precoDoProduto;
	}

	public String getNomeDoServicoContratado() {
		return nomeDoServicoContratado;
	}

	public void setNomeDoServicoContratado(String nomeDoServicoContratado) {
		this.nomeDoServicoContratado = nomeDoServicoContratado;
	}

	public String getNomeDoProduto() {
		return nomeDoProduto;
	}

	public void setNomeDoProduto(String nomeDoProduto) {
		this.nomeDoProduto = nomeDoProduto;
	}

	public Integer getUnidadesDoProduto() {
		return unidadesDoProduto;
	}

	public void setUnidadesDoProduto(Integer unidadesDoProduto) {
		this.unidadesDoProduto = unidadesDoProduto;
	}

	public Integer getPrecoDoMaterial() {
		return precoDoMaterial;
	}

	public void setPrecoDoMaterial(Integer precoDoMaterial) {
		this.precoDoMaterial = precoDoMaterial;
	}

	public Integer getMetro() {
		return Metro;
	}

	public void setMetro(Integer metro) {
		Metro = metro;
	}

	public String getEmailDeConfirmacao() {
		return emailDeConfirmacao;
	}

	public void setEmailDeConfirmacao(String emailDeConfirmacao) {
		this.emailDeConfirmacao = emailDeConfirmacao;
	}

	public String getStatusDoOrcamento() {
		return statusDoOrcamento;
	}

	public void setStatusDoOrcamento(String statusDoOrcamento) {
		this.statusDoOrcamento = statusDoOrcamento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Integer getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Integer valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
