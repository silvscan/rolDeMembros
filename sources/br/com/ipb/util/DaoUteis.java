package br.com.ipb.util;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class DaoUteis {

	public Date setDate(LocalDate localDate) {
		if (localDate != null){
			return Date.valueOf(localDate);
		}
		return null;
	}
	
	public LocalDate getLocalDateResultSet(ResultSet rs, String columName) throws SQLException {
		return rs.getDate(columName) != null ? rs.getDate(columName).toLocalDate() : null;
	}

	public void setIntOuNull(PreparedStatement psInsert, int posicao, Integer var) throws SQLException {
		if (var != null){
			psInsert.setInt(posicao, var);
		} else {
			psInsert.setNull(posicao, -1);
		}
	}
}
