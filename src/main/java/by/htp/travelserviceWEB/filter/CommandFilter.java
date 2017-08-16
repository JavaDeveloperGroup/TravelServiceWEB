package by.htp.travelserviceWEB.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.travelserviceWEB.entity.User;
import by.htp.travelserviceWEB.entity.dto.AdminTOWP;
import by.htp.travelserviceWEB.filter.factory.CheckCommandList;

import static by.htp.travelserviceWEB.util.Formatter.*;

public class CommandFilter extends AbstractFilter {

	public static int ADMIN_ID = 4;

	private static final long serialVersionUID = 8120657689790657853L;

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		FilterChain filterChain = chain;
		String command = ((HttpServletRequest) servletRequest).getParameter("command");
		HttpSession httpSession = ((HttpServletRequest) servletRequest).getSession();
		User user = (User) httpSession.getAttribute("user");
		if (checkUserAccess(user, servletResponse, command))
			filterChain.doFilter(servletRequest, servletResponse);
		else 
			((HttpServletResponse) servletResponse).sendRedirect("jsp/home_page.jsp");
		
	}

	private boolean checkUserAccess(User user, ServletResponse servletResponse, String command)
			throws IOException, ServletException {
		
		if (CheckCommandList.getInstance().isUserCommand(user, command)) {
			return true;
		} else 
			return false;
		/*String userTypeString = getRoleName(user).toUpperCase();
		if (UserHasCommands.valueOf(userTypeString).getSetUserCommands(user).contains(command)) {
		} else
			((HttpServletResponse) servletResponse).sendRedirect("jsp/home_page.jsp");*/
	}
}

/*enum UserHasCommands {

	GUEST {

		@Override
		Set<String> getSetUserCommands(Object user) {
			Set<String> guestListCommand = new HashSet<>();
			guestListCommand.add("hotel_catalogue_page");
			guestListCommand.add("auto_catalogue_sorting_page");
			guestListCommand.add("auto_sort_salon_page");
			guestListCommand.add("tour_catalogue_page");
			guestListCommand.add("log_in_page");
			guestListCommand.add("sign_up_page");
			guestListCommand.add("log_in");
			guestListCommand.add("sign_up");
			return guestListCommand;
		}

	},

	ADMIN_TOUR {

		@Override
		Set<String> getSetUserCommands(Object user) {
			Set<String> adminListCommand = new HashSet<>();
			adminListCommand.add("admin_page");
			adminListCommand.add("log_out");
			adminListCommand.add("tour_catalogue_page");
			return adminListCommand;
		}

	},

	ADMIN_AUTO {

		@Override
		Set<String> getSetUserCommands(Object user) {
			Set<String> adminListCommand = new HashSet<>();
			adminListCommand.add("admin_page");
			adminListCommand.add("log_out");
			adminListCommand.add("auto_catalogue_sorting_page");
			adminListCommand.add("auto_sort_salon_page");
			return adminListCommand;
		}

	},

	ADMIN_HOTEL {

		@Override
		Set<String> getSetUserCommands(Object user) {
			Set<String> adminListCommand = new HashSet<>();
			adminListCommand.add("admin_page");
			adminListCommand.add("log_out");
			adminListCommand.add("hotel_catalogue_page");
			return adminListCommand;
		}

	},

	CUSTOMER {

		@Override
		Set<String> getSetUserCommands(Object user) {
			Set<String> customerListCommand = new HashSet<>();
			customerListCommand.add("hotel_catalogue_page");
			customerListCommand.add("auto_catalogue_sorting_page");
			customerListCommand.add("auto_sort_salon_page");
			customerListCommand.add("tour_catalogue_page");
			customerListCommand.add("hotel_make_order");
			customerListCommand.add("auto_make_order");
			customerListCommand.add("tour_make_order");
			customerListCommand.add("log_out");
			customerListCommand.add("update_account_page");
			customerListCommand.add("update_account");
			return customerListCommand;
		}

	},
	
	USER {

		@Override
		Set<String> getSetUserCommands(Object user) {
			Set<String> userListCommand = new HashSet<>();
			return userListCommand;
		}
		
	};

	abstract Set<String> getSetUserCommands(Object user);
}*/

/*
 * final class InitSecurityCommand {
 * 
 * private static final Set<String> customerListCommand =
 * Collections.synchronizedSet(new HashSet<>()); private static final
 * Set<String> guestListCommand = Collections.synchronizedSet(new HashSet<>());
 * private static final Set<String> adminListCommand =
 * Collections.synchronizedSet(new HashSet<>());
 * 
 * private InitSecurityCommand() {
 * 
 * }
 * 
 * static class Singleton { private static final InitSecurityCommand INSTANCE =
 * new InitSecurityCommand(); }
 * 
 * public static InitSecurityCommand getInstance() { return Singleton.INSTANCE;
 * }
 * 
 * static { customerListCommand.add("hotel_catalogue_page");
 * customerListCommand.add("auto_catalogue_sorting_page");
 * customerListCommand.add("auto_sort_salon_page");
 * customerListCommand.add("tour_catalogue_page");
 * customerListCommand.add("hotel_make_order");
 * customerListCommand.add("auto_make_order");
 * customerListCommand.add("tour_make_order");
 * customerListCommand.add("log_out");
 * customerListCommand.add("update_account_page");
 * customerListCommand.add("update_account"); } static {
 * guestListCommand.add("hotel_catalogue_page");
 * guestListCommand.add("auto_catalogue_sorting_page");
 * guestListCommand.add("auto_sort_salon_page");
 * guestListCommand.add("tour_catalogue_page");
 * guestListCommand.add("log_in_page"); guestListCommand.add("sign_up_page");
 * guestListCommand.add("log_in"); guestListCommand.add("sign_up"); } static {
 * adminListCommand.add("hotel_catalogue_page");
 * adminListCommand.add("auto_catalogue_sorting_page");
 * adminListCommand.add("auto_sort_salon_page");
 * adminListCommand.add("tour_catalogue_page");
 * adminListCommand.add("admin_page"); adminListCommand.add("log_out"); }
 * 
 * boolean checkCustomerCommand(String command) { return
 * customerListCommand.contains(command); } boolean checkAdminCommand(String
 * command) { return adminListCommand.contains(command); } boolean
 * checkGuestCommand(String command) { return
 * guestListCommand.contains(command); }
 * 
 * }
 */