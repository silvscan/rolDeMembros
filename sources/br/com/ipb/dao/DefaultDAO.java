package br.com.ipb.dao;

import java.sql.SQLException;
import java.util.List;

public interface DefaultDAO<T> {
	
	public void salvar(T t) throws SQLException, Exception;
	public List<T> consultar(T t) throws SQLException, Exception;
	public void editar(T t) throws SQLException, Exception;
	public void deletar(T t) throws SQLException, Exception;

}
