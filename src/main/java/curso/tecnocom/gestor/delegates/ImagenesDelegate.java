package curso.tecnocom.gestor.delegates;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import curso.tecnocom.gestor.datos.Imagene;
import curso.tecnocom.gestor.services.ImagenesService;

@Component
public class ImagenesDelegate {
	
	@Autowired
	private ImagenesService imagenesService;

	public ImagenesService getImagenesService() {
		return imagenesService;
	}

	public void setImagenesService(ImagenesService imagenesService) {
		this.imagenesService = imagenesService;
	}

	public List<Imagene> getImagenesByCarrusel() throws Exception {
		// TODO Auto-generated method stub
		return getImagenesService().getImagenesByCarrusel();
	}

}
