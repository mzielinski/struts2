<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>Customer Manager</title>
</head>
<body>

<h1>Customer Manager</h1>
<s:actionerror/>

<s:form action="customer-add" method="post">
    <s:textfield name="customer.firstName" label="Firstname"/>
    <s:textfield name="customer.lastName" label="Lastname"/>
    <s:textfield name="customer.emailId" label="Email"/>
    <s:textfield name="customer.cellNo" label="Cell No."/>
    <s:textfield name="customer.website" label="Homepage"/>
    <s:textfield name="customer.birthDate" label="Birthdate"/>
    <s:submit value="Add Customer" align="center"/>
</s:form>


<h2>Customers</h2>
<table>
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Cell No.</th>
        <th>Birthdate</th>
        <th>Homepage</th>
        <th>Delete</th>
    </tr>
    <s:iterator value="customerList" var="customer">
        <tr>
            <td><s:property value="lastName"/>, <s:property value="firstName"/> </td>
            <td><s:property value="emailId"/></td>
            <td><s:property value="cellNo"/></td>
            <td><s:property value="birthDate"/></td>
            <td><a href="customer-show?id=<s:property value="id"/>">show</a></td>
            <td><a href="customer-delete?id=<s:property value="id"/>">delete</a></td>
        </tr>
    </s:iterator>
</table>
</body>
</html>