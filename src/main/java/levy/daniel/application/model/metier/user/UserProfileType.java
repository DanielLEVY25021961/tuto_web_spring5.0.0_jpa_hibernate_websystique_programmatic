package levy.daniel.application.model.metier.user;

/**
 * class UserProfileType :<br/>
 * Enumération des types de profils 
 * (Administrateur, Gestionnaire, ...).<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 16 oct. 2017
 *
 */
public enum UserProfileType {
	
	/**
	 * USER : UserProfileType :<br/>
	 * .<br/>
	 */
	USER("USER"),
	
	
	/**
	 * DBA : UserProfileType :<br/>
	 * .<br/>
	 */
	DBA("DBA"),
	
	
	/**
	 * ADMIN : UserProfileType :<br/>
	 * .<br/>
	 */
	ADMIN("ADMIN");
	
	/**
	 * userProfileType : String :<br/>
	 * Type de Profil
	 * (Administrateur, Gestionnaire, ...).<br/>
	 */
	String userProfileType;
	
	
	
	// *************************METHODES************************************/
	
	
	
	/**
	 * method getUserProfileType() :<br/>
	 * Getter du Type de Profil 
	 * (Administrateur, Gestionnaire, ...).<br/>
	 * <br/>
	 *
	 * @return : String : userProfileType.<br/>
	 */
	public String getUserProfileType(){
		return this.userProfileType;
	} // Fin de getUserProfileType().______________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR UserProfileType(
	 * String pUserProfileType) :<br/>
	 * Setter du Type de Profil 
	 * (Administrateur, Gestionnaire, ...).<br/>
	 * <br/>
	 *
	 * @param pUserProfileType : String : 
	 * valeur à passer à this.userProfileType.<br/>
	 */
	private UserProfileType(
			final String pUserProfileType){
		this.userProfileType = pUserProfileType;
	} // Fin de UserProfileType(...).______________________________________


	
} // FIN DE L'ENUMERATION UserProfileType.-----------------------------------
