<?php
	$sErrorMsg = "";
	$sMenssage = "";

	$sFileToUpload = $_GET['fileImputUpload'];
	if(!empty($_FILES[$sFileToUpload]['error']))
	{
		switch($_FILES[$sFileToUpload]['error'])
		{
			case '1':
				//$sErrorMsg = 'The uploaded file exceeds the upload_max_filesize directive in php.ini';
				$sErrorMsg = 'El tamaño del archivo que desea subir excede la directiva upload_max_filesize definida en php.ini';
				break;
			case '2':
				//$sErrorMsg = 'The uploaded file exceeds the MAX_FILE_SIZE directive that was specified in the HTML form';
				$sErrorMsg = 'El tamaño del archivo que desea subir excede la directiva MAX_FILE_SIZE que fue especificada en el FORM del HTML';
				break;
			case '3':
				$sErrorMsg = 'The uploaded file was only partially uploaded';
				break;
			case '4':
				$sErrorMsg = 'No file was uploaded.';
				break;
			case '6':
				$sErrorMsg = 'Missing a temporary folder';
				break;
			case '7':
				//$sErrorMsg = 'Failed to write file to disk';
				$sErrorMsg = 'Error al escribir el archivo en el disco';
				break;
			case '8':
				$sErrorMsg = 'File upload stopped by extension';
				break;
			case '999':
			default:
				//$sErrorMsg = 'No error code avaiable';
				$sErrorMsg = 'Error desconocido';
		}
	}
	elseif(empty($_FILES[$sFileToUpload]['tmp_name']) || $_FILES[$sFileToUpload]['tmp_name'] == 'none')
	{
		//$sErrorMsg = 'No file was uploaded..';
		$sErrorMsg .= 'No ingresó ningún archivo...';
	}
	else 
	{
		if (@move_uploaded_file($_FILES[$sFileToUpload]['tmp_name'], '../ajax/upload/' . $_FILES[$sFileToUpload]['name']))
		{ 	
			$iFileSize = @filesize('../ajax/upload/' . $_FILES[$sFileToUpload]['name']);
			$sMenssage .= " Nombre del archivo: " . $_FILES[$sFileToUpload]['name'] . ", <br />";
			$sMenssage .= " Tamaño del archivo: " . number_format($iFileSize/1024, 2) . " KB ($iFileSize bytes)";
			//Forsamos a la eliminación del archivo subido por razones de seguridad
			@unlink($_FILES[$sFileToUpload]);
		}
		else
		{
			$sErrorMsg .= 'No se pudo subir el archivo';
		}
	}
	echo "{error: '$sErrorMsg', msg:'$sMenssage', file: '{$_FILES[$sFileToUpload]['name']}'}";
?>