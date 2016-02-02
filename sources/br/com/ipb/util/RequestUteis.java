package br.com.ipb.util;

import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;

public class RequestUteis {
	
	public LocalDate getParameterDate(HttpServletRequest req, String name) {
		
		String []  dataArray = req.getParameter(name).split("/");
		return LocalDate.parse(dataArray[2]+"-"+dataArray[1]+"-"+dataArray[0]);
	}

	public Integer getParameterInt(HttpServletRequest req, String name) {
		return Integer.valueOf(req.getParameter(name));
	}

	public String getParameterString(HttpServletRequest req, String name) {
		return req.getParameter(name).trim();
	}

	public boolean validarSeParamentroExisteNaRequest(HttpServletRequest req, String name) {
		return req.getParameter(name) != null && !"".equals(req.getParameter(name));
	}
}
