package toc;

import java.io.Serializable;

public class Wizard extends Champion implements Serializable{
	
	private boolean necromancer;
	private String speciality;
	
	public Wizard(String championName, int skillLevel, boolean necromancer, String speciality) {
		super(championName, skillLevel, calculateEntryFee(necromancer));
		this.necromancer = necromancer;
		this.speciality = speciality;
		
	}
	
	public static int calculateEntryFee(boolean necromancer) {
		return necromancer ? 400 : 300;
	}
	
	@Override
	public String getExtraDetails() {
		return "\n Necromancer: " + necromancer 
				+ "\n Speciality: " + speciality
                        + "\n Class: " + "Wizard";
	}

        public boolean[] getChallengeAuthorisation () {
            return new boolean[] {true, true, true};
        }
}
