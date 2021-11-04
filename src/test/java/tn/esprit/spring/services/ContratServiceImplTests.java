package tn.esprit.spring.services;

 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.IContratService;;

@SpringBootTest
class ContratServiceImplTest  {


	@Autowired
	IContratService us;
	@Test
	public void testRetrieveAllContrats() {
	List<Contrat> listContrats = us.retrieveAllContracts();
	Assertions.assertEquals(0, listContrats.size());
	}
	public void testAddContrat() throws ParseException{
		/*SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		Contrat u = new Contrat("hassen1","hassen1",d,);
		Contrat ContratAdded = us.addContrat(u);
		Assertions.assertEquals(u.getSalaire(), ContratAdded.getSalaire());*/
		
	}
	public void testModifyContrat() throws ParseException{
		/*SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		Contrat u = new Contrat(5L,"hassen1zzzz","hassen1",d, );
		Contrat Contratupdated = us.addContrat(u);
		Assertions.assertEquals(u.getSalaire(), Contratupdated.getSalaire());*/
		
	}
	public void testDeleteContrat(){
		/*us.deleteContrat("3");
		Assertions.assertNull(us.retrieveContrat("3"));*/
	}
	public void testRetrieveContrat(){
		/*Contrat ContratRetrieved = us.retrieveContrat("3");
		Assertions.assertEquals(1l, ContratRetrieved.getSalair().longValue());*/
	}
	private static final Logger L = LogManager.getLogger(ContratServiceImplTest.class);
	
	@Test
	public void testAll(){
		try{
			L.info("In testAll()");
			 testRetrieveAllContrats();
			 testAddContrat();
			 testModifyContrat();
			 testDeleteContrat();
			 testRetrieveContrat();
			 L.info("Out of testAll()");
		}catch(Exception e){
		L.error("Out of testAll() wirh Errors : " + e);
		}
	}
	
}
