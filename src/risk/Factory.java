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
        if ("passive".equals(s)) {
            return new Passive();
        }
        else if ("Aggressive".equals(s)) {
            return new Aggressive();
        }
        return null;
    }
}
