<?php

	session_start();
	if(!isset($_SESSION['name']))
	{
		header("location:admin.html");
	}
	$name=$_SESSION['name'];
	
?>
<html>
<body background="5.jpg" >
<br>
<br>
<head>
<center><b style="font-size:50; color:red; background-color:white">Voter Registration System</b></center>
</head>
<br>
<br>
<br>
<form method="post" action="delete1.php"/>
<table>
<tr>
<td width="10%"/>
<td width="1010px" style="background-color:lightblue">
&nbsp&nbsp&nbsp&nbsp<b>Welcome 

<?php
//echo $_GET['name'];
//$name=$_GET['name'];
echo $name;	
?>
,
</b>


&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp|&nbsp&nbsp
&nbsp&nbsp|&nbsp&nbsp
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<a href="alogout.php">Log out</a>
</td>
</tr>
</table>

<table>

<td>
<td width="10%"/>
<td width="1010px" style="background-color:lightblue">
<table width="755px" style="background-color:lightyellow" align="center">


<td style="background-color:lightyellow" align="center" width="550px" height="200px">
	<table align="center">
		
			<tr><h1 colspan="2" align="center" style="background-color:fdd24f" >
				Deleting Section</h1>
			</tr>
		
		<tr>
	<tr>
	<tr>
				<tr>
				<td width="200px">&nbsp&nbsp&nbsp Voter Registration Number</td>
				<td><input type="text" name="voterregnum" required/></td>
			</tr>
			
			
			<tr>
			<td colspan="2" align="center">
			<input type="submit" value="Delete"> 
			<br>
			</td>
			</tr>
						
			
		</tr>
		
</td>
</table>
<td>
	<img src="deleteitem.png" width="200px"/>
</td>
	
</table>
</td>
	
	


</table>

</body>
</html>