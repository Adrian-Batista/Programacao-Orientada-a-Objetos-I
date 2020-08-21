package YouTube.entidades;

import java.io.IOException;
import java.util.Scanner;

import YouTube.Main;

public class Videos {
	
	private String nome;
	private String link;
	private String date;
	private String generoVideo;
	private String canalVideo;
	

	public Videos() {
		this.setNome(nome);
		this.setLink(link);
		this.setDate(date);
		this.setGeneroVideo(generoVideo);
		this.setCanalVideo(canalVideo);
	}
	
	static Scanner entrada = new Scanner(System.in);
	
	//-------------------------------------------------------------------------------
	
		public static void AdicionaVideos () throws IOException {
			Main.LimparTela();
			
			Videos video = new Videos();
			
			System.out.printf("Digite o nome do Vídeo: ");
			video.setNome(entrada.nextLine());
			
			System.out.printf("Digite o Link do Vídeo: ");
			video.setLink(entrada.nextLine());
			
			System.out.printf("Digite a data para publicação: ");
			video.setDate(entrada.nextLine());
			
			Main.videos.add(video);
			
			System.out.printf("\nDados Armazenados com sucesso!! \n");
			System.out.println("Pressione Enter Novamente...");
			System.in.read();
		}
		
		
		//-------------------------------------------------------------------------------
		
		public static void ListarVideos () throws IOException {
			
			Main.LimparTela();
					
			System.out.println("\n=============================================================\n"); 
			for(int i = 0;i<Main.videos.size();i++){  
				System.out.println("\nTítulo : " + Main.videos.get(i).getNome());
				System.out.println("Link : " + Main.videos.get(i).getLink());
				System.out.println("Data : " + Main.videos.get(i).getDate());
								
				System.out.println("\n=============================================================\n"); 
			}
					
													
			System.out.println("Pressione Enter Novamente...");
			System.in.read();
		}	
		
		//-------------------------------------------------------------------------------


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
