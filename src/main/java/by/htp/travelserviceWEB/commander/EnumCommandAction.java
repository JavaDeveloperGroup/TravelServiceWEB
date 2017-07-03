package by.htp.travelserviceWEB.commander;

public enum EnumCommandAction {
	
	LOG_IN {
		public CommandAction getCommantAction() {
			return new LogInAction();
		}
	},
	LOG_OUT{
		public CommandAction getCommantAction() {
			return new LogOutAction();
		}
	},
	LOG_IN_PAGE{
		public CommandAction getCommantAction() {
			return new LogInPageAction();
		}
	},
	SIGN_UP_PAGE{
		public CommandAction getCommantAction() {
			return new SignUpPageAction();
		}
	},
	SIGN_UP{
		public CommandAction getCommantAction() {
			return new SignUpAction();
		}
	};
	
	public abstract CommandAction getCommantAction();
	
	/*public static EnumCommandAction initAction(String command) {
		String comm = command.toUpperCase();
		try {
			return EnumCommandAction.valueOf(comm);
		} catch (EnumConstantNotPresentException e) {
			return EnumCommandAction.LOG_IN_PAGE;
		}
	}*/

}
