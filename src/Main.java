import java.util.LinkedList;
import java.util.Scanner;

class Main {

	public static void printMenu() {
		System.out.println("\n\nWelcome to the Main Menu");
		System.out.println("0: Exit");
		System.out.println("1: Test CardsUtil Functions");
		System.out.println("2: Play Greedy War!");
		System.out.print("\nYour selection: ");

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int mainSelection;

		do {
			printMenu();

			mainSelection = Integer.parseInt(in.nextLine().trim());
			if (mainSelection == 1) {
				CardsUtil.testCardsUtil();
				System.out.println();
			} else if (mainSelection == 2) {
				// creating the standard deck
				LinkedList<Card> deck = CardsUtil.createStandardDeck();
        
        // dealing the cards (dealCards shuffles before dealing)
        LinkedList<Card> computerHand = (LinkedList<Card>) CardsUtil.dealCards(deck, 26);
        LinkedList<Card> userHand = (LinkedList<Card>) CardsUtil.dealCards(deck, 26);

        boolean userContinue = true;
        int i = 1;
        //while x != q (quit) or while both players still have cards
        while( userContinue || computerHand.size() > 0 || userHand.size() > 0 || i > 0){
            System.out.println("=========================Round #"+i+"=========================");
            i++;
            System.out.println("Computer Card: ");
            Card computer = GreedGameUtil.playHand(computerHand);
            int computerCard = computer.getRank();

            System.out.println("User Card: ");
            Card card1 = GreedGameUtil.playHand(userHand);
            int userCard1 = card1.getRank();
            
            if (card1.getRank() == 1) {
              System.out.println("You WON this round with an ACE!!!");
              userHand.addLast(card1);
              userHand.addLast(computer);
            }
            
            else if (computer.getRank() == 1) {
              System.out.println("You LOSE this round to an ACE!!!");
              computerHand.addLast(card1);
              computerHand.addLast(computer);
            }

            else if (userCard1 > computerCard) {
              System.out.println("You WON this round!!!");
              userHand.addLast(card1);
              userHand.addLast(computer);
            }

            else if (userCard1 < computerCard){
              System.out.println("Would you like to draw another card? Y/N");
              boolean proceed = CheckInput.getYesNo();
              if (proceed) {
                System.out.println("User Card: ");
                Card card2 = GreedGameUtil.playHand(userHand);
                int userCard2 = card2.getRank();
                if (userCard1 + userCard2 <= computerCard) {
                  System.out.println("You WON this round!!!");
                  userHand.addLast(card1);
                  userHand.addLast(card2);
                  userHand.addLast(computer);
                }
                else {
                  System.out.println("You LOSE this round!!!");
                  computerHand.addLast(card1);
                  computerHand.addLast(card2);
                  computerHand.addLast(computer);
                }
              }
              else {
                System.out.println("You LOSE this round!!!");
                computerHand.addLast(card1);
                computerHand.addLast(computer);
              }
            }
            else {
              System.out.println("This means WAR!!!!");
              LinkedList<Card> computerWar = (LinkedList<Card>) GreedGameUtil.playWarHand(computerHand);
              LinkedList<Card> userWar = (LinkedList<Card>) GreedGameUtil.playWarHand(userHand);
              System.out.println("Computer's Card: ");
              Card computerWarCard = GreedGameUtil.playHand(computerWar);
              System.out.println("User's Card: ");
              Card userWarCard = GreedGameUtil.playHand(userWar);
              if (userWarCard.getRank() > computerWarCard.getRank()) {
                System.out.println("You WON THE WAR round!!");
                userHand.addLast(card1);
                userHand.addLast(computer);
                userHand.addLast(computerWarCard);
                userHand.addLast(userWarCard);
                CardsUtil.addCardsTo(userHand, userWar);
                CardsUtil.addCardsTo(userHand, computerWar);
              }
              else if (computerWarCard.getRank() > userWarCard.getRank()) {
                System.out.println("You LOST THE WAR round!");
                computerHand.addLast(card1);
                computerHand.addLast(computer);
                computerHand.addLast(computerWarCard);
                computerHand.addLast(userWarCard);
                CardsUtil.addCardsTo(computerHand, userWar);
                CardsUtil.addCardsTo(computerHand, computerWar);
              }
              else {
                System.out.println("You WON THE WAR round!!");
                userHand.addLast(card1);
                userHand.addLast(computer);
                userHand.addLast(computerWarCard);
                userHand.addLast(userWarCard);
                CardsUtil.addCardsTo(userHand, userWar);
                CardsUtil.addCardsTo(userHand, computerWar);
              }
            }
            if (computerHand.size() <= 0) {
              System.out.println("You WON the game of War!");
              break;
            }
            else if (userHand.size() <= 0) {
              System.out.println("You LOST the game of War!");
              break;
            }
            System.out.println("Your deck's size: " + userHand.size());
            System.out.println("Computer's deck size: " + computerHand.size()+" \n");
            System.out.println("Would you like to continue? Y/N");
            boolean userCont = CheckInput.getYesNo();
            if (userCont == false) {
              userContinue = false;
              break;
              }
        }
			} else if (mainSelection != 0){ 
        
				System.out.println("Your selection is invalid. You will be taken back to the main menu.");
			}
 
		} while (mainSelection != 0);

	  in.close();
    System.out.println("GoodBye!");
	}
}