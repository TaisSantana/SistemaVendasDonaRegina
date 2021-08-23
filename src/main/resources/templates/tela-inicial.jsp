<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head th:replace="header :: headerBlock">
</head>
<body>

	<div th:replace="header :: navBar" ></div>

	<h4>Bem vindo, ${usuarioLogado.apelido}! </h4>
</body>
</html>