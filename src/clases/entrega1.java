package clases;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class entrega1 {

    public static String archivo;
    public static JFileChooser fc;

    public static void main (String [] args){
        JFrame marco = new JFrame();

        marco.setSize(500, 400);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setLayout(new GridLayout(7,1));

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

        JPanel panel6 = new JPanel();
        panel6.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panel7 = new JPanel();
        panel7.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton file = new JButton("Selecciona un fichero");
        fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        fc.setFileFilter(filter);
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setCurrentDirectory(new File("C:\\Users\\usuario\\Desktop"));
        fc.setPreferredSize(new Dimension(600, 300));

        JButton crear = new JButton("Crear fichero");


        //==========================================================================


        /*---------------- CONTADOR PALABRAS Y VOCALES ----------------*/

        JButton contadores = new JButton("Contador de palabras y vocales");
        contadores.addActionListener(e -> {
            contapala.contar(archivo);
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


        /*---------------- COPIA ARCHIVO ----------------*/

        JButton copiar = new JButton("Copiar archivo");
        copiar.addActionListener(e -> {
            copiarchi.copiar(archivo);
        });

        /*---------------- COPIA ARCHIVO ----------------*/


        //==========================================================================


        JButton cifradores = new JButton("Cifrar archivo");
        cifradores.addActionListener(e -> {
            cifrarachi.cifrador(archivo);
        });

        JButton datos = new JButton("Ver los datos del archivo seleccionado");

        panel1.add(file);
        panel2.add(datos);
        panel3.add(contadores);
        panel4.add(editar);
        panel5.add(copiar);
        panel6.add(cifradores);
        panel7.add(crear);

        marco.add(panel1);
        marco.add(panel7);

        /*---------------- SELECCIONAR FICHERO ----------------*/

        file.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){

                    archivo = String.valueOf(fc.getSelectedFile());
                    file.setText("Seleccionar otro fichero");
                    marco.add(panel2);
                    marco.add(panel3);
                    marco.add(panel4);
                    marco.add(panel5);
                    marco.add(panel6);

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

        /*---------------- SELECCIONAR FICHERO ----------------*/

        //==============================================================

        /*---------------- CREAR FICHERO ----------------*/

        crear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    crearfich.creadorfich();
                    crear.setText("Crear otro fichero");
                    marco.add(panel2);
                    marco.add(panel3);
                    marco.add(panel4);
                    marco.add(panel5);
                    marco.add(panel6);

                    marco.revalidate();
            }
        });

        /*---------------- CREAR FICHERO ----------------*/


        marco.setVisible(true);
        marco.setResizable(false);
    }
}
