/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Engeniuseer
 */
public class TicTacToe extends JFrame{
    public static Grid g;
    public static boolean user_turn=true;
    ImageIcon imagen=new ImageIcon("grid.jpg");
    ImageIcon circle=new ImageIcon("circle.jpg");
    ImageIcon cross=new ImageIcon("cross.jpg");

    public TicTacToe() {
        TicTacToe.g = new Grid();
        this.setSize(3500,3500);
        this.setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(-18,0);
        
        this.getContentPane().setBackground(Color.green);
        setTitle("TicTacToe Game");   
    }
    
    public void render() throws InterruptedException{
        JPanel panel=new JPanel();
        ImageIcon image=imagen;
        panel.setBackground(Color.CYAN);
        this.getContentPane().add(panel);
        
        JLabel label2=new JLabel();
        label2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(720,720, Image.SCALE_SMOOTH)));
        label2.setBounds(600,100,720,720);
        label2.setOpaque(true);
        
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(TicTacToe.g.gameboard[i][j]==1){
                    JLabel cir=new JLabel();
                    cir.setIcon(new ImageIcon(circle.getImage().getScaledInstance(240, 240, Image.SCALE_SMOOTH)));
                    cir.setBounds(i*240,j*240,240,240);
                    cir.setOpaque(true);
                    label2.add(cir);
                }
                else if(TicTacToe.g.gameboard[i][j]==-1){
                    JLabel cro=new JLabel();
                    cro.setIcon(new ImageIcon(cross.getImage().getScaledInstance(240, 240, Image.SCALE_SMOOTH)));
                    cro.setBounds(i*240,j*240,240,240);
                    cro.setOpaque(true);
                    label2.add(cro);
                }
            }
        }
        
        
        panel.add(label2);
        
        MouseListener m=new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if(user_turn=true){
                    int x=(int)(me.getX()/240);
                    int y=(int)(me.getY()/240);
                    if(TicTacToe.g.gameboard[x][y]==0){
                        TicTacToe.g.gameboard[x][y]=1;
                        user_turn=false;
                    }
                }
                
                
            }

            @Override
            public void mousePressed(MouseEvent me) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent me) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        };
        
        panel.addMouseListener(m);
        this.pack();
        this.setVisible(true);
        //In case of memory error uncomment these lines
        //TimeUnit.SECONDS.sleep((long)1.0);
        //panel.removeAll();
    }
}
