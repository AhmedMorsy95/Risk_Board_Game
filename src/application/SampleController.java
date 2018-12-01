package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class SampleController {

    public static String player1 = "Human", player2 = "Human";
    @FXML
    private Button sim;

    @FXML
    private ImageView riskimage;
    @FXML
    private Button playingButton;

    @FXML
    void simulationClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AgentChoice.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    void ply1_passive_button(ActionEvent event) throws IOException {
        player1 = "Passive";
        Parent root = FXMLLoader.load(getClass().getResource("AgentChoice2.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    void ply1_aggressive_button(ActionEvent event) throws IOException {
        player1 = "Aggressive";
        Parent root = FXMLLoader.load(getClass().getResource("AgentChoice2.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    void ply1_pacifist_button(ActionEvent event) throws IOException {
        player1 = "Pacifist";
        Parent root = FXMLLoader.load(getClass().getResource("AgentChoice2.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    void ply1_greedy_button(ActionEvent event) throws IOException {
        player1 = "Greedy";
        Parent root = FXMLLoader.load(getClass().getResource("AgentChoice2.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    void ply1_astars_button(ActionEvent event) throws IOException {
        player1 = "A_Star";
        Parent root = FXMLLoader.load(getClass().getResource("AgentChoice2.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    void ply1_realtime_button(ActionEvent event) throws IOException {
        player1 = "RealTime A*";
        Parent root = FXMLLoader.load(getClass().getResource("AgentChoice2.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    void ply1_minimax_button(ActionEvent event) throws IOException {
        player1 = "Minimax";
        Parent root = FXMLLoader.load(getClass().getResource("AgentChoice2.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    void ply2_passive_button(ActionEvent event) throws IOException {
        player2 = "Passive";
        Parent root = FXMLLoader.load(getClass().getResource("MapChoiceSimulation.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    void ply2_aggressive_button(ActionEvent event) throws IOException {
        player2 = "Aggressive";
        Parent root = FXMLLoader.load(getClass().getResource("MapChoiceSimulation.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    void ply2_pacifist_button(ActionEvent event) throws IOException {
        player2 = "Pacifist";
        Parent root = FXMLLoader.load(getClass().getResource("MapChoiceSimulation.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    void ply2_greedy_button(ActionEvent event) throws IOException {
        player2 = "Greedy";
        Parent root = FXMLLoader.load(getClass().getResource("MapChoiceSimulation.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    void ply2_astars_button(ActionEvent event) throws IOException {
        player2 = "A_Star";
        Parent root = FXMLLoader.load(getClass().getResource("MapChoiceSimulation.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    void ply2_realtime_button(ActionEvent event) throws IOException {
        player2 = "RealTime A*";
        Parent root = FXMLLoader.load(getClass().getResource("MapChoiceSimulation.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    void ply2_minimax_button(ActionEvent event) throws IOException {
        player2 = "Minimax";
        Parent root = FXMLLoader.load(getClass().getResource("MapChoiceSimulation.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    void egyptSelectedSimulation(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/risk/EgyptSimulationMode.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    void USASelectedSimulation(ActionEvent event) throws IOException {
     //   player1 = player2 = "Human";
        Parent root = FXMLLoader.load(getClass().getResource("/risk/UsaSimulationMode.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    void playClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MapChoicePlaying.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    void egyptSelected(ActionEvent event) throws IOException {
//        player1 = player2 = "Human";
        Parent root = FXMLLoader.load(getClass().getResource("/risk/EgyptPlayingMode.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    void USASelected(ActionEvent event) throws IOException {
      //  player1 = player2 = "Human";
        Parent root = FXMLLoader.load(getClass().getResource("/risk/UsaPlayingMode.fxml"));
        Scene scene = new Scene(root);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();

    }

}
