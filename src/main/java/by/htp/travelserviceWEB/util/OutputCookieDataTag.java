package by.htp.travelserviceWEB.util;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.TagSupport;

import by.htp.travelserviceWEB.util.EncryptionFdl;

@SuppressWarnings("serial")
public final class OutputCookieDataTag extends  TagSupport implements DynamicAttributes{
	
	private String login;
	private String password;
	private String value;
	private HttpServletRequest request;

	@Override
	public void setDynamicAttribute(String arg0, String arg1, Object arg2) throws JspException {
		if("log".equals(arg2)) {
			login = (String)arg2;
		}
		else if("passw".equals(arg2)) {
			password = (String)arg2;
		}
		else if("value2".equals(arg1)) {
			request = (HttpServletRequest)arg2;
		}
	}
	
	@Override
    public int doStartTag() throws JspException {
        try {
        	Cookie[] cookies = request.getCookies();
    		if(cookies.length > 1) {
    			if(login != null) {
    				value = cookies[0].getValue();
    			}
    			else if(password != null) {
    				value = EncryptionFdl.decrypt(cookies[1].getValue());
    			}
    		}
    		if(value != null) {
    			pageContext.getOut().print(value);
    		}
        } catch(IOException ioException) {
            throw new JspException("Error: " + ioException.getMessage());
        }       
        finally {
        	login = null;
    		password = null;
		}
        return SKIP_BODY;
    }
}
