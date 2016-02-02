package br.com.ipb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.ipb.model.dto.Membro;
import br.com.ipb.util.DaoUteis;

public class DadosCadastraisDAO implements DefaultDAO<Membro>{
    private final String QUERY_CADASTRO_DADOS_CADASTRAIS = "INSERT INTO `ipbjard_db`.`membrosdb`(`id`,`nome`,`codigoDaCondicao`,`unidadeFrequentada`,`dataDeCadastramento`, `dataDeAtualizacao`) VALUES (?,?,?,?,?,?)";
    private final String QUERY_SELECT_MEMBRO = "SELECT * FROM `ipbjard_db`.`membrosdb` WHERE ID = ?";
	
    DaoUteis daoUteis;
    public DadosCadastraisDAO() {
    	daoUteis = new DaoUteis();
	}
    
    @Override
    public void salvar(Membro membro) throws SQLException, Exception{
		try (  Connection conexao = ConnectionFactory.getConexao(); 
			   PreparedStatement psSelect = conexao.prepareStatement(QUERY_SELECT_MEMBRO);
			   PreparedStatement psInsert = conexao.prepareStatement(QUERY_CADASTRO_DADOS_CADASTRAIS);
			){

			psSelect.setInt(1, membro.getId());
			ResultSet rs = psSelect.executeQuery();
			
			while (rs.next()){
				throw new IllegalArgumentException("Já existe um usuário cadastrado com o código informado!");
			}
			
			psInsert.setInt(1, membro.getId());
			psInsert.setString(2, membro.getNome());
			psInsert.setInt(3, membro.getCondicao().getCodigo());
			psInsert.setInt(4, membro.getUnidadeFrequentada().getCodigo());
			psInsert.setDate(5, daoUteis.setDate(membro.getDataDeCadastramento()));
			psInsert.setDate(6, daoUteis.setDate(membro.getDataDeAtualizacao()));
			
			psInsert.execute();
			
		}catch (SQLException sql ) {
			throw sql;
		} catch (Exception e) {
			throw e;
		}
    }
    
    @Override
	public List<Membro> consultar(Membro membro) throws SQLException, Exception {
		List<Membro> listaMembros = new ArrayList<Membro>();
		
		try (  Connection conexao = ConnectionFactory.getConexao(); 
			   PreparedStatement psSelect = conexao.prepareStatement(construirSelectDinamico(membro));
			){
			
			setarParametrosDoSelectDinamicamente(membro, psSelect);
			ResultSet rs = psSelect.executeQuery();
			
			while (rs.next()){
				Membro me = new Membro();
				me.setId(rs.getInt(1));
				me.setNome(rs.getString(2));
				me.setDataNascimento(rs.getDate(3) != null ? rs.getDate(3).toLocalDate() : null);
				me.getCondicao().setCodigo(rs.getInt(4));
				me.getCondicao().setDescricao(rs.getString(5));
				me.getEndereco().setCodEndereco(rs.getInt(6));
				me.getEndereco().setEndereco(rs.getString(7));
				me.getEndereco().setBairro(rs.getString(8));
				me.getEndereco().setCidade(rs.getString(9));
				me.getEndereco().setTelefoneRes(rs.getString(10));
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
	public void editar(Membro t) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void deletar(Membro t) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}
	
	private String construirSelectDinamico(Membro membro) {
		String query = "select   membro.id,                        "+
							    "membro.nome,                      "+
								"membro.dataNascimento,                  "+
								"cond.codigo,                    "+
								"cond.descricao,               "+
								"endereco.codigo,                  "+
								"endereco.endereco,                "+
						        "endereco.bairro,                  "+
						        "endereco.cidade,                  "+
						        "endereco.telefoneResidencial              "+
						
						"from	`ipbjard_db`.`condicoesdb` cond,   			"+
								"`ipbjard_db`.`membrosdb` membro left join     "+
								"`ipbjard_db`.`enderecosdb` endereco      			"+
						
						"ON     endereco.codigo = membro.codigoEndereco			"+
								
						"where  membro.codigoDaCondicao = cond.codigo  				"+
						"													";
		
		if (membro.getId() > 0){
			query += " AND membro.id = ?"; 
		}
		if (membro.getNome() != null && !"".equals(membro.getNome())){
			query += " AND membro.nome like ? "; 
		}
		if (membro.getCondicao().getCodigo() > 0){
			query += " AND membro.codigoDaCondicao = ?"; 
		}
		query += " order by membro.nome";
		return query;
	}
	
	private void setarParametrosDoSelectDinamicamente(Membro membro, PreparedStatement psSelect) throws SQLException {
		int posicao = 0;
		if (membro.getId() > 0){
			psSelect.setInt(++posicao, membro.getId()); 
		}
		if (membro.getNome() != null && !"".equals(membro.getNome())){
			psSelect.setString(++posicao, "%"+membro.getNome()+"%"); 
		}
		if (membro.getCondicao().getCodigo() > 0){
			psSelect.setInt(++posicao, membro.getCondicao().getCodigo()); 
		}
	}

}
