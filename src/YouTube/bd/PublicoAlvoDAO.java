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
	public void adicionar(Canal referencia) {
		try {
			String sql = "INSERT INTO PublicoAlvo VALUES ('" + referencia.getNome() + "','" + referencia.getPublico().getOpcao() + "')";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			//AlertaFX.erro("Não foi possível inserir o Usuario no banco!");
			System.out.println("Não foi possível inserir o jogador no banco!");
		}
	}

	public void atualizar(Canal referencia) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(Canal referencia) {
		try {
			String sql = "DELETE FROM PublicoAlvo WHERE NomeCanal = '" + referencia.getNome() + "'";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			//AlertaFX.erro("Não foi possível remover o Canal do banco!");
		}
		
	}

	@Override
	public List<Canal> todos() {
		List<Canal> retorno = new ArrayList<Canal>();
		try {
			String sql = "SELECT Nome, Publico FROM Canal";
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
			//AlertaFX.erro("Não foi possível consultar todas os Canais do banco!");
		}
		return retorno;
	}

}
