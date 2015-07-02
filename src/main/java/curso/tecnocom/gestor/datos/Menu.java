package curso.tecnocom.gestor.datos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the Menu database table.
 * 
 */
@Entity
@NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer idMenuPadre;

	private String link;

	private int nivel;

	private String titulo;

	// bi-directional many-to-one association to Contenido
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idContenidos")
	private Contenido contenido;

	// bi-directional many-to-one association to Imagene
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idImagen")
	private Imagene imagene;

	// bi-directional many-to-one association to TipoMenu
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idTipoMenu")
	private TipoMenu tipoMenu;

	public Menu() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getIdMenuPadre() {
		return this.idMenuPadre;
	}

	public void setIdMenuPadre(int idMenuPadre) {
		this.idMenuPadre = idMenuPadre;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getNivel() {
		return this.nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Contenido getContenido() {
		return this.contenido;
	}

	public void setContenido(Contenido contenido) {
		this.contenido = contenido;
	}

	public Imagene getImagene() {
		return this.imagene;
	}

	public void setImagene(Imagene imagene) {
		this.imagene = imagene;
	}

	public TipoMenu getTipoMenu() {
		return this.tipoMenu;
	}

	public void setTipoMenu(TipoMenu tipoMenu) {
		this.tipoMenu = tipoMenu;
	}

	@Override
	public boolean equals(Object obj) {
		try {
			Menu i = (Menu) obj;
			return this.getId().equals(i.getId());
		} catch (Exception e) {
			return false;
		}
	}

}