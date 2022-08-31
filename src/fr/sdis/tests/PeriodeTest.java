package fr.sdis.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.sdis.Periode;
import fr.sdis.Pompier;

class PeriodeTest {
	private Periode periode;

	@BeforeEach
	void setUp() throws Exception {
		periode = new Periode();
	}

	@Test
	void testGetStatut() {
		//
		periode.affecter(new Pompier("Marc DUPONT"), 'm');
		assertEquals(periode.getStatut(new Pompier("Marc DUPONT")), 'm');

		periode.affecter(new Pompier("Maurice DUPONT"), 't');
		assertEquals(periode.getStatut(new Pompier("Maurice DUPONT")), 't');

		periode.affecter(new Pompier("jp DUPONT"), 'd');
		assertEquals(periode.getStatut(new Pompier("jp DUPONT")), 'd');
	}

	@Test
	void testMissionner() {
		fail("Not yet implemented");
	}

	@Test
	void testSelectEquipe() {
		fail("Not yet implemented");
	}

}
