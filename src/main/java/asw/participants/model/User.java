package asw.participants.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.*;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class User {
	@XmlAttribute
	private String firstName;
	@XmlAttribute
	private String lastName;
	@XmlAttribute
	private String email;
	@XmlAttribute
	private Date dateOfBirth;
	@XmlAttribute
	private String password;
	
	@XmlAttribute
	private String address;
	@XmlAttribute
	private String nationality;
	@XmlAttribute
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
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
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
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", Email=" + email + ", dateOfBirth="
				+ dateOfBirth + ", Address=" + address + ", Nationality=" + nationality + ", DNI=" + DNI + "]";
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
