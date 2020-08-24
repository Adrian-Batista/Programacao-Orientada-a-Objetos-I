package YouTube.entidades;

import java.io.IOException;

import YouTube.Main;

public class VideosFavoritos extends Videos {

	public VideosFavoritos() {
		super();
	}

	
//-------------------------------------------------------------------------------------------
	
	
	public static void AdicionaVideoFavorito() throws IOException {
		int aux=0;
		String addFavorito;

		Videos favorito = new VideosFavoritos();

		System.out.println("Digite o LINK do vídeo a ser adicionado aos favoritos:");
		addFavorito = entrada.nextLine();

		for(int i = 0; i<Main.videos.size(); i++) {
			if(Main.videos.get(i).getLink().contentEquals(addFavorito)) {
				favorito = Main.videos.get(i);
				Main.videosfavoritos.add((VideosFavoritos) favorito);
				aux++;
				System.out.println("Vídeo localizado com Sucesso!");
				System.in.read();
				break;
			}
			if(aux == 0) {
				System.out.println("Video não localizado tente novamente!");
				System.in.read();
			}

		}

	}
	
//-----------------------------------------------------------------------------------------------
	
	public static void ListaVideoFavorito() throws IOException {
		
		Main.LimparTela();
		System.out.println("\n=============================================================\n"); 
		for(int i = 0;i<Main.videosfavoritos.size();i++){  
			System.out.println("\nTítulo : " + Main.videosfavoritos.get(i).getNome());
			System.out.println("Link : " + Main.videosfavoritos.get(i).getLink());
			System.out.println("Data : " + Main.videosfavoritos.get(i).getDate());
			System.out.println("Canal : " + Main.videosfavoritos.get(i).getCanalVideo());
			System.out.println("Descrição : " + Main.videosfavoritos.get(i).getDescricao());
			System.out.println("Preço : " + Main.videosfavoritos.get(i).getPrecoVideo());
							
			System.out.println("\n=============================================================\n"); 
		}											
		System.out.println("Pressione Enter Novamente...");
		System.in.read();
	}

	//----------------------------------------------------------------------------------------------

	public static void RemoveVideoFavorito() throws IOException {
		int aux=0;
		String remFavorito;

		System.out.println("Digite o LINK do vídeo a ser removido dos favoritos:");
		remFavorito = entrada.nextLine();

		for(int i = 0; i<Main.videos.size(); i++) {
			if(Main.videos.get(i).getLink().contentEquals(remFavorito)) {
				Main.videosfavoritos.remove(i);
				aux++;
				System.out.println("Vídeo localizado com Sucesso!");
				System.in.read();
				break;
			}
			if(aux == 0) {
				System.out.println("Video não localizado tente novamente!");
				System.in.read();
			}

		}

	}

	//-----------------------------------------------------------------------------------------------

	@SuppressWarnings("unused")
	public static void AtualizaVideoFavorito() throws IOException {
		int aux=0;
		String upFavorito;

		Videos favorito = new VideosFavoritos();

		System.out.println("Digite o LINK do vídeo favorito a ser sobreescrito por outro:");
		upFavorito = entrada.nextLine();

		for(int i = 0; i<Main.videosfavoritos.size(); i++) {
			if(Main.videosfavoritos.get(i).getLink().contentEquals(upFavorito)) {

				System.out.println("Digite o LINK do vídeo favorito a ser adicionado:");
				upFavorito = entrada.nextLine();

				for(int indice = 0; indice<Main.videos.size(); indice++) {
					if(Main.videos.get(indice).getLink().contentEquals(upFavorito)) {
						favorito = Main.videos.get(indice);
						Main.videosfavoritos.add(i, (VideosFavoritos) favorito);
						aux++;
						System.out.println("Vídeo localizado com Sucesso!");
						System.in.read();
						break;
					}		
				}
			}

			break;
		}
		if(aux == 0) {
			System.out.println("Video não localizado tente novamente!");
			System.in.read();
		}
	}
}



