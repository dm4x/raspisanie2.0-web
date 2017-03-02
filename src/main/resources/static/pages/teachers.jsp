<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>teachers Page</title>
    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>

<!--logout-->
<div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <br/>
        <a href="" onclick="document.forms['logoutForm'].submit()">Logout</a>
        <br/>
        <br/>

        <h3>Teachers List</h3>

        <c:if test="${!empty listTeachers}">
            <table class="tg">
                <tr>
                    <th width="80">ID</th>
                    <th width="120">Name</th>
                    <th width="120">Full Name</th>
                    <th width="120">Room</th>
                    <th width="60">Edit</th>
                    <th width="60">Delete</th>
                </tr>
                <c:forEach items="${listTeachers}" var="teacher">
                    <tr>
                        <td>${teacher.id}</td>
                        <td><a href="/teacherdata/${teacher.id}">${teacher.name}</a></td>
                        <td>${teacher.position}</td>
                        <td>${teacher.salary}</td>
                        <td><a href="<c:url value='/edit/${teacher.id}'/>">Edit</a></td>
                        <td><a href="<c:url value='/delete/${teacher.id}'/>">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>


        <h3>Add new teacher</h3>

        <c:url var="addAction" value="/teachers/add"/>

        <form:form action="${addAction}" commandName="teacher">
            <table>
                <c:if test="${!empty teacher.name}">
                    <tr>
                        <td>
                            <form:label path="id">
                                <spring:message text="ID"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="id" readonly="true" size="8" disabled="true"/>
                            <form:hidden path="id"/>
                        </td>
                    </tr>
                </c:if>
                <tr>
                    <td>
                        <form:label path="name">
                            <spring:message text="name"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="name"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="fullname">
                            <spring:message text="fullname"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="fullname"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <c:if test="${!empty teacher.name}">
                            <input type="submit"
                                   value="<spring:message text="Edit teacher"/>"/>
                        </c:if>
                        <c:if test="${empty teacher.name}">
                            <input type="submit"
                                   value="<spring:message text="Add teacher"/>"/>
                        </c:if>
                    </td>
                </tr>
            </table>
        </form:form>
    </c:if>
</div>

</body>
</html>