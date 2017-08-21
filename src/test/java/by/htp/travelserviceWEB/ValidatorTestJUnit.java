package by.htp.travelserviceWEB;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Ignore;

import by.htp.travelserviceWEB.entity.dto.CustomerTO;
import by.htp.travelserviceWEB.util.Validator;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith (ProjectRunner.class)
public class ValidatorTestJUnit {
	
	private String login;
	private String password;
	private String repeatPassword;
	private String name;
	private String surname;
	private String gender;
	private String birthday;
	private String passport;
	private String email;
	private String phoneNumber;
	private String driverLicence;
	private Integer roleId;
	//private CustomerTO сustomerTO = new CustomerTO(login, password, name, surname, gender, birthday, passport, email, phoneNumber, driverLicence, roleId);
	
	@Before
	public void inputValitAllDataField() {
		login = "User";
		password = "fidelio1Q@";
		repeatPassword = "fidelio1Q@";
		name = "Ivan";
		surname = "Ivanov";
		gender = "Male";
		birthday = "19-02-1999";
		passport = "AB1234567";
		email = "popovich@a1qa.by";
		phoneNumber = "+375293333333";
		driverLicence = "No";
		roleId = 1;
	}
	
	@Test (timeout = 500)
	public void validAllDataField() throws ServletException, IOException {
		CustomerTO сustomerTO = new CustomerTO(login, password, name, surname, gender, birthday, passport, email, phoneNumber, driverLicence, roleId);
		assertEquals(true, Validator.dataRegistration(сustomerTO, repeatPassword));
	}
	
	@Test (timeout = 500)
	public void notValidAllDataField() throws ServletException, IOException {
		login = "";
		password = "";
		repeatPassword = "";
		name = "";
		surname = "";
		gender = "";
		passport = "";
		email = "";
		phoneNumber = "";
		driverLicence = "";
		CustomerTO сustomerTO = new CustomerTO(login, password, name, surname, gender, birthday, passport, email, phoneNumber, driverLicence, roleId);
		assertEquals(true, Validator.dataRegistration(сustomerTO, repeatPassword));
	}
	
	//@Ignore
	@Test (timeout = 500)
	public void notValidEmailField() throws ServletException, IOException {
		email = "popovich@a1qa";
		CustomerTO сustomerTO = new CustomerTO(login, password, name, surname, gender, birthday, passport, email, phoneNumber, driverLicence, roleId);
		assertEquals(true, Validator.dataRegistration(сustomerTO, repeatPassword));
	}
	
	@Test (timeout = 500)
	public void notValidPasswField() throws ServletException, IOException {
		password = "fidelio1Q";
		CustomerTO сustomerTO = new CustomerTO(login, password, name, surname, gender, birthday, passport, email, phoneNumber, driverLicence, roleId);
		assertEquals(true, Validator.dataRegistration(сustomerTO, repeatPassword));
	}
}
