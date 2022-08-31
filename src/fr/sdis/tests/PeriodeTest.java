package fr.sdis.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
		Pompier p = new Pompier("jp D");
		assertFalse(periode.getEnMission().contains(p));
		periode.missionner(p);
		assertTrue(periode.getEnMission().contains(p));
		assertEquals('m', p.getStatut(periode));
		assertFalse(periode.getEnMission().contains(new Pompier("Martin")));
	}

	@Test
	void testSelectEquipe() {
		assertEquals(0, periode.selectEquipe(1).size());
		assertEquals(0, periode.selectEquipe(10).size());
		assertEquals(0, periode.selectEquipe(0).size());
		Pompier p = new Pompier("jp M");
		periode.affecter(p, 'm');
		assertEquals(0, periode.selectEquipe(1).size());
		periode.affecter(p, 't');
		assertEquals(1, periode.selectEquipe(1).size());
		Pompier p2 = new Pompier("jp X");
		periode.affecter(p2, 'd');
		assertEquals(1, periode.selectEquipe(1).size());
		assertEquals(2, periode.selectEquipe(2).size());
		assertEquals(2, periode.selectEquipe(3).size());
	}

}
