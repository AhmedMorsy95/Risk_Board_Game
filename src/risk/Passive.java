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

public class Passive extends Player {

	Passive(){ /// empty constructor
		territories = new ArrayList<Integer>();
		soldier_of_each_territory = new int[52];
	}
	
  
	@Override
	public void distribute_soldiers(int numberOfSoldiers) {
		///A completely passive agent, that places all of its bonus armies to the territory with
		//the fewest armies, and doesn’t make any attacks.
           int fewestArmies = Integer.MAX_VALUE , index = -1;
           for(int i = 0; i < territories.size();i++) {
        	   if(fewestArmies > soldier_of_each_territory[territories.get(i)]) {
        		   fewestArmies = soldier_of_each_territory[territories.get(i)];
        		   index = territories.get(i);
        	   }
           }
           
           addSoldiers(index, numberOfSoldiers);
	}
	@Override
	public void simulate_attack(Player opponent,int mapSz) {
		/* Poor Agent that has no attacks. */
	}

	@Override
	public void startAttack(Player opponent, int mapSz) {
		GameSimulator.status.didAttack = false;
	}


    @Override
    public void distribute_soldiers(int k, Player a) {

    }


	
}
