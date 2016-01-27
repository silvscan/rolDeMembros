package br.com.ipb.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.ipb.model.dto.MotivoAdmissao;
import br.com.ipb.model.dto.Condicao;
import br.com.ipb.model.dto.MotivoEliminacao;
import br.com.ipb.model.dto.Unidade;
import br.com.ipb.model.dto.Profissao;
import br.com.ipb.model.dto.Sociedades;

public class ObterDadosDosCombosDAO {
	private final String QUERY_LISTA_CONDICOES = "select * from `condicoesdb`";
	private final String QUERY_LISTA_UNIDADES = "select * from `unidadesdb`";
	private final String QUERY_LISTA_PROFISSOES = "select * from `profissoesdb`";
	private final String QUERY_LISTA_SOCIEDADES = "select * from `sociedadesdb`";
	private final String QUERY_LISTA_ADMISSOES = "select * from `motivos_admissoesdb`";
	private final String QUERY_LISTA_ELIMINACAO = "select * from `motivos_eliminacoes`";
	
	public List<Condicao> getListaCondicao() {
		List<Condicao> lista = new ArrayList<>();
		try (  Connection conexao = ConnectionFactory.getConexao(); 
			   Statement stmt = conexao.createStatement();){

			ResultSet rs = stmt.executeQuery(QUERY_LISTA_CONDICOES);
			while(rs.next()){
				Condicao condicao = new Condicao();
				condicao.setCodigo(rs.getInt(1));
				condicao.setDescricao(rs.getString(2));
				lista.add(condicao);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Unidade> getListaUnidades() {
		List<Unidade> lista = new ArrayList<>();
		try (  Connection conexao = ConnectionFactory.getConexao(); 
			   Statement stmt = conexao.createStatement();){

			ResultSet rs = stmt.executeQuery(QUERY_LISTA_UNIDADES);
			while(rs.next()){
				Unidade unidade = new Unidade();
				unidade.setCodigo(rs.getInt(1));
				unidade.setDescricao(rs.getString(2));
				lista.add(unidade);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Profissao> getListaProfissoes() {
		List<Profissao> lista = new ArrayList<>();
		try (  Connection conexao = ConnectionFactory.getConexao(); 
			   Statement stmt = conexao.createStatement();){

			ResultSet rs = stmt.executeQuery(QUERY_LISTA_PROFISSOES);
			while(rs.next()){
				Profissao profissao = new Profissao();
				profissao.setCodigo(rs.getInt(1));
				profissao.setProfissao(rs.getString(2));
				lista.add(profissao);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<Sociedades> getListaSociedades() {
		List<Sociedades> lista = new ArrayList<>();
		try (  Connection conexao = ConnectionFactory.getConexao(); 
			   Statement stmt = conexao.createStatement();){

			ResultSet rs = stmt.executeQuery(QUERY_LISTA_SOCIEDADES);
			while(rs.next()){
				Sociedades sociedades = new Sociedades();
				sociedades.setCodigo(rs.getInt(1));
				sociedades.setSociedade(rs.getString(2));
				lista.add(sociedades);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<MotivoAdmissao> getListaAdmissoes() {
		List<MotivoAdmissao> lista = new ArrayList<>();
		try (  Connection conexao = ConnectionFactory.getConexao(); 
			   Statement stmt = conexao.createStatement();){

			ResultSet rs = stmt.executeQuery(QUERY_LISTA_ADMISSOES);
			while(rs.next()){
				MotivoAdmissao motivoAdmissao = new MotivoAdmissao();
				motivoAdmissao.setCodigo(rs.getInt(2));
				motivoAdmissao.setTexto(rs.getString(1));
				lista.add(motivoAdmissao);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return lista;
	}
	
	public List<MotivoEliminacao> getListaEliminacoes() {
		List<MotivoEliminacao> lista = new ArrayList<>();
		try (  Connection conexao = ConnectionFactory.getConexao(); 
			   Statement stmt = conexao.createStatement();){

			ResultSet rs = stmt.executeQuery(QUERY_LISTA_ELIMINACAO);
			while(rs.next()){
				MotivoEliminacao motivoEliminacao = new MotivoEliminacao();
				motivoEliminacao.setCodigo(rs.getInt(1));
				motivoEliminacao.setTexto(rs.getString(2));
				lista.add(motivoEliminacao);
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		return lista;
	}
}
