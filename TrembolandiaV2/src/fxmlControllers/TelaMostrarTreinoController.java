package fxmlControllers;

import java.net.URL;
import java.util.ResourceBundle;

import control.ControleTreino;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TelaMostrarTreinoController extends IController implements Initializable {
    public ControleTreino cTreino = new ControleTreino();

    private Stage dialogStage;
        
    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    private Button botaoFecharTreino;

    @FXML
    private Label labelTreino;

    @FXML
    void sairDoTreino(ActionEvent event) {
        this.dialogStage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
            labelTreino.setText(cTreino.imprimirTreino(codigoTreinoInstanciado));
        } catch(Exception e) {
            System.out.println("deu erro ai man");
        }
        
    }

}
