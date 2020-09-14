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
			//AlertaFX.erro("Não consegui abrir a conexão com o banco!");
			System.out.println("Não consegui abrir a conexão com o banco!");
		}

		return conexao;
	}

	private static void abrirConexao() {
		try {
			Class.forName("org.sqlite.JDBC");
			conexao = DriverManager.getConnection("jdbc:sqlite:banco.sqlite");
		} catch (SQLException e) {
			//AlertaFX.erro("Não consegui abrir a conexão com o banco!");
			System.out.println("Não consegui abrir a conexão com o banco!");
		} catch (ClassNotFoundException e2) {
			//AlertaFX.erro("A biblioteca do SQLite não está funcionando corretamente!");
			System.out.println("A biblioteca do SQLite não está funcionando corretamente!");
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
			System.out.println("Não consegui fechar a conexão com o banco!");
		}
	}

	public static void initBD() {
		try {
			conexao = getConexao();
			Statement stm = conexao.createStatement();
			//criarInscricao(stm);
			//criarCanal(stm);
			//criarVideo(stm);
			criarPublicoAlvo(stm);
			criarUsuario(stm);
			stm.executeUpdate("PRAGMA foreign_keys=ON");
			stm.close();
		} catch (SQLException e) {
			//AlertaFX.erro("Não consegui criar o banco!");
			System.out.println("Não consegui criar o banco!");
		}
	}

	private static void criarUsuario(Statement stm) throws SQLException {		
		stm.executeUpdate("DROP TABLE IF EXISTS Usuario");
		stm.executeUpdate("CREATE TABLE Usuario ("
			+ "Nome VARCHAR(10) PRIMARY KEY NOT NULL,"
			+ "Email VARCHAR(30) NOT NULL,"
			+ "senha VARCHAR(20) NOT NULL"
			+ ");"
		);
		stm.executeUpdate("INSERT INTO Usuario VALUES ('usuario','usuario.teste@gmail.com','123');");
		stm.executeUpdate("INSERT INTO Usuario VALUES ('usuario2','usuario2.teste@gmail.com','321');");
}	

	private static void criarPublicoAlvo(Statement stm) throws SQLException {
		stm.executeUpdate("DROP TABLE IF EXISTS PublicoAlvo");
		stm.executeUpdate("CREATE TABLE PublicoAlvo (TipoPublico varchar(10) NOT NULL," + "NomeCanal varchar(10) NOT NULL,"
				+ "FOREIGN KEY (NomeCanal) REFERENCES Canal(Nome) ON DELETE CASCADE;");
		stm.executeUpdate("INSERT INTO PublicoAlvo VALUES ('Canal','Todos')");
		stm.executeUpdate("INSERT INTO PublicoAlvo VALUES ('Canal 2','Jovens')"
				
	);
	}

	private static void criarVideo(Statement stm) throws SQLException {
		stm.executeUpdate("DROP TABLE IF EXISTS Video");
		stm.executeUpdate("CREATE TABLE Video (Nome varchar(20) NOT NULL PRIMARY KEY,"
				+ "Link varchar(30) NOT NULL, Date varchar(10) NOT NULL, Canal varchar(10) NOT NULL, Descricao varchar(100) NOT NULL, Preco double NOT NULL,"
				+ "FOREIGN KEY (Canal) REFERENCES Canal(Nome) ON DELETE CASCADE);");
		stm.executeUpdate("INSERT INTO Video VALUES ('Video 1', https:, '11/09/2020', 'Canal', 'Seja bem vindo ao vídeo 1')");
		stm.executeUpdate("INSERT INTO Video VALUES ('Video 2', https:/, '11/09/2020'), 'Canal', 'Seja bem vindo ao vídeo 2'");
		stm.executeUpdate("INSERT INTO Video VALUES ('Video 3', https://, '12/09/2020', 'Canal', 'Seja bem vindo ao vídeo 3')");
	}

	private static void criarCanal(Statement stm) throws SQLException {
		stm.executeUpdate("DROP TABLE IF EXISTS Canal");
		stm.executeUpdate("CREATE TABLE Canal (Nome varchar(10) NOT NULL PRIMARY KEY,"
				+ "Email varchar(30) NOT NULL, Descricao varchar(100) NOT NULL, PublicoAlvo varchar(10) NOT NULL, Inscricao int NOT NULL,"
				+ "FOREIGN KEY (PublicoAlvo) REFERENCES PublicoAlvo(Nome) ON DELETE CASCADE;");
		stm.executeUpdate("INSERT INTO Canal VALUES ('Canal','canal.teste@gmail.com', 'Seja bem vindo ao Canal', 'Todos', '1')");
		stm.executeUpdate("INSERT INTO Canal VALUES ('Canal 2','canal2.teste@gmail.com', 'Seja bem vindo ao Canal 2', 'Jovens', '2')");
		
	}

	private static void criarInscricao(Statement stm) throws SQLException {
		stm.executeUpdate("DROP TABLE IF EXISTS Inscricao");
		stm.executeUpdate("CREATE TABLE Inscricao (Canal varchar(10) NOT NULL PRIMARY KEY),"
				+ "Nome varchar(10) NOT NULL,"
				+ "FOREIGN KEY (Canal) REFERENCES Canal(Nome) ON DELETE CASCADE,"
				+ "FOREIGN KEY (Nome) REFERENCES Usuario(Nome) ON DELETE CASCADE;");
		stm.executeUpdate("INSERT INTO Inscricao VALUES ('Canal', 'usuario')");
		stm.executeUpdate("INSERT INTO Inscricao VALUES ('Canal 2', 'usuario')");
		stm.executeUpdate("INSERT INTO Inscricao VALUES ('Canal 2'), 'usuario2' ");
	}

	public static void alterarBD(String sql) throws SQLException {
		Connection bd = UtilBD.getConexao();
		Statement stm = bd.createStatement();
		stm.executeUpdate(sql);
		System.out.println("Executei: " + sql);
		stm.close();
	}

	@SuppressWarnings("exports")
	public static ResultSet consultarBD(String sql) throws SQLException {
		Connection bd = UtilBD.getConexao();
		Statement stm = bd.createStatement();
		ResultSet retorno = stm.executeQuery(sql);
		System.out.println("Executei: " + sql);
		stm.close();
		return retorno;
	}
}