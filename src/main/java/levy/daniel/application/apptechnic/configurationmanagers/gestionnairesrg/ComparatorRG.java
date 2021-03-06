package levy.daniel.application.apptechnic.configurationmanagers.gestionnairesrg;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * class ComparatorRG :<br/>
 * Comparator pour classer les RG par ordre croissant de numéro de RG.<br/>
 * RG_INTERRO_VILLE_04<br/>
 * RG_INTERRO_NBREJOURS_05<br/>
 * ...<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * Expression régulière, Regex, RegEx, <br/>
 * Groupe capturant de chiffres, capture de groupe, capturer,<br/>
 * détecter chiffres,<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 27 sept. 2017
 *
 */
public class ComparatorRG implements Comparator<String> {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(ComparatorRG.class);
	

	// *************************METHODES************************************/
	

	
	 /**
	 * method CONSTRUCTEUR ComparatorRG() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public ComparatorRG() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int compare(final String pO1, final String pO2) {
		
		final Integer int01 = this.extraireNumero(pO1);
		final Integer int02 = this.extraireNumero(pO2);

		if (int01 == null) {
			
			if (int02 != null) {
				return +1;
			}
			
			return 0;
			
		} else if (int02 == null){
			return -1;
		}
		
		final int compare = int01.compareTo(int02);
		
		return compare;
		
	} // Fin de compare(...).______________________________________________
	

	
	/**
	 * method extraireNumero(
	 * String pString) :<br/>
	 * <ul>
	 * <li>Extrait le numéro dans le nom d'une RG 
	 * (5 pour RG_INTERRO_NBREJOURS_05).</li>
	 * </ul>
	 * retourne null si pString == null.<br/>
	 * retourne null si aucun numéro n'est trouvé.<br/>
	 * <br/>
	 *
	 * @param pString : RG dont il faut extraire le numéro.<br/>
	 * 
	 * @return : Integer.<br/>
	 */
	private Integer extraireNumero(
			final String pString) {
		
		/* retourne null si pString == null. */
		if (pString == null) {
			return null;
		}
		
		/* Groupe capturant de chiffres (05, 107, ...). */
		final String patternString = "(\\d+)";
		
		/* Instanciation d'un Pattern. */
		final Pattern pattern = Pattern.compile(patternString);
		
		/* Instanciation d'un moteur de recherche Matcher. */
		final Matcher matcher = pattern.matcher(pString);
		
		/* Recherche du Pattern. */
		final boolean trouve = matcher.find();
		
		String resultatString = null;
		Integer resultat = null;
		
		if (trouve) {
			
			resultatString = matcher.group(1);
			
			resultat = Integer.valueOf(resultatString);
			
		}
				
		return resultat;
		
	} // Fin de extraireNumeroFin(...).____________________________________

	

} // FIN DE LA CLASSE ComparatorRG.------------------------------------------
