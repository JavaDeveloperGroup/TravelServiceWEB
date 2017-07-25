package by.htp.travelserviceWEB;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class ValidatorTest2 {
	
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(ValidatorTest.class); //set to run test
		//how many successful tests
		System.out.println("Total number of tests " + result.getRunCount());
		//how many failed tests
		System.out.println("Total number of tests failed " + result.getFailureCount());
		//if fail then return error msg 
		for(Failure failure : result.getFailures()) {
			System.out.println(failure.getMessage());
		}
		//total result of test (true/false)
		System.out.println(result.wasSuccessful());
	}
}
