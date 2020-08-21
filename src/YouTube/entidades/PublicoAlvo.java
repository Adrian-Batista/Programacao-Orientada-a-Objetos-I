package YouTube.entidades;

public class PublicoAlvo {
	
	private String generoPublico;
	private String idadePublico;
	private String generoCanal;

	public PublicoAlvo(String generoPublico, String idadePublico, String generoCanal) {
		this.setGeneroPublico(generoPublico);
		this.setIdadePublico(idadePublico);
		this.setGeneroCanal(generoCanal);
	}

	public String getGeneroPublico() {
		return generoPublico;
	}

	public void setGeneroPublico(String generoPublico) {
		this.generoPublico = generoPublico;
	}

	public String getIdadePublico() {
		return idadePublico;
	}

	public void setIdadePublico(String idadePublico) {
		this.idadePublico = idadePublico;
	}

	public String getGeneroCanal() {
		return generoCanal;
	}

	public void setGeneroCanal(String generoCanal) {
		this.generoCanal = generoCanal;
	}

}
