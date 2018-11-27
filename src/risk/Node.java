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

public class Node implements Comparable<Node>{

    Player one, two;
    int cost;
    int depth;

    Node(Player a, Player b, int c,int d) {
        one = a;
        two = b;
        cost = c;
        depth = d;
    }

	@Override
	public int compareTo(Node arg0) {
		// TODO Auto-generated method stub
		if(cost  == arg0.cost) return 0;
		if(cost < arg0.cost) return 1;
		return -1;
	}
}
