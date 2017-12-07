<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>"Strona glowna"</title>
</head>
<body>
    <form action = "login" method = "GET" >
        Login: <input type = "text" name = "email">
        <br />
        Password: <input type = "text" name = "password"/>
        <input type = "submit" value = "Submit"/>
    </form>
</body>
</html>