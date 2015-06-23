			<div id="ftMain">
				<div class="cnt">
					<h4><?=$this->getTitle();?></h4>
					<p>
						<?=__('Todos los derechos reservados');?>  &copy; &reg; <?=date('Y');?> 
						<?=($SITE_User->checkModuleId('system') ? ' - <a href="' . getPermalink('system') . '" title="' . __('Panel administrativo') . '">' . __('Panel administrativo') . '</a>' : '');?> 
						- <a href="http://<?=SITE_Url;?>" target="_blank" title="<?=___('Ir al sitio');?>" ><?=___('Ir al sitio');?></a> 
						- <a href="<?=getPermalink('home', 'logout');?>" title="<?=__('Salir del sistema');?>"><?=__('Salir');?></a>
					</p>
				</div>
				<?php
				/*
				<h3><a href="http://4rsoluciones.com" title="<?=__('Diseño, desarrollo y alojamiento');?>"><span><?=__('Diseño, desarrollo y alojamiento: 4rStudios');?></span></a></h3>
				*/
				?>
				<div class="clear"></div>
			</div>
		</div>
	</body>
</html>