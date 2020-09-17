package YouTube.bd;

import java.sql.SQLException;
import java.util.List;

import YouTube.entidades.Canal;

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
		try {
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
		}
		
	}

	@Override
	public List<Canal> todos() {
		// TODO Auto-generated method stub
		return null;
	}

	public void atualizar(Canal referencia) {
		// TODO Auto-generated method stub
		
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
