package by.htp.travelserviceWEB;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

public class ProjectRunner extends BlockJUnit4ClassRunner{
	
	private ProjectRunListener projectRunListener;

	public ProjectRunner(Class<ProjectRunListener> klass) throws InitializationError {
		super(klass);
		projectRunListener = new ProjectRunListener();
	}
	
	public void run(RunNotifier notifier) {
		notifier.addListener(projectRunListener);
		super.run(notifier);
	}

}
