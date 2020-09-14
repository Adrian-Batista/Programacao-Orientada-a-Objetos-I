package YouTube.entidades;

import java.io.IOException;
import java.util.Scanner;

import YouTube.Main;

public class Usuario extends Perfil{

	public Usuario(String nome, String email) {
		super(nome, email);
	}
	public Usuario(String nome, String email, String senha) {
		super(nome, email, senha);
	}

	static Scanner entrada = new Scanner(System.in);
	
	public static void AdicionarUsuario(Perfil criaUsuario) throws IOException {
		int aux;
		
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
	}

	public static void ListarUsuario(String auxiliar) {
		System.out.println("\n=============================================================\n"); 
		for(int i = 0;i<Main.usuario.size();i++){
			if(Main.usuario.get(i).getNome().contentEquals(auxiliar)) {
				System.out.println("\nNome : " + Main.usuario.get(i).getNome());
				System.out.println("Email : " + Main.usuario.get(i).getEmail());
				System.out.println("\n=============================================================\n");
			}	
		}
	}

	public static String VerificaUsuario() {
		System.out.println("Digite seu nome completo: ");
		String auxiliar = entrada.nextLine();
		for(int i = 0; i<Main.usuario.size(); i++) {
			if(Main.usuario.get(i).getNome().contentEquals(auxiliar)) {
				System.out.println("Digite sua senha:");
				String auxiliar2 = entrada.nextLine();
				if(Main.usuario.get(i).getSenha().contentEquals(auxiliar2)) {
					return auxiliar;
				}else {
					return null;
				}
			}
		}
		return null;
	}
	
	@Override
	public void MetodoAbstrato() {
		System.out.println("Método abstrato da classe Canal!");
		
	}
	
	// -------------------------------- GETTERS E SETTERS ----------------------------

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
		

}
