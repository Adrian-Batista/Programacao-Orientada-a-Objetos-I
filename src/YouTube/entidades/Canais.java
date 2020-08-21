package YouTube.entidades;

public class Canais {
	
	private String nomeCanal;
	private String autorCanal;
	private String descricaoCanal;
	private String dataCanal;
	private String publicoAlvoCanal;
	

	public Canais(String nomeCanal, String autorCanal, String descricaoCanal, String publicoAlvoCanal) {
		this.setNomeCanal(nomeCanal);
		this.setAutorCanal(autorCanal);
		this.setDescricaoCanal(descricaoCanal);
		this.setPublicoAlvoCanal(publicoAlvoCanal);
	}


	public String getNomeCanal() {
		return nomeCanal;
	}


	public void setNomeCanal(String nomeCanal) {
		this.nomeCanal = nomeCanal;
	}


	public String getAutorCanal() {
		return autorCanal;
	}


	public void setAutorCanal(String autorCanal) {
		this.autorCanal = autorCanal;
	}


	public String getDescricaoCanal() {
		return descricaoCanal;
	}


	public void setDescricaoCanal(String descricaoCanal) {
		this.descricaoCanal = descricaoCanal;
	}


	public String getDataCanal() {
		return dataCanal;
	}


	public void setDataCanal(String dataCanal) {
		this.dataCanal = dataCanal;
	}


	public String getPublicoAlvoCanal() {
		return publicoAlvoCanal;
	}


	public void setPublicoAlvoCanal(String publicoAlvoCanal) {
		this.publicoAlvoCanal = publicoAlvoCanal;
	}

}
