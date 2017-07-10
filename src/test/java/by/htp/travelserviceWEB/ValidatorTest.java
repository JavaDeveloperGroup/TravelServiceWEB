package by.htp.travelserviceWEB;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Ignore;

import by.htp.travelserviceWEB.util.Validator;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith (ProjectRunner.class)
public class ValidatorTest {
	
	private String login;
	private String password;
	private String name;
	private String surname;
	private String passport;
	private String email;
	private String phoneNumber;
	
	@Before
	public void inputValitAllDataField() {
		login = "User";
		password = "fidelio1Q@";
		name = "Ivan";
		surname = "Ivanov";
		passport = "AB1234567";
		email = "popovich@a1qa.by";
		phoneNumber = "+375293333333";
	}
	
	@Test (timeout = 50)
	public void validAllDataField() {
		assertEquals(true, Validator.registrationCustomer(login, password, name, surname, passport, email, phoneNumber));
	}
	
	@Test (timeout = 50)
	public void notValidAllDataField() {
		login = "";
		password = "";
		name = "";
		surname = "";
		passport = "";
		email = "";
		phoneNumber = "";
		assertEquals(true, Validator.registrationCustomer(login, password, name, surname, passport, email, phoneNumber));
	}
	
	@Ignore
	@Test (timeout = 50)
	public void notValidEmailField() {
		email = "popovich@a1qa";
		assertEquals(true, Validator.registrationCustomer(login, password, name, surname, passport, email, phoneNumber));
	}
	
	@Test (timeout = 50)
	public void notValidPasswField() {
		password = "fidelio1Q";
		assertEquals(true, Validator.registrationCustomer(login, password, name, surname, passport, email, phoneNumber));
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
