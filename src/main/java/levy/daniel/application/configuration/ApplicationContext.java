package levy.daniel.application.configuration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import levy.daniel.application.converter.RoleToUserProfileConverter;




/**
 * class ApplicationContext :<br/>
 * CLASSE LUE AU DEMARRAGE DE L'APPLICATION.<br/>
 * Classe encapsulant l'équivalent du applicationContext.xml.<br/>
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
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "levy.daniel.application")
@Import(JpaConfiguration.class)
public class ApplicationContext extends WebMvcConfigurationSupport {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * CLASSE_APPLICATION_CONTEXT : String :<br/>
	 * "Classe ApplicationContext".<br/>
	 */
	public static final String CLASSE_APPLICATION_CONTEXT 
		= "Classe ApplicationContext";

	
	/**
	 * METHODE_CONFIGURE_VIEW_RESOLVERS : String :<br/>
	 * "méthode configureViewResolvers(
	 * ViewResolverRegistry pRegistry)".<br/>
	 */
	public static final String METHODE_CONFIGURE_VIEW_RESOLVERS 
		= "méthode configureViewResolvers("
				+ "ViewResolverRegistry pRegistry)";
	

	/**
	 * METHODE_ADD_RESOURCEHANDLERS : String :<br/>
	 * "méthode addResourceHandlers(
	 * ResourceHandlerRegistry pRegistry)".<br/>
	 */
	public static final String METHODE_ADD_RESOURCEHANDLERS 
		= "méthode addResourceHandlers("
				+ "ResourceHandlerRegistry pRegistry)";
	
	
	/**
	 * METHODE_MESSAGESOURCE : String :<br/>
	 * "méthode messageSource()".<br/>
	 */
	public static final String METHODE_MESSAGESOURCE 
		= "méthode messageSource()";
	
	
	/**
	 * SEPARATEUR_MOINS_AERE : String :<br/>
	 * " - ".<br/>
	 */
	public static final String SEPARATEUR_MOINS_AERE = " - ";
	

	/**
	 * roleToUserProfileConverter : RoleToUserProfileConverter :<br/>
	 * .<br/>
	 */
	@Autowired
	private RoleToUserProfileConverter roleToUserProfileConverter;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(ApplicationContext.class);

	
	// *************************METHODES************************************/
	
	

	/**
     * Configure ViewResolvers to deliver preferred views.
     */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void configureViewResolvers(
			final ViewResolverRegistry pRegistry) {
				
		/* InternalResourceViewResolver*/
		/* Indique où chercher les ressources (jsp, ...) 
		 * contrôlées par l'appli sous le contexte webapp. 
		 * ici dans le dossier « /WEB-INF/vues/ avec 
		 * l'extension « .jsp »*/
		final InternalResourceViewResolver viewResolver 
			= new InternalResourceViewResolver();
		
		final String message1 
		= CLASSE_APPLICATION_CONTEXT 
		+ SEPARATEUR_MOINS_AERE
		+ METHODE_CONFIGURE_VIEW_RESOLVERS
		+ SEPARATEUR_MOINS_AERE
		+ "J'ai instancié un Bean InternalResourceViewResolver";
		
		System.out.println(message1);
		LOG.info(message1);
		
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/vues/");
		viewResolver.setSuffix(".jsp");
		
		final String message2 
		= CLASSE_APPLICATION_CONTEXT 
		+ SEPARATEUR_MOINS_AERE
		+ METHODE_CONFIGURE_VIEW_RESOLVERS
		+ SEPARATEUR_MOINS_AERE
		+ "Le View Resolver sait que les jsp sont dans /WEB-INF/vues/ et qu'elles ont le suffixe jsp";
		
		System.out.println(message2);
		LOG.info(message2);
		
		pRegistry.viewResolver(viewResolver);
		
		final String message3 
		= CLASSE_APPLICATION_CONTEXT 
		+ SEPARATEUR_MOINS_AERE
		+ METHODE_CONFIGURE_VIEW_RESOLVERS
		+ SEPARATEUR_MOINS_AERE
		+ "Le Registre a enregistré le viewResolver";
		
		System.out.println(message3);
		LOG.info(message3);
		
	} // Fin de configureViewResolvers(...)._______________________________

	
	
	/**
     * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
     */
    /**
     * {@inheritDoc}
     */
    @Override
    public void addResourceHandlers(
    		final ResourceHandlerRegistry pRegistry) {
    	
        pRegistry.addResourceHandler("/static/**")
        	.addResourceLocations("/static/");
        
        final String message1 
		= CLASSE_APPLICATION_CONTEXT 
		+ SEPARATEUR_MOINS_AERE
		+ METHODE_ADD_RESOURCEHANDLERS
		+ SEPARATEUR_MOINS_AERE
		+ "Le Registre a enregistré la localisation des ressources statiques";
		
		System.out.println(message1);
		LOG.info(message1);
		
    } // Fin de addResourceHandlers(...).__________________________________
 
    
    
    /**
     * Configure Converter to be used.
     * In our example, we need a converter to convert string values[Roles] to UserProfiles in newUser.jsp
     */
    /**
     * {@inheritDoc}
     */
    @Override
    public void addFormatters(
    		final FormatterRegistry pRegistry) {
        pRegistry.addConverter(this.roleToUserProfileConverter);
    } // Fin de addFormatters(...).________________________________________
	

  
    /**
     * method messageSource() :<br/>
     * <ul>
     * <li>EQUIVALENT DU BEAN ReloadableResourceBundleMessageSource 
     * du <b>applicationContext.xml</b>.</li>
     * <li>Retourne le ResourceBundle encapsulant 
     * messages.properties.</li> 
     * </ul>
     *
     * @return : MessageSource.<br/>
     */
    @Bean
	public MessageSource messageSource() {
    	
	    final ResourceBundleMessageSource messageSource 
	    	= new ResourceBundleMessageSource();
	    
	    messageSource.setBasename("messages");
	    
	    final String messageBase 
	    	= CLASSE_APPLICATION_CONTEXT 
	    	+ SEPARATEUR_MOINS_AERE 
	    	+ METHODE_MESSAGESOURCE 
	    	+ SEPARATEUR_MOINS_AERE;
	    
	    final String message1 
	    	= messageBase + "BEAN MessageSource instancié";
	    
	    System.out.println(message1);
	    LOG.info(message1);
	    
	    return messageSource;
	    
	} // Fin de messageSource().___________________________________________
    
    
 
    
    /**Optional. It's only required when handling '.' in @PathVariables which otherwise ignore everything after last '.' in @PathVaidables argument.
     * It's a known bug in Spring [https://jira.spring.io/browse/SPR-6164], still present in Spring 4.3.0.
     * This is a workaround for this issue.
     */  
    /**
     * {@inheritDoc}
     */
    @Override
    public void configurePathMatch(
    		final PathMatchConfigurer pMatcher) {
        pMatcher.setUseRegisteredSuffixPatternMatch(true);
    } // Fin de configurePathMatch(...).___________________________________
    
    
    
} // FIN DE LA CLASSE ApplicationContext.---------------------------------------------

