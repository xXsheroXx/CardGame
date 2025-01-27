/*
 * Use scan.readLine() when reading menu alternatives. Use string.charAt(int index) 
 * to get a specific character from the input string. 
 */

import cardutils.Card;
import psModel.PsLogic;

import java.util.Scanner;

public class PsUserInterface {

	private Scanner scan;
	private PsLogic psLogic;

    public PsUserInterface() {
    	scan = new Scanner(System.in);
		this.psLogic = new PsLogic();
    }
    
    // main loop
    public void run() {
    	char choice = ' ';
    	String answer;
    	
    	do {
    		printMenu();
    		answer = scan.nextLine();
    		answer = answer.toUpperCase();
    		choice = answer.charAt(0); // first character
    		
    		switch(choice) {
    			case 'N':	game(); break;
    			case 'X':	System.out.println("Bye, bye!"); break;
    			default: 	System.out.println("Unknown command");
    		}
    		
    	} while(choice != 'X');
    }

    public void game() {
		System.out.println("Starting a new game.......");
		psLogic.initNewGame();
		System.out.println("Ready...");
			while (!psLogic.isGameOver()) {
				pickACard();
			}
		System.out.println("Your points: "+psLogic.getPoints()+"points");
    }

    public void pickACard() {
		String choice;
		Card nextCard= psLogic.pickNextCard();
		System.out.println(psLogic);
		System.out.println("Next card: "+nextCard);
		int index=0;
		do {
			System.out.println("Where do you want to place the card [1..5]: ");
			choice= scan.nextLine();
			index= Integer.parseInt(choice.trim())-1;
			if (psLogic.getPiles().get(index).getSize()>=5){
				System.out.println("Pile is full");
				System.out.println("Next card: "+nextCard);
			}

		} while (psLogic.getPiles().get(index).getSize()>=5);
		psLogic.addCardToPile(index);
    }
    
    public void printMenu() {
    	System.out.println("---Menu---");
    	System.out.println("N New game");
    	System.out.println("X Exit");
    	System.out.println("----------");
    }

}