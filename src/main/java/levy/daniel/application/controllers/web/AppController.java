package levy.daniel.application.controllers.web;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import levy.daniel.application.model.metier.user.User;
import levy.daniel.application.model.metier.user.UserProfile;
import levy.daniel.application.model.services.metier.user.IUserProfileService;
import levy.daniel.application.model.services.metier.user.IUserService;




/**
 * class AppController :<br/>
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
@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController {

	
	/**
	 * userService : IUserService :<br/>
	 * .<br/>
	 */
	@Autowired
	IUserService userService;

	
	/**
	 * userProfileService : IUserProfileService :<br/>
	 * .<br/>
	 */
	@Autowired
	IUserProfileService userProfileService;
	
	
	@Autowired
	MessageSource messageSource;

	
	
	
	/**
	 * method allerVersIndex() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @return :  :  .<br/>
	 */
	@RequestMapping(value="/app/index")
	public String allerVersIndex() {
		return "index";
	}
	
	
	/**
	 * This method will list all existing users.
	 */
	/**
	 * method listUsers() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pModel
	 * @return :  :  .<br/>
	 */
//	@RequestMapping(value = { "/", "/app/list" }, method = RequestMethod.GET)
	@RequestMapping(value = { "/app/list" }, method = RequestMethod.GET)
	public String listUsers(
			final ModelMap pModel) {

		final List<User> users = this.userService.findAllUsers();
		pModel.addAttribute("users", users);
		return "/metier/user/userslist";
		
	} // Fin de listUsers(...).____________________________________________
	
	

	/**
	 * This method will provide the medium to add a new user.
	 */
	/**
	 * method newUser() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pModel
	 * @return :  :  .<br/>
	 */
	@RequestMapping(value = { "/app/newuser" }, method = RequestMethod.GET)
	public String newUser(
			final ModelMap pModel) {
		
		final User user = new User();
		pModel.addAttribute("user", user);
		pModel.addAttribute("edit", false);
		
		return "/metier/user/registration";
		
	} // Fin de newUser(...).______________________________________________
	
	

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	/**
	 * method saveUser() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pUser
	 * @param pResult
	 * @param pModel
	 * @return :  :  .<br/>
	 */
	@RequestMapping(value = { "/app/newuser" }, method = RequestMethod.POST)
	public String saveUser(@Valid final User pUser
			, final BindingResult pResult
			, final ModelMap pModel) {

		if (pResult.hasErrors()) {
			return "/metier/user/registration";
		}

		/*
		 * Preferred way to achieve uniqueness of field [sso] should be
		 * implementing custom @Unique annotation and applying it on field
		 * [sso] of Model class [User].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that
		 * you can fill custom errors outside the validation framework as
		 * well while still using internationalized messages.
		 * 
		 */
		if (!this.userService.isUserSSOUnique(pUser.getId(), pUser.getSsoId())) {
			FieldError ssoError = new FieldError("user", "ssoId"
					, this.messageSource.getMessage("non.unique.ssoId",
					new String[] { pUser.getSsoId() }, Locale.getDefault()));
			
			pResult.addError(ssoError);
			
			return "/metier/user/registration";
		}

		this.userService.saveUser(pUser);

		pModel.addAttribute("success",
				"User " + pUser.getFirstName() + " " + pUser.getLastName() + " registered successfully");
		// return "success";
		return "registrationsuccess";
		
	} // Fin de saveUser(...)._____________________________________________
	


	/**
	 * This method will provide the medium to update an existing user.
	 */
	/**
	 * method editUser() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pSsoId
	 * @param pModel
	 * @return :  :  .<br/>
	 */
	@RequestMapping(value = { "/edit-user-{ssoId}" }, method = RequestMethod.GET)
	public String editUser(@PathVariable String pSsoId, ModelMap pModel) {
		
		final User user = this.userService.findBySSO(pSsoId);
		
		pModel.addAttribute("user", user);
		pModel.addAttribute("edit", true);
		
		return "/metier/user/registration";
		
	} // Fin de editUser(...)._____________________________________________
	
	
	
	/**
	 * This method will be called on form submission, handling POST request for
	 * updating user in database. It also validates the user input
	 */
	/**
	 * method updateUser() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pUser
	 * @param pResult
	 * @param pModel
	 * @param pSsoId
	 * @return :  :  .<br/>
	 */
	@RequestMapping(value = { "/edit-user-{ssoId}" }, method = RequestMethod.POST)
	public String updateUser(@Valid User pUser, BindingResult pResult,
			ModelMap pModel, @PathVariable String pSsoId) {

		if (pResult.hasErrors()) {
			return "/metier/user/registration";
		}

		/*//Uncomment below 'if block' if you WANT TO ALLOW UPDATING SSO_ID in UI which is a unique key to a User.
		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}*/


		this.userService.updateUser(pUser);

		pModel.addAttribute("success", "User " + pUser.getFirstName() + " "+ pUser.getLastName() + " updated successfully");
		
		return "/metier/user/registrationsuccess";
		
	} // Fin de updateUser(...).___________________________________________
	

	
	/**
	 * This method will delete an user by it's SSOID value.
	 */
	/**
	 * method deleteUser() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pSsoId
	 * @return :  :  .<br/>
	 */
	@RequestMapping(value = { "/delete-user-{ssoId}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable String pSsoId) {
		
		this.userService.deleteUserBySSO(pSsoId);
		
		return "redirect:/list";
		
	} // Fin de deleteUser(...).___________________________________________
	
	

	/**
	 * This method will provide UserProfile list to views
	 */
	/**
	 * method initializeProfiles() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @return :  :  .<br/>
	 */
	@ModelAttribute("roles")
	public List<UserProfile> initializeProfiles() {
		return this.userProfileService.findAll();
	} // Fin de initializeProfiles().______________________________________
	

	
} // Fin de AppController.---------------------------------------------------
