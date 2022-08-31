package fr.sdis;

public class ProgTest {

	public static void main(String[] args) {
		Pompier unPompier = new Pompier("Marc DUPONT");
		try {
			unPompier.setTel("060102030");
		} catch (InvalidTelNumberException e) {
			System.out.println("Numéro de téléphone invalide (10 chiffres obligatoires)");
		} finally {
			System.out.println(unPompier);
		}

	}

}
