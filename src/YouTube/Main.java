package YouTube;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import YouTube.entidades.*;

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
						Usuarios.AdicionaUsuario();
						break;
					
					case 2:
						Usuarios.ListarUsuarios();
						break;
						
					case 3:
						Usuarios.RemoverUsuario();
						break;
						
					case 4:
						Usuarios.AtualizarUsuario();
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
						Videos.AdicionaVideos();
						break;
					
					case 2:
						Videos.ListarVideos();
						break;
						
					case 3:
						Videos.AtualizarVideo();
						break;
						
					case 4:
						Videos.RemoverVideo();
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
						Canais.AdicionaCanais();
						break;
						
					case 2:
						Canais.ListarCanais();
						break;
						
					case 3:
						Canais.AtualizarCanal();
						break;
						
					case 4:
						Canais.RemoverCanal();
						break;
						
					case 5:
						PublicoAlvo.AtualizarPublicoAlvo();
						break;
						
					case 0:					
						break;
					
						}
					}while (opcao3 != 0);
				
				break;
				
				
// --------------------------------------- INSCRICOES ----------------------------------------				
				
				
			case 4:
				do {
					
					for(int i = 0; i < 100; i++)
					{
					       System.out.println("");
					}
					System.out.println("\n Caro Usuario selecione uma das opções abaixo: " );
					System.out.println("\n=================================\n|\t\t\t\t|");
					System.out.println("| ( 1 ) - ADICIONAR INSCRICOES  |\n|\t\t\t\t|");
					System.out.println("| ( 2 ) - LISTAR INSCRICOES     |\n|\t\t\t\t|");
					System.out.println("| ( 3 ) - REMOVER INSCRICOES    |\n|\t\t\t\t|");
					System.out.println("| ( 0 ) - VOLTAR                |\n|\t\t\t\t|");
					System.out.println("=================================\n");
					
					System.out.println(" Escolha uma das opções: ");
					opcao4 = entrada.nextInt();
					entrada.nextLine();
					System.out.print("\n");
					switch (opcao4) {
					
					case 1:
						Inscricoes.AdicionaInscricao();
						break;
						
					case 2:
						Inscricoes.ListaInscricao();
						break;
						
					case 3:
						Inscricoes.RemoveInscricao();
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
						VideosFavoritos.AdicionaVideoFavorito();
						break;
						
					case 2:
						VideosFavoritos.ListaVideoFavorito();
						break;
						
					case 3:
						VideosFavoritos.RemoveVideoFavorito();
						break;
						
					case 4:
						VideosFavoritos.AtualizaVideoFavorito();
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
