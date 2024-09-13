/**
represents a Card with a suit and rank
**/
public class Card {
	
	private Suits suit;
	private int rank;
	
	/**
  Overloaded constructor intializes a Card with given rank and suit 
  @param rank - the rank as an int
  @param suit - the suit as a Suit enum type.
   **/
	public Card( int rank, Suits suit) {
		this.rank = rank;
    this.suit = suit;
	}
	
  /**
  gets the suit of this Card 
  @return Suit enum type of this Card
  **/
	public Suits getSuit() {
		return this.suit;
	}
	
  /**
  gets the rank of this Card
  **/
	public int getRank() {
    return this.rank;
	}

  /**
  returns a description  of this Card that includes the rank and suit
  **/
	public String toString()
	{
		
		String suitSymbol = "Invalid";
		String rankSymbol = "Invalid";
		
		if( this.rank > 1 && this.rank < 11) {
			rankSymbol = Integer.toString(this.rank);
		}
		if (this.rank == 1) {
			rankSymbol = "A";
		}
	  if (this.rank == 11) {
			rankSymbol = "J";
		}
		if (this.rank == 12) {
			rankSymbol = "Q";
		}
		if (this.rank == 13) {
			rankSymbol = "K";
		}

		
		switch(this.suit) {
			case HEARTS:
				suitSymbol = "\u2665";
				break;
			case SPADES:
				suitSymbol = "\u2660";
        break;
			case DIAMONDS:
				suitSymbol = "\u2666";
				break;
			case CLUBS:
				suitSymbol = "\u2663";
				break;
		}
				
		return rankSymbol + suitSymbol;
	}
	
}


