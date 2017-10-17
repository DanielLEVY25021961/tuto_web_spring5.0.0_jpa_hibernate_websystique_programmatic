package levy.daniel.application.model.metier.user;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



/**
 * class User :<br/>
 * Modélisation d'un Internaute.<br/>
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
@Table(name="USERS")
public class User implements Serializable{

	// ************************ATTRIBUTS************************************/
	
	/**
	 * serialVersionUID : long :<br/>
	 * .<br/>
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * id : Integer :<br/>
	 * .<br/>
	 */
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", unique=true, nullable=false)
	private Integer id;

	
	/**
	 * ssoId : String :<br/>
	 * Login du User.<br/>
	 */
	@Column(name="SSO_ID", unique=true, nullable=false)
	private String ssoId;

	
	/**
	 * password : String :<br/>
	 * Mot de passe du User.<br/>
	 */
	@Column(name="PASSWORD", nullable=false)
	private String password;

	
	/**
	 * firstName : String :<br/>
	 * prénom du User.<br/>
	 */
	@Column(name="FIRST_NAME", nullable=false)
	private String firstName;

	
	/**
	 * lastName : String :<br/>
	 * Nom du User.<br/>
	 */
	@Column(name="LAST_NAME", nullable=false)
	private String lastName;

	
	/**
	 * email : String :<br/>
	 * email du User.<br/>
	 */
	@Column(name="EMAIL", nullable=false)
	private String email;


	/**
	 * userProfiles : Set&lt;UserProfile&gt; :<br/>
	 * ensemble des Profils d'un User 
	 * (Administrateur, Gestionaire, ...).<br/>
	 */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "USERS_USER_PROFILE", 
             joinColumns = { @JoinColumn(name = "USER_ID") }, 
             inverseJoinColumns = { @JoinColumn(name = "USER_PROFILE_ID") })
	private Set<UserProfile> userProfiles = new HashSet<UserProfile>();


	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(User.class);

	
	// *************************METHODES************************************/
	
	
	
	 /**
	 * method CONSTRUCTEUR User() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public User() {
		this(null, null, null, null, null, null, null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	

	 /**
	 * method CONSTRUCTEUR User(
	 * CONSTRUCTEUR COMPLET) :<br/>
	 * CONSTRUCTEUR COMPLET.<br/>
	 * SANS ID en base.<br/>
	 * SANS userProfiles.<br/>
	 * <br/>
	 *
	 * @param pSsoId : String : Login.<br/>
	 * @param pPassword : String : Mot de passe.<br/>
	 * @param pFirstName : String : prénom.<br/>
	 * @param pLastName : String : nom.<br/>
	 * @param pEmail : String : email.<br/>
	 */
	public User(
			final String pSsoId, final String pPassword
				, final String pFirstName, final String pLastName
				, final String pEmail) {
		
		this(null
				, pSsoId, pPassword
				, pFirstName, pLastName
				, pEmail
				, null);
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR User(
	 * CONSTRUCTEUR COMPLET BASE) :<br/>
	 * CONSTRUCTEUR COMPLET BASE.<br/>
	 * AVEC ID en base.<br/>
	 * SANS userProfiles.<br/>
	 * <br/>
	 *
	 * @param pId : Integer : ID en base.<br/>
	 * @param pSsoId : String : Login.<br/>
	 * @param pPassword : String : Mot de passe.<br/>
	 * @param pFirstName : String : prénom.<br/>
	 * @param pLastName : String : nom.<br/>
	 * @param pEmail : String : email.<br/>
	 */
	public User(
			final Integer pId
				, final String pSsoId, final String pPassword
				, final String pFirstName, final String pLastName
				, final String pEmail) {
		
		this(pId, pSsoId, pPassword, pFirstName, pLastName, pEmail, null);
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________

	
	
	 /**
	 * method CONSTRUCTEUR User(
	 * CONSTRUCTEUR COMPLET BASE) :<br/>
	 * CONSTRUCTEUR COMPLET BASE.<br/>
	 * AVEC ID en base.<br/>
	 * AVEC userProfiles.<br/>
	 * <br/>
	 *
	 * @param pId : Integer : ID en base.<br/>
	 * @param pSsoId : String : Login.<br/>
	 * @param pPassword : String : Mot de passe.<br/>
	 * @param pFirstName : String : prénom.<br/>
	 * @param pLastName : String : nom.<br/>
	 * @param pEmail : String : email.<br/>
	 * @param pUserProfiles : Set&lt;UserProfile&gt; : 
	 * ensemble des profils d'un User.<br/>
	 */
	public User(
			final Integer pId
				, final String pSsoId, final String pPassword
				, final String pFirstName, final String pLastName
				, final String pEmail
				, final Set<UserProfile> pUserProfiles) {
		super();
		this.id = pId;
		this.ssoId = pSsoId;
		this.password = pPassword;
		this.firstName = pFirstName;
		this.lastName = pLastName;
		this.email = pEmail;
		this.userProfiles = pUserProfiles;
		
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
				+ ((this.ssoId == null) ? 0 : this.ssoId.hashCode());
		
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
			
		if (!(pObj instanceof User)) {
			return false;
		}
			
		final User other = (User) pObj;
		
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}				
		} else if (!this.id.equals(other.id)) {
			return false;
		}
			
		if (this.ssoId == null) {
			if (other.ssoId != null) {
				return false;
			}				
		} else if (!this.ssoId.equals(other.ssoId)) {
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
		
		builder.append("User [");
		if (this.id != null) {
			builder.append("id=");
			builder.append(this.id);
			builder.append(", ");
		}
		if (this.ssoId != null) {
			builder.append("ssoId=");
			builder.append(this.ssoId);
			builder.append(", ");
		}
		if (this.password != null) {
			builder.append("password=");
			builder.append(this.password);
			builder.append(", ");
		}
		if (this.firstName != null) {
			builder.append("firstName=");
			builder.append(this.firstName);
			builder.append(", ");
		}
		if (this.lastName != null) {
			builder.append("lastName=");
			builder.append(this.lastName);
			builder.append(", ");
		}
		if (this.email != null) {
			builder.append("email=");
			builder.append(this.email);
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
	 * method getSsoId() :<br/>
	 * Getter du Login du User.<br/>
	 * <br/>
	 *
	 * @return : String : Login (ssoId).<br/>
	 */
	public String getSsoId() {
		return this.ssoId;
	} // Fin de getSsoId().________________________________________________
	

	
	/**
	 * method setSsoId(
	 * String pSsoId) :<br/>
	 * Setter du Login du User.<br/>
	 * <br/>
	 *
	 * @param pSsoId : String : valeur à passer à ssoId.<br/>
	 */
	public void setSsoId(
			final String pSsoId) {
		this.ssoId = pSsoId;
	} // Fin de setSsoId(...)._____________________________________________

	
	
	/**
	 * method getPassword() :<br/>
	 * Getter du Mot de passe du User.<br/>
	 * <br/>
	 *
	 * @return : String : password.<br/>
	 */
	public String getPassword() {
		return this.password;
	} // Fin de getPassword()._____________________________________________

	
	
	/**
	 * method setPassword(
	 * String pPassword) :<br/>
	 * Setter du Mot de passe du User.<br/>
	 * <br/>
	 *
	 * @param pPassword : String : valeur à passer à password.<br/>
	 */
	public void setPassword(
			final String pPassword) {
		this.password = pPassword;
	} // Fin de setPassword(...)._________________________________________

	
	
	/**
	 * method getFirstName() :<br/>
	 * Getter du prénom du User.<br/>
	 * <br/>
	 *
	 * @return : String : prénom.<br/>
	 */
	public String getFirstName() {
		return this.firstName;
	} // Fin de getFirstName().____________________________________________

	
		
	/**
	 * method setFirstName(
	 * String pFirstName) :<br/>
	 * Setter du prénom du User.<br/>
	 * <br/>
	 *
	 * @param pFirstName : String : valeur à passer à firstName.<br/>
	 */
	public void setFirstName(
			final String pFirstName) {
		this.firstName = pFirstName;
	} // Fin de setFirstName(...)._________________________________________

	
	
	/**
	 * method getLastName() :<br/>
	 * Getter du Nom du User.<br/>
	 * <br/>
	 *
	 * @return : String : nom.<br/>
	 */
	public String getLastName() {
		return this.lastName;
	} // Fin de getLastName()._____________________________________________

	
	
	/**
	 * method setLastName(
	 * String pLastName) :<br/>
	 * Setter du Nom du User.<br/>
	 * <br/>
	 *
	 * @param pLastName : String : valeur à passer à lastName.<br/>
	 */
	public void setLastName(
			final String pLastName) {
		this.lastName = pLastName;
	} // Fin de setLastName(...).__________________________________________

	
	
	/**
	 * method getEmail() :<br/>
	 * Getter du email du User.<br/>
	 * <br/>
	 *
	 * @return : String : email.<br/>
	 */
	public String getEmail() {
		return this.email;
	} // Fin de getEmail().________________________________________________

	
		
	/**
	 * method setEmail(
	 * String pEmail) :<br/>
	 * Setter du email du User.<br/>
	 * <br/>
	 *
	 * @param pEmail : String : valeur à passer à email.<br/>
	 */
	public void setEmail(
			final String pEmail) {
		this.email = pEmail;
	} // Fin de setEmail(...)._____________________________________________

	
	
	/**
	 * method getUserProfiles() :<br/>
	 * Getter de l'ensemble des Profils d'un User 
	 * (Administrateur, Gestionaire, ...).<br/>
	 * <br/>
	 *
	 * @return : Set&lt;UserProfile&gt; : 
	 * ensemble des Profils d'un User.<br/>
	 */
	public Set<UserProfile> getUserProfiles() {
		return this.userProfiles;
	} // Fin de getUserProfiles()._________________________________________

	
	
	/**
	 * method setUserProfiles() :<br/>
	 * Setter de l'ensemble des Profils d'un User 
	 * (Administrateur, Gestionaire, ...).<br/>
	 * <br/>
	 *
	 * @param pUserProfiles : Set&lt;UserProfile&gt; : 
	 * valeur à passer à userProfiles.<br/>
	 */
	public void setUserProfiles(
			final Set<UserProfile> pUserProfiles) {
		this.userProfiles = pUserProfiles;
	} // Fin de setUserProfiles(...).______________________________________


	
} // FIN DE LA CLASSE User.--------------------------------------------------
