package YouTube;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		int opcao = 0;
		int opcao1 =0;
		int opcao2 = 0;
		int opcao3 = 0;
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
					System.out.println("| ( 2 ) - ADICIONAR VÍDEO FAVORITO      |\n|\t\t\t\t\t|");
					System.out.println("| ( 3 ) - LISTAR VÍDEO FAVORITO         |\n|\t\t\t\t\t|");
					System.out.println("| ( 4 ) - REMOVER VÍDEO FAVORITO        |\n|\t\t\t\t\t|");
					System.out.println("| ( 0 ) - VOLTAR                        |\n|\t\t\t\t\t|");
					System.out.println("=========================================\n");
				
					System.out.println(" Escolha uma das opções: ");
					opcao1 = entrada.nextInt();
					entrada.nextLine();
					System.out.print("\n");
					
					switch (opcao1) {
					
					case 1:			
						break;
					
					case 2:
						break;
					
					case 3:					
						break;
					
					case 4:			
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
					System.out.println("| ( 1 ) - LISTAR VÍDEOS         |\n|\t\t\t\t|");
					System.out.println("| ( 2 ) - ADICIONAR VÍDEO       |\n|\t\t\t\t|");
					System.out.println("| ( 3 ) - REMOVER VÍDEO         |\n|\t\t\t\t|");
					System.out.println("| ( 4 ) - ATUALIZAR VÍDEO       |\n|\t\t\t\t|");
					System.out.println("| ( 0 ) - VOLTAR                |\n|\t\t\t\t|");
					System.out.println("=================================\n");
				
					System.out.println(" Escolha uma das opções: ");
					opcao2 = entrada.nextInt();
					entrada.nextLine();
					System.out.print("\n");
								
					switch (opcao2) {
				
					case 1:
						break;
					
					case 2:
						break;
					
					case 3:					
						break;
					
					case 4:		
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
					System.out.println("| ( 1 ) - LISTAR CANAIS         |\n|\t\t\t\t|");
					System.out.println("| ( 2 ) - ADICIONAR CANAL       |\n|\t\t\t\t|");
					System.out.println("| ( 3 ) - REMOVER CANAL         |\n|\t\t\t\t|");
					System.out.println("| ( 4 ) - ATUALIZAR CANAL       |\n|\t\t\t\t|");
					System.out.println("| ( 0 ) - VOLTAR                |\n|\t\t\t\t|");
					System.out.println("=================================\n");
					
					System.out.println(" Escolha uma das opções: ");
					opcao3 = entrada.nextInt();
					entrada.nextLine();
					System.out.print("\n");
					switch (opcao3) {
					
					case 1:
						break;
						
					case 2:
						break;
						
					case 3:
						break;
						
					case 4:
						break;
						
					case 0:					
						break;
					
						}
					}while (opcao3 != 0);
				
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

	
}
