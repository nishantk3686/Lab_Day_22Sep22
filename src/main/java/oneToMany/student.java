
/**
 * @author Nishant Kumar
 * Illustrating STUDENT MANAGEMENT SYSTEM TO CREATE STUDENT, LAPTOP AND ADD TO DATABASE USING HIBERNATE 
 * AND PRINT DATA OF ONE OR ALL STUDENTS AND LAPTOPS, DELETE STUDENT USING DATA ACCESS OBJECT AND HQL 
 * ILLUSTRATING ONE TO MANY MAPPING OF ENTITY IN DATABASE USING HIBERNATE
 * ONE STUDENT -> MANY LAPTOP
 */


package oneToMany;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

// ONE TO MANY MAPPING
// ONE STUDENT -> MANY LAPTOPS
@Entity
public class student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int stId;
	private String stFirstName;
	private String stLastName;
	private String stDoamin;
	private String stEmail;
	private String stContact;
	private int stAge;
	
	
	@OneToMany
	@JoinColumn(name = "stId")
	private List<laptop> l;

	public int getStId() {
		return stId;
	}

	public void setStId(int stId) {
		this.stId = stId;
	}

	public String getStFirstName() {
		return stFirstName;
	}

	public void setStFirstName(String stFirstName) {
		this.stFirstName = stFirstName;
	}

	public String getStLastName() {
		return stLastName;
	}

	public void setStLastName(String stLastName) {
		this.stLastName = stLastName;
	}

	public String getStDoamin() {
		return stDoamin;
	}

	public void setStDoamin(String stDoamin) {
		this.stDoamin = stDoamin;
	}

	public String getStEmail() {
		return stEmail;
	}

	public void setStEmail(String stEmail) {
		this.stEmail = stEmail;
	}

	public String getStContact() {
		return stContact;
	}

	public void setStContact(String stContact) {
		this.stContact = stContact;
	}

	public int getStAge() {
		return stAge;
	}

	public void setStAge(int stAge) {
		this.stAge = stAge;
	}

	public List<laptop> getL() {
		return l;
	}

	public void setL(List<laptop> l) {
		this.l = l;
	}

	@Override
	public String toString() {
		return "\n\nstudent [stId=" + stId + ", stFirstName=" + stFirstName + ", stLastName=" + stLastName + ", stDoamin="
				+ stDoamin + ", stEmail=" + stEmail + ", stContact=" + stContact + ", stAge=" + stAge + ", l=" + l
				+ "]";
	}
	
	
	
}