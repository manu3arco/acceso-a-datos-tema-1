package clases;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.text.SimpleDateFormat;

public class datosarchivo {
    public static void datos(String s, JFileChooser fc) {

        String cadena = s;
        JFileChooser fileChooser = fc;

        JFrame marco = new JFrame();

        marco.setSize(500, 400);
        marco.setLayout(new GridLayout(5,1));

        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panel5 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panel6 = new JPanel();
        panel4.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel nombre = new JLabel("Nombre: ");
        JTextField texto1 = new JTextField();
        texto1.setPreferredSize( new Dimension( 300, 24 ) );
        texto1.setEditable(false);
        panel2.add(nombre);
        panel2.add(texto1);

        JLabel formato = new JLabel("Formato: ");
        JTextField texto2 = new JTextField();
        texto2.setPreferredSize( new Dimension( 300, 24 ) );
        texto2.setEditable(false);
        panel3.add(formato);
        panel3.add(texto2);

        JLabel ruta = new JLabel("Ruta: ");
        JTextField texto3 = new JTextField();
        texto3.setPreferredSize( new Dimension( 300, 24 ) );
        texto3.setEditable(false);
        panel4.add(ruta);
        panel4.add(texto3);

        JLabel tamaño = new JLabel("Tamaño: ");
        JTextField texto4 = new JTextField();
        texto4.setPreferredSize( new Dimension( 300, 24 ) );
        texto4.setEditable(false);
        panel5.add(tamaño);
        panel5.add(texto4);

        JLabel modificacion = new JLabel("Última modificación: ");
        JTextField texto5 = new JTextField();
        texto5.setPreferredSize( new Dimension( 300, 24 ) );
        texto5.setEditable(false);
        panel6.add(modificacion);
        panel6.add(texto5);

        File f = new File(cadena);
        texto1.setText(f.getName().replaceFirst("[.][^.]+$", ""));
        texto2.setText(fileChooser.getTypeDescription(f));
        texto3.setText(f.getAbsolutePath());
        texto4.setText((double) s.length() /1000+" KB");
        texto5.setText(new SimpleDateFormat("dd/MM/yyyy  hh:mm:ss").format(f.lastModified()));

        marco.add(panel2);
        marco.add(panel3);
        marco.add(panel4);
        marco.add(panel5);
        marco.add(panel6);

        marco.setVisible(true);
        marco.setResizable(false);

    }
}
