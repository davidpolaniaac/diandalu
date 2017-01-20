package co.com.bancolombia.diandalu.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/Calculador")
public class Calculador {
	@Path("Suma/{numero1}/{numero2}")
	@GET
	public String sumarValores(@PathParam ("numero1") int numero1, @PathParam ("numero2") int numero2) {
		// TODO Auto-generated method stub
		return numero1+numero2 + "";
	}

}
