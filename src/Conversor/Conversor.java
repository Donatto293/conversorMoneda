package Conversor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Conversor extends JFrame {


    private JTextField txtCantidad;
    private JLabel lblResultado;
    private JLabel lblCantidad ;
    private JComboBox<String> comboMonedaOrigen;
    private  HashMap<String , Moneda > ValorMoneda;
    private JComboBox<String> comboMonedaDestino;
    public JButton btnConvertir;



    public Conversor() {
        setSize(600, 400); // Tamaño más grande para el marco
        setTitle("Conversor");
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        JLabel lblCantidad = new JLabel("Cantidad: ");
        lblCantidad.setBounds(30,30, 200, 30);
        ;

        txtCantidad = new JTextField(10);
        txtCantidad.setBounds(230, 30 , 200 ,30);

        ValorMoneda = new HashMap<>();
        ValorMoneda.put("Pesos Colombianos", new Moneda("Pesos Colombianos", 1.0,"USD"));
        ValorMoneda.put("Dolar", new Moneda( "Dólar", 0.00026, "USD"));
        ValorMoneda.put("Euro",new Moneda( "Euro" ,0.00022, "EUR0"));
        ValorMoneda.put("Libra Esterlina",new Moneda("Libra Esterlina", 0.00019, "GBP"));
        ValorMoneda.put("Yen Japonés",new Moneda("Yen Japones", 0.028, "JPY"));
        ValorMoneda.put("Won sur-coreano",new Moneda ("Won sur-coreano", 0.31, "KRW"));




        comboMonedaOrigen = new JComboBox<>(ValorMoneda.keySet().toArray(new String[0]));
         comboMonedaOrigen.setBounds(30,80,200,30);



        comboMonedaDestino = new JComboBox<>(ValorMoneda.keySet().toArray(new String[0]));
            comboMonedaDestino.setBounds(230,80,200,30);


        btnConvertir = new JButton("Convertir");
         btnConvertir.setBounds(30, 130, 400, 40);
        btnConvertir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String opcionSeleccionada = (String) comboMonedaDestino.getSelectedItem();
                String opcionDeMoneda = (String) comboMonedaOrigen.getSelectedItem();

                int numeroIngresado;
                try {
                    numeroIngresado = Integer.parseInt(txtCantidad.getText());
                } catch (NumberFormatException ex) {
                    // Si el usuario no ingresó un número válido, mostramos un mensaje de error
                    lblResultado.setText("Resultado: Error - Ingrese un número válido");
                    return;
                }

                // Realizar la conversion a la moneda elegida
                double resultado;


                Moneda monedaOrigen = ValorMoneda.get(opcionDeMoneda);
                Moneda monedaDestino = ValorMoneda.get(opcionSeleccionada);


                 resultado = numeroIngresado * (monedaDestino.getValorConversion() / monedaOrigen.getValorConversion());

                 //resultado con 2 decimales
                 String resultadoRedondeado = String.format("%.2f", resultado);



                String resultadoFinal = resultadoRedondeado + " " + monedaDestino.getAbreviaturaMoneda();

                lblResultado.setText("resultado= " + resultadoFinal + " " );

            }
        });
        lblResultado = new JLabel("Resultado: ");
        lblResultado.setBounds(30, 180, 400, 30);

        add(lblCantidad);
        add(txtCantidad);
        add(comboMonedaOrigen);
        add(comboMonedaDestino);
        add(btnConvertir);
        add(lblResultado);

        setVisible(true);



    }





    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            Conversor ventana = new Conversor();

            });
        }
    }
