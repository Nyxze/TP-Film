package fr.formation.filmotheque.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String titre;
	private int year;

	@ManyToOne(cascade = CascadeType.ALL)
	private Realisateur realisateur;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Acteur> acteurs;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Style style;
	
	private boolean vue;
	
	public boolean isVue() {
		return vue;
	}

	public void setVue(boolean vue) {
		this.vue = vue;
	}

	public Film() {
		
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}
 
	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	public Realisateur getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(Realisateur realisateur) {
		this.realisateur = realisateur;
	}

	public List<Acteur> getActeurs() {
		return acteurs;
	}

	public void setActeurs(List<Acteur> acteurs) {
		this.acteurs = acteurs;
	}

	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", titre='" + getTitre() + "'" +
			", year='" + getYear() + "'" +
			", realisateur='" + getRealisateur() + "'" +
			", acteurs='" + getActeurs() + "'" +
			", style='" + getStyle() + "'" +
			", vue='" + isVue() + "'" +
			"}";
	}

}
