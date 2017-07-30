package by.htp.travelserviceWEB.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public final class ReturnToTheOriginalPage {

	private ReturnToTheOriginalPage() {
	}

	public static String getOriginalPage(String nameCommandFromOriginalPage, HttpServletRequest request) {
		String page;
		HttpSession httpSession = request.getSession();
		String nameCommandFromSession = (String) httpSession.getAttribute("originalPage");
		if (nameCommandFromSession != null) {
			if (!nameCommandFromSession.matches(".*(log_out).*")) {
				page = nameCommandFromSession;
			} else
				page = "jsp/home_page.jsp";
		} else if (nameCommandFromOriginalPage.matches(".*(command).*")) {
			page = new String(
					new StringBuffer().append("jsp/").append(nameCommandFromOriginalPage.substring(55)).append(".jsp"));
		} else
			page = "jsp/home_page.jsp";
		return page;
	}

}
