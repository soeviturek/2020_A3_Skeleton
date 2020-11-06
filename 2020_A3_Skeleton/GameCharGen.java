import java.util.Scanner;

public class GameCharGen 
{
	public void displayMenu()
	{
		System.out.print("*** WoK GameCharGen Menu***\n");
		System.out.print(String.format("%-24s"," Create Wizard"));
		System.out.print("WZ\n");
		System.out.print(String.format("%-24s"," Create Fighter"));
		System.out.print("FG\n");
		System.out.print(String.format("%-24s"," Create Cleric"));
		System.out.print("CL\n");
		System.out.print(String.format("%-24s"," WisestOfThemAll"));
		System.out.print("WC\n");
		System.out.print(String.format("%-24s"," WiserThanStrongAsWise"));
		System.out.print("WS\n");
		System.out.print(String.format("%-24s"," Display Characters"));
		System.out.print("DC\n");
		System.out.print(String.format("%-24s"," Exit Program"));
		System.out.print("EX\n");
		System.out.print(" Enter Selection: ");

	}

	public void run() throws NoGameCharacterFoundException
	{
		GameCharGenModel myCharGen = new GameCharGenModel();
		Scanner menuInput = new Scanner(System.in);
		
		// Implement Q1 & Q4 menu updates here
		// Q2, Q3, & Q4 will be implemented in the GameCharGenModel class

		while(true) {
			displayMenu();
			GameCharacter character = null;
			String userInput = menuInput.nextLine().toUpperCase();
			switch (userInput) {
				case "WZ":
					character = new Wizard();
					character.randGen(true);
					break;
				case "FG":
					character = new Fighter();
					character.randGen(false);
					break;
				case "CL":
					character = new Cleric();
					character.randGen(true);
					break;
				case "WC":
					String[] results = myCharGen.wisestOfThemAll();
					for(String s : results) System.out.println(s);
					break;
				case "WS":
					myCharGen.wiserThanStrongOrStrongAsWise();
					myCharGen.display();
					break;
				case "DC":
					myCharGen.display();
					break;
				case "EX":
					System.exit(0);
					break;

				default:
					System.out.println("Unrecognised command.");
			}
			if (character != null) {
				myCharGen.addGameCharacter(character);
				System.out.println(character.display());
			}
		}
		
	}
}
