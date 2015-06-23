package curso.tecnocom.gestor.datos;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * The persistent class for the tipoMenu database table.
 * 
 */
@Entity
@NamedQuery(name = "TipoMenu.findAll", query = "SELECT t FROM TipoMenu t")
public class TipoMenu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String descripcion;

	// bi-directional many-to-one association to Menu
	@OneToMany(mappedBy = "tipoMenu")
	private Set<Menu> menus;

	public TipoMenu() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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
		menus.setTipoMenu(this);

		return menus;
	}

	public Menu removeMenus(Menu menus) {
		getMenus().remove(menus);
		menus.setTipoMenu(null);

		return menus;
	}

	@Override
	public boolean equals(Object obj) {
		try {
			TipoMenu i = (TipoMenu) obj;
			return this.getId().equals(i.getId());
		} catch (Exception e) {
			return false;
		}
	}

}