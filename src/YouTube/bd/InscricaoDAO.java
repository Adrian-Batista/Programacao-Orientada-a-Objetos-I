package YouTube.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import YouTube.entidades.Canal;
import YouTube.entidades.Inscricao;
import YouTube.entidades.PublicoAlvo;

public class InscricaoDAO implements InterfaceDAO<Canal>{

	@Override
	public void adicionar(Canal inscricao) {
		/*try {
			for(int j =0; j<inscricao.getInscrito().getLista().length; j++) {
				if(inscricao.getInscrito().getLista()[j].getNome()==null) {
					break;
				}
				String sql = "INSERT INTO Inscricao VALUES ('" + inscricao.getNome() + "','" + inscricao.getInscrito().getLista()[j].getNome() + "');";
				UtilBD.alterarBD(sql);
			}

		} catch (SQLException e) {
			//AlertaFX.erro("Não foi possível inserir a inscricao no banco!");
			System.out.println("Não foi possível inserir a inscricao no banco!");
		}*/
	}

	@Override
	public void remover(Canal inscricao) {
		/*try {
			for(int j =0; j<inscricao.getInscrito().getLista().length; j++) {
				if(inscricao.getInscrito().getLista()[j].getNome()==null) {
					break;
				}
			String sql = "DELETE FROM Inscricao WHERE NomeCanal = '" + inscricao.getNome() + "', NomeUsuario = '" + inscricao.getInscrito().getLista()[j].getNome() + "' ";
			UtilBD.alterarBD(sql);
			}
		} catch (SQLException e) {
			//AlertaFX.erro("Não foi possível remover a inscricao do banco!");
			System.out.println("Não foi possível remover a Inscricao no banco!");
		}*/

	}

	@Override
	public List<Canal> todos() {
		List<Canal> retorno = new ArrayList<Canal>();
		try {
			String sql = "SELECT NomeCanal, NomeUsuario FROM Inscricao";
			ResultSet resultSet = UtilBD.consultarBD(sql);
			while (resultSet.next()) {
				Canal objeto = new Canal(null, null, null, null, null);
				PublicoAlvo P = new PublicoAlvo(null);
				Inscricao I = new Inscricao(null, 0);
				I.setLista(Inscricao.CarregaVetor());
				(objeto).setPublico(P);
				(objeto).setInscrito(I);
				objeto.setNome(resultSet.getString("NomeCanal"));
				for(int i =0; i<objeto.getInscrito().getLista().length; i++) {
					if(objeto.getInscrito().getLista()[i].getNome()==null) {
						objeto.getInscrito().getLista()[i].setNome(resultSet.getString("NomeUsuario"));
						break;
					}
				}
				retorno.add(objeto);
			}
			resultSet.getStatement().close();
		} catch (SQLException e) {
			//AlertaFX.erro("Não foi possível consultar todos os Inscritos do banco!");
			System.out.println("Não foi possível consultar todos os Inscritos do banco!");
		}
		return retorno;	
	}

	public void adicionarInscricao(Canal canal, String auxiliar) {
		try {
			String sql = "INSERT INTO Inscricao VALUES ('" + canal.getNome() + "','" + auxiliar + "')";
			UtilBD.alterarBD(sql);

		} catch (SQLException e) {
			//AlertaFX.erro("Não foi possível inserir a inscricao no banco!");
			System.out.println("Não foi possível inserir a inscricao no banco!");
		}
	}

	public void removerInscricao(Canal inscricao, String nomeuser) {
		try {
			String sql = "DELETE FROM Inscricao WHERE "
					+ "NomeCanal = '" + inscricao.getNome() + "' AND NomeUsuario = '" + nomeuser + "';";
			UtilBD.alterarBD(sql);
		} catch (SQLException e) {
			//AlertaFX.erro("Não foi possível remover a inscricao do banco!");
			System.out.println("Não foi possível remover a Inscricao no banco!");
		}
	}

}
