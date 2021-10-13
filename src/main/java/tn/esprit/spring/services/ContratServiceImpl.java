package tn.esprit.spring.services;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;

@Service
public class ContratServiceImpl implements IContratService {

	@Autowired
	ContratRepository ContratRepository;

	private static final Logger l = LogManager.getLogger(ContratServiceImpl.class);
 	 
	 
	
	@Override
	public List<Contrat> retrieveAllContracts() { 
		List<Contrat> Contrats = null; 
		
		//try {
		l.info("In Method retrieverAllContrats :");
		Contrats=(List<Contrat>) ContratRepository.findAll();
		l.debug("connexion a la DB Ok :");
		//int i = 1/0;
		//l.debug("Je viens de lancer la divsion. " + i);
		for(Contrat Contrat : Contrats){
			l.debug("Contrat :" + Contrat.getSalaire());
		}
		l.info("Out of Methode retrieverAllContrats with Success");
		//}
		/*catch (Exception e) { l.error("Erreur dans getAllPrducts() : " + e); }*/
		 
		return Contrats;
	}


	@Override
	public Contrat addContrat(Contrat u) {
		l.info("In of Methode addContrat:");
		Contrat u_saved = ContratRepository.save(u); 
		l.info("Out of Methode addContrat:");
		return u_saved; 
	}

	@Override 
	public Contrat updateContrat(Contrat u) { 
		l.info("In of Methode updateContrat:"); 
		Contrat u_saved = ContratRepository.save(u); 
		l.info("Out of Methode updateContrat:");
		return u_saved; 
	}

	@Override
	public void deleteContrat(String id) {
		l.info("In of Methode deleteContrat:");
		ContratRepository.deleteById(Long.parseLong(id)); 
		l.info("Out of Methode deleteContrat:");
	}

	@Override
	public Contrat retrieveContrat(String id) {
		l.info("In of Methode retrieveContrat:");
		//Contrat u =  ContratRepository.findById(Long.parseLong(id)).orElse(null);
		Contrat u =  ContratRepository.findById(Long.parseLong(id)).get(); 
		l.info("Out of Methode retrieveContrat:");
		return u; 
	}

}
