package data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import model.Treino;


public class DataTreino{
    private final String nomeArquivo = "treinos.ser";
    private final String arquivoCodTreino = "codTreino.dat";

    public ArrayList<Treino> getAllTreinos() throws Exception {
        ArrayList <Treino> treinos = new ArrayList<>();
        File arq = new File (nomeArquivo);
        if (!arq.exists()){
            arq.createNewFile();
            return treinos;
        }
        FileInputStream fluxo;
        ObjectInputStream lerObj = null;
        try{
            fluxo = new FileInputStream(arq);
            lerObj = new ObjectInputStream(fluxo);
            treinos = (ArrayList<Treino>)lerObj.readObject();
            lerObj.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
            //System.out.println ("Erro ao listar treinos");
            //throw new Exception ("Erro ao listar treinos");
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println(ex.toString());
            //System.out.println ("Erro ao listar treinos");
            //throw new Exception ("Erro ao listar treinos");
        }
        return treinos;
    }
    
    public void createTreino(Treino treino) throws Exception {
        ArrayList <Treino> treinos = (ArrayList<Treino>) getAllTreinos();
        treino.setCodigo(controleCodigoTreino());
        treinos.add(treino);
        try{
            FileOutputStream fluxo = new FileOutputStream(nomeArquivo);
            ObjectOutputStream escreverObj = new ObjectOutputStream(fluxo);
            escreverObj.writeObject(treinos);
            escreverObj.close();   
        } catch (FileNotFoundException ex) {
            System.out.println ("Erro ao cadastrar treino");
            throw new Exception ("Erro ao Cadastrar treino");
        } catch (IOException ex) {
            System.out.println ("Erro ao cadastrar treino");
            throw new Exception ("Erro ao Cadastrar treino");
        }
    }
    
    public Treino readTreino(int codigo) throws Exception {
        ArrayList <Treino> treinos = (ArrayList<Treino>) getAllTreinos();
        Treino treino=null;
        for (int i = 0; i < treinos.size(); i++){
             if (codigo == treinos.get(i).getCodigo()){
                 treino = treinos.get(i);
                 break;
             }
         }
         return treino;
    }
    

    public void updateTreino(Treino treino) throws Exception {
        ArrayList <Treino> treinos = (ArrayList<Treino>) getAllTreinos();
        boolean achou=false;
        for (int i = 0; i < treinos.size(); i++){
             if (treino.getCodigo() == treinos.get(i).getCodigo()){
                treinos.remove(i);
                treinos.add(treino);
                achou=true;
                break;
             }
        }
        if (achou){
            atualizarArquivo(treinos);
        }
    }

    public void deleteTreino(Treino treino) throws Exception {
        ArrayList <Treino> treinos = (ArrayList<Treino>) getAllTreinos();
        boolean achou=false;
        for (int i=0; i<treinos.size(); i++){
             if (treino.getCodigo() == treinos.get(i).getCodigo()){
                treinos.remove(i);
                 achou=true;
                 break;
             }
         }
        if (achou){
            atualizarArquivo(treinos);
        } 
    }
    
    private void atualizarArquivo (ArrayList <Treino> treinos) throws Exception{
        try{
            FileOutputStream fluxo = new FileOutputStream(nomeArquivo);
            ObjectOutputStream escreverObj = new ObjectOutputStream(fluxo);
            escreverObj.writeObject(treinos);
            escreverObj.close();
          
        } catch (FileNotFoundException ex) {
            //System.out.println ("Erro ao atualizar treino");
            System.out.println(ex.toString());
            //throw new Exception ("Erro ao atualizar treino");        
        } catch (IOException ex) {
            //System.out.println ("Erro ao atualizar treino");
            System.out.println(ex.toString());
            //throw new Exception ("Erro ao atualizar treino");
        }
    }

    private int controleCodigoTreino (){
        File arqCodTreino = new File(arquivoCodTreino);
        int cod = 0;
        try { 
            if (!arqCodTreino.exists()){
                arqCodTreino.createNewFile();
                atualizaCodigoTreino(cod, arqCodTreino);
            }
            DataInputStream dis = new DataInputStream(new FileInputStream(arqCodTreino));
            cod = dis.readInt();
            dis.close();
            atualizaCodigoTreino(cod, arqCodTreino);
        } catch (FileNotFoundException ex) {
            System.out.println("Erro código do treino não encontrado");
        } catch (IOException ex) {
            System.out.println("Erro arquivo codTreino");
        }   
        return cod;
    } 
    
    private void atualizaCodigoTreino(int cod, File arqCodTreino) throws FileNotFoundException, IOException{    
        DataOutputStream dos = new DataOutputStream (new FileOutputStream (arqCodTreino));
        cod++;
        dos.writeInt(cod);
        dos.close();
    }
       
}
