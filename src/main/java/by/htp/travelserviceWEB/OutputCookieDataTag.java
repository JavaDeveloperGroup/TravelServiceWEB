package by.htp.travelserviceWEB;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import by.htp.travelserviceWEB.util.EncryptionFdl;

public class OutputCookieDataTag extends TagSupport{

	private static final long serialVersionUID = 886367702143691823L;
	private String value;
	
	public void setValue(String nameData) {
			if("login".equals(nameData)) 
				value = "login";
			else if ("password".equals(nameData))
				value = "password";
		
	}
	
	@Override
	public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();   
            out.print(value);
            
        } catch(IOException ioe) {
            throw new JspException("Error: " + ioe.getMessage());
        }       
        return SKIP_BODY;
    }
}
