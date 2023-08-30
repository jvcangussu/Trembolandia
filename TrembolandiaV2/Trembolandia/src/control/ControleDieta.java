package control;
import java.util.ArrayList;
import data.DataDieta;
import data.DataUsuario;
import model.Dieta;
import model.Usuario;
public class ControleDieta {
   private DataDieta dataDieta = new DataDieta();

   public void cadastrarDieta (Usuario usuario, int codigo, int opatividade){
        Dieta dieta = new Dieta(usuario, codigo, opatividade);
        dataDieta.createDieta(dieta);
    }
    
    public Dieta pesquisarDieta(int codigo) {
        return dataDieta.readDieta(codigo);
    }

    public void removerDieta(int codigo) throws Exception{
        Dieta d = pesquisarDieta(codigo);
        dataDieta.deleteDieta(d);
    }
    
    public void atualizarDieta(int codigo) throws Exception{
        Dieta d = pesquisarDieta(codigo);
        dataDieta.updateDieta(d);
    }
    
    public String imprimirDieta(int codigo, int opdieta) throws Exception{
        Dieta dieta = pesquisarDieta(codigo);
        return dieta.imprimirDieta();
    }

    public ArrayList<Dieta> listarDietas() throws Exception{
        ArrayList <Dieta> dietas = (ArrayList<Dieta>)dataDieta.getAllDietas();
        return dietas;
    }
    public Usuario retornarUsuario(Dieta d){
        return d.getUsuario();
    }

    public int retornarCodigo(Dieta d){
        return d.getCodigo();
    }
}

