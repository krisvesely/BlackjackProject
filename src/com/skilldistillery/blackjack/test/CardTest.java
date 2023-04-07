package com.skilldistillery.blackjack.test;

import com.skilldistillery.blackjack.entities.*;


public class CardTest {
  public static void main(String[] args) {
    Rank[] ranks = Rank.values();
    for(int i=0; i<ranks.length; i++) {
      System.out.println(ranks[i].toString() + " " + ranks[i].getValue());
    }
    
    for(Suit s : Suit.values()){
      System.out.println(s);
    }
  }
}
