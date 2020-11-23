<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="producto">

    <h2>Lista de productos</h2>

	<table id="productosTable" class="table table-striped">
        <thead>
        <tr>
            <th>Nombre</th>
            <th>Descripción</th>
            <th>Precio</th>
            <th>Descuento</th>
            <th>Cantidad</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${productos}" var="producto">
            <tr>
                <td>
                    <c:out value="${producto.nombre}"/>
                </td>
                <td>
                    <c:out value="${producto.descripción}"/>
                </td>
                <td>
                    <c:out value="${producto.precio}"/>
                </td>
                <td>
                    <c:out value="${producto.descuento}"/>
                </td>
                <td>
                    <c:out value="${producto.cantidad}"/>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</petclinic:layout>
