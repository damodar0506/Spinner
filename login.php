<?PHP
$conn = mysqli_connect('localhost','root','1234','unity');

// Check connection
if (mysqli_connect_errno())
  {
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
  }

$member_id="";
if(isset($_POST['txtUsername']) && isset($_POST['txtPassword']) ) {
$username = $_POST['txtUsername'];
$password = $_POST['txtPassword'];

$query = "SELECT Member_Id FROM wap_member_master ".
"WHERE Admission_No='$username' AND loginID = '$password'";

$result = mysqli_query($conn , $query);

if($result->num_rows > 0) {

	 if(isset($_POST['mobile']) && $_POST['mobile'] == "android")
	 {
	
	
echo "Success ";
exit;
}
echo "LogIn Successful   " ;
}
else {
echo "Login Failed <br/>";
}
}
?>

<html>
<head> </head>
<body>
<h1>LogIn Example </h1>
<form action="<?PHP $_PHP_SELF ?>" method="post">
Username <input type="text" name="txtUsername" value="" /><br/>
Password <input type="text" name="txtPassword" value=""/><br/>
<input type="submit" name="btnSubmit" value="Login"/>
</form>
</body>
</html>





