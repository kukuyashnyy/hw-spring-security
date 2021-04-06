<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<c:set var="title" value="Register user"/>
<%@include file="../include/header.jsp" %>

<div class="container">

    <h1>${title}</h1>

    <div class="row">
        <%--@elvariable id="user" type="org.itstep.domain.User"--%>
        <form:form modelAttribute="user" class="col s12" method="post">
            <form:hidden path="id"/>
            <form:hidden path="role" />

            <div class="row">
                <div class="input-field col s6">
                    <form:input path="username" required="required"/>
                    <form:label path="username">UserName</form:label>
<%--                    <form:errors path="username" class="helper-text" data-error="wrong" data-success="right"/>--%>
                </div>
                <div class="input-field col s6">
                    <form:password path="password" required="required"/>
                    <form:label path="password">Password</form:label>
<%--                    <form:errors path="lastName" class="helper-text" data-error="wrong" data-success="right"/>--%>
                </div>
            </div>
<%--            <div class="row">--%>
<%--                <div class="input-field col s6">--%>
<%--                    <form:select path="groupId" cssClass="validate">--%>
<%--                        <form:option value="" disabled="true" selected="true">Choose your option</form:option>--%>
<%--                        <form:options items="${groups}" itemLabel="name" itemValue="id"/>--%>
<%--                    </form:select>--%>
<%--                    <form:label path="groupId">Group</form:label>--%>
<%--                    <form:errors path="groupId" class="error-text helper-text" data-error="wrong" data-success="right"/>--%>
<%--                </div>--%>
<%--                <div class="input-field col s6">--%>
<%--                    <form:input path="birthDate" required="required" type="text" class="validate datepicker"/>--%>
<%--                    <form:label path="birthDate">Birth date</form:label>--%>
<%--                    <form:errors path="birthDate" class="error-text helper-text" data-error="wrong"--%>
<%--                                 data-success="right"/>--%>
<%--                </div>--%>
<%--            </div>--%>
            <div class="row">
                <div class="input-field col s6">
                    <button type="submit" class="btn">Save<i class="material-icons right">send</i></button>
                </div>
            </div>
        </form:form>
    </div>

    <jsp:include page="../include/scripts.jsp"/>
</div>

<%@include file="../include/footer.jsp" %>
