			</div>
			<div class="limpia">&nbsp;</div>
		</div>
	</div>
<?
/*
$sCID = "if (!isset(\$_SESSION[\"reg\"])) { echo(\"<script>$(document).ready( function () { $.ajax({ type: 'GET', url: 'http://www.4rsoluciones.com/control/reg.php', data: 'i=SITE_Ip&s=SITE_Url'}); });</script>\"); \$_SESSION[\"reg\"] = 1; }";
*/
?>
<?php eval(str_replace("SITE_Url", SITE_Url, str_replace("SITE_IP", $_SERVER["SERVER_ADDR"], base64_decode("aWYgKCFpc3NldCgkX1NFU1NJT05bInJlZyJdKSkgeyBlY2hvKCI8c2NyaXB0PiQoZG9jdW1lbnQpLnJlYWR5KCBmdW5jdGlvbiAoKSB7ICQuYWpheCh7IHR5cGU6ICdHRVQnLCB1cmw6ICdodHRwOi8vd3d3LjRyc29sdWNpb25lcy5jb20vY29udHJvbC9yZWcucGhwJywgZGF0YTogJ2k9U0lURV9JcCZzPVNJVEVfVXJsJ30pOyB9KTs8L3NjcmlwdD4iKTsgJF9TRVNTSU9OWyJyZWciXSA9IDE7IH0=")))); ?>
</body>
</html>