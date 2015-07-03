package curso.tecnocom.gestor.services;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.tecnocom.gestor.daos.ImagenesDao;
import curso.tecnocom.gestor.datos.Imagene;

@Service
public class ImagenesService {

	@Autowired
	private ImagenesDao imagenesDao;

	public ImagenesDao getImagenesDao() {
		return imagenesDao;
	}

	public void setImagenesDao(ImagenesDao imagenesDao) {
		this.imagenesDao = imagenesDao;
	}

	public List<Imagene> getImagenesByCarrusel() throws Exception {
		List<Imagene> salida= null;
		Method metodo=getImagenesDao().getClass().getMethod("getImagenesByCarrusel");
		salida=(List<Imagene>) metodo.invoke(getImagenesDao());
		
		return salida;
		
	}
}
