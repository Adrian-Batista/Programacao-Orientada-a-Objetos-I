package YouTube;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import YouTube.bd.CanalDAO;
import YouTube.bd.InscricaoDAO;
import YouTube.bd.PublicoAlvoDAO;
import YouTube.bd.UsuarioDAO;
import YouTube.bd.UtilBD;
import YouTube.bd.VideoDAO;
import YouTube.entidades.Canal;
import YouTube.entidades.Inscricao;
import YouTube.entidades.Perfil;
import YouTube.entidades.PublicoAlvo;
import YouTube.entidades.Usuario;
import YouTube.entidades.Video;

public class Main {

	public static List<Usuario> usuario = new ArrayList<Usuario>();
	public static List<Video> video = new ArrayList<Video>();
	public static List<Canal> canal = new ArrayList<Canal>();

	public static void main(String[] args) throws IOException {
		
		UtilBD.initBD();
		
		int opcao = 0;
		int opcao2 = 0;
		int opcao3 = 0;
		int opcao4 = 0;
		int opcao5 = 0;
		int cont = 0;
		int aux = 0;
		
		UsuarioDAO objUsuario = new UsuarioDAO();
		CanalDAO objCanal = new CanalDAO();
		InscricaoDAO objInscricao = new InscricaoDAO();
		PublicoAlvoDAO objPublico = new PublicoAlvoDAO();
		VideoDAO objVideo = new VideoDAO();
		
		usuario = objUsuario.todos();
		canal = objCanal.todos();
		video = objVideo.todos();
		
		Scanner entrada = new Scanner(System.in);

		do {

			if(cont>0)
				Main.LimparTela();

			cont++;

			System.out.println("\n\n BEM VINDO AO YOUTUBE ");	
			System.out.println("\n================================= \n|\t\t\t\t|");
			System.out.println("| ( 1 ) - CADASTRAR-SE          | \n|\t\t\t\t|");
			System.out.println("| ( 2 ) - MENU DO USUARIO       | \n|\t\t\t\t|");
			System.out.println("| ( 3 ) - MENU DE VÍDEOS        | \n|\t\t\t\t| ");
			System.out.println("| ( 4 ) - MENU DE CANAIS        | \n|\t\t\t\t| ");
			System.out.println("| ( 5 ) - MENU DE INSCRICOES    | \n|\t\t\t\t| ");
			System.out.println("| ( 0 ) - SAIR                  | \n|\t\t\t\t|");
			System.out.println("=================================\n");

			System.out.println(" Escolha uma das opções: ");
			opcao = entrada.nextInt();
			entrada.nextLine();
			System.out.print("\n");
			
			
			
			switch (opcao) {

			case 1:
				Main.LimparTela();
				Perfil criaUsuario = new Usuario(0, null, null, null);
				
				
				do {
					aux=0;
					System.out.printf("Digite seu nome completo: ");
					criaUsuario.setNome(entrada.nextLine());
					for(int i=0; i<Main.usuario.size(); i++) {
						if(Main.usuario.get(i).getNome().contentEquals(criaUsuario.getNome())) {
							aux++;
							Main.LimparTela();
							System.out.println("Nome ja existente escolha outro..\n");
							break;
						}
					}
				}while(aux!=0);
				
				do {
					aux=0;
					System.out.printf("Digite seu e-mail: ");
					criaUsuario.setEmail(entrada.nextLine());
					for(int i=0; i<Main.usuario.size(); i++) {
						if(Main.usuario.get(i).getEmail().contentEquals(criaUsuario.getEmail())) {
							aux++;
							Main.LimparTela();
							System.out.println("E-mail ja existente escolha outro..\n");
							break;
						}
					}
				}while(aux!=0);
				
				System.out.printf("Digite uma senha: ");
				criaUsuario.setSenha(entrada.nextLine());
				
				Main.usuario.add((Usuario) criaUsuario);
				objUsuario.adicionar((Usuario) criaUsuario);// -- comando que adiciona Usuario no Banco de Dados.
				usuario = objUsuario.todos();
				
				System.out.printf("\nDados Armazenados com sucesso!! \n");
				System.out.println("Pressione Enter Novamente...");
				System.in.read();
				break;

				// ----------------------------------------- LOGIN DE USUARIO ----------------------------------------------
			case 2:

				String user = Usuario.VerificaUsuario();
				if(user==null) {
					System.out.println("Dados incorretos refaça a operação!");
					System.in.read();
					break;
				}
				do {

					Main.LimparTela();
					System.out.println("\n Caro Usuario selecione uma das opções abaixo: " );
					System.out.println("\n=========================================\n|\t\t\t\t\t|");
					System.out.println("| ( 1 ) - LISTAR CADASTRO               |\n|\t\t\t\t\t|");
					System.out.println("| ( 2 ) - REMOVER CADASTRO              |\n|\t\t\t\t\t|");
					System.out.println("| ( 3 ) - ATUALIZAR CADASTRO            |\n|\t\t\t\t\t|");
					System.out.println("| ( 0 ) - VOLTAR                        |\n|\t\t\t\t\t|");
					System.out.println("=========================================\n");
					
					System.out.println(" Escolha uma das opções: ");
					opcao2 = entrada.nextInt();
					entrada.nextLine();
					System.out.print("\n");

					switch (opcao2) {

					case 1:  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~ LISTAR CADASTRO ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
						Main.LimparTela();
						System.out.println("\n=============================================================\n"); 
						for(int i = 0;i<Main.usuario.size();i++){
							if(Main.usuario.get(i).getNome().contentEquals(user)) {
								System.out.println("\nId : " + Main.usuario.get(i).getId());
								System.out.println("Nome : " + Main.usuario.get(i).getNome());
								System.out.println("Email : " + Main.usuario.get(i).getEmail());
								System.out.println("\n=============================================================\n");
							}	
						}	
						System.out.println("\nPressione Enter Novamente...");
						System.in.read();
						break;

					case 2:  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~ REMOVER CADASTRO ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
						Main.LimparTela();
						String nomeRemove = Usuario.VerificaUsuario();
						if(nomeRemove==null) {
							System.out.println("Dados inválidos refaça a operação!");
							System.in.read();
							break;
						}
						for (int indice = 0; indice < usuario.size(); indice++) {
							if (usuario.get(indice).getNome().contentEquals(nomeRemove)) {
								objUsuario.remover(usuario.get(indice)); // -- Removendo Usuario do Banco de Dados!
								Main.usuario.remove(indice);
								usuario = objUsuario.todos();
								System.out.printf("Usuário removido com Sucesso!! \n");
								System.out.println("Pressione Enter Novamente...");
								System.in.read();
							}	
						}
						break;

					case 3: // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ATUALIZAR CADASTRO ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
						Main.LimparTela();
						aux=0;
						String auxiliar=null;
						String usuarioUpdate = Usuario.VerificaUsuario();
						if(usuarioUpdate==null) {
							System.out.println("Dados inválidos refaça a operação!");
							System.in.read();
							break;
						}
						for (int indice = 0; indice < usuario.size(); indice++) {
							if (usuario.get(indice).getNome().contentEquals(usuarioUpdate)) {
								Main.LimparTela();
								System.out.println("\n Caro Usuario selecione uma das opções abaixo: " );
								System.out.println("\n=========================================\n|\t\t\t\t\t|");
								System.out.println("| ( 1 ) - ATUALIZAR NOME                |\n|\t\t\t\t\t|");
								System.out.println("| ( 2 ) - ATUALIZAR E-MAIL              |\n|\t\t\t\t\t|");
								System.out.println("| ( 3 ) - ATUALIZAR SENHA               |\n|\t\t\t\t\t|");
								System.out.println("| ( 0 ) - VOLTAR                        |\n|\t\t\t\t\t|");
								System.out.println("=========================================\n");

								System.out.println(" Escolha uma das opções: ");
								cont = entrada.nextInt();
								entrada.nextLine();
								System.out.print("\n");

								switch(cont) {
								case 1:
									do {
										aux=0;
										System.out.println("Digite a atualização do Nome: ");
										auxiliar = entrada.nextLine();
										for (int indice2 = 0; indice2 < usuario.size(); indice2++) {
											if (usuario.get(indice2).getNome().contentEquals(auxiliar)) {
												Main.LimparTela();
												System.out.println("Nome já existente escolha outro!\n\n");
												aux++;
												break;
											}
										}
										if(aux==0) {
											Main.LimparTela();
											usuario.get(indice).setNome(auxiliar);
											objUsuario.atualizarNome(usuario.get(indice)); // -- Comando que atualiza o Nome
											System.out.println("Dado Alterado com Sucesso!");
											System.in.read();
											break;
										}
									}while(aux!=0);
									opcao2=0;
									break;							

								case 2:
									do {
										aux=0;
										System.out.println("Digite a atualização do E-mail: ");
										auxiliar = entrada.nextLine();
										for (int indice2 = 0; indice2 < usuario.size(); indice2++) {
											if (usuario.get(indice2).getEmail().contentEquals(auxiliar)) {
												Main.LimparTela();
												System.out.println("E-mail já existente escolha outro!\n\n");
												aux++;
												break;
											}
										}
										if(aux==0) {
											Main.LimparTela();
											usuario.get(indice).setEmail(auxiliar);
											objUsuario.atualizarEmail(usuario.get(indice)); // -- Comando que atualiza o Email
											System.out.println("Dado Alterado com Sucesso!");
											System.in.read();
											break;
										}
									}while(aux!=0);
									opcao2=0;
									break;

								case 3:
									System.out.println("Digite a atualização da Senha: ");
									auxiliar = entrada.nextLine();	
									Main.LimparTela();
									usuario.get(indice).setSenha(auxiliar);
									objUsuario.atualizarSenha(usuario.get(indice)); // -- Comando que atualiza o Senha
									System.out.println("Dado Alterado com Sucesso!");
									System.in.read();	
									opcao2=0;
									break;

								case 0:
									break;
								}

								break;

							}

						}
						break;

					case 0:					
						break;

					}


				}while(opcao2!=0);
				break;
				// --------------------------------------- VISUALIZAR VÍDEOS ----------------------------------------

			case 3:

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
					opcao3 = entrada.nextInt();
					entrada.nextLine();
					System.out.print("\n");

					switch (opcao3) {

					case 1:
						Main.LimparTela();

						Video videos = new Video(null, null, null, null, null);
						Canal C = new Canal(null, null, null, null, null);
						videos.setCanal(C);
						int opc= 0;
						aux = 0;
						int aux2 = 0;

						do {
							do {
								System.out.printf("Para adicionar um novo vídeo é necessário um Canal.\n ");
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
								videos.getCanal().setNome(entrada.nextLine());
								aux2 = Canal.VerificarCanalInt(videos.getCanal().getNome());
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
							videos.setNome(entrada.nextLine());			
						}while(Video.VerificaTitulo(videos.getNome()) == true);

						do {
							System.out.printf("Digite o link de acesso: ");
							videos.setLink(entrada.nextLine());
						}while(Video.VerificaLink(videos.getLink()) == true);

						System.out.printf("Digite a data de publicação: ");
						videos.setDate(entrada.nextLine());					
						System.out.printf("Digite uma descrição ao vídeo: ");
						videos.setDescricao(entrada.nextLine());
						
						System.out.println("Digite o valor a ser cobrado pelo vídeo, se for gratuito digite ZERO.");
						videos.setPreco(entrada.nextDouble());

						video.add(videos);
						objVideo.adicionar(videos); // -- Comando que adiciona Video no Banco de Dados Video

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
								System.out.printf("Para adicionar um novo vídeo é necessário um Canal.\n  ");
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
								Video.ListarVideos(null);										
								System.out.println("Pressione Enter Novamente...");
								System.in.read();
								break;

							case 2:
								Main.LimparTela();
								System.out.printf("Digite o nome do Canal:  \n");
								String nomeCanal = entrada.nextLine();
								Video.ListarVideos(nomeCanal);
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
						System.out.println("Em desenvolvimento!");
						System.in.read();
						aux = 0;
						
						System.out.printf("Digite o nome do Video a ser Atualizado:  \n");
						String nomeUpdate = entrada.nextLine();
						
						for (int indice = 0; indice < Main.video.size(); indice++) {
							if (Main.video.get(indice).getNome().contentEquals(nomeUpdate)) {
								aux++;	
								Main.LimparTela();
								Video update = new Video(null, null, null, null, null);
								Canal canal = new Canal(null, null, null, null, null);
								update.setCanal(canal);
								do {
									System.out.printf("Digite o Tíulo do Vídeo: ");
									update.setNome(entrada.nextLine());			
								}while(Video.VerificaTitulo(update.getNome()) == true);

								do {
									System.out.printf("Digite o link de acesso: ");
									update.setLink(entrada.nextLine());
								}while(Video.VerificaLink(update.getLink()) == true);

								System.out.printf("Digite a data de publicação: ");
								update.setDate(entrada.nextLine());					
								System.out.printf("Digite uma descrição ao vídeo: ");
								update.setDescricao(entrada.nextLine());
								
								System.out.println("Digite o valor a ser cobrado pelo vídeo, se for gratuito digite ZERO.");
								update.setPreco(entrada.nextDouble());

								video.set(indice, update);

								System.out.printf("\nDados Armazenados com sucesso!! \n");
								System.out.println("Pressione Enter Novamente...");
								System.in.read();
								break;
							}	
						}
						if(aux==0) {
							System.out.printf("Video não Localizado tente novamente!! \n");
							System.out.println("Pressione Enter ...");
							System.in.read();
							break;
						}
						break;

					case 4:
						Main.LimparTela();
						System.out.printf("Digite o nome do Video a ser removido:  \n");
						String nomeRemove = entrada.nextLine();
						aux = 0;

						for (int indice = 0; indice < Main.video.size(); indice++) {
							if (Main.video.get(indice).getNome().contentEquals(nomeRemove)) {
								aux++;
								objVideo.remover(Main.video.get(indice)); // -- Comando que remove o Video do Banco de Videos
								Main.video.remove(indice);
								System.out.printf("Video removido com Sucesso!! \n");
								System.out.println("Pressione Enter Novamente...");
								System.in.read();
							}	
						}
						if(aux==0) {
							Main.LimparTela();
							System.out.printf("Vídeo não localizado tente novamente!! \n\n");
							System.in.read();
							break;
						}
						break;

					case 0:					
						break;

					}

				}while (opcao3 != 0);

				break;

				// --------------------------------------- MENU CANAIS ----------------------------------------

			case 4:
				do {

					for(int i = 0; i < 100; i++)
					{
						System.out.println("");
					}
					System.out.println("\n Caro Usuario selecione uma das opções abaixo: " );
					System.out.println("\n=========================================\n|\t\t\t\t\t|");
					System.out.println("| ( 1 ) - ADICIONAR CANAL               |\n|\t\t\t\t\t|");
					System.out.println("| ( 2 ) - LISTAR CANAIS                 |\n|\t\t\t\t\t|");
					System.out.println("| ( 3 ) - ATUALIZAR CANAL               |\n|\t\t\t\t\t|");
					System.out.println("| ( 4 ) - REMOVER CANAL                 |\n|\t\t\t\t\t|");
					System.out.println("| ( 0 ) - VOLTAR                        |\n|\t\t\t\t\t|");
					System.out.println("=========================================\n");

					System.out.println(" Escolha uma das opções: ");
					opcao4 = entrada.nextInt();
					entrada.nextLine();
					System.out.print("\n");
					switch (opcao4) {

					case 1: // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ADICIONAR CANAL ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
						Main.LimparTela();

						Canal canais = new Canal(null, null, null, null, null);
						PublicoAlvo P = new PublicoAlvo(null);
						Inscricao I = new Inscricao(null, 0);
						I.setLista(Inscricao.CarregaVetor());
						(canais).setPublico(P);
						(canais).setInscrito(I);

						do {
							System.out.printf("Digite o nome do canal: ");
							canais.setNome(entrada.nextLine());
						}while(Canal.VerificarCanalBoolean(canais.getNome()) == true);
						
						do {
							System.out.printf("Digite um e-mail válido: ");
							canais.setEmail(entrada.nextLine());
						}while(Canal.VerificarEmailCanalBoolean(canais.getEmail()) == true);
						
						System.out.printf("Digite uma descrição para este Canal: ");
						(canais).setDescricao(entrada.nextLine());

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

						PublicoAlvo publico = new PublicoAlvo(null);
						if(escolha==1)
							publico.setOpcao(publico.getOpc1());
						if(escolha==2)
							publico.setOpcao(publico.getOpc2());
						if(escolha==3)
							publico.setOpcao(publico.getOpc3());
						if(escolha==4)
							publico.setOpcao(publico.getOpc4());
						if(escolha==5) 
							publico.setOpcao(publico.getOpc5());
						
						canais.setId(canal.size()+1);
						(canais).getPublico().setOpcao(publico.getOpcao());
						canal.add(canais);
						
						objCanal.adicionar(canais); // -- Comando que adiciona Canal no Banco de Canais
						objPublico.adicionar(canais); // -- Comando que adiciona Publico no Banco de PublicoAlvo
						canal = objCanal.todos();
						
						System.out.printf("\nDados Armazenados com sucesso!! \n");
						System.out.println("Pressione Enter Novamente...");
						break;

					case 2: // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~ LISTAR CANAIS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
						Main.LimparTela();
						System.out.println("\n=============================================================\n"); 
						for(int i = 0;i<canal.size();i++){
							System.out.println("\nNome Canal : " + canal.get(i).getNome());
							System.out.println("E-mail : " + canal.get(i).getEmail());
							System.out.println("Descrição : " + canal.get(i).getDescricao());
							System.out.println("Público Alvo : " + canal.get(i).getPublico().getOpcao());
							System.out.println("Inscritos : " + canal.get(i).getInscrito().getNumeroInscritos());
							System.out.println("\n=============================================================\n"); 
						}
						System.out.println("Pressione Enter Novamente...");
						System.in.read();
						break;

					case 3: // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ATUALIZAR CANAL ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
						System.out.println("Digite o nome do Canal a ser atualizado: ");
						String nomeUpdate = entrada.nextLine();
						String auxiliar = null;
						for(int i=0; i<canal.size();i++) {
							if(canal.get(i).getNome().contentEquals(nomeUpdate)) {
								
								do {
									System.out.printf("Digite o nome do canal: ");
									auxiliar = entrada.nextLine();
								}while(Canal.VerificarCanalBoolean(auxiliar) == true);
								canal.get(i).setNome(auxiliar);
								
								do {
									System.out.printf("Digite um e-mail válido: ");
									auxiliar = (entrada.nextLine());
								}while(Canal.VerificarEmailCanalBoolean(auxiliar) == true);
								canal.get(i).setEmail(auxiliar);
								
								System.out.printf("Digite uma descrição para este Canal: ");
								canal.get(i).setDescricao(entrada.nextLine());

								escolha = 0;
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
								PublicoAlvo publicos = new PublicoAlvo(null);

								if(escolha==1)
									publicos.setOpcao(publicos.getOpc1());
								if(escolha==2)
									publicos.setOpcao(publicos.getOpc2());
								if(escolha==3)
									publicos.setOpcao(publicos.getOpc3());
								if(escolha==4)
									publicos.setOpcao(publicos.getOpc4());
								if(escolha==5) 
									publicos.setOpcao(publicos.getOpc5());

								canal.get(i).getPublico().setOpcao(publicos.getOpcao());
								
								objCanal.atualizar(canal.get(i), nomeUpdate);
								
								System.out.printf("\nDados Armazenados com sucesso!! \n");
								System.out.println("Pressione Enter Novamente...");
										break;
							}
						}
						break;

					case 4: // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~ REMOVER CANAIS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
						Main.LimparTela();
						int contador = 0;
						aux = 0;
						System.out.printf("Digite o nome do Canal a ser removido:  \n");
						String nomeRemove = entrada.nextLine();

						for (int indice = 0; indice < Main.canal.size(); indice++) {
							if (Main.canal.get(indice).getNome().contentEquals(nomeRemove)) {

								for (int indice2 = 0; indice2 < Main.video.size(); indice2++) {
									if (Main.video.get(indice2).getNome().contentEquals(nomeRemove))
										contador++;
								}

								do {
									System.out.printf("O Canal " + nomeRemove +" possui " + contador + " videos, deseja remove-los do Youtube?");
									System.out.println("\n============================================");
									System.out.println("|  1 - Remover tudo                       | ");
									System.out.println("|  2 - Voltar                             | ");
									System.out.println("============================================\n");
									aux = entrada.nextInt();

									if(aux==1) {
										for (int indice2 = 0; indice2 < Main.video.size(); indice2++) {
											if (Main.video.get(indice2).getNome().contentEquals(nomeRemove)) {
												Main.video.remove(indice2);
												indice2--;
											}
										}
										
										objCanal.remover(Main.canal.get(indice)); // -- remove o Canal do Banco de Canal
										objPublico.remover(Main.canal.get(indice)); // -- remove o Publico do Banco de Publicos
										Main.canal.remove(indice);
										canal = objCanal.todos();

										Main.LimparTela();
										System.out.printf("Canal removido com Sucesso!! \n");
										System.out.println("Pressione Enter Novamente...");
										System.in.read();
										break;
									}
									if(aux==2) {
										contador++;
										break;
									}

								}while(aux !=1 || aux!=2);

							}

						}
						if(contador==0) {
							Main.LimparTela();
							System.out.printf("Canal não localizado tente novamente!! \n");
							System.in.read();
							break;
						}
						break;


					case 0:					
						break;

					}
				}while (opcao4 != 0);

				break;


				// --------------------------------------- INSCRICOES ----------------------------------------				


			case 5:
				do {
					int quant = 0;
					Main.LimparTela();
					System.out.println("\n Caro Usuario selecione uma das opções abaixo: " );
					System.out.println("\n=========================================\n|\t\t\t\t\t|");
					System.out.println("| ( 1 ) - ADICIONAR INSCRICOES          |\n|\t\t\t\t\t|");
					System.out.println("| ( 2 ) - REMOVER INSCRICOES            |\n|\t\t\t\t\t|");
					System.out.println("| ( 3 ) - LISTAR INSCRIÇÕES DE UM CANAL |\n|\t\t\t\t\t|");
					System.out.println("| ( 0 ) - VOLTAR                        |\n|\t\t\t\t\t|");
					System.out.println("=========================================\n");

					System.out.println(" Escolha uma das opções: ");
					opcao5 = entrada.nextInt();
					entrada.nextLine();
					System.out.print("\n");
					switch (opcao5) {

					case 1: // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ADICIONAR INSCRIÇÕES ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
						Main.LimparTela();
						int opc = 0;
						aux = 0;				

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
							String auxiliar = entrada.nextLine();
							for (int indice = 0; indice < Main.canal.size(); indice++) {
								if (Main.canal.get(indice).getNome().contentEquals(auxiliar)) {	
									System.out.println("Para se inscrever vamos lhe solicitar seus dados.");

									String NomeUsuario = Usuario.VerificaUsuario();
									
									if(NomeUsuario != null) {
										for(int i=0; i< Main.canal.size(); i++) {
											if(Main.canal.get(i).getNome().contentEquals(auxiliar)) {
												for(int j =0; j<canal.get(i).getInscrito().getLista().length;j++) {
													if(canal.get(i).getInscrito().getLista()[j].getNome()==null) {
														canal.get(i).getInscrito().getLista()[j].setNome(NomeUsuario);
														quant = canal.get(i).getInscrito().getNumeroInscritos();
														quant++;
														canal.get(i).getInscrito().setNumeroInscritos(quant);
														objInscricao.adicionar(canal.get(indice)); // - adicionando dados na Tabela Inscricao 
														System.out.println("Dados armazenados com sucesso!");
														System.in.read();
														break;
													}
												}
											}
										}
									}
									if(NomeUsuario ==null) {
										Main.LimparTela();
										System.out.printf("Dados Incorretos refaça a operação!! \n\n");
										System.in.read();
										break;
									}
								}else {
									Main.LimparTela();
									System.out.println("Não Localizado!");
									System.in.read();
									break;
								}
							}
							
						}
						break;

					case 2: // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~ REMOVER INSCRIÇÕES ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
						Main.LimparTela();
						aux = 0;
						int aux2 = 0;


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

									for (int indice = 0; indice < Main.canal.size(); indice++) {
										if (Main.canal.get(indice).getNome().contentEquals(canalBusca)) {
											aux2++;
											String nomeUsuario = Usuario.VerificaUsuario();
											for(int i= 0; i < canal.get(indice).getInscrito().getLista().length; i++) {
												if(canal.get(indice).getInscrito().getLista()[i].getNome().equals(nomeUsuario)) {
													canal.get(indice).getInscrito().getLista()[i].setNome(null);
													quant = canal.get(indice).getInscrito().getNumeroInscritos();
													quant--;
													canal.get(indice).getInscrito().setNumeroInscritos(quant);
													objInscricao.removerInscricao(canal.get(indice), nomeUsuario);
													canal = objCanal.todos();
													System.out.println("Dados removidos!");
													System.in.read();
													break;
												}
												
											}
											
										}
									}
									if(aux2==0) {
										Main.LimparTela();
										System.out.printf("Canal não localizado tente novamente!! \n\n");
										System.in.read();
										break;
									}

							}
						break;
						
					case 3: // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~ LISTAR INSCRIÇÕES ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
						
						int n =0;
						System.out.println("Digite o Nome do Canal: ");
						String nomeCanal = entrada.nextLine();
						System.out.println(" ) Lista de Inscritos do Canal: "+ nomeCanal);
						System.out.println("\n=============================================================\n");
						for(int i = 0;i<Main.canal.size();i++){  
							if(Main.canal.get(i).getNome().contentEquals(nomeCanal)) {
								for(int j =0; j<canal.get(i).getInscrito().getLista().length; j++) {
									if(Main.canal.get(i).getInscrito().getLista()[j].getNome()==null) {
										break;
									}
									n++;
									System.out.println(n+" ) Nome Inscrito: "+ Main.canal.get(i).getInscrito().getLista()[j].getNome());
								}
							}
						}
						if(n==0) {
							System.out.println("Canal não Localizado!");
							System.in.read();
							break;
						}
						System.out.println("\n=============================================================\n");
						System.out.println("Pressione Enter Novamente...");
						System.in.read();
						
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
				System.out.println("Pressione Enter.!");
				System.in.read();

			}	

		} while (opcao != 0);
		entrada.close();
		UtilBD.fecharConexao();

	}

	// ------------------------------------ MÉTODO LIMPAR TELA ------------------------------------------------

	public static void LimparTela() {
		for(int i = 0; i < 100; i++)
			System.out.println("");
	}

}
