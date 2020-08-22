package YouTube.entidades;

import java.io.IOException;
import java.util.Scanner;

import YouTube.Main;


public class Videos {
	
	private String nome;
	private String link;
	private String date;
	private String canalVideo;
	private String generoVideo;
	private double precoVideo;
	

	public Videos(String nome, String link) {
		this.setNome(nome);
		this.setLink(link);
	}
	
	public Videos() {
		this.setNome(nome);
		this.setLink(link);
		this.setDate(date);
		this.setCanalVideo(canalVideo);
		this.setGeneroVideo(generoVideo);
		this.setPrecoVideo(0);
	}

	static Scanner entrada = new Scanner(System.in);
	
//------------------------------------------ Adicionar Vídeos ---------------------------------------------
	
		public static void AdicionaVideos () throws IOException {
			Main.LimparTela();
			
			Videos video = new Videos();
			int opc= 0;
			int aux = 0;
			int aux2 = 0;
							
			do {
				do {
					System.out.printf("Para adicionar um novo vídeo é necessário um Canal.\n Voce ja tem um Canal ou deseja criar um? ");
					System.out.println("\n============================================");
					System.out.println("|  1 - Buscar Canal                       | ");
					System.out.println("|  2 - Criar Canal                        | ");
					System.out.println("|  0 - Voltar                             | ");
					System.out.println("============================================\n");
					opc = entrada.nextInt();
					entrada.nextLine();
					
					if(opc==1 || opc == 2 || opc == 0)
						aux = 1;
					
				}while(aux !=1);
			
				switch (opc) { 
					
					case 1:
						System.out.printf("Digite o nome do Canal a ser localizado:  \n");
						String canalBusca = entrada.nextLine();
					
					
						for (int indice = 0; indice < Main.canais.size(); indice++) {
							if (Main.canais.get(indice).getNomeCanal().contentEquals(canalBusca)) {
								aux2++;
								video.setCanalVideo(canalBusca);
								Main.LimparTela();
								System.out.printf("Canal Localizado com Sucesso!! \n");
								System.out.println("Pressione Enter Novamente...\n\n");
								break;
							}
						}
							
							if(aux2==0) {
								Main.LimparTela();
								System.out.printf("Canal não localizado tente novamente!! \n\n");
								break;
							}
						break;
					
					case 2: 
						aux2++;
						Canais.AdicionaCanais();
						video.setCanalVideo(Canais.auxiliar);
						break;
					
					case 0: 
						return;
				}
				
			}while(aux2==0);
			
			
			Main.LimparTela();
			
			
			do {
				aux2=0;
				System.out.printf("Digite o Tíulo do Vídeo: ");
				video.setNome(entrada.nextLine());
				
				for (int indice = 0; indice < Main.videos.size(); indice++) {
					if (Main.videos.get(indice).getNome().contentEquals(video.getNome())){
						aux2++;
						System.out.printf("\nO Título escolhido ja está em uso, selecione outro:\n\n ");
						break;
					}
				}
				
			}while(aux2 != 0);
			
			do {
				aux2=0;
				System.out.printf("Digite o link de acesso: ");
				video.setLink(entrada.nextLine());
				for (int indice = 0; indice < Main.videos.size(); indice++) {
					if (Main.videos.get(indice).getLink().contentEquals(video.getLink())){
						aux2++;
						System.out.printf("\nO Link escolhido ja está em uso, selecione outro:\n\n ");
						break;
					}
				}
				
			}while(aux2 != 0);
			
			
			System.out.printf("Digite a data de publicação: ");
			video.setDate(entrada.nextLine());
			
			System.out.printf("Digite o gênero do seu vídeo: ");
			video.setGeneroVideo(entrada.nextLine());
			
			System.out.printf("Digite o valor que será cobrado pelo seu vídeo, caso for gratuito digite 0: ");
			video.setPrecoVideo(entrada.nextDouble());
			
			Main.videos.add(video);
			
			System.out.printf("\nDados Armazenados com sucesso!! \n");
			System.out.println("Pressione Enter Novamente...");
			System.in.read();
		}
		
		
//------------------------------------------ Listar Vídeos ----------------------------------------------
		
		public static void ListarVideos () throws IOException {
			
			Main.LimparTela();
					
			System.out.println("\n=============================================================\n"); 
			for(int i = 0;i<Main.videos.size();i++){  
				System.out.println("\nTítulo : " + Main.videos.get(i).getNome());
				System.out.println("Link : " + Main.videos.get(i).getLink());
				System.out.println("Data : " + Main.videos.get(i).getDate());
				System.out.println("Canal : " + Main.videos.get(i).getCanalVideo());
				System.out.println("Gênero : " + Main.videos.get(i).getGeneroVideo());
				System.out.println("Preço : " + Main.videos.get(i).getPrecoVideo());
								
				System.out.println("\n=============================================================\n"); 
			}
					
													
			System.out.println("Pressione Enter Novamente...");
			System.in.read();
		}	
		
// ---------------------------------- MÉTODO REMOVER VÍDEO -------------------------------------------
		
		public static void RemoverVideo() throws IOException {
			System.out.printf("Digite o nome do Video a ser removido:  \n");
			String nomeRemove = entrada.nextLine();
			int aux = 0;
			
			for (int indice = 0; indice < Main.videos.size(); indice++) {
				if (Main.videos.get(indice).getNome().contentEquals(nomeRemove)) {
					aux++;
					Main.videos.remove(indice);
					System.out.printf("Video removido com Sucesso!! \n");
					System.out.println("Pressione Enter Novamente...");
					System.in.read();
				}	
			}
			if(aux==0) {
				Main.LimparTela();
				System.out.printf("Vídeo não localizado tente novamente!! \n\n");
				System.in.read();
				return;
			}
		}	
		
// -------------------------------- MÉTODO ATUALIZAR VÍDEO -------------------------------------------		
		
		public static void AtualizarVideo() throws IOException {
			System.out.printf("Digite o nome do Video a ser Atualizado:  \n");
			String nomeUpdate = entrada.nextLine();
			String verificador;
			int aux = 0;
			int aux3 = 0;
			
			for (int indice = 0; indice < Main.videos.size(); indice++) {
				if (Main.videos.get(indice).getNome().contentEquals(nomeUpdate)) {
					aux++;
					Main.LimparTela();
					
					
					do {
						aux3=0;
						System.out.printf("Digite o Tíulo do Vídeo: ");
						verificador = (entrada.nextLine());
						for (int indice2 = 0; indice2 < Main.videos.size(); indice2++) {
							if (Main.videos.get(indice2).getNome().contentEquals(verificador)){
								aux3++;
								System.out.printf("\nO Título escolhido ja está em uso, selecione outro:\n\n ");
								break;
							}
						}
						if(aux3==0) {
							Main.videos.get(indice).setNome(verificador);
						}
						
					}while(aux3 != 0);
					
					do {
						aux3=0;
						System.out.printf("Digite o Link do Vídeo: ");
						verificador = (entrada.nextLine());
						for (int indice2 = 0; indice2 < Main.videos.size(); indice2++) {
							if (Main.videos.get(indice2).getLink().contentEquals(verificador)){
								aux3++;
								System.out.printf("\nO Link escolhido ja está em uso, selecione outro:\n\n ");
								break;
							}
						}
						if(aux3==0) {
							Main.videos.get(indice).setLink(verificador);
						}
						
					}while(aux3 != 0);
					
					System.out.printf("Digite a data de publicação: ");
					Main.videos.get(indice).setDate(entrada.nextLine());
					
					System.out.printf("Digite o gênero do seu vídeo: ");
					Main.videos.get(indice).setGeneroVideo(entrada.nextLine());
					
					System.out.printf("Digite o valor que será cobrado pelo seu vídeo, caso for gratuito digite 0: ");
					Main.videos.get(indice).setPrecoVideo(entrada.nextDouble());
					
					System.out.printf("Dados Armazenados com sucesso!! \n");
					System.out.println("Pressione Enter Novamente...");
					System.in.read();
					break;
				}	
			}
			if(aux==0) {
				System.out.printf("Video não Localizado tente novamente!! \n");
				System.out.println("Pressione Enter ...");
				System.in.read();
				return;
			}
		}		
		
//--------------------------------------------------------------------------------------------------------------


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


	public double getPrecoVideo() {
		return precoVideo;
	}

	public void setPrecoVideo(double precoVideo) {
		this.precoVideo = precoVideo;
	}

	public String getCanalVideo() {
		return canalVideo;
	}

	public void setCanalVideo(String canalVideo) {
		this.canalVideo = canalVideo;
	}
}
