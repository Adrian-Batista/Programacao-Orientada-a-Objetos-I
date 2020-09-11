package YouTube.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import steam.ihc.AlertaFX;

public class UtilBD {
	private static Connection conexao;

	public static Connection getConexao() {
		try {

			if (conexao == null)
				abrirConexao();

			if (conexao.isClosed())
				abrirConexao();

		} catch (SQLException e) {
			//AlertaFX.erro("Não consegui abrir a conexão com o banco!");
		}

		return conexao;
	}

	private static void abrirConexao() {
		try {
			Class.forName("org.sqlite.JDBC");
			conexao = DriverManager.getConnection("jdbc:sqlite:banco.sqlite");
		} catch (SQLException e) {
			//AlertaFX.erro("Não consegui abrir a conexão com o banco!");
		} catch (ClassNotFoundException e2) {
			//AlertaFX.erro("A biblioteca do SQLite não está funcionando corretamente!");
		}
	}

	public static void fecharConexao() {
		if (conexao == null)
			return;

		try {
			if (!conexao.isClosed())
				conexao.close();
		} catch (SQLException e) {
			//AlertaFX.erro("Não consegui fechar a conexão com o banco!");
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
			stm.close();
		} catch (SQLException e) {
			//AlertaFX.erro("Não consegui criar o banco!");
		}
	}

	private static void criarUsuario(Statement stm) throws SQLException {
		stm.executeUpdate("DROP TABLE IF EXISTS Usuario");
		stm.executeUpdate(
				"CREATE TABLE Usuario (Nome varchar(10) NOT NULL PRIMARY KEY, Email varchar(50) NOT NULL, Senha varchar(50) NOT NULL, Apelido varchar(30) NOT NULL);");
		stm.executeUpdate("INSERT INTO Usuario VALUES ('admin','admin@gmail.com','admin','admin')");
	}

	private static void criarPublicoAlvo(Statement stm) throws SQLException {
		stm.executeUpdate("DROP TABLE IF EXISTS PublicoAlvo");
		stm.executeUpdate("CREATE TABLE PublicoAlvo (NomeGenero varchar(10) NOT NULL," + "NomeJogo varchar(10) NOT NULL,"
				+ "FOREIGN KEY (NomeGenero) REFERENCES Inscricao(Nome) ON DELETE CASCADE,"
				+ "FOREIGN KEY (NomeJogo) REFERENCES Video(Nome) ON DELETE CASCADE,"
				+ "CONSTRAINT PK_GENERO_JOGO PRIMARY KEY (NomeGenero,NomeJogo));");
		stm.executeUpdate("INSERT INTO PublicoAlvo VALUES ('FPS','Counter Strike')");
		stm.executeUpdate("INSERT INTO PublicoAlvo VALUES ('Ação','Counter Strike')");
		stm.executeUpdate("INSERT INTO PublicoAlvo VALUES ('Ação','GTA')");
		stm.executeUpdate("INSERT INTO PublicoAlvo VALUES ('Estratégia','Age of Empires')");
		stm.executeUpdate("INSERT INTO PublicoAlvo VALUES ('Ação','Age of Empires')");
	}

	private static void criarVideo(Statement stm) throws SQLException {
		stm.executeUpdate("DROP TABLE IF EXISTS Video");
		stm.executeUpdate("CREATE TABLE Video (Nome varchar(10) NOT NULL PRIMARY KEY,"
				+ "Preco double NOT NULL, Canal varchar(10) NOT NULL,"
				+ "FOREIGN KEY (Canal) REFERENCES Canal(Nome) ON DELETE CASCADE);");
		stm.executeUpdate("INSERT INTO Video VALUES ('Counter Strike', 10, 'Valve')");
		stm.executeUpdate("INSERT INTO Video VALUES ('GTA', 15, 'Rockstar')");
		stm.executeUpdate("INSERT INTO Video VALUES ('Age of Empires', 20, 'Microsoft')");
	}

	private static void criarCanal(Statement stm) throws SQLException {
		stm.executeUpdate("DROP TABLE IF EXISTS Canal");
		stm.executeUpdate("CREATE TABLE Canal (Nome varchar(10) NOT NULL PRIMARY KEY,"
				+ "Email varchar(10) NOT NULL, Senha varchar(50) NOT NULL);");
		stm.executeUpdate("INSERT INTO Canal VALUES ('Valve','contato@valve.com', 'valve')");
		stm.executeUpdate("INSERT INTO Canal VALUES ('Rockstar','contato@rockstar.com', 'rockstar')");
		stm.executeUpdate("INSERT INTO Canal VALUES ('Microsoft','contato@microsoft.com', 'microsoft')");
	}

	private static void criarInscricao(Statement stm) throws SQLException {
		stm.executeUpdate("DROP TABLE IF EXISTS Inscricao");
		stm.executeUpdate("CREATE TABLE Inscricao (Nome varchar(10) NOT NULL PRIMARY KEY);");
		stm.executeUpdate("INSERT INTO Inscricao VALUES ('Ação')");
		stm.executeUpdate("INSERT INTO Inscricao VALUES ('Estratégia')");
		stm.executeUpdate("INSERT INTO Inscricao VALUES ('FPS')");
	}

	public static void alterarBD(String sql) throws SQLException {
		Connection bd = UtilBD.getConexao();
		Statement stm = bd.createStatement();
		stm.executeUpdate(sql);
		System.out.println("Executei: " + sql);
		stm.close();
	}

	public static ResultSet consultarBD(String sql) throws SQLException {
		Connection bd = UtilBD.getConexao();
		Statement stm = bd.createStatement();
		ResultSet retorno = stm.executeQuery(sql);
		System.out.println("Executei: " + sql);
//		stm.close();
		return retorno;
	}
}