package YouTube.entidades;

import YouTube.Main;

public class Inscricao{

	private Canal nomeCanal;
	private Usuario nomeUsuario;
	private int numeroInscritos =0;


	public Inscricao(Canal nomeCanal, Usuario nomeUsuario, int numeroInscritos) {
		super();
		this.nomeCanal = nomeCanal;
		this.nomeUsuario = nomeUsuario;
		this.numeroInscritos = numeroInscritos;
	}

	public Inscricao() {
		// TODO Auto-generated constructor stub
	}

	public static void RealizarInscricao(String auxiliar) {
		for (int indice = 0; indice < Main.canal.size(); indice++) {
			if (Main.canal.get(indice).getNomecanal().contentEquals(auxiliar)) {	
				System.out.println("Para se inscrever vamos lhe solicitar seus dados.");

				String NomeUsuario = Usuario.VerificaUsuario();

				if(NomeUsuario != null) {
					int aux = Main.canal.get(indice).getInscritos().getNumeroInscritos();
					aux++;
					Inscricao inscritos = new Inscricao();
					Canal C = new Canal();
					Usuario U = new Usuario();
					inscritos.setNomeCanal(C);
					inscritos.setNomeUsuario(U);
					inscritos.getNomeCanal().setNomecanal(auxiliar);
					inscritos.getNomeUsuario().setNome(NomeUsuario);
					inscritos.setNumeroInscritos(aux);
					Main.canal.get(indice).getInscritos().getNomeUsuario().setNome(NomeUsuario);;
					Main.canal.get(indice).getInscritos().setNumeroInscritos(aux);
					Main.inscricao.add(inscritos);
					Main.LimparTela();
					System.out.println("\nParabéns agora você é um inscrito do Canal "+ auxiliar+"\n\n");
					break;
				}
				if(NomeUsuario ==null) {
					Main.LimparTela();
					System.out.printf("Dados Incorretos refaça a operação!! \n\n");
					break;
				}
			}
		}
		Main.LimparTela();
		System.out.println("Não Localizado!");
	}
	// -----------------------------------------------------------------------------

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
