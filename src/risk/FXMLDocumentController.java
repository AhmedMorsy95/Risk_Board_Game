/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package risk;

import application.*;
import java.net.URL;
import java.util.ResourceBundle;

import application.SampleController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author smsm
 */
public class FXMLDocumentController implements Initializable {
    GameSimulator riskEgy = new GameSimulator(SampleController.player1, SampleController.player2, Player.EGYPT_TERRITORIES, 5);

    @FXML
    private Button yallaButton;
    @FXML
    private MenuButton startMenu;
    @FXML
    private MenuButton endMenu;
    @FXML
    private TextArea gameStatus;
    @FXML
    private Rectangle rec0 = new Rectangle();
    @FXML
    private Rectangle rec1 = new Rectangle();
    @FXML
    private Rectangle rec2 = new Rectangle();
    @FXML
    private Rectangle rec3 = new Rectangle();
    @FXML
    private Rectangle rec4 = new Rectangle();
    @FXML
    private Rectangle rec5 = new Rectangle();
    @FXML
    private Rectangle rec6 = new Rectangle();
    @FXML
    private Rectangle rec7 = new Rectangle();
    @FXML
    private Rectangle rec8 = new Rectangle();
    @FXML
    private Rectangle rec9 = new Rectangle();
    @FXML
    private Rectangle rec10 = new Rectangle();
    @FXML
    private Rectangle rec11 = new Rectangle();
    @FXML
    private Rectangle rec12 = new Rectangle();
    @FXML
    private Rectangle rec13 = new Rectangle();
    @FXML
    private Rectangle rec14 = new Rectangle();
    @FXML
    private Rectangle rec15 = new Rectangle();
    @FXML
    private Rectangle rec16 = new Rectangle();
    @FXML
    private Rectangle rec17 = new Rectangle();
    @FXML
    private Rectangle rec18 = new Rectangle();
    @FXML
    private Rectangle rec19 = new Rectangle();
    @FXML
    private Rectangle rec20 = new Rectangle();
    @FXML
    private Rectangle rec21 = new Rectangle();
    @FXML
    private Rectangle rec22 = new Rectangle();
    @FXML
    private Rectangle rec23 = new Rectangle();
    @FXML
    private Rectangle rec24 = new Rectangle();
    @FXML
    private Rectangle rec25 = new Rectangle();
    @FXML
    private Rectangle rec26 = new Rectangle();

    private Rectangle countryLabels[] = {rec0, rec1, rec2, rec3, rec4, rec5, rec6, rec7, rec8, rec9, rec10, rec11,
        rec12, rec13, rec14, rec15, rec16, rec17, rec18, rec19, rec20, rec21, rec22, rec23, rec24, rec25, rec26};

    @FXML
    public Circle circ0;
    @FXML
    private Circle circ1;
    @FXML
    private Circle circ2;
    @FXML
    private Circle circ3;
    @FXML
    private Circle circ4;
    @FXML
    private Circle circ5;
    @FXML
    private Circle circ6;
    @FXML
    private Circle circ7;
    @FXML
    private Circle circ8;
    @FXML
    private Circle circ9;
    @FXML
    private Circle circ10;
    @FXML
    private Circle circ11;
    @FXML
    private Circle circ12;
    @FXML
    private Circle circ13;
    @FXML
    private Circle circ14;
    @FXML
    private Circle circ15;
    @FXML
    private Circle circ16;
    @FXML
    private Circle circ17;
    @FXML
    private Circle circ18;
    @FXML
    private Circle circ19;
    @FXML
    private Circle circ20;
    @FXML
    private Circle circ21;
    @FXML
    private Circle circ22;
    @FXML
    private Circle circ23;
    @FXML
    private Circle circ24;
    @FXML
    private Circle circ25;
    @FXML
    private Circle circ26;
    private Circle attackingPoints[] = {circ0, circ1, circ2, circ3, circ4, circ5, circ6, circ7, circ8, circ9, circ10, circ11,
        circ12, circ13, circ14, circ15, circ16, circ17, circ18, circ19, circ20, circ21, circ22, circ23, circ24, circ25, circ26};

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    public void yalla(ActionEvent action) {
        riskEgy.play();
        checkTheRectangles();
        changeGameStatus();
    }

    public void checkTheRectangles() {
        if (riskEgy.first.getTerritories().contains(0)) {
            rec0.setFill(riskEgy.first.getColor());
        } else {
            rec0.setFill(riskEgy.second.getColor());
        }
        if (riskEgy.first.getTerritories().contains(1)) {
            rec1.setFill(riskEgy.first.getColor());
        } else {
            rec1.setFill(riskEgy.second.getColor());
        }
        if (riskEgy.first.getTerritories().contains(2)) {
            rec2.setFill(riskEgy.first.getColor());
        } else {
            rec2.setFill(riskEgy.second.getColor());
        }
        if (riskEgy.first.getTerritories().contains(3)) {
            rec3.setFill(riskEgy.first.getColor());
        } else {
            rec3.setFill(riskEgy.second.getColor());
        }
        if (riskEgy.first.getTerritories().contains(4)) {
            rec4.setFill(riskEgy.first.getColor());
        } else {
            rec4.setFill(riskEgy.second.getColor());
        }
        if (riskEgy.first.getTerritories().contains(5)) {
            rec5.setFill(riskEgy.first.getColor());
        } else {
            rec5.setFill(riskEgy.second.getColor());
        }
        if (riskEgy.first.getTerritories().contains(6)) {
            rec6.setFill(riskEgy.first.getColor());
        } else {
            rec6.setFill(riskEgy.second.getColor());
        }
        if (riskEgy.first.getTerritories().contains(7)) {
            rec7.setFill(riskEgy.first.getColor());
        } else {
            rec7.setFill(riskEgy.second.getColor());
        }
        if (riskEgy.first.getTerritories().contains(8)) {
            rec8.setFill(riskEgy.first.getColor());
        } else {
            rec8.setFill(riskEgy.second.getColor());
        }
        if (riskEgy.first.getTerritories().contains(9)) {
            rec9.setFill(riskEgy.first.getColor());
        } else {
            rec9.setFill(riskEgy.second.getColor());
        }
        if (riskEgy.first.getTerritories().contains(10)) {
            rec10.setFill(riskEgy.first.getColor());
        } else {
            rec10.setFill(riskEgy.second.getColor());
        }
        if (riskEgy.first.getTerritories().contains(11)) {
            rec11.setFill(riskEgy.first.getColor());
        } else {
            rec11.setFill(riskEgy.second.getColor());
        }
        if (riskEgy.first.getTerritories().contains(12)) {
            rec12.setFill(riskEgy.first.getColor());
        } else {
            rec12.setFill(riskEgy.second.getColor());
        }
        if (riskEgy.first.getTerritories().contains(13)) {
            rec13.setFill(riskEgy.first.getColor());
        } else {
            rec13.setFill(riskEgy.second.getColor());
        }
        if (riskEgy.first.getTerritories().contains(14)) {
            rec14.setFill(riskEgy.first.getColor());
        } else {
            rec14.setFill(riskEgy.second.getColor());
        }
        if (riskEgy.first.getTerritories().contains(15)) {
            rec15.setFill(riskEgy.first.getColor());
        } else {
            rec15.setFill(riskEgy.second.getColor());
        }
        if (riskEgy.first.getTerritories().contains(16)) {
            rec16.setFill(riskEgy.first.getColor());
        } else {
            rec16.setFill(riskEgy.second.getColor());
        }
        if (riskEgy.first.getTerritories().contains(17)) {
            rec17.setFill(riskEgy.first.getColor());
        } else {
            rec17.setFill(riskEgy.second.getColor());
        }
        if (riskEgy.first.getTerritories().contains(18)) {
            rec18.setFill(riskEgy.first.getColor());
        } else {
            rec18.setFill(riskEgy.second.getColor());
        }
        if (riskEgy.first.getTerritories().contains(19)) {
            rec19.setFill(riskEgy.first.getColor());
        } else {
            rec19.setFill(riskEgy.second.getColor());
        }
        if (riskEgy.first.getTerritories().contains(20)) {
            rec20.setFill(riskEgy.first.getColor());
        } else {
            rec20.setFill(riskEgy.second.getColor());
        }
        if (riskEgy.first.getTerritories().contains(21)) {
            rec21.setFill(riskEgy.first.getColor());
        } else {
            rec21.setFill(riskEgy.second.getColor());
        }
        if (riskEgy.first.getTerritories().contains(22)) {
            rec22.setFill(riskEgy.first.getColor());
        } else {
            rec22.setFill(riskEgy.second.getColor());
        }
        if (riskEgy.first.getTerritories().contains(23)) {
            rec23.setFill(riskEgy.first.getColor());
        } else {
            rec23.setFill(riskEgy.second.getColor());
        }
        if (riskEgy.first.getTerritories().contains(24)) {
            rec24.setFill(riskEgy.first.getColor());
        } else {
            rec24.setFill(riskEgy.second.getColor());
        }
        if (riskEgy.first.getTerritories().contains(25)) {
            rec25.setFill(riskEgy.first.getColor());
        } else {
            rec25.setFill(riskEgy.second.getColor());
        }
        if (riskEgy.first.getTerritories().contains(26)) {
            rec26.setFill(riskEgy.first.getColor());
        } else {
            rec26.setFill(riskEgy.second.getColor());
        }

    }

    public void changeGameStatus(){
        gameStatus.clear();
        if(GameSimulator.status.didAttack == false) {
        	gameStatus.appendText("Couldnot attack");
        	for(int i=0;i<27;i++) {
        		
        	}
        	return;
        }
        gameStatus.appendText("Attacking Soldiers: " + GameSimulator.status.soldiersFrom + "\r\n"
                +  "Defending Soldiers:\n" + GameSimulator.status.soldiersTo + "\r\n"
                +  "From: " + GameSimulator.status.from + "\r\n"
                +  "To: " + GameSimulator.status.to + "\r\n"
                +  "didAttackerInvade:\n " + GameSimulator.status.didAttackerInvade + "\r\n"
                +  "didAttackerWin:\n " + GameSimulator.status.didAttackerWin + "\r\n"
                ); /*
        for(int i = 0; i < riskEgy.first.soldier_of_each_territory.length; i++)
            System.out.print(riskEgy.first.soldier_of_each_territory[i] + " ");
        System.out.println(" ");
        for(int i : riskEgy.second.soldier_of_each_territory)
            System.out.print(riskEgy.second.soldier_of_each_territory[i] +" ");     */   
    }
}


