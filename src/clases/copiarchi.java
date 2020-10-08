package clases;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.text.SimpleDateFormat;

public class copiarchi {
    public static void copiar(String s) {

        String archivo = s;

        JFrame marco = new JFrame();

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

        JButton file = new JButton("Seleccionar directorio de destino");
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setCurrentDirectory(new File("C:\\Users\\dam2"));
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


        JButton añadir = new JButton("Copiar fichero");


        file.addActionListener(e -> {
            if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){

                File f2 = new File(String.valueOf(fc.getSelectedFile()));
                texto3.setText(f2.getAbsolutePath());


            }else{
                JOptionPane.showMessageDialog(marco,"Ha ocurrido un error al seleccionar el directorio.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });


        marco.add(panel1);
        marco.add(panel2);
        marco.add(panel3);
        marco.add(panel4);
        marco.add(panel5);

        marco.setVisible(true);
        marco.setResizable(false);
    }
}
