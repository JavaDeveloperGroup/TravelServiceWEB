package by.htp.travelserviceWEB.filter;

import java.util.HashSet;
import java.util.Set;

public final class InitSecurCommand {
	
	private static final Set<String> customerListCommand = new HashSet<>();
	private static final Set<String> guestListCommand = new HashSet<>();
	private static final Set<String> adminListCommand = new HashSet<>();
	
	private InitSecurCommand() {
		
	}
	
	static class Singleton {
		private static final InitSecurCommand INSTANCE = new InitSecurCommand();
	}
	
	public static InitSecurCommand getInstance() {
		return Singleton.INSTANCE;
	}
	
	static {
		customerListCommand.add("hotel_catalog_page");
		customerListCommand.add("auto_catalog_page");
		customerListCommand.add("tour_catalog_page");
		customerListCommand.add("hotel_make_order");
		customerListCommand.add("auto_make_order");
		customerListCommand.add("tour_make_order");
		customerListCommand.add("log_out");
	}
	static {
		guestListCommand.add("catalog_hotel_page");
		guestListCommand.add("catalog_auto_page");
		guestListCommand.add("catalog_tour_page");
		guestListCommand.add("log_in_page");
		guestListCommand.add("sign_up_page");
		guestListCommand.add("log_in");
		guestListCommand.add("sign_up");
	}
	static {
		adminListCommand.add("catalog_hotel_page");
		adminListCommand.add("catalog_auto_page");
		adminListCommand.add("catalog_tour_page");
		adminListCommand.add("admin_page");
		adminListCommand.add("log_out");
	}
	
	boolean initCustomerCommand(String command) {
		return customerListCommand.contains(command);
	}
	boolean initAdminCommand(String command) {
		return adminListCommand.contains(command);
	}
	boolean initGuestCommand(String command) {
		return guestListCommand.contains(command);		
	}
}
