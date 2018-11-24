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
public class Greedy extends AIPlayer {
    Greedy(){ /// empty constructor
		territories = new ArrayList<Integer>();
		soldiers_of_each_territory = new int[55];
	}
	
    Greedy(ArrayList<Integer> a , int all[] , int total , Color co){
    	territories = a;
    	turn = false;
    	for(int i=0;i<55;i++) {
    		soldiers_of_each_territory[i] = all[i];
    		soldiers = total;
    		c = co;
    	}
    	
    }

    @Override
    public void distribute_soldiers(int k, AIPlayer opponent, int mapSz) {
        //get neighbors, sum BST of neighbors
        int[] BST = null;
        double[] BSR = null;
        double sumBSR = 0, maxNBSR = 0;
        double[] NBSR = null;
        int[] stateIndex = null;
        int BSTsz = 0;
        int count = 0;
        // Goal -> get Most NBSR of All territories i have
        // to get BSR w have to find (number of troops of each neighbours) / (number of troops in my territory) of each territory i have
        // in countriesRatios we can save
        // NBSR
        int countriesRatios[][] = new int[27][27];
        for (int i = 0; i < territories.size(); i++) {
            ArrayList<Integer> neighbours = AdjacencyMatrix.getNeighbours(territories.get(i), mapSz);
            ArrayList<Integer> ellyGnby = new ArrayList<>();
            for (int j = 0; j < neighbours.size(); j++) { //for each country, find neighbors
                if (isMine(neighbours.get(j))) //lw heya el neighbor bta3y msh 3ayezha
                {
                    continue;
                }

                count += opponent.soldiers_of_each_territory[neighbours.get(j)];
                if (BSTsz == 0) { //first element
                    BST[0] = count;
                    BSR[0] = BST[0] / (soldiers_of_each_territory[neighbours.get(j)]);
                    sumBSR += BSR[0];
                    stateIndex[0] = territories.get(j);

                } else {
                    BSTsz += 1;
                    BST[BSTsz] = count; //array of BST for each state
                    BSR[BSTsz] = BST[BSTsz] / (soldiers_of_each_territory[neighbours.get(j)]);
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
            NBSR[l] = BSR[l] / sumBSR; //fill NBSR array 
        }
        // {0,5,8,9,6,3} -> My territories Loop from 0 to BSTsz 0 => country 0 , 1 => country 5
        for (int l = 0; l < BSTsz; l++) {
            if (NBSR[l] > secondMax) {
                if (NBSR[l] > firstMax) {
                    firstMax = NBSR[l];
                    maxIndex = l;
                } else {
                    secondMax = NBSR[l];
                    secondIndex = l;
                }
            } 
        }
        double firstRatio = firstMax / (firstMax + secondMax);
        int firstSoldiers = (int) ((int) k * firstRatio);

        addSoldiers(maxIndex, firstSoldiers);
        addSoldiers(secondIndex, k - firstSoldiers);

    }

    @Override
    public void simulate_attack(AIPlayer opponent, int mapSz) {
      //in progress
    }

    @Override
    public void startAttack(AIPlayer opponent, int mapSz) {
		simulate_attack(opponent, mapSz);
    }

}
