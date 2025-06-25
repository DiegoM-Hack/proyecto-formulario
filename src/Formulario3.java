import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Formulario3 extends JFrame {
    private JPanel principal;
    private JComboBox<String> comboProductos;
    private JTextField txtCantidad;
    private JLabel lblPrecio;
    private JLabel lblSubtotal;
    private JLabel lblIVA;
    private JLabel lblDescuento;
    private JLabel lblTotal;
    private JTable tablaResumen;
    private JButton btnPagar;
    private JButton btnLimpiar;

    private HashMap<String, Double> precios;
    private DefaultTableModel modeloTabla;

    public Formulario3() {
        setTitle("Test de Compras - Semi-Factura");
        setSize(800, 500);
        setContentPane(principal);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Precios de productos
        precios = new HashMap<>();
        precios.put("Martillo", 10.00);
        precios.put("Clavos", 3.50);
        precios.put("Pintura Blanca", 15.00);
        precios.put("Taladro", 50.00);

        // Rellenar combo
        comboProductos.setModel(new DefaultComboBoxModel<>(precios.keySet().toArray(new String[0])));

        // Configurar tabla
        modeloTabla = new DefaultTableModel(new String[]{"Producto", "Cantidad", "Precio Unit.", "Subtotal", "IVA", "Descuento", "Total"}, 0);
        tablaResumen.setModel(modeloTabla);

        // Mostrar precio cuando cambia el producto
        comboProductos.addActionListener(e -> mostrarPrecio());

        // Acción botón pagar
        btnPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagar();
            }
        });

        // Acción botón limpiar
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();
            }
        });

        mostrarPrecio(); // Mostrar precio del primer producto al iniciar
        setVisible(true);
    }

    private void mostrarPrecio() {
        String producto = (String) comboProductos.getSelectedItem();
        if (producto != null) {
            double precio = precios.get(producto);
            lblPrecio.setText(String.format("$ %.2f", precio));
        }
    }

    private void pagar() {
        String producto = (String) comboProductos.getSelectedItem();
        double precioUnitario = precios.get(producto);

        int cantidad;
        try {
            cantidad = Integer.parseInt(txtCantidad.getText());
            if (cantidad <= 0) throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingresa una cantidad válida (entero mayor a 0)", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double subtotal = precioUnitario * cantidad;
        double iva = subtotal * 0.15;
        double descuento = subtotal * 0.20;
        double total = subtotal + iva - descuento;

        // Mostrar en etiquetas
        lblSubtotal.setText(String.format("$ %.2f", subtotal));
        lblIVA.setText(String.format("$ %.2f", iva));
        lblDescuento.setText(String.format("$ %.2f", descuento));
        lblTotal.setText(String.format("$ %.2f", total));

        // Agregar a la tabla
        modeloTabla.addRow(new Object[]{
                producto, cantidad, String.format("$ %.2f", precioUnitario),
                String.format("$ %.2f", subtotal),
                String.format("$ %.2f", iva),
                String.format("$ %.2f", descuento),
                String.format("$ %.2f", total)
        });
    }

    private void limpiar() {
        txtCantidad.setText("");
        lblPrecio.setText("$ 0.00");
        lblSubtotal.setText("$ 0.00");
        lblIVA.setText("$ 0.00");
        lblDescuento.setText("$ 0.00");
        lblTotal.setText("$ 0.00");
        modeloTabla.setRowCount(0);
        comboProductos.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Formulario3());
    }
}
