<%@ page import="com.google.gson.Gson" %>
<%@ page import="pl.server.ErrorCode" %>
<%= new Gson().toJson(ErrorCode.UNAUTHORIZED.getEntity()) %>
