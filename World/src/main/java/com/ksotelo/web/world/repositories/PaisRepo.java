package com.ksotelo.web.world.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ksotelo.web.world.models.PaisModel;

@Repository
public interface PaisRepo extends CrudRepository<PaisModel, Long> {

	//todos los países que hablan Sloveno
	@Query(value = "select name, language, percentage from countries "
			+ "join languages ON countries.id = languages.country_id "
			+ "where language = 'Slovene' order by percentage DESC;", nativeQuery = true)
	List<Object[]> paisesHablaSloveno();
	
	//total de ciudades de cada país
	@Query(value="SELECT countries.name, count(*) as ciudadesTotales FROM cities "
			+ "JOIN countries on cities.country_id = countries.id "
			+ "GROUP BY countries.name order by ciudadesTotales DESC;", nativeQuery=true)
	List<Object[]> totalCiudadesPorPais();
	
	//todas las ciudades en México con una población mayor a 500.000
	@Query(value="select * from cities where country_code = 'MEX' && population > 500000 "
			+ "order by population desc;", nativeQuery=true)
	List<Object[]> mexicoMayorQuinientos();
	
	
	//lenguajes en cada país con un porcentaje mayor al 89%
	@Query(value="select countries.name, languages.language, languages.percentage "
			+ "from countries JOIN languages ON countries.id = languages.country_id "
			+ "ORDER BY languages.percentage DESC;", nativeQuery=true)
	List<Object[]> paisesMayor();
	
	//todos los países con un superficie de área inferior a 501 y una población mayor a 100.000
	@Query(value="select name, surface_area, population from countries where surface_area < 501 && population > 100000;", nativeQuery=true)
	List<Object[]> paisesMayorArea();
	
	//todos los países que tienen solo Constitutional Monarchy (Monarquía) y 
	//una superficie de área mayor a 200 y una expectativa de vida superior a los 75 años
	@Query(value="select name, government_form, capital, life_expectancy from countries "
			+ "where government_form LIKE 'Constitutional Monarchy' && life_expectancy >75;", 
			nativeQuery=true)
	List<Object[]> paisesSoloMonarchyAreaYExpectativa();
	
	//todas las ciudades de Argentina dentro del distrito de 
	//Buenos Aires y que tengan una población mayor a 500.000
	
	@Query (value="select countries.name, cities.name, cities.district, cities.population "
			+ "from countries JOIN cities on countries.code = cities.country_code "
			+ "where code = 'ARG' && cities.population > 500000 && "
			+ "cities.district = 'Buenos Aires' ORDER BY cities.population DESC;", 
			nativeQuery=true)
	List<Object[]> todasCiudadesArgBuenosAiresMayor();
	
	// sumar el número de países en cada región
	@Query (value="SELECT countries.region, count(*) as PaisesTotales FROM countries "
			+ "GROUP BY countries.region order by PaisesTotales DESC;", 
			nativeQuery=true)
	List<Object[]> sumaPaisesRegion();
	
	
}
