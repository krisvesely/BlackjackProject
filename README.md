# BlackjackProject

## Description
Provides a game space for a User to play single-deck Blackjack versus a program-generated Dealer. 
The application generates Dealer and Player objects that construct a Blackjack hand for each 
and a deck of cards for the Dealer. The Dealer automatically deals the initial two-card hand to each Player. 
If the User's hand is Blackjack or Bust, the Dealer reveals their hand, and a winner is displayed.
Otherwise, the User can hit until they opt to stay, or until their hand is Blackjack or Bust, 
at which point the Dealer reveals their full hand and hits or stays, dependent on the hand value, 
until a minimum Dealer hand value of 17 is reached. Hands are then compared to determine the round winner, 
and the User can play additional rounds until the deck is depleted beyond its capacity to continue play.

## Technologies Used
- Java OOP
- Eclipse
- Git

## Lessons Learned
- The standard four card suits and thirteen ranks are members of respective enumerated Types, 
with fields representing their names (both) and value (Rank).
- A Card class has both Suit and Rank enum Type objects as its fields.
- Deck is a class whose no-arg constructor iterates through each Rank member for each Suit member 
to instantiate a Card instance for each and adds them to its characteristic ArrayList, 
resulting in a standard 52-card deck.
- Hand is an abstract class whose field is an ArrayList.
- Blackjack Hand is a concrete sub-class to Hand, which adds a hand-valuation field and method specific to Blackjack. 
- A Blackjack Hand constitutes the Player class' field. A Dealer class extends Player and further includes 
a deck as a field.
- When the application runs, no-arg constructors for a Dealer and a Player (the application User) are called. 
Since both are Players, their instantiation includes new Blackjack Hands for each. The Dealer constructor 
also instantiates a Deck.
- Gameplay enters a loop that starts with the Dealer shuffling the Deck Collection. 
The first two cards are dealt to both Players, and are displayed depending upon their class 
(Player super-class vs. Dealer sub-class) consistent with Blackjack conventions. Cards are removed 
from the Dealer's ArrayList Deck as they are added to the respective Players' ArrayList Blackjack Hands.
- Conditionals evaluate whether the User's Hand is Blackjack or Bust, and if not, presents them the option to 
hit or stay.
- Once the User opts to stay, or their Hand is Blackjack or Bust, the Dealer reveals their Hand, and conditionals 
determine whether the Dealer hits or stays according to Blackjack rules.
- The User and Dealer Hands are compared at the end of each round to determine a winner or tie.
- Finally, the User has the option to play additional rounds so long as there are sufficient cards in the Deck. 
If additional rounds are selected, both Players' Hand ArrayLists are cleared, the loop cycles, and the 
Deck is shuffled (with the Cards dealt in previous rounds out of play).