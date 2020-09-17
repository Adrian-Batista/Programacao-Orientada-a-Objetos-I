package YouTube.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import steam.ihc.AlertaFX;

public class UtilBD {
	private static Connection conexao;

	@SuppressWarnings("exports")
	public static Connection getConexao() {
		try {

			if (conexao == null)
				abrirConexao();

			if (conexao.isClosed())
				abrirConexao();

		} catch (SQLException e) {
			//AlertaFX.erro("N�o consegui abrir a conex�o com o banco!");
			System.out.println("N�o consegui abrir a conex�o com o banco!");
		}

		return conexao;
	}

	private static void abrirConexao() {
		try {
			Class.forName("org.sqlite.JDBC");
			conexao = DriverManager.getConnection("jdbc:sqlite:banco.sqlite");
		} catch (SQLException e) {
			//AlertaFX.erro("N�o consegui abrir a conex�o com o banco!");
			System.out.println("N�o consegui abrir a conex�o com o banco!");
		} catch (ClassNotFoundException e2) {
			//AlertaFX.erro("A biblioteca do SQLite n�o est� funcionando corretamente!");
			System.out.println("A biblioteca do SQLite n�o est� funcionando corretamente!");
		}
	}

	public static void fecharConexao() {
		if (conexao == null)
			return;

		try {
			if (!conexao.isClosed())
				conexao.close();
		} catch (SQLException e) {
			//AlertaFX.erro("N�o consegui fechar a conex�o com o banco!");
			System.out.println("N�o consegui fechar a conex�o com o banco!");
		}
	}

	public static void initBD() {
		try {
			conexao = getConexao();
			Statement stm = conexao.createStatement();
			criarInscricao(stm);
			criarCanal(stm);
			criarVideo(stm);
			criarPublicoAlvo(stm);
			criarUsuario(stm);
			stm.executeUpdate("PRAGMA foreign_keys=ON");
			stm.close();
		} catch (SQLException e) {
			//AlertaFX.erro("N�o consegui criar o banco!");
			System.out.println("N�o consegui criar o banco!");
		}
	}

	private static void criarUsuario(Statement stm) throws SQLException {		
		stm.executeUpdate("DROP TABLE IF EXISTS Usuario");
		stm.executeUpdate("CREATE TABLE Usuario ("
			+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ "Nome VARCHAR(10) NOT NULL,"
			+ "Email VARCHAR(30) NOT NULL,"
			+ "Senha VARCHAR(20) NOT NULL"
			+ ");"
		);
		stm.executeUpdate("INSERT INTO Usuario (Nome, Email, Senha) VALUES ('usuario','usuario.teste@gmail.com','123');");
		stm.executeUpdate("INSERT INTO Usuario (Nome, Email, Senha) VALUES ('usuario2','usuario2.teste@gmail.com','321');");
}	

	private static void criarPublicoAlvo(Statement stm) throws SQLException {
		stm.executeUpdate("DROP TABLE IF EXISTS PublicoAlvo");
		stm.executeUpdate("CREATE TABLE PublicoAlvo ("
				+ "NomeCanal VARCHAR(10) NOT NULL,"
				+ "TipoPublico VARCHAR(10) NOT NULL"
				//+ "FOREIGN KEY (NomeCanal) REFERENCES Canal(Nome) ON DELETE CASCADE,"
				//+ "FOREIGN KEY (TipoPublico) REFERENCES Canal(Publico) ON DELETE CASCADE"
				+ ");"
		);
		//stm.executeUpdate("INSERT INTO PublicoAlvo VALUES ('Canal','Todos')");
		//stm.executeUpdate("INSERT INTO PublicoAlvo VALUES ('Canal 2','Jovens')");
	}

	private static void criarVideo(Statement stm) throws SQLException {
		stm.executeUpdate("DROP TABLE IF EXISTS Video");
		stm.executeUpdate("CREATE TABLE Video ("
				+ "Nome VARCHAR(20) NOT NULL,"
				+ "Link VARCHAR(30) NOT NULL,"
				+ "Date VARCHAR(10) NOT NULL,"
				+ "Preco INTEGER NOT NULL,"
				+ "NomeCanal VARCHAR(10) NOT NULL,"
				+ "Descricao VARCAHAR(100) NOT NULL"
				//+ "FOREIGN KEY (NomeCanal) REFERENCES Canal(Nome) ON DELETE CASCADE"
				+ ");"
				
		);
		stm.executeUpdate("INSERT INTO Video VALUES ('Video 1', 'https:', '11/09/2020','15.8', 'Canal', 'Seja bem vindo ao v�deo 1');");
		stm.executeUpdate("INSERT INTO Video VALUES ('Video 2', 'https:/', '11/09/2020', '10', 'Canal', 'Seja bem vindo ao v�deo 2');");
		stm.executeUpdate("INSERT INTO Video VALUES ('Video 3', 'https://', '12/09/2020', '0', 'Canal', 'Seja bem vindo ao v�deo 3');");
	}

	private static void criarCanal(Statement stm) throws SQLException {
		stm.executeUpdate("DROP TABLE IF EXISTS Canal");
		stm.executeUpdate("CREATE TABLE Canal ("
				+ "Nome VARCHAR(10) PRIMARY KEY NOT NULL,"
				+ "Email VARCHAR(30) NOT NULL,"
				+ "Descricao VARCHAR(100) NOT NULL,"
				+ "Publico VARCHAR(10) NOT NULL,"
				+ "Inscricao INTEGER NOT NULL"
				+ ");"
		);
		stm.executeUpdate("INSERT INTO Canal VALUES ('Canal','canal.teste@gmail.com', 'Seja bem vindo ao Canal', 'Todos', '1')");
		stm.executeUpdate("INSERT INTO Canal VALUES ('Canal 2','canal2.teste@gmail.com', 'Seja bem vindo ao Canal 2', 'Jovens', '2')");
		
	}

	private static void criarInscricao(Statement stm) throws SQLException {
		stm.executeUpdate("DROP TABLE IF EXISTS Inscricao");
		stm.executeUpdate("CREATE TABLE Inscricao ("
				+ "NomeCanal VARCHAR(10) NOT NULL,"
				+ "NomeUsuario VARCHAR(10) NOT NULL"
				//+ "FOREIGN KEY (NomeCanal) REFERENCES Canal(Nome) ON DELETE CASCADE,"
				//+ "FOREIGN KEY (NomeUsuario) REFERENCES Usuario(Nome) ON DELETE CASCADE"
				+ ");"
		);
		//stm.executeUpdate("INSERT INTO Inscricao VALUES ('Canal', 'usuario')");
		//stm.executeUpdate("INSERT INTO Inscricao VALUES ('Canal 2', 'usuario')");
		//stm.executeUpdate("INSERT INTO Inscricao VALUES ('Canal 2', 'usuario2')");
	}

	public static void alterarBD(String sql) throws SQLException {
		Connection bd = UtilBD.getConexao();
		Statement stm = bd.createStatement();
		stm.executeUpdate(sql);
		//System.out.println("Executei: " + sql);
		stm.close();
	}
	
	@SuppressWarnings("exports")
	public static ResultSet consultarBD(String sql) throws SQLException {
		Connection bd = UtilBD.getConexao();
		Statement stm = bd.createStatement();
		ResultSet retorno = stm.executeQuery(sql);
		//System.out.println("Executei: " + sql);
		return retorno;
	}
}