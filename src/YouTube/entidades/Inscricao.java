package YouTube.entidades;

public class Inscricao{

	private int numeroInscritos;
	Usuario[] lista = new Usuario[50];
	
	
	
	public Inscricao(Usuario[] lista, int numeroInscritos) {
		super();
		this.lista = lista;
		this.numeroInscritos = numeroInscritos;
	}
	
	public Inscricao(int numeroInscritos) {
		super();
		this.lista = null;
		this.numeroInscritos = numeroInscritos;
	}
	
	public static Usuario[] CarregaVetor() {
		Usuario[] lista = new Usuario[50];
		for(int i =0; i<lista.length; i++) {
			lista[i] = new Usuario(0, null, null, null);
		}
		return lista;
	}
	// ----------------------------------- GETTERS E SETTERS ------------------------------------------


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
