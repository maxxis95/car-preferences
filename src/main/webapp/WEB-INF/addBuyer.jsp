	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
    </head>
    <body>
        <h3>Enter The Buyer Details</h3>
        <form:form method="POST" 
          action="/addBuyer" modelAttribute="buyer">
             <table>
                <tr>
                    <td><form:label path="name">Name: </form:label></td>
                    <td><form:input path="name"/></td>
                    
                </tr>
                <tr>
                    <td><form:label path="lastName">Last Name: </form:label></td>
                    <td><form:input path="lastName"/></td>
                </tr>
                <tr>
                    <td><form:label path="email">
                      Email: </form:label></td>
                    <td><form:input path="email"/></td>
                </tr>
                <tr>
                    <td><form:label path="address">
                      Address: </form:label></td>
                    <td><form:input path="address"/></td>
                </tr>
                <tr>
                    <td><form:label path="city">
                      City: </form:label></td>
                    <td><form:input path="city"/></td>
                </tr>                
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>