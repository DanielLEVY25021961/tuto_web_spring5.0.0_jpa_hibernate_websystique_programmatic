package levy.daniel.application.model.dao.metier.user.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import levy.daniel.application.model.dao.metier.user.AbstractDao;
import levy.daniel.application.model.dao.metier.user.IUserDao;
import levy.daniel.application.model.metier.user.User;




/**
 * class UserDaoImpl :<br/>
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
@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements IUserDao {

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public User findById(Integer pId) {

		final User user = getByKey(pId);
		
		if(user!=null){
			initializeCollection(user.getUserProfiles());
		}
		
		return user;
		
	} // Fin de findById(...)._____________________________________________




	/**
	 * {@inheritDoc}
	 */
	@Override
	public User findBySSO(
			final String pSsoId) {

		try {
			final User user 
				= (User) getEntityManager()
				.createQuery("SELECT u FROM User u WHERE u.ssoId LIKE :ssoId")
					.setParameter("ssoId", pSsoId).getSingleResult();

			if (user != null) {
				initializeCollection(user.getUserProfiles());
			}
			
			return user;
		}
		catch (NoResultException ex) {
			return null;
		}
		
	} // Fin de findBySSO(...).____________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<User> findAllUsers() {
		
		final List<User> users = getEntityManager()
				.createQuery("SELECT u FROM User u ORDER BY u.firstName ASC")
				.getResultList();
		
		return users;
	} // Fin de findAllUsers().____________________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void save(
			final User pUser) {
		persist(pUser);
	} // Fin de save(...)._________________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteBySSO(
			final String pSsoId) {
		
		final User user = (User) getEntityManager()
				.createQuery("SELECT u FROM User u WHERE u.ssoId LIKE :ssoId")
				.setParameter("ssoId", pSsoId)
				.getSingleResult();
		
		delete(user);
		
	} // Fin de deleteBySSO(...).__________________________________________
	
	

	/**
	 * method initializeCollection(
	 * Collection<?> pCollection) :<br/>
	 * An alternative to Hibernate.initialize().<br/>
	 * <br/>
	 *
	 * @param pCollection :  :  .<br/>
	 */
	protected void initializeCollection(
			final Collection<?> pCollection) {
		
	    if(pCollection == null) {
	        return;
	    }
	    
	    pCollection.iterator().hasNext();
	    
	} // Fin de initializeCollection(...)._________________________________


	
} // FIN DE LA CLASSE UserDaoImpl.-------------------------------------------
