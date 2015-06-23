package curso.tecnocom.gestor.datos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the imagenes database table.
 * 
 */
@Entity
@Table(name="imagenes")
@NamedQuery(name="Imagene.findAll", query="SELECT i FROM Imagene i")
public class Imagene implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int banner;

	@Lob
	private byte[] imagen;

	private String nombre;

	//bi-directional many-to-one association to Menu
	@OneToMany(mappedBy="imagene")
	private Set<Menu> menus;

	//bi-directional many-to-one association to Destacado
	@OneToMany(mappedBy="imagene")
	private Set<Destacado> destacados;

	//bi-directional many-to-one association to Noticia
	@OneToMany(mappedBy="imagene")
	private Set<Noticia> noticias;

	//bi-directional many-to-one association to Principale
	@OneToMany(mappedBy="imagene")
	private Set<Principale> principales;

	public Imagene() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBanner() {
		return this.banner;
	}

	public void setBanner(int banner) {
		this.banner = banner;
	}

	public byte[] getImagen() {
		return this.imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Menu> getMenus() {
		return this.menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}

	public Menu addMenus(Menu menus) {
		getMenus().add(menus);
		menus.setImagene(this);

		return menus;
	}

	public Menu removeMenus(Menu menus) {
		getMenus().remove(menus);
		menus.setImagene(null);

		return menus;
	}

	public Set<Destacado> getDestacados() {
		return this.destacados;
	}

	public void setDestacados(Set<Destacado> destacados) {
		this.destacados = destacados;
	}

	public Destacado addDestacado(Destacado destacado) {
		getDestacados().add(destacado);
		destacado.setImagene(this);

		return destacado;
	}

	public Destacado removeDestacado(Destacado destacado) {
		getDestacados().remove(destacado);
		destacado.setImagene(null);

		return destacado;
	}

	public Set<Noticia> getNoticias() {
		return this.noticias;
	}

	public void setNoticias(Set<Noticia> noticias) {
		this.noticias = noticias;
	}

	public Noticia addNoticia(Noticia noticia) {
		getNoticias().add(noticia);
		noticia.setImagene(this);

		return noticia;
	}

	public Noticia removeNoticia(Noticia noticia) {
		getNoticias().remove(noticia);
		noticia.setImagene(null);

		return noticia;
	}

	public Set<Principale> getPrincipales() {
		return this.principales;
	}

	public void setPrincipales(Set<Principale> principales) {
		this.principales = principales;
	}

	public Principale addPrincipale(Principale principale) {
		getPrincipales().add(principale);
		principale.setImagene(this);

		return principale;
	}

	public Principale removePrincipale(Principale principale) {
		getPrincipales().remove(principale);
		principale.setImagene(null);

		return principale;
	}

}