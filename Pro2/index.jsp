<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <meta content="text/html; charset=windows-1250">
  <title>Questionary</title>
</head>

<body text="#484800" bgcolor="#e8e8e8"> <!--<p> крашу фон</p>-->
<form action="/answer" method="POST"><!--<p> передача данных и веб-форм методом "POST"</p>-->
  <p align="center">What is your name?<br><input type="text" name="name"><br>
    <br>
    What is your surname?<br><input type="text" name="surname"><br>
    <br>
    How old are you?<br><input type="text" name="age"><br> </p> <!--<p> все вопросы по центру и в поле текст</p>-->
  <p align="center"> <span style="font-size: 144%; color: rgba(26,169,245,0.71); ">How long you are programming?</span><br>
    <input type="radio" name="period" value="<1">less 1 year<br>
    <input type="radio" name="period" value=">2">more 2 years<br>
    <input type="radio" name="period" value=">3">more 3 years<br>
    <br>
  </p>
  <p align="center"> <span style="font-size: 144%; color: rgb(0,255,47); ">What language do you prefer?</span><br>
    <input type="radio" name="lang" value="Java">Java<br>
    <input type="radio" name="lang" value="Python">Python<br>
    <input type="radio" name="lang" value="C++">C++<br>
    <br>
  </p>
  <p align="center"><input type="text" name="comments">Comments(optional)<br>
    <br>
    <input type="submit" value="send"><br></p>
</form>
</body>
</html>