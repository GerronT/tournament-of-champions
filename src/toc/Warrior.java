package toc;

import java.io.Serializable;

public class Warrior extends Champion implements Serializable{
	
	private String weapon;
	
	public Warrior(String championName, int entryFee, String weapon) {
		super(championName, calculateSkillLevel(entryFee), entryFee);
		this.weapon = weapon;
	}
	
	public static int calculateSkillLevel(int entryFee) {
		return entryFee / 100;
	}
	
	@Override
	public String getExtraDetails() {
		return "\n Weapon: " + weapon
                       + "\n Class: " + "Warrior";
	}
        public boolean[] getChallengeAuthorisation () {
            return new boolean[] {false, true, false};
        }
}
