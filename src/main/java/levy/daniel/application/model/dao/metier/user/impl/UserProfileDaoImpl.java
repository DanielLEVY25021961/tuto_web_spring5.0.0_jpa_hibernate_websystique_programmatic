package levy.daniel.application.model.dao.metier.user.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import levy.daniel.application.model.dao.metier.user.AbstractDao;
import levy.daniel.application.model.dao.metier.user.IUserProfileDao;
import levy.daniel.application.model.metier.user.UserProfile;




/**
 * class UserProfileDaoImpl :<br/>
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
@Repository("userProfileDao")
public class UserProfileDaoImpl 
	extends AbstractDao<Integer, UserProfile> 
							implements IUserProfileDao{

	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final UserProfile findById(
			final Integer pId) {
		return this.getByKey(pId);
	} // Fin de findById(...)._____________________________________________
	


	/**
	 * {@inheritDoc}
	 */
	@Override
	public final UserProfile findByType(
			final String pType) {

		try {
			
			final UserProfile userProfile 
				= (UserProfile) getEntityManager()
					.createQuery("SELECT p FROM UserProfile p WHERE p.type LIKE :type")
					.setParameter("type", pType)
					.getSingleResult();
			
			return userProfile;
			
		}
		catch (NoResultException ex) {
			return null;
		}
		
	} // Fin de findByType(...).___________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UserProfile> findAll(){
		
		List<UserProfile> userProfiles = getEntityManager()
				.createQuery("SELECT p FROM UserProfile p  ORDER BY p.type ASC")
				.getResultList();
		
		return userProfiles;
		
	} // Fin de findAll()._________________________________________________
	
	
	
} // FIN DE LA CLASSE UserProfileDaoImpl.------------------------------------
