import java.util.Random;

public abstract class GameCharacter 
{
	protected int CHAR_MAX_HP=0;
	protected String name;
	protected int hitPoints;
	protected int strength;
	protected int intelligence;
	protected int wisdom;
	
	protected String[][] randomNames ={{"Arthur","Achilles","Hector"},{"Conan","Caesar","Lancilot"},{"Harry P.","Felonius","Gandalf"}};
	protected static int howManyNames = 3;
	
	public abstract void randGen(boolean areHitPointsMaxed);

	public String getName(){
		return name;
	}
	
	public int getStrength()
	{
		return strength;
	}
	
	public int getIntelligence()
	{
		return intelligence;
	}
	
	public int getWisdom()
	{
		return wisdom;
	}
	
	protected int rollDice(int numFaces)
	{
		Random dice = new Random();
		// Rolls a numFaces-sided dice
		return(1 + dice.nextInt(numFaces));
	}
	
	public String display()
	{
		String result = "";
		String format = "%-15s%s%n";
		result += String.format(format,"Name:", name);
		result += String.format(format,"Hit Points:",hitPoints);
		result += String.format(format,"Strength:",strength);
		result += String.format(format,"Intelligence:",intelligence);
		result += String.format(format,"Wisdom:",wisdom);
		return result;
	}
	
}
