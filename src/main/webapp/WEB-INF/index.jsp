<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="ru.academits.model.Contact" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.academits.service.ContactService" %>
<%@ page import="ru.academits.servlet.GetAllContactsServlet" %>
<!DOCTYPE html>
<html lang="">

<head>
    <meta charset="utf8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" type="text/css" href="../css/phonebook.css"/>
    <title>Phone book</title>
</head>

<body>

<div class="delete-dialog"></div>

<div class="alert" title="Нет выбранных контактов"></div>
<div class="content">

    <table class="table">
        <thead>
        <tr>
            <th>№</th>
            <th>Фамилия</th>
            <th>Имя</th>
            <th>Телефон</th>
            <th>Удалить</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${contacts}" var="contact" varStatus="loop">
            <tr>
                <td>
                    <c:out value="${loop.index + 1}"/>
                </td>
                <td>
                    <c:out value="${contact.lastName}"/>
                </td>
                <td>
                    <c:out value="${contact.firstName}"/>
                </td>
                <td>
                    <c:out value="${contact.phone}"/>
                </td>
                <td>
                    <form action="remove" method="POST">
                        <button name="index" value=${contact.id}>Удалить
                        </button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <br>

    <form action="add" method="POST">
        <div>
            <label class="form-label">
                <span class="form-field">Фамилия:</span>
                <input type="text" name="lastname" class="form-control input-sm form-input"/>
                <span class="error-message">
                <%= request.getAttribute("errorLastName") %>
            </span>
            </label>
        </div>
        <div>
            <label class="form-label">
                <span class="form-field">Имя:</span>
                <input type="text" name="firstname" class="form-control input-sm form-input"/>
                <span class="error-message">
                    <%= request.getAttribute("errorFirstName") %>
            </span>
            </label>
        </div>
        <div>
            <label class="form-label">
                <span class="form-field">Телефон:</span>
                <input type="number" name="phone" class="form-control input-sm form-input">
                <span class="error-message">
                <%= request.getAttribute("errorPhone") %>
                </span>
            </label>
        </div>
        <button>Добавить</button>
    </form>

</div>
</body>
</html>