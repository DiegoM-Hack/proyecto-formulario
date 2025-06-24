import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formulario extends JFrame {
    private JPanel contenedor;
    private JTextField nombre;
    private JTextField apellido;
    private JTextField anioNacimiento;
    private JButton hombreButton;
    private JButton mujerButton;
    private JButton verificarEdadButton;
    private JButton Limpiar;

    public Formulario() {

        setTitle("Mi Formulario ");
        setSize(500, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contenedor);
        setLocationRelativeTo(null);
        setVisible(true);

        verificarEdadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String datos = verificarEdad();
                JOptionPane.showMessageDialog(null, datos, "Datos Ingresados", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        hombreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        mujerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        Limpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombre.setText("");
                apellido.setText("");
                anioNacimiento.setText("");
            }
        });
    }

    public String verificarEdad() {

        String nombre = this.nombre.getText();
        String apellido = this.apellido.getText();
        int anio = Integer.parseInt(anioNacimiento.getText());

        int edad = 2025 - Integer.parseInt(anioNacimiento.getText());
        if (2025-Integer.parseInt(anioNacimiento.getText()) >= 18) {
            return "Nombre: " + nombre +" "+ apellido +"\n"
                    + "Es mayor de edad y su edad es: " + edad + "\n"
                    + "Año de Nacimiento: " + anio + "\n";
        }else {
            return "Nombre: " + nombre + apellido +"\n"
                    + "Es menor de edad y su edad es: " + edad + "\n"
                    + "Año de Nacimiento: " + anio + "\n";
        }
    }
    public static void main(String[] args) {
        Formulario dialog = new Formulario();
        dialog.setVisible(true);

    }
}
