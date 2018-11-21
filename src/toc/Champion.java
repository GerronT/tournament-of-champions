package toc;

public class Champion {
	
	private String championName;
	private int skillLevel;
	private int entryFee;
	private String status;
	
	public Champion(String championName, int skillLevel, int entryFee) {
		this.championName = championName;
		this.skillLevel = skillLevel;
		this.entryFee = entryFee;
		this.status = "Waiting";
		
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
	
	public int getEntryFee() {
		return entryFee;
	}
        
        public int getSkillLevel() {
		return skillLevel;
	}
	
	public String getChampionName() {
		return championName;
	}
	
	public String getChampionDetails() {
		return "Name: " + championName + ", Skill Level: " + skillLevel + ", Entry Fee: " + entryFee + ", Status: " + status + getExtras();
	}

	public String getExtras() {
		return null;
	}
	public boolean[] GetChallengeAuthorisation () {
            return new boolean[] {false, false, false};
        }
}
