<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="venderCreditos">

	<c:if test="${not empty errorMessage}"><c:out value="${errorMessage}"/></c:if>
	<c:if test="${not empty successMessage}"><c:out value="${successMessage}"/></c:if>

	<p>
		Saldo actual: <c:out value="${saldo}"/>
	</p>

	<form method="POST" action="/credito/vender">
		<p>
			<label for="bankAccountNumber">Cuenta bancaria: </label>
			<input id="bankAccountNumber" name="bankAccountNumber" type="text" value="<c:if test="${not empty bankAccountNumber}"><c:out value="${bankAccountNumber}"/></c:if>" />
		</p>
		<p>
			<label for="credits">Cantidad: </label>
			<input id="credits" name="credits" type="number" step="1" value="<c:if test="${not empty credits}"><c:out value="${credits}"/></c:if>" />
		</p>
		<input type="submit" value="vender"/>
	</form>

</petclinic:layout>
