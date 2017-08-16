package by.htp.travelserviceWEB.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter extends AbstractFilter {
	
	private static final long serialVersionUID = 7740625431531226243L;
	
	private static final String CODE = "UTF-8";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String codeRequest = request.getCharacterEncoding();
		if (!CODE.equalsIgnoreCase(codeRequest)) {
			request.setCharacterEncoding(CODE);
			response.setCharacterEncoding(CODE);
        }
        chain.doFilter(request, response);
	}
}
