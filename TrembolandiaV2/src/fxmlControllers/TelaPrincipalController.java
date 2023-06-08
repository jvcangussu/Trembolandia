package fxmlControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import control.ControleUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class TelaPrincipalController extends IController implements Initializable {

    @FXML
    private AnchorPane anchorPaneInfos;

    @FXML
    private AnchorPane anchorPaneMenu;

    @FXML
    private AnchorPane anchorPaneTesteLogin;

    @FXML
    private Label labelNome;

    @FXML
    private Button sairParaLogin;
    
    @FXML
    private Button botaoTreinos;

    @FXML
    private Button botaoMacronutrientes;

    @FXML
    private Button botaoPlus;

    @FXML
    void irParaLogin(ActionEvent event) throws IOException {
        FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("../fxml/login.fxml"));
        Parent login = loginLoader.load();
        anchorPaneTesteLogin.getChildren().setAll(login);
    }

    @FXML
    void irParaTreinos(ActionEvent event) throws IOException {
        FXMLLoader treinosLoader = new FXMLLoader(getClass().getResource("../fxml/telaTreinos.fxml"));
        Parent treinos = treinosLoader.load();
        anchorPaneInfos.getChildren().setAll(treinos);
    }
    
    @FXML
    void irParaMacronutrientes(ActionEvent event) throws IOException {
        FXMLLoader macronutrientesLoader = new FXMLLoader(getClass().getResource("../fxml/telaMacronutrientes.fxml"));
        Parent macronutrientes = macronutrientesLoader.load();
        anchorPaneInfos.getChildren().setAll(macronutrientes);
    }

    @FXML
    void irParaPlus(ActionEvent event) throws IOException {
        FXMLLoader plusLoader = new FXMLLoader(getClass().getResource("../fxml/telaPlus.fxml"));
        Parent plus = plusLoader.load();
        anchorPaneInfos.getChildren().setAll(plus);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ControleUsuario cUsuario = new ControleUsuario();
        labelNome.setText("Olá " + cUsuario.pesquisarUsuario(super.loginInstanciado).getNome());
    }

}
