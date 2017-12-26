<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="rpa.models.UserAccount"%>
<%@ page import="com.google.gson.Gson"%>
<% 	
	if(session.getAttribute("userinfo")==null){		
		String redirectURL = "login.jsp";
        response.sendRedirect(redirectURL);
	}else{
		String ujson =  String.valueOf(session.getAttribute("userinfo"));
		UserAccount account = new Gson().fromJson(ujson, UserAccount.class);
	}		
%>