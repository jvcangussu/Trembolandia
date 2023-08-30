package fxmlControllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import control.ControleUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CadastroController implements Initializable {

    @FXML
    private AnchorPane anchorPaneCadastro;

    @FXML
    private Button botaoCadastro;

    @FXML
    private Hyperlink botaoLogin;

    @FXML
    private PasswordField campoConfirmaSenha;

    @FXML
    private TextField campoNome;

    @FXML
    private PasswordField campoSenha;

    @FXML
    private TextField campoUsername;

    @FXML
    private DatePicker escolheDataNasc;

    @FXML
    private ChoiceBox<String> selecaoGenero;
    private String[] generos = {"Feminino", "Masculino"};    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        selecaoGenero.getItems().addAll(generos);
    }

    @FXML
    private Label statusCadastro;

    @FXML
    void irParaLogin(ActionEvent event) throws IOException {
        FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("../fxml/login.fxml"));
        Parent login = loginLoader.load();
        anchorPaneCadastro.getChildren().setAll(login);
    }

    @FXML
    void realizarCadastro(ActionEvent event) {
        ControleUsuario cUsuario = new ControleUsuario();
        String username = campoUsername.getText();
        String senha = campoSenha.getText();
        String confirmaSenha = campoConfirmaSenha.getText();
        String nome = campoNome.getText();
        String genero = selecaoGenero.getValue();
        Boolean gen = false;
            if(genero.equals("Masculino"))
                gen = true;

        LocalDate dataNasc = escolheDataNasc.getValue();

        if(username.isEmpty() || senha.isEmpty() || confirmaSenha.isEmpty() || nome.isEmpty() || genero.isEmpty() || dataNasc.toString().isEmpty()){
            statusCadastro.setText("Preencha todos os campos!");
        } else if(!(senha.equals(confirmaSenha))) {
            statusCadastro.setText("As senhas são diferentets!");
        } else if(cUsuario.pesquisarUsuario(username) != null) {
            statusCadastro.setText("O nome de usuário já está em uso!");
        } else {
            cUsuario.cadastrarUsuario(username, senha, nome, gen, dataNasc);
            statusCadastro.setText("Cadastro Realizado!");
            limparCampos();
        }
    }

    void limparCampos() {
        campoUsername.setText("");
        campoSenha.setText("");
        campoConfirmaSenha.setText("");
        campoNome.setText("");
        selecaoGenero.setValue(null);
        escolheDataNasc.setValue(null);
    }

}


