package fxmlControllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import control.ControleTreino;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Treino;

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
    private Label labelTreino1;

    @FXML
    private Label labelTreino2;

    @FXML
    private Label labelTreino3;

    @FXML
    private Label labelTreino4;

    @FXML
    private Label labelTreino5;

    @FXML
    private Button botaoTrocarExercicio;

    public ArrayList<Label> labelsTreinos = new ArrayList<>();
    

    @FXML
    void sairDoTreino(ActionEvent event) {
        this.dialogStage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<Label> labelsTreinos = new ArrayList<>();
        labelsTreinos.add(labelTreino1);
        labelsTreinos.add(labelTreino2);
        labelsTreinos.add(labelTreino3);
        labelsTreinos.add(labelTreino4);
        labelsTreinos.add(labelTreino5);
        try{
            Treino t = cTreino.pesquisarTreino(codigoTreinoInstanciado);
            ArrayList<ArrayList<String>> textoTotal = t.imprimirTreino();
            String diaTreino = "";
            for(int i = 0; i < textoTotal.size(); i++){
                for(int j = 0; j < textoTotal.get(i).size(); j++){
                    diaTreino += textoTotal.get(i).get(j) + "\n";
                }
                labelsTreinos.get(i).setText(diaTreino);
                diaTreino = "";
            }
        } catch(Exception e) {
            System.out.println("deu erro ai man");
        }
        
    }

    @FXML
    void trocarExercicio(ActionEvent event) throws Exception {
        String exercicio = JOptionPane.showInputDialog("Qual exercício deseja trocar?");
        ArrayList<Label> labelsTreinos = new ArrayList<>();
        labelsTreinos.add(labelTreino1);
        labelsTreinos.add(labelTreino2);
        labelsTreinos.add(labelTreino3);
        labelsTreinos.add(labelTreino4);
        labelsTreinos.add(labelTreino5);
        cTreino.trocarExercicio(codigoTreinoInstanciado, exercicio);
        try{
            Treino t = cTreino.pesquisarTreino(codigoTreinoInstanciado);
            ArrayList<ArrayList<String>> textoTotal = t.imprimirTreino();
            String diaTreino = "";
            for(int i = 0; i < textoTotal.size(); i++){
                for(int j = 0; j < textoTotal.get(i).size(); j++){
                    diaTreino += textoTotal.get(i).get(j) + "\n";
                }
                labelsTreinos.get(i).setText(diaTreino);
                diaTreino = "";
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
