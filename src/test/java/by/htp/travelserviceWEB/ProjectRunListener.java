package by.htp.travelserviceWEB;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class ProjectRunListener extends RunListener{

	@Override
	public void testRunStarted(Description description) throws Exception {
		System.out.println("Start test: " + description.getClassName() + "\n-----");
	}
	
	@Override
	public void testStarted(Description description) throws Exception {
		System.out.println("Start test method: " + description.getMethodName());
	}
	
	@Override
	public void testFailure(Failure failure) throws Exception {
		System.out.println("Test fail with exception: " + failure.getException());
	}

	@Override
	public void testFinished(Description description) throws Exception {
		System.out.println("Finished test method: " + description.getMethodName() + "\n-----");
	}
	
	@Override
	public void testIgnored(Description description) throws Exception {
		System.out.println("Ignored test method: " + description.getMethodName() + "\n-----");
	}

	@Override
	public void testRunFinished(Result result) throws Exception {
		System.out.println("Finished test: runtime - " + result.getRunTime() + "millis");
		System.out.println("Quantity tests: " + result.getRunCount());
		System.out.println("Failed tests: " + result.getFailureCount());
		System.out.println("Ignored tests: " + result.getIgnoreCount());
		System.out.println("Results tests: " + result.wasSuccessful());
	}
}
