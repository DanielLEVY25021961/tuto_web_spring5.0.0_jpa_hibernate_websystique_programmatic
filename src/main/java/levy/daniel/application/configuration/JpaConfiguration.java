package levy.daniel.application.configuration;

import java.util.Properties;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;



/**
 * class JpaConfiguration :<br/>
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
@Configuration
@EnableTransactionManagement
@PropertySource(value = { "classpath:application.properties" }
, ignoreResourceNotFound=true)
public class JpaConfiguration {

	// ************************ATTRIBUTS************************************/

	/**
	 * CLASSE_JPA_CONFIGURATION : String :<br/>
	 * "Classe JpaConfiguration".<br/>
	 */
	public static final String CLASSE_JPA_CONFIGURATION 
		= "Classe JpaConfiguration";

	
	/**
	 * METHODE_ENTITYMANAGER_FACTORY : String :<br/>
	 * "méthode entityManagerFactory()".<br/>
	 */
	public static final String METHODE_ENTITYMANAGER_FACTORY 
		= "méthode entityManagerFactory()";
	
	
	/**
	 * METHODE_DATASOURCE : String :<br/>
	 * "méthode dataSource()".<br/>
	 */
	public static final String METHODE_DATASOURCE 
		= "méthode dataSource()";
	
	
	/**
	 * METHODE_ORM_PROPERTIES : String :<br/>
	 * "méthode ormProperties()".<br/>
	 */
	public static final String METHODE_ORM_PROPERTIES 
		= "méthode ormProperties()";
	
	
	/**
	 * METHODE_JPA_VENDOR_ADAPTER : String :<br/>
	 * "méthode jpaVendorAdapter()".<br/>
	 */
	public static final String METHODE_JPA_VENDOR_ADAPTER 
		= "méthode jpaVendorAdapter()";
	
	
	/**
	 * METHODE_TRANSACTION_MANAGER : String :<br/>
	 * "méthode transactionManager(
	 * EntityManagerFactory pEntityManagerFactory)".<br/>
	 */
	public static final String METHODE_TRANSACTION_MANAGER 
	= "méthode transactionManager"
			+ "(EntityManagerFactory pEntityManagerFactory)";
	
	
	/**
	 * SEPARATEUR_MOINS_AERE : String :<br/>
	 * " - ".<br/>
	 */
	public static final String SEPARATEUR_MOINS_AERE = " - ";
	

	/**
	 * environment : Environment :<br/>
	 * .<br/>
	 */
	@Autowired
	private Environment environment;

		
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(JpaConfiguration.class);

	
	// *************************METHODES************************************/


	/**
	 * method entityManagerFactory() :<br/>
	 * <ul>
	 * <li>EQUIVALENT DU BEAN LocalContainerEntityManagerFactoryBean 
	 * dans <b>applicationContext.xml</b>.</li>
	 * <li>Instancie et retourne la LocalContainerEntityManagerFactoryBean 
	 * qui permet d'instancier les EntityManager</li>
	 * <ul>
	 * <li>Spécifie la DataSource à utiliser.</li>
	 * <li>Spécifie les packages à scanner.</li>
	 * <li>Spécifie l'ORM (Hibernate).</li>
	 * <li>Spécifie le paramétrage de l'ORM (Hibernate).</li>
	 * </ul>
	 * </ul>
	 *
	 * @return LocalContainerEntityManagerFactoryBean
	 * 
	 * @throws NamingException
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() 
			throws NamingException {
		
		final LocalContainerEntityManagerFactoryBean factoryBean 
			= new LocalContainerEntityManagerFactoryBean();
		
		final String messageBase 
			= CLASSE_JPA_CONFIGURATION 
			+ SEPARATEUR_MOINS_AERE 
			+ METHODE_ENTITYMANAGER_FACTORY 
			+ SEPARATEUR_MOINS_AERE;
		
		factoryBean.setDataSource(dataSource());
		
		final String message1 
			= messageBase + "DataSource passée à la EntityManagerFactoryBean";
		
		System.out.println(message1);
		LOG.info(message1);
		
		factoryBean.setPackagesToScan(new String[] { "levy.daniel.application.model" });
		
		final String message2 
		= messageBase + "Packages contenant les classes annotées passés à la EntityManagerFactoryBean";
	
		System.out.println(message2);
		LOG.info(message2);
		
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
		
		final String message3 
		= messageBase + "Vendor ORM Hibernate passé à la EntityManagerFactoryBean";
	
		System.out.println(message3);
		LOG.info(message3);

		factoryBean.setJpaProperties(ormProperties());
		
		final String message4 
		= messageBase + "Paramétrage d'Hibernate passé à la EntityManagerFactoryBean";
	
		System.out.println(message4);
		LOG.info(message4);
		
		return factoryBean;
		
	} // Fin de entityManagerFactory().____________________________________
	

	
	/**
	 * method dataSource() :<br/>
	 * <ul>
	 * <li>EQUIVALENT DU /webapp/META-INF/<b>context.xml</b>.</li>
	 * <li>Instancie et retourne la DataSource encapsulant la BD.</li>
	 * <li>Lit les valeurs dans application.properties.</li>
	 * <ul>
	 * <li>Lit le Driver jdbc à utiliser pour la connexion.</li>
	 * <li>lit l'URL de connexion comme par exemple :
	 * jdbc:postgresql://localhost:5432/base-tutoriel-websystique</li>
	 * <li>lit le username.</li>
	 * <li>lit le password.</li>
	 * <li>lit les propriétés de connexion (maxIdle, ...).</li>
	 * </ul>
	 * </ul>
	 *
	 * @return : DataSource.<br/>
	 */
	@Bean
	public DataSource dataSource() {
		
		final DriverManagerDataSource dataSource 
			= new DriverManagerDataSource();
		
		dataSource.setDriverClassName(this.environment.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(this.environment.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(this.environment.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(this.environment.getRequiredProperty("jdbc.password"));

		final Properties connectionProperties = new Properties();
		
		connectionProperties.put("maxActive"
				, this.environment.getRequiredProperty("maxActive"));		
		connectionProperties.put("maxIdle"
				, this.environment.getRequiredProperty("maxIdle"));
		connectionProperties.put("maxWait"
				, this.environment.getRequiredProperty("maxWait"));
		connectionProperties.put("removeAbandoned"
				, this.environment.getRequiredProperty("removeAbandoned"));
		connectionProperties.put("removeAbandonedTimeout"
				, this.environment.getRequiredProperty("removeAbandonedTimeout"));
		connectionProperties.put("logAbandoned"
				, this.environment.getRequiredProperty("logAbandoned"));
		
		dataSource.setConnectionProperties(connectionProperties);
		
		final String messageBase 
		= CLASSE_JPA_CONFIGURATION 
		+ SEPARATEUR_MOINS_AERE 
		+ METHODE_DATASOURCE
		+ SEPARATEUR_MOINS_AERE;
		
		final String message1 
			= messageBase + "DataSource instanciée et paramétrée";
		
		System.out.println(message1);
		LOG.info(message1);
		
		return dataSource;
		
	} // Fin de dataSource().______________________________________________
	
	
	
	/**
	 * method ormProperties() :<br/>
	 * <ul>
	 * <li>EQUIVALENT DU /META-INF/<b>persistence.xml</b>.</li>
	 * <li>Retourne les propriétés de paramétrage 
	 * de l'ORM (Hibernate).</li>
	 * <li>(Properties) lues dans application.properties.</li>
	 * <ul>
	 * <li>hibernate.dialect</li>
	 * <li>hibernate.show_sql</li>
	 * <li>hibernate.format_sql</li>
	 * <li>hibernate.use_sql_comments</li>
	 * <li>hibernate.generate_statistics</li>
	 * <li>cache.provider_class</li>
	 * <li>hibernate.hbm2ddl.auto</li>
	 * </ul>
	 * </ul>
	 *
	 * @return : java.util.Properties.<br/>
	 */
	private Properties ormProperties() {
		
		final Properties properties = new Properties();
		
		properties.put("hibernate.dialect"
				, this.environment.getRequiredProperty("hibernate.dialect"));		
		properties.put("hibernate.show_sql"
				, this.environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql"
				, this.environment.getRequiredProperty("hibernate.format_sql"));
		properties.put("hibernate.use_sql_comments"
				, this.environment.getRequiredProperty("hibernate.use_sql_comments"));
		properties.put("hibernate.generate_statistics"
				, this.environment.getRequiredProperty("hibernate.generate_statistics"));
		properties.put("cache.provider_class"
				, this.environment.getRequiredProperty("cache.provider_class"));
		properties.put("hibernate.hbm2ddl.auto"
				, this.environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		
		final String messageBase 
		= CLASSE_JPA_CONFIGURATION 
		+ SEPARATEUR_MOINS_AERE 
		+ METHODE_ORM_PROPERTIES
		+ SEPARATEUR_MOINS_AERE;
		
		final String message1 
			= messageBase 
			+ "Propriétés de connexion à la base passées "
			+ "au Properties de l'ORM";
		
		System.out.println(message1);
		LOG.info(message1);
		
		return properties;
		
	} // Fin de ormProperties().___________________________________________
	
	

	/**
	 * method jpaVendorAdapter() :<br/>
	 * <ul>
	 * <li>Retourne l'adaptateur JPA pour l'ORM choisi (Hibernate).</li>
	 * <li>EQUIVALENT DU PROVIDER dans le <b>persistence.xml</b>.</li>
	 * </ul>
	 *
	 * @return : JpaVendorAdapter.<br/>
	 */
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		
		final HibernateJpaVendorAdapter hibernateJpaVendorAdapter 
			= new HibernateJpaVendorAdapter();
		
		final String messageBase 
		= CLASSE_JPA_CONFIGURATION 
		+ SEPARATEUR_MOINS_AERE 
		+ METHODE_JPA_VENDOR_ADAPTER
		+ SEPARATEUR_MOINS_AERE;
		
		final String message1 
			= messageBase 
			+ "Bean JpaVendorAdapter signalant l'utilisation"
			+ " d'Hibernate instancié";
		
		System.out.println(message1);
		LOG.info(message1);
		
		return hibernateJpaVendorAdapter;
		
	} // Fin de jpaVendorAdapter().________________________________________
	
	

	/**
	 * method transactionManager(
	 * EntityManagerFactory pEntityManagerFactory) :<br/>
	 * <ul>
	 * <li>EQUIVALENT DU BEAN JpaTransactionManager du 
	 * <b>applicationContext.xml</b>.</li>
	 * <li>Instancie et retourne un JpaTransactionManager.</li>
	 * </ul>
	 *
	 * @param pEntityManagerFactory : EntityManagerFactory
	 * 
	 * @return : PlatformTransactionManager.<br/>
	 */
	@Bean
	@Autowired
	public PlatformTransactionManager transactionManager(
			final EntityManagerFactory pEntityManagerFactory) {
		
		final JpaTransactionManager txManager 
			= new JpaTransactionManager();
		
		txManager.setEntityManagerFactory(pEntityManagerFactory);
		
		final String messageBase 
		= CLASSE_JPA_CONFIGURATION 
		+ SEPARATEUR_MOINS_AERE 
		+ METHODE_TRANSACTION_MANAGER
		+ SEPARATEUR_MOINS_AERE;
		
		final String message1 
			= messageBase 
			+ "Bean JpaTransactionManager gérant les transactions"
			+ " d'Hibernate instancié (@Autowired)";
		
		System.out.println(message1);
		LOG.info(message1);

		
		return txManager;
		
	} // Fin de transactionManager(...).___________________________________

	

} // FIN DE LA CLASSE JpaConfiguration.--------------------------------------
