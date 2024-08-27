package view;
        
import control.PessoaController;
import java.text.ParseException;
import javax.swing.JOptionPane;

public class MenuPessoa  {
    final private PessoaController pessoaController;

    public MenuPessoa(PessoaController pessoaController) {
        this.pessoaController = pessoaController;
    }
    public void formularioCriacao(){
        try {
            String nome = JOptionPane.showInputDialog(null, "Digite o nome: ");
            String nascimento = JOptionPane.showInputDialog(null, "Digite sua data de nascimento (dd/MM/yyyy): ");
            String telefone = JOptionPane.showInputDialog(null, "Digite o seu telefone: ");
            
               pessoaController.criarPessoa(nome, nascimento, telefone);
               
            JOptionPane.showMessageDialog(null, "Pessoa criada com sucesso");
        } catch(ParseException e){
            JOptionPane.showMessageDialog(null, "Data de nascimento invalida");
        }
    }
    
    
    public static void main(String[] args) {
        PessoaController controller = new PessoaController(10); // Tamanho do array fixado em 10
        MenuPessoa view = new MenuPessoa(controller);

        view.formularioCriacao();
        controller.listarPessoas();
    }
    
    
}
