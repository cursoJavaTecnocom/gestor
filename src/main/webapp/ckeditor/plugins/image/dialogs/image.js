 /*
Copyright (c) 2003-2010, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
*/

(function(){var a=1,b=2,c=4,d=8,e=/^\s*(\d+)((px)|\%)?\s*$/i,f=/(^\s*(\d+)((px)|\%)?\s*$)|^$/i,g=/^\d+px$/,h=function(){var q=this.getValue(),r=this.getDialog(),s=q.match(e);if(s){if(s[2]=='%')m(r,false);q=s[1];}if(r.lockRatio){var t=r.originalElement;if(t.getCustomData('isReady')=='true')if(this.id=='txtHeight'){if(q&&q!='0')q=Math.round(t.$.width*(q/t.$.height));if(!isNaN(q))r.setValueOf('info','txtWidth',q);}else{if(q&&q!='0')q=Math.round(t.$.height*(q/t.$.width));if(!isNaN(q))r.setValueOf('info','txtHeight',q);}}i(r);},i=function(q){if(!q.originalElement||!q.preview)return 1;q.commitContent(c,q.preview);return 0;};function j(){var q=arguments,r=this.getContentElement('advanced','txtdlgGenStyle');r&&r.commit.apply(r,q);this.foreach(function(s){if(s.commit&&s.id!='txtdlgGenStyle')s.commit.apply(s,q);});};var k;function l(q){if(k)return;k=1;var r=this.getDialog(),s=r.imageElement;if(s){this.commit(a,s);q=[].concat(q);var t=q.length,u;for(var v=0;v<t;v++){u=r.getContentElement.apply(r,q[v].split(':'));u&&u.setup(a,s);}}k=0;};var m=function(q,r){var s=q.originalElement,t=CKEDITOR.document.getById('btnLockSizes');if(s.getCustomData('isReady')=='true'){if(r=='check'){var u=q.getValueOf('info','txtWidth'),v=q.getValueOf('info','txtHeight'),w=s.$.width*1000/s.$.height,x=u*1000/v;q.lockRatio=false;if(!u&&!v)q.lockRatio=true;else if(!isNaN(w)&&!isNaN(x))if(Math.round(w)==Math.round(x))q.lockRatio=true;}else if(r!=undefined)q.lockRatio=r;else q.lockRatio=!q.lockRatio;}else if(r!='check')q.lockRatio=false;if(q.lockRatio)t.removeClass('cke_btn_unlocked');else t.addClass('cke_btn_unlocked');var y=q._.editor.lang.image,z=y[q.lockRatio?'unlockRatio':'lockRatio'];t.setAttribute('title',z);t.getFirst().setText(z);return q.lockRatio;},n=function(q){var r=q.originalElement;if(r.getCustomData('isReady')=='true'){q.setValueOf('info','txtWidth',r.$.width);q.setValueOf('info','txtHeight',r.$.height);}i(q);},o=function(q,r){if(q!=a)return;function s(x,y){var z=x.match(e);if(z){if(z[2]=='%'){z[1]+='%';m(t,false);}return z[1];}return y;};var t=this.getDialog(),u='',v=this.id=='txtWidth'?'width':'height',w=r.getAttribute(v);if(w)u=s(w,u);u=s(r.getStyle(v),u);this.setValue(u);},p=function(q,r){var s,t=function(){var v=this.originalElement;v.setCustomData('isReady','true');v.removeListener('load',t);v.removeListener('error',u);v.removeListener('abort',u);CKEDITOR.document.getById('ImagePreviewLoader').setStyle('display','none');if(!this.dontResetSize)n(this);if(this.firstLoad)CKEDITOR.tools.setTimeout(function(){m(this,'check');
},0,this);this.firstLoad=false;this.dontResetSize=false;},u=function(){var x=this;var v=x.originalElement;v.removeListener('load',t);v.removeListener('error',u);v.removeListener('abort',u);var w=CKEDITOR.getUrl(q.skinPath+'images/noimage.png');if(x.preview)x.preview.setAttribute('src',w);CKEDITOR.document.getById('ImagePreviewLoader').setStyle('display','none');m(x,false);};return{title:r=='image'?q.lang.image.title:q.lang.image.titleButton,minWidth:420,minHeight:310,onShow:function(){var B=this;B.imageElement=false;B.linkElement=false;B.imageEditMode=false;B.linkEditMode=false;B.lockRatio=true;B.dontResetSize=false;B.firstLoad=true;B.addLink=false;var v=B.getParentEditor(),w=B.getParentEditor().getSelection(),x=w.getSelectedElement(),y=x&&x.getAscendant('a');CKEDITOR.document.getById('ImagePreviewLoader').setStyle('display','none');s=new CKEDITOR.dom.element('img',v.document);B.preview=CKEDITOR.document.getById('previewImage');B.originalElement=v.document.createElement('img');B.originalElement.setAttribute('alt','');B.originalElement.setCustomData('isReady','false');if(y){B.linkElement=y;B.linkEditMode=true;var z=y.getChildren();if(z.count()==1){var A=z.getItem(0).getName();if(A=='img'||A=='input'){B.imageElement=z.getItem(0);if(B.imageElement.getName()=='img')B.imageEditMode='img';else if(B.imageElement.getName()=='input')B.imageEditMode='input';}}if(r=='image')B.setupContent(b,y);}if(x&&x.getName()=='img'&&!x.getAttribute('_cke_realelement')||x&&x.getName()=='input'&&x.getAttribute('type')=='image'){B.imageEditMode=x.getName();B.imageElement=x;}if(B.imageEditMode){B.cleanImageElement=B.imageElement;B.imageElement=B.cleanImageElement.clone(true,true);B.setupContent(a,B.imageElement);m(B,true);}else B.imageElement=v.document.createElement('img');if(!CKEDITOR.tools.trim(B.getValueOf('info','txtUrl'))){B.preview.removeAttribute('src');B.preview.setStyle('display','none');}},onOk:function(){var w=this;if(w.imageEditMode){var v=w.imageEditMode;if(r=='image'&&v=='input'&&confirm(q.lang.image.button2Img)){v='img';w.imageElement=q.document.createElement('img');w.imageElement.setAttribute('alt','');q.insertElement(w.imageElement);}else if(r!='image'&&v=='img'&&confirm(q.lang.image.img2Button)){v='input';w.imageElement=q.document.createElement('input');w.imageElement.setAttributes({type:'image',alt:''});q.insertElement(w.imageElement);}else{w.imageElement=w.cleanImageElement;delete w.cleanImageElement;}}else{if(r=='image')w.imageElement=q.document.createElement('img');
else{w.imageElement=q.document.createElement('input');w.imageElement.setAttribute('type','image');}w.imageElement.setAttribute('alt','');}if(!w.linkEditMode)w.linkElement=q.document.createElement('a');w.commitContent(a,w.imageElement);w.commitContent(b,w.linkElement);if(!w.imageElement.getAttribute('style'))w.imageElement.removeAttribute('style');if(!w.imageEditMode){if(w.addLink){if(!w.linkEditMode){q.insertElement(w.linkElement);w.linkElement.append(w.imageElement,false);}else q.insertElement(w.imageElement);}else q.insertElement(w.imageElement);}else if(!w.linkEditMode&&w.addLink){q.insertElement(w.linkElement);w.imageElement.appendTo(w.linkElement);}else if(w.linkEditMode&&!w.addLink){q.getSelection().selectElement(w.linkElement);q.insertElement(w.imageElement);}},onLoad:function(){var w=this;if(r!='image')w.hidePage('Link');var v=w._.element.getDocument();w.addFocusable(v.getById('btnResetSize'),5);w.addFocusable(v.getById('btnLockSizes'),5);w.commitContent=j;},onHide:function(){var v=this;if(v.preview)v.commitContent(d,v.preview);if(v.originalElement){v.originalElement.removeListener('load',t);v.originalElement.removeListener('error',u);v.originalElement.removeListener('abort',u);v.originalElement.remove();v.originalElement=false;}delete v.imageElement;},contents:[{id:'info',label:q.lang.image.infoTab,accessKey:'I',elements:[{type:'vbox',padding:0,children:[{type:'hbox',widths:['280px','110px'],align:'right',children:[{id:'txtUrl',type:'text',label:q.lang.common.url,required:true,onChange:function(){var v=this.getDialog(),w=this.getValue();if(w.length>0){v=this.getDialog();var x=v.originalElement;v.preview.removeStyle('display');x.setCustomData('isReady','false');var y=CKEDITOR.document.getById('ImagePreviewLoader');if(y)y.setStyle('display','');x.on('load',t,v);x.on('error',u,v);x.on('abort',u,v);x.setAttribute('src',w);s.setAttribute('src',w);v.preview.setAttribute('src',s.$.src);i(v);}else if(v.preview){v.preview.removeAttribute('src');v.preview.setStyle('display','none');}},setup:function(v,w){if(v==a){var x=w.getAttribute('_cke_saved_src')||w.getAttribute('src'),y=this;this.getDialog().dontResetSize=true;y.setValue(x);y.setInitValue();y.focus();}},commit:function(v,w){var x=this;if(v==a&&(x.getValue()||x.isChanged())){w.setAttribute('_cke_saved_src',decodeURI(x.getValue()));w.setAttribute('src',decodeURI(x.getValue()));}else if(v==d){w.setAttribute('src','');w.removeAttribute('src');}},validate:CKEDITOR.dialog.validate.notEmpty(q.lang.image.urlMissing)},{type:'button',id:'browse',style:'display:inline-block;margin-top:10px;',align:'center',label:q.lang.common.browseServer,hidden:true,filebrowser:'info:txtUrl'}]}]},{id:'txtAlt',type:'text',label:q.lang.image.alt,accessKey:'A','default':'',onChange:function(){i(this.getDialog());
},setup:function(v,w){if(v==a)this.setValue(w.getAttribute('alt'));},commit:function(v,w){var x=this;if(v==a){if(x.getValue()||x.isChanged())w.setAttribute('alt',x.getValue());}else if(v==c)w.setAttribute('alt',x.getValue());else if(v==d)w.removeAttribute('alt');}},{type:'hbox',widths:['140px','240px'],children:[{type:'vbox',padding:10,children:[{type:'hbox',widths:['70%','30%'],children:[{type:'vbox',padding:1,children:[{type:'text',width:'40px',id:'txtWidth',labelLayout:'horizontal',label:q.lang.image.width,onKeyUp:h,onChange:function(){l.call(this,'advanced:txtdlgGenStyle');},validate:function(){var v=this.getValue().match(f);if(!v)alert(q.lang.image.validateWidth);return!!v;},setup:o,commit:function(v,w,x){var y=this.getValue();if(v==a){if(y)w.setStyle('width',CKEDITOR.tools.cssLength(y));else if(!y&&this.isChanged())w.removeStyle('width');!x&&w.removeAttribute('width');}else if(v==c){var z=y.match(e);if(!z){var A=this.getDialog().originalElement;if(A.getCustomData('isReady')=='true')w.setStyle('width',A.$.width+'px');}else w.setStyle('width',y+'px');}else if(v==d){w.removeAttribute('width');w.removeStyle('width');}}},{type:'text',id:'txtHeight',width:'40px',labelLayout:'horizontal',label:q.lang.image.height,onKeyUp:h,onChange:function(){l.call(this,'advanced:txtdlgGenStyle');},validate:function(){var v=this.getValue().match(f);if(!v)alert(q.lang.image.validateHeight);return!!v;},setup:o,commit:function(v,w,x){var y=this.getValue();if(v==a){if(y)w.setStyle('height',CKEDITOR.tools.cssLength(y));else if(!y&&this.isChanged())w.removeStyle('height');if(!x&&v==a)w.removeAttribute('height');}else if(v==c){var z=y.match(e);if(!z){var A=this.getDialog().originalElement;if(A.getCustomData('isReady')=='true')w.setStyle('height',A.$.height+'px');}else w.setStyle('height',y+'px');}else if(v==d){w.removeAttribute('height');w.removeStyle('height');}}}]},{type:'html',style:'margin-top:10px;width:40px;height:40px;',onLoad:function(){var v=CKEDITOR.document.getById('btnResetSize'),w=CKEDITOR.document.getById('btnLockSizes');if(v){v.on('click',function(x){n(this);x.data.preventDefault();},this.getDialog());v.on('mouseover',function(){this.addClass('cke_btn_over');},v);v.on('mouseout',function(){this.removeClass('cke_btn_over');},v);}if(w){w.on('click',function(x){var C=this;var y=m(C),z=C.originalElement,A=C.getValueOf('info','txtWidth');if(z.getCustomData('isReady')=='true'&&A){var B=z.$.height/z.$.width*A;if(!isNaN(B)){C.setValueOf('info','txtHeight',Math.round(B));i(C);
}}x.data.preventDefault();},this.getDialog());w.on('mouseover',function(){this.addClass('cke_btn_over');},w);w.on('mouseout',function(){this.removeClass('cke_btn_over');},w);}},html:'<div><a href="javascript:void(0)" tabindex="-1" title="'+q.lang.image.unlockRatio+'" class="cke_btn_locked" id="btnLockSizes" role="button"><span class="cke_label">'+q.lang.image.unlockRatio+'</span></a>'+'<a href="javascript:void(0)" tabindex="-1" title="'+q.lang.image.resetSize+'" class="cke_btn_reset" id="btnResetSize" role="button"><span class="cke_label">'+q.lang.image.resetSize+'</span></a>'+'</div>'}]},{type:'vbox',padding:1,children:[{type:'text',id:'txtBorder',width:'60px',labelLayout:'horizontal',label:q.lang.image.border,'default':'',onKeyUp:function(){i(this.getDialog());},onChange:function(){l.call(this,'advanced:txtdlgGenStyle');},validate:CKEDITOR.dialog.validate.integer(q.lang.image.validateBorder),setup:function(v,w){if(v==a){var x,y=w.getStyle('border-width');y=y&&y.match(/^(\d+px)(?: \1 \1 \1)?$/);x=y&&parseInt(y[1],10);isNaN(parseInt(x,10))&&(x=w.getAttribute('border'));this.setValue(x);}},commit:function(v,w,x){var y=parseInt(this.getValue(),10);if(v==a||v==c){if(!isNaN(y)){w.setStyle('border-width',CKEDITOR.tools.cssLength(y));w.setStyle('border-style','solid');}else if(!y&&this.isChanged()){w.removeStyle('border-width');w.removeStyle('border-style');w.removeStyle('border-color');}if(!x&&v==a)w.removeAttribute('border');}else if(v==d){w.removeAttribute('border');w.removeStyle('border-width');w.removeStyle('border-style');w.removeStyle('border-color');}}},{type:'text',id:'txtHSpace',width:'60px',labelLayout:'horizontal',label:q.lang.image.hSpace,'default':'',onKeyUp:function(){i(this.getDialog());},onChange:function(){l.call(this,'advanced:txtdlgGenStyle');},validate:CKEDITOR.dialog.validate.integer(q.lang.image.validateHSpace),setup:function(v,w){if(v==a){var x,y,z,A=w.getStyle('margin-left'),B=w.getStyle('margin-right');A=A&&A.match(g);B=B&&B.match(g);y=parseInt(A,10);z=parseInt(B,10);x=y==z&&y;isNaN(parseInt(x,10))&&(x=w.getAttribute('hspace'));this.setValue(x);}},commit:function(v,w,x){var y=parseInt(this.getValue(),10);if(v==a||v==c){if(!isNaN(y)){w.setStyle('margin-left',CKEDITOR.tools.cssLength(y));w.setStyle('margin-right',CKEDITOR.tools.cssLength(y));}else if(!y&&this.isChanged()){w.removeStyle('margin-left');w.removeStyle('margin-right');}if(!x&&v==a)w.removeAttribute('hspace');}else if(v==d){w.removeAttribute('hspace');w.removeStyle('margin-left');
w.removeStyle('margin-right');}}},{type:'text',id:'txtVSpace',width:'60px',labelLayout:'horizontal',label:q.lang.image.vSpace,'default':'',onKeyUp:function(){i(this.getDialog());},onChange:function(){l.call(this,'advanced:txtdlgGenStyle');},validate:CKEDITOR.dialog.validate.integer(q.lang.image.validateVSpace),setup:function(v,w){if(v==a){var x,y,z,A=w.getStyle('margin-top'),B=w.getStyle('margin-bottom');A=A&&A.match(g);B=B&&B.match(g);y=parseInt(A,10);z=parseInt(B,10);x=y==z&&y;isNaN(parseInt(x,10))&&(x=w.getAttribute('vspace'));this.setValue(x);}},commit:function(v,w,x){var y=parseInt(this.getValue(),10);if(v==a||v==c){if(!isNaN(y)){w.setStyle('margin-top',CKEDITOR.tools.cssLength(y));w.setStyle('margin-bottom',CKEDITOR.tools.cssLength(y));}else if(!y&&this.isChanged()){w.removeStyle('margin-top');w.removeStyle('margin-bottom');}if(!x&&v==a)w.removeAttribute('vspace');}else if(v==d){w.removeAttribute('vspace');w.removeStyle('margin-top');w.removeStyle('margin-bottom');}}},{id:'cmbAlign',type:'select',labelLayout:'horizontal',widths:['35%','65%'],style:'width:90px',label:q.lang.image.align,'default':'',items:[[q.lang.common.notSet,''],[q.lang.image.alignLeft,'left'],[q.lang.image.alignRight,'right']],onChange:function(){i(this.getDialog());l.call(this,'advanced:txtdlgGenStyle');},setup:function(v,w){if(v==a){var x=w.getStyle('float');switch(x){case 'inherit':case 'none':x='';}!x&&(x=(w.getAttribute('align')||'').toLowerCase());this.setValue(x);}},commit:function(v,w,x){var y=this.getValue();if(v==a||v==c){if(y)w.setStyle('float',y);else w.removeStyle('float');if(!x&&v==a){y=(w.getAttribute('align')||'').toLowerCase();switch(y){case 'left':case 'right':w.removeAttribute('align');}}}else if(v==d)w.removeStyle('float');}}]}]},{type:'vbox',height:'250px',children:[{type:'html',style:'width:95%;',html:'<div>'+CKEDITOR.tools.htmlEncode(q.lang.common.preview)+'<br>'+'<div id="ImagePreviewLoader" style="display:none"><div class="loading">&nbsp;</div></div>'+'<div id="ImagePreviewBox"><table><tr><td>'+'<a href="javascript:void(0)" target="_blank" onclick="return false;" id="previewLink">'+'<img id="previewImage" alt="" /></a>'+(q.config.image_previewText||'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas feugiat consequat diam. Maecenas metus. Vivamus diam purus, cursus a, commodo non, facilisis vitae, nulla. Aenean dictum lacinia tortor. Nunc iaculis, nibh non iaculis aliquam, orci felis euismod neque, sed ornare massa mauris sed velit. Nulla pretium mi et risus. Fusce mi pede, tempor id, cursus ac, ullamcorper nec, enim. Sed tortor. Curabitur molestie. Duis velit augue, condimentum at, ultrices a, luctus ut, orci. Donec pellentesque egestas eros. Integer cursus, augue in cursus faucibus, eros pede bibendum sem, in tempus tellus justo quis ligula. Etiam eget tortor. Vestibulum rutrum, est ut placerat elementum, lectus nisl aliquam velit, tempor aliquam eros nunc nonummy metus. In eros metus, gravida a, gravida sed, lobortis id, turpis. Ut ultrices, ipsum at venenatis fringilla, sem nulla lacinia tellus, eget aliquet turpis mauris non enim. Nam turpis. Suspendisse lacinia. Curabitur ac tortor ut ipsum egestas elementum. Nunc imperdiet gravida mauris.')+'</td></tr></table></div></div>'}]}]}]},{id:'Link',label:q.lang.link.title,padding:0,elements:[{id:'txtUrl',type:'text',label:q.lang.common.url,style:'width: 100%','default':'',setup:function(v,w){if(v==b){var x=w.getAttribute('_cke_saved_href');
if(!x)x=w.getAttribute('href');this.setValue(x);}},commit:function(v,w){var x=this;if(v==b)if(x.getValue()||x.isChanged()){w.setAttribute('_cke_saved_href',decodeURI(x.getValue()));w.setAttribute('href','javascript:void(0)/*'+CKEDITOR.tools.getNextNumber()+'*/');if(x.getValue()||!q.config.image_removeLinkByEmptyURL)x.getDialog().addLink=true;}}},{type:'button',id:'browse',filebrowser:{action:'Browse',target:'Link:txtUrl',url:q.config.filebrowserImageBrowseLinkUrl||q.config.filebrowserBrowseUrl},style:'float:right',hidden:true,label:q.lang.common.browseServer},{id:'cmbTarget',type:'select',label:q.lang.common.target,'default':'',items:[[q.lang.common.notSet,''],[q.lang.common.targetNew,'_blank'],[q.lang.common.targetTop,'_top'],[q.lang.common.targetSelf,'_self'],[q.lang.common.targetParent,'_parent']],setup:function(v,w){if(v==b)this.setValue(w.getAttribute('target'));},commit:function(v,w){if(v==b)if(this.getValue()||this.isChanged())w.setAttribute('target',this.getValue());}}]},{id:'Upload',hidden:true,filebrowser:'uploadButton',label:q.lang.image.upload,elements:[{type:'file',id:'upload',label:q.lang.image.btnUpload,style:'height:40px',size:38},{type:'fileButton',id:'uploadButton',filebrowser:'info:txtUrl',label:q.lang.image.btnUpload,'for':['Upload','upload']}]},{id:'advanced',label:q.lang.common.advancedTab,elements:[{type:'hbox',widths:['50%','25%','25%'],children:[{type:'text',id:'linkId',label:q.lang.common.id,setup:function(v,w){if(v==a)this.setValue(w.getAttribute('id'));},commit:function(v,w){if(v==a)if(this.getValue()||this.isChanged())w.setAttribute('id',this.getValue());}},{id:'cmbLangDir',type:'select',style:'width : 100px;',label:q.lang.common.langDir,'default':'',items:[[q.lang.common.notSet,''],[q.lang.common.langDirLtr,'ltr'],[q.lang.common.langDirRtl,'rtl']],setup:function(v,w){if(v==a)this.setValue(w.getAttribute('dir'));},commit:function(v,w){if(v==a)if(this.getValue()||this.isChanged())w.setAttribute('dir',this.getValue());}},{type:'text',id:'txtLangCode',label:q.lang.common.langCode,'default':'',setup:function(v,w){if(v==a)this.setValue(w.getAttribute('lang'));},commit:function(v,w){if(v==a)if(this.getValue()||this.isChanged())w.setAttribute('lang',this.getValue());}}]},{type:'text',id:'txtGenLongDescr',label:q.lang.common.longDescr,setup:function(v,w){if(v==a)this.setValue(w.getAttribute('longDesc'));},commit:function(v,w){if(v==a)if(this.getValue()||this.isChanged())w.setAttribute('longDesc',this.getValue());}},{type:'hbox',widths:['50%','50%'],children:[{type:'text',id:'txtGenClass',label:q.lang.common.cssClass,'default':'',setup:function(v,w){if(v==a)this.setValue(w.getAttribute('class'));
},commit:function(v,w){if(v==a)if(this.getValue()||this.isChanged())w.setAttribute('class',this.getValue());}},{type:'text',id:'txtGenTitle',label:q.lang.common.advisoryTitle,'default':'',onChange:function(){i(this.getDialog());},setup:function(v,w){if(v==a)this.setValue(w.getAttribute('title'));},commit:function(v,w){var x=this;if(v==a){if(x.getValue()||x.isChanged())w.setAttribute('title',x.getValue());}else if(v==c)w.setAttribute('title',x.getValue());else if(v==d)w.removeAttribute('title');}}]},{type:'text',id:'txtdlgGenStyle',label:q.lang.common.cssStyle,'default':'',setup:function(v,w){if(v==a){var x=w.getAttribute('style');if(!x&&w.$.style.cssText)x=w.$.style.cssText;this.setValue(x);var y=w.$.style.height,z=w.$.style.width,A=(y?y:'').match(e),B=(z?z:'').match(e);this.attributesInStyle={height:!!A,width:!!B};}},onChange:function(){l.call(this,['info:cmbFloat','info:cmbAlign','info:txtVSpace','info:txtHSpace','info:txtBorder','info:txtWidth','info:txtHeight']);i(this);},commit:function(v,w){if(v==a&&(this.getValue()||this.isChanged()))w.setAttribute('style',this.getValue());}}]}]};};CKEDITOR.dialog.add('image',function(q){return p(q,'image');});CKEDITOR.dialog.add('imagebutton',function(q){return p(q,'imagebutton');});})();