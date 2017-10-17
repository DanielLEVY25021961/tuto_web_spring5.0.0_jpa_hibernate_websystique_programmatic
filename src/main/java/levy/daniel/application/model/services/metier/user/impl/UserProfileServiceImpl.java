package levy.daniel.application.model.services.metier.user.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import levy.daniel.application.model.dao.metier.user.IUserProfileDao;
import levy.daniel.application.model.metier.user.UserProfile;
import levy.daniel.application.model.services.metier.user.IUserProfileService;



/**
 * class UserProfileServiceImpl :<br/>
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
@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements IUserProfileService{

	// ************************ATTRIBUTS************************************/
	
	/**
	 * dao : IUserProfileDao :<br/>
	 * .<br/>
	 */
	@Autowired
	IUserProfileDao dao;

	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(UserProfileServiceImpl.class);


	// *************************METHODES************************************/
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserProfile findById(
			final Integer pId) {
		return this.dao.findById(pId);
	} // Fin de findById(...)._____________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserProfile findByType(
			final String pType){
		return this.dao.findByType(pType);
	} // Fin de findByType(...).___________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UserProfile> findAll() {
		return this.dao.findAll();
	} // Fin de findAll()._________________________________________________
	
	
	
} // FIN DE LA CLASSE UserProfileServiceImpl.--------------------------------
