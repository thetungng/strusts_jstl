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

<h3>Cart Page</h3>
<table cellpadding="2" cellspacing="2" border="1">
    <tr>
        <th>Option</th>
        <th>Id</th>
        <th>Name</th>
        <th>Photo</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Sub Total</th>
    </tr>
    <c:set var="total" value="0"></c:set>
    <c:forEach var="item" items="${sessionScope.cart }">
        <c:set var="total" value="${total + item.product.price * item.quantity }"></c:set>
        <tr>
            <td align="center">
                <s:url var="url_remove" namespace="/cart" action="remove">
                    <s:param name="id">${item.product.id }</s:param>
                </s:url>
                <s:a href="%{url_remove}" onclick="return confirm('Are you sure?')">Remove</s:a>
            </td>
            <td>${item.product.id }</td>
            <td>${item.product.name }</td>
            <td><img src="${pageContext.request.contextPath }/assets/images/${item.product.photo }"
                     width="50"></td>
            <td>${item.product.price }</td>
            <td>${item.quantity }</td>
            <td>${item.product.price * item.quantity }</td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="6" align="right">Sum</td>
        <td>${total }</td>
    </tr>
</table>
<br>
<s:a namespace="/product" action="index">Continue Shopping</s:a>

</body>
</html>