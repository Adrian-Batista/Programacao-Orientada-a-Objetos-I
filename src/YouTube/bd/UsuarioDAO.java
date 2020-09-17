package YouTube.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import YouTube.entidades.Usuario;


public class UsuarioDAO implements InterfaceDAO<Usuario> {

	public void adicionar(Usuario usuario) {
		try {
			String sql = "INSERT INTO Usuario (Nome, Email, Senha) VALUES ('" 
					+ usuario.getNome() + "','" 
					+ usuario.getEmail() + "','"
					+ usuario.getSenha() + "')";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			//AlertaFX.erro("Não foi possível inserir o Usuario no banco!");
			System.out.println("Não foi possível inserir o Usuario no banco!");
		}
	}

	public void remover(Usuario usuario) {
		try {
			String sql = "DELETE FROM Usuario WHERE Nome = '" + usuario.getNome() + "';";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			//AlertaFX.erro("Não foi possível remover o Usuario no banco!");
			System.out.println("Não foi possível remover o Usuario no banco!");
		}
	}

	public List<Usuario> todos() {
		List<Usuario> retorno = new ArrayList<Usuario>();
		try {
			String sql = "SELECT id, Nome, Email, Senha FROM Usuario";
			ResultSet resultSet = UtilBD.consultarBD(sql);
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String nome = resultSet.getString("Nome");
				String email = resultSet.getString("Email");
				String senha = resultSet.getString("Senha");
				retorno.add(new Usuario(id, nome, email, senha));
			}
			resultSet.getStatement().close();
		} catch (SQLException e) {
			//AlertaFX.erro("Não foi possível consultar todos os Usuarios do banco!");
			System.out.println("Não foi possível consultar todos os Usuarios do banco!");
		}
		return retorno;
	}

	public Usuario get(String nome) {
		Usuario retorno = new Usuario(0, null, null, null);
		try {
			String sql = "SELECT Id, Email, Senha FROM Usuario WHERE Nome = '" + nome + "'";
			ResultSet resultSet = UtilBD.consultarBD(sql);
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String email = resultSet.getString("Email");
				String senha = resultSet.getString("Senha");
				retorno = new Usuario(id, nome, email, senha);
				
			}
			// PRECISO FECHAR O STATEMENT SÓ DEPOIS!
			resultSet.getStatement().close();
		} catch (SQLException e) {
			//AlertaFX.erro("Não foi possível consultar um Usuario do banco!");
			System.out.println("Não foi possível consultar um Usuario do banco!");
		}
		return retorno;
	}

	public void atualizarNome(Usuario usuario) {
		try {
			String sql = "UPDATE Usuario SET Nome = '" + usuario.getNome() + "' WHERE Email = '" + usuario.getEmail() + "'";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			//AlertaFX.erro("Não foi possível atualizar o usuario no banco!");
			System.out.println("Não foi possível atualizar o usuario no banco!");
		}
	}
	
	public void atualizarEmail(Usuario usuario) {
		try {
			String sql = "UPDATE Usuario SET Email = '" + usuario.getEmail() + "' WHERE Nome = '" + usuario.getNome() + "'";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			//AlertaFX.erro("Não foi possível atualizar o usuario no banco!");
			System.out.println("Não foi possível atualizar o usuario no banco!");
		}
	}
	
	public void atualizarSenha(Usuario usuario) {
		try {
			String sql = "UPDATE Usuario SET Senha = '" + usuario.getSenha() + "' WHERE Nome = '" + usuario.getNome() + "'";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			//AlertaFX.erro("Não foi possível atualizar o usuario no banco!");
			System.out.println("Não foi possível atualizar o usuario no banco!");
		}
	}

}
