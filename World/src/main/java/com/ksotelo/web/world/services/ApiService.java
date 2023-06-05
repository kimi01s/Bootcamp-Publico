package com.ksotelo.web.world.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksotelo.web.world.repositories.PaisRepo;

@Service
public class ApiService {

	@Autowired
	private PaisRepo paisRepo;

	// todos los países que hablan Sloveno
	public List<Object[]> paisesHablaSloveno() {
		return paisRepo.paisesHablaSloveno();
	}

	// total de ciudades de cada país
	public List<Object[]> totalCiudadesPorPais() {
		return paisRepo.totalCiudadesPorPais();
	}

	// todas las ciudades en México con una población mayor a 500.000
	public List<Object[]> mexicoMayorQuinientos() {
		return paisRepo.mexicoMayorQuinientos();
	}

	// lenguajes en cada país con un porcentaje mayor al 89%
	public List<Object[]> paisesMayor() {
		return paisRepo.paisesMayor();
	}

	// todos los países con un superficie de área inferior a 501 y una población
	// mayor a 100.000
	public List<Object[]> paisesMayorArea() {
		return paisRepo.paisesMayorArea();
	}

	// todos los países que tienen solo Constitutional Monarchy (Monarquía) y
	// una superficie de área mayor a 200 y una expectativa de vida superior a los
	// 75 años
	public List<Object[]> paisesSoloMonarchyAreaYExpectativa() {
		return paisRepo.paisesSoloMonarchyAreaYExpectativa();
	}

	// todas las ciudades de Argentina dentro del distrito de
	// Buenos Aires y que tengan una población mayor a 500.000
	public List<Object[]> todasCiudadesArgBuenosAiresMayor() {
		return paisRepo.todasCiudadesArgBuenosAiresMayor();
	}
	
	
	public List<Object[]> sumaPaisesRegion() {
		return paisRepo.sumaPaisesRegion();
	}
}
