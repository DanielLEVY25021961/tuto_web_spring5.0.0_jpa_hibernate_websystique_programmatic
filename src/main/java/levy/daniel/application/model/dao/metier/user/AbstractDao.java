package levy.daniel.application.model.dao.metier.user;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * class AbstractDao :<br/>
 * .<br/>
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
 * @param <T> : Type paramétré : Classe réelle d'un Objet métier.<br/>
 * @param <PK> : Type paramétré : type de l'ID en base d'un Objet métier 
 * (Long, Integer, String, ...).<br/>
 */
public abstract class AbstractDao<PK extends Serializable, T> {


	// ************************ATTRIBUTS************************************/
	

	/**
	 * persistentClass : Class<T> :<br/>
	 * Class de l'objet métier géré par le présent DAO.<br/>
	 */
	private final Class<T> persistentClass;
	
	

	/**
	 * entityManager : EntityManager :<br/>
	 * EntityManager.<br/>
	 */
	@PersistenceContext
	EntityManager entityManager;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(AbstractDao.class);

	
	// *************************METHODES************************************/
	
		
	 /**
	 * method CONSTRUCTEUR AbstractDao() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	@SuppressWarnings("unchecked")
	public AbstractDao(){
		
		this.persistentClass 
			= (Class<T>) ((ParameterizedType) 
					this.getClass().getGenericSuperclass())
			.getActualTypeArguments()[1];
		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________


	
	/**
	 * method getByKey(PK pKey) :<br/>
	 * Retourne un Objet métier de type paramétré T 
	 * via son ID en base.<br/>
	 * <br/>
	 *
	 * @param pKey : PK.<br/>
	 * @return : T : Objet métier.<br/>
	 */
	protected T getByKey(
			final PK pKey) {
		return this.entityManager.find(this.persistentClass, pKey);
	} // Fin de getByKey(...)._____________________________________________

	
	
	/**
	 * method persist(
	 * T pEntity) :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pEntity :  :  .<br/>
	 */
	protected void persist(
			final T pEntity) {
		this.entityManager.persist(pEntity);
	} // Fin de persist(...).______________________________________________

	
	
	/**
	 * method update(
	 * T pEntity) :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pEntity :  :  .<br/>
	 */
	protected void update(
			final T pEntity) {
		this.entityManager.merge(pEntity);
	} // Fin de update(...)._______________________________________________

	
	
	/**
	 * method delete(
	 * T pEntity) :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pEntity :  :  .<br/>
	 */
	protected void delete(
			final T pEntity) {
		this.entityManager.remove(pEntity);
	} // Fin de delete(...)._______________________________________________
	

	
	/**
	 * method getEntityManager() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @return :  :  .<br/>
	 */
	protected EntityManager getEntityManager(){
		return this.entityManager;
	} // Fin de getEntityManager().________________________________________


	
} // FIN DE LA CLASSE AbstractDao.-------------------------------------------
