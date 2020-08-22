package YouTube.entidades;

import java.io.IOException;
import java.util.Scanner;

import YouTube.Main;

public class Usuarios {
	
	private String nomeUsuario;
	private String enderecoUsuario;
	private String emailUsuario;
	private String senhaUsuario;
	
	public Usuarios(String nomeUsuario) {
		setNomeUsuario(nomeUsuario);
	}
	
	public Usuarios(String NomeUsuario, String EnderecoUsuario, String EmailUsuario, String SehaUsuario) {
		setNomeUsuario(nomeUsuario);
		setEnderecoUsuario(enderecoUsuario);
		setEmailUsuario(emailUsuario);
		setSenhaUsuario(senhaUsuario);
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
		usuario.setNomeUsuario(entrada.nextLine());
		
		System.out.printf("Digite seu endereco: ");
		usuario.setEnderecoUsuario(entrada.nextLine());
		
		System.out.printf("Digite o seu email: ");
		usuario.setEmailUsuario(entrada.nextLine());
		
		System.out.printf("Digite uma senha: ");
		usuario.setSenhaUsuario(entrada.nextLine());
		
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
			System.out.println("\nNome : " + Main.usuarios.get(i).getNomeUsuario());
			System.out.println("\nEndereço : " + Main.usuarios.get(i).getEnderecoUsuario());
			System.out.println("E-mail : " + Main.usuarios.get(i).getEmailUsuario());
			System.out.println("Senha : " + Main.usuarios.get(i).getSenhaUsuario());
							
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
			if (Main.usuarios.get(indice).getNomeUsuario().contentEquals(nomeRemove)) {
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
			if (Main.usuarios.get(indice).getNomeUsuario().contentEquals(nomeUpdate)) {
				aux++;
				Main.LimparTela();
				
				
				do {
					aux3=0;
					System.out.printf("Digite o seu nome: ");
					verificador = (entrada.nextLine());
					for (int indice2 = 0; indice2 < Main.usuarios.size(); indice2++) {
						if (Main.usuarios.get(indice2).getNomeUsuario().contentEquals(verificador)){
							aux3++;
							System.out.printf("\nO nome escolhido ja está em uso, selecione outro:\n\n ");
							break;
						}
					}
					if(aux3==0) {
						Main.usuarios.get(indice).setNomeUsuario(verificador);
					}
					
				}while(aux3 != 0);
				
				System.out.printf("Digite seu endereco: ");
				verificador = (entrada.nextLine());
				Main.usuarios.get(indice).setEnderecoUsuario(verificador);
				
				do {
					aux3=0;
					
					System.out.printf("Digite o seu email: ");
					verificador = (entrada.nextLine());
					for (int indice2 = 0; indice2 < Main.usuarios.size(); indice2++) {
						if (Main.usuarios.get(indice2).getEmailUsuario().contentEquals(verificador)){
							aux3++;
							System.out.printf("\nO E-mail escolhido ja está em uso, selecione outro:\n\n ");
							break;
						}
					}
					if(aux3==0) {
						Main.usuarios.get(indice).setEmailUsuario(verificador);
					}
				}while(aux3 != 0);
				
				System.out.printf("Digite uma senha: ");
				verificador = (entrada.nextLine());
				Main.usuarios.get(indice).setSenhaUsuario(verificador);
				
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
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}


	public String getEnderecoUsuario() {
		return enderecoUsuario;
	}


	public void setEnderecoUsuario(String enderecoUsuario) {
		this.enderecoUsuario = enderecoUsuario;
	}


}
