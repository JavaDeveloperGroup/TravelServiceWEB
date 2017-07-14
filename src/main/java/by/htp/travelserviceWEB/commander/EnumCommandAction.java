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
	},
	UPDATE_ACCOUNT{
		public CommandAction getCommantAction() {
			return new UpdateAccountAction();
		}
	};
	
	public abstract CommandAction getCommantAction();

}
