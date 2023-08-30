package model;
import java.text.DecimalFormat;
import java.io.Serializable;
public class Dieta implements Serializable {
    // Atributos
    private Usuario usuario;
    private int opatividade;
    private int opdieta;
    private double atividade;
    private int codigo;
    private double proteina;
    private double carbo;
    private double gordura;

    // Construtores
    public Dieta (Usuario usuario, int codigo) {
        this.usuario = usuario;
        this.codigo = codigo;
     }
     
     public Dieta (Usuario usuario, int opdieta, int opatividade) {
        this.usuario = usuario;
        this.opatividade = opatividade;
        this.opdieta = opdieta;
        switch (opatividade) {
             case 1: {
               this.atividade = 1.2;
               break;
             }
             case 2: {
               this.atividade = 1.55;
               break;
             }
             case 3: {
               this.atividade = 1.725;
               break;
             }
        }
     }

     // Getters and Setters 
    
    public void setCodigo (int codigo) {
         this.codigo = codigo;
     }
       public int getCodigo () {
        return this.codigo;
     }
           
      public double getAtividade () {
        return this.atividade;
     }
     
     public Usuario getUsuario() {
        return usuario;
    }
     // Metodos geradores de Dieta
     DecimalFormat formatar = new DecimalFormat("#,##0.00");
     public double gerarCalorias() {
        if (usuario.isGenero()) {
            return ((10.00 * usuario.getPeso()) + (6.25 * usuario.getAltura()) -(5.00 * usuario.getIdade() + 5)) * atividade;
        }
        else {
         return ((10.00 * usuario.getPeso()) + (6.25 * usuario.getAltura()) - (5.00 * usuario.getIdade() - 161)) * atividade;
        }
     }
     public String CuttingCarboModerado () {
        this.proteina = (gerarCalorias() - 500) * 0.3 / 4;
        this.gordura = (gerarCalorias() - 500) * 0.35 / 9;
        this.carbo = (gerarCalorias() - 500) * 0.35 / 4;

     return ("Carboidrato: " + formatar.format(carbo) + "g" + " \nProteina: " + formatar.format(proteina) + "g" + " \nGordura: " + formatar.format(gordura) + "g");

     }
     public String CuttingCarboBaixo () {
        this.proteina = (gerarCalorias() - 500) * 0.4 / 4;
        this.gordura = (gerarCalorias() - 500) * 0.4 / 9;
        this.carbo = (gerarCalorias() - 500) * 0.2 / 4;

     return ("Carboidrato: " + formatar.format(carbo) + "g" + " \nProteina: " + formatar.format(proteina) + "g" + " \nGordura: " + formatar.format(gordura) + "g");

     }
     public String CuttingCarboAlto() {
        this.proteina = (gerarCalorias() - 500) * 0.3 / 4;
        this.gordura = (gerarCalorias() - 500) * 0.2 / 9;
        this.carbo = (gerarCalorias() - 500) * 0.5 / 4;

     return ("Carboidrato: " + formatar.format(carbo) + "g" + " \nProteina: " + formatar.format(proteina) + "g" + " \nGordura: " + formatar.format(gordura) + "g");

     }
      public String MaintanceCarboModerado () {
        this.proteina = (gerarCalorias()) * 0.3 / 4;
        this.gordura = (gerarCalorias()) * 0.35 / 9;
        this.carbo = (gerarCalorias()) * 0.35 / 4;

     return ("Carboidrato: " + formatar.format(carbo) + "g" + " \nProteina: " + formatar.format(proteina) + "g" + " \nGordura: " + formatar.format(gordura) + "g");

     }
      public String MaintanceCarbobaixo () {
        this.proteina = gerarCalorias() * 0.4 / 4;
        this.gordura = gerarCalorias()  * 0.4 / 9;
        this.carbo = gerarCalorias() * 0.2 / 4;

     return ("Carboidrato: " + formatar.format(carbo) + "g" + " \nProteina: " + formatar.format(proteina) + "g" + "\nGordura: " + formatar.format(gordura) + "g");

     }
       public String MaintanceCarboAlto() {
        this.proteina = gerarCalorias() * 0.3 / 4;
        this.gordura = gerarCalorias()  * 0.2 / 9;
        this.carbo = gerarCalorias() * 0.5 / 4;

     return ("Carboidrato: " + formatar.format(carbo) + "g" + " \nProteina: " + formatar.format(proteina) + "g" + " \nGordura: " + formatar.format(gordura) + "g");

     }
       public String BulkCarboModerado () {
        this.proteina = (gerarCalorias() + 500) * 0.3 / 4;
        this.gordura = (gerarCalorias() + 500)  * 0.35 / 9;
        this.carbo = (gerarCalorias() + 500) * 0.35 / 4;

     return ("Carboidrato: " + formatar.format(carbo) + "g" + " \nProteina: " + formatar.format(proteina) + "g" + " \nGordura: " + formatar.format(gordura) + "g");

     }
     public String BulkCarboBaixo () {
        this.proteina = (gerarCalorias() + 500) * 0.4 / 4;
        this.gordura = (gerarCalorias() + 500) * 0.4 / 9;
        this.carbo = (gerarCalorias() + 500) * 0.2 / 4;

     return ("Carboidrato: " + formatar.format(carbo) + "g" + " \nProteina: " + formatar.format(proteina) + "g" + " \nGordura: " + formatar.format(gordura) + "g");

     }
     public String BulkCarboAlto () {
        this.proteina = (gerarCalorias() + 500) * 0.3 / 4;
        this.gordura = (gerarCalorias() + 500)  * 0.2 / 9;
        this.carbo = (gerarCalorias() + 500)* 0.5 / 4;

     return ("Carboidrato: " + formatar.format(carbo) + "g" + " \nProteina: " + formatar.format(proteina) + "g" + " \nGordura: " + formatar.format(gordura) + "g");

     }
    
    public String calcularIMC () {
        double peso = usuario.getPeso();
        double altura = usuario.getAltura();
        double imc = peso / ((altura/100) * (altura/100));
        if (imc < 18.5) {
            return "IMC: " + formatar.format(imc) + " - Abaixo do peso\n";
        } else if (imc < 25) {
            return "IMC: " + formatar.format(imc) + " - Peso normal\n";
        } else if (imc  < 30) {
            return "IMC: " + formatar.format(imc) + " - Sobreopeso\n";
        } else if (imc  < 35) {
            return "IMC: " + formatar.format(imc) + " - Obesidade grau 1\n";
        } else if (imc  < 40) {
            return "IMC: " + formatar.format(imc) + " - Obesidade grau 2\n";
        } else {
            return "IMC: " + formatar.format(imc) + " - Obesidade grau 3\n";
        }
    }
    
      public String imprimirDieta () {
         String textdieta = ""; 
         switch (opdieta) {
            case 1: {
               textdieta += "Gasto calorico diario: " + gerarCalorias() + "\n\n";
               textdieta += "Macronutrentes para dieta de manuntenção: \n" +
                            "Carboidrato moderado:\n" + MaintanceCarboModerado() + "\n\n" +
                            "Carboidrato alto:\n" + MaintanceCarboAlto() + "\n\n" +
                            "Carboidato baixo:\n" + MaintanceCarbobaixo();
               break;
            }
              case 2: {
               textdieta += "Gasto calorico diario: " + gerarCalorias() + "\n\n";
               textdieta += "Macronutrentes para dieta de emagrecimento: \n" +
                            "Carboidrato moderado:\n" + CuttingCarboModerado() + "\n\n" +
                            "Carboidrato alto:\n" + CuttingCarboAlto() + "\n\n" +
                            "Carboidato baixo:\n" + CuttingCarboBaixo();
               break;
            }
              case 3: {
               textdieta += "Gasto calorico diario: " + gerarCalorias() + "\n\n";
               textdieta += "Macronutrentes para dieta de ganho de massa: \n" +
                            "Carboidrato moderado:\n" + BulkCarboModerado() + "\n\n" +
                            "Carboidrato alto:\n" + BulkCarboAlto() + "\n\n" +
                            "Carboidato baixo:\n" + BulkCarboBaixo();
               break;
            }
          }
          return textdieta;
     }
}
