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
		mapCommand.put("sign_up", new SignUp());
		//here are the commands
		return mapCommand;
	}
	
	private static CommandMap getInstance() {
		return Singletone.INSTANCE;
	}
}
