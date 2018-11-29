/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risk;

import java.util.ArrayList;
import javafx.scene.paint.Color;

/**
 *
 * @author Nevine
 */
public class Greedy extends Player {

    Greedy() { /// empty constructor
        territories = new ArrayList<Integer>();
        soldier_of_each_territory = new int[Player.EGYPT_TERRITORIES];
    }

    Greedy(ArrayList<Integer> a, int all[], int total, Color co) {
        territories = a;
        turn = false;
        for (int i = 0; i < Player.EGYPT_TERRITORIES; i++) {
            soldier_of_each_territory[i] = all[i];
            soldiers = total;
            c = co;
        }

    }

    public void distribute_soldiers(int k, Player opponent, int mapSz) {
        // get neighbors, sum BST of neighbors
        int[] BST = null;
        double[] BSR = null;
        double sumBSR = 0, maxNBSR = 0;
        double[] NBSR = null;
        int[] stateIndex = null;
        int BSTsz = 0;
        int count = 0;
        // Goal -> get Most NBSR of All territories i have
        // to get BSR w have to find (number of troops of each neighbours) /
        // (number of troops in my territory) of each territory i have
        // in countriesRatios we can save
        // NBSR
        // int countriesRatios[][] = new int[27][27];
        for (int i = 0; i < territories.size(); i++) {
            ArrayList<Integer> neighbours = AdjacencyMatrix.getNeighbours(territories.get(i), mapSz);

            for (int j = 0; j < neighbours.size(); j++) { // for each country,
                // find neighbors
                if (isMine(neighbours.get(j))) // lw heya el neighbor bta3y msh
                // 3ayezha
                {
                    continue;
                }

                count += opponent.soldier_of_each_territory[neighbours.get(j)];
                if (BSTsz == 0) { // first element
                    BST[0] = count;
                    BSR[0] = BST[0] / (soldier_of_each_territory[neighbours.get(j)]);
                    sumBSR += BSR[0];
                    stateIndex[0] = territories.get(j);

                } else {
                    BSTsz += 1;
                    BST[BSTsz] = count; // array of BST for each state
                    BSR[BSTsz] = BST[BSTsz] / (soldier_of_each_territory[neighbours.get(j)]);
                    sumBSR += BSR[BSTsz];
                    stateIndex[BSTsz] = territories.get(j);

                }

            }

        }
        // 1. Array <Ratios> -> index of maximum ration = index of the city
        double firstMax = -1;
        double secondMax = -1;
        int maxIndex = -1;
        int secondIndex = -1;
        for (int l = 0; l < BSTsz; l++) {
            NBSR[l] = BSR[l] / sumBSR; // fill NBSR array
        }
        // {0,5,8,9,6,3} -> My territories Loop from 0 to BSTsz 0 => country 0 ,
        // 1 => country 5
        for (int l = 0; l < BSTsz; l++) {
            if (NBSR[l] > secondMax) {
                if (NBSR[l] > firstMax) {
                    firstMax = NBSR[l];
                    maxIndex = stateIndex[l]; // msh moqtane3aa 3shan masta5demtsh state index f 7aaga
                } else {
                    secondMax = NBSR[l];
                    secondIndex = stateIndex[l];
                }
            }
        }
        double firstRatio = firstMax / (firstMax + secondMax);
        int firstSoldiers = (int) ((int) k * firstRatio);

        addSoldiers(maxIndex, firstSoldiers);
        addSoldiers(secondIndex, k - firstSoldiers);

    }

    int heuristic(Player a, int mapSz) {
        int total = 0, maxHeuristic = Integer.MIN_VALUE, hasOneSoldier = 0, index = -1;
        for (int i = 0; i < a.territories.size(); i++) {
            total = 0;
            System.out.print(a.territories.size());
            if (a.soldier_of_each_territory[a.territories.get(i)] == 1) {
                hasOneSoldier = 1;
            }
            ArrayList<Integer> neighbours = AdjacencyMatrix.getNeighbours(a.territories.get(i), mapSz);
            for (int j = 0; j < neighbours.size(); j++) {
                total = 0;
                if (a.isMine(neighbours.get(j))) {
                    continue;
                }
                if (a.getSoldiers_from_territory(neighbours.get(j)) > 1 && hasOneSoldier == 1) {
                    total++;
                }
                total -= a.getSoldiers_from_territory(neighbours.get(j));
                ArrayList<Integer> neighboursOfNeighbours = AdjacencyMatrix.getNeighbours(neighbours.get(j), mapSz);
                int cnt = 0;
                for (int k = 0; k < neighboursOfNeighbours.size(); k++) {
                    if (a.isMine(neighboursOfNeighbours.get(k))) {
                        continue;
                    }
                    cnt++;
                }
                total += cnt;
                if (total > maxHeuristic) {
                    maxHeuristic = total;
                    index = neighbours.get(j);

                }
            }

        }
        return index;
    }

    @Override
    public void simulate_attack(Player opponent, int mapSz) {
        int index = heuristic(opponent, mapSz);
        int attackFrom = -1, attackTo = -1, a = 0, b = 0;

        for (int i = 0; i < territories.size(); i++) {
            if (soldier_of_each_territory[territories.get(i)] == 1) {
                continue;
            }
            ArrayList<Integer> neighbours = AdjacencyMatrix.getNeighbours(territories.get(i), mapSz);
            for (int j = 0; j < neighbours.size(); j++) {
                if (isMine(neighbours.get(j))) {
                    continue;
                }

                if (neighbours.get(j) != index) {
                    continue;
                }
                if (soldier_of_each_territory[territories.get(i)] > 1) { //i want to find index of max heuritic and find a country in my territories that is neighbor to this country AND can attack it
                    attackFrom = territories.get(i);
                    attackTo = index; //index of max heuristic

                }
            }
        }
        if (attackFrom != -1) {
            fightStart(this, opponent, Math.min(3, this.soldier_of_each_territory[attackFrom] - 1), 1, attackFrom, attackTo);
        } else {
            GameSimulator.status.didAttack = false;
        }
    }

    @Override
    public void startAttack(Player opponent, int mapSz) {
        simulate_attack(opponent, mapSz);
    }

    @Override
    public void distribute_soldiers(int k) {
        // TODO Auto-generated method stub

    }

}
