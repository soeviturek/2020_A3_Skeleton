

import java.util.Arrays;
import java.util.Scanner;

public class GameCharGenModel 
{
	static public int NUM_CHARS_BLOCK = 500;
	final public int STRENGTH=0; 
	final public int INTELLIGENCE=1; 
	final public int WISDOM=2;
	
	private int gameCharCount=0;
	private GameCharacter[] randomGameChars = new GameCharacter[NUM_CHARS_BLOCK];
	
	/**
	 * Returns the number of randomly-generated characters so far. 
	 * @return Number of randomly-generated characters.
	 */
	public int getNumCharacters()
	{
		return gameCharCount;
	}
	
	/**
	 * Adds a character to the array of characters
	 * @param c character to be added
	 */
	public void addGameCharacter(GameCharacter c)
	{
		if (gameCharCount>=randomGameChars.length)
		{
			GameCharacter[] newRandomChars = Arrays.copyOf(randomGameChars,randomGameChars.length+GameCharGenModel.NUM_CHARS_BLOCK);
			randomGameChars = newRandomChars;
		}
			
		randomGameChars[gameCharCount] = c;
		gameCharCount++;
	}
	
	/**
	 * Returns a character at a given index
	 * @param idx Provided index
	 * @return Character at a given index
	 */
	public GameCharacter gameCharacterAt(int idx)
	{
		if (idx<0 || idx>=randomGameChars.length)
			throw new IndexOutOfBoundsException();
		
		return randomGameChars[idx];
	}
	
	/**
	 * Finds a character with either maximum strength, intelligence or wisdom based on the parameter passed.
	 * @return Index of the character with lowest HP in the character array.
	 * @throws NoGameCharacterFoundException
	 */
	public String[] wisestOfThemAll() throws NoGameCharacterFoundException
	{
		//Implement Q2 here
		if(gameCharCount == 0){
			throw new NoGameCharacterFoundException();
		}
		String[] result= new String[4];
		double averageWisdom = 0;
		int characterCount = 0;
		int maxValue = 0;
		int characterIndex = 0;
		String name = null;
		for(int i = 0; i<gameCharCount;i++) {
			GameCharacter character = gameCharacterAt(i);
			int characterWisdom = character.getWisdom();
			averageWisdom+= characterWisdom;
			characterCount++;
			//update maximum
			if(characterWisdom > maxValue){maxValue=characterWisdom; characterIndex = i; name = character.getName();}
		}
		averageWisdom = averageWisdom / gameCharCount;
		result[0] = "Character Index:\t\t"+Integer.toString(characterIndex);
		result[1] = "Character Name:\t\t"+name;
		result[2] = "Character Wisdom:\t\t"+Integer.toString(maxValue);
		result[3] = "Average Wisdom:\t\t"+Double.toString(averageWisdom);
		return result;
	}
	
	
	public void wiserThanStrongOrStrongAsWise() throws NoGameCharacterFoundException
	{
		// Implement Q3 here
		if(gameCharCount == 0){
			throw new NoGameCharacterFoundException();
		}

		
	}

	public String display() {
		String result = "";
		// Implement Q4 here
		for(int i = 0; i < gameCharCount; i++) System.out.println(gameCharacterAt(i).display());
		return result;
	}
}
