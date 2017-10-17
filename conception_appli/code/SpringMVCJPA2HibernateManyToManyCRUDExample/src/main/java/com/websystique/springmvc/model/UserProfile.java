package levy.daniel.application.model.metier.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * class UserProfile :<br/>
 * Modélise les Profils des utilisateurs 
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
 * @since 15 oct. 2017
 *
 */
@Entity
@Table(name="USER_PROFILE")
public class UserProfile implements Serializable{

	// ************************ATTRIBUTS************************************/
	
	/**
	 * serialVersionUID : long :<br/>
	 * .<br/>
	 */
	private static final long serialVersionUID = 1L;
	

	/**
	 * id : Integer :<br/>
	 * ID en base.<br/>
	 */
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;	

	
	/**
	 * type : String :<br/>
	 * Type de profil (Administrateur, Gestionnaire, ...).<br/>
	 */
	@Column(name="TYPE", length=15, unique=true, nullable=false)
	private String type = UserProfileType.USER.getUserProfileType();
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(UserProfile.class);
	

	// *************************METHODES************************************/
	

	
	 /**
	 * method CONSTRUCTEUR UserProfile() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public UserProfile() {
		this(null, null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________


	
	 /**
	 * method CONSTRUCTEUR UserProfile(
	 * String pType) :<br/>
	 * CONSTRUCTEUR COMPLET.<br/>
	 * SANS id en base.<br/>
	 * <br/>
	 *
	 * @param pType : String : Type de profil 
	 * (Administrateur, Gestionnaire, ...).<br/>
	 */
	public UserProfile(
			final String pType) {
		
		this(null, pType);
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________

	
	
	 /**
	 * method CONSTRUCTEUR UserProfile(
	 * Integer pId
	 * , String pType) :<br/>
	 * CONSTRUCTEUR COMPLET BASE.<br/>
	 * AVEC id en base.<br/>
	 * <br/>
	 *
	 * @param pId : Integer : ID en base.<br/>
	 * @param pType : String : Type de profil 
	 * (Administrateur, Gestionnaire, ...).<br/>
	 */
	public UserProfile(
			final Integer pId
				, final String pType) {
		
		super();
		
		this.id = pId;
		this.type = pType;
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result 
				+ ((this.id == null) ? 0 : this.id.hashCode());
		result = prime * result 
				+ ((this.type == null) ? 0 : this.type.hashCode());
		
		return result;
		
	} // Fin de hashCode().________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(
			final Object pObj) {

		if (this == pObj) {
			return true;
		}
		
		if (pObj == null) {
			return false;
		}
		
		if (!(pObj instanceof UserProfile)) {
			return false;
		}
		
		final UserProfile other = (UserProfile) pObj;
		
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		}
		else if (!this.id.equals(other.id)) {
			return false;
		}
		
		if (this.type == null) {
			if (other.type != null) {
				return false;
			}
		}
		else if (!this.type.equals(other.type)) {
			return false;
		}
		
		return true;
		
	} // Fin de equals(...)._______________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {

		final StringBuilder builder = new StringBuilder();
		
		builder.append("UserProfile [");
		
		if (this.id != null) {
			builder.append("id=");
			builder.append(this.id);
			builder.append(", ");
		}
		if (this.type != null) {
			builder.append("type=");
			builder.append(this.type);
		}
		
		builder.append(']');
		
		return builder.toString();
		
	} // Fin de toString().________________________________________________



	/**
	 * method getId() :<br/>
	 * Getter de l'ID en base.<br/>
	 * <br/>
	 *
	 * @return id : Integer.<br/>
	 */
	public Integer getId() {
		return this.id;
	} // Fin de getId().___________________________________________________
	


	/**
	* method setId(
	* Integer pId) :<br/>
	* Setter de l'ID en base.<br/>
	* <br/>
	*
	* @param pId : Integer : valeur à passer à id.<br/>
	*/
	public void setId(
			final Integer pId) {
		this.id = pId;
	} // Fin de setId(...).________________________________________________



	/**
	 * method getType() :<br/>
	 * Getter du Type de profil (Administrateur, Gestionnaire, ...).<br/>
	 * <br/>
	 *
	 * @return : String : Type de profil.<br/>
	 */
	public String getType() {
		return this.type;
	} // Fin de getType()._________________________________________________

	
	
	/**
	 * method setType(
	 * String pType) :<br/>
	 * Setter du Type de profil (Administrateur, Gestionnaire, ...).<br/>
	 * <br/>
	 *
	 * @param pType : String : valeur à passer à type.<br/>
	 */
	public void setType(
			final String pType) {
		this.type = pType;
	} // Fin de setType(...).______________________________________________



} // FIN DE LA CLASSE UserProfile.-------------------------------------------
