package levy.daniel.application.model.dao.metier.user;

import java.util.List;

import levy.daniel.application.model.metier.user.UserProfile;




/**
 * class IUserProfileDao :<br/>
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
 */
public interface IUserProfileDao {


	
	/**
	 * method findByType(
	 * String pType) :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pType
	 * @return :  :  .<br/>
	 */
	UserProfile findByType(String pType);


	
	/**
	 * method findById(
	 * Integer pId) :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pId
	 * @return :  :  .<br/>
	 */
	UserProfile findById(Integer pId);
	

	
	/**
	 * method findAll() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @return :  :  .<br/>
	 */
	List<UserProfile> findAll();

	
	
} // FIn DE L'INTERFACE IUserProfileDao.-------------------------------------
