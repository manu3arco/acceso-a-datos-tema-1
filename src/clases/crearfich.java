package clases;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class crearfich {
    public static void creadorfich(String s){
        String archivo = s;

        JFrame marco = new JFrame();

        marco.setSize(500, 400);
        marco.setLayout(new GridLayout(4,1));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout(FlowLayout.CENTER));

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

        JFileChooser fc = new JFileChooser();
        JButton directorio = new JButton("Selecciona directorio");
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setCurrentDirectory(new File("C:\\Users\\dam2\\Desktop"));
        fc.setPreferredSize(new Dimension(600, 300));
        directorio.addActionListener(e -> {
            if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){

                texto2.setText(fc.getSelectedFile().getAbsolutePath());


            }else {
                JOptionPane.showMessageDialog(marco, "Ha ocurrido un error al seleccionar el directorio.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        panel2.add(directorio);





        JButton crear = new JButton("Crear fichero");
        crear.addActionListener(e -> {
            try {
                String rutades = fc.getSelectedFile().getAbsolutePath()+"\\"+texto1.getText()+".txt";
                File f = new File(rutades);
                f.createNewFile();
                JOptionPane.showMessageDialog(marco,"Se ha creado el fichero con éxito.",
                        "Info",
                        JOptionPane.INFORMATION_MESSAGE);


            } catch (Exception h) {
                System.err.println("¡Hubo un error de E/S!");
            }
        });
        panel4.add(crear);

        marco.add(panel1);
        marco.add(panel2);
        marco.add(panel3);
        marco.add(panel4);

        marco.setVisible(true);
        marco.setResizable(false);
    }

    }
