package clases;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.text.SimpleDateFormat;

public class datosarchivo {
    public void datos() {
        JFrame marco = new JFrame();

        marco.setSize(500, 400);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        panel3.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panel6 = new JPanel();
        panel4.setLayout(new FlowLayout(FlowLayout.CENTER));


        JButton file = new JButton("Selecciona un fichero o directorio");
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fc.setCurrentDirectory(new File("C:\\Users\\dam2"));
        fc.setPreferredSize(new Dimension(600, 300));
        panel1.add(file);

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


        file.addActionListener(e -> {
            if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){

                File f = new File(String.valueOf(fc.getSelectedFile()));
                texto1.setText(f.getName().replaceFirst("[.][^.]+$", ""));
                texto2.setText(fc.getTypeDescription(f));
                texto3.setText(f.getAbsolutePath());
                texto4.setText((double) f.length() /1000+" KB");
                texto5.setText(new SimpleDateFormat("dd/MM/yyyy  hh:mm:ss").format(f.lastModified()));

            }else{
                JOptionPane.showMessageDialog(marco,"Ha ocurrido un error al abrir el archivo.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
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
