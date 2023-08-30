package data;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Dieta;
public class DataDieta {
    
    private final String nomearq = "dietas.ser";

    public ArrayList<Dieta> getAllDietas() {
        ArrayList <Dieta> dietas = new ArrayList<>();
        FileInputStream fluxo;
        ObjectInputStream lerObj = null;
        try{
            fluxo = new FileInputStream(nomearq);
            lerObj = new ObjectInputStream(fluxo);
            dietas = (ArrayList<Dieta>)lerObj.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println ("Erro ao listar as dietas");
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println ("Erro ao listar as dietas");
        }
        return dietas;
    }
    private void updateArq(ArrayList<Dieta> dietas){
        try{
            FileOutputStream fluxo = new FileOutputStream(nomearq);
            ObjectOutputStream escreverObj = new ObjectOutputStream(fluxo);
            escreverObj.writeObject(dietas);
            escreverObj.close();          
           } catch (FileNotFoundException ex) {
            System.out.println ("Erro ao atualizar dietas");
           } catch (IOException ex) {
            System.out.println ("Erro ao atualizar dietas");
        }
    }
    public void createDieta(Dieta dieta) {
          ArrayList <Dieta> dietas = (ArrayList<Dieta>) getAllDietas();
          dietas.add(dieta);
          try{
             FileOutputStream fluxo = new FileOutputStream(nomearq);
             ObjectOutputStream escreverObj = new ObjectOutputStream(fluxo);
             escreverObj.writeObject(dietas);
             escreverObj.close();
          
           } catch (FileNotFoundException ex) {
            System.out.println ("Erro ao cadastrar dieta");
           } catch (IOException ex) {
            System.out.println ("Erro ao cadastrar dieta");
        }
    }
    public void updateDieta(Dieta dieta){
        ArrayList<Dieta> dietas = (ArrayList<Dieta>)getAllDietas();
        boolean achou = false;
        for (int i = 0; i < dietas.size(); i++){
            if (dieta.getCodigo() == (dietas.get(i).getCodigo())){
                dietas.remove(i);
                dietas.add(dieta);
                achou=true;
                break;
            }
        }
        if(achou){
            updateArq(dietas);
        }
    }
     public Dieta readDieta(int codigo) {
       ArrayList <Dieta> dietas = (ArrayList<Dieta>) getAllDietas();
       Dieta dieta=null;
         for (int i=0; i<dietas.size(); i++){
             if (codigo == (dietas.get(i).getCodigo())){
                 dieta=dietas.get(i);
                 break;
             }
         }
         return dieta;
    }
      public void deleteDieta(Dieta dieta) throws Exception {
        ArrayList <Dieta> dietas = (ArrayList<Dieta>)getAllDietas();
        boolean achou=false;
        for (int i=0; i<dietas.size(); i++){
             if (dieta.getCodigo()==(dietas.get(i).getCodigo())){
                 dietas.remove(i);
                 achou=true;
                 break;
             }
         }
        if (achou){
            updateArq(dietas);
        } 
    }
}
