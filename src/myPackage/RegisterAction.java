package myPackage;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.validation.SkipValidation;


public class RegisterAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private String organization;
	private String address;
	private String city;
	private String state;
	private String zipcode;
	private String contactperson;
	private String email;
	private String phone;
	private String date;
	private String time;
	private String av;
	
	
	
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getContactperson() {
		return contactperson;
	}
	public void setContactperson(String contactperson) {
		this.contactperson = contactperson;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAv() {
		return av;
	}
	public void setAv(String av) {
		this.av = av;
	}
	
	public String execute(){
		return "success";
	}
	
	public void validate(){
			System.out.println("in validate");
			if(StringUtils.isEmpty(getOrganization())){
				System.out.println("Organization is blank");
				addFieldError("organization","Organization cannot be blank");
			}
			if(StringUtils.isEmpty(getAddress())){
				addFieldError("address","Address cannot be blank");
				System.out.println("Address is blank");
			}
			if(StringUtils.isEmpty(getCity())){
				System.out.println("city is blank");
				addFieldError("city","City cannot be blank");
			}
			if(StringUtils.isEmpty(getState())){
				addFieldError("state","State cannot be blank");
			}
			if(StringUtils.isEmpty(getZipcode())){
				addFieldError("zipcode","ZipCode cannot be blank");
			}
			if(StringUtils.isEmpty(getContactperson())){
				addFieldError("contactperson","Contact Person cannot be blank");
			}
			if(StringUtils.isEmpty(getDate())){
				addFieldError("date","Date cannot be blank");
			}
			if(StringUtils.isEmpty(getPhone())){
				addFieldError("phone","Phone cannot be blank");
			}
			if(StringUtils.isEmpty(getTime())){
				addFieldError("time","Time cannot be blank");
			}
			
			 String emailString = getEmail();
			   int atpos = emailString.indexOf("@");
			   int dotpos = emailString.lastIndexOf(".");
			   if (atpos < 1 || dotpos < atpos+2 || dotpos+2 >= emailString.length())
			   {      
					System.out.println("not a valid email **************");
			      addFieldError("email","Not a valid email");
			   }

			   organization = getOrganization();
			   contactperson = getContactperson();
			   address = getAddress();
			   city = getCity();
			   state = getState();
			   zipcode = getZipcode();
			   phone = getPhone();
			   email = getEmail();
			   date = getDate();
			   time = getTime();
			   
		}

	
}