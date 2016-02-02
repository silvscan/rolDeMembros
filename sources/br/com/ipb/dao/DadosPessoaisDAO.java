package br.com.ipb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import br.com.ipb.model.dto.Membro;
import br.com.ipb.util.DaoUteis;

public class DadosPessoaisDAO implements DefaultDAO<Membro>{
	DaoUteis daoUteis;
	
    public DadosPessoaisDAO() {
    	daoUteis = new DaoUteis();
	}
    
	private final String QUERY_CADASTRO_DADOS_PESSOAIS = "UPDATE `ipbjard_db`.`membrosdb` "
														+"SET                             "
														+"`dataNascimento` = ?,           "
														+"`naturalidade` = ?,             "
														+"`nacionalidade` = ?,            "
														+"`sexo` = ?,                     "
														+"`escolaridade` = ?,             "
														+"`tipoSanguineo` = ?,            "
														+"`estadoCivil` = ?,              "
														+"`conjuge` = ?,                  "
														+"`dataCasamento` = ?,            "
														+"`nomeDoPai` = ?,                "
														+"`nomeDaMae` = ?                 "
														+"                                "
														+"WHERE `id` = ?;                 "
														+";                               ";
	
	@Override
	public void salvar(Membro membro) throws SQLException, Exception {
		try (  Connection conexao = ConnectionFactory.getConexao(); 
				   PreparedStatement psInsert = conexao.prepareStatement(QUERY_CADASTRO_DADOS_PESSOAIS);
				){
			
				psInsert.setDate(1,  daoUteis.setDate(membro.getDataNascimento()));
				psInsert.setString(2, membro.getNaturalidade());
				psInsert.setString(3, membro.getNacionalidade());
				daoUteis.setIntOuNull(psInsert, 4, membro.getSexo());
				psInsert.setString(5, membro.getGrauDeEscolaridade());
				psInsert.setString(6, membro.getTipoSanguino());
				psInsert.setString(7, membro.getEstadoCivil());
				psInsert.setString(8, membro.getConjugue());
				psInsert.setDate(9, daoUteis.setDate(membro.getDataCasamento()));
				psInsert.setString(10, membro.getNomeDoPai());
				psInsert.setString(11, membro.getNomeDaMae());
				psInsert.setInt(12, membro.getId());
				
				psInsert.execute();
				
			}catch (SQLException sql ) {
				throw sql;
			} catch (Exception e) {
				throw e;
			}
	}

	@Override
	public List<Membro> consultar(Membro membro) throws SQLException, Exception {
		return null;
	}

	@Override
	public void editar(Membro membro) throws SQLException, Exception {
		
	}

	@Override
	public void deletar(Membro membro) throws SQLException, Exception {
		
	}
	
}
