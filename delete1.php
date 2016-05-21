<?php

$con = mysqli_connect("localhost","root","sakshi2309","mck_voters_db");

if(! $con)
{
    die('Connection Failed'.mysql_error());
}


//mysql_select_db("test",$con);

$voterregnum=$_POST['voterregnum'];
//$itemno=$_POST['itemno'];
//$numofitems=$_POST['noitem'];

	//$sql="Delete from $item where '$item'_id='$itemno'" ;
	
	
		$sql="delete from voters where voter_reg_num='$voterregnum'";
		//$result = mysqli_query($sql,$con);
		//$row = mysqli_fetch_array($result);
		
			//$sql="Delete from books where book_id='$itemno'" ;
		if ($con->query($sql) === TRUE) {
    echo "Deletion Successful!!";
} else {
    echo "Connection error";
}
?>