<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>World Adventures Airlines</title>
    <link rel="stylesheet" href="resources/css/normalize.css"/>
    <link rel="stylesheet" href="resources/css/theme.css"/>

</head>
<body>

<div class="container">

    <div class="title">Add a passenger</div>

    <%
        if (request.getAttribute("errors") != null) {
    %>
    <fieldset id="error_fieldset">
        <legend align="center">Errors</legend>
        <ul>

            <%
                if (request.getAttribute("firstname_error") != null) {
            %>
            <li class="error">First name error</li>
            <%
                }
            %>

            <%
                if (request.getAttribute("lastname_error") != null) {
            %>
            <li class="error">Last name error</li>
            <%
                }
            %>


            <%
                if (request.getAttribute("date_format_error") != null) {
            %>
            <li class="error">Date of birth invalid</li>
            <%
                }
            %>

        </ul>

    </fieldset>
    <%
        }
    %>

    <fieldset>

        <legend>Passenger details</legend>

        <form action="AddPassenger" method="post">

            <div class="inputField">
                <label for="first-name" class="inputLabel">First name: </label> <input
                    name="first-name" type="text"></input>
            </div>

            <div class="inputField">
                <label for="last-name" class="inputLabel">Last name: </label> <input
                    name="last-name" type="text"></input>
            </div>

            <div class="inputField">
                <label for="dob" class="inputLabel">Date of birth: </label> <input
                    name="dob" type="text"></input>
            </div>

            <div class="inputField">
                <label for="first-name" class="inputLabel">Gender: </label> <select
                    name="gender">
                <option value="Male">Male</option>
                <option valuie="Female">Female</option>
            </select>
            </div>

            <div class="inputField" id="submitField">
                <input id="submitBtn" type="submit" value="Add new passenger"></input>
            </div>

        </form>

    </fieldset>


</div>

</body>
</html>