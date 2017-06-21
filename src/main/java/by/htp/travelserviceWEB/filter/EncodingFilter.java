package by.htp.travelserviceWEB.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(urlPatterns = { "/*" }, initParams = {  @WebInitParam(name = "encoding", value = "UTF-8") })
public class EncodingFilter implements Filter{

	private String code;

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		code = fConfig.getInitParameter("encoding");
		//code = "UTF-8";
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		String codeRequest = servletRequest.getCharacterEncoding();
		if (code != null && !code.equalsIgnoreCase(codeRequest)) {
            servletRequest.setCharacterEncoding(code);
            servletResponse.setCharacterEncoding(code);
        }
        chain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void destroy() {
		code = null;
	}

}
