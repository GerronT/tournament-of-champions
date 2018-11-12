package toc;

import java.io.*;
/**
 * Enumeration class ChallengeType - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum ChallengeType implements Serializable
{
    MAGIC(" Magic"), FIGHT("Fight"), MYSTERY ("Mystery");
    private String type;
    
    private ChallengeType(String ty)
    {
        type = ty;
    }
    
    public String toString()
    {
        return type;
    }
}
