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
public class Factory { /// returns instance of the agent we want

    static Player getPlayer(String s) {
        if (null != s) {
            switch (s) {
                case "Passive":
                    return new Passive();
                case "Aggressive":
                    return new Aggressive();
                case "Pacifist":
                    return new Pacifist();
                case "Greedy":
                    return new Greedy();
                case "Minimax":
                    return new MiniMax(); 	
                default:
                    break;
            }
        }
        return null;
    }
}
