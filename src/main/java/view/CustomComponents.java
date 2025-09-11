package main.java.view;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CustomComponents {
    public static class GradientButton extends JButton {
        private Color cor1;
        private Color cor2;
        private int cantos;
        
        public GradientButton(Color cor1, Color cor2) {
            this(cor1, cor2, 20);
        }
        
        public GradientButton(Color cor1, Color cor2, int cantos) {
            this.cor1 = cor1;
            this.cor2 = cor2;
            this.cantos = cantos;
            setContentAreaFilled(false);
            setOpaque(false);
            setForeground(Color.WHITE);
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
             RoundRectangle2D rr2d = new RoundRectangle2D.Float(
                0, 0, getWidth(), getHeight(), cantos, cantos
            );
            
            GradientPaint gp = new GradientPaint(0, 0, cor1, getWidth(), 0, cor2);
            g2d.setPaint(gp);
            g2d.fill(rr2d);
            
            super.paintComponent(g2d);
            g2d.dispose();
        }
        
        @Override
        protected void paintBorder(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            g2d.setColor(getForeground());
            g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cantos, cantos);
            g2d.dispose();
        }
    }
    
    public static class GradientPanel extends JPanel {
        private Image eduConnect;
        private Color cor1;
        private Color cor2;
        
        public GradientPanel(Color cor1, Color cor2) {
            this.cor1 = cor1;
            this.cor2 = cor2;
            try {
                this.eduConnect = new ImageIcon(getClass().getResource("/main/java/logos/EduConnect_Branco.png")).getImage();
            } catch (Exception e) {
                System.err.println("Erro ao carregar imagem: " + e.getMessage());
            }
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            
            GradientPaint gp = new GradientPaint(0, 0, cor1, getWidth(), 0, cor2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, getWidth(), getHeight());
            
            if (eduConnect != null) {
                int logoWidth = 375;
                int logoHeight = 50;
                
                int x = (getWidth() - logoWidth) / 2;
                int y = 18;
                g2d.drawImage(eduConnect, x, y, logoWidth, logoHeight, this);
            }
        }
    }
}