package levy.daniel.application.configuration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * class JpaConfigurationTest :<br/>
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
public class JpaConfigurationTest {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(JpaConfigurationTest.class);
	

	// *************************METHODES************************************/

	
	 /**
	 * method CONSTRUCTEUR JpaConfigurationTest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public JpaConfigurationTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * method testConfiguration() :<br/>
	 * .<br/>
	 * <br/>
	 * :  :  .<br/>
	 */
//	@Test
//	public void testConfiguration() {
//
//		/* CHARGEMENT DES CLASSES DE CONFIGURATION DE SPRING 
//		 * pour les fournir au conteneur Spring. */
//		final AnnotationConfigApplicationContext  context 
//			= new AnnotationConfigApplicationContext();
//		
//		context.register(ApplicationContext.class, AppInitializer.class);
//		context.register(JpaConfiguration.class);
//		
//		context.refresh();
//		
//		
//		
//		final String nomApplication = context.getApplicationName();
//		
//		System.out.println("NOM DE L'APPLICATION" + nomApplication);
//		
//		final JpaConfiguration jpaConfiguration = new JpaConfiguration();
//		jpaConfiguration.dataSource();
//		
//		Environment environmentSpring = null;
//		String url = null;
//		
//		environmentSpring = jpaConfiguration.getEnvironment();
//		
//		if (environmentSpring != null) {
//			url = environmentSpring.getRequiredProperty("jdbc.url");
//			System.out.println(url);
//		}
//		else {
//			System.out.println("jpaConfiguration.getEnvironment() retourne null");
//		}
//		
//		context.close();
//		
//	} // Fin de testConfiguration()._______________________________________


} // FIN DE LA CLASSE JpaConfigurationTest.----------------------------------
