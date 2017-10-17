package levy.daniel.application.model.services.metier.user;

import java.util.List;

import levy.daniel.application.model.metier.user.User;



/**
 * class IUserService :<br/>
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
public interface IUserService {
	
	
	
	/**
	 * method findById(
	 * Integer pId) :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pId
	 * @return :  :  .<br/>
	 */
	User findById(Integer pId);

	
	
	/**
	 * method findBySSO(
	 * String pSsoId) :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pSsoId
	 * @return :  :  .<br/>
	 */
	User findBySSO(String pSsoId);

	
	
	/**
	 * method saveUser(
	 * User pUser) :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pUser :  :  .<br/>
	 */
	void saveUser(User pUser);

	
	
	/**
	 * method updateUser(
	 * User pUser) :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pUser :  :  .<br/>
	 */
	void updateUser(User pUser);

	
	
	/**
	 * method deleteUserBySSO(
	 * String pSsoId) :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pSsoId :  :  .<br/>
	 */
	void deleteUserBySSO(String pSsoId);

	
	
	/**
	 * method findAllUsers() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @return :  :  .<br/>
	 */
	List<User> findAllUsers(); 

	
	
	/**
	 * method isUserSSOUnique(
	 * Integer pId
	 * , String pSsoId) :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pId
	 * @param pSsoId
	 * @return :  :  .<br/>
	 */
	boolean isUserSSOUnique(Integer pId, String pSsoId);

	
	
} // FIN DE L'INTERFACE IUserService.--------------------------------------