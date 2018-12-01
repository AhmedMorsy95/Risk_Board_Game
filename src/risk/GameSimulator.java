package risk;

/**
 *
 * @author smsm
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javafx.scene.paint.Color;

public class GameSimulator  {

    static Player first;
    static Player second;
    int boardSize;
    static MatchStatus status;
    boolean firstPlay = false;
    static int mapSizeplz;
    GameSimulator(String a, String b, int nTerritories, int extra) {  /// constructor ,  sets the game initial conditions
        mapSizeplz = nTerritories;
    	first = Factory.getPlayer(a);
        second = Factory.getPlayer(b);
        boardSize = nTerritories;
        status = new MatchStatus();
        /// initial configuration
        first.turn = true;
        second.turn = false;
        first.c = Color.RED;
        second.c = Color.BLUE;
        first.soldiers = nTerritories;
        second.soldiers = nTerritories;
        /// now we have 2 instances , randomly distribute territories
        randomDistributeTerritories(nTerritories);
        randomDistributeExrta(extra);
        System.out.print(a + " " + b + " " + first.callDistribute + " " + second.callDistribute + "hamada\n");
        /// now we distributed territories and extra soldiers
        /// we are ready to play!
    }

    void play() {  /// called by the gui , simulates one turn only
    	
    	if(firstPlay == false){
            firstPlay = true;
            return;
        }
        if (first.turn) {
            if(first.callDistribute)
            first.distribute_soldiers(first.getBonusSoldiers());
            first.startAttack(second, boardSize);
        } else if (second.turn) {
            if(second.callDistribute)
            second.distribute_soldiers(first.getBonusSoldiers());
            second.startAttack(first, boardSize);
        }
        System.out.println(first.callDistribute + " " + second.callDistribute);
        if(first.turn ==  true && first.callDistribute == false){
            return;
        }
        if(second.turn ==  true && second.callDistribute == false){
            return;
        } 
        first.alterTurn();
        second.alterTurn();
    }

    private void randomDistributeTerritories(int n) {
        ArrayList<Integer> x = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            x.add(i);
        }

        Collections.shuffle(x);
        for (int i = 0; i < n; i++) {
            if (i * 2 < n) {
                first.addTerritory(x.get(i), 1);
            } else {
                second.addTerritory(x.get(i), 1);
            }
        }
    }

    private void randomDistributeExrta(int extra) {
        for (int i = 0; i < extra; i++) {
            int x = new Random().nextInt(first.getTerritories().size());
            int y = new Random().nextInt(second.getTerritories().size());
            first.addSoldiers(first.getTerritories().get(x), 1);
            second.addSoldiers(second.getTerritories().get(y), 1);
        }
    }
}
