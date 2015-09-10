<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>Calculator</title>
   
    <script src="js/jquery-1.11.1.js" type="text/javascript"></script>
<script type="text/javascript" src="ajax.js"></script>
  </head>
  <body>
   
    <p>Welcome to Calculator Server</p>
   
  
 <!-- <form action="CalculatorServlet" method="get">
        Number 1:<input type="text" id="a" name="a"></input>
</br>
    Number 2:<input type="text" id="b" name="b"></input>
</br>
</br>
   
    <button id="button1" name="action"  value="add">Addition</button>
    <button id="button2" name="action"  value="sub">Substraction</button>
    <button id="button3" name="action"  value="mul">Multiplication</button>
    <button id="button4" name="action"  value="div">Division</button>

</form>

<form> -->
 Number 1:<input type="text" id="a" name="a"></input>
</br>
    Number 2:<input type="text" id="b" name="b"></input>
</br>
</br>
   <div id="dv">
    <button id="add" name="action"  value="add">Addition</button>
    <button id="sub" name="action"  value="sub">Substraction</button>
    <button id="mul" name="action"  value="mul">Multiplication</button>
    <button id="div" name="action"  value="div">Division</button>
    </div>
    <br />
<fieldset>
	<br />
	Result: <div id="result"></div>
</fieldset>

<!-- </form> -->
   

    
  </body>
</html>