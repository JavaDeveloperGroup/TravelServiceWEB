package by.htp.travelserviceWEB.commander;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateAccountPageAction implements CommandAction {
	
	public UpdateAccountPageAction() {}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = "jsp/update_account_page.jsp";
		
		return page;
	}

}
