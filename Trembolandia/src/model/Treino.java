package model;

import java.util.ArrayList;
import java.util.Random;
import java.io.Serializable;

public class Treino implements Serializable{

    private ArrayList <String> grupos = new  ArrayList<>();
    private ArrayList <String> treino = new ArrayList <>();
    private ArrayList <String> peito = new ArrayList<>();
    private ArrayList <String> triceps = new ArrayList<>();
    private ArrayList <String> biceps = new ArrayList<>();
    private ArrayList <String> ombro = new ArrayList<>();
    private ArrayList <String> costas = new ArrayList<>();
    private ArrayList <String> pernas = new ArrayList<>();
    private ArrayList <String> posterior = new ArrayList<>();
    private ArrayList <String> panturrilha = new ArrayList<>();
    private ArrayList <String> abdomen = new ArrayList<>();
    private ArrayList <String> gluteos = new ArrayList<>();
    private int dias;
    private Random r = new Random();
    private int codigo; 
    private String s;
    private Usuario usuario;
    private String nome;

    public Treino(Usuario usuario, int dias, String nome){
        
        peito.add("Supino reto com barra");
        peito.add("Supino inclinado com barra");
        peito.add("Supino declinado com barra");
        peito.add("Supino reto com halteres");
        peito.add("Supino inclinado com halteres");
        peito.add("Crucifixo com halteres");
        peito.add("Máquina de peck deck");
        peito.add("Cross-over com cabos");
       
        triceps.add("Tríceps testa");
        triceps.add("Tríceps francês");
        triceps.add("Tríceps na polia alta com corda");
        triceps.add("Tríceps na polia alta com barra reta");
        triceps.add("Tríceps apoiado no banco");
        triceps.add("Supino fechado");
        
        biceps.add("Rosca direta com barra");
        biceps.add("Rosca Scott com barra");
        biceps.add("Rosca martelo com halteres");
        biceps.add("Rosca concentrada");
        biceps.add("Rosca alternada com halteres");
        biceps.add("Bíceps com corda na polia");
        biceps.add("Rosca direta inclinada com halteres");

        ombro.add("Desenvolvimento com halteres sentado");
        ombro.add("Desenvolvimento militar com barra");
        ombro.add("Elevação frontal com halteres");
        ombro.add("Desenvolvimento Arnold");
        ombro.add("Elevação lateral com halteres");
        ombro.add("Crucifixo inverso");
        ombro.add("Remada alta com barra");

        costas.add("Remada curvada com barra");
        costas.add("Pulldown com pegada aberta");
        costas.add("Pulldown com pegada fechada");
        costas.add("Remada unilateral com halteres");
        costas.add("Remada baixa");
        costas.add("Remada cavalinho");
        costas.add("Puxada reta");
        costas.add("Puxada supinada");
        
        pernas.add("Agachamento livre");
        pernas.add("Leg press");
        pernas.add("Cadeira extensora");
        pernas.add("Agachamento búlgaro");
        pernas.add("Levantamento terra");
        pernas.add("Agachamento hack");

        abdomen.add("Abdominal infra no banco");
        abdomen.add("Abdominal oblíquo no chão");
        abdomen.add("Prancha");
        abdomen.add("Abdominal crunch");
        abdomen.add("Elevação de perna");
        abdomen.add("Abdominal Giro Russo");

        gluteos.add("Afundo");
        gluteos.add("Elevação de quadril com barra");
        gluteos.add("Deadlift");
        gluteos.add("Abdução de quadril com caneleira");
        gluteos.add("Agachamento sumô");

        posterior.add("Stiff");
        posterior.add("Mesa flexora");
        posterior.add("Cadeira flexora");
        posterior.add("Flexão nórdica");

        panturrilha.add("Panturrilha em pé");
        panturrilha.add("Panturrilha sentado");
        panturrilha.add("Panturrilha no smith");
        this.nome = nome;
        this.usuario = usuario;

        gerarTreino(dias);
    }

    public int getDias(){
        return dias;
    }

    public String getNome(){
        return nome;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ArrayList<String> getTreino() {
        return treino;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public ArrayList<ArrayList<String>> imprimirTreino(){
        ArrayList<ArrayList<String>> textTreino = new ArrayList<>();
        switch(s){
            case "homem":{
                switch(this.dias){
                    case 3:{
                        ArrayList<String> dia1 = new ArrayList<>();
                        dia1.add("Dia 1: Peito, Ombro e Tríceps\n");
                        dia1.add(adicionarAoTexto("peito"));
                        dia1.add(adicionarAoTexto("ombro"));
                        dia1.add(adicionarAoTexto("tríceps"));
                        textTreino.add(dia1);
                        ArrayList<String> dia2 = new ArrayList<>();
                        dia2.add("Dia 2: Costas, Bíceps e Abdômen\n");
                        dia2.add(adicionarAoTexto("costas"));
                        dia2.add(adicionarAoTexto("bíceps"));
                        dia2.add(adicionarAoTexto("abdômen"));
                        textTreino.add(dia2);
                        ArrayList<String> dia3 = new ArrayList<>();
                        dia3.add("Dia 3: Pernas e Panturrilha\n");
                        dia3.add(adicionarAoTexto("pernas"));
                        dia3.add(adicionarAoTexto("posterior"));
                        dia3.add(adicionarAoTexto("panturrilha"));
                        textTreino.add(dia3);
                        break;
                    }  
                    
                    case 4:{
                        ArrayList<String> dia1 = new ArrayList<>();
                        dia1.add("Dia 1: Peito e Ombro\n");
                        dia1.add(adicionarAoTexto("peito"));
                        dia1.add(adicionarAoTexto("ombro"));
                        textTreino.add(dia1);
                        ArrayList<String> dia2 = new ArrayList<>();
                        dia2.add("Dia 2: Costas e Abdômen\n");
                        dia2.add(adicionarAoTexto("costas"));
                        dia2.add(adicionarAoTexto("abdômen"));
                        textTreino.add(dia2);
                        ArrayList<String> dia3 = new ArrayList<>();
                        dia3.add("Dia 3: Pernas e Panturrilha\n");
                        dia3.add(adicionarAoTexto("pernas"));
                        dia3.add(adicionarAoTexto("posterior"));
                        dia3.add(adicionarAoTexto("panturrilha"));
                        textTreino.add(dia3);
                        ArrayList<String> dia4 = new ArrayList<>();
                        dia4.add("Dia 4: Tríceps e Bíceps\n");
                        dia4.add(adicionarAoTexto("tríceps"));
                        dia4.add(adicionarAoTexto("bíceps"));
                        textTreino.add(dia4);
                        break;
                    }
                    
                    case 5:{
                        ArrayList<String> dia1 = new ArrayList<>();
                        dia1.add("Dia 1: Peito e Abdômen\n");
                        dia1.add(adicionarAoTexto("peito")); 
                        dia1.add(adicionarAoTexto("abdômen"));
                        textTreino.add(dia1);
                        ArrayList<String> dia2 = new ArrayList<>();
                        dia2.add("Dia 2: Costas\n");
                        dia2.add(adicionarAoTexto("costas"));   
                        textTreino.add(dia2);
                        ArrayList<String> dia3 = new ArrayList<>();
                        dia3.add("Dia 3: Pernas e Panturrilha\n");
                        dia3.add(adicionarAoTexto("pernas"));
                        dia3.add(adicionarAoTexto("posterior"));
                        dia3.add(adicionarAoTexto("panturrilha"));
                        textTreino.add(dia3);
                        ArrayList<String> dia4 = new ArrayList<>();
                        dia4.add("Dia 4: Tríceps e Bíceps\n");
                        dia4.add(adicionarAoTexto("tríceps"));
                        dia4.add(adicionarAoTexto("bíceps"));
                        textTreino.add(dia4);
                        ArrayList<String> dia5 = new ArrayList<>();
                        dia5.add("Dia 5: Ombro\n");
                        dia5.add(adicionarAoTexto("ombro"));
                        textTreino.add(dia5);
                        break;
                    }
                }
                break;
            }

            case "mulher" :{
                switch(this.dias){
                    case 3:{
                        ArrayList<String> dia1 = new ArrayList<>();
                        dia1.add("Dia 1: Pernas, Posterior, Glúteos e Panturrilha\n");
                        dia1.add(adicionarAoTexto("pernas"));
                        dia1.add(adicionarAoTexto("posterior"));
                        dia1.add(adicionarAoTexto("glúteos"));
                        dia1.add(adicionarAoTexto("panturrilha"));
                        textTreino.add(dia1);
                        ArrayList<String> dia2 = new ArrayList<>();
                        dia2.add("\nDia 2: Costas e Bíceps\n");
                        dia2.add(adicionarAoTexto("costas"));
                        dia2.add(adicionarAoTexto("bíceps"));
                        dia2.add(adicionarAoTexto("abdômen"));
                        textTreino.add(dia2);
                        ArrayList<String> dia3 = new ArrayList<>();      
                        dia3.add("\nDia 3: Peito, Tríceps e Ombro\n\n");
                        dia3.add(adicionarAoTexto("peito"));
                        dia3.add(adicionarAoTexto("tríceps"));
                        dia3.add(adicionarAoTexto("ombro"));
                        textTreino.add(dia3);
                        break;
                    }  
                    
                    case 4:{
                        ArrayList<String> dia1 = new ArrayList<>();
                        dia1.add("\nDia 1: Pernas e Panturrilha\n");
                        dia1.add(adicionarAoTexto("pernas"));
                        dia1.add(adicionarAoTexto("panturrilha"));
                        textTreino.add(dia1);
                        ArrayList<String> dia2 = new ArrayList<>();
                        dia2.add("\nDia 2: Peito, Tríceps e Ombro\n");
                        dia2.add(adicionarAoTexto("peito"));
                        dia2.add(adicionarAoTexto("tríceps"));
                        dia2.add(adicionarAoTexto("ombro"));
                        textTreino.add(dia2);
                        ArrayList<String> dia3 = new ArrayList<>(); 
                        dia3.add("\nDia 3: Pernas e Panturrilha\n");
                        dia3.add(adicionarAoTexto("pernas"));
                        dia3.add(adicionarAoTexto("posterior"));
                        dia3.add(adicionarAoTexto("panturrilha"));
                        textTreino.add(dia3);
                        ArrayList<String> dia4 = new ArrayList<>();
                        dia4.add("\nDia 4: Costas, Bíceps e Abdômen\n");
                        dia2.add(adicionarAoTexto("costas"));
                        dia4.add(adicionarAoTexto("bíceps"));
                        dia4.add(adicionarAoTexto("abdômen"));
                        textTreino.add(dia2);
                        
                        break;
                    }
                    
                    case 5:{
                        ArrayList<String> dia1 = new ArrayList<>();
                        dia1.add("\nDia 1: Pernas e Panturrilha\n");
                        dia1.add(adicionarAoTexto("pernas"));
                        dia1.add(adicionarAoTexto("panturrilha"));
                        textTreino.add(dia1);
                        ArrayList<String> dia2 = new ArrayList<>();
                        dia2.add("\nDia 2: Peito, Tríceps e Ombro\n");
                        dia2.add(adicionarAoTexto("peito"));
                        dia2.add(adicionarAoTexto("tríceps"));
                        dia2.add(adicionarAoTexto("ombro"));
                        textTreino.add(dia2);
                        ArrayList<String> dia3 = new ArrayList<>();     
                        dia3.add("\nDia 3: Posterior\n");
                        dia3.add(adicionarAoTexto("posterior"));
                        textTreino.add(dia3);
                        ArrayList<String> dia4 = new ArrayList<>();
                        dia4.add("\nDia 4: Costas e Bíceps\n");
                        dia4.add(adicionarAoTexto("costas"));
                        dia4.add(adicionarAoTexto("bíceps"));
                        textTreino.add(dia4);
                        ArrayList<String> dia5 = new ArrayList<>();
                        dia5.add("\nDia 5: Glúteos e Abdômen\n");
                        dia5.add(adicionarAoTexto("glúteos"));
                        dia5.add(adicionarAoTexto("abdômen"));
                        textTreino.add(dia5);
                        break;
                    }
                }
                break;
            }
        }
        return textTreino;
    }

    public boolean trocarExercicio (String exercicioTrocado){    
        boolean contem = false;
        String tipo = "";
        int id = -1;
        
        for(int i = 0; i < treino.size(); i++){
            if(exercicioTrocado.equals(treino.get(i))){
                contem = true;
                id = i;
                tipo = grupos.get(i);
            }
        }

        if(!contem){
            return contem;
        }

        switch(tipo){
            case "peito":{
                mudarExercicio(exercicioTrocado, peito, tipo, id);
                break;
            }
            case "costas":{
                mudarExercicio(exercicioTrocado, costas, tipo, id);
                break;
            }
            case "bíceps":{
                mudarExercicio(exercicioTrocado, biceps, tipo, id);
                break;
            }
            case "tríceps":{
                mudarExercicio(exercicioTrocado, triceps, tipo, id);
                break;
            }
            case "ombro":{
                mudarExercicio(exercicioTrocado, ombro, tipo, id);
                break;
            }
            case "pernas":{
                mudarExercicio(exercicioTrocado, pernas, tipo, id);
                break;
            }
            case "posterior":{
                mudarExercicio(exercicioTrocado, posterior, tipo, id);
                break;
            }
            case "panturrilha":{
                mudarExercicio(exercicioTrocado, panturrilha, tipo, id);
                break;
            }
            case "glúteos":{
                mudarExercicio(exercicioTrocado, gluteos, tipo, id);
                break;
            }
            case "abdômen":{
                mudarExercicio(exercicioTrocado, abdomen, tipo, id);
                break;
            }
        }
        return contem;
    }

    public boolean estaNoTreino(String exercicio){
        boolean contem = false;
        if(treino.contains(exercicio)){
            contem = true;
        }
        return contem;
    }

    @Override
    public String toString(){
        return "Treino" + getCodigo();
    }

    //MÉTODOS INTERNOS

    private void mudarExercicio(String exercicioTrocado, ArrayList<String> grupo, String nomeGrupo, int id){ 
        int aux = r.nextInt(grupo.size());
        String novoExercicio = grupo.get(aux);
        while(novoExercicio.equals(exercicioTrocado) || treino.contains(novoExercicio)){
            aux = r.nextInt(grupo.size());
            novoExercicio = grupo.get(aux);
        }
        treino.set(id, novoExercicio);
    }
    
    private String adicionarAoTexto(String grupo){
        String textTreino = "";
        for(int i = 0; i < treino.size(); i++){
            if(grupo.equals(grupos.get(i))){
                textTreino += "*" + treino.get(i) + "\n";
           }
        }
        return textTreino;
    }

    private void randomizarExercicios(ArrayList<String> grupo, int numExercicios, String nomeGrupo){
        ArrayList <Integer> repeatedIndex = new ArrayList<>();
        int aux;
        for(int i = 0; i < numExercicios; i++){
            aux = r.nextInt(grupo.size());
            while(repeatedIndex.contains(aux)){
                aux = r.nextInt(grupo.size());
            }
            treino.add(grupo.get(aux));
            grupos.add(nomeGrupo);
            repeatedIndex.add(aux);
        }
        repeatedIndex.clear();
    }

    private void gerarTreino (int dias){

        this.dias = dias;
        if(usuario.isGenero()){
            s = "homem";
        } else {
            s = "mulher";
        }

        switch(s){
            case "homem":{
                switch(dias){
                    case 3:{  //Treino ABC
        
                        //Dia 1
                        randomizarExercicios(peito, 3, "peito");
                        randomizarExercicios(ombro, 2, "ombro");
                        randomizarExercicios(triceps, 2, "tríceps");
        
                        //Dia 2
                        randomizarExercicios(costas, 4, "costas");
                        randomizarExercicios(biceps, 2, "bíceps");
                        randomizarExercicios(abdomen, 1, "abdômen");
        
                        //Dia 3
                        randomizarExercicios(pernas, 3, "pernas");
                        randomizarExercicios(posterior, 2, "posterior");
                        randomizarExercicios(panturrilha, 1, "panturrilha");
                       
                        break; 
                    }
        
                    case 4:{  //Treino ABCD
         
                        //Dia 1
                        randomizarExercicios(peito, 4, "peito");
                        randomizarExercicios(ombro, 2, "ombro");
        
                        //Dia 2
                        randomizarExercicios(costas, 6, "costas");
                        randomizarExercicios(abdomen, 1, "abdômen");
        
                        //Dia 3
                        randomizarExercicios(pernas, 3, "pernas");
                        randomizarExercicios(posterior, 2, "posterior");
                        randomizarExercicios(panturrilha, 1, "panturrilha");
        
                        //Dia 4
                        randomizarExercicios(triceps, 3, "tríceps");
                        randomizarExercicios(biceps, 3, "bíceps");
        
                        break;
                    }
        
                    case 5:{  //Treino ABCDE
     
                        //Dia 1
                        randomizarExercicios(peito, 5, "peito");
                        randomizarExercicios(abdomen, 2, "abdômen");
        
                        //Dia 2
                        randomizarExercicios(costas, 6, "costas");
        
                        //Dia 3
                        randomizarExercicios(pernas, 3, "pernas");
                        randomizarExercicios(posterior, 2, "posterior");
                        randomizarExercicios(panturrilha, 1, "panturrilha");

                        //Dia 4
                        randomizarExercicios(triceps, 3, "tríceps");
                        randomizarExercicios(biceps, 3, "bíceps");
        
                        //Dia 5
                        randomizarExercicios(ombro, 5, "ombro");
        
                        break;
                    }
                }
                break;
            } 

            case "mulher":{
                switch(dias){
                    case 3:{  //Treino ABC
        
                        //Dia 1
                        randomizarExercicios(peito, 3, "peito");
                        randomizarExercicios(triceps, 2, "tríceps");
                        randomizarExercicios(ombro, 2, "ombro");
                        
        
                        //Dia 2
                        randomizarExercicios(pernas, 3, "pernas");
                        randomizarExercicios(posterior, 2, "posterior");
                        randomizarExercicios(gluteos, 2, "glúteos");
                        randomizarExercicios(panturrilha, 1, "panturrilha");
        
                        //Dia 3
                        randomizarExercicios(costas, 3, "costas");
                        randomizarExercicios(biceps, 2, "bíceps");
                        randomizarExercicios(abdomen, 2, "abdômen");
                        
                        break; 
                    }
        
                    case 4:{  //Treino ABCD
                       
                        //Dia 1
                        randomizarExercicios(pernas, 5, "pernas");
                        randomizarExercicios(panturrilha, 2, "panturrilha");
        
                        //Dia 2
                        randomizarExercicios(peito, 3, "peito");
                        randomizarExercicios(ombro, 2, "ombro");
                        randomizarExercicios(triceps, 2, "tríceps");
        
                        //Dia 3
                        randomizarExercicios(posterior, 3, "posterior");
                        randomizarExercicios(gluteos, 3, "glúteos");
        
                        //Dia 4
                        randomizarExercicios(costas, 3, "costas");
                        randomizarExercicios(biceps, 3, "bíceps");
                        randomizarExercicios(abdomen, 2, "abdômen");
        
                        break;
                    }
        
                    case 5:{  //Treino ABCDE
        
                        //Dia 1
                        randomizarExercicios(pernas, 5, "pernas");
                        randomizarExercicios(panturrilha, 2, "panturrilha");

                        //Dia 2
                        randomizarExercicios(peito, 3, "peito");
                        randomizarExercicios(ombro, 2, "ombro");
                        randomizarExercicios(triceps, 2, "tríceps");
        
                        //Dia 3                   
                        randomizarExercicios(posterior, 4, "posterior");
        
                        //Dia 4
                        randomizarExercicios(costas, 4, "costas");
                        randomizarExercicios(biceps, 2, "bíceps");
        
                        //Dia 5
                        randomizarExercicios(gluteos, 3, "glúteos");
                        randomizarExercicios(abdomen, 2, "abdômen");

                        break;
                    }
                }
                break;
            }
        }
        
    }
}
