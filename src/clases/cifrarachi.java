package clases;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class cifrarachi {
    public static void cifrador(String s){
        String archivos = s;
        JFrame marco = new JFrame();

        marco.setSize(500, 400);
        marco.setLayout(new GridLayout(2,1));

        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel nombre = new JLabel("Nombre del archivo: ");
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
        String archivos2 = archivos;
        try {
            File fiche = new File(archivos2);
            fiche.getAbsolutePath();
            String nomarchiv = archivos.replaceFirst("[.][^.]+$", "");
            FileReader Ficheroentrada = new FileReader(archivos2);
            BufferedReader entrada = new BufferedReader(Ficheroentrada);
            FileWriter Ficherosalida = new FileWriter(nomarchiv + "_CIFRADO.txt");
            BufferedWriter salida = new BufferedWriter(Ficherosalida);
            Scanner escaner = new Scanner(Ficheroentrada);String cadena = entrada.readLine();
            while (cadena != null) {
                System.out.println(cadena);
                salida.write("Adios");
                salida.newLine();
                cadena = entrada.readLine();

            }

            escaner.close();
            salida.close();
            salida.flush();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());


        } catch (IOException e) {
            e.printStackTrace();
        }


        marco.add(panel1);
        marco.add(panel2);


        marco.setVisible(true);
        marco.setResizable(false);
    }
}