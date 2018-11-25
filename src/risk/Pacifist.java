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

public class Pacifist extends Player {

    /* A nearly pacifist agent, that places its armies like the completely passive agent, then
       conquers only the one territory with fewest armies (if it can). */
    Pacifist() {
        territories = new ArrayList<Integer>();
        soldier_of_each_territory = new int[EGYPT_TERRITORIES];
    }

    @Override
    public void distribute_soldiers(int numberOfSoldiers) {
        int fewestArmies = Integer.MAX_VALUE, index = -1;
        for (int i = 0; i < territories.size(); i++) {
            if (fewestArmies < soldier_of_each_territory[territories.get(i)]) {
                fewestArmies = soldier_of_each_territory[territories.get(i)];
                index = territories.get(i);
            }
        }
        if (index != -1) {
            addSoldiers(index, numberOfSoldiers);
        }
    }

    @Override
    public void simulate_attack(Player opponent, int boardSize) {
        int attackFrom = -1, attackTo = -1, sz = Integer.MAX_VALUE;

        for (int i = 0; i < territories.size(); i++) {
            ArrayList<Integer> neighbours = AdjacencyMatrix.getNeighbours(territories.get(i), boardSize);

            if (soldier_of_each_territory[territories.get(i)] == 1) {
                continue;
            }

            for (int j = 0; j < neighbours.size(); j++) {
                if (isMine(neighbours.get(j))) {
                    continue;
                }

                if (sz > opponent.soldier_of_each_territory[neighbours.get(j)]) {
                    attackFrom = territories.get(i);
                    attackTo = neighbours.get(j);
                    sz = opponent.soldier_of_each_territory[neighbours.get(j)];
                }
            }
        }

        if (sz < Integer.MAX_VALUE) {
            int k1 = Math.min(3, soldier_of_each_territory[attackFrom] - 1);
            int k2 = 1;
            fightStart(this, opponent, k1, k2, attackFrom, attackTo);
        } else {
            GameSimulator.status.didAttack = false;
        }
    }

    @Override
    public void startAttack(Player opponent, int mapSz) {
        simulate_attack(opponent, mapSz);
    }

}
