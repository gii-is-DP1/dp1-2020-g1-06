<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

<petclinic:layout pageName="Lista productos">

<c:if test="${message != null}"><c:out value="${message}"/></c:if>

	<table id="productosTable" class="table table-striped">
        <thead>
        <tr>
        	<th style="width: 240px;">Nombre</th>
            <th style="width: 180px;">Descripcion</th>
            <th style="width: 200px;">Precio</th>
            <th style="width: 120px;">Cantidad</th>
            <th style="width: 160px;">Descuento</th>
            <th style="width: 160px;">Actor</th>
            <th style="width: 160px;"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${productos}" var="producto">
            <tr>
            	<td>
                    <c:out value="${producto.nombre} "/>
                </td> 
                <td>
                    <c:out value="${producto.descripcion}"/>
                </td>
                <td>
                    <c:out value="${producto.precio}"/>
                </td>
                <td>
					<c:out value="${producto.cantidad}"/>
                </td>
                <td>
                    <c:out value="${producto.descuento}"/>
                </td>
                <td>
                    <c:out value="${producto.actor.nombre}"/>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    
    <a href="/producto/new"><input class="btn btn-default" type="button" value="Añadir un nuevo producto"/></a>
</petclinic:layout>