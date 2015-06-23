<?PHP
	$aVars = $this->getGlobalVars();
	foreach ($aVars as $sVar => $mVar)
	{
		eval("$\$sVar = \$this->get(\"$sVar\");");
	}
	unset($aVars);
	global $SITE_LANG;

	$aConfiguracion = getObjeto('configuracion')->rows(NULL, "conf_idioma='" . SITE_LENGUAJE . "'");
	define ('SITE_Name', (!empty($aConfiguracion[1]['conf_dato']) ? $aConfiguracion[1]['conf_dato'] : 'Mi sitio '));
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title><?=SITE_Name;?> :: <?=$this->getTitle();?></title>
	<meta name="description" content="<?=$this->getDescription();?>" />
	<meta name="keywords" content="<?=$this->getKeywords();?>" />

	<?PHP
	global $SITE_User, $SITE_aModulos, $aCateroriasUsuarios;
	if (!$this->bSiteInProduction)
	{
		$this->registerCSS('/share/css/global.css', 0);
		$this->registerJS('/share/js/common.js');
		echo $this->getCSS();
		echo $this->getJS();
	}
	else
	{
		?>
		<link rel="stylesheet" type="text/css" href="share/css/theme/<?=SITE_Theme;?>/global.css" />
		<link rel="stylesheet" type="text/css" href="share/css/impromptu.css" />
		<script language="javascript" type="text/javascript" src="share/js/jquery-1.3.1.js"></script>
		<script language="javascript" type="text/javascript" src="share/js/jquery-impromptu.1.2.js"></script>
		<script language="javascript" type="text/javascript" src="share/js/ajaxfileupload.js"></script>
		<script language="javascript" type="text/javascript" src="share/js/common.js"></script>
		<?PHP
	}
	$this->generateInitFunctionsJS();
	$this->getWidgets();
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

	<div id="pgWrapper">
		<div id="mnuTop">
			<h2><?=SITE_Name;?></h2>
			<ul>
				<?php
				if (isset($SITE_User->sNombre))
				{
					?><li><?=___('Bienvenido');?> <?=$SITE_User->sNombre;?></li><?php
				}
				?>
				<li><a href="http://<?=SITE_Url;?>/" target="_blank" title="<?=___('Ir al sitio');?>" ><?=___('Ir al sitio');?></a></li>
				<li><a href="<?=getPermalink('home', 'logout');?>" title="<?=__('Salir del sistema');?>"><?=__('Salir');?></a></li>
			</ul>
			<div class="clear" style="height:32px;"></div>
			<ul class="subMenu">
				<?php
				foreach ($SITE_LANG as $sLang => $aLang)
				{
					/* ?><li <?=(SITE_LENGUAJE == $sLang ? 'class="activecat"' : '')?> style="border:none;"><a href="<?=getPermalink('home', NULL, 'lang=' . $sLang );?>" ><?=(SITE_LENGUAJE == $sLang ? '&raquo;' : '')?> <img src="http://<?=SITE_Url;?>/img/lang/<?=$sLang?>.png" alt="<?=$sLang;?>" width="20" /> <?=$aLang['nombre'];?> <?=(SITE_LENGUAJE == $sLang ? '&laquo;' : '')?></a></li><?php */
					?><li <?=(SITE_LENGUAJE == $sLang ? 'class="activelang"' : '')?> ><a href="<?=getPermalink('home', NULL, 'lang=' . $sLang );?>" ><img src="http://<?=SITE_Url;?>/img/lang/<?=$sLang?>.png" alt="<?=$sLang;?>" width="20" /></a></li><?php
				}
				?>
			</ul>
			<div class="clear"></div>
		</div>
		<?php
		if (isset($SITE_User->sNombre))
		{
			?>
			<div id="hdMain">
				<div id="mnuMain">
					<ul>
						<li <?=(SITE_CURRENT_Modulo == 'home'	? 'class="active"': '')?> ><a href="<?=getPermalink('home');?>" title="<?=$SITE_aModulos['home']['name'];?>"><?=$SITE_aModulos['home']['name'];?></a></li>
						<li <?=(SITE_CURRENT_Modulo == 'menu'	? 'class="active"': '')?> ><a href="<?=getPermalink('menu');?>" title="<?=$SITE_aModulos['menu']['name'];?>"><?=$SITE_aModulos['menu']['name'];?></a></li>
						<?php
						foreach ($SITE_aModulos as $sModId => $aModulo)
						{
							if ($sModId != 'system')
							{
								if ($SITE_User->checkModuleId($sModId))
								{
									?>
						<li <?=(SITE_CURRENT_Modulo == $sModId	? 'class="active"': '')?> ><a href="<?=getPermalink($sModId, (isset($aModulo['pgs']) ? $aModulo['pgs'] : NULL));?>" title="<?=$aModulo['name'];?>"><?=$aModulo['name'];?></a></li>
						<?PHP
								}
							}
						}
						?>
					</ul>
				</div>
			</div>
			<?php
			if (SITE_CURRENT_Modulo != 'home' && $aSubModulos = $this->getChildrenModules())
			{
				?>
				<div id="mnuSecundario">
					<ul>
						<?PHP

						foreach ($aSubModulos as $sModId => $aSubModulo)
						{
							if (!isset($aSubModulo['display']) || $aSubModulo['display'] != 'hidden')
							{
								echo ((isset($aSubModulo['space_left']) && $aSubModulo['space_left']) ? '<li><a>&nbsp;</a></li>' : '');
								?>
-								<li <?=(SITE_CURRENT_Page == $sModId ? 'class="active"' : '');?>><a href="<?=getPermalink(SITE_CURRENT_Modulo, $aSubModulo['url']);?>" title="<?=$aSubModulo['name'];?>"><?=$aSubModulo['name'];?></a></li>
								<?PHP
							}
						}
						?>
					</ul>
				</div>
				<?PHP
			}
		}
		?>