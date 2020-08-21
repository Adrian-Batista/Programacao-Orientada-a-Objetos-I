package YouTube.entidades;

import java.io.IOException;
import java.util.Scanner;

import YouTube.Main;

public class Inscricoes {
	
	private String nomeCanalInscr;
	

	public Inscricoes() {
		this.setNomeCanalInscr(nomeCanalInscr);
	}

	static Scanner entrada = new Scanner(System.in);
	
	// -----------------------------------------------------------------------------------
	
		public static void AdicionaInscricao () throws IOException {
			
			Main.LimparTela();
			Inscricoes inscricao = new Inscricoes();
			int opc = 0;
			int aux = 0;
			int aux2 = 0;
							
			
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
					
					
						for (int indice = 0; indice < Main.canais.size(); indice++) {
							if (Main.canais.get(indice).getNomeCanal().contentEquals(canalBusca)) {
								aux2++;
								inscricao.setNomeCanalInscr(canalBusca);
								Main.inscricoes.add(inscricao);
							
								Main.LimparTela();
								System.out.printf("Canal Localizado com Sucesso!! \n");
								System.out.printf("Agora você é um inscrito!! \n");
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
							
				}
		}
		
	// -----------------------------------------------------------------------------
		public static void ListaInscricao () throws IOException {
			
			Main.LimparTela();
			
			System.out.println("\n=============================================================\n"); 
			for(int i = 0;i<Main.inscricoes.size();i++){  
				System.out.println("\nCanal : " + Main.inscricoes.get(i).getNomeCanalInscr());		
				System.out.println("\n=============================================================\n");
			}
			 
											
			System.out.println("Pressione Enter Novamente...");
			System.in.read();
		
		}
		
	// -----------------------------------------------------------------------------
	
		public String getNomeCanalInscr() {
		return nomeCanalInscr;
	}


	public void setNomeCanalInscr(String nomeCanalInscr) {
		this.nomeCanalInscr = nomeCanalInscr;
	}

}
