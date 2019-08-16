<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Learn Struts 2 with Real Apps</title>
</head>
<body>

<h3>Products Page</h3>
<table cellpadding="2" cellspacing="2" border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Photo</th>
        <th>Price</th>
        <th>Buy</th>
    </tr>
    <c:forEach var="product" items="${products }">
        <tr>
            <td>${product.id }</td>
            <td>${product.name }</td>
            <td>
                <img src="${pageContext.request.contextPath }/assets/images/${product.photo }" width="50">
            </td>
            <td>${product.price }</td>
            <td align="center">
                <s:url var="url_buy" namespace="/cart" action="buy">
                    <s:param name="id">${product.id}</s:param>
                </s:url>
                <s:a href="%{url_buy}">Buy Now</s:a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>