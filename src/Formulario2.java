import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formulario2 extends JFrame {
    private JPanel principal;
    private JRadioButton aLaCapacidadDeRadioButton;
    private JRadioButton bLaCapacidadDeRadioButton;
    private JRadioButton cUsarMúltiplesClasesRadioButton;
    private JRadioButton aPrivateRadioButton;
    private JRadioButton bPublicRadioButton;
    private JRadioButton cDefaultRadioButton;
    private JRadioButton falsoRadioButton;
    private JRadioButton verdaderoRadioButton;
    private JLabel primera;
    private JLabel segunda;
    private JLabel tercero;
    private JButton verResultadosButton;
    private JButton limpiarButton;

    public Formulario2() {
        setTitle("Test Java POO");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(principal);
        setLocationRelativeTo(null);
        setVisible(true);

        // Agrupar botones para cada pregunta
        ButtonGroup grupo1 = new ButtonGroup();
        grupo1.add(aLaCapacidadDeRadioButton);
        grupo1.add(bLaCapacidadDeRadioButton);
        grupo1.add(cUsarMúltiplesClasesRadioButton);

        ButtonGroup grupo2 = new ButtonGroup();
        grupo2.add(aPrivateRadioButton);
        grupo2.add(bPublicRadioButton);
        grupo2.add(cDefaultRadioButton);

        ButtonGroup grupo3 = new ButtonGroup();
        grupo3.add(verdaderoRadioButton);
        grupo3.add(falsoRadioButton);

        // Acción botón Ver Resultados
        verResultadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int puntaje = 0;

                // Respuesta correcta pregunta 1: B
                if (bLaCapacidadDeRadioButton.isSelected()) {
                    puntaje += 5;
                }

                // Respuesta correcta pregunta 2: C (default)
                if (cDefaultRadioButton.isSelected()) {
                    puntaje += 5;
                }

                // Respuesta correcta pregunta 3: Verdadero
                if (verdaderoRadioButton.isSelected()) {
                    puntaje += 5;
                }

                JOptionPane.showMessageDialog(null,
                        "Tu puntaje total es: " + puntaje + " / 15",
                        "Resultado",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Acción botón Limpiar
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                grupo1.clearSelection();
                grupo2.clearSelection();
                grupo3.clearSelection();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Formulario2());
    }
}
