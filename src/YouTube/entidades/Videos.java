package YouTube.entidades;

public class Videos{
	
	private String nome;
	private String link;
	private String date;
	private String canal;
	private String descricao;
	
	
	public Videos(String nome, String link, String date, String canal, String descricao) {
		super();
		this.nome = nome;
		this.link = link;
		this.date = date;
		this.canal = canal;
		this.descricao = descricao;
	}
		
//---------------------------------------- GETTERS E SETTERS ---------------------------------------------

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getCanal() {
		return canal;
	}


	public void setCanal(String canal) {
		this.canal = canal;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
