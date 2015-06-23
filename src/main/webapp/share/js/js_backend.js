// <![CDATA[
	$(document).ready(
		function() {
			// le saca los puntitos de m*** a los links en IE
			if ($.browser.msie) {
				$('a').focus(
					function() {
						$(this).blur()
					}
				);
			}
			// menu idioma
			$('#selector-idioma, #selector-idioma a').click(
				function() {
					$('#lista-idiomas').slideDown(300);
				}
			);
			$('#lista-idiomas').hover(
				null,
				function() {
					$('#lista-idiomas').slideUp(200);
				}
			);
			if(es_IE6) {
				$('ul.ul-item').hover(
					function() {
						$(this).css('background', '#F8F8F8');
					},
					function() {
						$(this).css('background', 'none');
					}
				)
			}
			// menu izquierda
			var delay_menu_izq = 350;
			var altura_item = $('ul.lista-item li').height();
			altura_item=18;
			var altura_titulo_lista = $('ul.top-item').height();
			var relleno_item_lista = parseFloat($('li.laprimeraenlalista').css('padding-top'));
			function alturaMenuActivo(quien, muestranima, abre) {
				var altura_lista_menu = (quien.children('.lista-item').find('li').length - 1) * altura_item + altura_titulo_lista + relleno_item_lista;
				var cierra_abre = quien.find('li.mas-por-menos a');

				if (!$(quien).hasClass("item-triplete")) return false;

				if(abre) {
					switch(muestranima) {
						case 'muestra':
							quien.css('height', altura_lista_menu + 'px');
							break;
						case 'anima':
							quien.animate({'height': altura_lista_menu + 'px'}, delay_menu_izq);
							break;
					}
				}
				else {
					switch(muestranima) {
						case 'muestra':
							quien.css('height', altura_titulo_lista + 'px');
							break;
						case 'anima':
							quien.animate({'height': altura_titulo_lista + 'px'}, delay_menu_izq);
							break;
					}
				}
			}
			function abreCierraMenus(quien) {
				var papacho = quien.parents('.item-menu');
				if (papacho.hasClass('item-cerrado')) {
					papacho.removeClass('item-cerrado');
					papacho.addClass('item-abierto');
					quien.parents('.item-menu').find('.lista-item').slideDown(delay_menu_izq);
					alturaMenuActivo(quien.parents('.item-menu'), 'anima', true);
				}
				else {
					papacho.removeClass('item-abierto');
					papacho.addClass('item-cerrado');
					quien.parents('.item-menu').find('.lista-item').slideUp(delay_menu_izq);
					alturaMenuActivo(quien.parents('.item-menu'), 'anima', false);
				}
			}
			$('.item-triplete .top-item a').click(
				function() {
					abreCierraMenus($(this));
					return false;
				}
			);			
			
			// muestra el menu que está activo
			
			alturaMenuActivo($('.item-menu-activo'), 'muestra', true);
			
			/* estilos para los selects */
			/* ni vale la pena hacer esto en IE 6 */
			if (!($.browser.msie && $.browser.version == "6.0")) {
				$('.select-estilo').css('filter', 'alpha(opacity=0)');
				$('.select-estilo').css('opacity', '0');
				$('.select-estilo').change(function() {
					var opcion = $(this).children(":selected").text();
					$(this).parent().children('.span-estilo').text(opcion);
				});
				/* que ponga autom�ticamente el texto del que este seleccionado */
				$('.span-estilo').each(
					function() {$(this).text($(this).parent().children('.select-estilo').children(':selected').text())}
				);
			}
			/* checkbox con estilo */
			/* los que ya estan checkeados */
			var alt_check = $('.span-check').css('height');
			/* opacidad que valida */
			$('.check').css('filter', 'alpha(opacity=0)');
			$('.check').css('opacity', '0');
			$('input.check:checked').parent().css({'background-position' : '0 -' + alt_check});
			/* click */
			$('input.check').click(function() {
					if($(this).is(':checked')) {
						$(this).parent().css({'background-position' : '0 -' + alt_check});
					}
					else {
						$(this).parent().css({'background-position' : '0 0'});
					}
				}
			);
			// tooltips
			$('ul.axion li a').hover(
				function() {
					var tt = $(this).parent().find('.tooltip');
					if(tt.is(':animated')) {
						return;
					}
					tt.fadeIn(250);
				},
				function() {
					$(this).parent().find('.tooltip').hide();
				}
			);
			$('.ancho-128-6').hover(
				null,
				function() {
					$(this).find('.tooltip').hide();
				}
			);

/*
			jQuery(function($){
				$.datepicker.regional['es'] = {
				        closeText: 'Cerrar',
				        prevText: '&#x3c;Ant',
				        nextText: 'Sig&#x3e;',
				        currentText: 'Hoy',
				        monthNames: ['Enero','Febrero','Marzo','Abril','Mayo','Junio',
				        'Julio','Agosto','Septiembre','Octubre','Noviembre','Diciembre'],
				        monthNamesShort: ['Ene','Feb','Mar','Abr','May','Jun',
				        'Jul','Ago','Sep','Oct','Nov','Dic'],
				        dayNames: ['Domingo','Lunes','Martes','Mi&eacute;rcoles','Jueves','Viernes','S&aacute;bado'],
				        dayNamesShort: ['Dom','Lun','Mar','Mi&eacute;','Juv','Vie','S&aacute;b'],
				        dayNamesMin: ['Do','Lu','Ma','Mi','Ju','Vi','S&aacute;'],
				        weekHeader: 'Sm',
				        dateFormat: 'dd/mm/yy',
				        firstDay: 1,
				        isRTL: false,
				        showMonthAfterYear: false,
				        yearSuffix: ''};
				$.datepicker.setDefaults($.datepicker.regional['es']);
			});
*/
		}
	);

// ]]>