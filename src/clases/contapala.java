package clases;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class contapala {

    public static void contarvocal() {

        int contador_a = 0, contador_e = 0, contador_i = 0, contador_o = 0, contador_u = 0;

        char  letra_a ='a';

        /*for(int i=0;i<charsLine.length;i++) {
                if (charsLine[i] == vowels[j]) {//comparacion
                    contador_a++;
                }

        }*/
    }


    public static void contarpalabras() {
        JFrame marco = new JFrame();

        marco.setSize(500, 400);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setLayout(new GridLayout(4,1));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.CENTER));



        JLabel nombre = new JLabel("Número de palabras: ");
        JTextField texto1 = new JTextField();
        texto1.setPreferredSize( new Dimension( 50, 24 ) );
        texto1.setEditable(false);
        panel2.add(nombre);
        panel2.add(texto1);

        JLabel letra_a = new JLabel("Número de vocales a: ");
        JTextField contar_a = new JTextField();
        contar_a.setPreferredSize( new Dimension( 50, 24 ) );
        contar_a.setEditable(false);
        panel3.add(letra_a);
        panel3.add(contar_a);
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fc.setCurrentDirectory(new File("C:\\Users\\dam2"));
        fc.setPreferredSize(new Dimension(600, 300));
        panel1.add(fc);

        fc.addActionListener(e -> {
            if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

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

                            }
                        }
                    }
                    texto1.setText("son "+a+" palabras");
                } catch (FileNotFoundException ea) {
                    ea.printStackTrace();
                } catch (IOException ew) {
                    ew.printStackTrace();
                }
            }
        });
        marco.add(panel1);
        marco.add(panel2);
        marco.add(panel3);

        marco.setVisible(true);

    }
}
