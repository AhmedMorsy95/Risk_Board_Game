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
        	Player ret = null;
            switch (s) {
                case "Passive":
                    ret = new Passive();
                    break;
                case "Aggressive":
                	ret = new Aggressive();
                	break;
                case "Pacifist":
                	ret = new Pacifist();
                	break;
                case "Greedy":
                	ret = new Greedy();
                	break;
                case "Minimax":
                	ret = new MiniMax();
                	break;
                case "A_Star":
                	ret = new AggressiveVsAStar();
                	break;
                case "Human":
                	ret = new Human();
                	break;
                default:
                    break;
            }
           if(s.equals("Human")) return ret; 
             ret.me = new String(s);
             if(s != "Human") {
            	 ret.callDistribute = true;
             }
            
            return ret;
        }
        return null;
    }
}
