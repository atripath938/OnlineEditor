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

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="Scripts/welcomePageScript.js"></script>
    <title>Word Search Application</title>
    <link rel="stylesheet" href="StyleSheets/WelcomePageStyling.css">
</head>
<body>
<%DictionaryHandler.createWordList();%>
<div id="SearchBox">
    <p style="font-size: x-large; color: darksalmon;">Start typing in the box below</p>
    <div contenteditable id="wordInputBox"></div>
    <p id="ResultText"></p>
</div>
</body>
</html>
