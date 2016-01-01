<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>電話帳</title>
<link rel="stylesheet" type="text/css" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"/>
<style>
div.container{
    max-width:800px;
}
ul.errorMessage{
    color:red;
}
div.result dd{
    margin-bottom:32px;
}
</style>
<script type="text/javascript">
function updateSubmit(id) {
    document.forms["updateForm"].id.value = id;	
	document.forms["updateForm"].submit();
}
function deleteSubmit(id) {
    document.forms["deleteForm"].id.value = id;    
	document.forms["deleteForm"].submit();
}
</script>
</head>
<body>
    <div class="container">
        <div class="page-header">
            <h1>電話帳 <small>ver 1.0.0</small></h1><a href="insert.action" class="btn btn-primary"><s:text name="%{getText('label.button.insert')}" /></a>
        </div>
        <table class="table table-bordered">
        <tr class="active">
            <td><s:label key="label.id.value" /></td>
            <td><s:label key="label.name.value" /></td>
            <td><s:label key="label.telno.value" /></td>
            <td><s:label key="label.mail.value" /></td>
            <td><s:label key="label.memo.value" /></td>
            <td></td>
        </tr>
        <s:iterator value="list">
        <tr>
            <td><s:property value="id"/></td>
            <td><s:property value="name"/></td>
            <td><s:property value="telNo"/></td>
            <td><s:property value="mailAddress"/></td>
            <td><s:property value="memo"/></td>
            <td align="center">
                <s:submit type="button" value="%{getText('label.button.update')}" cssClass="btn btn-warning" onclick="updateSubmit('%{id}');return false;"/>
                <s:submit type="button" value="%{getText('label.button.delete')}" cssClass="btn btn-danger" onclick="deleteSubmit('%{id}');return false;"/>
            </td>
        </tr>
        </s:iterator>
        </table>
        <form method="post" name="updateForm" action="update.action">
            <s:hidden name="id"></s:hidden>
 		</form>
        <form method="post" name="deleteForm" action="delete.action">
            <s:hidden name="id"></s:hidden>
        </form>
		<p class="err"><s:actionerror /></p>
    </div>
</body>