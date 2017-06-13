package by.htp.travelserviceWEB.commander;

import java.util.HashMap;
import java.util.Map;

public final class CommandMap {
	
	private CommandMap() {
		CommandMap.getInstance();
	}
	
	private static class Singletone{
		private static final CommandMap INSTANCE = new CommandMap();
	}
	
	public static Map map() {
		Map<String, CommandAction> mapCommand = new HashMap<String, CommandAction>(); 
		mapCommand.put("log_in", new LogInAction());
		mapCommand.put("log_out", new LogOutAction());
<<<<<<< HEAD
		mapCommand.put("sign_up", new SignUpAction());
=======
		mapCommand.put("sign_up", new SignUp());
>>>>>>> ead200ba513bd829d0bf53accc9e7f6255a6fe89
		//here are the commands
		return mapCommand;
	}
	
	private static CommandMap getInstance() {
		return Singletone.INSTANCE;
	}
}
