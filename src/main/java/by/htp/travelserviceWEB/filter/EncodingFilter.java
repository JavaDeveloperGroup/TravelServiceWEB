package by.htp.travelserviceWEB.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter{
	
	public EncodingFilter () {
		System.out.println("constr filter");
	}

	private static final String CODE = "UTF-8";

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("init filter");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		String codeRequest = servletRequest.getCharacterEncoding();
		if (!CODE.equalsIgnoreCase(codeRequest)) {
            servletRequest.setCharacterEncoding(CODE);
            servletResponse.setCharacterEncoding(CODE);
        }
        chain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void destroy() {
		System.out.println("destroy filter");
	}

}
