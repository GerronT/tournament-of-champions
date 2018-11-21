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
		return ", Weapon: " + weapon;
	}
        public boolean[] getTypes () {
            return new boolean[] {false, true, false};
        }
}
