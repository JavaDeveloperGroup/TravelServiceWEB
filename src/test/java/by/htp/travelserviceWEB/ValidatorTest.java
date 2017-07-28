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
public class ValidatorTest {
	
	private String repeatPassword;
	private CustomerTO customerTO;
	
	@Before
	public void inputValitAllDataField() {
		customerTO = new CustomerTO("User", "fidelio1Q@", "Ivan", "Ivanov", "MEN", 
				"2000-02-02", "AB1234567", "ivan_ivanov@a1qa.by", "+375293333333", "AA 0000000", 1);
		
		repeatPassword = "fidelio1Q@";
	}
	
	@Test (timeout = 50)
	public void validAllDataField() throws ServletException, IOException {
		assertEquals(true, Validator.registrationCustomer(customerTO, repeatPassword));
	}
	
	@Test (timeout = 50)
	public void notValidAllDataField() throws ServletException, IOException {
		
		customerTO.setLogin("");
		customerTO.setPassword("");
		customerTO.setName("");
		customerTO.setSurname("");
		customerTO.setGender("");
		customerTO.setBirthday("");
		customerTO.setPassport("");
		customerTO.setEmail("");
		customerTO.setPhoneNumber("");
		customerTO.setDriverLicense("");
		customerTO.setRoleId(0);
		repeatPassword = "";

		assertEquals(true, Validator.registrationCustomer(customerTO, repeatPassword));
	}
	
	@Ignore
	@Test (timeout = 50)
	public void notValidEmailField() throws ServletException, IOException {
		customerTO.setEmail("ivan_ivanov@a1qa.by");
		assertEquals(true, Validator.registrationCustomer(customerTO, repeatPassword));
	}
	
	@Test (timeout = 50)
	public void notValidPasswField() throws ServletException, IOException {
		customerTO.setPassword("fidelio1Q");
		assertEquals(true, Validator.registrationCustomer(customerTO, repeatPassword));
	}
	
	/*@AfterClass
	public static void printInfo() {
		System.out.println("Ending tests.");
	}*/
		//uncorrect data
//		login = "user@";
//		password = "fidelio1@";
//		name = "Ivan1";
//		surname = "Ivanov1";
//		passport = "1234567";
//		email = "@a1qa.by";
//		phoneNumber = "375293333333";
//		assertEquals(true, Validator.registrationCustomer(login, password, name, surname, passport, email, phoneNumber));
	
}
