package curso.tecnocom.gestor;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import curso.tecnocom.gestor.datos.Imagene;
import curso.tecnocom.gestor.delegates.GestorDelegate;

//@Controller
public class ImagenesController {

	@Autowired
	private ServletFileUpload servletFileUpload;

	@Autowired
	private ServletContext servletContext;

	private GestorDelegate gestorDelegate;

	@RequestMapping(value = "/altaImagen.html")
	public ModelAndView altaImagen(
			@RequestParam("fichero") MultipartFile fichero,
			HttpServletRequest request, HttpServletResponse response,
			@RequestParam("titulo") String titulo,
			@RequestParam("texto") String texto) throws Exception {
		String salida = null;
		try {

			if (ServletFileUpload.isMultipartContent(request)) {
				// System.out.println("paso1");

				// System.out.println("paso2");
				// Iterator it = fileItemsList.iterator();
				// while (it.hasNext()) {
				// System.out.println("paso3");
				// FileItem archivoActual = (FileItem) it.next();
				String nombre = fichero.getOriginalFilename();
				File archivoADisco = new File(nombre);

				archivoADisco = new File(archivoADisco.getName());
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

	@RequestMapping(value = "/altaImagen.html")
	public ModelAndView imagenes(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
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
