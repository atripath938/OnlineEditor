<%@ page import="com.resources.DictionaryHandler" %><%--
  Created by IntelliJ IDEA.
  User: atrip
  Date: 3/14/2019
  Time: 6:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Word Search Application</title>
    <link rel="stylesheet" href="StyleSheets/WelcomPageStyling.css">
</head>
<body>
<%DictionaryHandler.createWordList();%>
<div id="SearchBox">
    <p style="font-size: x-large; color: darksalmon;">Please enter the word to search</p>
    <input type="text" id="wordInputBox" onkeyup="checkWordExistence()">
</div>
</body>
</html>
