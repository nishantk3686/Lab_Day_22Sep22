package lab.day;
import javax.persistence.Entity;

@Entity
public class fresherEmployee extends employee{
	private int contractPeriod;
	private int increment;
	@Override
	public String toString() {
		return "fresherEmployee [empFirstName=" +empFirstName+", empLastName=" +empLastName+" ,contractPeriod=" + contractPeriod + ", increment=" + increment + "]";
	}
	public int getContractPeriod() {
		return contractPeriod;
	}
	public void setContractPeriod(int contractPeriod) {
		this.contractPeriod = contractPeriod;
	}
	public int getIncrement() {
		return increment;
	}
	public void setIncrement(int increment) {
		this.increment = increment;
	}
	
}