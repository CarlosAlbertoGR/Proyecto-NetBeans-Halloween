/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.halloween.poo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class HalloweenPOOGUI extends JFrame {

    private final JTextArea logArea;
    private final JPanel monsterPanel;
    private final List<SerMagico> personajes;
    private final Random random = new Random();

    public HalloweenPOOGUI() {
        super("Dinámica POO - Halloween con Java Swing");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLayout(new BorderLayout(10, 10)); 
        
        this.personajes = crearPersonajes();

        JPanel topPanel = new JPanel(new BorderLayout(10, 10));
        JLabel titleLabel = new JLabel("Clases y Polimorfismo de Terror 🦇", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 30));
        titleLabel.setForeground(new Color(255, 107, 0)); 
        topPanel.add(titleLabel, BorderLayout.NORTH);

        JButton runButton = new JButton("Lanzar Ronda de Interacción (Polimorfismo)");
        runButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        runButton.setBackground(new Color(150, 0, 0)); 
        runButton.setForeground(Color.WHITE);
        runButton.setFocusPainted(false);
        runButton.addActionListener(this::ejecutarRonda);
        topPanel.add(runButton, BorderLayout.CENTER);
        
        monsterPanel = new JPanel();
        monsterPanel.setLayout(new GridLayout(2, 3, 15, 15)); 
        monsterPanel.setBorder(BorderFactory.createTitledBorder("Monstruos en la escena"));
        cargarMonstruosEnPanel();
        
        try {
             ImageIcon bgIcon = new ImageIcon(getClass().getResource("/images/fondo.jpg"));
             if (bgIcon.getImageLoadStatus() == MediaTracker.COMPLETE) {
                 setContentPane(new JLabel(bgIcon)); 
                 setLayout(new BorderLayout(10, 10)); 
                 add(new JLayeredPane(), BorderLayout.CENTER);
             }
        } catch (Exception e) {
             System.out.println("No se pudo cargar fondo.jpg. Usando color de fondo predeterminado.");
             getContentPane().setBackground(new Color(26, 26, 26)); 
        }
        
        add(topPanel, BorderLayout.NORTH);
        add(monsterPanel, BorderLayout.CENTER);

        logArea = new JTextArea("¡Bienvenido! Presiona el botón para empezar la dinámica de POO.\n\n");
        logArea.setEditable(false);
        logArea.setBackground(new Color(44, 44, 44)); 
        logArea.setForeground(Color.WHITE);
        logArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(logArea);
        scrollPane.setPreferredSize(new Dimension(850, 200));
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(74, 0, 74), 2)); 
        
        JPanel bottomPanel = new JPanel(new BorderLayout());
        JButton clearButton = new JButton("Limpiar Bitácora");
        clearButton.addActionListener(e -> logArea.setText("Bitácora limpia.\n"));
        bottomPanel.add(new JLabel("Bitácora de Eventos (Canvas de Texto):", SwingConstants.LEFT), BorderLayout.NORTH);
        bottomPanel.add(scrollPane, BorderLayout.CENTER);
        bottomPanel.add(clearButton, BorderLayout.SOUTH);
        
        add(bottomPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null); 
        setVisible(true);
    }
    
    private List<SerMagico> crearPersonajes() {
        List<SerMagico> list = new ArrayList<>();
        list.add(new Vampiro("Drácula"));
        list.add(new HombreLobo("Lupín"));
        list.add(new Fantasma("Casper"));
        list.add(new Hada("Titania"));
        list.add(new Driade("Willow"));
        list.add(new Bruja("Morgana"));
        return list;
    }
    

    private void cargarMonstruosEnPanel() {
        for (SerMagico p : personajes) {
            JPanel card = crearTarjetaMonstruo(p);
            monsterPanel.add(card);
        }
    }

    private JPanel crearTarjetaMonstruo(SerMagico p) {
        JPanel card = new JPanel(new BorderLayout(5, 5));
        card.setBorder(BorderFactory.createRaisedBevelBorder());
        card.setBackground(new Color(50, 50, 50));
        
        JLabel nameLabel = new JLabel(p.getEmoji() + " " + p.getNombre(), SwingConstants.CENTER);
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        nameLabel.setForeground(new Color(255, 200, 0)); 

        JLabel typeLabel = new JLabel("(" + (p instanceof MonstruoClasico ? "Clásico" : "Mágico") + ")", SwingConstants.CENTER);
        typeLabel.setFont(new Font("SansSerif", Font.ITALIC, 10));
        typeLabel.setForeground(new Color(180, 180, 180));
        
        JLabel imageLabel = new JLabel();
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/images/" + p.getRutaImagen()));
            if (icon.getImageLoadStatus() == MediaTracker.COMPLETE) {
                Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(img));
            } else {
                imageLabel.setText(p.getEmoji() + " (Error: Imagen)"); 
                imageLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
            }
        } catch (Exception e) {
            imageLabel.setText(p.getEmoji() + " (Sin Imagen)"); 
            imageLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
        }
        
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        card.add(nameLabel, BorderLayout.NORTH);
        card.add(imageLabel, BorderLayout.CENTER);
        card.add(typeLabel, BorderLayout.SOUTH);
        
        return card;
    }


    private void ejecutarRonda(ActionEvent event) {
        logArea.append("--- RONDA DE INTERACCIÓN MÁGICA ---\n");

        for (int i = 0; i < personajes.size(); i++) {
            SerMagico actor = personajes.get(i);
            
            int targetIndex;
            do {
                targetIndex = random.nextInt(personajes.size());
            } while (targetIndex == i);

            SerMagico objetivo = personajes.get(targetIndex);

            String resultado = actor.ejecutarAccion(objetivo);

            logArea.append("[" + actor.getEmoji() + "] " + actor.getNombre() + " interactúa con " + objetivo.getNombre() + ":\n");
            logArea.append("   -> " + resultado + "\n");
        }
        
        logArea.append("\n");
        logArea.setCaretPosition(logArea.getDocument().getLength()); 
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HalloweenPOOGUI());
    }
}