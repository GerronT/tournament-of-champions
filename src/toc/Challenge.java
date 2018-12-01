package toc;

import java.io.Serializable;

public class Challenge implements Serializable{
	private int challengeNo;
        private String type;
        private String enemy;
        private int skillLevelReq;
        private int reward;
        public static int initialChNo = 1;
        
	
	public Challenge(String type, String enemy, int skillReq, int reward) {
				this.challengeNo = initialChNo;
				initialChNo++;
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
            return "Challenge No.: " + challengeNo
            + "\n Type: " + type
            + "\n Enemy Name: " + enemy
            + "\n Skill level required: " + skillLevelReq
            + "\n Reward: " + reward + "\n";
        }
}
