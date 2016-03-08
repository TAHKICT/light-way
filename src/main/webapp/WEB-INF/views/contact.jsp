<%@ page import="net.schastny.contactmanager.domain.Rate" %>
<%@ page import="net.schastny.contactmanager.service.RateService" %>
<%@ page import="net.schastny.contactmanager.service.RateServiceImpl" %>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf8">
	<title><spring:message code="label.title" /></title>
</head>
<body>

<a href="<c:url value="/logout" />">
	<spring:message code="label.logout" />
</a>
  
<h2><spring:message code="label.title" /></h2>

<form:form method="post" action="add" commandName="rate">

	<table>
		<tr>
			<td><form:label path="bankId">
				<spring:message code="label.bankId" />
			</form:label></td>
			<td><form:input path="bankId" /></td>
		</tr>
		<tr>
			<td><form:label path="TTime">
				<spring:message code="label.TTime" />
			</form:label></td>
			<td><form:input path="TTime" /></td>
		</tr>
		<tr>
			<td><form:label path="USDbuy">
				<spring:message code="label.USDbuy" />
			</form:label></td>
			<td><form:input path="USDbuy" /></td>
		</tr>
		<tr>
			<td><form:label path="USDsell">
				<spring:message code="label.USDsell" />
			</form:label></td>
			<td><form:input path="USDsell" /></td>
		</tr>
		<tr>
			<td><form:label path="EURbuy">
				<spring:message code="label.EURbuy" />
			</form:label></td>
			<td><form:input path="EURbuy" /></td>
		</tr>
		<tr>
			<td><form:label path="EURsell">
				<spring:message code="label.EURsell" />
			</form:label></td>
			<td><form:input path="EURsell" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit"
				value="<spring:message code="label.addrate"/>" /></td>
		</tr>
	</table>
</form:form>

<table class="data">
	<tr>
		<th><spring:message code="label.bankId" /></th>
		<th><spring:message code="label.TTime" /></th>
		<th><spring:message code="label.USDbuy" /></th>
		<th><spring:message code="label.USDsell" /></th>
		<th><spring:message code="label.EURbuy" /></th>
		<th><spring:message code="label.EURsell" /></th>
		<th>&nbsp;</th>
	</tr>
	<c:forEach items="${allRates1}" var="rate">
		<tr>
			<td>${rate.bankId}</td>
			<td>${rate.TTime}</td>
			<td>${rate.USDbuy}</td>
			<td> ${rate.USDsell}</td>
			<td>${rate.EURbuy}</td>
			<td> ${rate.EURsell}</td>
		</tr>
	</c:forEach>
</table>
<h3><spring:message code="label.rates" /></h3>
<c:if test="${!empty contactList}">
	<table class="data">
		<tr>
			<th><spring:message code="label.bankId" /></th>
			<th><spring:message code="label.TTime" /></th>
			<th><spring:message code="label.USDbuy" /></th>
			<th><spring:message code="label.USDsell" /></th>
			<th><spring:message code="label.EURbuy" /></th>
			<th><spring:message code="label.EURsell" /></th>
			<th>&nbsp;</th>
		</tr>
		<c:forEach items="${contactList}" var="rate">
			<tr>
				<td>${rate.bankId}</td>
				<td>${rate.TTime}</td>
				<td>${rate.USDbuy}</td>
				<td> ${rate.USDsell}</td>
				<td>${rate.EURbuy}</td>
				<td> ${rate.EURsell}</td>
				<td><a href="delete/${rate.id}"><spring:message code="label.delete" /></a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>

</body>
</html>