package YouTube.entidades;

import java.util.Scanner;

import YouTube.Main;

public class Usuario{

	private String nome;
	private String email;
	private String senha;

	public Usuario(String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	static Scanner entrada = new Scanner(System.in);
	
	public static void AdicionarUsuario() {
		Usuario usuario = new Usuario(null, null, null);
		System.out.printf("Digite seu nome completo: ");
		usuario.setNome(entrada.nextLine());
		System.out.printf("Digite seu e-mail: ");
		usuario.setEmail(entrada.nextLine());
		System.out.printf("Digite uma senha: ");
		usuario.setSenha(entrada.nextLine());
		Main.usuario.add(usuario);
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


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}		

}
