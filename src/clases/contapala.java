package clases;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class contapala {

    public static void contar(String archivo, JFileChooser fc) {
        JFrame marco = new JFrame();

        int contador_a = 0, contador_e = 0, contador_i = 0, contador_o = 0, contador_u = 0;

        char  cont_a ='a';

        marco.setSize(500, 400);
        marco.setLayout(new GridLayout(2,1));


        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER));



        JLabel nombre = new JLabel("Número de palabras: ");
        JTextField texto1 = new JTextField();
        texto1.setPreferredSize( new Dimension( 50, 24 ) );
        texto1.setEditable(false);
        panel1.add(nombre);
        panel1.add(texto1);

        JLabel letra_a = new JLabel("Número de vocales a: ");
        JTextField contar_a = new JTextField();
        contar_a.setPreferredSize( new Dimension( 50, 24 ) );
        contar_a.setEditable(false);
        panel2.add(letra_a);
        panel2.add(contar_a);

                try {
                    File f = new File(String.valueOf(fc.getSelectedFile()));
                    String linea;
                    FileReader fr = new FileReader(f);
                    BufferedReader br = new BufferedReader(fr);
                    int i, j, a = 0;
                    while ((linea = br.readLine()) != null) {
                        for (i = 0; i < linea.length(); i++) {
                            if (i == 0) {
                                if (linea.charAt(i) != ' ')
                                    a++;
                            } else {
                                if (linea.charAt(i - 1) == ' ')
                                    if (linea.charAt(i) != ' ')
                                        a++;

                               /* for ( i = 0; i < linea.length(); i++) {
                                        contador_a++;
                                    }*/
                            }
                        }
                    }
                    texto1.setText(" " + a +" ");
                } catch (FileNotFoundException ea) {
                    ea.printStackTrace();
                } catch (IOException ew) {
                    ew.printStackTrace();
                }

        marco.add(panel1);
        marco.add(panel2);

        marco.setVisible(true);

    }
}
