<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="es">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <title>Pilot Test</title>
        <style>
            <%@include file="/WEB-INF/styles/style.css"%>
        </style>

    </head>

    <body>

        <header>
            <h1>CRUD Conectado a SQL Server - Elaborado por BitsTeam</h1>
        </header>

        <section>

            <div class="add"><a href="${pageContext.request.contextPath}/?action=openCreate">Agregar persona</a></div>

            <table class="table">
                <thead>
                    <tr>
                        <th>
                            Nombre
                        </th>
                        <th>
                            Acciones
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="person" items="${people}">
                        <tr>
                            <td>
                                <c:out value="${person.nombre}" escapeXml="true"/>
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/?action=openUpdate&id=${person.id}&name=${person.nombre}">Editar</a>
                                <a href="${pageContext.request.contextPath}/?action=delete&id=${person.id}">eliminar</a>
                            </td>
                        </tr>
                    </c:forEach> 
                </tbody>
            </table>

        </section>

    </body>

</html>