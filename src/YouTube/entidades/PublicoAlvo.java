package YouTube.entidades;

import java.io.IOException;
import java.util.Scanner;

import YouTube.Main;

public class PublicoAlvo {
	
	static String opcao = "NULL";
	private static String opc1 = "Crianças";
	private static String opc2 = "Jovens";
	private static String opc3 = "Adultos";
	private static String opc4 = "Idosos";
	private static String opc5 = "Todos";
	
	public PublicoAlvo(String opcao) {
		PublicoAlvo.opcao = opcao;
	}

	public PublicoAlvo(String opc1, String opc2, String opc3, String opc4, String opc5, String opcao) {
		PublicoAlvo.opcao = opcao;
		PublicoAlvo.opc1 = opc1;
		PublicoAlvo.opc2 = opc2;
		PublicoAlvo.opc3 = opc3;
		PublicoAlvo.opc4 = opc4;
		PublicoAlvo.opc5 = opc5;
	}
	
	static Scanner entrada = new Scanner(System.in);
	
//--------------------------------------------------------------------------------------------------------
	
	public static void EscolherPublicoAlvo() {
			int escolha = 0;
			Main.LimparTela();
			
			System.out.println("\n Usuario selecione o publico alvo dos seu Canal: " );
			System.out.println("\n============================================");
			System.out.println("|  1 - Crianças (abaixo de 12 anos)        | ");
			System.out.println("|  2 - Jovens   (13 a 24 anos)             | ");
			System.out.println("|  3 - Adultos  (25 a 50 anos)             | ");
			System.out.println("|  4 - Idosos   (acima de 51 anos)         | ");
			System.out.println("|  5 - Todos                               | ");
			System.out.println("============================================\n");
		
			do {
				System.out.println(" Escolha uma das opções: ");
				escolha = entrada.nextInt();
				entrada.nextLine();
		
			}while(escolha<1 || escolha>5);
		
			if(escolha==1)
				opcao = opc1;
			if(escolha==2)
				opcao = opc2;
			if(escolha==3)
				opcao = opc3;
			if(escolha==4)
				opcao = opc4;
			if(escolha==5)
			opcao = opc5;
			
	}
	
	
	//--------------------------------------------------------------------------------------------------------
	
	public static void AtualizarPublicoAlvo() throws IOException {
		int escolha = 0;
		Main.LimparTela();
		
		System.out.printf("Digite o nome do Canal a ser atualizado o Público Alvo:  \n");
		String nomeUpdate = entrada.nextLine();
		int aux = 0;
		
		for (int indice = 0; indice < Main.canais.size(); indice++) {
			if (Main.canais.get(indice).getNome().contentEquals(nomeUpdate)) {
				aux++;
				Main.LimparTela();
				System.out.printf("Canal localizado com sucesso!! \n\n");
				
				System.out.println("O Público Alvo definido anteriormente é : " + Main.canais.get(indice).getPublicoAlvo() + ", para este Canal!");
				System.out.println("\n\n Usuario selecione o publico alvo dos seu Canal: " );
				System.out.println("\n============================================");
				System.out.println("|  1 - Crianças (abaixo de 12 anos)        | ");
				System.out.println("|  2 - Jovens   (13 a 24 anos)             | ");
				System.out.println("|  3 - Adultos  (25 a 50 anos)             | ");
				System.out.println("|  4 - Idosos   (acima de 51 anos)         | ");
				System.out.println("|  5 - Todos                               | ");
				System.out.println("============================================\n");
			
				do {
					System.out.println(" Escolha uma das opções: ");
					escolha = entrada.nextInt();
					entrada.nextLine();
			
				}while(escolha<1 || escolha>5);
			
				if(escolha==1)
					opcao = opc1;
				if(escolha==2)
					opcao = opc2;
				if(escolha==3)
					opcao = opc3;
				if(escolha==4)
					opcao = opc4;
				if(escolha==5)
				opcao = opc5;
				
				Main.canais.get(indice).setPublicoAlvo(opcao);;
			}	
		}
		if(aux==0) {
			Main.LimparTela();
			System.out.printf("Canal não localizado tente novamente!! \n\n");
			System.in.read();
			return;
		}
		
}
	
	//--------------------------------------------------------------------------------------------------------
	

	public String getOpcao() {
		return opcao;
	}


	public void setOpcao(String opcao) {
		PublicoAlvo.opcao = opcao;
	}


	public String getOpc1() {
		return opc1;
	}

	public void setOpc1(String opc1) {
		PublicoAlvo.opc1 = opc1;
	}

	public String getOpc2() {
		return opc2;
	}

	public void setOpc2(String opc2) {
		PublicoAlvo.opc2 = opc2;
	}

	public String getOpc3() {
		return opc3;
	}

	public void setOpc3(String opc3) {
		PublicoAlvo.opc3 = opc3;
	}

	public String getOpc4() {
		return opc4;
	}

	public void setOpc4(String opc4) {
		PublicoAlvo.opc4 = opc4;
	}

	public String getOpc5() {
		return opc5;
	}

	public void setOpc5(String opc5) {
		PublicoAlvo.opc5 = opc5;
	}

	
	
}
