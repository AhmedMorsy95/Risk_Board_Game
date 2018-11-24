package risk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;

import javafx.scene.paint.Color;

public abstract class AIPlayer {
     boolean turn;
     int soldiers_of_each_territory[]  = new int[55];
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
    	 return soldiers_of_each_territory[i];
     }
     boolean isMine(int country) {
    	 for(int i=0;i<territories.size();i++) {
    		 if(territories.get(i) == country) {
    			 return true;
    		 }
    	 }
    	 return false;
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
    	 soldiers_of_each_territory[country] += x; 
     }
     void removeSoldiers(int country , int x) {
    	 soldiers -= x;
    	 soldiers_of_each_territory[country] -= x; 
     } 
     void addTerritory(int country,int x) {
    	 territories.add(country);
    	 soldiers_of_each_territory[country] = x; 
     }
     void removeTerritory(int country) {
    	 soldiers_of_each_territory[country] = 0;
    	 for(int i=0;i<territories.size();i++) {
    	     if(territories.get(i) == country)
    	    	 territories.remove(i);
    	 }
     }
     void fightStart(Player one,Player two,int a,int b,int from,int to) {
    	 // starts fight where from attack to with a soldiers and to defends with b soldiers
    	 boolean result = fight(a,b);
    	 //System.out.print(from + " " + to + " " + a + " " + b + " " + result + "\n");
    	 if(result) {
    		 two.removeSoldiers(to, b);
    		 if(two.soldier_of_each_territory[to] == 0) { 
    		   	 /// remove it from the loser
    			 two.removeTerritory(to);
    			 /// add to to winner and add 1 soldier there
    			 one.addTerritory(to, 1);
    			 one.removeSoldiers(from, 1);
    		 }
    	 }
    	 else {
    		 /// attackers soldiers die
    		 one.removeSoldiers(from, a);
    	 }
     }
     boolean fight(int a,int b) { /// determines if i win the fight , simulates dice throwing
    	 ArrayList<Integer> x =  new ArrayList<Integer>();
    	 ArrayList<Integer> y =  new ArrayList<Integer>();
    	 
    	 for(int i=0;i<a;i++) {
    		 Random r = new Random();
    		 x.add(r.nextInt(6)+1);
    	 }
    	 
    	 for(int i=0;i<b;i++) {
    		 Random r = new Random();
    		 y.add(r.nextInt(6)+1);
    	 }
    	 
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
     public abstract void distribute_soldiers(int k,Player opponent,int mapSz) ; /// strategy depends on the agent
     
     public abstract void simulate_attack(Player opponent,int mapSz) ; /// strategy depends on agent
    
     public abstract void startAttack(Player opponent,int mapSz); // in case we want to make more than one attack
     
}
