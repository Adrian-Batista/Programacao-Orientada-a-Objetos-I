package YouTube;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import YouTube.entidades.Canais;
import YouTube.entidades.Inscricoes;
import YouTube.entidades.PublicoAlvo;
import YouTube.entidades.Usuarios;
import YouTube.entidades.Videos;
import YouTube.entidades.VideosFavoritos;

public class Main {

	public static List<Usuarios> usuarios = new ArrayList<Usuarios>();
	public static List<Videos> videos = new ArrayList<Videos>();
	public static List<Canais> canais = new ArrayList<Canais>();
	public static List<Inscricoes> inscricoes = new ArrayList<Inscricoes>();
	public static List<VideosFavoritos>videosfavoritos = new ArrayList<VideosFavoritos>();
	
	public static void main(String[] args) throws IOException {
		int opcao = 0;
		int opcao1 =0;
		int opcao2 = 0;
		int opcao3 = 0;
		int opcao4 = 0;
		int opcao5 = 0;
		int cont = 0;
		
		Scanner entrada = new Scanner(System.in);
		
		do {
			
			if(cont>0)
				Main.LimparTela();
			
			cont++;
			
			System.out.println("\n\n BEM VINDO AO YOUTUBE ");	
			System.out.println("\n================================= \n|\t\t\t\t|");
			System.out.println("| ( 1 ) - MENU DO USUARIO       | \n|\t\t\t\t|");
			System.out.println("| ( 2 ) - MENU DE VÍDEOS        | \n|\t\t\t\t| ");
			System.out.println("| ( 3 ) - MENU DE CANAIS        | \n|\t\t\t\t| ");
			System.out.println("| ( 4 ) - MENU DE INSCRICOES    | \n|\t\t\t\t| ");
			System.out.println("| ( 5 ) - MENU DE FAVORITOS     | \n|\t\t\t\t| ");
			System.out.println("| ( 0 ) - SAIR                  | \n|\t\t\t\t|");
			System.out.println("=================================\n");
	
			System.out.println(" Escolha uma das opções: ");
			opcao = entrada.nextInt();
			entrada.nextLine();
			System.out.print("\n");
			
			switch (opcao) {

// ----------------------------------------- LOGIN DE USUARIO ----------------------------------------------
			case 1:
				
				
				do {
					Main.LimparTela();
					System.out.println("\n Caro Usuario selecione uma das opções abaixo: " );
					System.out.println("\n=========================================\n|\t\t\t\t\t|");
					System.out.println("| ( 1 ) - CADASTRAR - SE                |\n|\t\t\t\t\t|");
					System.out.println("| ( 2 ) - LISTAR CADASTRO               |\n|\t\t\t\t\t|");
					System.out.println("| ( 3 ) - REMOVER CADASTRO              |\n|\t\t\t\t\t|");
					System.out.println("| ( 4 ) - ATUALIZAR CADASTRO            |\n|\t\t\t\t\t|");
					System.out.println("| ( 0 ) - VOLTAR                        |\n|\t\t\t\t\t|");
					System.out.println("=========================================\n");
				
					System.out.println(" Escolha uma das opções: ");
					opcao1 = entrada.nextInt();
					entrada.nextLine();
					System.out.print("\n");
					
					switch (opcao1) {
					
					case 1:
						Main.LimparTela();
						Usuarios.AdicionarUsuario();
						System.out.printf("\nDados Armazenados com sucesso!! \n");
						System.out.println("Pressione Enter Novamente...");
						System.in.read();
						break;
					
					case 2:
						Main.LimparTela();		
						Usuarios.ListarUsuario();					
						System.out.println("Pressione Enter Novamente...");
						System.in.read();
						break;
						
					case 3:
						Main.LimparTela();
						System.out.println("Em Desenvolvimento!!");
						System.out.println("Pressione Enter Novamente...");
						System.in.read();
						
					  /*System.out.printf("Digite o nome do Usuario a ser removido:  \n");
						String nomeRemove = entrada.nextLine();
						int aux = 0;
						
						for (int indice = 0; indice < Main.usuarios.size(); indice++) {
							if (Main.usuarios.get(indice).getNome().contentEquals(nomeRemove)) {
								aux++;
								Main.usuarios.remove(indice);
								System.out.printf("Usuário removido com Sucesso!! \n");
								System.out.println("Pressione Enter Novamente...");
								System.in.read();
							}	
						}
						if(aux==0) {
							Main.LimparTela();
							System.out.printf("Usuário não localizado tente novamente!! \n\n");
							System.in.read();
							return;
						}*/
						break;
						
					case 4:
						Main.LimparTela();
						System.out.println("Em Desenvolvimento!!");
						System.out.println("Pressione Enter Novamente...");
						System.in.read();
						/*System.out.printf("Digite o nome do Usuario a ser Atualizado:  \n");
						String nomeUpdate = entrada.nextLine();
						String verificador;
						int aux = 0;
						int aux3 = 0;
						
						for (int indice = 0; indice < Main.usuarios.size(); indice++) {
							if (Main.usuarios.get(indice).getNome().contentEquals(nomeUpdate)) {
								aux++;
								Main.LimparTela();
								
								
								do {
									aux3=0;
									System.out.printf("Digite o seu nome: ");
									verificador = (entrada.nextLine());
									for (int indice2 = 0; indice2 < Main.usuarios.size(); indice2++) {
										if (Main.usuarios.get(indice2).getNome().contentEquals(verificador)){
											aux3++;
											System.out.printf("\nO nome escolhido ja está em uso, selecione outro:\n\n ");
											break;
										}
									}
									if(aux3==0) {
										Main.usuarios.get(indice).setNome(verificador);
									}
									
								}while(aux3 != 0);
								
								System.out.printf("Digite seu endereco: ");
								verificador = (entrada.nextLine());
								Main.usuarios.get(indice).setEndereco(verificador);
								
								do {
									aux3=0;
									
									System.out.printf("Digite o seu email: ");
									verificador = (entrada.nextLine());
									for (int indice2 = 0; indice2 < Main.usuarios.size(); indice2++) {
										if (Main.usuarios.get(indice2).getEmail().contentEquals(verificador)){
											aux3++;
											System.out.printf("\nO E-mail escolhido ja está em uso, selecione outro:\n\n ");
											break;
										}
									}
									if(aux3==0) {
										Main.usuarios.get(indice).setEmail(verificador);
									}
								}while(aux3 != 0);
								
								System.out.printf("Digite uma senha: ");
								verificador = (entrada.nextLine());
								Main.usuarios.get(indice).setSenha(verificador);
								
								System.out.printf("Dados Armazenados com sucesso!! \n");
								System.out.println("Pressione Enter Novamente...");
								System.in.read();
								break;
							}	
						}
						if(aux==0) {
							System.out.printf("Usuario não Localizado tente novamente!! \n");
							System.out.println("Pressione Enter ...");
							System.in.read();
							return;
						}*/
						break;
						
					case 0:					
						break;
				
					}
				
				
				}while(opcao1!=0);
				break;
// --------------------------------------- VISUALIZAR VÍDEOS ----------------------------------------
				
			case 2:
					
				do {
					Main.LimparTela();
				
					System.out.println("\n Caro Usuario selecione uma das opções abaixo: " );
					System.out.println("\n=================================\n|\t\t\t\t|");
					System.out.println("| ( 1 ) - ADICIONAR VÍDEO       |\n|\t\t\t\t|");
					System.out.println("| ( 2 ) - LISTAR VÍDEOS         |\n|\t\t\t\t|");
					System.out.println("| ( 3 ) - ATUALIZAR VÍDEO       |\n|\t\t\t\t|");
					System.out.println("| ( 4 ) - REMOVER VÍDEO         |\n|\t\t\t\t|");
					System.out.println("| ( 0 ) - VOLTAR                |\n|\t\t\t\t|");
					System.out.println("=================================\n");
				
					System.out.println(" Escolha uma das opções: ");
					opcao2 = entrada.nextInt();
					entrada.nextLine();
					System.out.print("\n");
								
					switch (opcao2) {
				
					case 1:
						Main.LimparTela();
						
						Videos video = new Videos();
						Canais C = new Canais();
						video.setCanal(C);
						int opc= 0;
						int aux = 0;
						int aux2 = 0;
										
						do {
							do {
								System.out.printf("Para adicionar um novo vídeo é necessário um Canal.\n Voce ja tem um Canal ou deseja criar um? ");
								System.out.println("\n============================================");
								System.out.println("|  1 - Buscar Canal                       | ");
								System.out.println("|  0 - Voltar                             | ");
								System.out.println("============================================\n");
								opc = entrada.nextInt();
								entrada.nextLine();
								
								if(opc==1 || opc == 0)
									aux = 1;
								
							}while(aux !=1);
						
							switch (opc) { 
								
								case 1:
									System.out.printf("Digite o nome do Canal a ser localizado:  \n");
									video.getCanal().setNomecanal(entrada.nextLine());
									aux2 = Canais.VerificarNomeCanal(video.getCanal().getNomecanal());
									break;
								
								case 0:
									aux2++;
									break;
							}
							
						}while(aux2==0);
						
						if(opc == 0) {
							break;
						}
						
						Main.LimparTela();					
						do {
							System.out.printf("Digite o Tíulo do Vídeo: ");
							video.setNome(entrada.nextLine());			
						}while(Videos.VerificaTitulo(video.getNome()) == true);
						
						do {
							System.out.printf("Digite o link de acesso: ");
							video.setLink(entrada.nextLine());
						}while(Videos.VerificaLink(video.getLink()) == true);
												
						System.out.printf("Digite a data de publicação: ");
						video.setDate(entrada.nextLine());					
						System.out.printf("Digite uma descrição ao vídeo: ");
						video.setDescricao(entrada.nextLine());
						
						videos.add(video);
						
						System.out.printf("\nDados Armazenados com sucesso!! \n");
						System.out.println("Pressione Enter Novamente...");
						System.in.read();
						break;
					
					case 2:
						int auxiliar = 0;
						int auxiliar2 = 0;
						opc = 0;
						
						do {
							Main.LimparTela();
							do {
								System.out.printf("Para adicionar um novo vídeo é necessário um Canal.\n Voce ja tem um Canal ou deseja criar um? ");
								System.out.println("\n============================================");
								System.out.println("|  1 - Listar todos os vídeos             | ");
								System.out.println("|  2 - Listar por Canal                   | ");
								System.out.println("|  0 - Voltar                             | ");
								System.out.println("============================================\n");
								opc = entrada.nextInt();
								entrada.nextLine();
								
								if(opc==1 || opc == 2 || opc == 0)
									auxiliar2 = 1;
								
							}while(auxiliar2 !=1);
						
							switch (opc) { 
								
								case 1:
									Main.LimparTela();
									Videos.ListarVideos(null);										
									System.out.println("Pressione Enter Novamente...");
									System.in.read();
									break;
								
								case 2:
									Main.LimparTela();
									System.out.printf("Digite o nome do Canal:  \n");
									String nomeCanal = entrada.nextLine();
									Videos.ListarVideos(nomeCanal);
									System.out.println("Pressione Enter Novamente...");
									System.in.read();
									break;
								
								case 0: 
									auxiliar++;
									break;
							}
							
						}while(auxiliar==0);
						break;
						
					case 3:
						Main.LimparTela();
						System.out.println("Em Desenvolvimento!!");
						System.out.println("Pressione Enter Novamente...");
						System.in.read();
						/*System.out.printf("Digite o nome do Video a ser Atualizado:  \n");
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
								Main.videos.get(indice).setDescricao(entrada.nextLine());
								
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
						}*/
						break;
						
					case 4:
						Main.LimparTela();
						System.out.println("Em Desenvolvimento!!");
						System.out.println("Pressione Enter Novamente...");
						System.in.read();
					/*	System.out.printf("Digite o nome do Video a ser removido:  \n");
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
						}*/
						break;
					
					case 0:					
						break;
				
					}
				
				}while (opcao2 != 0);
				
				break;
				
// --------------------------------------- VISUALIZAR CANAIS ----------------------------------------
							
			case 3:
				do {
					
					for(int i = 0; i < 100; i++)
					{
					       System.out.println("");
					}
					System.out.println("\n Caro Usuario selecione uma das opções abaixo: " );
					System.out.println("\n=================================\n|\t\t\t\t|");
					System.out.println("| ( 1 ) - ADICIONAR CANAL       |\n|\t\t\t\t|");
					System.out.println("| ( 2 ) - LISTAR CANAIS         |\n|\t\t\t\t|");
					System.out.println("| ( 3 ) - ATUALIZAR CANAL       |\n|\t\t\t\t|");
					System.out.println("| ( 4 ) - REMOVER CANAL         |\n|\t\t\t\t|");
					System.out.println("| ( 5 ) - ATUALIZAR PÚBLICO ALVO|\n|\t\t\t\t|");
					System.out.println("| ( 0 ) - VOLTAR                |\n|\t\t\t\t|");
					System.out.println("=================================\n");
					
					System.out.println(" Escolha uma das opções: ");
					opcao3 = entrada.nextInt();
					entrada.nextLine();
					System.out.print("\n");
					switch (opcao3) {
					
					case 1:
						Main.LimparTela();

						Canais canal = new Canais();
						Usuarios U = new Usuarios();
						PublicoAlvo P = new PublicoAlvo();
						Inscricoes I = new Inscricoes();
						canal.setUsuario(U);
						canal.setPublico(P);
						canal.setInscritos(I);
					
						do {
							System.out.printf("Digite o nome do canal: ");
							canal.setNomecanal(entrada.nextLine());
						}while(Canais.VerificarNomeCanal1(canal.getNomecanal()) == true);
						System.out.printf("Digite o seu nome: ");
						canal.getUsuario().setNome(entrada.nextLine());
						
						System.out.printf("Digite uma descrição para este Canal: ");
						canal.setDescricao(entrada.nextLine());
	
						int escolha = 0;
						Main.LimparTela();
						System.out.println("\n Usuario selecione o publico alvo dos seu Canal: " );
						System.out.println("\n============================================");
						System.out.println("|  1 - Crianças (abaixo de 12 anos)        | ");
						System.out.println("|  2 - Jovens   (13 a 24 anos)             | ");
						System.out.println("|  3 - Adultos  (25 a 50 anos)             | ");
						System.out.println("|  4 - Idosos   (acima de 51 anos)         | ");
						System.out.println("|  5 - Todos                               | ");
						System.out.println("============================================\n");
					
						do {
							System.out.println(" Escolha uma das opções: ");
							escolha = entrada.nextInt();
							entrada.nextLine();
					
						}while(escolha<1 || escolha>5);
						canal.getPublico().setOpcao(PublicoAlvo.SelecionaPublicoAlvo(escolha));

						canais.add(canal);

						System.out.printf("\nDados Armazenados com sucesso!! \n");
						System.out.println("Pressione Enter Novamente...");
						break;
						
					case 2:
						Main.LimparTela();

						System.out.println("\n=============================================================\n"); 
						for(int i = 0;i<Main.canais.size();i++){  
							System.out.println("\nNome Canal : " + canais.get(i).getNomecanal());
							System.out.println("Autor : " + canais.get(i).getUsuario().getNome());
							System.out.println("Descrição : " + canais.get(i).getDescricao());
							System.out.println("Público Alvo : " + canais.get(i).getPublico().getOpcao());
							System.out.println("Inscritos : " + canais.get(i).getInscritos().getNumeroInscritos());
							System.out.println("\n=============================================================\n"); 
						}
						System.out.println("Pressione Enter Novamente...");
						System.in.read();
						break;
						
					case 3:
						Main.LimparTela();
						System.out.println("Em Desenvolvimento!!");
						System.out.println("Pressione Enter Novamente...");
						System.in.read();
						/*System.out.printf("Digite o nome do Canal a ser Atualizado:  \n");
						String nomeUpdate = entrada.nextLine();
						int aux = 0;


						for (int indice = 0; indice < Main.canais.size(); indice++) {

							if (Main.canais.get(indice).getNome().contentEquals(nomeUpdate)) {
								aux++;
								Main.LimparTela();

								System.out.printf("Digite o Nome do Canal: ");
								Main.canais.get(indice).setNome(entrada.nextLine());

								System.out.printf("Digite o nome do autor: ");
								Main.canais.get(indice).setAutor(entrada.nextLine());

								System.out.printf("Digite uma descrição para este Canal: ");
								Main.canais.get(indice).setDescricao(entrada.nextLine());

								Main.canais.get(indice).setPublicoAlvo(PublicoAlvo.opcao);
								PublicoAlvo.EscolherPublicoAlvo();


								for (int indice2 = 0; indice2 < Main.videos.size(); indice2++) {
									aux++;
									if (Main.videos.get(indice2).getNome().contentEquals(nomeUpdate)) {
										Main.videos.get(indice2).setNome(Main.canais.get(indice).getNome());
									}
								}

								System.out.printf("Dados Armazenados com sucesso!! \n");
								System.out.println("Pressione Enter Novamente...");
								System.in.read();
								break;
							}

						}
						if(aux==Main.canais.size()) {
							System.out.printf("Canal não Localizado tente novamente!! \n");
							System.out.println("Pressione Enter ...");
							System.in.read();
							return;
						}*/
						break;
						
					case 4:
						Main.LimparTela();
						System.out.println("Em Desenvolvimento!!");
						System.out.println("Pressione Enter Novamente...");
						System.in.read();
						/*Main.LimparTela();
						int auxiliar = 0;
						int aux = 0;
						System.out.printf("Digite o nome do Canal a ser removido:  \n");
						String nomeRemove = entrada.nextLine();

						for (int indice = 0; indice < Main.canais.size(); indice++) {
							if (Main.canais.get(indice).getNome().contentEquals(nomeRemove)) {

								for (int indice2 = 0; indice2 < Main.videos.size(); indice2++) {
									if (Main.videos.get(indice2).getNome().contentEquals(nomeRemove))
										auxiliar++;
								}

								do {
									System.out.printf("O Canal " + nomeRemove +" possui " + auxiliar + " videos, deseja remove-los do Youtube?");
									System.out.println("\n============================================");
									System.out.println("|  1 - Remover tudo                       | ");
									System.out.println("|  2 - Voltar                             | ");
									System.out.println("============================================\n");
									aux = entrada.nextInt();

									if(aux==1) {
										for (int indice2 = 0; indice2 < Main.videos.size(); indice2++) {
											if (Main.videos.get(indice2).getNome().contentEquals(nomeRemove)) {
												Main.videos.remove(indice2);
												indice2--;
											}
										}

										Main.canais.remove(indice);

										Main.LimparTela();
										System.out.printf("Canal removido com Sucesso!! \n");
										System.out.println("Pressione Enter Novamente...");
										System.in.read();
										break;
									}
									if(aux==2) {
										return;
									}

								}while(aux !=1 || aux!=2);

							}

						}
						if(auxiliar==0) {
							Main.LimparTela();
							System.out.printf("Canal não localizado tente novamente!! \n");
							System.in.read();
							return;
						}*/
						break;
						
					case 5:
						Main.LimparTela();
						System.out.println("Em Desenvolvimento!!");
						System.out.println("Pressione Enter Novamente...");
						System.in.read();
						/*PublicoAlvo.AtualizarPublicoAlvo();*/
						break;
						
					case 0:					
						break;
					
						}
					}while (opcao3 != 0);
				
				break;
				
				
// --------------------------------------- INSCRICOES ----------------------------------------				
				
				
			case 4:
				do {
					Main.LimparTela();
					System.out.println("\n Caro Usuario selecione uma das opções abaixo: " );
					System.out.println("\n=================================\n|\t\t\t\t|");
					System.out.println("| ( 1 ) - ADICIONAR INSCRICOES  |\n|\t\t\t\t|");
					System.out.println("| ( 2 ) - REMOVER INSCRICOES    |\n|\t\t\t\t|");
					System.out.println("| ( 3 ) - LISTAR INSCRICOES     |\n|\t\t\t\t|");
					System.out.println("| ( 0 ) - VOLTAR                |\n|\t\t\t\t|");
					System.out.println("=================================\n");
					
					System.out.println(" Escolha uma das opções: ");
					opcao4 = entrada.nextInt();
					entrada.nextLine();
					System.out.print("\n");
					switch (opcao4) {
					
					case 1:
						Main.LimparTela();
						int opc = 0;
						int aux = 0;				
						
						do {
								System.out.printf("Para se inscrever em um canal: ");
								System.out.println("\n============================================");
								System.out.println("|  1 - Buscar Canal                       | ");
								System.out.println("|  0 - Voltar                             | ");
								System.out.println("============================================\n");
								opc = entrada.nextInt();
								entrada.nextLine();
								
								aux = opc;
								
						}while(aux!=1 && aux !=0 );
						
							switch (opc) { 
							
								case 0:
									break;
								
								case 1:
									System.out.printf("Digite o nome do Canal a ser localizado:  \n");
									String canalBusca = entrada.nextLine();
									Inscricoes.RealizarInscricao(canalBusca);		
									break;
							}
							break;
						
					case 2:
						Main.LimparTela();
						System.out.println("Em Desenvolvimento!!");
						System.out.println("Pressione Enter Novamente...");
						System.in.read();
						/*Main.LimparTela();
						Inscricoes inscricao = new Inscricoes();
						int opc = 0;
						int aux = 0;
						int aux2 = 0;
						int auxiliar = 0;
										
						
						do {
								System.out.printf("Para remover a inscrição em um canal: ");
								System.out.println("\n============================================");
								System.out.println("|  1 - Buscar Canal                       | ");
								System.out.println("|  0 - Voltar                             | ");
								System.out.println("============================================\n");
								opc = entrada.nextInt();
								entrada.nextLine();
								
								aux = opc;
								
						}while(aux!=1 && aux !=0 );
						
							switch (opc) { 
							
								case 0:
									break;
								
								case 1:
									System.out.printf("Digite o nome do Canal a ser localizado:  \n");
									String canalBusca = entrada.nextLine();
								
								
									for (int indice = 0; indice < Main.canais.size(); indice++) {
										if (Main.canais.get(indice).getNome().contentEquals(canalBusca)) {
											aux2++;
											inscricao.setNomeCanalInscr(canalBusca);
											Main.inscricoes.add(inscricao);
											auxiliar = Main.canais.get(indice).getInscritos();
											if(auxiliar>0) {
												auxiliar--;	
											}
											Main.canais.get(indice).setInscritos(auxiliar);
										
											Main.LimparTela();
											System.out.printf("Canal Localizado com Sucesso!! \n");
											System.out.printf("Agora você não é mais inscrito deste Canal!! \n");
											System.out.println("Pressione Enter Novamente...\n\n");
											System.in.read();
											break;
										}
									}
										
									if(aux2==0) {
										Main.LimparTela();
										System.out.printf("Canal não localizado tente novamente!! \n\n");
										System.in.read();
										break;
									}
										
							}*/
						break;
						
					case 3:
						Main.LimparTela();
						aux=1;
						
						System.out.println("\n=============================================================\n"); 
						for(int i = 0;i<Main.inscricoes.size();i++){  
							System.out.println("\n"+aux+" ) Canal : " + inscricoes.get(i).getNomeCanal().getNomecanal());
							
							System.out.println("\n=============================================================\n");
							aux++;
						}
						 
														
						System.out.println("Pressione Enter Novamente...");
						System.in.read();
						
						break;
						
					case 0:					
						break;
					
						}
					}while (opcao4 != 0);
				
				break;
				
// -------------------------------------- VÍDEOS FAVORITOS ------------------------------------------------					

			case 5:
				do {
					
					for(int i = 0; i < 100; i++)
					{
					       System.out.println("");
					}
					System.out.println("\n Caro Usuario selecione uma das opções abaixo: " );
					System.out.println("\n===================================\n|\t\t\t\t  |");
					System.out.println("| ( 1 ) - ADICIONAR VÍDEO FAVORITO|\n|\t\t\t\t  |");
					System.out.println("| ( 2 ) - LISTAR VÍDEO FAVORITO   |\n|\t\t\t\t  |");
					System.out.println("| ( 3 ) - REMOVER VÍDEO FAVORITO  |\n|\t\t\t\t  |");
					System.out.println("| ( 4 ) - ATUALIZAR VÍDEO FAVORITO|\n|\t\t\t\t  |");
					System.out.println("| ( 0 ) - VOLTAR                  |\n|\t\t\t\t  |");
					System.out.println("===================================\n");
					
					System.out.println(" Escolha uma das opções: ");
					opcao5 = entrada.nextInt();
					entrada.nextLine();
					System.out.print("\n");
					switch (opcao5) {
					
					case 1:
						String addFavorito;
						System.out.println("Digite o LINK do vídeo a ser adicionado aos favoritos:");
						addFavorito = entrada.nextLine();
						if(VideosFavoritos.AdicionaFavorito(addFavorito)==true) {
							Main.LimparTela();
							System.out.println("Vídeo adicionado aos Favoritos!");
							System.in.read();
						}else {
							Main.LimparTela();
							System.out.println("Vídeo não localizado!");
							System.in.read();
							}
						
						break;
						
					case 2:
						Main.LimparTela();
						System.out.println("\n=============================================================\n"); 
						for(int i = 0;i<Main.videosfavoritos.size();i++){  
							System.out.println("\nTítulo : " + videosfavoritos.get(i).getNome());
							System.out.println("Link : " + videosfavoritos.get(i).getLink());
							System.out.println("Data : " + videosfavoritos.get(i).getDate());
							System.out.println("Canal : " + videosfavoritos.get(i).getCanal());
							System.out.println("Descrição : " + videosfavoritos.get(i).getDescricao());
											
							System.out.println("\n=============================================================\n"); 
						}											
						System.out.println("Pressione Enter Novamente...");
						System.in.read();
						break;
						
					case 3:
						Main.LimparTela();
						System.out.println("Em Desenvolvimento!!");
						System.out.println("Pressione Enter Novamente...");
						System.in.read();
						/*aux=0;
						String remFavorito;

						System.out.println("Digite o LINK do vídeo a ser removido dos favoritos:");
						remFavorito = entrada.nextLine();

						for(int i = 0; i<videos.size(); i++) {
							if(videos.get(i).getLink().contentEquals(remFavorito)) {
								videosfavoritos.remove(i);
								aux++;
								System.out.println("Vídeo localizado com Sucesso!");
								System.in.read();
								break;
							}
							if(aux == 0) {
								System.out.println("Video não localizado tente novamente!");
								System.in.read();
							}

						}*/
						break;
						
					case 4:
						Main.LimparTela();
						System.out.println("Em Desenvolvimento!!");
						System.out.println("Pressione Enter Novamente...");
						System.in.read();
						/*aux=0;
						String upFavorito;

					

						System.out.println("Digite o LINK do vídeo favorito a ser sobreescrito por outro:");
						upFavorito = entrada.nextLine();

						for(int i = 0; i<videosfavoritos.size(); i++) {
							if(videosfavoritos.get(i).getLink().contentEquals(upFavorito)) {

								System.out.println("Digite o LINK do vídeo favorito a ser adicionado:");
								upFavorito = entrada.nextLine();

								for(int indice = 0; indice<videos.size(); indice++) {
									if(videos.get(indice).getLink().contentEquals(upFavorito)) {
										favorito = Main.videos.get(indice);
										videosfavoritos.add(i, (VideosFavoritos) favorito);
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
					*/
						break;
						
					case 0:					
						break;
					
						}
					}while (opcao5 != 0);
				
				break;
				
// -------------------------------------- SAIR DO PROGRAMA ------------------------------------------------					
			case 0:
				break;
				
				
			default:
				System.out.println("Opção Inválida!");
				
			}	
			
		} while (opcao != 0);
		entrada.close();
		
	}
	
// ------------------------------------ MÉTODO LIMPAR TELA ------------------------------------------------
	
	public static void LimparTela() {
		for(int i = 0; i < 100; i++)
	       System.out.println("");
	}

	public List<Usuarios> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuarios> usuarios) {
		Main.usuarios = usuarios;
	}
	
}
