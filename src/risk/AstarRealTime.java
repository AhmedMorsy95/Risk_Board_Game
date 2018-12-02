/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Random;

/**
 *
 * @author smsm
 */
public class AstarRealTime extends Player {

	AstarRealTime() {
        territories = new ArrayList<Integer>();
        soldier_of_each_territory = new int[55];
    }
	HashMap<Node, ParentPath> mp = new HashMap<>();

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
    }

    Node best = null;
    @Override
    public void startAttack(Player opponent, int mapSz) {
    	Node best;
		try {
			best = go(opponent,mapSz);
        ParentPath p = null;
        while(mp.containsKey(best)) {
        	p = mp.get(best);
        	best = p.parent;
        }
        /// we have the 2 chosen countries 
        boolean didwin = false;
        boolean didinvade = false;
        boolean didAttack = true;
         
        	didwin = true;
        	didinvade = true;
        	opponent.removeTerritory(p.toAStar);
        	this.addTerritory(p.toAStar, 1);
        	this.removeSoldiers(p.fromAStar, 1);
        	
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        GameSimulator.status = new MatchStatus(0,0,p.fromAStar,p.toAStar,didwin,didinvade,didAttack,tmp,tmp);
        
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
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
    
    /// keep history to avoid cycles
    
    HashSet<Node> visited = new HashSet<>();

    public Node go(Player aggressive, int mapSz) throws CloneNotSupportedException {
        Node cur = new Node(this, aggressive, 0);
        PriorityQueue<Node> pq = new PriorityQueue<Node>(new NodeComparator());
         Node ret = cur;
        pq.add(cur);
        
        int limit = 10;
         
        while (!pq.isEmpty() && limit > 0) {
        	
        	cur = pq.peek();
            pq.poll();
            limit --;
            if(cur.cost >= ret.cost) {
            	ret = cur;
            }
            if(visited.contains(cur)) {
            	continue;
            }
            visited.add(cur);
            
            
            //System.out.print(cur.cost + " " + cur.depth + "\n");
            
            int indexOfTerritory;
            for (int i = 0; i < cur.one.territories.size(); i++) {
                indexOfTerritory = cur.one.territories.get(i);
                 ArrayList<Integer> neighbours = AdjacencyMatrix.getNeighbours(indexOfTerritory, mapSz);
                 for (int j = 0; j < neighbours.size(); j++) {
                     if (cur.one.getSoldiers_from_territory(indexOfTerritory) < cur.two.getSoldiers_from_territory(neighbours.get(j))) {
                        continue;
                    }
                    int h = heuristic(cur.one, cur.two, indexOfTerritory, neighbours.get(j), mapSz);
                    // problem
                    Player first = new AggressiveVsAStar();
                    first.c=cur.one.c;
                    first.soldier_of_each_territory=cur.one.soldier_of_each_territory.clone();
                    first.turn=cur.one.turn;
                    first.soldiers=cur.one.soldiers;
                    first.territories=(ArrayList<Integer>) cur.one.territories.clone();
                    first.firstPlayerDice=(ArrayList<Integer>) cur.one.firstPlayerDice.clone();
                    first.secondPlayerDice=(ArrayList<Integer>) cur.one.secondPlayerDice.clone();
                    Player second = new Aggressive();
                    second.c=cur.two.c;
                    second.soldier_of_each_territory=cur.two.soldier_of_each_territory;
                    second.turn=cur.two.turn;
                    second.soldiers=cur.two.soldiers;
                    second.territories=(ArrayList<Integer>)cur.two.territories.clone();
                    second.firstPlayerDice=(ArrayList<Integer>)cur.two.firstPlayerDice.clone();
                    second.secondPlayerDice=(ArrayList<Integer>)cur.two.secondPlayerDice.clone();
                    //
                    first.removeSoldiers(indexOfTerritory, 1);
                    first.addTerritory(neighbours.get(j), 1);
                  //  System.out.println(first.territories.size() + " " + cur.one.territories.size());
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
                    mp.put(n,new ParentPath(cur, indexOfTerritory, neighbours.get(j)) );
                }
            }
        }
        return ret;
    }

    @Override
    public void distribute_soldiers(int k, Player a) {

    }
}
