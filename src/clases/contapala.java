package clases;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class contapala {

    public static void contar(String fc) {

        JFrame  marco = new JFrame("CONTAR PALABRAS Y VOCALES DEL FICHERO");

        int contador_a = 0, contador_e = 0, contador_i = 0, contador_o = 0, contador_u = 0;

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

        JLabel letra_e = new JLabel("Número de vocales e: ");
        JTextField contar_e = new JTextField();
        contar_e.setPreferredSize( new Dimension( 50, 24 ) );
        contar_e.setEditable(false);
        panel3.add(letra_e);
        panel3.add(contar_e);

        JLabel letra_i = new JLabel("Número de vocales i: ");
        JTextField contar_i = new JTextField();
        contar_i.setPreferredSize( new Dimension( 50, 24 ) );
        contar_i.setEditable(false);
        panel4.add(letra_i);
        panel4.add(contar_i);

        JLabel letra_o = new JLabel("Número de vocales o: ");
        JTextField contar_o = new JTextField();
        contar_o.setPreferredSize( new Dimension( 50, 24 ) );
        contar_o.setEditable(false);
        panel5.add(letra_o);
        panel5.add(contar_o);

        JLabel letra_u = new JLabel("Número de vocales u: ");
        JTextField contar_u = new JTextField();
        contar_u.setPreferredSize( new Dimension( 50, 24 ) );
        contar_u.setEditable(false);
        panel6.add(letra_u);
        panel6.add(contar_u);

                try {
                    File f = new File(String.valueOf(fc));
                    String linea;
                    FileReader fr = new FileReader(f);
                    BufferedReader br = new BufferedReader(fr);
                    int i, a = 0;
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
                    texto1.setText(" " + a +" ");
                } catch (FileNotFoundException ea) {
                    ea.printStackTrace();
                } catch (IOException ew) {
                    ew.printStackTrace();
                }

                try {
                    File f1 = new File(String.valueOf(fc));
                    FileReader fr1 = new FileReader(f1);
                    BufferedReader br1 = new BufferedReader(fr1);
                    String lineaa;
                    while ((lineaa = br1.readLine()) != null) {
                        for (int x = 0; x < lineaa.length(); x++) {

                            if ((lineaa.charAt(x) == 'a') || (lineaa.charAt(x) == 'A')) {
                                contador_a++;

                            }

                            if ((lineaa.charAt(x) == 'e') || (lineaa.charAt(x) == 'E')) {
                                contador_e++;
                            }

                            if ((lineaa.charAt(x) == 'i') || (lineaa.charAt(x) == 'I')) {
                                contador_i++;
                            }

                            if ((lineaa.charAt(x) == 'o') || (lineaa.charAt(x) == 'O')){
                                contador_o++;
                            }

                            if ((lineaa.charAt(x) == 'u') || (lineaa.charAt(x) == 'U')){
                                contador_u++;
                            }
                        }
                    }
                    } catch(FileNotFoundException ae){
                        ae.printStackTrace();
                    } catch(IOException we) {
                    we.printStackTrace();
                }

        contar_a.setText(String.valueOf(contador_a));
        contar_e.setText(String.valueOf(contador_e));
        contar_i.setText(String.valueOf(contador_i));
        contar_o.setText(String.valueOf(contador_o));
        contar_u.setText(String.valueOf(contador_u));

        marco.add(panel1);
        marco.add(panel2);
        marco.add(panel3);
        marco.add(panel4);
        marco.add(panel5);
        marco.add(panel6);
        marco.setVisible(true);

    }
}
