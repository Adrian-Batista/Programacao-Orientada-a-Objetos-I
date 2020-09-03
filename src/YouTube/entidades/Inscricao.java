package YouTube.entidades;

import java.io.IOException;

import YouTube.Main;

public class Inscricao{

	private Canal nomeCanal;
	private Usuario nomeUsuario;
	private int numeroInscritos = 0;


	public Inscricao(Canal nomeCanal, Usuario nomeUsuario, int numeroInscritos) {
		super();
		this.nomeCanal = nomeCanal;
		this.nomeUsuario = nomeUsuario;
		this.numeroInscritos = numeroInscritos;
	}


	public static void RealizarInscricao(String auxiliar) throws IOException {
		for (int indice = 0; indice < Main.canal.size(); indice++) {
			if (Main.canal.get(indice).getNomecanal().contentEquals(auxiliar)) {	
				System.out.println("Para se inscrever vamos lhe solicitar seus dados.");

				String NomeUsuario = Usuario.VerificaUsuario();
				for(int aux1 = 0;aux1<Main.inscricao.size();aux1++) {
					if(NomeUsuario==null) {
						break;
					}
					if(Main.inscricao.get(aux1).getNomeCanal().getNomecanal().contentEquals(auxiliar)) {
						for(int aux2=0; aux2<Main.inscricao.size(); aux2++) {
							if(Main.inscricao.get(aux1).getNomeUsuario().getNome().contentEquals(NomeUsuario)) {
								System.out.println("Ops, você já é um inscrito deste Canal!");
								System.in.read();
								return;
							}
						}
					}
				}

				if(NomeUsuario != null) {
					int aux = Main.canal.get(indice).getInscritos().getNumeroInscritos();
					aux++;
					Inscricao inscritos = new Inscricao(null, null, 0);
					Canal C = new Canal(null, null, null, null, null);
					Usuario U = new Usuario(null, null, null);
					inscritos.setNomeCanal(C);
					inscritos.setNomeUsuario(U);
					inscritos.getNomeCanal().setNomecanal(auxiliar);
					inscritos.getNomeUsuario().setNome(NomeUsuario);
					inscritos.setNumeroInscritos(aux);
					Main.canal.get(indice).getInscritos().setNumeroInscritos(aux);
					Main.inscricao.add(inscritos);
					Main.LimparTela();
					System.out.println("\nParabéns agora você é um inscrito do Canal "+ auxiliar+"\n\n");
					System.in.read();
					break;
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

	public Canal getNomeCanal() {
		return nomeCanal;
	}

	public void setNomeCanal(Canal nomeCanal) {
		this.nomeCanal = nomeCanal;
	}

	public Usuario getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(Usuario nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public int getNumeroInscritos() {
		return numeroInscritos;
	}

	public void setNumeroInscritos(int numeroInscritos) {
		this.numeroInscritos = numeroInscritos;
	}



}
