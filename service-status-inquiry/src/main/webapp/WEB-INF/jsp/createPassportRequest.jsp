<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Insert</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script type="text/javascript" src="${contextPath}/resources/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="${contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="${contextPath}/resources/js/ajaxCall.js" type="text/javascript"></script>
    <link href="${contextPath}/resources/css/bootstrap.min.css"rel="stylesheet" type="text/css">
    <link href="${contextPath}/resources/fonts/font-awesome-4.3.0/css/font-awesome.min.css"rel="stylesheet" type="text/css">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet" type="text/css">
    <link href="${contextPath}/resources/css/main.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet">
</head>

<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <div class="row">
                <div class="col-md-12 col-md-offset-6 text-center">
                    <p>
                        This is a sample application developed using mSpace platform.<br>
                        You may change the code and User interface as per your requirements and connect to mSpace platform.
                    </p>
                </div>
            </div>
        </div>
    </div>
</nav>

<div class="wrapper">
    <div class="container-fluid">
        <div class="content-block without-left-menu">
            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <h3 class="main-topic">Enter Details</h3>
                    <div class="page-card">
                        <form:form method="POST" id="passportForm" modelAttribute="passportForm" class="form-signin">
                            <div class="row margin-top-20">
                                <div class="col-md-12">
                                    <table class="table table-without-border">
                                        <tbody>
                                            <tr>
                                                <td>Full Name</td>
                                                <td>
                                                    <spring:bind path="fullName">
                                                        <div class="form-group ${status.error ? 'has-error' : ''}">
                                                            <form:input type="text" path="fullName" class="form-control" placeholder="Full Name" autofocus="true"></form:input>
                                                        </div>
                                                    </spring:bind>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Reference Number *</td>
                                                <td>
                                                    <spring:bind path="refNo">
                                                        <div class="form-group ${status.error ? 'has-error' : ''}">
                                                            <form:input type="text" path="refNo" class="form-control" placeholder="Reference Number" autofocus="true" required="required" ></form:input>
                                                        </div>
                                                    </spring:bind>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Address</td>
                                                <td>
                                                    <spring:bind path="address">
                                                        <div class="form-group ${status.error ? 'has-error' : ''}">
                                                            <form:input type="text" path="address" class="form-control" placeholder="Address" autofocus="true"></form:input>
                                                        </div>
                                                    </spring:bind>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>NIC</td>
                                                <td>
                                                    <spring:bind path="nic">
                                                        <div class="form-group ${status.error ? 'has-error' : ''}">
                                                            <form:input type="text" path="nic" class="form-control" placeholder="NIC" autofocus="true"></form:input>
                                                        </div>
                                                    </spring:bind>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4 col-md-offset-8">
                                    <button class="btn btn-primary margin-top-20 full-width"
                                            type="submit">Save
                                    </button>
                                </div>
                                <a href="http://core.passport.service:9001/request">&laquo; Back</a>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>