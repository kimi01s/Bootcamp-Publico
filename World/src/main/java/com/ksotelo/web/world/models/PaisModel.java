package com.ksotelo.web.world.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="countries")
public class PaisModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String code;
	private String name;
	private String continent;
	private String region;
	private Double surface_area;
	private Integer indep_year;
	private Integer population;
	private Double life_expectancy;
	private Double gnp;
	private Double gnp_old;
	private String local_name;
	private String government_form;
	private String head_of_state;
	private Integer capital;
	private String code2;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public Double getSurface_area() {
		return surface_area;
	}
	public void setSurface_area(Double surface_area) {
		this.surface_area = surface_area;
	}
	public Integer getIndep_year() {
		return indep_year;
	}
	public void setIndep_year(Integer indep_year) {
		this.indep_year = indep_year;
	}
	public Integer getPopulation() {
		return population;
	}
	public void setPopulation(Integer population) {
		this.population = population;
	}
	public Double getLife_expectancy() {
		return life_expectancy;
	}
	public void setLife_expectancy(Double life_expectancy) {
		this.life_expectancy = life_expectancy;
	}
	public Double getGnp() {
		return gnp;
	}
	public void setGnp(Double gnp) {
		this.gnp = gnp;
	}
	public Double getGnp_old() {
		return gnp_old;
	}
	public void setGnp_old(Double gnp_old) {
		this.gnp_old = gnp_old;
	}
	public String getLocal_name() {
		return local_name;
	}
	public void setLocal_name(String local_name) {
		this.local_name = local_name;
	}
	public String getGovernment_form() {
		return government_form;
	}
	public void setGovernment_form(String government_form) {
		this.government_form = government_form;
	}
	public String getHead_of_state() {
		return head_of_state;
	}
	public void setHead_of_state(String head_of_state) {
		this.head_of_state = head_of_state;
	}
	public Integer getCapital() {
		return capital;
	}
	public void setCapital(Integer capital) {
		this.capital = capital;
	}
	public String getCode2() {
		return code2;
	}
	public void setCode2(String code2) {
		this.code2 = code2;
	}
	public PaisModel() {
	}
}
