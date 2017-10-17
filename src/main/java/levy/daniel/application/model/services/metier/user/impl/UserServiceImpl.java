package levy.daniel.application.model.services.metier.user.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import levy.daniel.application.model.dao.metier.user.IUserDao;
import levy.daniel.application.model.metier.user.User;
import levy.daniel.application.model.services.metier.user.IUserService;



/**
 * class UserServiceImpl :<br/>
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
@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {


	// ************************ATTRIBUTS************************************/
	
	
	/**
	 * dao : IUserDao :<br/>
	 * .<br/>
	 */
	@Autowired
	private IUserDao dao;

	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(UserServiceImpl.class);


	
	// *************************METHODES************************************/
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User findById(
			final Integer pId) {
		return this.dao.findById(pId);
	} // Fin de findById(...)._____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public User findBySSO(
			final String pSsoId) {

		final User user = this.dao.findBySSO(pSsoId);
		return user;
		
	} // Fin de findBySSO(...).____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveUser(
			final User pUser) {

		this.dao.save(pUser);
		
	} // Fin de saveUser(...)._____________________________________________



	/*
	 * Since the method is running with Transaction, No need to call
	 * hibernate update explicitly. Just fetch the entity from db and update
	 * it with proper values within transaction. It will be updated in db
	 * once transaction ends.
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateUser(
			final User pUser) {

		final User entity = this.dao.findById(pUser.getId());
		
		if (entity != null) {
			entity.setSsoId(pUser.getSsoId());
			entity.setPassword(pUser.getPassword());
			entity.setFirstName(pUser.getFirstName());
			entity.setLastName(pUser.getLastName());
			entity.setEmail(pUser.getEmail());
			entity.setUserProfiles(pUser.getUserProfiles());
		}
		
	} // Fin de updateUser(...).___________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteUserBySSO(
			final String pSsoId) {

		this.dao.deleteBySSO(pSsoId);
		
	} // Fin de deleteUserBySSO(...).______________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<User> findAllUsers() {

		return this.dao.findAllUsers();
		
	} // Fin de findAllUsers().____________________________________________
	



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isUserSSOUnique(
			final Integer pId
				, final String pSsoId) {

		final User user = findBySSO(pSsoId);
		
		return (user == null || ((pId != null) && (user.getId() == pId)));
		
	} // Fin de isUserSSOUnique(...).______________________________________
	
	

} // FIN DE LA CLASSE UserServiceImpl.---------------------------------------
