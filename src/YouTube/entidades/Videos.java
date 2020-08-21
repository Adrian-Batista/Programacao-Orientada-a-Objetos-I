package YouTube.entidades;

public class Videos {
	
	private String nome;
	private String link;
	private String date;
	private String generoVideo;
	private String canalVideo;
	

	public Videos(String nome, String link, String date, String generoVideo, String canalVideo) {
		this.setNome(nome);
		this.setLink(link);
		this.setDate(date);
		this.setGeneroVideo(generoVideo);
		this.setCanalVideo(canalVideo);
	}


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


	public String getGeneroVideo() {
		return generoVideo;
	}


	public void setGeneroVideo(String generoVideo) {
		this.generoVideo = generoVideo;
	}


	public String getCanalVideo() {
		return canalVideo;
	}


	public void setCanalVideo(String canalVideo) {
		this.canalVideo = canalVideo;
	}

}
