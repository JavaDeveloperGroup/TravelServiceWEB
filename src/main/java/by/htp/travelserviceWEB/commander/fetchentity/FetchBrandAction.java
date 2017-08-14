package by.htp.travelserviceWEB.commander.fetchentity;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.travelserviceWEB.commander.CommandAction;
import by.htp.travelserviceWEB.entity.Entity;
import by.htp.travelserviceWEB.entity.auto.Brand;
import by.htp.travelserviceWEB.service.auto.BrandService;
import by.htp.travelserviceWEB.service.auto.impl.BrandServiceImpl;

public class FetchBrandAction implements CommandAction {
	
	private BrandService brandService;
	
	public FetchBrandAction() {
		brandService = BrandServiceImpl.getInstance();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = "jsp/index.jsp";
		
		List<Entity> list = brandService.fillingListByTheBrands(new Brand());
		request.setAttribute("brand_list", list);
		
		return page;
	}

}
