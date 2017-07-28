package by.htp.travelserviceWEB.commander;

import java.awt.List;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.htp.travelserviceWEB.entity.Entity;
import by.htp.travelserviceWEB.entity.EntityAll;
import by.htp.travelserviceWEB.entity.dto.AdminTO;
import by.htp.travelserviceWEB.entity.dto.CustomerTO;
import by.htp.travelserviceWEB.entity.dto.CustomerTOLP;
import by.htp.travelserviceWEB.service.CustomerService;
import by.htp.travelserviceWEB.service.impl.CustomerServiceImpl;
import by.htp.travelserviceWEB.util.EncryptionFdl;
import by.htp.travelserviceWEB.util.Validator;

import static by.htp.travelserviceWEB.util.ConstantValue.*;
import static by.htp.travelserviceWEB.util.Formatter.*;


public class SignUpAction implements CommandAction {

	private static final Logger log = Logger.getLogger(LogInAction.class);
	
	private HttpSession httpSession;
	private CustomerTO customerTO;
	private CustomerTOLP customerTOLP;
	private String page;
	
	private CustomerService customerService;
	{
		customerService = CustomerServiceImpl.getInstance();
	}

	public SignUpAction() {
		customerTO = new CustomerTO();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		customerTO = (CustomerTO) newInstance(request, customerTO);
		customerTO.setPassword(EncryptionFdl.encrypt(customerTO.getPassword()));
		        
        String passwordRepeatEncrypt = EncryptionFdl.encrypt(request.getParameter(listOfParametersForSinUp.get(listOfParametersForSinUp.size() - 1)));
        
		if (!Validator.registrationCustomer(customerTO, passwordRepeatEncrypt)) {
			page = "jsp/sign_up_page.jsp";
			request.setAttribute("msg", "Incorrect data entry.");
			return page;
		}
		else {
			customerTOLP = new CustomerTOLP(customerTO.getLogin(), customerTO.getPassword());
			return getPage(request, response);
		}
	}
	
	private String getPage(HttpServletRequest request, HttpServletResponse response) {
		CustomerTO customerTO = null;
		httpSession = request.getSession();
		customerTO = customerService.authoriseCustomer(customerTO, customerTOLP);	
		if (customerTO == null) {
			AdminTO adminTO = null;
			adminTO = customerService.authoriseAdmin(adminTO, customerTOLP);
			if (adminTO == null) {
				customerTO = customerService.registrationCustomer(this.customerTO);
				httpSession.setAttribute("user", this.customerTO);
				inputCookie(request, response);
				page = "jsp/home_page.jsp";
			}
			else {
				request.setAttribute("msg", "There is a user with such login.");
				page = "jsp/sign_up_page.jsp";
			}
		} else {
			request.setAttribute("msg", "There is a user with such login.");
			page = "jsp/sign_up_page.jsp";
		}
		//log.info("Sign up " + ((Customer)httpSession.getAttribute("user")).getLogin());
		return page;
	}
	
	private void inputCookie(HttpServletRequest request, HttpServletResponse response) {
		response.addCookie(new Cookie("login", this.customerTO.getLogin()));
		response.addCookie(new Cookie("password", this.customerTO.getPassword()));
	}
	
	private Object newInstance(HttpServletRequest request, EntityAll entityAll) {
		Object obj = null;
		try {
			obj =  getConstructor(entityAll)[1].newInstance(parameters(request, entityAll));
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	
	private Object[] parameters(HttpServletRequest request, EntityAll entityAll) {
		Object[] obj = new Object[getParameterTypes(entityAll).length];
		System.out.println("obj.lenght " + obj.length);
		int i = 0;
		for (String value : listOfParametersForSinUp) {
			if (i < listOfParametersForSinUp.size() - 1) {}
			obj[i] = request.getParameter(value);
			i++;
		}
		obj[10] = 1;
		System.out.println("obj.lenght " + obj.length);
		return obj;
	}
}