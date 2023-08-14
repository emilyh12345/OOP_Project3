package Project3.java;

import javax.swing.*;
public class SampleGUI extends JFrame {
      
   public SampleGUI(String title, int height, int width) { //creates a sample gui that will be used to display options open and quit
	   setTitle("Sample GUI");
	   setSize(height,width);
	   setLocation  (400,200);
	   createFileMenu();
	   setDefaultCloseOperation(EXIT_ON_CLOSE);
       setVisible(true);
   } //SSNGUI

   private void createFileMenu( ) { //creates a file menu for the sample gui
	   JMenuItem   item;
       JMenuBar    menuBar  = new JMenuBar();
       JMenu       fileMenu = new JMenu("File");
       FileMenuHandler fmh  = new FileMenuHandler(this); //instanciates a file menu handler used to handle the file menu  

       item = new JMenuItem("Open"); //creates menu item open
       item.addActionListener( fmh );
       fileMenu.add( item );

       fileMenu.addSeparator(); //add a horizontal separator line between open and quit
    
       item = new JMenuItem("Quit"); //creates menu item quit
       item.addActionListener( fmh );
       fileMenu.add( item );

       setJMenuBar(menuBar);
       menuBar.add(fileMenu); //add the file menu to to the menu bar created
   } //createMenu
   
} //SSNGUI