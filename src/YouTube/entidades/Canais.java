package YouTube.entidades;

import java.io.IOException;
import java.util.Scanner;

import YouTube.Main;

public class Canais {
	
	private String nomeCanal;
	private String autorCanal;
	private String descricaoCanal;
	private String dataCanal;
	private String publicoAlvoCanal;
	

	public Canais() {
		this.setNomeCanal(nomeCanal);
		this.setAutorCanal(autorCanal);
		this.setDescricaoCanal(descricaoCanal);
		this.setPublicoAlvoCanal(publicoAlvoCanal);
	}

	
static Scanner entrada = new Scanner(System.in);
	
	//-------------------------------------------------------------------------------
	
		public static void AdicionaCanais () throws IOException {
			Main.LimparTela();
			
			Canais canal = new Canais();
			
			System.out.printf("Digite o nome do Canal: ");
			canal.setNomeCanal(entrada.nextLine());
			
			System.out.printf("Digite seu Nome: ");
			canal.setAutorCanal(entrada.nextLine());
			
			System.out.printf("Digite uma descrição para este Canal: ");
			canal.setDescricaoCanal(entrada.nextLine());
			
			System.out.printf("Digite o seu Público Alvo: ");
			canal.setPublicoAlvoCanal(entrada.nextLine());
			
			Main.canais.add(canal);
			
			System.out.printf("\nDados Armazenados com sucesso!! \n");
			System.out.println("Pressione Enter Novamente...");
			System.in.read();
		}
		
		
		//-------------------------------------------------------------------------------
		
		public static void ListarCanais () throws IOException {
			
			Main.LimparTela();
					
			System.out.println("\n=============================================================\n"); 
			for(int i = 0;i<Main.canais.size();i++){  
				System.out.println("\nNome Canal : " + Main.canais.get(i).getNomeCanal());
				System.out.println("Autor : " + Main.canais.get(i).getAutorCanal());
				System.out.println("Descrição : " + Main.canais.get(i).getDescricaoCanal());
				System.out.println("Público Alvo : " + Main.canais.get(i).getPublicoAlvoCanal());
								
				System.out.println("\n=============================================================\n"); 
			}
					
													
			System.out.println("Pressione Enter Novamente...");
			System.in.read();
		}	
		
		//-------------------------------------------------------------------------------
	

	public String getNomeCanal() {
		return nomeCanal;
	}


	public void setNomeCanal(String nomeCanal) {
		this.nomeCanal = nomeCanal;
	}


	public String getAutorCanal() {
		return autorCanal;
	}


	public void setAutorCanal(String autorCanal) {
		this.autorCanal = autorCanal;
	}


	public String getDescricaoCanal() {
		return descricaoCanal;
	}


	public void setDescricaoCanal(String descricaoCanal) {
		this.descricaoCanal = descricaoCanal;
	}


	public String getDataCanal() {
		return dataCanal;
	}


	public void setDataCanal(String dataCanal) {
		this.dataCanal = dataCanal;
	}


	public String getPublicoAlvoCanal() {
		return publicoAlvoCanal;
	}


	public void setPublicoAlvoCanal(String publicoAlvoCanal) {
		this.publicoAlvoCanal = publicoAlvoCanal;
	}

}
