package YouTube.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import YouTube.entidades.Canal;
import YouTube.entidades.Video;

public class VideoDAO implements InterfaceDAO<Video> {

	@Override
	public void adicionar(Video video) {
		try {
			String sql = "INSERT INTO Video VALUES ('" + video.getNome() + "','" 
					+ video.getLink() + "','" 
					+ video.getDate() + "','" 
					+ video.getPreco() + "','"
					+ video.getCanal().getNome() + "','"
					+ video.getDescricao() + "')";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			//AlertaFX.erro("Não foi possível inserir o Video no banco!");
			System.out.println("Não foi possível inserir o Video no banco!");
		}
	}

	@Override
	public void remover(Video referencia) {
		try {
			String sql = "DELETE FROM Video WHERE Nome = '" + referencia.getNome() + "'";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			//AlertaFX.erro("Não foi possível remover o Video do banco!");
			System.out.println("Não foi possível remover o Video do banco!");
		}
		
	}

	@Override
	public List<Video> todos() {
		List<Video> retorno = new ArrayList<Video>();
		try {
			String sql = "SELECT * FROM Video";
			ResultSet resultSet = UtilBD.consultarBD(sql);
			while (resultSet.next()) {
				Video objeto = new Video(null, null, null, null, null);
				Canal C = new Canal(null, null, null, null, null);
				objeto.setCanal(C);
				objeto.setNome(resultSet.getString("Nome"));
				objeto.setLink(resultSet.getString("Link"));
				objeto.setDate(resultSet.getString("Date"));
				objeto.setPreco(resultSet.getDouble("Preco"));
				objeto.getCanal().setNome(resultSet.getString("NomeCanal"));
				objeto.setDescricao(resultSet.getString("Descricao"));
				retorno.add(objeto);
			}
			resultSet.getStatement().close();
		} catch (SQLException e) {
			//AlertaFX.erro("Não foi possível consultar todas os Canais do banco!");
			System.out.println("Não foi possível consultar todas os Canais do banco!");
		}
		return retorno;
	}

	public void atualizar(Video video, String auxiliar) {
		try {
			String sql = "UPDATE Video SET "
					+ "Nome = '" + video.getNome() + "', "
					+ "Link = '" + video.getLink() + "', "
					+ "Date = '" + video.getDate() + "', "
					+ "Preco = '" + video.getPreco() + "', "
					+ "NomeCanal = '" + video.getCanal().getNome() + "', "
					+ "Descricao = '" + video.getDescricao() + "' "
					+ "WHERE Nome = '" + auxiliar + "';";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			//AlertaFX.erro("Não foi possível atualizar o Video do banco!");
			System.out.println("Não foi possível atualizar o Video do banco!");
		}
		
	}

}
