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
import fr.formation.filmotheque.bll.StyleManager;
import fr.formation.filmotheque.entity.Film;
import fr.formation.filmotheque.entity.Style;
import fr.formation.filmotheque.exception.BeanException;

@Path("/style")
@Singleton
public class StyleRs {

	private StyleManager styleManager;

	public StyleRs() {
		styleManager = new StyleManager();
		System.out.println("Test");
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Style> getStyles() {
		try {
			List<Style> liste = styleManager.listerStyle();
			return liste;
		} catch (BeanException e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void postStyle(Style s) {
		try {
			System.out.println("Ajout de " + s);
			styleManager.ajouterStyle(s);
		} catch (BeanException e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public void putStyle(Style s, @PathParam("id") String str) {
		try {
			s.setLabel(str);
			styleManager.modifierStyle(s);
		} catch (BeanException e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}

	@DELETE
	@Path("/{id}")
	public void deleteStyle(@PathParam("id") String str) {
		try {
			styleManager.supprimerStyle(str);
		} catch (BeanException e) {
			throw new WebApplicationException(Response.Status.CONFLICT);
		}
	}

	

}
