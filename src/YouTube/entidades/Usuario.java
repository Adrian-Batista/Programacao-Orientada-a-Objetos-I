package YouTube.entidades;

import java.util.Scanner;

import YouTube.Main;

public class Usuario extends Perfil{

	public Usuario(String nome, String email) {
		super(nome, email);
	}
	public Usuario(int id, String nome, String email, String senha) {
		super(id, nome, email, senha);
	}

	static Scanner entrada = new Scanner(System.in);

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
