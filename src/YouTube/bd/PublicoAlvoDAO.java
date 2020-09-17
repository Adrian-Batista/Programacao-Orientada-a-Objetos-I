package YouTube.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import YouTube.entidades.Canal;
import YouTube.entidades.Inscricao;
import YouTube.entidades.PublicoAlvo;

public class PublicoAlvoDAO implements InterfaceDAO<Canal> {



	@Override
	public void adicionar(Canal canal) {
		try {
			String sql = "INSERT INTO PublicoAlvo VALUES ('" + canal.getNome() + "','" + canal.getPublico().getOpcao() + "')";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			//AlertaFX.erro("Não foi possível inserir o Publico no banco!");
			System.out.println("Não foi possível inserir o Publico no banco!");
		}
	}

	@Override
	public void remover(Canal canal) {
		try {
			String sql = "DELETE FROM PublicoAlvo WHERE NomeCanal = '" + canal.getNome() + "'";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			//AlertaFX.erro("Não foi possível remover o Publico no banco!");
			System.out.println("Não foi possível remover o Publico no banco!");
		}
	}

	@Override
	public List<Canal> todos() {
		List<Canal> retorno = new ArrayList<Canal>();
		try {
			String sql = "SELECT Nome, Publico Publico FROM Canal";
			ResultSet resultSet = UtilBD.consultarBD(sql);
			while (resultSet.next()) {
				Canal objeto = new Canal(null, null, null, null, null);
				PublicoAlvo P = new PublicoAlvo(null);
				Inscricao I = new Inscricao(null, 0);
				I.setLista(Inscricao.CarregaVetor());
				(objeto).setPublico(P);
				(objeto).setInscrito(I);
				objeto.setNome(resultSet.getString("Nome"));
				objeto.getPublico().setOpcao(resultSet.getString("Publico"));
				retorno.add(objeto);
			}
			resultSet.getStatement().close();
		} catch (SQLException e) {
			//AlertaFX.erro("Não foi possível consultar todos os Publicos do banco!");
			System.out.println("Não foi possível consultar todos os Publicos do banco!");
		}
		return retorno;
	}

	public void atualizar(Canal canal, String auxiliar) {
		try {
			String sql = "UPDATE PublicoAlvo SET "
					+ "NomeCanal = '" + canal.getNome() + "', "
					+ "TipoPublico = '" + canal.getPublico().getOpcao() + "' "
					+ "WHERE NomeCanal = '" + auxiliar + "';";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			//AlertaFX.erro("Não foi possível atualizar o Video do banco!");
			System.out.println("Não foi possível atualizar o Video do banco!");
		}

	}

}
