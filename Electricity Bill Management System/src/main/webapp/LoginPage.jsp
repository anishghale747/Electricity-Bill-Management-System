<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Login Page</title>
        <style>
            @import url(https://fonts.googleapis.com/css?family=Roboto:300);

            .login-page {
                width: 500px;
                padding: 8% 0 0;
                margin: auto;
            }

            .form {
                position: relative;
                z-index: 1;
                background: #FFFFFF;
                max-width: 360px;
                margin: 0 auto 410px;
                padding: 45px;
                text-align: center;
                border-radius: 20px;
                box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
            }

            .form select-form {    
                position: relative;   
            }

            .select-form{
                font-family: "Roboto", sans-serif;
                font-weight: lighter;
                text-align: center;
                border-radius: 20px;
                background-color:#f2f2f2; 
                font-size: 14px;
                width: 30%;
                height: 25px;
            }

            .select-items div:hover {
                background-color: lightgray;
            }

            .form input {
                font-family: "Roboto", sans-serif;
                outline: 0;
                background: #f2f2f2;
                width: 100%;
                border: 0;
                margin: 0 0 15px;
                padding: 15px;
                box-sizing: border-box;
                font-size: 14px;
                border-radius: 5px;
            }
            .form button {
                font-family: "Roboto", sans-serif;
                text-transform: uppercase;
                outline: 0;
                background: dodgerblue;
                width: 100%;
                border: 0;
                padding: 15px;
                color: #FFFFFF;
                font-size: 14px;
                -webkit-transition: all 0.3 ease;
                transition: all 0.3 ease;
                cursor: pointer;
                border-radius: 5px;
            }

            .form button:hover,.form button:active,.form button:focus {
                background: #045de9;
            }

            body {
              
                background-color: #045de9;
                    background-image: linear-gradient(315deg, #045de9 0%, #09c6f9 74%);
            }


        </style>
    </head>
    <body>    
        <div class="login-page">    
            <div class="form">
                <h1>Login Form</h1>
                <form class="login-form" style="display: block;" action="<%=request.getContextPath()%>/login" method="post">
                    <input type="text" placeholder="Username" name = "username" id="username" required>
                    <input type="password" placeholder="Password" name = "password" id="password" required>
                    <br>
                    <select class="select-form" name="role" id="role" required> 
                    	<option  disabled hidden selected>Select Role</option>
                        <option>Admin</option>
                        <option>User</option>
                    </select>
                    <br>
                    <br>
                    <br>
                    <button value="Submit">LOG IN</button>
                </form>
            </div>
        </div>    
    </body> 
</html>

