package YouTube.entidades;

import YouTube.Main;

public class VideosFavoritos extends Video{

	public VideosFavoritos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VideosFavoritos(String nome, String link, String date, Canal canal, String descricao) {
		super(nome, link, date, canal, descricao);
		// TODO Auto-generated constructor stub
	}

	public static boolean AdicionaFavorito(String auxiliar){
		Video favorito = new VideosFavoritos();
		Canal C = new Canal();
		favorito.setCanal(C);
		for(int i = 0; i<Main.video.size(); i++) {
			if(Main.video.get(i).getLink().contentEquals(auxiliar)) {
				favorito = Main.video.get(i);
				Main.videosfavoritos.add((VideosFavoritos) favorito);
				return true;
			}

		}
		return false;

	}



}



