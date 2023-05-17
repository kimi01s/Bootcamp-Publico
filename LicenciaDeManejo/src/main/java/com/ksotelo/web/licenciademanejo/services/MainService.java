package com.ksotelo.web.licenciademanejo.services;

import com.ksotelo.web.licenciademanejo.models.LicenseModel;
import com.ksotelo.web.licenciademanejo.models.PersonModel;
import com.ksotelo.web.licenciademanejo.repositories.LicenseRepository;
import com.ksotelo.web.licenciademanejo.repositories.PersonRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {
	@Autowired
	private PersonRepository personRepo;
	@Autowired
	private LicenseRepository licenseRepo;

	// CRUD PERSONAS

	// crea a la persona
	public List<PersonModel> todosUsuarios() {
		return personRepo.findAll();
	}

	public PersonModel createPerson(PersonModel p) {
		return personRepo.save(p);
	}

	public PersonModel findById(Long id) {
		return personRepo.findById(id).orElse(null);
	}

	public List<PersonModel> findByNoLicense() {
		return personRepo.findByNoLicense();
	}

	// CRUD LICENCIAS
	public int generarLicencia() {
		LicenseModel lic = licenseRepo.findTopByOrderByNumberDesc();
		int numMayor = 000001;
		System.out.println(lic);
		if (lic == null) {
			return numMayor;
		} else {
			numMayor = lic.getNumber();
			numMayor++;
			return numMayor;
		}
	}

	public LicenseModel createLicense(LicenseModel l) {
		System.out.println(this.generarLicencia());
		l.setNumber(this.generarLicencia());
		return licenseRepo.save(l);
	}

	public int dato() {
		return 0;
	}

}