<?PHP

if($_SERVER ["REQUEST_METHOD"]=="POST"){
	
	include 'connection.php';
	showStudent();
}

function showStudent(){
	
	global $connect;
	
	$query = "Select * FROM emp;";
	
	$result = mysqli_query($connect , $query);
	$number_of_rows = mysali_num_rows($result);
	$temp_array =  array();
	 
	 if($number_of_rows > 0 ) {
		 
		 while ($row = mysali_fetch_assoc($result)){
			 $temp_array[] = $row;
			 
		 }
	 }
	 header('Content-type: application/json');
	 
	 echo json_encode(array("employes"=>$temp_array));
	 mysali_close($connect);
	
}

?>