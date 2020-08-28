package YouTube.entidades;

import YouTube.Main;

public class VideosFavoritos extends Videos{

	public VideosFavoritos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VideosFavoritos(String nome, String link, String date, Canais canal, String descricao) {
		super(nome, link, date, canal, descricao);
		// TODO Auto-generated constructor stub
	}

	public static boolean AdicionaFavorito(String auxiliar){
		Videos favorito = new VideosFavoritos();
		Canais C = new Canais();
		favorito.setCanal(C);
		for(int i = 0; i<Main.videos.size(); i++) {
			if(Main.videos.get(i).getLink().contentEquals(auxiliar)) {
				favorito = Main.videos.get(i);
				Main.videosfavoritos.add((VideosFavoritos) favorito);
				return true;
			}

		}
		return false;

	}



}



