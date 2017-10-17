package levy.daniel.application.model.dao.metier.user;

import java.util.List;

import levy.daniel.application.model.metier.user.User;




/**
 * class IUserDao :<br/>
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
public interface IUserDao {

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
	 * method save(
	 * User pUser) :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pUser :  :  .<br/>
	 */
	void save(User pUser);

	
	
	/**
	 * method deleteBySSO(
	 * String pSsoId) :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pSsoId :  :  .<br/>
	 */
	void deleteBySSO(String pSsoId);

	
	
	/**
	 * method findAllUsers() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @return :  :  .<br/>
	 */
	List<User> findAllUsers();

	

} // FIN DE L'INTERFACE IUserDao.--------------------------------------------

