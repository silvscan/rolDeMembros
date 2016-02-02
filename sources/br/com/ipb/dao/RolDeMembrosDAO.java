package br.com.ipb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.ipb.model.dto.Membro;
import br.com.ipb.util.DaoUteis;

public class RolDeMembrosDAO implements DefaultDAO<Membro>{
	private DaoUteis daoUteis;
	private final String QUERY_SELECT_MEMBROS = "SELECT * "+
											    "FROM `ipbjard_db`.`membrosdb` "+
											    "WHERE id = ?;";
	
	public RolDeMembrosDAO() {
		daoUteis = new DaoUteis();
	}
	@Override
	public void salvar(Membro membro) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Membro> consultar(Membro membro) throws SQLException, Exception {
		List<Membro> listaMembros = new ArrayList<Membro>();
		try (  Connection conexao = ConnectionFactory.getConexao(); 
			   PreparedStatement psSelect = conexao.prepareStatement(QUERY_SELECT_MEMBROS);
			){
			
			psSelect.setInt(1, membro.getId());
			ResultSet rs = psSelect.executeQuery();
			
			while (rs.next()){
				Membro me = new Membro();
				me.setId(rs.getInt("id"));
				me.setNome(rs.getString("nome"));
				me.setDataNascimento(daoUteis.getLocalDateResultSet(rs, "dataNascimento"));
				me.setNaturalidade(rs.getString("naturalidade"));
				me.setNacionalidade(rs.getString("nacionalidade"));
				me.setSexo(rs.getInt("sexo"));
				me.setGrauDeEscolaridade(rs.getString("escolaridade"));
				me.setTipoSanguino(rs.getString("tipoSanguineo"));
				me.setEstadoCivil(rs.getString("estadoCivil"));
				me.getEndereco().setCodEndereco(rs.getInt("codigoEndereco"));
				me.getProfissao().setCodigo(rs.getInt("codigoProfissao"));
				me.setLocalDeTrabalho(rs.getString("localDeTrabalho"));
				me.setTelefoneComercial(rs.getString("telefoneComercial"));
				me.setCelular(rs.getString("celular"));
				me.setEmail(rs.getString("email"));
				me.setConjugue(rs.getString("conjuge"));
				me.setDataCasamento(daoUteis.getLocalDateResultSet(rs, "dataCasamento"));
				me.setNomeDoPai(rs.getString("nomeDoPai"));
				me.setNomeDaMae(rs.getString("nomeDaMae"));
				me.getUnidadeFrequentada().setCodigo(rs.getInt("unidadeFrequentada"));
				me.setDataDeInclusao(daoUteis.getLocalDateResultSet(rs, "dataDeInclusao"));
				me.setAdmitidoPor(rs.getInt("codigoTipoAdmissao"));
				me.setLivroAdmissao(rs.getString("livroDeAdmissao"));
				me.setPaginaAdmissao(rs.getString("paginaDeAdmissao"));
				me.setIgrejaDeOrigem(rs.getString("igrejaDeOrigem"));
				me.setDataDeSaida(daoUteis.getLocalDateResultSet(rs, "dataDeSaida"));
				me.setEleminadoPor(rs.getInt("codigoMotivoEliminacao"));
				me.setLivroEliminacao(rs.getString("livroDeEliminacao"));
				me.setPaginaEliminacao(rs.getString("paginaDeEliminacao"));
				me.setIgrejaDeDestino(rs.getString("igrejaDeDestino"));
				me.setPastorBatizado(rs.getString("pastorBatizado"));
				me.setIgrejaBatizado(rs.getString("igrejaBatizado"));
				me.setDataBatismo(daoUteis.getLocalDateResultSet(rs, "dataDoBatismo"));
				me.setPastorProfissao(rs.getString("pastorDaProfissao"));
				me.setIgrejaProfissao(rs.getString("igrejaDaProfissao"));
				me.setDataProfissao(daoUteis.getLocalDateResultSet(rs, "dataDaProfissao"));
				me.setSociedade(rs.getInt("codigoDaSociedade"));
				me.getCondicao().setCodigo(rs.getInt("codigoDaCondicao"));
				me.setDataDeCadastramento(daoUteis.getLocalDateResultSet(rs, "dataDeCadastramento"));
				me.setDataDeAtualizacao(daoUteis.getLocalDateResultSet(rs, "dataDeAtualizacao"));
				me.setTalentos(rs.getString("talentos"));
				me.setAtaAdmissao(rs.getString("ataDeAdmissao"));
				me.setAtaEliminacao(rs.getString("ataDeEliminacao"));
				
				listaMembros.add(me);
			}
			
		}catch (SQLException sql ) {
			throw sql;
		} catch (Exception e) {
			throw e;
		}
		return listaMembros;
	}

	@Override
	public void editar(Membro membro) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(Membro membro) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}

}

