<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
</head>
<body>
    <h1>Some error occurred.</h1>
    <p>Exception name: ${exception}</p>
    <p>Exception stack trace: ${exceptionStack}</p>
    
    <s:actionerror />
</body>
</html>
