package tn.esprit.spring.services;
import java.util.List;

import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.EntrepriseRepository;


@Service
public class EntrepriseServiceImpl implements IEntrepriseService {
	
	
	@Autowired
	EntrepriseRepository entrepriseRepository;
	
	private static final Logger l = LogManager.getLogger(EntrepriseServiceImpl.class);

	@Override
	public List<Entreprise> retrieveAllEntreprises(){
		List<Entreprise> entreprises = null;
		try {
			
			l.info("In method retrieveAllEntreprises :"); 
			entreprises = (List<Entreprise>) entrepriseRepository.findAll();  
			l.debug("connexion à la DB Ok:");
			for (Entreprise entreprise : entreprises) {
				l.info("for empty");
			} 
			l.info("Out of method retrieveAllEntreprises with success");
		}catch (Exception e) {
			l.error("");
		}

		return entreprises;
	}


	@Override
	public Entreprise addEntreprise(Entreprise e) {
		Entreprise u_saved = entrepriseRepository.save(e); 
		return u_saved; 
	}

	@Override 
	public Entreprise updateEntreprise(Entreprise e) {  
		return entrepriseRepository.save(e); 
	}

	@Override
	public void deleteEntreprise(int id) {
		l.info("In deleteEntreprise(): ");
		entrepriseRepository.deleteById(id);
		l.info("Out deleteEntreprise()");
	}
	@Override
	public Entreprise retrieveEntreprise(int id) {	
		Entreprise e =  entrepriseRepository.findById(id).orElse(null);
		return e; 
	}

}
