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
public class Node {

    Player one, two;
    int cost;

    Node(Player a, Player b, int c) {
        one = a;
        two = b;
        cost = c;
    }
}
