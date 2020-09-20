package YouTube.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import YouTube.ihc.AlertaFX;

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
			AlertaFX.erro("Não consegui abrir a conexão com o banco!");
		}

		return conexao;
	}

	private static void abrirConexao() {
		try {
			Class.forName("org.sqlite.JDBC");
			conexao = DriverManager.getConnection("jdbc:sqlite:banco.sqlite");
		} catch (SQLException e) {
			AlertaFX.erro("Não consegui abrir a conexão com o banco!");
		} catch (ClassNotFoundException e2) {
			AlertaFX.erro("A biblioteca do SQLite não está funcionando corretamente!");
		}
	}

	public static void fecharConexao() {
		if (conexao == null)
			return;

		try {
			if (!conexao.isClosed())
				conexao.close();
		} catch (SQLException e) {
			AlertaFX.erro("Não consegui fechar a conexão com o banco!");
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
			AlertaFX.erro("Não consegui criar o banco!");
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
		stm.executeUpdate("INSERT INTO Usuario (Nome, Email, Senha) VALUES ('admin','usuario.teste@gmail.com','123');");
		stm.executeUpdate("INSERT INTO Usuario (Nome, Email, Senha) VALUES ('Adrian','Adrian.teste@gmail.com','321');");
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
		stm.executeUpdate("INSERT INTO PublicoAlvo VALUES ('Canal','Todos')");
		stm.executeUpdate("INSERT INTO PublicoAlvo VALUES ('Canal 2','Jovens')");
	}

	private static void criarVideo(Statement stm) throws SQLException {
		stm.executeUpdate("DROP TABLE IF EXISTS Video");
		stm.executeUpdate("CREATE TABLE Video ("
				+ "Nome VARCHAR(50) NOT NULL,"
				+ "Link VARCHAR(100) NOT NULL,"
				+ "Date VARCHAR(10) NOT NULL,"
				+ "Preco INTEGER NOT NULL,"
				+ "NomeCanal VARCHAR(10) NOT NULL,"
				+ "Descricao VARCAHAR(100) NOT NULL"
				//+ "FOREIGN KEY (NomeCanal) REFERENCES Canal(Nome) ON DELETE CASCADE"
				+ ");"

				);
		stm.executeUpdate("INSERT INTO Video VALUES ('Intercâmbio para Programadores', 'https://www.youtube.com/watch?v=xcxz_PmpZ8w', '20/09/2020','16.80', 'Lucas Montano', 'Seja bem vindo ao vídeo 1');");
		stm.executeUpdate("INSERT INTO Video VALUES ('O Framework Que Vou Utilizar (Decisões Técnicas)', 'https://www.youtube.com/watch?v=1yx4KVpQfN4', '20/09/2020', '10', 'Lucas Montano', 'Seja bem vindo ao vídeo 2');");
		stm.executeUpdate("INSERT INTO Video VALUES ('VOU APRENDER TYPESCRIPT (3 motivos)', 'https://www.youtube.com/watch?v=M57zuClvRbM', '20/09/2020', '0', 'Filipe Deschamps', 'Seja bem vindo ao vídeo 3');");
		stm.executeUpdate("INSERT INTO Video VALUES ('Minha Carreira Teria Sido MUITO Melhor', 'https://www.youtube.com/watch?v=NA4srP35Maw&list=RDCMUCU5JicSrEM5A63jkJ2QvGYw&index=14', '20/09/2020', '10.60', 'Filipe Deschamps', 'Seja bem vindo ao vídeo 4');");
		stm.executeUpdate("INSERT INTO Video VALUES ('6 dicas fundamentais para um código de qualidade', 'https://www.youtube.com/watch?v=MMAu_1KMcMA&list=RDCMUCU5JicSrEM5A63jkJ2QvGYw&index=15', '20/09/2020', '0', 'Filipe Deschamps', 'Seja bem vindo ao vídeo 5');");
		
	
	
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
		stm.executeUpdate("INSERT INTO Canal VALUES ('Filipe Deschamps','Filipe.teste@gmail.com', 'Seja bem vindo ao Canal Filipe D.', 'Todos', '1')");
		stm.executeUpdate("INSERT INTO Canal VALUES ('Lucas Montano','Lucas.teste@gmail.com', 'Seja bem vindo ao Canal Lucas Montano', 'Jovens', '2')");
		stm.executeUpdate("INSERT INTO Canal VALUES ('Curso em Vídeo','CeV.teste@gmail.com', 'Seja bem vindo ao Canal Curso em Vídeo', 'Todos', '3')");
		stm.executeUpdate("INSERT INTO Canal VALUES ('Fabio Akita','Fabio.teste@gmail.com', 'Seja bem vindo ao Canal Fabio Akita', 'Jovens', '2')");
		
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
		stm.executeUpdate("INSERT INTO Inscricao VALUES ('Canal', 'usuario')");
		stm.executeUpdate("INSERT INTO Inscricao VALUES ('Canal 2', 'usuario')");
		stm.executeUpdate("INSERT INTO Inscricao VALUES ('Canal 2', 'usuario2')");
	}

	public static void alterarBD(String sql) throws SQLException {
		Connection bd = UtilBD.getConexao();
		Statement stm = bd.createStatement();
		stm.executeUpdate(sql);
		stm.close();
	}

	@SuppressWarnings("exports")
	public static ResultSet consultarBD(String sql) throws SQLException {
		Connection bd = UtilBD.getConexao();
		Statement stm = bd.createStatement();
		ResultSet retorno = stm.executeQuery(sql);
		return retorno;
	}
}