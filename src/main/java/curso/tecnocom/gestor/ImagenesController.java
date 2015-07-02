package curso.tecnocom.gestor;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
			HttpServletRequest request) throws Exception {
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
					getGestorDelegate().grabaObjeto(imagen);
				}

			}
			return imagenes(request);
		} catch (Exception ex) {
			salida = "grabadoKo";
			ex.printStackTrace();
		}

		return new ModelAndView(salida);

	}

	@RequestMapping("modificaImagen{id}.html")
	public ModelAndView modificaImagen(@PathVariable("id") int id) {
		ModelAndView salida = new ModelAndView("modificaImagen");
		Imagene imagen = new Imagene();
		try {
			if (id > 0) {
				imagen = (Imagene) getGestorDelegate().dameObjeto(id,
						Imagene.class);
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
	
	public  ModelAndView borraImagen(@PathVariable("id") int id, HttpServletRequest request) {
		
		if (!gestorDelegate.validar(request)) {

			ModelAndView modelAndView = new ModelAndView("validacion");
			modelAndView.addObject("usuario", new Usuario());
			modelAndView.addObject("destino", "imagenes.html");
			return modelAndView;
		}
		
		
		try {
			Imagene imagen= (Imagene) getGestorDelegate().dameObjeto(id, Imagene.class);
			
			getGestorDelegate().borraDato(imagen);
			File file= new File(getServletContext().getRealPath("/") + "/images/"
								+ imagen.getNombre());
			file.delete();
		 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//salida.addObject("error","");
			//result.addError(new ObjectError("error", "La imagen no ha podido borrarse"));
			
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
