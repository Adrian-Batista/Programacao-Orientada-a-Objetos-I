package YouTube.entidades;

import YouTube.Main;

public class Inscricoes{

	private Canais nomeCanal;
	private Usuarios nomeUsuario;
	private int numeroInscritos =0;


	public Inscricoes(Canais nomeCanal, Usuarios nomeUsuario, int numeroInscritos) {
		super();
		this.nomeCanal = nomeCanal;
		this.nomeUsuario = nomeUsuario;
		this.numeroInscritos = numeroInscritos;
	}

	public Inscricoes() {
		// TODO Auto-generated constructor stub
	}

	public static void RealizarInscricao(String auxiliar) {
		for (int indice = 0; indice < Main.canais.size(); indice++) {
			if (Main.canais.get(indice).getNomecanal().contentEquals(auxiliar)) {	
				System.out.println("Para se inscrever vamos lhe solicitar seus dados.");

				String NomeUsuario = Usuarios.VerificaUsuario();

				if(NomeUsuario != null) {
					int aux = Main.canais.get(indice).getInscritos().getNumeroInscritos();
					aux++;
					Inscricoes inscritos = new Inscricoes();
					Canais C = new Canais();
					Usuarios U = new Usuarios();
					inscritos.setNomeCanal(C);
					inscritos.setNomeUsuario(U);
					inscritos.getNomeCanal().setNomecanal(auxiliar);
					inscritos.getNomeUsuario().setNome(NomeUsuario);
					inscritos.setNumeroInscritos(aux);
					Main.canais.get(indice).getInscritos().setNumeroInscritos(aux);
					Main.inscricoes.add(inscritos);
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

	public Canais getNomeCanal() {
		return nomeCanal;
	}

	public void setNomeCanal(Canais nomeCanal) {
		this.nomeCanal = nomeCanal;
	}

	public Usuarios getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(Usuarios nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public int getNumeroInscritos() {
		return numeroInscritos;
	}

	public void setNumeroInscritos(int numeroInscritos) {
		this.numeroInscritos = numeroInscritos;
	}



}
