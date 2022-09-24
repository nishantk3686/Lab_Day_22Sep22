package lab.day;

import javax.persistence.Entity;

@Entity
public class experienceEmployee extends employee {
	private int experience;
	private int hike;
	@Override
	public String toString() {
		return "experienceEmployee [empFirstName=" +empFirstName+", empLastName=" +empLastName+" ,experience=" + experience + ", hike=" + hike + "]";
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getHike() {
		return hike;
	}
	public void setHike(int hike) {
		this.hike = hike;
	}
	
}