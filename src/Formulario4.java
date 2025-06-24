import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class Formulario4 extends JFrame {

    private JTextField txtNombre, txtApellido, txtEdad, txtTelefono;
    private JRadioButton rbHombre, rbMujer;
    private JCheckBox cbFutbol, cbBasquet, cbTenis, cbNatacion;
    private JComboBox<String> comboBarrio;
    private JButton btnRegistrar, btnLimpiar;
    private JTable tabla;
    private DefaultTableModel modeloTabla;

    public Formulario4() {
        setTitle("Formulario de Registro");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 2, 5, 5));

        // Campos de texto
        txtNombre = new JTextField();
        txtApellido = new JTextField();
        txtEdad = new JTextField();
        txtTelefono = new JTextField();

        // Género
        rbHombre = new JRadioButton("Hombre");
        rbMujer = new JRadioButton("Mujer");
        ButtonGroup grupoGenero = new ButtonGroup();
        grupoGenero.add(rbHombre);
        grupoGenero.add(rbMujer);

        // Deportes
        cbFutbol = new JCheckBox("Fútbol");
        cbBasquet = new JCheckBox("Básquet");
        cbTenis = new JCheckBox("Tenis");
        cbNatacion = new JCheckBox("Natación");

        // Barrios
        String[] barrios = {"La Floresta", "Chillogallo", "Carcelén", "El Condado"};
        comboBarrio = new JComboBox<>(barrios);

        // Botones
        btnRegistrar = new JButton("Registrar");
        btnLimpiar = new JButton("Limpiar");

        // Tabla
        String[] columnas = {"Nombre", "Apellido", "Edad", "Teléfono", "Género", "Deportes", "Barrio"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tabla);

        // Añadir componentes al panel
        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);
        panel.add(new JLabel("Apellido:"));
        panel.add(txtApellido);
        panel.add(new JLabel("Edad:"));
        panel.add(txtEdad);
        panel.add(new JLabel("Teléfono:"));
        panel.add(txtTelefono);

        panel.add(new JLabel("Género:"));
        JPanel panelGenero = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelGenero.add(rbHombre);
        panelGenero.add(rbMujer);
        panel.add(panelGenero);

        panel.add(new JLabel("Deportes:"));
        JPanel panelDeportes = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelDeportes.add(cbFutbol);
        panelDeportes.add(cbBasquet);
        panelDeportes.add(cbTenis);
        panelDeportes.add(cbNatacion);
        panel.add(panelDeportes);

        panel.add(new JLabel("Barrio:"));
        panel.add(comboBarrio);

        panel.add(btnRegistrar);
        panel.add(btnLimpiar);

        // Agregar paneles al JFrame
        getContentPane().add(panel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Acciones de los botones
        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarDatos();
            }
        });

        btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });

        setVisible(true);
    }

    private void registrarDatos() {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String edad = txtEdad.getText();
        String telefono = txtTelefono.getText();

        String genero = rbHombre.isSelected() ? "Hombre" : (rbMujer.isSelected() ? "Mujer" : "No especificado");

        StringBuilder deportes = new StringBuilder();
        if (cbFutbol.isSelected()) deportes.append("Fútbol ");
        if (cbBasquet.isSelected()) deportes.append("Básquet ");
        if (cbTenis.isSelected()) deportes.append("Tenis ");
        if (cbNatacion.isSelected()) deportes.append("Natación ");

        String barrio = comboBarrio.getSelectedItem().toString();

        modeloTabla.addRow(new Object[]{nombre, apellido, edad, telefono, genero, deportes.toString().trim(), barrio});
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtEdad.setText("");
        txtTelefono.setText("");
        rbHombre.setSelected(false);
        rbMujer.setSelected(false);
        cbFutbol.setSelected(false);
        cbBasquet.setSelected(false);
        cbTenis.setSelected(false);
        cbNatacion.setSelected(false);
        comboBarrio.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Formulario4());
    }
}
