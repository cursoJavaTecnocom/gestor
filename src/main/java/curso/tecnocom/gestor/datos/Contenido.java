package curso.tecnocom.gestor.datos;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the contenidos database table.
 * 
 */
@Entity
@Table(name = "contenidos")
@NamedQuery(name = "Contenido.findAll", query = "SELECT c FROM Contenido c")
public class Contenido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Lob
	private String contenido;

	private String descripcion;

	// bi-directional many-to-one association to Menu
	@OneToMany(mappedBy = "contenido")
	private Set<Menu> menus;

	// bi-directional many-to-one association to Destacado
	@OneToMany(mappedBy = "contenido")
	private Set<Destacado> destacados;

	// bi-directional many-to-one association to Noticia
	@OneToMany(mappedBy = "contenido")
	private Set<Noticia> noticias;

	// bi-directional many-to-one association to Principale
	@OneToMany(mappedBy = "contenido")
	private Set<Principale> principales;

	public Contenido() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContenido() {
		return this.contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Menu> getMenus() {
		return this.menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}

	public Menu addMenus(Menu menus) {
		getMenus().add(menus);
		menus.setContenido(this);

		return menus;
	}

	public Menu removeMenus(Menu menus) {
		getMenus().remove(menus);
		menus.setContenido(null);

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
		destacado.setContenido(this);

		return destacado;
	}

	public Destacado removeDestacado(Destacado destacado) {
		getDestacados().remove(destacado);
		destacado.setContenido(null);

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
		noticia.setContenido(this);

		return noticia;
	}

	public Noticia removeNoticia(Noticia noticia) {
		getNoticias().remove(noticia);
		noticia.setContenido(null);

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
		principale.setContenido(this);

		return principale;
	}

	public Principale removePrincipale(Principale principale) {
		getPrincipales().remove(principale);
		principale.setContenido(null);

		return principale;
	}

	@Override
	public boolean equals(Object obj) {
		try {
			Contenido i = (Contenido) obj;
			return this.getId().equals(i.getId());
		} catch (Exception e) {
			return false;
		}
	}

}