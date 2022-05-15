package fr.formation.filmotheque.dal;

public class DaoFactory {

	public static FilmDAO getFilmDao() {
		return new FilmDAOImpl();
	}

	public static StyleDAO getStyleDao() {
		return new StyleDAOImpl();
	}
}
