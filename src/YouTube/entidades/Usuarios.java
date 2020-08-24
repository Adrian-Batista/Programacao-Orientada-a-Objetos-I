package YouTube.entidades;

import java.io.IOException;
import java.util.Scanner;

import YouTube.Main;

public class Usuarios extends Canais {
	
	private String endereco;
	private String senha;
	
	public Usuarios(String nome, String email, String Endereco, String Senha) {
		super(nome, email);
		setEndereco(endereco);
		setSenha(senha);
	}

	public Usuarios() {
		// TODO Auto-generated constructor stub
	}

	static Scanner entrada = new Scanner(System.in);
	
	
	
	//-------------------------------------------------------------------------------
	
	public static void AdicionaUsuario () throws IOException {
		Main.LimparTela();
		
		 Usuarios usuario = new Usuarios();
		
		System.out.printf("Digite seu nome: ");
		usuario.setNome(entrada.nextLine());
		
		System.out.printf("Digite seu endereco: ");
		usuario.setEndereco(entrada.nextLine());
		
		System.out.printf("Digite o seu email: ");
		usuario.setEmail(entrada.nextLine());
		
		System.out.printf("Digite uma senha: ");
		usuario.setSenha(entrada.nextLine());
		
		Main.usuarios.add(usuario);
		
		System.out.printf("\nDados Armazenados com sucesso!! \n");
		System.out.println("Pressione Enter Novamente...");
		System.in.read();
	}
	
	
	//-------------------------------------------------------------------------------
	
	public static void ListarUsuarios () throws IOException {
		
		Main.LimparTela();
				
		System.out.println("\n=============================================================\n"); 
		for(int i = 0;i<Main.usuarios.size();i++){  
			System.out.println("\nNome : " + Main.usuarios.get(i).getNome());
			System.out.println("\nEndereço : " + Main.usuarios.get(i).getEndereco());
			System.out.println("E-mail : " + Main.usuarios.get(i).getEmail());
			System.out.println("Senha : " + Main.usuarios.get(i).getSenha());
							
			System.out.println("\n=============================================================\n"); 
		}
				
												
		System.out.println("Pressione Enter Novamente...");
		System.in.read();
	}	
	
	//----------------------------------- REMOVER USUÁRIO --------------------------------------------
	
	public static void RemoverUsuario() throws IOException {
		System.out.printf("Digite o nome do Usuario a ser removido:  \n");
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
		}
	}	
	
	//----------------------------------- ATUALIZAR USUÁRIO --------------------------------------------
	
	public static void AtualizarUsuario() throws IOException {
		System.out.printf("Digite o nome do Usuario a ser Atualizado:  \n");
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
		}
	}		
	
	//-------------------------------------------------------------------------------

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


}
