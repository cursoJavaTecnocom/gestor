 /*
Copyright (c) 2003-2012, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
*/

/**
 * @fileOverview Defines the {@link CKEDITOR.lang} object, for the
 * Spanish language.
 */

/**#@+
   @type String
   @example
*/

/**
 * Contains the dictionary of language entries.
 * @namespace
 */
CKEDITOR.lang['es'] =
{
	/**
	 * The language reading direction. Possible values are "rtl" for
	 * Right-To-Left languages (like Arabic) and "ltr" for Left-To-Right
	 * languages (like English).
	 * @default 'ltr'
	 */
	dir : 'ltr',

	/*
	 * Screenreader titles. Please note that screenreaders are not always capable
	 * of reading non-English words. So be careful while translating it.
	 */
	editorTitle : 'Rich text editor, %1', // MISSING
	editorHelp : 'Press ALT 0 for help', // MISSING

	// ARIA descriptions.
	toolbars	: 'Barras de herramientas del editor',
	editor		: 'Editor de texto enriquecido',

	// Toolbar buttons without dialogs.
	source			: 'Fuente HTML',
	newPage			: 'Nueva P�gina',
	save			: 'Guardar',
	preview			: 'Vista Previa',
	cut				: 'Cortar',
	copy			: 'Copiar',
	paste			: 'Pegar',
	print			: 'Imprimir',
	underline		: 'Subrayado',
	bold			: 'Negrita',
	italic			: 'Cursiva',
	selectAll		: 'Seleccionar Todo',
	removeFormat	: 'Eliminar Formato',
	strike			: 'Tachado',
	subscript		: 'Sub�ndice',
	superscript		: 'Super�ndice',
	horizontalrule	: 'Insertar L�nea Horizontal',
	pagebreak		: 'Insertar Salto de P�gina',
	pagebreakAlt		: 'Salto de p�gina',
	unlink			: 'Eliminar V�nculo',
	undo			: 'Deshacer',
	redo			: 'Rehacer',

	// Common messages and labels.
	common :
	{
		browseServer	: 'Ver Servidor',
		url				: 'URL',
		protocol		: 'Protocolo',
		upload			: 'Cargar',
		uploadSubmit	: 'Enviar al Servidor',
		image			: 'Imagen',
		flash			: 'Flash',
		form			: 'Formulario',
		checkbox		: 'Casilla de Verificaci�n',
		radio			: 'Botones de Radio',
		textField		: 'Campo de Texto',
		textarea		: 'Area de Texto',
		hiddenField		: 'Campo Oculto',
		button			: 'Bot�n',
		select			: 'Campo de Selecci�n',
		imageButton		: 'Bot�n Imagen',
		notSet			: '<No definido>',
		id				: 'Id',
		name			: 'Nombre',
		langDir			: 'Orientaci�n',
		langDirLtr		: 'Izquierda a Derecha (LTR)',
		langDirRtl		: 'Derecha a Izquierda (RTL)',
		langCode		: 'C�d. de idioma',
		longDescr		: 'Descripci�n larga URL',
		cssClass		: 'Clases de hojas de estilo',
		advisoryTitle	: 'T�tulo',
		cssStyle		: 'Estilo',
		ok				: 'Aceptar',
		cancel			: 'Cancelar',
		close			: 'Cerrar',
		preview			: 'Previsualizaci�n',
		generalTab		: 'General',
		advancedTab		: 'Avanzado',
		validateNumberFailed : 'El valor no es un n�mero.',
		confirmNewPage	: 'Cualquier cambio que no se haya guardado se perder�.\r\n¿Est� seguro de querer crear una nueva p�gina?',
		confirmCancel	: 'Algunas de las opciones se han cambiado.\r\n¿Est� seguro de querer cerrar el di�logo?',
		options			: 'Opciones',
		target			: 'Destino',
		targetNew		: 'Nueva ventana (_blank)',
		targetTop		: 'Ventana principal (_top)',
		targetSelf		: 'Misma ventana (_self)',
		targetParent	: 'Ventana padre (_parent)',
		langDirLTR		: 'Izquierda a derecha (LTR)',
		langDirRTL		: 'Derecha a izquierda (RTL)',
		styles			: 'Estilos',
		cssClasses		: 'Clase de la hoja de estilos',
		width			: 'Anchura',
		height			: 'Altura',
		align			: 'Alineaci�n',
		alignLeft		: 'Izquierda',
		alignRight		: 'Derecha',
		alignCenter		: 'Centrado',
		alignTop		: 'Tope',
		alignMiddle		: 'Centro',
		alignBottom		: 'Pie',
		invalidHeight	: 'Altura debe ser un n�mero.',
		invalidWidth	: 'Anchura debe ser un n�mero.',
		invalidCssLength	: 'El valor especificado para el campo "%1" debe ser un n�mero positivo, incluyendo optionalmente una unidad de medida CSS v�lida (px, %, in, cm, mm, em, ex, pt, o pc).',
		invalidHtmlLength	: 'El valor especificado para el campo "%1" debe ser un n�mero positivo, incluyendo optionalmente una unidad de medida HTML v�lida (px o %).',
		invalidInlineStyle	: 'El valor especificado para el estilo debe consistir en uno o m�s pares con el formato "nombre: valor", separados por punto y coma.',
		cssLengthTooltip	: 'Introduca un n�mero para el valor en pixels o un n�mero con una unidad de medida CSS v�lida (px, %, in, cm, mm, em, ex, pt, o pc).',

		// Put the voice-only part of the label in the span.
		unavailable		: '%1<span class="cke_accessibility">, no disponible</span>'
	},

	contextmenu :
	{
		options : 'Opciones del men� contextual'
	},

	// Special char dialog.
	specialChar		:
	{
		toolbar		: 'Insertar Caracter Especial',
		title		: 'Seleccione un caracter especial',
		options : 'Opciones de caracteres especiales'
	},

	// Link dialog.
	link :
	{
		toolbar		: 'Insertar/Editar V�nculo',
		other 		: '<otro>',
		menu		: 'Editar V�nculo',
		title		: 'V�nculo',
		info		: 'Informaci�n de V�nculo',
		target		: 'Destino',
		upload		: 'Cargar',
		advanced	: 'Avanzado',
		type		: 'Tipo de v�nculo',
		toUrl		: 'URL',
		toAnchor	: 'Referencia en esta p�gina',
		toEmail		: 'E-Mail',
		targetFrame		: '<marco>',
		targetPopup		: '<ventana emergente>',
		targetFrameName	: 'Nombre del Marco Destino',
		targetPopupName	: 'Nombre de Ventana Emergente',
		popupFeatures	: 'Caracter�sticas de Ventana Emergente',
		popupResizable	: 'Redimensionable',
		popupStatusBar	: 'Barra de Estado',
		popupLocationBar: 'Barra de ubicaci�n',
		popupToolbar	: 'Barra de Herramientas',
		popupMenuBar	: 'Barra de Men�',
		popupFullScreen	: 'Pantalla Completa (IE)',
		popupScrollBars	: 'Barras de desplazamiento',
		popupDependent	: 'Dependiente (Netscape)',
		popupLeft		: 'Posici�n Izquierda',
		popupTop		: 'Posici�n Derecha',
		id				: 'Id',
		langDir			: 'Orientaci�n',
		langDirLTR		: 'Izquierda a Derecha (LTR)',
		langDirRTL		: 'Derecha a Izquierda (RTL)',
		acccessKey		: 'Tecla de Acceso',
		name			: 'Nombre',
		langCode			: 'C�digo idioma',
		tabIndex			: 'Indice de tabulaci�n',
		advisoryTitle		: 'T�tulo',
		advisoryContentType	: 'Tipo de Contenido',
		cssClasses		: 'Clases de hojas de estilo',
		charset			: 'Fuente de caracteres vinculado',
		styles			: 'Estilo',
		rel			: 'Relaci�n',
		selectAnchor		: 'Seleccionar una referencia',
		anchorName		: 'Por Nombre de Referencia',
		anchorId			: 'Por ID de elemento',
		emailAddress		: 'Direcci�n de E-Mail',
		emailSubject		: 'T�tulo del Mensaje',
		emailBody		: 'Cuerpo del Mensaje',
		noAnchors		: '(No hay referencias disponibles en el documento)',
		noUrl			: 'Por favor escriba el v�nculo URL',
		noEmail			: 'Por favor escriba la direcci�n de e-mail'
	},

	// Anchor dialog
	anchor :
	{
		toolbar		: 'Referencia',
		menu		: 'Propiedades de Referencia',
		title		: 'Propiedades de Referencia',
		name		: 'Nombre de la Referencia',
		errorName	: 'Por favor, complete el nombre de la Referencia',
		remove		: 'Quitar Referencia'
	},

	// List style dialog
	list:
	{
		numberedTitle		: 'Propiedades de lista numerada',
		bulletedTitle		: 'Propiedades de vi�etas',
		type				: 'Tipo',
		start				: 'Inicio',
		validateStartNumber				:'El Inicio debe ser un n�mero entero.',
		circle				: 'C�rculo',
		disc				: 'Disco',
		square				: 'Cuadrado',
		none				: 'Ninguno',
		notset				: '<sin establecer>',
		armenian			: 'Numeraci�n armenia',
		georgian			: 'Numeraci�n georgiana (an, ban, gan, etc.)',
		lowerRoman			: 'N�meros romanos en min�sculas (i, ii, iii, iv, v, etc.)',
		upperRoman			: 'N�meros romanos en may�sculas (I, II, III, IV, V, etc.)',
		lowerAlpha			: 'Alfabeto en min�sculas (a, b, c, d, e, etc.)',
		upperAlpha			: 'Alfabeto en may�sculas  (A, B, C, D, E, etc.)',
		lowerGreek			: 'Letras griegas (alpha, beta, gamma, etc.)',
		decimal				: 'Decimal (1, 2, 3, etc.)',
		decimalLeadingZero	: 'Decimal con cero inicial (01, 02, 03, etc.)'
	},

	// Find And Replace Dialog
	findAndReplace :
	{
		title				: 'Buscar y Reemplazar',
		find				: 'Buscar',
		replace				: 'Reemplazar',
		findWhat			: 'Texto a buscar:',
		replaceWith			: 'Reemplazar con:',
		notFoundMsg			: 'El texto especificado no ha sido encontrado.',
		findOptions			: 'Opciones de b�squeda',
		matchCase			: 'Coincidir may/min',
		matchWord			: 'Coincidir toda la palabra',
		matchCyclic			: 'Buscar en todo el contenido',
		replaceAll			: 'Reemplazar Todo',
		replaceSuccessMsg	: 'La expresi�n buscada ha sido reemplazada %1 veces.'
	},

	// Table Dialog
	table :
	{
		toolbar		: 'Tabla',
		title		: 'Propiedades de Tabla',
		menu		: 'Propiedades de Tabla',
		deleteTable	: 'Eliminar Tabla',
		rows		: 'Filas',
		columns		: 'Columnas',
		border		: 'Tama�o de Borde',
		widthPx		: 'pixeles',
		widthPc		: 'porcentaje',
		widthUnit	: 'unidad de la anchura',
		cellSpace	: 'Esp. e/celdas',
		cellPad		: 'Esp. interior',
		caption		: 'T�tulo',
		summary		: 'S�ntesis',
		headers		: 'Encabezados',
		headersNone		: 'Ninguno',
		headersColumn	: 'Primera columna',
		headersRow		: 'Primera fila',
		headersBoth		: 'Ambas',
		invalidRows		: 'El n�mero de filas debe ser un n�mero mayor que 0.',
		invalidCols		: 'El n�mero de columnas debe ser un n�mero mayor que 0.',
		invalidBorder	: 'El tama�o del borde debe ser un n�mero.',
		invalidWidth	: 'La anchura de tabla debe ser un n�mero.',
		invalidHeight	: 'La altura de tabla debe ser un n�mero.',
		invalidCellSpacing	: 'El espaciado entre celdas debe ser un n�mero.',
		invalidCellPadding	: 'El espaciado interior debe ser un n�mero.',

		cell :
		{
			menu			: 'Celda',
			insertBefore	: 'Insertar celda a la izquierda',
			insertAfter		: 'Insertar celda a la derecha',
			deleteCell		: 'Eliminar Celdas',
			merge			: 'Combinar Celdas',
			mergeRight		: 'Combinar a la derecha',
			mergeDown		: 'Combinar hacia abajo',
			splitHorizontal	: 'Dividir la celda horizontalmente',
			splitVertical	: 'Dividir la celda verticalmente',
			title			: 'Propiedades de celda',
			cellType		: 'Tipo de Celda',
			rowSpan			: 'Expandir filas',
			colSpan			: 'Expandir columnas',
			wordWrap		: 'Ajustar al contenido',
			hAlign			: 'Alineaci�n Horizontal',
			vAlign			: 'Alineaci�n Vertical',
			alignBaseline	: 'Linea de base',
			bgColor			: 'Color de fondo',
			borderColor		: 'Color de borde',
			data			: 'Datos',
			header			: 'Encabezado',
			yes				: 'S�',
			no				: 'No',
			invalidWidth	: 'La anchura de celda debe ser un n�mero.',
			invalidHeight	: 'La altura de celda debe ser un n�mero.',
			invalidRowSpan	: 'La expansi�n de filas debe ser un n�mero entero.',
			invalidColSpan	: 'La expansi�n de columnas debe ser un n�mero entero.',
			chooseColor		: 'Elegir'
		},

		row :
		{
			menu			: 'Fila',
			insertBefore	: 'Insertar fila en la parte superior',
			insertAfter		: 'Insertar fila en la parte inferior',
			deleteRow		: 'Eliminar Filas'
		},

		column :
		{
			menu			: 'Columna',
			insertBefore	: 'Insertar columna a la izquierda',
			insertAfter		: 'Insertar columna a la derecha',
			deleteColumn	: 'Eliminar Columnas'
		}
	},

	// Button Dialog.
	button :
	{
		title		: 'Propiedades de Bot�n',
		text		: 'Texto (Valor)',
		type		: 'Tipo',
		typeBtn		: 'Boton',
		typeSbm		: 'Enviar',
		typeRst		: 'Reestablecer'
	},

	// Checkbox and Radio Button Dialogs.
	checkboxAndRadio :
	{
		checkboxTitle : 'Propiedades de Casilla',
		radioTitle	: 'Propiedades de Bot�n de Radio',
		value		: 'Valor',
		selected	: 'Seleccionado'
	},

	// Form Dialog.
	form :
	{
		title		: 'Propiedades de Formulario',
		menu		: 'Propiedades de Formulario',
		action		: 'Acci�n',
		method		: 'M�todo',
		encoding	: 'Codificaci�n'
	},

	// Select Field Dialog.
	select :
	{
		title		: 'Propiedades de Campo de Selecci�n',
		selectInfo	: 'Informaci�n',
		opAvail		: 'Opciones disponibles',
		value		: 'Valor',
		size		: 'Tama�o',
		lines		: 'Lineas',
		chkMulti	: 'Permitir m�ltiple selecci�n',
		opText		: 'Texto',
		opValue		: 'Valor',
		btnAdd		: 'Agregar',
		btnModify	: 'Modificar',
		btnUp		: 'Subir',
		btnDown		: 'Bajar',
		btnSetValue : 'Establecer como predeterminado',
		btnDelete	: 'Eliminar'
	},

	// Textarea Dialog.
	textarea :
	{
		title		: 'Propiedades de Area de Texto',
		cols		: 'Columnas',
		rows		: 'Filas'
	},

	// Text Field Dialog.
	textfield :
	{
		title		: 'Propiedades de Campo de Texto',
		name		: 'Nombre',
		value		: 'Valor',
		charWidth	: 'Caracteres de ancho',
		maxChars	: 'M�ximo caracteres',
		type		: 'Tipo',
		typeText	: 'Texto',
		typePass	: 'Contrase�a'
	},

	// Hidden Field Dialog.
	hidden :
	{
		title	: 'Propiedades de Campo Oculto',
		name	: 'Nombre',
		value	: 'Valor'
	},

	// Image Dialog.
	image :
	{
		title		: 'Propiedades de Imagen',
		titleButton	: 'Propiedades de Bot�n de Imagen',
		menu		: 'Propiedades de Imagen',
		infoTab		: 'Informaci�n de Imagen',
		btnUpload	: 'Enviar al Servidor',
		upload		: 'Cargar',
		alt			: 'Texto Alternativo',
		lockRatio	: 'Proporcional',
		resetSize	: 'Tama�o Original',
		border		: 'Borde',
		hSpace		: 'Esp.Horiz',
		vSpace		: 'Esp.Vert',
		alertUrl	: 'Por favor escriba la URL de la imagen',
		linkTab		: 'V�nculo',
		button2Img	: '¿Desea convertir el bot�n de imagen en una simple imagen?',
		img2Button	: '¿Desea convertir la imagen en un bot�n de imagen?',
		urlMissing	: 'Debe indicar la URL de la imagen.',
		validateBorder	: 'El borde debe ser un n�mero.',
		validateHSpace	: 'El espaciado horizontal debe ser un n�mero.',
		validateVSpace	: 'El espaciado vertical debe ser un n�mero.'
	},

	// Flash Dialog
	flash :
	{
		properties		: 'Propiedades de Flash',
		propertiesTab	: 'Propiedades',
		title			: 'Propiedades de Flash',
		chkPlay			: 'Autoejecuci�n',
		chkLoop			: 'Repetir',
		chkMenu			: 'Activar Men� Flash',
		chkFull			: 'Permitir pantalla completa',
 		scale			: 'Escala',
		scaleAll		: 'Mostrar todo',
		scaleNoBorder	: 'Sin Borde',
		scaleFit		: 'Ajustado',
		access			: 'Acceso de scripts',
		accessAlways	: 'Siempre',
		accessSameDomain: 'Mismo dominio',
		accessNever		: 'Nunca',
		alignAbsBottom	: 'Abs inferior',
		alignAbsMiddle	: 'Abs centro',
		alignBaseline	: 'L�nea de base',
		alignTextTop	: 'Tope del texto',
		quality			: 'Calidad',
		qualityBest		: 'La mejor',
		qualityHigh		: 'Alta',
		qualityAutoHigh	: 'Auto Alta',
		qualityMedium	: 'Media',
		qualityAutoLow	: 'Auto Baja',
		qualityLow		: 'Baja',
		windowModeWindow: 'Ventana',
		windowModeOpaque: 'Opaco',
		windowModeTransparent : 'Transparente',
		windowMode		: 'WindowMode',
		flashvars		: 'Opciones',
		bgcolor			: 'Color de Fondo',
		hSpace			: 'Esp.Horiz',
		vSpace			: 'Esp.Vert',
		validateSrc		: 'Por favor escriba el v�nculo URL',
		validateHSpace	: 'Esp.Horiz debe ser un n�mero.',
		validateVSpace	: 'Esp.Vert debe ser un n�mero.'
	},

	// Speller Pages Dialog
	spellCheck :
	{
		toolbar			: 'Ortograf�a',
		title			: 'Comprobar ortograf�a',
		notAvailable	: 'Lo sentimos pero el servicio no est� disponible.',
		errorLoading	: 'Error cargando la aplicaci�n del servidor: %s.',
		notInDic		: 'No se encuentra en el Diccionario',
		changeTo		: 'Cambiar a',
		btnIgnore		: 'Ignorar',
		btnIgnoreAll	: 'Ignorar Todo',
		btnReplace		: 'Reemplazar',
		btnReplaceAll	: 'Reemplazar Todo',
		btnUndo			: 'Deshacer',
		noSuggestions	: '- No hay sugerencias -',
		progress		: 'Control de Ortograf�a en progreso...',
		noMispell		: 'Control finalizado: no se encontraron errores',
		noChanges		: 'Control finalizado: no se ha cambiado ninguna palabra',
		oneChange		: 'Control finalizado: se ha cambiado una palabra',
		manyChanges		: 'Control finalizado: se ha cambiado %1 palabras',
		ieSpellDownload	: 'M�dulo de Control de Ortograf�a no instalado.\r\n¿Desea descargarlo ahora?'
	},

	smiley :
	{
		toolbar	: 'Emoticonos',
		title	: 'Insertar un Emoticon',
		options : 'Opciones de emoticonos'
	},

	elementsPath :
	{
		eleLabel : 'Ruta de los elementos',
		eleTitle : '%1 elemento'
	},

	numberedlist	: 'Numeraci�n',
	bulletedlist	: 'Vi�etas',
	indent			: 'Aumentar Sangr�a',
	outdent			: 'Disminuir Sangr�a',

	justify :
	{
		left	: 'Alinear a Izquierda',
		center	: 'Centrar',
		right	: 'Alinear a Derecha',
		block	: 'Justificado'
	},

	blockquote : 'Cita',

	clipboard :
	{
		title		: 'Pegar',
		cutError	: 'La configuraci�n de seguridad de este navegador no permite la ejecuci�n autom�tica de operaciones de cortado.\r\nPor favor use el teclado (Ctrl/Cmd+X).',
		copyError	: 'La configuraci�n de seguridad de este navegador no permite la ejecuci�n autom�tica de operaciones de copiado.\r\nPor favor use el teclado (Ctrl/Cmd+C).',
		pasteMsg	: 'Por favor pegue dentro del cuadro utilizando el teclado (<STRONG>Ctrl/Cmd+V</STRONG>);\r\nluego presione <STRONG>Aceptar</STRONG>.',
		securityMsg	: 'Debido a la configuraci�n de seguridad de su navegador, el editor no tiene acceso al portapapeles.\r\nEs necesario que lo pegue de nuevo en esta ventana.',
		pasteArea	: 'Zona de pegado'
	},

	pastefromword :
	{
		confirmCleanup	: 'El texto que desea parece provenir de Word.\r\n¿Desea depurarlo antes de pegarlo?',
		toolbar			: 'Pegar desde Word',
		title			: 'Pegar desde Word',
		error			: 'No ha sido posible limpiar los datos debido a un error interno'
	},

	pasteText :
	{
		button	: 'Pegar como Texto Plano',
		title	: 'Pegar como Texto Plano'
	},

	templates :
	{
		button			: 'Plantillas',
		title			: 'Contenido de Plantillas',
		options : 'Opciones de plantillas',
		insertOption	: 'Reemplazar el contenido actual',
		selectPromptMsg	: 'Por favor selecciona la plantilla a abrir en el editor<br>(el contenido actual se perder�):',
		emptyListMsg	: '(No hay plantillas definidas)'
	},

	showBlocks : 'Mostrar bloques',

	stylesCombo :
	{
		label		: 'Estilo',
		panelTitle	: 'Estilos para formatear',
		panelTitle1	: 'Estilos de p�rrafo',
		panelTitle2	: 'Estilos de car�cter',
		panelTitle3	: 'Estilos de objeto'
	},

	format :
	{
		label		: 'Formato',
		panelTitle	: 'Formato',

		tag_p		: 'Normal',
		tag_pre		: 'Con formato',
		tag_address	: 'Direcci�n',
		tag_h1		: 'Encabezado 1',
		tag_h2		: 'Encabezado 2',
		tag_h3		: 'Encabezado 3',
		tag_h4		: 'Encabezado 4',
		tag_h5		: 'Encabezado 5',
		tag_h6		: 'Encabezado 6',
		tag_div		: 'Normal (DIV)'
	},

	div :
	{
		title				: 'Crear contenedor DIV',
		toolbar				: 'Crear contenedor DIV',
		cssClassInputLabel	: 'Clase de hoja de estilos',
		styleSelectLabel	: 'Estilo',
		IdInputLabel		: 'Id',
		languageCodeInputLabel	: ' Codigo de idioma',
		inlineStyleInputLabel	: 'Estilo',
		advisoryTitleInputLabel	: 'T�tulo',
		langDirLabel		: 'Orientaci�n',
		langDirLTRLabel		: 'Izquierda a Derecha (LTR)',
		langDirRTLLabel		: 'Derecha a Izquierda (RTL)',
		edit				: 'Editar Div',
		remove				: 'Quitar Div'
  	},

	iframe :
	{
		title		: 'Propiedades de iframe',
		toolbar		: 'IFrame',
		noUrl		: 'Por favor, escriba la direcci�n del iframe',
		scrolling	: 'Activar barras de desplazamiento',
		border		: 'Mostrar borde del marco'
	},

	font :
	{
		label		: 'Fuente',
		voiceLabel	: 'Fuente',
		panelTitle	: 'Fuente'
	},

	fontSize :
	{
		label		: 'Tama�o',
		voiceLabel	: 'Tama�o de fuente',
		panelTitle	: 'Tama�o'
	},

	colorButton :
	{
		textColorTitle	: 'Color de Texto',
		bgColorTitle	: 'Color de Fondo',
		panelTitle		: 'Colores',
		auto			: 'Autom�tico',
		more			: 'M�s Colores...'
	},

	colors :
	{
		'000' : 'Negro',
		'800000' : 'Marr�n oscuro',
		'8B4513' : 'Marr�n tierra',
		'2F4F4F' : 'Pizarra Oscuro',
		'008080' : 'Azul verdoso',
		'000080' : 'Azul marino',
		'4B0082' : 'A�il',
		'696969' : 'Gris oscuro',
		'B22222' : 'Ladrillo',
		'A52A2A' : 'Marr�n',
		'DAA520' : 'Oro oscuro',
		'006400' : 'Verde oscuro',
		'40E0D0' : 'Turquesa',
		'0000CD' : 'Azul medio-oscuro',
		'800080' : 'P�rpura',
		'808080' : 'Gris',
		'F00' : 'Rojo',
		'FF8C00' : 'Naranja oscuro',
		'FFD700' : 'Oro',
		'008000' : 'Verde',
		'0FF' : 'Cian',
		'00F' : 'Azul',
		'EE82EE' : 'Violeta',
		'A9A9A9' : 'Gris medio',
		'FFA07A' : 'Salm�n claro',
		'FFA500' : 'Naranja',
		'FFFF00' : 'Amarillo',
		'00FF00' : 'Lima',
		'AFEEEE' : 'Turquesa claro',
		'ADD8E6' : 'Azul claro',
		'DDA0DD' : 'Violeta claro',
		'D3D3D3' : 'Gris claro',
		'FFF0F5' : 'Lavanda rojizo',
		'FAEBD7' : 'Blanco antiguo',
		'FFFFE0' : 'Amarillo claro',
		'F0FFF0' : 'Miel',
		'F0FFFF' : 'Azul celeste',
		'F0F8FF' : 'Azul p�lido',
		'E6E6FA' : 'Lavanda',
		'FFF' : 'Blanco'
	},

	scayt :
	{
		title			: 'Comprobar Ortograf�a Mientras Escribe',
		opera_title		: 'No soportado en Opera',
		enable			: 'Activar Corrector',
		disable			: 'Desactivar Corrector',
		about			: 'Acerca de Corrector',
		toggle			: 'Cambiar Corrector',
		options			: 'Opciones',
		langs			: 'Idiomas',
		moreSuggestions	: 'M�s sugerencias',
		ignore			: 'Ignorar',
		ignoreAll		: 'Ignorar Todas',
		addWord			: 'A�adir palabra',
		emptyDic		: 'El nombre del diccionario no puede estar en blanco.',

		optionsTab		: 'Opciones',
		allCaps			: 'Omitir palabras en MAY�SCULAS',
		ignoreDomainNames : 'Omitir nombres de dominio',
		mixedCase		: 'Ignorar palabras con combinaci�n de may�sculas y min�sculas',
		mixedWithDigits	: 'Omitir palabras con n�meros',

		languagesTab	: 'Idiomas',

		dictionariesTab	: 'Diccionarios',
		dic_field_name	: 'Nombre del diccionario',
		dic_create		: 'Crear',
		dic_restore		: 'Recuperar',
		dic_delete		: 'Borrar',
		dic_rename		: 'Renombrar',
		dic_info		: 'Inicialmente el Diccionario de usuario se guarda en una Cookie. Sin embargo, las cookies est�n limitadas en tama�o. Cuando el diccionario crece a un punto en el que no se puede guardar en una Cookie, el diccionario puede ser almacenado en nuestro servidor. Para almacenar su diccionario personalizado en nuestro servidor debe especificar un nombre para su diccionario. Si ya ha guardado un diccionaro, por favor, escriba su nombre y pulse el bot�n Recuperar',

		aboutTab		: 'Acerca de'
	},

	about :
	{
		title		: 'Acerca de CKEditor',
		dlgTitle	: 'Acerca de CKEditor',
		help	: 'Lea la  $1 para resolver sus dudas.',
		userGuide : 'Gu�a de usuario de CKEditor',
		moreInfo	: 'Para informaci�n de licencia, por favor visite nuestro sitio web:',
		copy		: 'Copyright &copy; $1. Todos los derechos reservados.'
	},

	maximize : 'Maximizar',
	minimize : 'Minimizar',

	fakeobjects :
	{
		anchor		: 'Ancla',
		flash		: 'Animaci�n flash',
		iframe		: 'IFrame',
		hiddenfield	: 'Campo oculto',
		unknown		: 'Objeto desconocido'
	},

	resize : 'Arrastre para redimensionar',

	colordialog :
	{
		title		: 'Elegir color',
		options	:	'Opciones de colores',
		highlight	: 'Muestra',
		selected	: 'Elegido',
		clear		: 'Borrar'
	},

	toolbarCollapse	: 'Contraer barra de herramientas',
	toolbarExpand	: 'Expandir barra de herramientas',

	toolbarGroups :
	{
		document : 'Documento',
		clipboard : 'Portapapeles/Deshacer',
		editing : 'Edici�n',
		forms : 'Formularios',
		basicstyles : 'Estilos b�sicos',
		paragraph : 'P�rrafo',
		links : 'Enlaces',
		insert : 'Insertar',
		styles : 'Estilos',
		colors : 'Colores',
		tools : 'Herramientas'
	},

	bidi :
	{
		ltr : 'Direcci�n del texto de izquierda a derecha',
		rtl : 'Direcci�n del texto de derecha a izquierda'
	},

	docprops :
	{
		label : 'Propiedades del documento',
		title : 'Propiedades del documento',
		design : 'Dise�o',
		meta : 'Meta Tags',
		chooseColor : 'Elegir',
		other : 'Otro...',
		docTitle :	'T�tulo de p�gina',
		charset : 	'Codificaci�n de caracteres',
		charsetOther : 'Otra codificaci�n de caracteres',
		charsetASCII : 'ASCII',
		charsetCE : 'Centro Europeo',
		charsetCT : 'Chino Tradicional (Big5)',
		charsetCR : 'Ruso',
		charsetGR : 'Griego',
		charsetJP : 'Japon�s',
		charsetKR : 'Koreano',
		charsetTR : 'Turco',
		charsetUN : 'Unicode (UTF-8)',
		charsetWE : 'Europeo occidental',
		docType : 'Tipo de documento',
		docTypeOther : 'Otro tipo de documento',
		xhtmlDec : 'Incluir declaraci�n XHTML',
		bgColor : 'Color de fondo',
		bgImage : 'Imagen de fondo',
		bgFixed : 'Fondo fijo (no se desplaza)',
		txtColor : 'Color del texto',
		margin : 'M�rgenes',
		marginTop : 'Superior',
		marginLeft : 'Izquierdo',
		marginRight : 'Derecho',
		marginBottom : 'Inferior',
		metaKeywords : 'Palabras claves del documento separadas por coma (meta keywords)',
		metaDescription : 'Descripci�n del documento',
		metaAuthor : 'Autor',
		metaCopyright : 'Copyright',
		previewHtml : '<p>Este es un <strong>texto de ejemplo</strong>. Usted est� usando <a href="javascript:void(0)">CKEditor</a>.</p>'
	}
};
