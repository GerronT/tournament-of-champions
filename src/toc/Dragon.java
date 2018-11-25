package toc;

import java.io.Serializable;

public class Dragon extends Champion implements Serializable{

	private boolean talks;
	
	public Dragon(String championName, boolean talks) {
		super(championName, 7, 500);
		this.talks = talks;
	}
	
	@Override
	public String getExtraDetails() {
		return "\n Talks: " + talks
                        + "\n Class: " + "Dragon";
	}
        public boolean[] getChallengeAuthorisation () {
            return new boolean[] {false, true, talks};
        }
}
