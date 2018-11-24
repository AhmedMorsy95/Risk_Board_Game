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
public class MatchStatus {
     int from,to,soldiersFrom , soldiersTo;
     boolean didAttackerWin;
     boolean didAttackerInvade;
     boolean didAttack;
     public MatchStatus() {
	
     }
     MatchStatus(int a,int b,int c,int d,boolean z,boolean x,boolean y){
    	 soldiersFrom = a;
    	 soldiersTo = b;
    	 from = c;
    	 to = d;
    	 didAttackerWin  = x;
    	 didAttackerInvade = y;
    	 didAttack = z;
     }
}