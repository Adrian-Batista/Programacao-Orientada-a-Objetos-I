package YouTube.entidades;

public class Usuarios {
	
	private String nomeUsuario;
	private String emailUsuario;
	private String senhaUsuario;

	public Usuarios(String nomeUsuario, String emailUsuario, String senhaUsuario) {
		this.setNomeUsuario(nomeUsuario);
		this.setEmailUsuario(emailUsuario);
		this.setSenhaUsuario(senhaUsuario);
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

}
