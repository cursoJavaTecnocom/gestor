(function(e) {
    var d = e.DOM, b = e.dom.Event, h = e.extend, f = e.each, a = e.util.Cookie, g, c = e.explode;
    e.ThemeManager.requireLangPack("advanced");
    e.create("tinymce.themes.AdvancedTheme", {sizes: [8, 10, 12, 14, 18, 24, 36], controls: {bold: ["bold_desc", "Bold"], italic: ["italic_desc", "Italic"], underline: ["underline_desc", "Underline"], strikethrough: ["striketrough_desc", "Strikethrough"], justifyleft: ["justifyleft_desc", "JustifyLeft"], justifycenter: ["justifycenter_desc", "JustifyCenter"], justifyright: ["justifyright_desc", "JustifyRight"], justifyfull: ["justifyfull_desc", "JustifyFull"], bullist: ["bullist_desc", "InsertUnorderedList"], numlist: ["numlist_desc", "InsertOrderedList"], outdent: ["outdent_desc", "Outdent"], indent: ["indent_desc", "Indent"], cut: ["cut_desc", "Cut"], copy: ["copy_desc", "Copy"], paste: ["paste_desc", "Paste"], undo: ["undo_desc", "Undo"], redo: ["redo_desc", "Redo"], link: ["link_desc", "mceLink"], unlink: ["unlink_desc", "unlink"], image: ["image_desc", "mceImage"], cleanup: ["cleanup_desc", "mceCleanup"], help: ["help_desc", "mceHelp"], code: ["code_desc", "mceCodeEditor"], hr: ["hr_desc", "InsertHorizontalRule"], removeformat: ["removeformat_desc", "RemoveFormat"], sub: ["sub_desc", "subscript"], sup: ["sup_desc", "superscript"], forecolor: ["forecolor_desc", "ForeColor"], forecolorpicker: ["forecolor_desc", "mceForeColor"], backcolor: ["backcolor_desc", "HiliteColor"], backcolorpicker: ["backcolor_desc", "mceBackColor"], charmap: ["charmap_desc", "mceCharMap"], visualaid: ["visualaid_desc", "mceToggleVisualAid"], anchor: ["anchor_desc", "mceInsertAnchor"], newdocument: ["newdocument_desc", "mceNewDocument"], blockquote: ["blockquote_desc", "mceBlockQuote"]}, stateControls: ["bold", "italic", "underline", "strikethrough", "bullist", "numlist", "justifyleft", "justifycenter", "justifyright", "justifyfull", "sub", "sup", "blockquote"], init: function(j, k) {
            var l = this, m, i, n;
            l.editor = j;
            l.url = k;
            l.onResolveName = new e.util.Dispatcher(this);
            l.settings = m = h({theme_advanced_path: true, theme_advanced_toolbar_location: "bottom", theme_advanced_buttons1: "bold,italic,underline,strikethrough,|,justifyleft,justifycenter,justifyright,justifyfull,|,styleselect,formatselect", theme_advanced_buttons2: "bullist,numlist,|,outdent,indent,|,undo,redo,|,link,unlink,anchor,image,cleanup,help,code", theme_advanced_buttons3: "hr,removeformat,visualaid,|,sub,sup,|,charmap", theme_advanced_blockformats: "p,address,pre,h1,h2,h3,h4,h5,h6", theme_advanced_toolbar_align: "center", theme_advanced_fonts: "Andale Mono=andale mono,times;Arial=arial,helvetica,sans-serif;Arial Black=arial black,avant garde;Book Antiqua=book antiqua,palatino;Comic Sans MS=comic sans ms,sans-serif;Courier New=courier new,courier;Georgia=georgia,palatino;Helvetica=helvetica;Impact=impact,chicago;Symbol=symbol;Tahoma=tahoma,arial,helvetica,sans-serif;Terminal=terminal,monaco;Times New Roman=times new roman,times;Trebuchet MS=trebuchet ms,geneva;Verdana=verdana,geneva;Webdings=webdings;Wingdings=wingdings,zapf dingbats", theme_advanced_more_colors: 1, theme_advanced_row_height: 23, theme_advanced_resize_horizontal: 1, theme_advanced_resizing_use_cookie: 1, theme_advanced_font_sizes: "1,2,3,4,5,6,7", readonly: j.settings.readonly}, j.settings);
            if (!m.font_size_style_values) {
                m.font_size_style_values = "8pt,10pt,12pt,14pt,18pt,24pt,36pt"
            }
            if (e.is(m.theme_advanced_font_sizes, "string")) {
                m.font_size_style_values = e.explode(m.font_size_style_values);
                m.font_size_classes = e.explode(m.font_size_classes || "");
                n = {};
                j.settings.theme_advanced_font_sizes = m.theme_advanced_font_sizes;
                f(j.getParam("theme_advanced_font_sizes", "", "hash"), function(q, p) {
                    var o;
                    if (p == q && q >= 1 && q <= 7) {
                        p = q + " (" + l.sizes[q - 1] + "pt)";
                        if (j.settings.convert_fonts_to_spans) {
                            o = m.font_size_classes[q - 1];
                            q = m.font_size_style_values[q - 1] || (l.sizes[q - 1] + "pt")
                        }
                    }
                    if (/^\s*\./.test(q)) {
                        o = q.replace(/\./g, "")
                    }
                    n[p] = o ? {"class": o} : {fontSize: q}
                });
                m.theme_advanced_font_sizes = n
            }
            if ((i = m.theme_advanced_path_location) && i != "none") {
                m.theme_advanced_statusbar_location = m.theme_advanced_path_location
            }
            if (m.theme_advanced_statusbar_location == "none") {
                m.theme_advanced_statusbar_location = 0
            }
            j.onInit.add(function() {
                j.onNodeChange.add(l._nodeChanged, l);
                if (j.settings.content_css !== false) {
                    j.dom.loadCSS(j.baseURI.toAbsolute("themes/advanced/skins/" + j.settings.skin + "/content.css"))
                }
            });
            j.onSetProgressState.add(function(q, o, r) {
                var s, t = q.id, p;
                if (o) {
                    l.progressTimer = setTimeout(function() {
                        s = q.getContainer();
                        s = s.insertBefore(d.create("DIV", {style: "position:relative"}), s.firstChild);
                        p = d.get(q.id + "_tbl");
                        d.add(s, "div", {id: t + "_blocker", "class": "mceBlocker", style: {width: p.clientWidth + 2, height: p.clientHeight + 2}});
                        d.add(s, "div", {id: t + "_progress", "class": "mceProgress", style: {left: p.clientWidth / 2, top: p.clientHeight / 2}})
                    }, r || 0)
                } else {
                    d.remove(t + "_blocker");
                    d.remove(t + "_progress");
                    clearTimeout(l.progressTimer)
                }
            });
            d.loadCSS(m.editor_css ? j.documentBaseURI.toAbsolute(m.editor_css) : k + "/skins/" + j.settings.skin + "/ui.css");
            if (m.skin_variant) {
                d.loadCSS(k + "/skins/" + j.settings.skin + "/ui_" + m.skin_variant + ".css")
            }
        }, createControl: function(l, i) {
            var j, k;
            if (k = i.createControl(l)) {
                return k
            }
            switch (l) {
                case"styleselect":
                    return this._createStyleSelect();
                case"formatselect":
                    return this._createBlockFormats();
                case"fontselect":
                    return this._createFontSelect();
                case"fontsizeselect":
                    return this._createFontSizeSelect();
                case"forecolor":
                    return this._createForeColorMenu();
                case"backcolor":
                    return this._createBackColorMenu()
            }
            if ((j = this.controls[l])) {
                return i.createButton(l, {title: "advanced." + j[0], cmd: j[1], ui: j[2], value: j[3]})
            }
        }, execCommand: function(k, j, l) {
            var i = this["_" + k];
            if (i) {
                i.call(this, j, l);
                return true
            }
            return false
        }, _importClasses: function(j) {
            var i = this.editor, k = i.controlManager.get("styleselect");
            if (k.getLength() == 0) {
                f(i.dom.getClasses(), function(l) {
                    k.add(l["class"], l["class"])
                })
            }
        }, _createStyleSelect: function(m) {
            var j = this, i = j.editor, k = i.controlManager, l = k.createListBox("styleselect", {title: "advanced.style_select", onselect: function(n) {
                    if (l.selectedValue === n) {
                        i.execCommand("mceSetStyleInfo", 0, {command: "removeformat"});
                        l.select();
                        return false
                    } else {
                        i.execCommand("mceSetCSSClass", 0, n)
                    }
                }});
            if (l) {
                f(i.getParam("theme_advanced_styles", "", "hash"), function(o, n) {
                    if (o) {
                        l.add(j.editor.translate(n), o)
                    }
                });
                l.onPostRender.add(function(o, p) {
                    if (!l.NativeListBox) {
                        b.add(p.id + "_text", "focus", j._importClasses, j);
                        b.add(p.id + "_text", "mousedown", j._importClasses, j);
                        b.add(p.id + "_open", "focus", j._importClasses, j);
                        b.add(p.id + "_open", "mousedown", j._importClasses, j)
                    } else {
                        b.add(p.id, "focus", j._importClasses, j)
                    }
                })
            }
            return l
        }, _createFontSelect: function() {
            var k, j = this, i = j.editor;
            k = i.controlManager.createListBox("fontselect", {title: "advanced.fontdefault", cmd: "FontName"});
            if (k) {
                f(i.getParam("theme_advanced_fonts", j.settings.theme_advanced_fonts, "hash"), function(m, l) {
                    k.add(i.translate(l), m, {style: m.indexOf("dings") == -1 ? "font-family:" + m : ""})
                })
            }
            return k
        }, _createFontSizeSelect: function() {
            var m = this, k = m.editor, n, l = 0, j = [];
            n = k.controlManager.createListBox("fontsizeselect", {title: "advanced.font_size", onselect: function(i) {
                    if (i.fontSize) {
                        k.execCommand("FontSize", false, i.fontSize)
                    } else {
                        f(m.settings.theme_advanced_font_sizes, function(p, o) {
                            if (p["class"]) {
                                j.push(p["class"])
                            }
                        });
                        k.editorCommands._applyInlineStyle("span", {"class": i["class"]}, {check_classes: j})
                    }
                }});
            if (n) {
                f(m.settings.theme_advanced_font_sizes, function(o, i) {
                    var p = o.fontSize;
                    if (p >= 1 && p <= 7) {
                        p = m.sizes[parseInt(p) - 1] + "pt"
                    }
                    n.add(i, o, {style: "font-size:" + p, "class": "mceFontSize" + (l++) + (" " + (o["class"] || ""))})
                })
            }
            return n
        }, _createBlockFormats: function() {
            var k, i = {p: "advanced.paragraph", address: "advanced.address", pre: "advanced.pre", h1: "advanced.h1", h2: "advanced.h2", h3: "advanced.h3", h4: "advanced.h4", h5: "advanced.h5", h6: "advanced.h6", div: "advanced.div", blockquote: "advanced.blockquote", code: "advanced.code", dt: "advanced.dt", dd: "advanced.dd", samp: "advanced.samp"}, j = this;
            k = j.editor.controlManager.createListBox("formatselect", {title: "advanced.block", cmd: "FormatBlock"});
            if (k) {
                f(j.editor.getParam("theme_advanced_blockformats", j.settings.theme_advanced_blockformats, "hash"), function(m, l) {
                    k.add(j.editor.translate(l != m ? l : i[m]), m, {"class": "mce_formatPreview mce_" + m})
                })
            }
            return k
        }, _createForeColorMenu: function() {
            var m, j = this, k = j.settings, l = {}, i;
            if (k.theme_advanced_more_colors) {
                l.more_colors_func = function() {
                    j._mceColorPicker(0, {color: m.value, func: function(n) {
                            m.setColor(n)
                        }})
                }
            }
            if (i = k.theme_advanced_text_colors) {
                l.colors = i
            }
            if (k.theme_advanced_default_foreground_color) {
                l.default_color = k.theme_advanced_default_foreground_color
            }
            l.title = "advanced.forecolor_desc";
            l.cmd = "ForeColor";
            l.scope = this;
            m = j.editor.controlManager.createColorSplitButton("forecolor", l);
            return m
        }, _createBackColorMenu: function() {
            var m, j = this, k = j.settings, l = {}, i;
            if (k.theme_advanced_more_colors) {
                l.more_colors_func = function() {
                    j._mceColorPicker(0, {color: m.value, func: function(n) {
                            m.setColor(n)
                        }})
                }
            }
            if (i = k.theme_advanced_background_colors) {
                l.colors = i
            }
            if (k.theme_advanced_default_background_color) {
                l.default_color = k.theme_advanced_default_background_color
            }
            l.title = "advanced.backcolor_desc";
            l.cmd = "HiliteColor";
            l.scope = this;
            m = j.editor.controlManager.createColorSplitButton("backcolor", l);
            return m
        }, renderUI: function(k) {
            var m, l, q, v = this, r = v.editor, w = v.settings, u, j, i;
            m = j = d.create("span", {id: r.id + "_parent", "class": "mceEditor " + r.settings.skin + "Skin" + (w.skin_variant ? " " + r.settings.skin + "Skin" + v._ufirst(w.skin_variant) : "")});
            if (!d.boxModel) {
                m = d.add(m, "div", {"class": "mceOldBoxModel"})
            }
            m = u = d.add(m, "table", {id: r.id + "_tbl", "class": "mceLayout", cellSpacing: 0, cellPadding: 0});
            m = q = d.add(m, "tbody");
            switch ((w.theme_advanced_layout_manager || "").toLowerCase()) {
                case"rowlayout":
                    l = v._rowLayout(w, q, k);
                    break;
                case"customlayout":
                    l = r.execCallback("theme_advanced_custom_layout", w, q, k, j);
                    break;
                default:
                    l = v._simpleLayout(w, q, k, j)
            }
            m = k.targetNode;
            i = d.stdMode ? u.getElementsByTagName("tr") : u.rows;
            d.addClass(i[0], "mceFirst");
            d.addClass(i[i.length - 1], "mceLast");
            f(d.select("tr", q), function(o) {
                d.addClass(o.firstChild, "mceFirst");
                d.addClass(o.childNodes[o.childNodes.length - 1], "mceLast")
            });
            if (d.get(w.theme_advanced_toolbar_container)) {
                d.get(w.theme_advanced_toolbar_container).appendChild(j)
            } else {
                d.insertAfter(j, m)
            }
            b.add(r.id + "_path_row", "click", function(n) {
                n = n.target;
                if (n.nodeName == "A") {
                    v._sel(n.className.replace(/^.*mcePath_([0-9]+).*$/, "$1"));
                    return b.cancel(n)
                }
            });
            if (!r.getParam("accessibility_focus")) {
                b.add(d.add(j, "a", {href: "#"}, "<!-- IE -->"), "focus", function() {
                    tinyMCE.get(r.id).focus()
                })
            }
            if (w.theme_advanced_toolbar_location == "external") {
                k.deltaHeight = 0
            }
            v.deltaHeight = k.deltaHeight;
            k.targetNode = null;
            return{iframeContainer: l, editorContainer: r.id + "_parent", sizeContainer: u, deltaHeight: k.deltaHeight}
        }, getInfo: function() {
            return{longname: "Advanced theme", author: "Moxiecode Systems AB", authorurl: "http://tinymce.moxiecode.com", version: e.majorVersion + "." + e.minorVersion}
        }, resizeBy: function(i, j) {
            var k = d.get(this.editor.id + "_tbl");
            this.resizeTo(k.clientWidth + i, k.clientHeight + j)
        }, resizeTo: function(i, l) {
            var j = this.editor, k = j.settings, n = d.get(j.id + "_tbl"), o = d.get(j.id + "_ifr"), m;
            i = Math.max(k.theme_advanced_resizing_min_width || 100, i);
            l = Math.max(k.theme_advanced_resizing_min_height || 100, l);
            i = Math.min(k.theme_advanced_resizing_max_width || 65535, i);
            l = Math.min(k.theme_advanced_resizing_max_height || 65535, l);
            m = n.clientHeight - o.clientHeight;
            d.setStyle(o, "height", l - m);
            d.setStyles(n, {width: i, height: l})
        }, destroy: function() {
            var i = this.editor.id;
            b.clear(i + "_resize");
            b.clear(i + "_path_row");
            b.clear(i + "_external_close")
        }, _simpleLayout: function(y, r, k, i) {
            var x = this, u = x.editor, v = y.theme_advanced_toolbar_location, m = y.theme_advanced_statusbar_location, l, j, q, w;
            if (y.readonly) {
                l = d.add(r, "tr");
                l = j = d.add(l, "td", {"class": "mceIframeContainer"});
                return j
            }
            if (v == "top") {
                x._addToolbars(r, k)
            }
            if (v == "external") {
                l = w = d.create("div", {style: "position:relative"});
                l = d.add(l, "div", {id: u.id + "_external", "class": "mceExternalToolbar"});
                d.add(l, "a", {id: u.id + "_external_close", href: "javascript:;", "class": "mceExternalClose"});
                l = d.add(l, "table", {id: u.id + "_tblext", cellSpacing: 0, cellPadding: 0});
                q = d.add(l, "tbody");
                if (i.firstChild.className == "mceOldBoxModel") {
                    i.firstChild.appendChild(w)
                } else {
                    i.insertBefore(w, i.firstChild)
                }
                x._addToolbars(q, k);
                u.onMouseUp.add(function() {
                    var o = d.get(u.id + "_external");
                    d.show(o);
                    d.hide(g);
                    var n = b.add(u.id + "_external_close", "click", function() {
                        d.hide(u.id + "_external");
                        b.remove(u.id + "_external_close", "click", n)
                    });
                    d.show(o);
                    d.setStyle(o, "top", 0 - d.getRect(u.id + "_tblext").h - 1);
                    d.hide(o);
                    d.show(o);
                    o.style.filter = "";
                    g = u.id + "_external";
                    o = null
                })
            }
            if (m == "top") {
                x._addStatusBar(r, k)
            }
            if (!y.theme_advanced_toolbar_container) {
                l = d.add(r, "tr");
                l = j = d.add(l, "td", {"class": "mceIframeContainer"})
            }
            if (v == "bottom") {
                x._addToolbars(r, k)
            }
            if (m == "bottom") {
                x._addStatusBar(r, k)
            }
            return j
        }, _rowLayout: function(w, m, k) {
            var v = this, p = v.editor, u, x, i = p.controlManager, l, j, r, q;
            u = w.theme_advanced_containers_default_class || "";
            x = w.theme_advanced_containers_default_align || "center";
            f(c(w.theme_advanced_containers || ""), function(s, o) {
                var n = w["theme_advanced_container_" + s] || "";
                switch (n.toLowerCase()) {
                    case"mceeditor":
                        l = d.add(m, "tr");
                        l = j = d.add(l, "td", {"class": "mceIframeContainer"});
                        break;
                    case"mceelementpath":
                        v._addStatusBar(m, k);
                        break;
                    default:
                        q = (w["theme_advanced_container_" + s + "_align"] || x).toLowerCase();
                        q = "mce" + v._ufirst(q);
                        l = d.add(d.add(m, "tr"), "td", {"class": "mceToolbar " + (w["theme_advanced_container_" + s + "_class"] || u) + " " + q || x});
                        r = i.createToolbar("toolbar" + o);
                        v._addControls(n, r);
                        d.setHTML(l, r.renderHTML());
                        k.deltaHeight -= w.theme_advanced_row_height
                    }
            });
            return j
        }, _addControls: function(j, i) {
            var k = this, l = k.settings, m, n = k.editor.controlManager;
            if (l.theme_advanced_disable && !k._disabled) {
                m = {};
                f(c(l.theme_advanced_disable), function(o) {
                    m[o] = 1
                });
                k._disabled = m
            } else {
                m = k._disabled
            }
            f(c(j), function(p) {
                var o;
                if (m && m[p]) {
                    return
                }
                if (p == "tablecontrols") {
                    f(["table", "|", "row_props", "cell_props", "|", "row_before", "row_after", "delete_row", "|", "col_before", "col_after", "delete_col", "|", "split_cells", "merge_cells"], function(q) {
                        q = k.createControl(q, n);
                        if (q) {
                            i.add(q)
                        }
                    });
                    return
                }
                o = k.createControl(p, n);
                if (o) {
                    i.add(o)
                }
            })
        }, _addToolbars: function(w, k) {
            var z = this, p, m, r = z.editor, A = z.settings, y, j = r.controlManager, u, l, q = [], x;
            x = A.theme_advanced_toolbar_align.toLowerCase();
            x = "mce" + z._ufirst(x);
            l = d.add(d.add(w, "tr"), "td", {"class": "mceToolbar " + x});
            if (!r.getParam("accessibility_focus")) {
                q.push(d.createHTML("a", {href: "#", onfocus: "tinyMCE.get('" + r.id + "').focus();"}, "<!-- IE -->"))
            }
            q.push(d.createHTML("a", {href: "#", accesskey: "q", title: r.getLang("advanced.toolbar_focus")}, "<!-- IE -->"));
            for (p = 1; (y = A["theme_advanced_buttons" + p]); p++) {
                m = j.createToolbar("toolbar" + p, {"class": "mceToolbarRow" + p});
                if (A["theme_advanced_buttons" + p + "_add"]) {
                    y += "," + A["theme_advanced_buttons" + p + "_add"]
                }
                if (A["theme_advanced_buttons" + p + "_add_before"]) {
                    y = A["theme_advanced_buttons" + p + "_add_before"] + "," + y
                }
                z._addControls(y, m);
                q.push(m.renderHTML());
                k.deltaHeight -= A.theme_advanced_row_height
            }
            q.push(d.createHTML("a", {href: "#", accesskey: "z", title: r.getLang("advanced.toolbar_focus"), onfocus: "tinyMCE.getInstanceById('" + r.id + "').focus();"}, "<!-- IE -->"));
            d.setHTML(l, q.join(""))
        }, _addStatusBar: function(m, j) {
            var k, v = this, p = v.editor, w = v.settings, i, q, u, l;
            k = d.add(m, "tr");
            k = l = d.add(k, "td", {"class": "mceStatusbar"});
            k = d.add(k, "div", {id: p.id + "_path_row"}, w.theme_advanced_path ? p.translate("advanced.path") + ": " : "&#160;");
            d.add(k, "a", {href: "#", accesskey: "x"});
            if (w.theme_advanced_resizing) {
                d.add(l, "a", {id: p.id + "_resize", href: "javascript:;", onclick: "return false;", "class": "mceResize"});
                if (w.theme_advanced_resizing_use_cookie) {
                    p.onPostRender.add(function() {
                        var n = a.getHash("TinyMCE_" + p.id + "_size"), r = d.get(p.id + "_tbl");
                        if (!n) {
                            return
                        }
                        if (w.theme_advanced_resize_horizontal) {
                            r.style.width = Math.max(10, n.cw) + "px"
                        }
                        r.style.height = Math.max(10, n.ch) + "px";
                        d.get(p.id + "_ifr").style.height = Math.max(10, parseInt(n.ch) + v.deltaHeight) + "px"
                    })
                }
                p.onPostRender.add(function() {
                    b.add(p.id + "_resize", "mousedown", function(x) {
                        var z, t, o, s, y, r;
                        z = d.get(p.id + "_tbl");
                        o = z.clientWidth;
                        s = z.clientHeight;
                        miw = w.theme_advanced_resizing_min_width || 100;
                        mih = w.theme_advanced_resizing_min_height || 100;
                        maw = w.theme_advanced_resizing_max_width || 65535;
                        mah = w.theme_advanced_resizing_max_height || 65535;
                        t = d.add(d.get(p.id + "_parent"), "div", {"class": "mcePlaceHolder"});
                        d.setStyles(t, {width: o, height: s});
                        d.hide(z);
                        d.show(t);
                        i = {x: x.screenX, y: x.screenY, w: o, h: s, dx: null, dy: null};
                        q = b.add(d.doc, "mousemove", function(B) {
                            var n, A;
                            i.dx = B.screenX - i.x;
                            i.dy = B.screenY - i.y;
                            n = Math.max(miw, i.w + i.dx);
                            A = Math.max(mih, i.h + i.dy);
                            n = Math.min(maw, n);
                            A = Math.min(mah, A);
                            if (w.theme_advanced_resize_horizontal) {
                                t.style.width = n + "px"
                            }
                            t.style.height = A + "px";
                            return b.cancel(B)
                        });
                        u = b.add(d.doc, "mouseup", function(n) {
                            var A;
                            b.remove(d.doc, "mousemove", q);
                            b.remove(d.doc, "mouseup", u);
                            z.style.display = "";
                            d.remove(t);
                            if (i.dx === null) {
                                return
                            }
                            A = d.get(p.id + "_ifr");
                            if (w.theme_advanced_resize_horizontal) {
                                z.style.width = Math.max(10, i.w + i.dx) + "px"
                            }
                            z.style.height = Math.max(10, i.h + i.dy) + "px";
                            A.style.height = Math.max(10, A.clientHeight + i.dy) + "px";
                            if (w.theme_advanced_resizing_use_cookie) {
                                a.setHash("TinyMCE_" + p.id + "_size", {cw: i.w + i.dx, ch: i.h + i.dy})
                            }
                        });
                        return b.cancel(x)
                    })
                })
            }
            j.deltaHeight -= 21;
            k = m = null
        }, _nodeChanged: function(l, u, k, q) {
            var y = this, i, r = 0, x, m, z = y.settings, w, j, o;
            if (z.readonly) {
                return
            }
            e.each(y.stateControls, function(n) {
                u.setActive(n, l.queryCommandState(y.controls[n][1]))
            });
            u.setActive("visualaid", l.hasVisual);
            u.setDisabled("undo", !l.undoManager.hasUndo() && !l.typing);
            u.setDisabled("redo", !l.undoManager.hasRedo());
            u.setDisabled("outdent", !l.queryCommandState("Outdent"));
            i = d.getParent(k, "A");
            if (m = u.get("link")) {
                if (!i || !i.name) {
                    m.setDisabled(!i && q);
                    m.setActive(!!i)
                }
            }
            if (m = u.get("unlink")) {
                m.setDisabled(!i && q);
                m.setActive(!!i && !i.name)
            }
            if (m = u.get("anchor")) {
                m.setActive(!!i && i.name);
                if (e.isWebKit) {
                    i = d.getParent(k, "IMG");
                    m.setActive(!!i && d.getAttrib(i, "mce_name") == "a")
                }
            }
            i = d.getParent(k, "IMG");
            if (m = u.get("image")) {
                m.setActive(!!i && k.className.indexOf("mceItem") == -1)
            }
            if (m = u.get("styleselect")) {
                if (k.className) {
                    y._importClasses();
                    m.select(k.className)
                } else {
                    m.select()
                }
            }
            if (m = u.get("formatselect")) {
                i = d.getParent(k, d.isBlock);
                if (i) {
                    m.select(i.nodeName.toLowerCase())
                }
            }
            if (l.settings.convert_fonts_to_spans) {
                l.dom.getParent(k, function(p) {
                    if (p.nodeName === "SPAN") {
                        if (!w && p.className) {
                            w = p.className
                        }
                        if (!j && p.style.fontSize) {
                            j = p.style.fontSize
                        }
                        if (!o && p.style.fontFamily) {
                            o = p.style.fontFamily.replace(/[\"\']+/g, "").replace(/^([^,]+).*/, "$1").toLowerCase()
                        }
                    }
                    return false
                });
                if (m = u.get("fontselect")) {
                    m.select(function(n) {
                        return n.replace(/^([^,]+).*/, "$1").toLowerCase() == o
                    })
                }
                if (m = u.get("fontsizeselect")) {
                    m.select(function(n) {
                        if (n.fontSize && n.fontSize === j) {
                            return true
                        }
                        if (n["class"] && n["class"] === w) {
                            return true
                        }
                    })
                }
            } else {
                if (m = u.get("fontselect")) {
                    m.select(l.queryCommandValue("FontName"))
                }
                if (m = u.get("fontsizeselect")) {
                    x = l.queryCommandValue("FontSize");
                    m.select(function(n) {
                        return n.fontSize == x
                    })
                }
            }
            if (z.theme_advanced_path && z.theme_advanced_statusbar_location) {
                i = d.get(l.id + "_path") || d.add(l.id + "_path_row", "span", {id: l.id + "_path"});
                d.setHTML(i, "");
                l.dom.getParent(k, function(A) {
                    var p = A.nodeName.toLowerCase(), s, v, t = "";
                    if (A.nodeType != 1 || A.nodeName === "BR" || (d.hasClass(A, "mceItemHidden") || d.hasClass(A, "mceItemRemoved"))) {
                        return
                    }
                    if (x = d.getAttrib(A, "mce_name")) {
                        p = x
                    }
                    if (e.isIE && A.scopeName !== "HTML") {
                        p = A.scopeName + ":" + p
                    }
                    p = p.replace(/mce\:/g, "");
                    switch (p) {
                        case"b":
                            p = "strong";
                            break;
                        case"i":
                            p = "em";
                            break;
                        case"img":
                            if (x = d.getAttrib(A, "src")) {
                                t += "src: " + x + " "
                            }
                            break;
                        case"a":
                            if (x = d.getAttrib(A, "name")) {
                                t += "name: " + x + " ";
                                p += "#" + x
                            }
                            if (x = d.getAttrib(A, "href")) {
                                t += "href: " + x + " "
                            }
                            break;
                        case"font":
                            if (z.convert_fonts_to_spans) {
                                p = "span"
                            }
                            if (x = d.getAttrib(A, "face")) {
                                t += "font: " + x + " "
                            }
                            if (x = d.getAttrib(A, "size")) {
                                t += "size: " + x + " "
                            }
                            if (x = d.getAttrib(A, "color")) {
                                t += "color: " + x + " "
                            }
                            break;
                        case"span":
                            if (x = d.getAttrib(A, "style")) {
                                t += "style: " + x + " "
                            }
                            break
                    }
                    if (x = d.getAttrib(A, "id")) {
                        t += "id: " + x + " "
                    }
                    if (x = A.className) {
                        x = x.replace(/(webkit-[\w\-]+|Apple-[\w\-]+|mceItem\w+|mceVisualAid)/g, "");
                        if (x && x.indexOf("mceItem") == -1) {
                            t += "class: " + x + " ";
                            if (d.isBlock(A) || p == "img" || p == "span") {
                                p += "." + x
                            }
                        }
                    }
                    p = p.replace(/(html:)/g, "");
                    p = {name: p, node: A, title: t};
                    y.onResolveName.dispatch(y, p);
                    t = p.title;
                    p = p.name;
                    v = d.create("a", {href: "javascript:;", onmousedown: "return false;", title: t, "class": "mcePath_" + (r++)}, p);
                    if (i.hasChildNodes()) {
                        i.insertBefore(d.doc.createTextNode(" \u00bb "), i.firstChild);
                        i.insertBefore(v, i.firstChild)
                    } else {
                        i.appendChild(v)
                    }
                }, l.getBody())
            }
        }, _sel: function(i) {
            this.editor.execCommand("mceSelectNodeDepth", false, i)
        }, _mceInsertAnchor: function(k, j) {
            var i = this.editor;
            i.windowManager.open({url: e.baseURL + "/themes/advanced/anchor.htm", width: 320 + parseInt(i.getLang("advanced.anchor_delta_width", 0)), height: 90 + parseInt(i.getLang("advanced.anchor_delta_height", 0)), inline: true}, {theme_url: this.url})
        }, _mceCharMap: function() {
            var i = this.editor;
            i.windowManager.open({url: e.baseURL + "/themes/advanced/charmap.htm", width: 550 + parseInt(i.getLang("advanced.charmap_delta_width", 0)), height: 250 + parseInt(i.getLang("advanced.charmap_delta_height", 0)), inline: true}, {theme_url: this.url})
        }, _mceHelp: function() {
            var i = this.editor;
            i.windowManager.open({url: e.baseURL + "/themes/advanced/about.htm", width: 480, height: 380, inline: true}, {theme_url: this.url})
        }, _mceColorPicker: function(k, j) {
            var i = this.editor;
            j = j || {};
            i.windowManager.open({url: e.baseURL + "/themes/advanced/color_picker.htm", width: 375 + parseInt(i.getLang("advanced.colorpicker_delta_width", 0)), height: 250 + parseInt(i.getLang("advanced.colorpicker_delta_height", 0)), close_previous: false, inline: true}, {input_color: j.color, func: j.func, theme_url: this.url})
        }, _mceCodeEditor: function(j, k) {
            var i = this.editor;
            i.windowManager.open({url: e.baseURL + "/themes/advanced/source_editor.htm", width: parseInt(i.getParam("theme_advanced_source_editor_width", 720)), height: parseInt(i.getParam("theme_advanced_source_editor_height", 580)), inline: true, resizable: true, maximizable: true}, {theme_url: this.url})
        }, _mceImage: function(j, k) {
            var i = this.editor;
            if (i.dom.getAttrib(i.selection.getNode(), "class").indexOf("mceItem") != -1) {
                return
            }
            i.windowManager.open({url: e.baseURL + "/themes/advanced/image.htm", width: 355 + parseInt(i.getLang("advanced.image_delta_width", 0)), height: 275 + parseInt(i.getLang("advanced.image_delta_height", 0)), inline: true}, {theme_url: this.url})
        }, _mceLink: function(j, k) {
            var i = this.editor;
            i.windowManager.open({url: e.baseURL + "/themes/advanced/link.htm", width: 310 + parseInt(i.getLang("advanced.link_delta_width", 0)), height: 200 + parseInt(i.getLang("advanced.link_delta_height", 0)), inline: true}, {theme_url: this.url})
        }, _mceNewDocument: function() {
            var i = this.editor;
            i.windowManager.confirm("advanced.newdocument", function(j) {
                if (j) {
                    i.execCommand("mceSetContent", false, "")
                }
            })
        }, _mceForeColor: function() {
            var i = this;
            this._mceColorPicker(0, {color: i.fgColor, func: function(j) {
                    i.fgColor = j;
                    i.editor.execCommand("ForeColor", false, j)
                }})
        }, _mceBackColor: function() {
            var i = this;
            this._mceColorPicker(0, {color: i.bgColor, func: function(j) {
                    i.bgColor = j;
                    i.editor.execCommand("HiliteColor", false, j)
                }})
        }, _ufirst: function(i) {
            return i.substring(0, 1).toUpperCase() + i.substring(1)
        }});
    e.ThemeManager.add("advanced", e.themes.AdvancedTheme)
}(tinymce));