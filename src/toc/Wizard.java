package toc;

public class Wizard extends Champion{
	
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
	public String getExtras() {
		return ", Necromancer: " + (necromancer ? "Yes" : "No") + ", Speciality: " + speciality;
	}

        public boolean[] GetChallengeAuthorisation () {
            return new boolean[] {true, true, true};
        }
}
