/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risk;

import java.util.ArrayList;

/**
 *
 * @author smsm
 */
public class MatchStatus {

    int from, to, soldiersFrom, soldiersTo;
    boolean didAttackerWin;
    boolean didAttackerInvade;
    boolean didAttack;
    ArrayList<Integer> dice1;
    ArrayList<Integer> dice2;

    public MatchStatus() {

    }

    MatchStatus(int a, int b, int c, int d, boolean z, boolean x, boolean y, ArrayList<Integer> ply1, ArrayList<Integer> ply2) {
        soldiersFrom = a;
        soldiersTo = b;
        from = c;
        to = d;
        didAttackerWin = x;
        didAttackerInvade = y;
        didAttack = z;
        dice1 = ply1;
        dice2 = ply2;
    }
}
