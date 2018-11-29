/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risk;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;

/**
 *
 * @author smsm
 */
public class AggressiveVsAStar extends Player {

    AggressiveVsAStar() {
        territories = new ArrayList<Integer>();
        soldier_of_each_territory = new int[55];
    }

    @Override
    public void distribute_soldiers(int numberOfSoldiers) {
        int index;
        for (int i = 0; i < numberOfSoldiers; i++) {
            Random r = new Random();
            index = r.nextInt(territories.size());
            soldier_of_each_territory[territories.get(index)]++;
        }

    }

    @Override
    public void simulate_attack(Player opponent, int mapSz) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void startAttack(Player opponent, int mapSz) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    int heuristic(Player a, Player b, int myTerritory, int attackTerritory, int mapSz) {
        int myHeuristic = 0;
        if (a.soldier_of_each_territory[myTerritory] == 1 && b.soldier_of_each_territory[attackTerritory] > 1) {
            myHeuristic++;
        }
        ArrayList<Integer> neighbours = AdjacencyMatrix.getNeighbours(attackTerritory, mapSz);
        for (int i = 0; i < neighbours.size(); i++) {
            if (a.isMine(neighbours.get(i))) {
                continue;
            }
            myHeuristic++;
        }
        myHeuristic -= b.soldier_of_each_territory[attackTerritory];
        return myHeuristic;
    }

    public void go(Player aggressive, int mapSz) {
        Node cur = new Node(this, aggressive, 0);
        PriorityQueue<Node> pq = new PriorityQueue<Node>();

        pq.add(cur);

        while (!pq.isEmpty()) {
            cur = pq.peek();
            pq.poll();
            int indexOfTerritory;
            for (int i = 0; i < cur.one.territories.size(); i++) {
                indexOfTerritory = cur.one.territories.get(i);
                ArrayList<Integer> neighbours = AdjacencyMatrix.getNeighbours(indexOfTerritory, mapSz);
                for (int j = 0; j < neighbours.size(); j++) {
                    if (cur.one.getSoldiers_from_territory(indexOfTerritory) < cur.two.getSoldiers_from_territory(neighbours.get(j))) {
                        continue;
                    }
                    int h = heuristic(cur.one, cur.two, indexOfTerritory, neighbours.get(j), mapSz);
                    Player first = cur.one;
                    Player second = cur.two;
                    first.addTerritory(neighbours.get(j), 1);
                    first.removeSoldiers(indexOfTerritory, 1);
                    second.removeTerritory(neighbours.get(j));
                    h++;

                    int sz = 0, attackFrom = 0, attackTo = 0;
                    for (int k = 0; k < cur.two.territories.size(); k++) {
                        indexOfTerritory = cur.two.territories.get(k);
                        if (cur.two.getSoldiers_from_territory(indexOfTerritory) <= 1) {
                            continue;
                        }
                        ArrayList<Integer> neighbours2 = AdjacencyMatrix.getNeighbours(indexOfTerritory, mapSz);
                        for (int l = 0; l < neighbours2.size(); l++) {
                            if (isMine(neighbours2.get(l)) || soldier_of_each_territory[territories.get(i)] == 1) {
                                continue;
                            }

                            if (sz < cur.one.soldier_of_each_territory[neighbours2.get(l)]) {
                                attackFrom = indexOfTerritory;
                                attackTo = neighbours2.get(l);
                                sz = cur.one.soldier_of_each_territory[neighbours2.get(l)];
                            }
                        }

                    }
                    if (sz > 0 && cur.one.soldier_of_each_territory[attackTo] < cur.two.soldier_of_each_territory[attackFrom]) {
                        cur.two.addTerritory(attackTo, 1);
                        cur.two.removeSoldiers(attackFrom, 1);
                        cur.one.removeTerritory(attackTo);
                    }
                    Node n = new Node(cur.one, cur.two, h);
                    pq.add(n);
                }
            }
        }
    }

    @Override
    public void distribute_soldiers(int k, Player a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
