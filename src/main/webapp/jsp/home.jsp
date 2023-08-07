<%@ page import="com.example.servletexample.model.User" %>
<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: Ritan
  Date: 10/15/2022
  Time: 11:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
</head>

<body>
<div class="w-screen h-screen flex justify-center items-center
            bg-gradient-to-br from-blue-700 to-pink-700">

    <div class="p-10 bg-white rounded-xl drop-shadow-lg space-y-5">
<div>
    <h1 class="text-center text-3xl">Hello ${name}, you have ${userPoints} total points. </h1>

    <form action="/homeServlet" method="post">
        <div class="flex flex-col space-y-2">
            <label class="text-sm font-light" for="priceInput">Please enter the price of your purchases</label>
        <input class="w-96 px-3 py-2 rounded-md border border-slate-400" name="priceInput" type="number" id="priceInput" >
        </div>

        <button class="w-full px-10 py-2 bg-blue-600 text-white rounded-md
        hover:bg-blue-500 hover:drop-shadow-md duration-300 ease-in" type="submit">Submit</button>
    </form>

    <h1 class="text-center text-2xl">You are a:  ${userType}</h1>
    <h1 class="text-center text-2xl">Discount applied: ${discount} lei.</h1>
    <h1 class="text-center text-2xl">Initial price:  ${initialPrice}</h1>
    <h1 class="text-center text-2xl">Final price:  ${finalPrice} lei.</h1>


    <%
        String[] prizes = {"Dunhill Albastru", "Tigaie DryCooker", "Absolut Vodka 0.7l", "Apa Plata Bucovina", "Pilota Dormeo"};
    %>

    <c:if test="${userType.equals('client')}"><h2 class="text-center text-3xl"><%=prizes[new Random().nextInt(prizes.length)]%></h2></c:if>

    <%--<%
        String[] prizes = {};
        if (session.getAttribute("userType").equals("client") && (session.getAttribute("userPoints").equals("100") || session.getAttribute("userPoints").equals("200") || session.getAttribute("userPoints").equals("300") || session.getAttribute("userPoints").equals("400")))
        {
            prizes = new String[] {"Dunhill Albastru", "Tigaie DryCooker", "Absolut Vodka 0.7l", "Apa Plata Bucovina", "Pilota Dormeo"};
        }

    %>--%>

    <%--<c:choose>
        <c:when test="${userType.equals('client')}">
            <h2 class="text-center text-3xl" placeholder = "Prize"><%=prizes[new Random().nextInt(prizes.length)]%> </h2>
        </c:when>
        <c:otherwise>
            <h2 class="text-center text-3xl" placeholder = "Prize"> :) </h2>
        </c:otherwise>
    </c:choose>--%>



</div>
    </div>
</div>
</body>
</html>
