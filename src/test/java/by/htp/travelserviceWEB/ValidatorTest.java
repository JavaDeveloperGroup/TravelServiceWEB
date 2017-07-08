package by.htp.travelserviceWEB;

import static org.junit.Assert.*;

import by.htp.travelserviceWEB.util.Validator;

import org.junit.Test;

public class ValidatorTest {

	@Test
	public void test() {
		//correct data
		String login = "user0";
		String password = "fidelio1Q@";
		String name = "Ivan";
		String surname = "Ivanov";
		String passport = "AB1234567";
		String email = "popovich@a1qa.by";
		String phoneNumber = "+375293333333";
		assertEquals(true, Validator.registrationCustomer(login, password, name, surname, passport, email, phoneNumber));
		
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
}
