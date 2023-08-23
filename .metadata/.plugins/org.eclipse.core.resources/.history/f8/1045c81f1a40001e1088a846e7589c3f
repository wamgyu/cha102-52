<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Member List</title>
</head>
<body>
    <h1>Member List</h1>
    <table border="1">
        <tr>
            <th>Member No</th>
            <th>Name</th>
            <th>Personal ID</th>
            <th>Gender</th>
            <th>Picture</th>
            <th>Email</th>
            <th>Password</th>
            <th>Phone</th>
            <th>Address</th>
            <th>Birth</th>
            <th>Auth</th>
            <th>Vio</th>
        </tr>
        <%
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/polybrain_bid", "root", "0987242920");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM member");

                while (resultSet.next()) {
                    String memberNo = resultSet.getString("MEM_NO");
                    String memberName = resultSet.getString("MEM_NAME");
                    String memberPID = resultSet.getString("MEM_PID");
                    String memberGender = resultSet.getString("MEM_GENDER");
                    String memberPic = resultSet.getString("MEM_PIC");
                    String memberEmail = resultSet.getString("MEM_EMAIL");
                    String memberPwd = resultSet.getString("MEM_PWD");
                    String memberPhone = resultSet.getString("MEM_PH");
                    String memberAddress = resultSet.getString("MEM_ADDRS");
                    String memberBirth = resultSet.getString("MEM_BIRTH");
                    String memberAuth = resultSet.getString("MEM_AUTH");
                    String memberVio = resultSet.getString("MEM_VIO");

        %>
        <tr>
            <td><%= memberNo %></td>
            <td><%= memberName %></td>
            <td><%= memberPID %></td>
            <td><%= memberGender %></td>
            <td><%= memberPic %></td>
            <td><%= memberEmail %></td>
            <td><%= memberPwd %></td>
            <td><%= memberPhone %></td>
            <td><%= memberAddress %></td>
            <td><%= memberBirth %></td>
            <td><%= memberAuth %></td>
            <td><%= memberVio %></td>
        </tr>
        <%
                }
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                out.println("An error occurred while accessing the database.");
            }
        %>
    </table>
</body>
</html>
