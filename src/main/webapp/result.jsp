<%@ page import="entities.Employee" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Results</title>
    </head>
    <body>
        <%
            List<Employee> employeeList = (List<Employee>) session.getAttribute("employeeList");
            if(employeeList != null && !employeeList.isEmpty()){
        %>
            <table>
        <%
                for(Employee e : employeeList){
        %>
                <tr>
                    <td><%=e.getId()%></td>
                    <td><%=e.getfName() + " " + e.getlName()%></td>
                    <td><%=e.getEmail()%></td>
                    <td><%=e.getStartDate()%></td>
                </tr>
        <%
                }
        %>
            </table>
        <%
            }else{
                %>
        <div>No employees currently found in the database</div>
        <%
            }
        %>
    </body>
</html>
