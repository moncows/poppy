<?php
require "koneksi.php";
header("Content-type:application/json");

$modul = (isset($_GET['modul'])) ? $_GET['modul'] : null;
$nik = (isset($_POST['nik'])) ? $_POST['nik'] : null;
$nama_karyawan = (isset($_POST['nama_karyawan'])) ? $_POST['nama_karyawan'] : null;
$jenis_kelamin = (isset($_POST['jenis_kelamin'])) ? $_POST['jenis_kelamin'] : null;
$shift_kerja = (isset($_POST['shift_kerja'])) ? $_POST['shift_kerja'] : null;
$status_perkawinan = (isset($_POST['status_perkawinan'])) ? $_POST['status_perkawinan'] : null;

$respon = array();
$respon["data"] = array();
if (($modul == "view")) {
	$kue = "
		SELECT *
		FROM tb_karyawan
		ORDER BY id
		DESC
		LIMIT 1 ";
	$sql = $pdo->prepare($kue);
	$sql->execute();
	$cek_login = $sql->rowCount();
	if ($cek_login > 0) {
		while ($data = $sql->fetch(PDO::FETCH_ASSOC)) {
			array_push($respon["data"], $data);
		}
		$respon["pesan"] = "sukses";
		echo json_encode($respon, JSON_PRETTY_PRINT);
	} else {
		$respon["pesan"] = "tidak ada akun";
		echo json_encode($respon, JSON_PRETTY_PRINT);
	}
} else if (($modul == "insert")) {
	if ((!empty($nik)) and (!empty($nama_karyawan))) {
		$kue = "
			INSERT INTO tb_karyawan
			(nik,nama_karyawan,jenis_kelamin,shift_kerja,status_perkawinan)
			VALUES('" . $nik . "','" . $nama_karyawan . "','" . $jenis_kelamin . "','" . $shift_kerja . "','" . $status_perkawinan .  "')
			";
		$sql = $pdo->query($kue);
		if ($sql) {
			$respon["pesan"] = "sukses";
		} else {
			$respon["pesan"] = "gagal";
		}
	} else {
		$respon["pesan"] = "no_akses";
	}
	echo json_encode($respon, JSON_PRETTY_PRINT);
}
