						<div id="tepaginolapagina">
							<?PHP

							if (isset($aBas) && $aBas)
							{
								?>
								<ul>
									<?PHP
									if ($aBas['before'])
									{
										?><li class="anterior"><a href="<?=getPermalink(SITE_CURRENT_Modulo, SITE_CURRENT_Page, $aBas['before']);?>" title="<?=__('Página anterior');?>"><img class="transparente" height="13" width="7" alt="" src="http://<?=SITE_SHARE;?>/img/ico-flecha-ant.png"/></a></li><?PHP
									}
									else
									{
										?><li class="disablepage"><img class="transparente" height="13" width="7" alt="" src="http://<?=SITE_SHARE;?>/img/ico-flecha-ant.png"/></li><?PHP
									}#página anterior

									//<li><span>...</span></li>
									foreach ($aBas['pages'] as $mLink)
									{
										if ($mLink)
										{
											if (!is_null($mLink['link']))
											{
												?><li class="numeros" ><a <?=(!is_null($mLink['link']) ? 'href="' . getPermalink(SITE_CURRENT_Modulo, SITE_CURRENT_Page, $mLink['link']) . '"' : '');?>>
												<span class="izq">
													<img class="transparente" height="17" width="2" alt="" src="http://<?=SITE_SHARE;?>/img/img-izq-num-pag.png"/>
												</span>
												<span class="fondiu"><?=$mLink['lbl'];?></span>
												<span class="der">
													<img class="transparente" height="17" width="2" alt="" src="http://<?=SITE_SHARE;?>/img/img-der-num-pag.png"/>
												</span>
												</a></li><?PHP
											}else
											{
												?><li class="numeros activo"><?=$mLink['lbl'];?></li><?PHP
											}
										}
										else
										{
											?><li><span>...</span></li><?PHP
										}
									}
									//<li><span>...</span></li>
									# end Parte media del paginador

									if ($aBas['next'])
									{
										?><li class="siguiente"><a href="<?=getPermalink(SITE_CURRENT_Modulo, SITE_CURRENT_Page, $aBas['next']);?>" title="<?=__('Página siguiente');?>"><img class="transparente" height="13" width="7" alt="" src="http://<?=SITE_SHARE;?>/img/ico-flecha-sig.png"/></a></li><?PHP
									}
									else
									{
										?><li class="siguiente"><img class="transparente" height="13" width="7" alt="" src="http://<?=SITE_SHARE;?>/img/ico-flecha-sig.png"/></li><?PHP
									}#siguiente página
									?>
								</ul>
								<?PHP
							}
							?>
						</div>