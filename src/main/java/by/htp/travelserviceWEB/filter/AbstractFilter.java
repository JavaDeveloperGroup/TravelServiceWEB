package by.htp.travelserviceWEB.filter;

import java.io.Serializable;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;

public abstract class AbstractFilter implements Filter, Serializable {

	private static final long serialVersionUID = 4055260450354192055L;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void destroy() {}
}
