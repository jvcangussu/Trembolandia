package control;

import java.util.ArrayList;
import data.DataTreino;
import model.Treino;
import model.Usuario;

public class ControleTreino{
    private DataTreino dataTreino = new DataTreino();

    public Treino criarTreino(Usuario u, int dias, String nome) throws Exception{
        Treino t = new Treino(u, dias, nome);
        dataTreino.createTreino(t);
        return t;
    }

    public ArrayList<Treino> listarTreinos() throws Exception{
        ArrayList <Treino> treinos = (ArrayList<Treino>)dataTreino.getAllTreinos();
        return treinos;
    }

    public Treino pesquisarTreino(int codigo) throws Exception{
        Treino t = dataTreino.readTreino(codigo);
        return t;
    }

    public int retornarCodigo(Treino t){
        return t.getCodigo();
    }

    public Usuario retornarUsuario(Treino t){
        return t.getUsuario();
    }

    public void atualizarTreino(int cod) throws Exception{
        Treino t = pesquisarTreino(cod);
        dataTreino.updateTreino(t);
    }

    /*public Treino pesquisarTreino(Usuario u) throws Exception{
        ArrayList <Usuario> usuarios = dataUsuario.getAllUsuarios();
        String username = pesquisarUsuario(u);
        return t;
    }*/


    public void trocarExercicio(int codigo, String exercicioTrocado) throws Exception{
        Treino t = pesquisarTreino(codigo);
        t.trocarExercicio(exercicioTrocado);
        dataTreino.updateTreino(t);
    }

    public String imprimirTreino(int codigo) throws Exception{
        String textoParaImprimir = "";
        Treino t = pesquisarTreino(codigo);
        ArrayList<ArrayList<String>> textoTotal = t.imprimirTreino();
        for(ArrayList<String> i: textoTotal){
            for(String j: i){
                textoParaImprimir += j;
            }
        }
        return textoParaImprimir;
    }

    public void deletarTreino(int codigo) throws Exception{
        Treino t = pesquisarTreino(codigo);
        dataTreino.deleteTreino(t);
    }
}
