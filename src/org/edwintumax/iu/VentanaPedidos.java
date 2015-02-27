package org.edwintumax.iu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.edwintumax.bean.TasaDolar;
import org.edwintumax.interfaces.Observer;
import org.edwintumax.modelo.ModeloTasaDolar;
public class VentanaPedidos extends JFrame implements Observer {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPanel;
    private JTable tabla;
    private ModeloTasaDolar modelo;    
    private JButton btnAgregar;
    public VentanaPedidos() {
        this.setTitle("Ventana de Pedidos");
        this.setLayout(null);
        modelo = new ModeloTasaDolar();
        tabla = new JTable();
        tabla.setModel(modelo);
        modelo.actualizarDatos();
        btnAgregar = new JButton("Actualizar Tasa");
        btnAgregar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String nuevoValor = javax.swing.JOptionPane.showInputDialog("Nuevo valor");
                modelo.agregar(new TasaDolar(Double.parseDouble(nuevoValor),new Date()));
            }
        });
        btnAgregar.setBounds(5,270,160,40);
        this.getContentPane().add(btnAgregar);
        scrollPanel = new JScrollPane();
        scrollPanel.setViewportView(tabla);
        scrollPanel.setBounds(5,5,470,250);
        this.getContentPane().add(scrollPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,350);
        this.setVisible(true);
    }
    public void actualizar() {
        modelo.actualizarDatos();
    }
}