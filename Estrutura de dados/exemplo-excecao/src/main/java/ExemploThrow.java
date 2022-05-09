import javax.swing.*;

public class ExemploThrow {

    public static void main(String[] args) {

        float nota1 = Float.parseFloat(JOptionPane.showInputDialog("Digite a nota 1: "));
        float nota2 = Float.parseFloat(JOptionPane.showInputDialog("Digite a nota 2: "));

        try{
            if(nota1 < 0 || nota1 > 10){
                throw new LimiteUltrapassadoException("Nota1: Valor fora dos limites permitidos!");
            }
            if(nota2 < 0 || nota2 > 10){
                throw new LimiteUltrapassadoException("Nota2: Valor fora dos limites permitidos!");
            }
            JOptionPane.showMessageDialog(null, "Média = " + (nota1 + nota2)/2);
        }
        catch(LimiteUltrapassadoException erro){
            JOptionPane.showMessageDialog(null, erro + "\n " + erro.data, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
