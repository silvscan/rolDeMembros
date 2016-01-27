package br.com.ipb.model.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.ipb.dao.DadosCadastraisDAO;
import br.com.ipb.model.dto.Membro;

public class BOConsultarInformacoesMembro {
	private Membro membro;
	private DadosCadastraisDAO dadosCadastraisDAO;
	
	public BOConsultarInformacoesMembro() {
		dadosCadastraisDAO = new DadosCadastraisDAO();
	}
	
	public List<Membro> consulta() {
		try {
			return dadosCadastraisDAO.consultar(membro);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Membro getMembro() {
		return membro;
	}

	public void setMembro(Membro membro) {
		this.membro = membro;
	}
}
