package fr.formation.filmotheque.api;

import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import fr.formation.filmotheque.bll.FilmManager;
import fr.formation.filmotheque.entity.Film;
import fr.formation.filmotheque.exception.BeanException;

@Path("/film")
@Singleton
public class FilmRs {

	private FilmManager filmManager;

	public FilmRs() {
		filmManager = new FilmManager();
	
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Film> getFilms() {
		try {
			List<Film> liste = filmManager.listerFilm();
			return liste;
		} catch (BeanException e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void postFilm(Film f) {
		try {
			filmManager.ajouterFilm(f);
		} catch (BeanException e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public void putFilm(Film f, @PathParam("id") int id) {
		try {
			f.setId(id);
			filmManager.modifierFilm(f);
		} catch (BeanException e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}

	@DELETE
	@Path("/{id}")
	public void deleteFilm(@PathParam("id") int id) {
		try {
			filmManager.deleteFilmParId(id);
		} catch (BeanException e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Film getFilm(@PathParam("id") int id) {
		try {
			Film f = filmManager.trouverUnFilmParId(id);
			return f;
		} catch (BeanException e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}

}
