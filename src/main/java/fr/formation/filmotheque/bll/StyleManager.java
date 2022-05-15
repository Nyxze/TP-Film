package fr.formation.filmotheque.bll;

import java.util.List;

import fr.formation.filmotheque.dal.DaoFactory;
import fr.formation.filmotheque.dal.FilmDAO;
import fr.formation.filmotheque.dal.StyleDAO;
import fr.formation.filmotheque.entity.Film;
import fr.formation.filmotheque.entity.Style;
import fr.formation.filmotheque.exception.BeanException;

public class StyleManager {

	private StyleDAO styleDAO;

	public StyleManager() {

		styleDAO = DaoFactory.getStyleDao();
	}

	public List<Style> listerStyle() throws BeanException {

		return styleDAO.findAll();
	}

	public void ajouterStyle(Style s) throws BeanException {

		if (styleDAO.findOne(s) == null)
			styleDAO.add(s);

	}

	public void modifierStyle(Style s) throws BeanException {
		styleDAO.update(s);

	}

	public void supprimerStyle(String str) throws BeanException {
		styleDAO.delete(str);

	}
	public Style trouverStyle(Style s) throws BeanException {

		return styleDAO.findOne(s);
	}

}
