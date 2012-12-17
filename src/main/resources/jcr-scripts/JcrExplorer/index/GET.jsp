<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page session="false"%>
<%@page contentType="text/html; charset=UTF-8"%>
<c:if test="${not fn:endsWith(pageContext.request.requestURI, '/jcrexplorer/')}">
	<html xmlns="http://www.w3.org/1999/xhtml" lang="hu">
	<head>
		<title>liveSense JCR Explorer Redirect</title>
		<meta http-equiv="refresh" content="0;<c:url value="/jcrexplorer/"/>">
	</head>
	</html>
</c:if>
<c:if test="${fn:endsWith(pageContext.request.requestURI, '/jcrexplorer/')}">
<html xmlns="http://www.w3.org/1999/xhtml" lang="hu">
<head>
<title>liveSense JCR Explorer</title>
<meta name="description" content="liveSense JCR Explorer">
<script type="text/javascript" language="javascript" src="/jcrexplorer/jcrexplorer/jcrexplorer.nocache.js"></script>
<style type="text/css">
	h1 {
	  font-size: 2em;
	  font-weight: bold;
	  color: #777777;
	  margin: 40px 0px 70px;
	  text-align: center;
	}
	
	.sendButton {
	  display: block;
	  font-size: 16pt;
	}
	
	/** Most GWT widgets already have a style name defined */
	.gwt-DialogBox {
	  width: 400px;
	}
	
	.dialogVPanel {
	  margin: 5px;
	}
	
	.serverResponseLabelError {
	  color: red;
	}
	
	/** Set ids using widget.getElement().setId("idOfElement") */
	#closeButton {
	  margin: 15px 6px 6px;
	}
</style>
</head>
<body>
	<jsp:directive.include file="../sling.jsp" />
	<jsp:directive.include file="../authentication.jsp" />
	<jsp:directive.include file="../currentNode.jsp" />
	<iframe src="javascript:''" id="__gwt_historyFrame" tabIndex='-1' style="position:absolute;width:0;height:0;border:0"></iframe>
</body>
</html>
</c:if>