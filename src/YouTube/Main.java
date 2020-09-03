package YouTube;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import YouTube.entidades.Canal;
import YouTube.entidades.Inscricao;
import YouTube.entidades.PublicoAlvo;
import YouTube.entidades.Usuario;
import YouTube.entidades.Video;

public class Main {

	public static List<Usuario> usuario = new ArrayList<Usuario>();
	public static List<Video> video = new ArrayList<Video>();
	public static List<Canal> canal = new ArrayList<Canal>();
	public static List<Inscricao> inscricao = new ArrayList<Inscricao>();


	public static void main(String[] args) throws IOException {
		int opcao = 0;
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
			System.out.println("| ( 1 ) - CADASTRAR-SE          | \n|\t\t\t\t|");
			System.out.println("| ( 2 ) - MENU DO USUARIO       | \n|\t\t\t\t|");
			System.out.println("| ( 3 ) - MENU DE V�DEOS        | \n|\t\t\t\t| ");
			System.out.println("| ( 4 ) - MENU DE CANAIS        | \n|\t\t\t\t| ");
			System.out.println("| ( 5 ) - MENU DE INSCRICOES    | \n|\t\t\t\t| ");
			System.out.println("| ( 0 ) - SAIR                  | \n|\t\t\t\t|");
			System.out.println("=================================\n");

			System.out.println(" Escolha uma das op��es: ");
			opcao = entrada.nextInt();
			entrada.nextLine();
			System.out.print("\n");

			switch (opcao) {

			case 1:
				Main.LimparTela();
				Usuario.AdicionarUsuario();
				System.out.printf("\nDados Armazenados com sucesso!! \n");
				System.out.println("Pressione Enter Novamente...");
				System.in.read();
				break;

				// ----------------------------------------- LOGIN DE USUARIO ----------------------------------------------
			case 2:

				String user = Usuario.VerificaUsuario();
				if(user==null) {
					System.out.println("Dados incorretos refa�a a opera��o!");
					System.in.read();
					break;
				}
				do {

					Main.LimparTela();
					System.out.println("\n Caro Usuario selecione uma das op��es abaixo: " );
					System.out.println("\n=========================================\n|\t\t\t\t\t|");
					System.out.println("| ( 1 ) - LISTAR CADASTRO               |\n|\t\t\t\t\t|");
					System.out.println("| ( 2 ) - REMOVER CADASTRO              |\n|\t\t\t\t\t|");
					System.out.println("| ( 3 ) - ATUALIZAR CADASTRO            |\n|\t\t\t\t\t|");
					System.out.println("| ( 0 ) - VOLTAR                        |\n|\t\t\t\t\t|");
					System.out.println("=========================================\n");

					System.out.println(" Escolha uma das op��es: ");
					opcao2 = entrada.nextInt();
					entrada.nextLine();
					System.out.print("\n");

					switch (opcao2) {

					case 1:
						Main.LimparTela();		
						Usuario.ListarUsuario(user);					
						System.out.println("Pressione Enter Novamente...");
						System.in.read();
						break;

					case 2:
						Main.LimparTela();
						String nomeRemove = Usuario.VerificaUsuario();
						if(nomeRemove==null) {
							System.out.println("Dados inv�lidos refa�a a opera��o!");
							System.in.read();
							break;
						}
						for (int indice = 0; indice < usuario.size(); indice++) {
							if (usuario.get(indice).getNome().contentEquals(nomeRemove)) {
								Main.usuario.remove(indice);
								System.out.printf("Usu�rio removido com Sucesso!! \n");
								System.out.println("Pressione Enter Novamente...");
								System.in.read();
							}	
						}
						break;

					case 3:
						Main.LimparTela();
						int aux=0;
						String auxiliar=null;
						String usuarioUpdate = Usuario.VerificaUsuario();
						if(usuarioUpdate==null) {
							System.out.println("Dados inv�lidos refa�a a opera��o!");
							System.in.read();
							break;
						}
						for (int indice = 0; indice < usuario.size(); indice++) {
							if (usuario.get(indice).getNome().contentEquals(usuarioUpdate)) {
								Main.LimparTela();
								System.out.println("\n Caro Usuario selecione uma das op��es abaixo: " );
								System.out.println("\n=========================================\n|\t\t\t\t\t|");
								System.out.println("| ( 1 ) - ATUALIZAR NOME                |\n|\t\t\t\t\t|");
								System.out.println("| ( 2 ) - ATUALIZAR E-MAIL              |\n|\t\t\t\t\t|");
								System.out.println("| ( 3 ) - ATUALIZAR SENHA               |\n|\t\t\t\t\t|");
								System.out.println("| ( 0 ) - VOLTAR                        |\n|\t\t\t\t\t|");
								System.out.println("=========================================\n");

								System.out.println(" Escolha uma das op��es: ");
								cont = entrada.nextInt();
								entrada.nextLine();
								System.out.print("\n");

								switch(cont) {
								case 1:
									do {
										aux=0;
										System.out.println("Digite a atualiza��o do Nome: ");
										auxiliar = entrada.nextLine();
										for (int indice2 = 0; indice2 < usuario.size(); indice2++) {
											if (usuario.get(indice2).getNome().contentEquals(auxiliar)) {
												Main.LimparTela();
												System.out.println("Nome j� existente escolha outro!\n\n");
												aux++;
												break;
											}
										}
										if(aux==0) {
											Main.LimparTela();
											usuario.get(indice).setNome(auxiliar);
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
										System.out.println("Digite a atualiza��o do E-mail: ");
										auxiliar = entrada.nextLine();
										for (int indice2 = 0; indice2 < usuario.size(); indice2++) {
											if (usuario.get(indice2).getEmail().contentEquals(auxiliar)) {
												Main.LimparTela();
												System.out.println("Nome j� existente escolha outro!\n\n");
												aux++;
												break;
											}
										}
										if(aux==0) {
											Main.LimparTela();
											usuario.get(indice).setEmail(auxiliar);
											System.out.println("Dado Alterado com Sucesso!");
											System.in.read();
											break;
										}
									}while(aux!=0);
									opcao2=0;
									break;

								case 3:
									break;

								case 0:
									break;
								}

								break;

							}

						}

					case 0:					
						break;

					}


				}while(opcao2!=0);
				break;
				// --------------------------------------- VISUALIZAR V�DEOS ----------------------------------------

			case 3:

				do {
					Main.LimparTela();

					System.out.println("\n Caro Usuario selecione uma das op��es abaixo: " );
					System.out.println("\n=================================\n|\t\t\t\t|");
					System.out.println("| ( 1 ) - ADICIONAR V�DEO       |\n|\t\t\t\t|");
					System.out.println("| ( 2 ) - LISTAR V�DEOS         |\n|\t\t\t\t|");
					System.out.println("| ( 3 ) - ATUALIZAR V�DEO       |\n|\t\t\t\t|");
					System.out.println("| ( 4 ) - REMOVER V�DEO         |\n|\t\t\t\t|");
					System.out.println("| ( 0 ) - VOLTAR                |\n|\t\t\t\t|");
					System.out.println("=================================\n");

					System.out.println(" Escolha uma das op��es: ");
					opcao3 = entrada.nextInt();
					entrada.nextLine();
					System.out.print("\n");

					switch (opcao3) {

					case 1:
						Main.LimparTela();

						Video videos = new Video();
						Canal C = new Canal();
						videos.setCanal(C);
						int opc= 0;
						int aux = 0;
						int aux2 = 0;

						do {
							do {
								System.out.printf("Para adicionar um novo v�deo � necess�rio um Canal.\n Voce ja tem um Canal ou deseja criar um? ");
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
								videos.getCanal().setNomecanal(entrada.nextLine());
								aux2 = Canal.VerificarCanalInt(videos.getCanal().getNomecanal());
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
							System.out.printf("Digite o T�ulo do V�deo: ");
							videos.setNome(entrada.nextLine());			
						}while(Video.VerificaTitulo(videos.getNome()) == true);

						do {
							System.out.printf("Digite o link de acesso: ");
							videos.setLink(entrada.nextLine());
						}while(Video.VerificaLink(videos.getLink()) == true);

						System.out.printf("Digite a data de publica��o: ");
						videos.setDate(entrada.nextLine());					
						System.out.printf("Digite uma descri��o ao v�deo: ");
						videos.setDescricao(entrada.nextLine());

						video.add(videos);

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
								System.out.printf("Para adicionar um novo v�deo � necess�rio um Canal.\n Voce ja tem um Canal ou deseja criar um? ");
								System.out.println("\n============================================");
								System.out.println("|  1 - Listar todos os v�deos             | ");
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
									System.out.printf("Digite o T�ulo do V�deo: ");
									verificador = (entrada.nextLine());
									for (int indice2 = 0; indice2 < Main.videos.size(); indice2++) {
										if (Main.videos.get(indice2).getNome().contentEquals(verificador)){
											aux3++;
											System.out.printf("\nO T�tulo escolhido ja est� em uso, selecione outro:\n\n ");
											break;
										}
									}
									if(aux3==0) {
										Main.videos.get(indice).setNome(verificador);
									}

								}while(aux3 != 0);

								do {
									aux3=0;
									System.out.printf("Digite o Link do V�deo: ");
									verificador = (entrada.nextLine());
									for (int indice2 = 0; indice2 < Main.videos.size(); indice2++) {
										if (Main.videos.get(indice2).getLink().contentEquals(verificador)){
											aux3++;
											System.out.printf("\nO Link escolhido ja est� em uso, selecione outro:\n\n ");
											break;
										}
									}
									if(aux3==0) {
										Main.videos.get(indice).setLink(verificador);
									}

								}while(aux3 != 0);

								System.out.printf("Digite a data de publica��o: ");
								Main.videos.get(indice).setDate(entrada.nextLine());

								System.out.printf("Digite o g�nero do seu v�deo: ");
								Main.videos.get(indice).setDescricao(entrada.nextLine());

								System.out.printf("Digite o valor que ser� cobrado pelo seu v�deo, caso for gratuito digite 0: ");
								Main.videos.get(indice).setPrecoVideo(entrada.nextDouble());

								System.out.printf("Dados Armazenados com sucesso!! \n");
								System.out.println("Pressione Enter Novamente...");
								System.in.read();
								break;
							}	
						}
						if(aux==0) {
							System.out.printf("Video n�o Localizado tente novamente!! \n");
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
							System.out.printf("V�deo n�o localizado tente novamente!! \n\n");
							System.in.read();
							return;
						}*/
						break;

					case 0:					
						break;

					}

				}while (opcao3 != 0);

				break;

				// --------------------------------------- VISUALIZAR CANAIS ----------------------------------------

			case 4:
				do {

					for(int i = 0; i < 100; i++)
					{
						System.out.println("");
					}
					System.out.println("\n Caro Usuario selecione uma das op��es abaixo: " );
					System.out.println("\n=========================================\n|\t\t\t\t\t|");
					System.out.println("| ( 1 ) - ADICIONAR CANAL               |\n|\t\t\t\t\t|");
					System.out.println("| ( 2 ) - LISTAR CANAIS                 |\n|\t\t\t\t\t|");
					System.out.println("| ( 3 ) - LISTAR INSCRI��ES DE UM CANAL |\n|\t\t\t\t\t|");
					System.out.println("| ( 4 ) - ATUALIZAR CANAL               |\n|\t\t\t\t\t|");
					System.out.println("| ( 5 ) - REMOVER CANAL                 |\n|\t\t\t\t\t|");
					System.out.println("| ( 6 ) - ATUALIZAR P�BLICO ALVO        |\n|\t\t\t\t\t|");
					System.out.println("| ( 0 ) - VOLTAR                        |\n|\t\t\t\t\t|");
					System.out.println("=========================================\n");

					System.out.println(" Escolha uma das op��es: ");
					opcao4 = entrada.nextInt();
					entrada.nextLine();
					System.out.print("\n");
					switch (opcao4) {

					case 1:
						Main.LimparTela();

						Canal canais = new Canal();
						Usuario U = new Usuario();
						PublicoAlvo P = new PublicoAlvo();
						Inscricao I = new Inscricao();
						canais.setUsuario(U);
						canais.setPublico(P);
						canais.setInscritos(I);

						do {
							System.out.printf("Digite o nome do canal: ");
							canais.setNomecanal(entrada.nextLine());
						}while(Canal.VerificarCanalBoolean(canais.getNomecanal()) == true);
						System.out.printf("Digite o seu nome: ");
						canais.getUsuario().setNome(entrada.nextLine());

						System.out.printf("Digite uma descri��o para este Canal: ");
						canais.setDescricao(entrada.nextLine());

						int escolha = 0;
						Main.LimparTela();
						System.out.println("\n Usuario selecione o publico alvo dos seu Canal: " );
						System.out.println("\n============================================");
						System.out.println("|  1 - Crian�as (abaixo de 12 anos)        | ");
						System.out.println("|  2 - Jovens   (13 a 24 anos)             | ");
						System.out.println("|  3 - Adultos  (25 a 50 anos)             | ");
						System.out.println("|  4 - Idosos   (acima de 51 anos)         | ");
						System.out.println("|  5 - Todos                               | ");
						System.out.println("============================================\n");

						do {
							System.out.println(" Escolha uma das op��es: ");
							escolha = entrada.nextInt();
							entrada.nextLine();

						}while(escolha<1 || escolha>5);

						PublicoAlvo publico = new PublicoAlvo();
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

						canais.getPublico().setOpcao(publico.getOpcao());
						canal.add(canais);

						System.out.printf("\nDados Armazenados com sucesso!! \n");
						System.out.println("Pressione Enter Novamente...");
						break;

					case 2:
						Main.LimparTela();

						System.out.println("\n=============================================================\n"); 
						for(int i = 0;i<Main.canal.size();i++){  
							System.out.println("\nNome Canal : " + canal.get(i).getNomecanal());
							System.out.println("Autor : " + canal.get(i).getUsuario().getNome());
							System.out.println("Descri��o : " + canal.get(i).getDescricao());
							System.out.println("P�blico Alvo : " + canal.get(i).getPublico().getOpcao());
							System.out.println("Inscritos : " + canal.get(i).getInscritos().getNumeroInscritos());
							System.out.println("\n=============================================================\n"); 
						}
						System.out.println("Pressione Enter Novamente...");
						System.in.read();
						break;

					case 3:
						int n =0;
						System.out.println("Digite o Nome do Canal: ");
						String auxiliar = entrada.nextLine();
						System.out.println(" ) Lista de Inscritos do Canal: "+ auxiliar);
						System.out.println("\n=============================================================\n");
						for(int i = 0;i<Main.inscricao.size();i++){  
							if(Main.inscricao.get(i).getNomeCanal().getNomecanal().contentEquals(auxiliar)) {
								n++;
								System.out.println(n+" ) Nome Inscrito: "+ Main.inscricao.get(i).getNomeUsuario().getNome());
							}


						}
						System.out.println("\n=============================================================\n");
						System.out.println("Pressione Enter Novamente...");
						System.in.read();
						break;

					case 4:
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

								System.out.printf("Digite uma descri��o para este Canal: ");
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
							System.out.printf("Canal n�o Localizado tente novamente!! \n");
							System.out.println("Pressione Enter ...");
							System.in.read();
							return;
						}*/
						break;

					case 5:
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
							System.out.printf("Canal n�o localizado tente novamente!! \n");
							System.in.read();
							return;
						}*/
						break;

					case 6:
						Main.LimparTela();
						System.out.println("Em Desenvolvimento!!");
						System.out.println("Pressione Enter Novamente...");
						System.in.read();
						/*PublicoAlvo.AtualizarPublicoAlvo();*/
						break;

					case 0:					
						break;

					}
				}while (opcao4 != 0);

				break;


				// --------------------------------------- INSCRICOES ----------------------------------------				


			case 5:
				do {
					Main.LimparTela();
					System.out.println("\n Caro Usuario selecione uma das op��es abaixo: " );
					System.out.println("\n=================================\n|\t\t\t\t|");
					System.out.println("| ( 1 ) - ADICIONAR INSCRICOES  |\n|\t\t\t\t|");
					System.out.println("| ( 2 ) - REMOVER INSCRICOES    |\n|\t\t\t\t|");
					System.out.println("| ( 3 ) - LISTAR INSCRICOES     |\n|\t\t\t\t|");
					System.out.println("| ( 0 ) - VOLTAR                |\n|\t\t\t\t|");
					System.out.println("=================================\n");

					System.out.println(" Escolha uma das op��es: ");
					opcao5 = entrada.nextInt();
					entrada.nextLine();
					System.out.print("\n");
					switch (opcao5) {

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
							Inscricao.RealizarInscricao(canalBusca);		
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
								System.out.printf("Para remover a inscri��o em um canal: ");
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
											System.out.printf("Agora voc� n�o � mais inscrito deste Canal!! \n");
											System.out.println("Pressione Enter Novamente...\n\n");
											System.in.read();
											break;
										}
									}

									if(aux2==0) {
										Main.LimparTela();
										System.out.printf("Canal n�o localizado tente novamente!! \n\n");
										System.in.read();
										break;
									}

							}*/
						break;

					case 3:
						Main.LimparTela();
						aux=1;

						System.out.println("\n=============================================================\n"); 
						for(int i = 0;i<Main.inscricao.size();i++){  
							System.out.println("\n"+aux+" ) Canal : " + inscricao.get(i).getNomeCanal().getNomecanal());

							System.out.println("\n=============================================================\n");
							aux++;
						}


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
				System.out.println("Op��o Inv�lida!");
				System.out.println("Pressione Enter.!");
				System.in.read();

			}	

		} while (opcao != 0);
		entrada.close();

	}

	// ------------------------------------ M�TODO LIMPAR TELA ------------------------------------------------

	public static void LimparTela() {
		for(int i = 0; i < 100; i++)
			System.out.println("");
	}

}
