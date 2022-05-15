package fr.formation.filmotheque.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Style {

	@Id
	private String label;

	public Style() {

	}
	public Style(String str) {
		label = str;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "Style [label=" + label + "]";
	}

}
