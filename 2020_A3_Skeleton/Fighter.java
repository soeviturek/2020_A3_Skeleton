public class Fighter extends GameCharacter 
{
	private static int FIGHTER_MAX_HP = 10; 
	
	public Fighter()
	{
		super.CHAR_MAX_HP = FIGHTER_MAX_HP;		
	}

	@Override
	public void randGen(final boolean areHitPointsMaxed) 
	{	
		// HitPoints
		if (areHitPointsMaxed)
			this.hitPoints = FIGHTER_MAX_HP;
		else
			hitPoints = rollDice(10);
		
		// STR, INT, WIS
		strength = rollDice(6) + rollDice(6) + rollDice(6) + 1;
		intelligence = rollDice(6) + rollDice(6) + rollDice(6);
		wisdom = rollDice(6) + rollDice(6) + rollDice(6);
		
		int i,j;
		i = rollDice(GameCharacter.howManyNames)-1;
		j = rollDice(GameCharacter.howManyNames)-1;
		name = randomNames[i][j];
	}
	
	@Override
	public String display()
	{
		String result = "";
		String format = "%-15s%s%n";
		result += String.format(format,"Class:","Fighter");
		result += super.display();
		return result;
	}

}
