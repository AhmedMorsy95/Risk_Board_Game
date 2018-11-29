/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risk;

import java.util.ArrayList;

/**
 *
 * @author Nevine & Smsm
 */
public class Human extends Player {
    
    public Human(){
        territories = new ArrayList<Integer>();
	soldier_of_each_territory = new int[Player.EGYPT_TERRITORIES];
    }

    @Override
    public void distribute_soldiers(int k) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void simulate_attack(Player opponent, int mapSz) {
            if(this.myDice > 0)
                fightStart(this,opponent,this.myDice,this.opponentDice,this.attackFromIndex,this.attackToIndex);
            else
                GameSimulator.status.didAttack = false;
    }

    @Override
    public void startAttack(Player opponent, int mapSz) {
        simulate_attack(opponent,mapSz);
    }

    @Override
    public void distribute_soldiers(int k, Player a) {
        addSoldiers(k,a.distributeIndex);
    }
    
    
    
}
