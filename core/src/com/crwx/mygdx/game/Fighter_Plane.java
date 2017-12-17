package com.crwx.mygdx.game;

import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import javax.swing.*;
import java.util.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Fighter_Plane extends JApplet
{

  private Image imgFighter;

 public void init(){
   imgFighter = getImage(getDocumentBase(), "Fighter.gif");
   Fighter_Panel fp = new Fighter_Panel(imgFighter);  //create a panel
   getContentPane().add(fp);  //add panel to applet


 }

 public static void main(String s[]) {
      JFrame f = new JFrame("Fighter Plane");
      f.addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e) {System.exit(0);}
      });
      JApplet applet = new Fighter_Plane();
      f.getContentPane().add(applet, BorderLayout.CENTER);
      applet.init();
      f.pack();
      f.setSize(new Dimension(250,250));
      f.setVisible(true);
    }




}

class Fighter_Panel extends JPanel implements MouseListener,
MouseMotionListener{


  private int mouseX=0,mouseY=0;
  private Image imgFighter;


  public Fighter_Panel(Image imgFighter)
  {
    this.imgFighter=imgFighter;
    addMouseMotionListener(this);
    addMouseListener(this);

  }

    public void mouseClicked( MouseEvent e ){}
    public void mousePressed( MouseEvent e ){    }
    public void mouseReleased( MouseEvent e ){}
    public void mouseEntered( MouseEvent e ){}
    public void mouseExited( MouseEvent e ){}
    public void mouseDragged( MouseEvent e ){}

    public void mouseMoved( MouseEvent e ){
      repaint();
      mouseX=e.getX();
      mouseY=e.getY();
      repaint();
    }


    public void paintComponent (Graphics g)
     {
      super.paintComponent(g);
      g.drawImage(imgFighter, mouseX,mouseY,
imgFighter.getWidth(this),imgFighter.getHeight(this),this);
     }



}