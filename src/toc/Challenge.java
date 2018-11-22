package toc;

public class Challenge {
	private int challengeNo;
        private String type;
        private String enemy;
        private int skillLevelReq;
        private int reward;
        
	
	public Challenge(int n, String type, String enemy, int skillReq, int reward) {
				this.challengeNo = n; 
                this.type = type; 
                this.enemy = enemy; 
                this.skillLevelReq = skillReq; 
                this.reward = reward;
	}
	
	public int getChallengeNo() {
		return challengeNo;
	}
        
        public String getType() {
		return type;
	}
        
        public String getEnemy() {
		return enemy;
	}
        
        public int getSkillReq() {
		return skillLevelReq;
	}
        
        public int getReward() {
		return reward;
	}
        
        @Override
        public String toString() {
            return "Number: " + challengeNo
            + "\nType: " + type
            + "\nEnemy Name: " + enemy
            + "\nSkill level required: " + skillLevelReq
            + "\nReward: " + reward + "\n";
        }
}
