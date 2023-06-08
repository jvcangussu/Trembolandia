package view;

/*import java.time.LocalDate;
import javax.swing.JOptionPane;
import control.ControleUsuario;
*/

public class App {

    /*public static String menu(){
        return "Digite:\n" +
                "1 - Cadastrar Usuário\n"+
                "2 - Listar usuários\n" +
                "3 - Pesquisar usuário\n"+
                "4 - Remover usuário\n" +
                "5 - Login usuário\n"+
                "0 - para sair";
    }
    public static void main(String[] args) throws Exception {
        ControleUsuario cUsuario = new ControleUsuario();
        
        int op = Integer.parseInt(JOptionPane.showInputDialog(menu()));
        while(op != 0){
            switch(op){
                case 1:{
                    LocalDate data = null;
                    String username = JOptionPane.showInputDialog("Qual será o username?");
                    String senha = JOptionPane.showInputDialog("Qual será a senha?");
                    String nome = JOptionPane.showInputDialog("Qual será o nome?");
                    int opGen = Integer.parseInt(JOptionPane.showInputDialog("Qual é o gênero? 1 - Feminino 2 - Masculino"));
                    while(opGen != 1 && opGen != 2){
                        JOptionPane.showMessageDialog(null, "Opção inválida!");
                        opGen = Integer.parseInt(JOptionPane.showInputDialog("Qual é o gênero? 1 - Feminino 2 - Masculino"));
                    }
                    boolean genero = true;
                        if(opGen == 1)
                            genero = false;

                    cUsuario.cadastrarUsuario(username, senha, nome, genero, data.now());
                    break;
                }
                case 2:{
                    JOptionPane.showMessageDialog(null, cUsuario.imprimirUsuarios());
                    break;
                }
                case 3:{
                    String username = JOptionPane.showInputDialog("Qual o username do usuário que deseja procurar?");
                    JOptionPane.showMessageDialog(null, cUsuario.pesquisarUsuario(username).toString());
                }
                case 4:{
                    String username = JOptionPane.showInputDialog("Qual o username do usuário que deseja remover?");
                    cUsuario.removerUsuario(username);
                    break;
                }
                case 5:{
                    String username = JOptionPane.showInputDialog("Qual é o username?");
                    String senha = JOptionPane.showInputDialog("Qual é a senha?");
                    if(cUsuario.loginUsuario(username, senha))
                        JOptionPane.showMessageDialog(null, "Login com sucesso!");
                    else
                        JOptionPane.showMessageDialog(null, "Login sem sucesso!");
                    break;
                }
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
                    break;
            }
            op = Integer.parseInt(JOptionPane.showInputDialog(menu()));
        }
    }*/
}
