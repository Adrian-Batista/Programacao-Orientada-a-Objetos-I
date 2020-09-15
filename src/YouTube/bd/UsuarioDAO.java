package YouTube.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import YouTube.entidades.Usuario;


public class UsuarioDAO implements InterfaceDAO<Usuario> {

	public void adicionar(Usuario referencia) {
		try {
			String sql = "INSERT INTO Usuario VALUES ('" + referencia.getNome() + "','" + referencia.getEmail() + "','"
					+ referencia.getSenha() + "')";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			//AlertaFX.erro("Não foi possível inserir o jogador no banco!");
			System.out.println("Não foi possível inserir o jogador no banco!");
		}
	}

	public void remover(Usuario referencia) {
		try {
			String sql = "DELETE FROM Usuario WHERE nome = '" + referencia.getNome() + "'";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			//AlertaFX.erro("Não foi possível remover o jogador do banco!");
			System.out.println("Não foi possível remover o jogador do banco!");
		}
	}

	public List<Usuario> todos() {
		List<Usuario> retorno = new ArrayList<Usuario>();
		try {
			String sql = "SELECT Nome, Email, Senha FROM Usuario";
			ResultSet resultSet = UtilBD.consultarBD(sql);
			while (resultSet.next()) {
				String nome = resultSet.getString("Nome");
				String email = resultSet.getString("Email");
				String senha = resultSet.getString("Senha");
				retorno.add(new Usuario(nome, email, senha));
			}
			resultSet.getStatement().close();
		} catch (SQLException e) {
			//AlertaFX.erro("Não foi possível consultar todos os jogadores do banco!");
			System.out.println("Não foi possível consultar todos os jogadores do banco!");
		}
		return retorno;
	}

	public Usuario get(String nome) {
		Usuario retorno = null;
		try {
			String sql = "SELECT Email, Senha FROM Usuario WHERE Nome = '" + nome + "'";
			ResultSet resultSet = UtilBD.consultarBD(sql);
			while (resultSet.next()) {
				String email = resultSet.getString("Email");
				String senha = resultSet.getString("Senha");
				retorno = new Usuario(nome, email, senha);
			}
			// PRECISO FECHAR O STATEMENT SÓ DEPOIS!
			resultSet.getStatement().close();
		} catch (SQLException e) {
			//AlertaFX.erro("Não foi possível consultar um jogador do banco!");
			System.out.println("Não foi possível consultar um jogador do banco!");
		}
		return retorno;
	}

}
