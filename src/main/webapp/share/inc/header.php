<?PHP
/* DEFINICIONES META */
define ("CLIENTE","4r soluciones");
define ("AUTOR","4r soluciones");
define ("ANIO", date("Y"));
define ("CHARSET","UTF-8");

$aVars = $this->getGlobalVars();
foreach ($aVars as $sVar => $mVar)
{
	eval("$\$sVar = \$this->get(\"$sVar\");");
}
unset($aVars);
global $SITE_LANG;
global $SITE_oSession;
global $SITE_aModulos;
global $aComponentes;

$aConfiguracion = getObjeto('configuracion')->rows(NULL, "conf_idioma='" . SITE_LENGUAJE . "'");
define ('SITE_Name', (!empty($aConfiguracion[1]['conf_dato']) ? $aConfiguracion[1]['conf_dato'] : 'Mi sitio '));
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="<?=SITE_LENGUAJE?>" lang="<?=SITE_LENGUAJE?>">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=<?=CHARSET?>" />
<title><?=$this->getTitle();?></title>
<meta name="title" content="<?=SITE_Name;?> :: <?=$this->getTitle();?>" />
<meta name="description" content="<?=$this->getDescription();?>" />
<meta name="keywords" content="<?=$this->getKeywords();?>" />
<meta name="language" content="<?=SITE_LENGUAJE?>" />
<meta http-equiv="Content-Language" content="<?=SITE_LENGUAJE?>" />
<meta name="revisit-after" content="7 days" />
<meta name="robot" content="Index,Follow" />
<meta name="robot" content="All" />
<meta name="Distribution" content="Global" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta name="rating" content="general" />
<meta name="author" http-equiv="Author" content="<?=AUTOR?>"/>
<meta name="copyright" content="Copyright <?=ANIO?> | <?=CLIENTE?>" />
<link rel="icon" type="image/x-icon" href="http://<?=SITE_Url;?>/favicon.ico" />
<link rel="shortcut icon" href="http://<?=SITE_Url;?>/favicon.ico" />

<style type="text/css" media="screen">
	@import "share/css/theme/<?=SITE_Theme;?>/estilos.css";
</style>

<script type="text/javascript">
	var es_IE6 = false;
</script>

<!--[if IE]>
	<link rel="stylesheet" type="text/css" href="share/css/theme/<?=SITE_Theme;?>/ie.css" />
<![endif]-->

<!--[if IE 6]>
	<link rel="stylesheet" type="text/css" href="share/css/theme/<?=SITE_Theme;?>/ie6.css" />
	<script  type="text/javascript" src="share/js/DD_belatedPNG_0.0.8a-min.js"></script>
	<script  type="text/javascript">
		DD_belatedPNG.fix('.transparente');
		var es_IE6 = true;
	</script>
<![endif]-->

<!--[if IE 7]>
	<link rel="stylesheet" type="text/css" href="share/css/theme/<?=SITE_Theme;?>/ie7.css" />
<![endif]-->

<!--[if IE 8]>
	<link rel="stylesheet" type="text/css" href="share/css/theme/<?=SITE_Theme;?>/ie8.css" />
<![endif]-->

<link rel="stylesheet" type="text/css" href="share/css/theme/<?=SITE_Theme;?>/global.css" />
<link rel="stylesheet" type="text/css" href="share/css/impromptu.css" />
<link rel="stylesheet" type="text/css" href="share/css/jquery-ui-1.7.2.custom.css" />

<script type="text/javascript" src="share/js/jquery-1.3.2.min.js"></script>
<script language="javascript" type="text/javascript" src="share/js/jquery-impromptu.1.2.js"></script>
<script type="text/javascript" src="share/js/jquery-ui-1.7.2.custom.min.js"></script>
<script type="text/javascript" src="share/js/js_backend.js"></script>
<script language="javascript" type="text/javascript" src="share/js/ajaxfileupload.js"></script>
<script language="javascript" type="text/javascript" src="share/js/common.js"></script>

<?PHP
	$this->generateInitFunctionsJS();
	$this->getWidgets();
	global $SITE_User;
?>
	
<script type="text/javascript">
	var sUrlSite = '<?=SERVER_Name;?>';
</script>

</head>
<body>
	
<!-- INI: Capas para efectos lightbox -->
<div id="lightBG" onclick="JS_closeBox();"></div>
<div id="lightBOX"></div>
<!-- END: Capas para efectos lightbox -->	

<hr />

<div class="header">
	<div class="top">
		<div class="izq">
			<div class="deg"><a href="../" target="_blank"><img src="http://<?=SERVER_Name;?>/share/css/theme/<?=SITE_Theme;?>/img/img-deg-top.png" width="211" height="70" alt="" class="transparente" /></a></div>
		</div>
		<div class="der">
			<ul class="ul-der-top">
				<?php if (isset($SITE_User->sNombre)) { ?>
				<li class="cantopri">Bienvenido <em><?=$SITE_User->sNombre;?></em></li>
				<? } ?>
				<li>
					<div class="btn-gris-1">
						<div class="izq-btn-1 transparente">&nbsp;</div>
						<div class="der-btn-1 transparente"><a href="../" target="_blank">Visitar sitio</a></div>
					</div>
				</li>
				<li id="selector-idioma">
					<div class="btn-gris-1">
						<div class="izq-btn-1 transparente">&nbsp;</div>
						<div class="der-btn-1 transparente"><a href="#" class="ie6">Idioma</a><a href="#" class="ie6"><img src="http://<?=SERVER_Name;?>/share/css/theme/<?=SITE_Theme;?>/img/ico-mas-btn-gris.png" width="19" height="20" alt="" /></a></div>
					</div>
					<div id="lista-idiomas">
						<div class="top-lista"><img src="http://<?=SERVER_Name;?>/share/css/theme/<?=SITE_Theme;?>/img/img-sombra-top-sm-idioma.png" width="57" height="3" alt="" /></div>
						<ul>
	
					<?php
					foreach ($SITE_LANG as $sLang => $aLang)
					{
						?>
						<li><a href="<?=getPermalink('home', NULL, 'lang=' . $sLang );?>"><span class="<?=$sLang;?>"><?=$aLang["nombre"];?></span></a></li>
						<?
					}
					?>
						</ul>
						<div class="aba-lista"><img src="http://<?=SERVER_Name;?>/share/css/theme/<?=SITE_Theme;?>/img/img-aba-sm-idioma.png" width="57" height="4" alt="" /></div>
					</div>
				</li>
				<li>
					<div class="btn-gris-1">
						<div class="izq-btn-1 transparente">&nbsp;</div>
						<div class="der-btn-1 transparente"><a href="<?=getPermalink('home', 'logout');?>" id="cerrar-sesion">Cerrar Sesión</a></div>
					</div>
				</li>
			</ul>
		</div>
	</div>
	<div class="aba">
		<div class="que-nombre-le-pongo-a-esto">
			<h5>No te olvides de mantener tu perfil actualizado</h5>
		</div>
	</div>
</div>

<div class="contenedor">
	<div class="cuerpo">

		<? if ($SITE_oSession->Check()) { ?>
			<div class="barra-izq">
				<div class="item-menu <?=(SITE_CURRENT_Modulo=="home")?"item-menu-activo":"";?>" id="home">
						<?php
							$sHome = './';
						?>
					<ul class="top-item">
						<li class="ico-menu"><a href="<?=$sHome;?>"><img src="http://<?=SERVER_Name;?>/share/css/theme/<?=SITE_Theme;?>/img/ico-home.gif" alt="" /></a></li>
						<li class="link"><a href="<?=$sHome;?>">Inicio</a></li>
					</ul>
				</div>
				<?
			if ($SITE_User->checkModuleId('menu')) {
				?>
				<div class="item-menu <?=(SITE_CURRENT_Modulo=="menu")?"item-menu-activo":"";?>" id="menu">
					<ul class="top-item">
						<?php
							$sMenu = 'index.php?modid=menu&pgid=index';
						?>
						<li class="ico-menu"><a href="<?=$sMenu;?>"><img src="http://<?=SERVER_Name;?>/share/css/theme/<?=SITE_Theme;?>/img/ico-menu.gif" alt="" /></a></li>
						<li class="link"><a href="<?=$sMenu;?>">Menú</a></li>
					</ul>
				</div>
				<?
			}
				foreach($aComponentes as $sID => $sNombre) {
					if ($SITE_User->checkModuleId($sID)) {
					if ((sizeof($SITE_aModulos[$sID])==1)) {
					?>
						<div class="item-menu <?=($sID==SITE_CURRENT_Modulo)?"item-menu-activo":"";?>" id="<?=$sID;?>">
							<ul class="top-item">
								<?
									$sLink = "JS_header('".getPermalink($sID, $aPagina['url'])."')";
								?>
								<li class="ico-menu"><a href="#" onclick="<?=$sLink;?>"><img src="http://<?=SERVER_Name;?>/share/css/theme/<?=SITE_Theme;?>/img/ico-<?=$sID;?>.gif" alt="" /></a></li>
								<li class="link"><a href="#" onclick="<?=$sLink;?>"><?=$sNombre;?></a></li>
							</ul>
						</div>
					<?	
					} else {
					?>
						<div class="item-menu  <?=($sID==SITE_CURRENT_Modulo)?"item-menu-activo item-abierto":"item-cerrado";?> item-triplete" id="<?=$sID;?>">
						<ul class="top-item">
							<li class="ico-menu"><a href="#"><img src="http://<?=SERVER_Name;?>/share/css/theme/<?=SITE_Theme;?>/img/ico-<?=$sID;?>.gif" alt="" /></a></li>
							<li class="link"><a href="#"><?=$sNombre;?></a></li>
							<li class="mas-por-menos"><a href="#">&nbsp;</a></li>
						</ul>
						<ul class="lista-item">
							<?
							$primero = true;
							foreach($SITE_aModulos[$sID]["pg"] as $sCOD => $aPagina) {
								$mostrar = true;
								if (isset($aPagina["display"])) {
									if ($aPagina["display"]!="") {
										$mostrar = false;
									}
								}
								if ($mostrar) {
									?>
										<li class="<?=($primero)?"laprimeraenlalista":"";?>"><a href="#" <?=(($aPagina["url"]==SITE_CURRENT_Page)&&($sID==SITE_CURRENT_Modulo))?'class="activo"':'';?>" onclick="JS_header('<?=getPermalink($sID, $aPagina['url']);?>')"><?=$aPagina['name'];?></a></li>
									<?
									$primero=false;
								}
							}
							?>
							<li class="borde-aba transparente">&nbsp;</li>
						</ul>
						</div>
					<? } ?>
				<? }
				}?>
			</div>
		<? } ?>

		<div <?=($SITE_oSession->Check())?'':'id="login"';?> class="contenido">
				
