package asw.participants.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
	private String firstName;
	private String lastName;
	private String Email;
	private Date dateOfBirth;
	private String password;
	
	private String Address;
	private String Nationality;
	private String DNI;
	
	@Id @GeneratedValue
	private Long id;
	
	User() {
	}

	public User(String DNI) {
		super();
		this.DNI = DNI;
	}

	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getNationality() {
		return Nationality;
	}

	public void setNationality(String nationality) {
		Nationality = nationality;
	}

	public String getDNI() {
		return DNI;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DNI == null) ? 0 : DNI.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (DNI == null) {
			if (other.DNI != null)
				return false;
		} else if (!DNI.equals(other.DNI))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", Email=" + Email + ", dateOfBirth="
				+ dateOfBirth + ", Address=" + Address + ", Nationality=" + Nationality + ", DNI=" + DNI + "]";
	}

	public String toXML(){
		StringBuilder sb = new StringBuilder();
		
		sb.append("<user>");
		
		sb.append("<DNI>");
		if(this.getDNI()!=null)
			sb.append(this.getDNI());
		sb.append("</DNI>");
		
		sb.append("<firstName>");
		if(this.getFirstName()!=null)
		sb.append(this.getFirstName());
		sb.append("</firstName>");
		
		sb.append("<lastName>");
		if(this.getLastName()!=null)
			sb.append(this.getLastName());
		sb.append("</lastName>");
		
		sb.append("<Email>");
		if(this.getEmail()!=null)
			sb.append(this.getEmail());
		sb.append("</Email>");
		
		sb.append("<dateOfBirth>");
		if(this.getDateOfBirth()!=null)
			sb.append(this.getDateOfBirth());
		sb.append("</dateOfBirth>");
		
		sb.append("<Address>");
		if(this.getAddress()!=null)
			sb.append(this.getAddress());
		sb.append("</Address>");
		
		sb.append("<Nationality>");
		if(this.getNationality()!=null)
			sb.append(this.getNationality());
		sb.append("</Nationality>");

		sb.append("</user>");
		
		return sb.toString();
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
