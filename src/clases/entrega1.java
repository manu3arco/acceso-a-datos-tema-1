package clases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class entrega1 {

    private static String archivo;

    public static void main (String [] args){
        JFrame marco = new JFrame();

        marco.setSize(500, 400);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setLayout(new GridLayout(2,1));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton file = new JButton("Selecciona un fichero o directorio");
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fc.setCurrentDirectory(new File("C:\\Users\\dam2"));
        fc.setPreferredSize(new Dimension(600, 300));
        panel1.add(file);

        file.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){

                    archivo = String.valueOf(fc.getSelectedFile());

                }else{
                    JOptionPane.showMessageDialog(marco,"Ha ocurrido un error al abrir el archivo.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton datos = new JButton("Ver los datos del archivo seleccionado");
        datos.addActionListener(e -> {
            datosarchivo.datos(archivo, fc);
        });
        panel2.add(datos);

        marco.add(panel1);
        marco.add(panel2);

        marco.setVisible(true);
        marco.setResizable(false);
    }
}
