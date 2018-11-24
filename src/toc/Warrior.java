package toc;

public class Warrior extends Champion{
	
	private String weapon;
	
	public Warrior(String championName, int entryFee, String weapon) {
		super(championName, calculateSkillLevel(entryFee), entryFee);
		this.weapon = weapon;
	}
	
	public static int calculateSkillLevel(int entryFee) {
		return entryFee / 100;
	}
	
	@Override
	public String getExtras() {
		return "\n Weapon: " + weapon
                       + "\n Class: " + "Warrior";
	}
        public boolean[] getChallengeAuthorisation () {
            return new boolean[] {false, true, false};
        }
}
