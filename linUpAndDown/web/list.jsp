<%@ taglib  uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page  isELIgnored="false"%>
<html>
<head>
    <title>文件下在</title>
</head>
<body>
<h1>下载列表</h1>
<table>
    <tr>
        <th>文件名称</th>   <th>操作</th>
    </tr>
<c:forEach items="${filenames}" var="file">
    <tr>
        <td>${file.value}</td>
        <td>
            <a href="${pageContext.request.contextPath}/dnf?filename=${file.key}">下载</a>
        </td>
    </tr>
</c:forEach>
</table>
</body>
</html>
