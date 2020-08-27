package YouTube.entidades;

public class PublicoAlvo {
	
	 String opcao = "NULL";
	private String opc1 = "Crian�as";
	private String opc2 = "Jovens";
	private String opc3 = "Adultos";
	private String opc4 = "Idosos";
	private String opc5 = "Todos";
	
	
	public PublicoAlvo(String opcao, String opc1, String opc2, String opc3, String opc4, String opc5) {
		super();
		this.opcao = opcao;
		this.opc1 = opc1;
		this.opc2 = opc2;
		this.opc3 = opc3;
		this.opc4 = opc4;
		this.opc5 = opc5;
	}
	
	public PublicoAlvo() {
		
	}
	
	public static String SelecionaPublicoAlvo(int escolha) {
		PublicoAlvo publico = new PublicoAlvo();
		if(escolha==1)
			publico.setOpcao(publico.getOpc1());
		if(escolha==2)
			publico.setOpcao(publico.getOpc2());
		if(escolha==3)
			publico.setOpcao(publico.getOpc3());
		if(escolha==4)
			publico.setOpcao(publico.getOpc4());
		if(escolha==5) {
			publico.setOpcao(publico.getOpc5());
		}
		return publico.getOpcao();
		
	}

//------------------------------------------ GETTERS E SETTERS -------------------------------------------
	
	public String getOpcao() {
		return opcao;
	}


	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}


	public String getOpc1() {
		return opc1;
	}


	public void setOpc1(String opc1) {
		this.opc1 = opc1;
	}


	public String getOpc2() {
		return opc2;
	}


	public void setOpc2(String opc2) {
		this.opc2 = opc2;
	}


	public String getOpc3() {
		return opc3;
	}


	public void setOpc3(String opc3) {
		this.opc3 = opc3;
	}


	public String getOpc4() {
		return opc4;
	}


	public void setOpc4(String opc4) {
		this.opc4 = opc4;
	}


	public String getOpc5() {
		return opc5;
	}


	public void setOpc5(String opc5) {
		this.opc5 = opc5;
	}
	
	
}
