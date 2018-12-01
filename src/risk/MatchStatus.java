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

    String from, to;
    int soldiersFrom, soldiersTo;
    boolean didAttackerWin;
    boolean didAttackerInvade;
    boolean didAttack;
    ArrayList<Integer> dice1;
    ArrayList<Integer> dice2;
    
    String[] Egycountries = new String[] {"Matrouh","Alexandria","Kafr El-sheikh","Damietta","Port Said","N Sinai","Gharbiya","Daqahliya","S Sinai","Behira","Menoufiya","Qalyobiya","Sharqiya","New Valley","Giza","Ismaily","Suez","Red Sea","Fayoum","Beni Suef","Minya","Asyut","Sohag","Qena","Aswan","Luxor"};
    String[] Usacountries = new String[55];
    
    public MatchStatus() {

    }

    MatchStatus(int a, int b, int c, int d, boolean z, boolean x, boolean y, ArrayList<Integer> ply1, ArrayList<Integer> ply2) {
        soldiersFrom = a;
        soldiersTo = b;
        if(GameSimulator.mapSizeplz == 27) {
         from = Egycountries[c];
         to = Egycountries[d];
        }
        else {
        	from = String.valueOf(c+1);
        	to = String.valueOf(d+1);
        }
        didAttackerWin = x;
        didAttackerInvade = y;
        didAttack = z;
        dice1 = ply1;
        dice2 = ply2;
    }
}
