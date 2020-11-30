<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="prganizaciones">
    <h2>
        <c:if test="${organizacion['new']}">New </c:if> Organizacion
    </h2>
    <form:form modelAttribute="organizacion" class="form-horizontal" id="add-organizacionform">
        <div class="form-group has-feedback">
            <petclinic:inputField label="First Name" name="nombre"/>
            <petclinic:inputField label="Last Name" name="apellidos"/>
            <petclinic:inputField label="Address" name="direccion"/>
            <petclinic:inputField label="Telephone" name="telefono"/>
            <petclinic:inputField label="Email" name="email"/>
            <petclinic:inputField label="Username" name="cuenta_actor.username"/>
            <petclinic:inputField label="Password" name="cuenta_actor.password"/>

        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${organizacion['new']}">
                        <button class="btn btn-default" type="submit">Add Organizacion</button>
                    </c:when>
                    <c:otherwise>
                        <button class="btn btn-default" type="submit">Update Organizacion</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
</petclinic:layout>
