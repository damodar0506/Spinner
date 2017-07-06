<?php 
 
 if($_SERVER['REQUEST_METHOD']=='GET'){
 
 $id  = $_GET['Admission_No'];
 
 require_once('dbConnect.php');
 
 $sql = "SELECT * FROM wap_member_master WHERE Admission_No ='".$id."'";
 
 $r = mysqli_query($con,$sql);
 
 $res = mysqli_fetch_array($r);
 
 $result = array();
 
 array_push($result,array(
 "Name"=>$res['Member_Name'],
 "Id"=>$res['Member_Id'],
 "gender"=>$res['Gender']
 )
 );
 
 echo json_encode(array("result"=>$result));
 
 mysqli_close($con);
 
 }
 ?>