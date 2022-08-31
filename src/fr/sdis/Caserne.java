package fr.sdis;

import java.util.ArrayList;
import java.util.List;

public class Caserne {
	private List<Pompier> lesPompiers;

	public Caserne() {
		lesPompiers = new ArrayList<>();
	}

	public void appeler(String numero) {
		// TODO envoi SMS
	}

	/**
	 * Appelle une équipe de pompiers pour une intervention concernant la période
	 * passée en paramètre. Le paramètre “nbPompiers” représente le nombre de
	 * pompiers à solliciter. Si un nombre suffisant de pompiers ne peut pas être
	 * sollicité, une équipe incomplète sera appelée. Cette fonction modifie le
	 * statut des pompiers sélectionnés, les appelle sur leur téléphone et retourne
	 * le nombre de pompiers appelés.
	 * 
	 * @param unePeriode
	 * @param nbPompiers
	 * @return
	 */
	public int appelEquipe(Periode unePeriode, int nbPompiers) {
		List<Pompier> listepompier = unePeriode.selectEquipe(nbPompiers);

		for (Pompier pompier : listepompier) {
			pompier.missionner(unePeriode);
			this.appeler(pompier.getTel());

		}
		return listepompier.size();
	}
}
