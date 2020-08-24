package YouTube.entidades;

import java.io.IOException;
import java.util.Scanner;

import YouTube.Main;



public class Canais {

	private String nome;
	private String autor;
	private String email;
	private String descricao;
	private String publicoAlvo;
	private int inscritos;
	static String auxiliar;


	public Canais(String Nome, String Email) {
		setNome(nome);
		setEmail(email);
	}
	
	public Canais() {
		setNome(nome);
		setAutor(autor);
		setEmail(email);
		setDescricao(descricao);
		setInscritos(0);
		setPublicoAlvo(publicoAlvo);
	}



	static Scanner entrada = new Scanner(System.in);



	//-------------------------------------------------------------------------------

	public static void AdicionaCanais () throws IOException {
		Main.LimparTela();

		Canais canal = new Canais();

		System.out.printf("Digite o nome do Canal: ");
		canal.setNome(entrada.nextLine());

		System.out.printf("Digite seu Nome: ");
		canal.setAutor(entrada.nextLine());

		System.out.printf("Digite uma descrição para este Canal: ");
		canal.setDescricao(entrada.nextLine());

		PublicoAlvo.EscolherPublicoAlvo();
		canal.setPublicoAlvo(PublicoAlvo.opcao);

		Main.canais.add(canal);

		auxiliar = canal.nome;

		System.out.printf("\nDados Armazenados com sucesso!! \n");
		System.out.println("Pressione Enter Novamente...");
	}


	//-------------------------------------------------------------------------------

	public static void ListarCanais () throws IOException {

		Main.LimparTela();

		System.out.println("\n=============================================================\n"); 
		for(int i = 0;i<Main.canais.size();i++){  
			System.out.println("\nNome Canal : " + Main.canais.get(i).getNome());
			System.out.println("Autor : " + Main.canais.get(i).getAutor());
			System.out.println("Descrição : " + Main.canais.get(i).getDescricao());
			System.out.println("Inscritos : " + Main.canais.get(i).getInscritos());
			System.out.println("Público Alvo : " + Main.canais.get(i).getPublicoAlvo());

			System.out.println("\n=============================================================\n"); 
		}


		System.out.println("Pressione Enter Novamente...");
		System.in.read();
	}	

	//-------------------------------------------------------------------------------


	public static void RemoverCanal() throws IOException {
		Main.LimparTela();
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
		}
	}

	//--------------------------------------------------------------------------------

	public static void AtualizarCanal() throws IOException {

		System.out.printf("Digite o nome do Canal a ser Atualizado:  \n");
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
		}
	}

	//--------------------------------------------------------------------------------------------------

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getPublicoAlvo() {
		return publicoAlvo;
	}


	public void setPublicoAlvo(String publicoAlvo) {
		this.publicoAlvo = publicoAlvo;
	}

	public int getInscritos() {
		return inscritos;
	}

	public void setInscritos(int inscritos) {
		this.inscritos = inscritos;
	}

}
