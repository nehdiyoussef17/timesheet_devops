package tn.esprit.spring.services;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IEntrepriseService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)

 class EntrepriseServiceImplTest {@Autowired
	IEntrepriseService es;

	@Test
	@Order(1)
	 void testAddEntreprise() {
		es.addEntreprise(new Entreprise("las3ed", "ESPRIT"));
		List<Entreprise> listEntreprises = es.retrieveAllEntreprises();
		Assertions.assertEquals(2, listEntreprises.size());
	}

	@Test
	@Order(2)
	 void testRetrieveAllEntreprises() {
		List<Entreprise> listEntreprises = es.retrieveAllEntreprises();
		Assertions.assertEquals(2, listEntreprises.size());
	}

	@Test
	@Order(3)
	 void testUpdateEntreprise() {
		List<Entreprise> listEntreprises = es.retrieveAllEntreprises();
		Entreprise e = listEntreprises.get(0);
		e.setName("updatelas3ed");
		es.updateEntreprise(e);
		listEntreprises = es.retrieveAllEntreprises();
		Assertions.assertEquals("updatelas3ed", listEntreprises.get(0).getName());
	}

	@Test
	@Order(4)
	 void testDeleteEntreprise() {
		List<Entreprise> listEntreprises = es.retrieveAllEntreprises();
		es.deleteEntreprise(listEntreprises.get(0).getId());
		listEntreprises = es.retrieveAllEntreprises();
		Assertions.assertEquals(1, listEntreprises.size());
	}
	

}