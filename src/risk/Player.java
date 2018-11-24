/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risk;


/**
 *
 * @author smsm
 */

/*  -------------------------------------------------------------
           This class is responsible to save player info
    1. Territories.
    2. ID   -> We give him unique ID to call him.
    3. Name -> Option
    4. Color -> Different Color in map.
    5. isTurn -> boolean ro decide if its turn or not;
    -------------------------------------------------------------   */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;

import javafx.scene.paint.Color;

public abstract class Player {
    static final int EGYPT_TERRITORIES = 27;
//    static final int USA_TERRITORIES = 50;
     boolean turn;
     int[] soldier_of_each_territory  = new int[EGYPT_TERRITORIES];
     ArrayList<Integer> territories;
     int soldiers;
     Color c;
     
     int getBonusSoldiers() {
    	  return Math.max(territories.size()/3, 3);
     }
     ArrayList<Integer> getTerritories(){
    	 return territories;
     }
     int getSoldiers() {
    	 return soldiers;
     }
     int getSoldiers_from_territory(int i) {
    	 return soldier_of_each_territory[i];
     }
     
     boolean isMine(int country) {
         return (territories.contains(country));
     }
     
     Color getColor() {
    	 return c;
     }
     boolean isMyTurn() {
    	 return turn;
     }
     void alterTurn() {
    	 turn = !turn;
     }
     void addSoldiers(int country , int x) {
    	 soldiers += x;
    	 soldier_of_each_territory[country] += x; 
     }
     void removeSoldiers(int country , int x) {
    	 soldiers -= x;
    	 soldier_of_each_territory[country] -= x; 
     } 
     void addTerritory(int country,int x) {
    	 territories.add(country);
    	 soldier_of_each_territory[country] = x; 
     }
     void removeTerritory(int country) {
    	 soldier_of_each_territory[country] = 0;
         territories.remove(territories.indexOf(country));
     }
     void fightStart(Player one,Player two,int a,int b,int from,int to) {
    	 // starts fight where from attack to with a soldiers and to defends with b soldiers
    	 boolean result = fight(a,b);
    	 boolean invade = false;
    	 if(result) {
    		 two.removeSoldiers(to, b);
    		 if(two.soldier_of_each_territory[to] == 0) { 
    		   	 /// remove it from the loser
    			 two.removeTerritory(to);
    			 invade = true;
    			 /// add to to winner and add 1 soldier there
    			 one.addTerritory(to, 1);
    			 one.removeSoldiers(from, 1);
    		 }
    	 }
    	 else {
    		 /// attackers soldiers die
    		 one.removeSoldiers(from, a);
    	 }
    	  GameSimulator.status = new MatchStatus(a,b,from,to,true,result,invade);
     }
     boolean fight(int a,int b) { /// determines if i win the fight , simulates dice throwing
    	 ArrayList<Integer> x =  new ArrayList<Integer>();
    	 ArrayList<Integer> y =  new ArrayList<Integer>();
    	 
    	 for(int i = 0; i < a ; i++)
    		 x.add(new Random().nextInt(6)+1);
    	 
    	 for(int i = 0; i < b ; i++)
    		 y.add(new Random().nextInt(6)+1);
    	 
    	 Collections.sort(x);
    	 Collections.sort(y);
    	 Collections.reverse(x);
    	 Collections.reverse(y);
    	 
    	 if( !Objects.equals(x.get(0), y.get(0))) {
    		 return x.get(0) > y.get(0);
    	 }
    	 
    	 if(y.size() > 1) {
    		 if( !Objects.equals(x.get(1), y.get(1))) {
    			 return x.get(1) > y.get(1);
    		 }
    	 }
    	 
    	 return false;
     }
     public abstract void distribute_soldiers(int k) ; /* Soldiers Distrubnce */
     
     public abstract void simulate_attack(Player opponent,int mapSz); /* Attack Simulation */
    
     public abstract void startAttack(Player opponent,int mapSz); /* More than 1 attack */
     
}