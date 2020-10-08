package clases;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class editorarchivo {
    public static void editar(String s) {

        File f = new File(s);

        JFrame marco = new JFrame();

        marco.setSize(800, 700);
        marco.setLayout(new GridLayout(2,1));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER));

        JTextArea texto = new JTextArea(100, 50);
        panel1.add(texto);

        JButton get = new JButton("Obtener texto");
        panel2.add(get);
        JButton set = new JButton("Modificar texto");
        panel2.add(set);

        get.addActionListener(e -> {
            try{
                texto.setText(null);
                FileReader lector = new FileReader(f.getAbsolutePath());
                BufferedReader entrada = new BufferedReader(lector);

                String cadena = entrada.readLine();

                while (cadena != null) {
                    texto.append(cadena+"\n");
                    cadena = entrada.readLine();
                }

                entrada.close();

            }catch (Exception ee){
                JOptionPane.showMessageDialog(marco,"Ha ocurrido un error al abrir el archivo.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        set.addActionListener(e -> {
            try{
                FileWriter escritor = new FileWriter(f.getAbsolutePath());
                BufferedWriter salida = new BufferedWriter(escritor);

                salida.write(texto.getText());
                texto.setText(null);
                JOptionPane.showMessageDialog(marco,"Se ha modificado el texto con éxito.",
                        "Info",
                        JOptionPane.INFORMATION_MESSAGE);

                salida.close();

            }catch (Exception ee){
                JOptionPane.showMessageDialog(marco,"Ha ocurrido un error al abrir el archivo.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        marco.add(panel1);
        marco.add(panel2);

        marco.setVisible(true);
        marco.setResizable(false);
    }
}
