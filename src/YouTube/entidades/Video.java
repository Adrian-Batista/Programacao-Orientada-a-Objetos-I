package YouTube.entidades;

import YouTube.Main;

public class Video{

	private String nome;
	private String link;
	private String date;
	private Canal canal;
	private String descricao;
	private double preco;


	public Video(String nome, String link, String date, Canal canal, String descricao, double preco) {
		super();
		this.nome = nome;
		this.link = link;
		this.date = date;
		this.canal = canal;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	public Video(String nome, String link, String date, Canal canal, String descricao) {
		super();
		this.nome = nome;
		this.link = link;
		this.date = date;
		this.canal = canal;
		this.descricao = descricao;
		this.preco = 0;
	}

	public static boolean VerificaTitulo(String auxiliar) {
		for (int indice = 0; indice < Main.video.size(); indice++) {
			if (Main.video.get(indice).getNome().contentEquals(auxiliar)){
				System.out.printf("\nO Título escolhido ja está em uso, selecione outro:\n\n ");
				return true;
			}		
		}
		return false;
	}

	public static boolean VerificaLink(String auxiliar) {
		for (int indice = 0; indice < Main.video.size(); indice++) {
			if (Main.video.get(indice).getLink().contentEquals(auxiliar)){
				System.out.printf("\nO Link escolhido ja está em uso, selecione outro:\n\n ");
				return true;
			}
		}
		return false;
	}

	public static void ListarVideos(String auxiliar) {
		int cont=0;
		if(auxiliar==null) {
			System.out.println("\n=============================================================\n"); 
			for(int i = 0;i<Main.video.size();i++){  
				System.out.println("\nTítulo : " + Main.video.get(i).getNome());
				System.out.println("Link : " + Main.video.get(i).getLink());
				System.out.println("Data : " + Main.video.get(i).getDate());
				System.out.println("Canal : " + Main.video.get(i).getCanal().getNome());
				System.out.println("Descrição : " + Main.video.get(i).getDescricao());				
				System.out.println("\n=============================================================\n"); 
			}
		}else{
			System.out.println("\n=============================================================\n"); 
			for (int i = 0; i < Main.video.size(); i++) {
				if (Main.video.get(i).getCanal().getNome().contentEquals(auxiliar)) {
					cont++;
					System.out.println("\nTítulo : " + Main.video.get(i).getNome());
					System.out.println("Link : " + Main.video.get(i).getLink());
					System.out.println("Data : " + Main.video.get(i).getDate());
					System.out.println("Canal : " + Main.video.get(i).getCanal().getNome());
					System.out.println("Descrição : " + Main.video.get(i).getDescricao());					
					System.out.println("\n=============================================================\n"); 
				}	
			}
			if(cont==0) {
				Main.LimparTela();
				System.out.printf("Canal não localizado tente novamente!! \n\n");

			}	
		}	
	}

	//---------------------------------------- GETTERS E SETTERS ---------------------------------------------



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


	public Canal getCanal() {
		return canal;
	}


	public void setCanal(Canal canal) {
		this.canal = canal;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}
