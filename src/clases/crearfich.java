package clases;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class crearfich {

    public static JFileChooser fc1;

    public static void creadorfich(){

        JFrame marco = new JFrame("CREAR FICHERO");

        marco.setSize(700, 500);
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

        JPanel panel6 = new JPanel();
        panel6.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panel7 = new JPanel();
        panel6.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel nombre = new JLabel("Nombre del archivo: ");
        JTextField texto1 = new JTextField();
        texto1.setPreferredSize( new Dimension( 300, 24 ) );
        panel1.add(nombre);
        panel1.add(texto1);

        JTextField texto2 = new JTextField();
        texto2.setPreferredSize( new Dimension( 300, 24 ) );
        texto2.setEditable(false);
        panel3.add(new JLabel("Ruta de destino: "));
        panel3.add(texto2);

        fc1 = new JFileChooser();
        JButton directorio = new JButton("Selecciona directorio");
        fc1.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc1.setCurrentDirectory(new File("C:\\Users\\usuario\\Desktop"));
        fc1.setPreferredSize(new Dimension(600, 300));
        directorio.addActionListener(e -> {
            if (fc1.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){

                texto2.setText(fc1.getSelectedFile().getAbsolutePath());

            }else {
                JOptionPane.showMessageDialog(marco, "Ha ocurrido un error al seleccionar el directorio.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        panel2.add(directorio);


        JTextArea texto = new JTextArea(3, 50);
        JScrollPane scroll = new JScrollPane(texto);
        panel4.add(new JLabel("Texto a introducir en el fichero:"));
        panel5.add(scroll);

        panel6.add(panel4);
        panel6.add(panel5);

        JButton crear = new JButton("Crear fichero");
        crear.addActionListener(e -> {
            try {
                entrega1.archivo = fc1.getSelectedFile().getAbsolutePath()+"\\"+texto1.getText()+".txt";
                FileWriter escritor = new FileWriter(entrega1.archivo);
                BufferedWriter salida = new BufferedWriter(escritor);

                salida.write(texto.getText());
                texto.setText(null);

                salida.close();
                JOptionPane.showMessageDialog(marco,"Se ha creado el fichero con éxito.",
                        "Info",
                        JOptionPane.INFORMATION_MESSAGE);


            } catch (Exception h) {
                System.err.println("¡Hubo un error de E/S!");
            }
        });
        panel7.add(crear);

        marco.add(panel1);
        marco.add(panel2);
        marco.add(panel3);
        marco.add(panel6);
        marco.add(panel7);

        marco.setVisible(true);
        marco.setResizable(false);
    }

    }
