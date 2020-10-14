package clases;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.*;

public class copiarchi {
    public static void copiar(String s) {

        String archivo = s;

        JFrame  marco = new JFrame("COPIAR FICHERO");

        marco.setSize(500, 400);
        marco.setLayout(new GridLayout(6,1));

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

        JLabel nombre = new JLabel("Nombre del fichero: ");
        JTextField texto1 = new JTextField();
        texto1.setPreferredSize( new Dimension( 300, 24 ) );
        texto1.setEditable(false);
        panel1.add(nombre);
        panel1.add(texto1);

        JLabel ruta = new JLabel("Ruta de origen: ");
        JTextField texto2 = new JTextField();
        texto2.setPreferredSize( new Dimension( 300, 24 ) );
        texto2.setEditable(false);
        panel2.add(ruta);
        panel2.add(texto2);

        JButton file = new JButton("Seleccionar directorio de destino");
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setCurrentDirectory(new File("C:\\Users\\usuario"));
        fc.setPreferredSize(new Dimension(600, 300));
        panel3.add(file);

        File f = new File(archivo);
        texto1.setText(f.getName());
        texto2.setText(f.getAbsolutePath());

        JTextField texto3 = new JTextField();
        texto3.setPreferredSize( new Dimension( 300, 24 ) );
        texto3.setEditable(false);
        panel4.add(new JLabel("Ruta de destino: "));
        panel4.add(texto3);

        JTextField texto4 = new JTextField();
        texto4.setPreferredSize( new Dimension( 200, 24 ));
        panel5.add(new JLabel("Nuevo nombre del fichero: "));
        panel5.add(texto4);
        JButton añadir = new JButton("Copiar fichero");
        panel6.add(añadir);

        file.addActionListener(e -> {
            if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){

                texto3.setText(fc.getSelectedFile().getAbsolutePath());


            }else{
                JOptionPane.showMessageDialog(marco,"Ha ocurrido un error al seleccionar el directorio.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        añadir.addActionListener(e -> {
            try {
                String texto = texto4.getText();

                if((texto.length() == 0) || (texto == " ")){
                    FileReader lector = new FileReader(f.getAbsolutePath());
                    BufferedReader entrada = new BufferedReader(lector);
                    FileWriter escritor = new FileWriter(fc.getSelectedFile().getAbsolutePath() + "\\" + texto1.getText());
                    BufferedWriter salida = new BufferedWriter(escritor);

                    String cadena = entrada.readLine();

                    while (cadena != null) {
                        salida.write(cadena);
                        salida.newLine();
                        cadena = entrada.readLine();
                    }

                    entrada.close();
                    salida.close();

                    JOptionPane.showMessageDialog(marco, "Se ha copiado el fichero con éxito.",
                            "Info",
                            JOptionPane.INFORMATION_MESSAGE);

                    salida.close();

                }else {
                    FileReader lector = new FileReader(f.getAbsolutePath());
                    BufferedReader entrada = new BufferedReader(lector);
                    FileWriter escritor = new FileWriter(fc.getSelectedFile().getAbsolutePath() + "\\" + texto4.getText() + ".txt");
                    BufferedWriter salida = new BufferedWriter(escritor);

                    String cadena = entrada.readLine();

                    while (cadena != null) {
                        salida.write(cadena);
                        salida.newLine();
                        cadena = entrada.readLine();
                    }

                    entrada.close();
                    salida.close();

                    JOptionPane.showMessageDialog(marco, "Se ha copiado el fichero con éxito.",
                            "Info",
                            JOptionPane.INFORMATION_MESSAGE);

                    salida.close();
                }
            } catch (IOException ioe) {
                System.err.println("¡Hubo un error de E/S!");
            }
        });




        marco.add(panel1);
        marco.add(panel2);
        marco.add(panel3);
        marco.add(panel4);
        marco.add(panel5);
        marco.add(panel6);

        marco.setVisible(true);
        marco.setResizable(false);
    }
}
