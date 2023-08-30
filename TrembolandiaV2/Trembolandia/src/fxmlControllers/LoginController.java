package fxmlControllers;

import java.io.IOException;

import control.ControleUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginController extends IController {

    @FXML
    private AnchorPane anchorPaneLogin;

    @FXML
    private Hyperlink botaoCadastro;

    @FXML
    private Button botaoLogar;

    @FXML
    private PasswordField campoSenha;

    @FXML
    private TextField campoUsername;

    @FXML
    private Label statusLogin;

    @FXML
    void irParaCadastro(ActionEvent event) throws IOException {
        FXMLLoader cadastroLoader = new FXMLLoader(getClass().getResource("../fxml/cadastro.fxml"));
        Parent cadastro = cadastroLoader.load();
        anchorPaneLogin.getChildren().setAll(cadastro);
    }

    @FXML
    void tentarLogin(ActionEvent event) throws IOException {
        ControleUsuario cUsuario = new ControleUsuario();
        String username = campoUsername.getText();
        String senha = campoSenha.getText();
        if(!cUsuario.loginUsuario(username, senha)){
            statusLogin.setText("Usuário ou senha incorretos!");
        } else {
            super.loginInstanciado = username;
            FXMLLoader testeLoginLoader = new FXMLLoader(getClass().getResource("../fxml/telaPrincipal.fxml"));
            Parent testeLogin = testeLoginLoader.load();
            anchorPaneLogin.getChildren().setAll(testeLogin);
        }
    }

}

