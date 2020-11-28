<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="producto">

    <h2>Información de producto</h2>

    <table class="table table-striped">
        <tr>
            <th>Nombre</th>
            <td><b><c:out value="${producto.nombre}"/></b></td>
        </tr>
        <tr>
            <th>Descripción</th>
            <td><b><c:out value="${producto.descripción}"/></b></td>
        </tr>
        <tr>
            <th>Precio</th>
            <td><c:out value="${producto.precio}"/></td>
        </tr>
        <tr>
            <th>Cantidad</th>
            <td><c:out value="${producto.cantidad}"/></td>
        </tr>
        <tr>
            <th>Descuento</th>
            <td><c:out value="${producto.descuento}"/></td>
        </tr>
    </table>

    <!-- <spring:url value="{ownerId}/edit" var="editUrl">
        <spring:param name="ownerId" value="${owner.id}"/>
    </spring:url>
    <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">Edit Owner</a> -->

</petclinic:layout>
