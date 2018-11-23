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
public class Territory {
    boolean player;
    int soldiers;
    int id;
    Territory(boolean x , int y){
    	player = x;
    	soldiers = 1;
    	id  = y;
    }
    void add_soldiers() {
    	this.soldiers++;
    }
}