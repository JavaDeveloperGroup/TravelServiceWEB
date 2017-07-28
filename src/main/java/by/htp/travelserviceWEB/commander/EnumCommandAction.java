package by.htp.travelserviceWEB.commander;

public enum EnumCommandAction {
	
	LOG_IN {
		@Override
		public CommandAction getCommantAction() {
			return new LogInAction();
		}
	},
	LOG_OUT{
		@Override
		public CommandAction getCommantAction() {
			return new LogOutAction();
		}
	},
	LOG_IN_PAGE{
		@Override
		public CommandAction getCommantAction() {
			return new LogInPageAction();
		}
	},
	SIGN_UP_PAGE{
		@Override
		public CommandAction getCommantAction() {
			return new SignUpPageAction();
		}
	},
	SIGN_UP{
		@Override
		public CommandAction getCommantAction() {
			return new SignUpAction();
		}
	},
	UPDATE_ACCOUNT_PAGE{
		@Override
		public CommandAction getCommantAction() {
			return new UpdateAccountPageAction();
		}
	},
	UPDATE_ACCOUNT{
		@Override
		public CommandAction getCommantAction() {
			return new UpdateAccountAction();
		}
	};
	
	public abstract CommandAction getCommantAction();

}
