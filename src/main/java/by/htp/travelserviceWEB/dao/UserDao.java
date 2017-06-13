package by.htp.travelserviceWEB.dao;

import javax.servlet.http.HttpServletRequest;

<<<<<<< HEAD
import by.htp.travelserviceWEB.dto.CustomerDTO;
import by.htp.travelserviceWEB.dto.UserDTO;
=======
>>>>>>> ead200ba513bd829d0bf53accc9e7f6255a6fe89
import by.htp.travelserviceWEB.entity.Admin;
import by.htp.travelserviceWEB.entity.Customer;

public interface UserDao {
<<<<<<< HEAD
	Customer fetchCustomer(UserDTO userDTO);
	Admin fetchAdmin(UserDTO userDTO);
	Customer makeCustomer(CustomerDTO customerDTO);
=======
	Customer fetchCustomer(String login, String password);
	Admin fetchAdmin(String login, String password);
	Customer makeCustomer(Customer customer);
>>>>>>> ead200ba513bd829d0bf53accc9e7f6255a6fe89
}