package by.htp.travelserviceWEB.commander;

enum EnumCommandAction {
	
	LOG_IN,
	LOG_OUT,
	LOG_IN_PAGE,
	SIGN_UP_PAGE,
	SIGN_UP;
	
	public static EnumCommandAction initAction(String command) {
		String comm = command.toUpperCase();
		try {
			return EnumCommandAction.valueOf(comm);
		} catch (EnumConstantNotPresentException e) {
			return EnumCommandAction.LOG_IN_PAGE;
		}
	}

}
