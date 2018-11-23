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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javafx.scene.paint.Color;


public class GameSimulator {
    Player first;
    Player second;
    int boardSize;
    static MatchStatus status;
	GameSimulator(String a,String b ,int nTerritories,int extra){  /// constructor ,  sets the game initial conditions
    	first = Factory.getPlayer(a);
    	second = Factory.getPlayer(b);
    	boardSize = nTerritories;
    	status = new MatchStatus();
    	/// initial configuration
    	first.turn = true;
    	second.turn = false;
    	first.c = Color.RED;
    	second.c = Color.BLUE;
    	first.soldiers = nTerritories;
    	second.soldiers = nTerritories;
    	/// now we have 2 instances , randomly distribute territories
    	randomDistributeTerritories(nTerritories);
    	randomDistributeExrta(extra);
    	/// now we distributed territories and extra soldiers
    	/// we are ready to play!
        for(int i : first.soldier_of_each_territory)
                System.out.print(i +" ");
            System.out.println("");
        for(int i : second.soldier_of_each_territory)
                System.out.print(i + " ");
            System.out.println("");
    }
	void play() {  /// called by the gui , simulates one turn only
		if(first.turn) {
			first.distribute_soldiers(first.getBonusSoldiers());
			first.startAttack(second , boardSize);
		}
                else if(second.turn) {
			second.distribute_soldiers(first.getBonusSoldiers());
			second.startAttack(first , boardSize);
		}
		 first.alterTurn();
	     second.alterTurn();
	}

	private void randomDistributeTerritories(int n) {
		  ArrayList<Integer>x = new ArrayList<Integer>();
		  for(int i = 0; i < n;i++) {
			  x.add(i);
		  }
		  
		  Collections.shuffle(x);
		  for(int i = 0; i < n; i++) {
			  if(i*2 < n) {
				  first.addTerritory(x.get(i), 1);
			  }
			  else {
				  second.addTerritory(x.get(i), 1);
			  }
		  }
	}
	
	private void randomDistributeExrta(int extra) {
		for(int i = 0; i < extra;i++) {
			int x = new Random().nextInt(first.getTerritories().size());
			int y = new Random().nextInt(second.getTerritories().size());
			first.addSoldiers(first.getTerritories().get(x), 1);
			second.addSoldiers(second.getTerritories().get(y), 1);
		}
	}
}