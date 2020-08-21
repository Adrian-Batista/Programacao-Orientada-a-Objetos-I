package YouTube.entidades;

import java.io.IOException;
import java.util.Scanner;

import YouTube.Main;

public class Usuarios {
	
	private String nomeUsuario;
	private String emailUsuario;
	private String senhaUsuario;

	public Usuarios() {
		this.setNomeUsuario(nomeUsuario);
		this.setEmailUsuario(emailUsuario);
		this.setSenhaUsuario(senhaUsuario);
	}

	static Scanner entrada = new Scanner(System.in);
	
	
	
	//-------------------------------------------------------------------------------
	
	public static void AdicionaUsuario () throws IOException {
		Main.LimparTela();
		
		Usuarios usuario = new Usuarios();
		
		System.out.printf("Digite seu nome: ");
		usuario.setNomeUsuario(entrada.nextLine());
		
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
			System.out.println("E-mail : " + Main.usuarios.get(i).getEmailUsuario());
			System.out.println("Senha : " + Main.usuarios.get(i).getSenhaUsuario());
							
			System.out.println("\n=============================================================\n"); 
		}
				
												
		System.out.println("Pressione Enter Novamente...");
		System.in.read();
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

}
