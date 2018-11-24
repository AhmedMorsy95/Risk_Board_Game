/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risk;

import java.util.ArrayList;

/**
 *
 * @author smsm
 */
public class Aggressive extends Player {

    Aggressive() { ///  constructor
        territories = new ArrayList<Integer>();
        soldier_of_each_territory = new int[EGYPT_TERRITORIES];
        for(int i = 0; i < soldier_of_each_territory.length;)
            soldier_of_each_territory[i++] = 0;
    }

    /*An aggressive agent, that always places all its bonus armies on the territory with
    the most armies, and greedily attempts to attack territories with most armies that
    he can attack.*/
    @Override
    public void distribute_soldiers(int numberOfSoldiers) {
        int mostArmies = -1, index = -1;
        for (int i = 0; i < territories.size(); i++) {
            if (mostArmies < soldier_of_each_territory[territories.get(i)]) {
                mostArmies = soldier_of_each_territory[territories.get(i)];
                index = territories.get(i);
            }
        }
        addSoldiers(index, numberOfSoldiers);
    }

    @Override
    public void simulate_attack(Player opponent, int boardSize) {
        int attackFrom = -1, attackTo = -1, sz = 0;

        for (int i = 0; i < territories.size(); i++) {
            ArrayList<Integer> neighbours = AdjacencyMatrix.getNeighbours(territories.get(i), boardSize);
            for (int j = 0; j < neighbours.size(); j++) {
                if (isMine(neighbours.get(j)) || soldier_of_each_territory[territories.get(i)] == 1) {
                    continue;
                }

                if (sz < opponent.soldier_of_each_territory[neighbours.get(j)]) {
                    attackFrom = territories.get(i);
                    attackTo = neighbours.get(j);
                    sz = opponent.soldier_of_each_territory[neighbours.get(j)];
                }
            }
        }
        if (sz > 0) {
            int k1 = Math.min(3, soldier_of_each_territory[attackFrom] - 1);
            int k2 = 1;
            fightStart(this, opponent, k1, k2, attackFrom, attackTo);
        }
        else {
        	GameSimulator.status.didAttack = false;
        }
        
    }

    @Override
    public void startAttack(Player opponent, int mapSz) {
        simulate_attack(opponent, mapSz);
    }
}
