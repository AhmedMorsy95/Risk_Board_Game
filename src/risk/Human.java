/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risk;

import java.util.ArrayList;

/**
 *
 * @author Nevine & Smsm wait 
 */
public class Human extends Player {
    
    public Human(){
        callDistribute = false;
        territories = new ArrayList<Integer>();
	soldier_of_each_territory = new int[Player.EGYPT_TERRITORIES];
    }

    @Override
    public void distribute_soldiers(int k) {
            distribute_soldiers(k,this);
    }

    @Override
    public void simulate_attack(Player opponent, int mapSz) {
        System.out.println(this.myDice);
        System.out.println(this.opponentDice);
            if(this.myDice > 0){
                fightStart(this,opponent,this.myDice,this.opponentDice,this.attackFromIndex,this.attackToIndex);
            }
            else
                GameSimulator.status.didAttack = false;
    }

    @Override
    public void startAttack(Player opponent, int mapSz) {
        simulate_attack(opponent,mapSz);
    }

    @Override
    public void distribute_soldiers(int k, Player a) {
        addSoldiers(Player.distributeIndex,k);
        GameSimulator.first.alterTurn();
        GameSimulator.second.alterTurn();
    }
    
    
    
}
