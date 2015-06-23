
<%@taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<html>

    <head>
        <link rel="icon" href="images/favicon.ico" type="image/x-icon">
        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
        <link rel="stylesheet" type="text/css" media="screen" href="css/style.css">
        <link rel="stylesheet" href="css/camera.css" type="text/css" media="screen">
        <link rel="stylesheet" type="text/css" media="screen" href="css/tabs-min.css">
        <link rel="stylesheet" type="text/css" media="screen" href="css/estilos.css">
        <link rel="stylesheet" type="text/css" media="screen" href="css/ui.css">

        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/superfish.js"></script>
        <script type="text/javascript" src="js/jquery.responsivemenu.js"></script>
        <script type="text/javascript" src="js/jquery.mobilemenu.js"></script>
        <script type="text/javascript" src="js/jquery.easing.1.3.js"></script>

        <script src="js/script.js"></script>
        <script type="text/javascript" src="js/camera.js"></script>
        <script src="js/jquery.tabs.min.js"></script>
        <!--[if (gt IE 9)|!(IE)]><!-->
        <script type="text/javascript" src="js/jquery.mobile.customized.min.js"></script>
        <!--<![endif]-->
        <script>
            $(document).ready(function() {
                jQuery('.camera_wrap').camera();
            });
        </script>

    </head>
    <body>     
                  <style type="text/css">
                .campo { float:left; width:110px;}
                .valor { float:left; }
                .valor input { width:400px; }
                .clear { clear:both; height:10px; }
                .editor { margin-left:20px; }
                .comando { float:right; margin-left:20px; }
                input { background-color:#F8F8F8; border:1px solid #E0E0E0; }
                #cont_seo_descripcion { width:620px; height:50px; background-color:#F8F8F8; border:1px solid #E0E0E0; }
            </style>

            <div class="contenido">


                <textarea cols="80" id="contenido" name="contenido" rows="800" >
                    </textarea>


               



            </div>

              <script type="text/javascript" src="share/js/ui-sortable.js"></script>
        <script type="text/javascript">
            iniInputFilePreview('cont_imagen');

            function JS_cambiarSeccion(iValue)
            {
                aVals = iValue.split('|');
                if (aVals[0].length == 0 || iValue == -1)
                {
                    $('#cont_tipo_menu').parent().hide();
                    if ($('#cont_grupo').val() == 0) {
                        $('#cont_tipo_menu').attr('disabled', '');
                    }
                }
                else
                {
                    if ($('#cont_grupo').val() > 0) {
                        $('#cont_tipo_menu').attr('disabled', 'disabled').parent().hide();
                    } else {
                        $('#cont_tipo_menu').attr('disabled', '').parent().show();
                    }
                    if (aVals.length > 0 && aVals[1].length > 0) {
                        $('#cont_tipo_menu').val(aVals[1]).trigger('change');
                        $('#cont_tipo_menu').attr('disabled', 'disabled');
                    }
                }
            }

            function JS_habilitarSeccion(iValue) {
                if (iValue > 0) {
                    $('#cont_tipo_menu').attr('disabled', 'disabled').parent().hide();
                }
                JS_cambiarSeccion($('#cont_padre').val());
            }

            function JS_setContent()
            {
                $('#cont_pagina').val(tinyMCE.get('cont_pagina').getContent());
            }

            menuContenidoTinyMCE("cont_pagina", 690);

            function JS_actualizaPermalink(sTitulo)
            {
                var sPermalink = sTitulo.toLowerCase();
                sPermalink = sPermalink.replace(/[ä]/g, 'ae');
                sPermalink = sPermalink.replace(/[áàäâå]/g, 'a');
                sPermalink = sPermalink.replace(/[éèëê]/g, 'e');
                sPermalink = sPermalink.replace(/[íìïî]/g, 'i');
                sPermalink = sPermalink.replace(/[ö]/g, 'oe');
                sPermalink = sPermalink.replace(/[óòöô]/g, 'o');
                sPermalink = sPermalink.replace(/[ü]/g, 'ue');
                sPermalink = sPermalink.replace(/[úùüû]/g, 'u');
                sPermalink = sPermalink.replace(/[ß]/g, 'ss');
                sPermalink = sPermalink.replace(/[ýÿ]/g, 'y');
                sPermalink = sPermalink.replace(/[ñ]/g, 'n');
                sPermalink = sPermalink.replace(/[ç]/g, 'c');
                sPermalink = sPermalink.replace(/['"]/g, '');
                sPermalink = sPermalink.replace(/[^a-zA-Z0-9-]/g, ' '); //sPermalink = sPermalink.replace(/\W/g, ' ');
                sPermalink = sPermalink.replace(/\s+/g, '-');
                sPermalink = sPermalink.replace(/(_)$/g, '');
                sPermalink = sPermalink.replace(/^(_)/g, '');
                $('#cont_permalink').val(sPermalink);
            }

            function cargarSelects() {
                if (!($.browser.msie && $.browser.version == "6.0")) {
                    $('.select-estilo').css('filter', 'alpha(opacity=0)');
                    $('.select-estilo').css('opacity', '0');
                    $('.select-estilo').change(function() {
                        var opcion = $(this).children(":selected").text();
                        $(this).parent().children('.span-estilo').text(opcion);
                    });
                    /* que ponga automáticamente el texto del que este seleccionado */
                    $('.span-estilo').each(
                            function() {
                                $(this).text($(this).parent().children('.select-estilo').children(':selected').text())
                            }
                    );
                }
            }
            function JS_elimiarImagen()
            {
                $('#agregarimagen').attr('src', 'http://azulymas.com/administrador/share/img/add_imagen.gif');
                $('#cont_deleteimagen').val(1);
                $('#eliminar-imagen').remove();
            }


        </script>
  
    <ckeditor:replace replace="contenido" basePath="ckeditor/"/>

</body>
</html>  