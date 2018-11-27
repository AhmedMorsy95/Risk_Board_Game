/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * 
 * 
 *   goal test : done
 *   comparator :  done
 *   path : done 
 *   limit depth : done
 *   
 */

package risk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Random;

/**
 *
 * @author Merna
 */
public class PassiveVsAStar extends Player {

	HashMap<Node, ParentPath> mp = new HashMap<>();
    PassiveVsAStar() {
        territories = new ArrayList<Integer>();
        soldier_of_each_territory = new int[EGYPT_TERRITORIES];
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
    public void startAttack(Player opponent, int mapSz) throws CloneNotSupportedException {
        Node best = go(opponent,mapSz);
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

    public Node go(Player Passive, int mapSz) throws CloneNotSupportedException {
        Node cur = new Node(this, Passive, 0,1);
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        Node ret = cur;
        pq.add(cur);
        
        while (!pq.isEmpty()) {
            cur = pq.peek();
            pq.poll();
            if(cur.cost >= ret.cost) {
            	ret = cur;
            }
            //System.out.print(cur.cost + " " + cur.depth + "\n");
            if(cur.depth == 3)continue;
            
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
                    Player first = new PassiveVsAStar();
                    first.c=cur.one.c;
                    first.soldier_of_each_territory=cur.one.soldier_of_each_territory.clone();
                    first.turn=cur.one.turn;
                    first.soldiers=cur.one.soldiers;
                    first.territories=(ArrayList<Integer>) cur.one.territories.clone();
                    first.firstPlayerDice=(ArrayList<Integer>) cur.one.firstPlayerDice.clone();
                    first.secondPlayerDice=(ArrayList<Integer>) cur.one.secondPlayerDice.clone();
                    Player second = new Passive();
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
                    Node n = new Node(cur.one, cur.two, h,cur.depth+1);
                    pq.add(n);
                    mp.put(n,new ParentPath(cur, indexOfTerritory, neighbours.get(j)) );
                }
            }
        }
        return ret;
    }
}
