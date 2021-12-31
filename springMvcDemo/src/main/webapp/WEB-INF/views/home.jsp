<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<table>
	<tr>
		<td>
			<c:forEach var="study" items="${studyMap}" varStatus="loop">
				<a href="${study.key}">${study.value}</a>
				<c:if test="${!loop.last}">,</c:if>
			</c:forEach>
		</td>
	</tr>
</table>
</body>
</html>
