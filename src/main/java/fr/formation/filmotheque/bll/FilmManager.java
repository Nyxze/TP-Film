package fr.formation.filmotheque.bll;

import java.util.List;

import fr.formation.filmotheque.dal.DaoFactory;
import fr.formation.filmotheque.dal.FilmDAO;
import fr.formation.filmotheque.entity.Film;
import fr.formation.filmotheque.exception.BeanException;

public class FilmManager {

	private FilmDAO filmDAO;

	public FilmManager() {

		filmDAO = DaoFactory.getFilmDao();
	}

	public void ajouterFilm(Film f) throws BeanException {
		
		
		
		filmDAO.add(f);
	}

	public void deleteFilmParId(int id) throws BeanException {

		filmDAO.delete(id);
	}

	public void modifierFilm(Film f) throws BeanException {

		filmDAO.update(f);
	}

	public List<Film> listerFilm() throws BeanException {

		return filmDAO.findAll();
	}

	public Film trouverUnFilmParId(int id) throws BeanException {

		return filmDAO.findById(id);
	}

}
