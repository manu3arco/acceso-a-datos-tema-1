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
        marco.setLayout(new GridLayout(5,1));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panel5 = new JPanel();
        panel5.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton file = new JButton("Selecciona un fichero o directorio");
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fc.setCurrentDirectory(new File("C:\\Users\\dam2\\Desktop"));
        fc.setPreferredSize(new Dimension(600, 300));


        //==========================================================================





        //==========================================================================


        /*---------------- CONTADOR PALABRAS Y VOCALES ----------------*/

        JButton contadores = new JButton("Contador de palabras y vocales");
        contadores.addActionListener(e -> {
            contapala.contar(archivo, fc);
        });

        /*---------------- CONTADOR PALABRAS Y VOCALES ----------------*/


        //==========================================================================


        /*---------------- EDITOR DE TEXTO ----------------*/

        JButton editar = new JButton("Editor");
        editar.addActionListener(e -> {
            editorarchivo.editar(archivo);
        });

        /*---------------- EDITOR DE TEXTO ----------------*/


        //==========================================================================


        JButton copiar = new JButton("Copiar archivo");
        copiar.addActionListener(e -> {
            copiarchi.copiar(archivo);
        });

        //==========================================================================

        JButton datos = new JButton("Ver los datos del archivo seleccionado");

        panel1.add(file);
        panel2.add(datos);
        panel3.add(contadores);
        panel4.add(editar);
        panel5.add(copiar);

        marco.add(panel1);

        /*---------------- DATOS DEL FICHERO ----------------*/

        file.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){

                    archivo = String.valueOf(fc.getSelectedFile());
                    marco.add(panel2);
                    marco.add(panel3);
                    marco.add(panel4);
                    marco.add(panel5);

                    marco.revalidate();

                }else{
                    JOptionPane.showMessageDialog(marco,"Ha ocurrido un error al abrir el archivo.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        datos.addActionListener(e -> {
            datosarchivo.datos(archivo, fc);
        });

        /*---------------- DATOS DEL FICHERO ----------------*/


        marco.setVisible(true);
        marco.setResizable(false);
    }
}
