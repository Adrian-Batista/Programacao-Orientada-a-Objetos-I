package YouTube.entidades;

import java.util.Scanner;

import YouTube.Main;

public class Usuarios{
	
	private String nome;
	private String email;
	private String senha;
	
	public Usuarios(String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	
	public Usuarios() {
		super();
	
	}
		
	
	public static void AdicionarUsuario() {
		Scanner entrada = new Scanner(System.in);
		Usuarios usuario = new Usuarios();
		
		System.out.printf("Digite seu nome: ");
		usuario.setNome(entrada.nextLine());
		
		System.out.printf("Digite seu e-mail: ");
		usuario.setEmail(entrada.nextLine());
		
		System.out.printf("Digite uma senha: ");
		usuario.setSenha(entrada.nextLine());
		
		Main.usuarios.add(usuario);
	}
	
	public static void ListarUsuario() {
		System.out.println("\n=============================================================\n"); 
		for(int i = 0;i<Main.usuarios.size();i++){  
			System.out.println("\nNome : " + Main.usuarios.get(i).getNome());
			System.out.println("Email : " + Main.usuarios.get(i).getEmail());
							
			System.out.println("\n=============================================================\n");
		}
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
