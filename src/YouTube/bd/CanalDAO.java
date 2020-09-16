package YouTube.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import YouTube.entidades.Canal;
import YouTube.entidades.Inscricao;
import YouTube.entidades.PublicoAlvo;

public class CanalDAO implements InterfaceDAO<Canal> {

	public void adicionar(Canal canal) {
		try {
			String sql = "INSERT INTO Canal VALUES ('" + canal.getNome() + "','"
					+ canal.getEmail() + "','"
					+ canal.getDescricao() + "','"
					+ canal.getPublico().getOpcao() + "','"
					+ canal.getInscrito().getNumeroInscritos() + "')";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			//AlertaFX.erro("Não foi possível inserir a desenvolvedora no banco!");
			System.out.println("Não foi possível inserir a desenvolvedora no banco!");
		}
	}

	public void remover(Canal canal) {
		try {
			String sql = "DELETE FROM Canal WHERE nome = '" + canal.getNome() + "'";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			//AlertaFX.erro("Não foi possível remover o Canal do banco!");
		}

	}

	public List<Canal> todos() {
		List<Canal> retorno = new ArrayList<Canal>();
		try {
			String sql = "SELECT * FROM Canal";
			ResultSet resultSet = UtilBD.consultarBD(sql);
			while (resultSet.next()) {
				Canal objeto = new Canal(null, null, null, null, null);
				PublicoAlvo P = new PublicoAlvo(null);
				Inscricao I = new Inscricao(null, 0);
				I.setLista(Inscricao.CarregaVetor());
				(objeto).setPublico(P);
				(objeto).setInscrito(I);
				objeto.setNome(resultSet.getString("Nome"));
				objeto.setEmail(resultSet.getString("Email"));
				objeto.setDescricao(resultSet.getString("Descricao"));
				objeto.getPublico().setOpcao(resultSet.getString("Publico"));
				objeto.getInscrito().setNumeroInscritos(resultSet.getInt("Inscricao"));
				retorno.add(objeto);
			}
			resultSet.getStatement().close();
		} catch (SQLException e) {
			//AlertaFX.erro("Não foi possível consultar todas os Canais do banco!");
		}
		return retorno;
	}

	public Canal get(String nome) {
		Canal retorno = null;
		try {
			String sql = "SELECT Email, Senha FROM Canalw WHERE Nome = '" + nome + "'";
			ResultSet resultSet = UtilBD.consultarBD(sql);
			while (resultSet.next()) {
				//String email = resultSet.getString("Email");
				//String senha = resultSet.getString("Senha");
				//retorno = new Canal(nome, email, senha, senha, 0);
			}
			resultSet.getStatement().close();
		} catch (SQLException e) {
			//AlertaFX.erro("Não foi possível consultar um Canal do banco!");
		}
		return retorno;
	}

	@Override
	public void atualizar(Canal referencia) {
		// TODO Auto-generated method stub
		
	}

}
