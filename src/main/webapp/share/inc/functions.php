<?php
	function setLang()
	{
		if (isset($_REQUEST['setlang']) && !empty($_REQUEST['setlang']))
		{
			setcookie('sitelang', $_REQUEST['setlang']);
			$sLang = $_REQUEST['setlang'];
		}
		elseif (isset($_COOKIE['sitelang']))
		{
			$sLang = $_COOKIE['sitelang'];
		}
		else
		{
			$sLang = 'es';
		}
		define ('SITE_Lenguaje', $sLang);
		load_web_textdomain($sLang);
	} 
?>
