package curso.tecnocom.gestor;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import curso.tecnocom.gestor.datos.Imagene;
import curso.tecnocom.gestor.datos.Usuario;
import curso.tecnocom.gestor.delegates.GestorDelegate;

@Controller
public class ImagenesController {

	@Autowired
	private ServletFileUpload servletFileUpload;

	@Autowired
	private ServletContext servletContext;

	@Autowired
	private GestorDelegate gestorDelegate;

	@RequestMapping(value = "/altaImagen.html")
	public ModelAndView altaImagen(
			@RequestParam("fichero") MultipartFile fichero,
			HttpServletRequest request, String banner) throws Exception {
		String salida = null;
		try {

			if (!gestorDelegate.validar(request)) {

				ModelAndView modelAndView = new ModelAndView("validacion");
				modelAndView.addObject("usuario", new Usuario());
				modelAndView.addObject("destino", "imagenes.html");
				return modelAndView;
			}

			if (ServletFileUpload.isMultipartContent(request)) {

				String nombre = fichero.getOriginalFilename();

				try (FileOutputStream fo = new FileOutputStream(
						getServletContext().getRealPath("/") + "/images/"
								+ nombre);) {
					byte[] b = fichero.getBytes();
					fo.write(b);
					fo.flush();
					Imagene imagen = new Imagene();
					imagen.setNombre(nombre);
					imagen.setImagen(b);
					imagen.setBanner(0);
					imagen.setCarrusel(false);
					if (banner.equals("on")) {
						imagen.setBanner(1);
						imagen.setCarrusel(true);
					}

					getGestorDelegate().grabaObjeto(imagen);
				}

			}
			return imagenes(request);
		} catch (Exception ex) {
			salida = "home";
			ex.printStackTrace();
		}

		return new ModelAndView(salida);

	}

	@RequestMapping("grabaModificaImagen{id}.html")
	public ModelAndView grabaModificaImagen(@PathVariable("id") int id,
			HttpServletRequest request, Imagene imagen) {

		if (!gestorDelegate.validar(request)) {

			ModelAndView modelAndView = new ModelAndView("validacion");
			modelAndView.addObject("usuario", new Usuario());
			modelAndView.addObject("destino", "imagenes.html");
			return modelAndView;
		}

		try {
			Imagene im = (Imagene) getGestorDelegate().dameObjeto(id,
					Imagene.class);
			if (imagen.isCarrusel()) {
				im.setBanner(1);
				im.setCarrusel(imagen.isCarrusel());
			}

			getGestorDelegate().grabaObjeto(im);
			return imagenes(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("home");
		}

	}

	@RequestMapping("modificaImagen{id}.html")
	public ModelAndView modificaImagen(@PathVariable("id") int id) {
		Imagene imagen = new Imagene();
		ModelAndView salida = null;
		try {
			if (id > 0) {
				imagen = (Imagene) getGestorDelegate().dameObjeto(id,
						Imagene.class);
				salida = new ModelAndView("modificaImagen");
				imagen.setCarrusel(false);
				if (imagen.getBanner() == 1)
					imagen.setCarrusel(true);

			} else {
				salida = new ModelAndView("altaImagen");

			}
			salida.addObject("imagen", imagen);

			return salida;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("home");
		}
	}

	@RequestMapping("borraImagen{id}.html")
	public ModelAndView borraImagen(@PathVariable("id") int id,
			HttpServletRequest request) {

		if (!gestorDelegate.validar(request)) {

			ModelAndView modelAndView = new ModelAndView("validacion");
			modelAndView.addObject("usuario", new Usuario());
			modelAndView.addObject("destino", "imagenes.html");
			return modelAndView;
		}

		try {
			Imagene imagen = (Imagene) getGestorDelegate().dameObjeto(id,
					Imagene.class);

			getGestorDelegate().borraDato(imagen);
			File file = new File(getServletContext().getRealPath("/")
					+ "/images/" + imagen.getNombre());
			file.delete();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// salida.addObject("error","");
			// result.addError(new ObjectError("error",
			// "La imagen no ha podido borrarse"));

		}
		return imagenes(request);
	}

	@RequestMapping(value = "/imagenes.html")
	public ModelAndView imagenes(HttpServletRequest request) {
		if (!gestorDelegate.validar(request)) {

			ModelAndView modelAndView = new ModelAndView("validacion");
			modelAndView.addObject("usuario", new Usuario());
			modelAndView.addObject("destino", "imagenes.html");
			return modelAndView;
		}
		try {
			List<?> imagenes = getGestorDelegate().dameDatos(Imagene.class);
			ModelAndView modelAndView = new ModelAndView("imagenes");
			modelAndView.addObject("imagenes", imagenes);
			return modelAndView;
		} catch (Exception e) {
			return new ModelAndView("home");
		}

	}

	public ServletFileUpload getServletFileUpload() {
		return servletFileUpload;
	}

	public void setServletFileUpload(ServletFileUpload servletFileUpload) {
		this.servletFileUpload = servletFileUpload;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public GestorDelegate getGestorDelegate() {
		return gestorDelegate;
	}

	public void setGestorDelegate(GestorDelegate gestorDelegate) {
		this.gestorDelegate = gestorDelegate;
	}

}
