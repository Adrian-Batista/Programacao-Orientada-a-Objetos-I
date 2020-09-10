package YouTube.entidades;

import java.io.IOException;

import YouTube.Main;

public class Inscricao{

	private Canal dadosCanal;
	private Usuario dadosUsuario;
	private int numeroInscritos;
	Usuario[] lista = new Usuario[50];

	public Inscricao(Canal dadosCanal, Usuario dadosUsuario, int numeroInscritos) {
		super();
		this.dadosCanal = dadosCanal;
		this.dadosUsuario = dadosUsuario;
		this.numeroInscritos = numeroInscritos;
	}

	public static void RealizarInscricao(String auxiliar) throws IOException {
		for (int indice = 0; indice < Main.canal.size(); indice++) {
			if (Main.canal.get(indice).getNome().contentEquals(auxiliar)) {	
				System.out.println("Para se inscrever vamos lhe solicitar seus dados.");

				String NomeUsuario = Usuario.VerificaUsuario();
				
				if(NomeUsuario != null) {
					for(int i=0; i< Main.canal.size(); i++) {						
						if(Main.canal.get(i).getNome().contentEquals(auxiliar)) {
							for(int j=0; j<50; j++) {
								if(Main.canal.get(i).getInscrito().getLista()[j].getNome().contentEquals(NomeUsuario)) {
									System.out.println("Ops, você já é um inscrito do Canal!");
									System.in.read();
									break;
								}
								if(Main.canal.get(i).getInscrito().getLista()[j].getNome()==null) {
									Main.canal.get(i).getInscrito().getLista()[j].setNome(NomeUsuario);
									Main.LimparTela();
									System.out.println("\nParabéns agora você é um inscrito do Canal "+ auxiliar+"\n\n");
									System.in.read();
									break;
								}
							}
						}
					}
				}
				if(NomeUsuario ==null) {
					Main.LimparTela();
					System.out.printf("Dados Incorretos refaça a operação!! \n\n");
					System.in.read();
					break;
				}
			}
		}
		Main.LimparTela();
		System.out.println("Não Localizado!");
	}
	// ----------------------------------- GETTERS E SETTERS ------------------------------------------

	public Canal getDadosCanal() {
		return dadosCanal;
	}

	public void setDadosCanal(Canal dadosCanal) {
		this.dadosCanal = dadosCanal;
	}

	public Usuario getDadosUsuario() {
		return dadosUsuario;
	}

	public void setDadosUsuario(Usuario dadosUsuario) {
		this.dadosUsuario = dadosUsuario;
	}

	public int getNumeroInscritos() {
		return numeroInscritos;
	}

	public void setNumeroInscritos(int numeroInscritos) {
		this.numeroInscritos = numeroInscritos;
	}

	public Usuario[] getLista() {
		return lista;
	}

	public void setLista(Usuario[] lista) {
		this.lista = lista;
	}
	

}
