<%@ include file="common/header.jsp"%>
<%@ include file="common/navigation.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container">
    <p>Add new User:</p>
    <%--@elvariable id="user" type="com.psp.psp13.model.User"--%>
    <form:form method="post" modelAttribute="user">
        <form:label path="userId">UserId</form:label>
        <form:input path="userId" type="text" required="required" />
        <form:errors path="userId" />
        <br/>
        <form:label path="name">Name</form:label>
        <form:input path="name" type="text" required="required" />
        <form:errors path="name" />
        <br/>
        <form:label path="surname">Surname</form:label>
        <form:input path="surname" type="text" required="required" />
        <form:errors path="surname" />
        <br/>
        <form:label path="phoneNumber">Phone Number</form:label>
        <form:input path="phoneNumber" type="text" required="required" />
        <form:errors path="phoneNumber" />
        <br/>
        <form:label path="email">Email</form:label>
        <form:input path="email" type="text" required="required" />
        <form:errors path="email" />
        <br/>
        <form:label path="address">Address</form:label>
        <form:input path="address" type="text" required="required" />
        <form:errors path="address" />
        <br/>
        <form:label path="password">Password</form:label>
        <form:input path="password" type="text" required="required" />
        <form:errors path="password" />
        <br/>
        <button type="submit">OK</button>
    </form:form>
</div>