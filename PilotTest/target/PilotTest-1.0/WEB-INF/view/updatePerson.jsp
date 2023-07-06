<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Crear Persona</title>
        <style>
            <%@include file="/WEB-INF/styles/style.css"%>
        </style>
    </head>
    <body>
        <h1>Por favor diligencie los campos:</h1>
        <form action="${pageContext.request.contextPath}/?action=update&id=${id}" method="post">
            <label>Nombre:</label>
            <input type="text" name="name" value="${name}" required>
            <input type="submit" value="Editar">
        </form>
    </body>
</html>
