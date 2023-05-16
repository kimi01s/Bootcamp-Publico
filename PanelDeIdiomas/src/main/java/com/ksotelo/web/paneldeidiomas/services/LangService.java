package com.ksotelo.web.paneldeidiomas.services;

import com.ksotelo.web.paneldeidiomas.models.LanguageModel;
import com.ksotelo.web.paneldeidiomas.repositories.LanguageRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class LangService {
	private final LanguageRepository langRepo;

	public LangService(LanguageRepository LanguageRepository) {
		this.langRepo = LanguageRepository;
	}

	// READ
	public List<LanguageModel> allLanguages() {
		return langRepo.findAll();
	}

	// encontrar un lenguaje por el id
	public LanguageModel findLangById(Long id) {
		Optional<LanguageModel> optionalLang = langRepo.findById(id);
		if (optionalLang.isPresent()) {
			return optionalLang.get();
		} else {
			return null;
		}
	}

	// CREATE
	public LanguageModel createLang(LanguageModel lang) {
		return langRepo.save(lang);
	}

	// UPDATE
	public LanguageModel updateLang(LanguageModel langModel) {
		LanguageModel actualizarLang = findLangById(langModel.getId());
		actualizarLang.setId(langModel.getId());
		actualizarLang.setName(langModel.getName());
		actualizarLang.setCreator(langModel.getCreator());
		actualizarLang.setCurrentVersion(langModel.getCurrentVersion());
		langRepo.save(actualizarLang);
		return actualizarLang;
	}

	// DELETE
	public void deleteLang(Long id) {
		Optional<LanguageModel> optionalLang = langRepo.findById(id);
		if (optionalLang.isPresent()) {
			langRepo.deleteById(id);
		}
	}
}
