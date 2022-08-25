package fr.sdis.tests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.sdis.Pompier;

class PompierTest {
	private Pompier pompier;

	@BeforeEach
	void setUp() throws Exception {
		pompier = new Pompier();
	}

	@Test
	void testGetIdentite() {
		pompier.setIdentite("JC HERON");
		assertEquals("JC HERON", pompier.getIdentite());

		pompier.setIdentite("JC HERON ");
		assertEquals("JC HERON", pompier.getIdentite());
	}

	@Test
	void testSetIdentite() {
		pompier.setIdentite("JC HERON");
		assertEquals("JC", pompier.getPrenom());
		assertEquals("HERON", pompier.getNom());

		pompier.setIdentite("JC HERON ZZ");
		assertEquals("JC", pompier.getPrenom());
		assertEquals("HERON ZZ", pompier.getNom());

		pompier.setIdentite("HERON");
		assertEquals("", pompier.getPrenom());
		assertEquals("HERON", pompier.getNom());

		pompier.setIdentite(" HERON");
		assertEquals("", pompier.getPrenom());
		assertEquals("HERON", pompier.getNom());

		pompier.setIdentite("JC ");
		assertEquals("", pompier.getPrenom());
		assertEquals("JC", pompier.getNom());
	}

	@Test
	void testGetTel() {
		pompier.setTel("0123654789");
		assertEquals("01 23 65 47 89", pompier.getTel());
	}

	@Test
	void testSetTel() {

		RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
			pompier.setTel(" 06325645135131899");
		});

		assertEquals("error", thrown.getMessage());

		RuntimeException thrown2 = assertThrows(RuntimeException.class, () -> {
			pompier.setTel(" 1");
		});

		assertEquals("error", thrown2.getMessage());

		// pompier.setTel(" 06325417899");
		// assertEquals("06 32 54 17 899", pompier.getTel());

		pompier.setTel(" 06.3 ...25 417 89");
		assertEquals("06 32 54 17 89", pompier.getTel());

		pompier.setTel(" 06-.3 ...25 417 89");
		assertEquals("06 32 54 17 89", pompier.getTel());

	}

}
