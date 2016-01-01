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
</head>
<body>
    <div class="container">
        <div class="page-header">
            <h1>電話帳 <small>ver 1.0.0</small></h1>
        </div>
		<s:form cssClass="form-horizontal">
		    <div class="form-group">
		        <label class="col-sm-2 control-label"><s:label key="label.id.value" /></label>
		        <div class="col-sm-10">
		            <s:textfield name="id" cssClass="form-control"/>
		        </div>
		    </div>
		    <div class="form-group">
		        <label class="col-sm-2 control-label"><s:label key="label.name.value" /></label>
		        <div class="col-sm-10">
		            <s:textfield name="name" cssClass="form-control"/>
		        </div>
		    </div>
            <div class="form-group">
                <label class="col-sm-2 control-label"><s:label key="label.telno.value" /></label>
                <div class="col-sm-10">
                    <s:textfield name="telNo" cssClass="form-control"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label"><s:label key="label.mail.value" /></label>
                <div class="col-sm-10">
                    <s:textfield name="mailAddress" cssClass="form-control"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label"><s:label key="label.memo.value" /></label>
                <div class="col-sm-10">
                    <s:textfield name="memo" cssClass="form-control"/>
                </div>
            </div>
		    <div class="form-group">
		        <div class="col-sm-offset-2 col-sm-10">
		            <s:submit method="insert" value="%{getText('label.button.insert')}" cssClass="btn btn-primary"/>
		            <a href="list.action" class="btn btn-info"><s:text name="%{getText('label.button.list')}" /></a>
		        </div>
		    </div>
		</s:form>
		<p class="err"><s:actionerror /></p>
    </div>
</body>