/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//For the damaged *code* :(
package risk;

import java.net.URL;
import java.util.ResourceBundle;

import application.SampleController;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author smsm
 */
public class FXMLDocumentController implements Initializable {

    GameSimulator riskEgy = new GameSimulator(SampleController.player1, SampleController.player2, Player.EGYPT_TERRITORIES, 5);

    private boolean modeChoice = false;
    @FXML
    private Label turn2;

    @FXML
    private Label turn1;

    @FXML
    private ImageView dice2_1;

    @FXML
    private ImageView dice2_2;

    @FXML
    private ImageView dice2_3;

    @FXML
    private ImageView dice1_1;

    @FXML
    private ImageView dice1_2;

    @FXML
    private ImageView dice1_3;

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

    private Rectangle countryLabels[] = new Rectangle[27];

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

    private Circle attackingPoints[] = new Circle[27];

    ArrayList<Image> dices = new ArrayList<>();

    public void load() {
        for (int i = 1; i <= 6; i++) {
            dices.add(new Image(getClass().getResource(i + ".png").toExternalForm()));
        }
    }

    public void loadRect() {
        countryLabels[0] = rec0;
        countryLabels[1] = rec1;
        countryLabels[2] = rec2;
        countryLabels[3] = rec3;
        countryLabels[4] = rec4;
        countryLabels[5] = rec5;
        countryLabels[6] = rec6;
        countryLabels[7] = rec7;
        countryLabels[8] = rec8;
        countryLabels[9] = rec9;
        countryLabels[10] = rec10;
        countryLabels[11] = rec11;
        countryLabels[12] = rec12;
        countryLabels[13] = rec13;
        countryLabels[14] = rec14;
        countryLabels[15] = rec15;
        countryLabels[16] = rec16;
        countryLabels[17] = rec17;
        countryLabels[18] = rec18;
        countryLabels[19] = rec19;
        countryLabels[20] = rec20;
        countryLabels[21] = rec21;
        countryLabels[22] = rec22;
        countryLabels[23] = rec23;
        countryLabels[24] = rec24;
        countryLabels[25] = rec25;
        countryLabels[26] = rec26;
    }

    public void loadCircles() {
        attackingPoints[0] = circ0;
        attackingPoints[1] = circ1;
        attackingPoints[2] = circ2;
        attackingPoints[3] = circ3;
        attackingPoints[4] = circ4;
        attackingPoints[5] = circ5;
        attackingPoints[6] = circ6;
        attackingPoints[7] = circ7;
        attackingPoints[8] = circ8;
        attackingPoints[9] = circ9;
        attackingPoints[10] = circ10;
        attackingPoints[11] = circ11;
        attackingPoints[12] = circ12;
        attackingPoints[13] = circ13;
        attackingPoints[14] = circ14;
        attackingPoints[15] = circ15;
        attackingPoints[16] = circ16;
        attackingPoints[17] = circ17;
        attackingPoints[18] = circ18;
        attackingPoints[19] = circ19;
        attackingPoints[20] = circ20;
        attackingPoints[21] = circ21;
        attackingPoints[22] = circ22;
        attackingPoints[23] = circ23;
        attackingPoints[24] = circ24;
        attackingPoints[25] = circ25;
        attackingPoints[26] = circ26;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    public void yalla(MouseEvent action) {
        riskEgy.play();
        load();
        checkTheRectangles();
        loadCircles();
        getMyCirclesVisible();
        changeGameStatus();
    }

    public void checkTheRectangles() {

        loadRect();
        for (int i = 0; i < Player.EGYPT_TERRITORIES; i++) {
            if (riskEgy.first.getTerritories().contains(i)) {
                countryLabels[i].setFill(riskEgy.first.getColor());
            } else {
                countryLabels[i].setFill(riskEgy.second.getColor());
            }

        }
    }
//if it my turn -> disable circles that are not mine, but visible 3ady
    //modes:
    //first step -> i should get the event handler for the first time
//: my turn, enable all my circles + visible, disable the circles of the other player and set visible false for other player then mode switch
    //second step:!visible my circles and !disable mine,el opponent shayef el circles bto3oh and disable = false

    public void getMyCirclesVisible() {
        if (riskEgy.first.isMyTurn()) {
            //     if (!modeChoice) {
            for (int i = 0; i < Player.EGYPT_TERRITORIES; i++) {
                if (riskEgy.first.isMine(i)) {
                    attackingPoints[i].setVisible(true);
                    attackingPoints[i].setDisable(false);
                } else {
                    attackingPoints[i].setVisible(false);
                    attackingPoints[i].setDisable(true);
                }
            }
        } else {
           
            for (int i = 0; i < Player.EGYPT_TERRITORIES; i++) {
                if (riskEgy.second.isMine(i)) {
                    attackingPoints[i].setVisible(true);
                    attackingPoints[i].setDisable(false);
                } else {
                    attackingPoints[i].setVisible(false);
                    attackingPoints[i].setDisable(true);
                }
            }
           
        }
    } // <3 :( Fuck my life
    //on rolling dice: visible my countires that i can attack from s7
    //if my turn: if mode choice = 0, click on circle, mode =1; set circle visibility to false, disable = true, enable circles i can attack

    @FXML
    public void getNonNeighboursBlocked(MouseEvent event) {

        int idx = -1, tempIndex = -1;
        for (int i = 0; i < attackingPoints.length; i++) {
            if (event.getSource().equals(attackingPoints[i])) {
                idx = i;
            }
        }
        if (riskEgy.first.isMyTurn()) {
            if (!modeChoice) {
                for (int i = 0; i < Player.EGYPT_TERRITORIES; i++) {
                    if (riskEgy.first.isMine(i)) {
                        attackingPoints[i].setVisible(false);
                        attackingPoints[i].setDisable(true);
                    }
                }
                for (int i = 0; i < Player.EGYPT_TERRITORIES; i++) {
                    if (AdjacencyMatrix.egyptMap[idx][i] == 1 && !riskEgy.first.isMine(i)) {
                        attackingPoints[i].setVisible(true);
                        attackingPoints[i].setDisable(false);
                    } else {
                        attackingPoints[i].setVisible(false);
                        attackingPoints[i].setDisable(true);
                    }
                }
                tempIndex = idx;
                modeChoice = true;
            } else {
                for (int i = 0; i < Player.EGYPT_TERRITORIES; i++) {
                    if (!(i == tempIndex || i == idx)) {
                        attackingPoints[i].setVisible(false);
                        attackingPoints[i].setDisable(true);
                    }
                }
                modeChoice = false;
            }

        } else {
            if (!modeChoice) {
                for (int i = 0; i < Player.EGYPT_TERRITORIES; i++) {
                    if (riskEgy.second.isMine(i)) {
                        attackingPoints[i].setVisible(false);
                        attackingPoints[i].setDisable(true);
                    }
                }
                for (int i = 0; i < Player.EGYPT_TERRITORIES; i++) {
                    if (AdjacencyMatrix.egyptMap[idx][i] == 1 && !riskEgy.second.isMine(i)) {
                        attackingPoints[i].setVisible(true);
                        attackingPoints[i].setDisable(false);
                    } else {
                        attackingPoints[i].setVisible(false);
                        attackingPoints[i].setDisable(true);
                    }
                }
                tempIndex = idx;
                modeChoice = true;
            } else {
                for (int i = 0; i < Player.EGYPT_TERRITORIES; i++) {
                    if (!(i == tempIndex || i == idx)) {
                        attackingPoints[i].setVisible(false);
                        attackingPoints[i].setDisable(true);
                    }
                }
                modeChoice = false;
            }

        }
        //if it my turn -> disable circles that are not mine, but visible 3ady
        //modes:
        //first step: my turn, enable all my circles + visible, disable the circles of the other player and set visible false for other player then mode switch
        //second step:!visible my circles and !disable mine,el opponent shayef el circles bto3oh and disable = false
    }

    public void changeGameStatus() {
        gameStatus.clear();
        if (GameSimulator.first.isMyTurn()) {
            turn2.setVisible(false);
            turn1.setVisible(true);
        } else {
            turn1.setVisible(false);
            turn2.setVisible(true);
        }

        dice1_1.setImage(new Image(getClass().getResource("No.png").toExternalForm()));
        dice1_2.setImage(new Image(getClass().getResource("No.png").toExternalForm()));
        dice1_3.setImage(new Image(getClass().getResource("No.png").toExternalForm()));
        dice2_1.setImage(new Image(getClass().getResource("No.png").toExternalForm()));
        dice2_2.setImage(new Image(getClass().getResource("No.png").toExternalForm()));
        dice2_3.setImage(new Image(getClass().getResource("No.png").toExternalForm()));

        if (GameSimulator.status.didAttack == false) {
            gameStatus.appendText("Couldn't attack");
            for (int i = 0; i < 27; i++) {
            }
            return;
        }

        switch (riskEgy.status.dice1.size()) {
            case 3:
                dice1_1.setImage(dices.get(riskEgy.status.dice1.get(0)));
                dice1_2.setImage(dices.get(riskEgy.status.dice1.get(1)));
                dice1_3.setImage(dices.get(riskEgy.status.dice1.get(2)));
                break;
            case 2:
                dice1_1.setImage(dices.get(riskEgy.status.dice1.get(0)));
                dice1_2.setImage(dices.get(riskEgy.status.dice1.get(1)));
                break;
            case 1:
                dice1_1.setImage(dices.get(riskEgy.status.dice1.get(0)));
                break;
            default:
                break;
        }

        switch (riskEgy.status.dice2.size()) {
            case 3:
                dice2_1.setImage(dices.get(riskEgy.status.dice1.get(0)));
                dice2_2.setImage(dices.get(riskEgy.status.dice1.get(1)));
                dice2_3.setImage(dices.get(riskEgy.status.dice1.get(2)));
                break;

            case 2:
                dice2_1.setImage(dices.get(riskEgy.status.dice2.get(0)));
                dice2_2.setImage(dices.get(riskEgy.status.dice2.get(1)));
                break;
            case 1:
                dice2_1.setImage(dices.get(riskEgy.status.dice2.get(0)));
                break;
            default:
                break;
        }

        gameStatus.appendText("Attacking Soldiers: " + GameSimulator.status.soldiersFrom + "\r\n"
                + "Defending Soldiers:\n" + GameSimulator.status.soldiersTo + "\r\n"
                + "From: " + GameSimulator.status.from + "\r\n"
                + "To: " + GameSimulator.status.to + "\r\n"
                + "didAttackerInvade:\n " + GameSimulator.status.didAttackerInvade + "\r\n"
                + "didAttackerWin:\n " + GameSimulator.status.didAttackerWin + "\r\n"
        );
    }
}
