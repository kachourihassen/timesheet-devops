package tn.esprit.spring.services;

 
 

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IEntrepriseService;


 

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class EntrepriseServiceImplTests {

	@Autowired
	IEntrepriseService et;


	private void testAddEntreprise() {
		et.addEntreprise(new Entreprise("ESPRIT_5SIM3", "5SIM3"));
		List<Entreprise> listEntreprises = et.retrieveAllEntreprises();
		Assertions.assertEquals(1, listEntreprises.size());
	}

	private void testRetrieveAllEntreprises() {
		List<Entreprise> listEntreprises = et.retrieveAllEntreprises();
		Assertions.assertEquals(1, listEntreprises.size());
	}

	
	private void testUpdateEntreprise() {
		List<Entreprise> listEntreprises = et.retrieveAllEntreprises();
		Entreprise e = listEntreprises.get(0);
		e.setName("ESPRIT1");
		et.updateEntreprise(e);
		listEntreprises = et.retrieveAllEntreprises();
		Assertions.assertEquals("ESPRIT1", listEntreprises.get(0).getName());
	}

	
	private void testDeleteEntreprise() {
		List<Entreprise> listEntreprises = et.retrieveAllEntreprises();
		et.deleteEntreprise(listEntreprises.get(0).getId());
		listEntreprises = et.retrieveAllEntreprises();
		Assertions.assertEquals(0, listEntreprises.size());
	}
	
//	@Test
//	public void testEntreprise(){
//		testAddEntreprise();
//		testRetrieveAllEntreprises();
//		testUpdateEntreprise();
//		testDeleteEntreprise();
//	}
	private static final Logger L = LogManager.getLogger(EntrepriseServiceImplTests.class);
	@Test
	public void testEntreprise(){
		try{
			L.info("In testEntreprise()");
			testAddEntreprise();
			testRetrieveAllEntreprises();
			testUpdateEntreprise();
			testDeleteEntreprise();
			 L.info("Out of testEntreprise()");
		}catch(Exception e){
		L.error("Out of testEntreprise() wirh Errors : " + e);
		}
	}
	
}