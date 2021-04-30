/**
 * 
 */
package com.bank.project;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bank.project.dto.AccountDTO;
import com.bank.project.dto.UserDTO;
import com.bank.project.model.User;
import com.bank.project.service.AccountService;
import com.bank.project.service.UserService;

/**
 * @author SUDESHA
 *
 */
@Controller
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	AccountService accountService;

	static Logger logger = Logger.getLogger(UserController.class);

	/**
	 * @param login
	 * @param model
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginSuccess(User login, Model model) {
		try {
			String userlogin = userService.loginCheck(login.getUserName(), login.getPassword());
			int userId = userService.getUserId(login.getUserName());
			if (userlogin.equals("success")) {
				List<AccountDTO> accountListById = accountService.getAllAccountDetailsById(userId);
				model.addAttribute("accountList", accountListById);
				model.addAttribute("userId", userId);
				logger.info("login successfully");
				return "accountList";
			} else {
				logger.error("Wrong UserId or Password");
				model.addAttribute("message", "Wrong UserId or Password");
				return "home";

			}

		} catch (Exception e) {
			logger.error("Error while login user : " + e.getMessage(), e);
		}
		return "home";
	}

	/**
	 * @param model
	 * 
	 */
	@RequestMapping(value = "/userForm", method = RequestMethod.GET)
	public String userForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("btnValue", "Save");
		return "userForm";
	}

	/**
	 * @param model
	 * 
	 */

	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public String userList(Model model) {
		List<UserDTO> userList = userService.getAllUserDetails();
		model.addAttribute("userdata", true);
		model.addAttribute("userList", userList);
		logger.info("view user list");
		return "userList";
	}

	/**
	 * 
	 * @param user
	 * @return ModelAndView
	 */

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute("user") @Valid UserDTO userDTO, BindingResult result, Model model) {
		try {
			List<String> errMessages = new ArrayList<String>();
			if (result.hasErrors()) {
				for (ObjectError err : result.getAllErrors()) {
					errMessages.add(err.getDefaultMessage());
				}
				model.addAttribute("btnValue", "Save");
				model.addAttribute("error", errMessages);
				return new ModelAndView("userForm", "user", userDTO);
			}
			if (userDTO.getUserId() == 0) {
				// updating the user
				userService.saveUserDetails(userDTO);
				logger.info("save user details");
			} else {
				userService.updateUserDetails(userDTO);
				logger.info("update user details");
			}

		} catch (Exception e) {
			logger.error("Error while save user : " + e.getMessage(), e);
		}
		return new ModelAndView("redirect:/getUserDetails");
	}

	/**
	 * @param model
	 * 
	 */
	@RequestMapping(value = "/getUserDetails", method = RequestMethod.GET)
	public String getUserDetails(Model model) {
		List<UserDTO> userList = userService.getAllUserDetails();
		model.addAttribute("message", "Saved User Details Successfully");
		model.addAttribute("userList", userList);
		return "userList";
	}

	/**
	 * @param userId
	 * @param model
	 * @param user
	 */
	@RequestMapping(value = "/editUserDetails", method = RequestMethod.GET)
	public String updateEmplyeeDetails(@RequestParam int userId, Model model, @ModelAttribute User user) {
		System.out.println("update dedtails");
		List<UserDTO> userList = userService.getUpdateDetails(userId);
		model.addAttribute("userList", userList);
		model.addAttribute("btnValue", "Update");
		return "userForm";
	}

	/**
	 * @param userId
	 * @param model
	 * 
	 */
	@RequestMapping(value = "/userListdata/{userId}", method = RequestMethod.GET)
	public String userListdata(@PathVariable int userId, Model model) {
		List<UserDTO> userList = userService.getAllUserDetails();
		model.addAttribute("userList", userList);
		model.addAttribute("userdata", false);
		logger.info("view user list");
		return "userList";
	}

}
