<?php
	// Koneksi Procedural PHP5 ke MySQL dengan mysql_connect
	$host = "localhost";
	$user = "root";
	$pass = "";
	$db = "poppyagustian_db";

	//PHP5 PROCEDURAL
	/*
	$konek = mysql_connect($host, $user, $pass);
	if (!$konek) {
		die("Koneksi Gagal: " . mysql_connect_error());
	}
	mysql_select_db($db);
	*/
	
	//PHP7 OOP
	$cn = new mysqli($host, $user, $pass, $db);
	if($cn->connect_error){
	   die("Koneksi Gagal: " . $cn->connect_error);
	}
  
	// Koneksi ke MySQL dengan PDO OOP PHP5 dan PHP7
	$pdo = new PDO('mysql:host='.$host.';dbname='.$db, $user, $pass);
	$pdo->setAttribute(PDO::MYSQL_ATTR_USE_BUFFERED_QUERY, true);
	
 ?>
