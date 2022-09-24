
/**
 * @author Nishant Kumar
 * Illustrating STUDENT MANAGEMENT SYSTEM TO CREATE STUDENT, LAPTOP AND ADD TO DATABASE USING HIBERNATE 
 * AND PRINT DATA OF ONE OR ALL STUDENTS AND LAPTOPS, DELETE STUDENT USING DATA ACCESS OBJECT AND HQL 
 * ILLUSTRATING ONE TO MANY MAPPING OF ENTITY IN DATABASE USING HIBERNATE
 * ONE STUDENT -> MANY LAPTOP
 */

package oneToMany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// ONE TO MANY MAPPING
// ONE STUDENT -> MANY LAPTOP
@Entity
public class laptop {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int lapId;
	private String lapName;
	private String lapOs;
	private String lapIp;
	private int lapRAM;
	public int getLapId() {
		return lapId;
	}
	public void setLapId(int lapId) {
		this.lapId = lapId;
	}
	public String getLapName() {
		return lapName;
	}
	public void setLapName(String lapName) {
		this.lapName = lapName;
	}
	public String getLapOs() {
		return lapOs;
	}
	public void setLapOs(String lapOs) {
		this.lapOs = lapOs;
	}
	public String getLapIp() {
		return lapIp;
	}
	public void setLapIp(String lapIp) {
		this.lapIp = lapIp;
	}
	public int getLapRAM() {
		return lapRAM;
	}
	public void setLapRAM(int lapRAM) {
		this.lapRAM = lapRAM;
	}
	@Override
	public String toString() {
		return "\nlaptop [lapId=" + lapId + ", lapName=" + lapName + ", lapOs=" + lapOs + ", lapIp=" + lapIp + ", lapRAM="
				+ lapRAM + "]";
	}
	
	
}