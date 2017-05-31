package by.htp.travleservice.entity;

import java.sql.Date;

public class User {

	private Integer userId;
	private String login;
	private String password;
	private String name;
	private String surname;
	private String gender;
	private Date birthday;
	private String passport;
	private String email;
	private String phoneNumber;
	private String driverLicense;
	private String vip;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public User(String login, String password, String name, String surname, String gender, Date birthday,
			String passport, String email, String phoneNumber, String driverLicense, String vip) {
		super();
		this.login = login;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.birthday = birthday;
		this.passport = passport;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.driverLicense = driverLicense;
		this.vip = vip;
	}
	
	public User(Integer userId, String login, String password, String name, String surname, String gender,
			Date birthday, String passport, String email, String phoneNumber, String driverLicense, String vip) {
		super();
		this.userId = userId;
		this.login = login;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.birthday = birthday;
		this.passport = passport;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.driverLicense = driverLicense;
		this.vip = vip;
	}
	
	
}
