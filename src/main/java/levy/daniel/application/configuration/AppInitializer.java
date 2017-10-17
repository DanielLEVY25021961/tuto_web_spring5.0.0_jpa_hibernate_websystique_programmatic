package levy.daniel.application.configuration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * class AppInitializer :<br/>
 * EQUIVALENT DU WEB.XML.<br/>
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
public class AppInitializer 
	extends AbstractAnnotationConfigDispatcherServletInitializer {
	

	// ************************ATTRIBUTS************************************/

	/**
	 * CLASSE_APPINITIALIZER : String :<br/>
	 * "Classe AppInitializer".<br/>
	 */
	public static final String CLASSE_APPINITIALIZER 
		= "Classe AppInitializer";

	
	/**
	 * METHODE_GETROOTCONFIGCLASSES : String :<br/>
	 * "méthode getRootConfigClasses()".<br/>
	 */
	public static final String METHODE_GETROOTCONFIGCLASSES 
		= "méthode getRootConfigClasses()";
	
	
	/**
	 * METHODE_GETSERVLETCONFIGCLASSES : String :<br/>
	 * "méthode getServletConfigClasses()".<br/>
	 */
	public static final String METHODE_GETSERVLETCONFIGCLASSES 
		= "méthode getServletConfigClasses()";

	
	/**
	 * METHODE_GETSERVLETSMAPPING : String :<br/>
	 * "méthode getServletMappings()".<br/>
	 */
	public static final String METHODE_GETSERVLETSMAPPING 
		= "méthode getServletMappings()";
	
	/**
	 * SEPARATEUR_MOINS_AERE : String :<br/>
	 * " - ".<br/>
	 */
	public static final String SEPARATEUR_MOINS_AERE = " - ";
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(AppInitializer.class);

	
	// *************************METHODES************************************/
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		final String message1 
			= CLASSE_APPINITIALIZER 
			+ SEPARATEUR_MOINS_AERE 
			+ METHODE_GETROOTCONFIGCLASSES 
			+ SEPARATEUR_MOINS_AERE 
			+ "La classe de Configuration du Context ROOT sera null";
		
		System.out.println(message1);
		LOG.fatal(message1);
		
		return new Class[] { };
		
	} // Fin de getRootConfigClasses().____________________________________
 
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		final String message1 
			= CLASSE_APPINITIALIZER 
			+ SEPARATEUR_MOINS_AERE 
			+ METHODE_GETSERVLETCONFIGCLASSES 
			+ SEPARATEUR_MOINS_AERE 
			+ "La classe de Configuration du Context Servlet sera ApplicationContext";
		
		System.out.println(message1);
		LOG.fatal(message1);
		
		return new Class[] { ApplicationContext.class };
		
	} // Fin de getServletConfigClasses()._________________________________
 
	
	
	/**
	 * {@inheritDoc}
	 * <br/>
	 * SPECIFIE QUE LE CONTROLLEUR SPRING DispatcherServlet 
	 * n'interceptera que les URL préfixées par /app/.<br/>
	 */
	@Override
	protected String[] getServletMappings() {
		
		final String message1 
		= CLASSE_APPINITIALIZER 
		+ SEPARATEUR_MOINS_AERE 
		+ METHODE_GETSERVLETSMAPPING
		+ SEPARATEUR_MOINS_AERE 
		+ "Le CONTROLLER DISPATCHERSERVLET de SPRING n'interceptera que les URL /app/*";
	
		System.out.println(message1);
		LOG.fatal(message1);
	
		return new String[] { "/app/*" };
		
	} // Fin de getServletMappings().______________________________________

	
	
} // FIN DE LA CLASSE AppInitializer.--------------------------------------
