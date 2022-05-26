package lib;
import javax.swing.JOptionPane;
import static java.lang.Integer.parseInt;
public class Principal {
    public static void main(String[] args) {
        String menu = "1-Cadastrar\n2-Atualizar\n3-Apagar\n4-Listar\n0-Sair";

        int op = 0;
        do{
            try{
                op = Integer.parseInt(JOptionPane.showInputDialog(menu));
                    switch (op){
                        case 1:{
                            String nome = JOptionPane.showInputDialog("Digite o nome");
                            String fone = JOptionPane.showInputDialog("Digite o fone");
                            String email = JOptionPane.showInputDialog("Digite o e-mail");
                            Pessoa p = new Pessoa(nome, fone, email);
                            p.inserir();
                            JOptionPane.showMessageDialog(null, "Pessoa cadastrada");
                            break;
                        }
                        case 2:{
                            String s = Pessoa.referenciar();
                            int codigo = parseInt(JOptionPane.showInputDialog("Escolha um código de cadastro abaixo para atualizar:\n" + s));
                            String s2 = Pessoa.referenciarUm(codigo);
                            String nome = JOptionPane.showInputDialog("Digite o nome:\nLembre-se! Você está atualizando:\n"+s2);
                            String fone = JOptionPane.showInputDialog("Digite o fone:\nLembre-se! Você está atualizando:\n"+s2);
                            String email = JOptionPane.showInputDialog("Digite o e-mail:\nLembre-se! Você está atualizando:\n"+s2);
                            Pessoa p = new Pessoa(codigo, nome, fone, email);
                            p.atualizar();
                            JOptionPane.showMessageDialog(null, "Pessoa atualizada");
                            break;
                        }
                        case 3:{
                            String s = Pessoa.referenciar();
                            new Pessoa(
                                parseInt(JOptionPane.showInputDialog("Digite um dos códigos abaixo para deletar:\n" + s+"\n"))
                            ).apagar();
                            break;
                        }
                        case 4:
//                            Pessoa.listar();
                        	String s = Pessoa.referenciar();
                        	JOptionPane.showMessageDialog(null, "\n" + s+"\n");
                            break;
                        case 0:
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opção inválida");
                }
            }
            catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Falhou...");
                    System.out.println(e.getMessage());
            }

        }while (op != 0);
   } 
}
