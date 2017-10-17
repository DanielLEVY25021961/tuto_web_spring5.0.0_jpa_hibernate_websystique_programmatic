package levy.daniel.application.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import levy.daniel.application.model.metier.user.UserProfile;
import levy.daniel.application.model.services.metier.user.IUserProfileService;


/**
 * A converter class used in views to map id's to actual userProfile objects.
 */
/**
 * class RoleToUserProfileConverter :<br/>
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
@Component
public class RoleToUserProfileConverter implements Converter<Object, UserProfile>{

	/**
	 * userProfileService : IUserProfileService :<br/>
	 * .<br/>
	 */
	@Autowired
	IUserProfileService userProfileService;

	
	/**
	 * Gets UserProfile by Id
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserProfile convert(
			final Object pElement) {
		
		Integer id = Integer.parseInt((String)pElement);
		UserProfile profile= this.userProfileService.findById(id);
		
		System.out.println("Profile : "+profile);
		
		return profile;
		
	} // Fin de convert(...).______________________________________________
	
	
	
} // FIN DE LA CLASSE RoleToUserProfileConverter.----------------------------