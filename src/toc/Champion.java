package toc;

import java.io.Serializable;

public class Champion implements Serializable {
	
	private String championName;
	private int skillLevel;
	private int entryFee;
	private String status;
	
	public Champion(String championName, int skillLevel, int entryFee) {
		this.championName = championName;
		this.skillLevel = skillLevel;
		this.entryFee = entryFee;
		this.status = ChampionState.WAITING.toString();
		
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
		return "Name: " + championName 
				+ "\n Skill Level: " + skillLevel 
				+ "\n Entry Fee: " + entryFee 
				+ "\n Status: " + status + getExtraDetails() + "\n";
	}

	public String getExtraDetails() {
		return "";
	}
	
	public boolean[] getChallengeAuthorisation () {
            return new boolean[] {false, false, false};
        }
}
