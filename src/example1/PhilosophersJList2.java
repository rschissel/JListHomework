package example1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * MVC architecture using JList with a DefaultListModel and non-standard
 * ActionListener implementation using anonymous inner classes.
 *
 * JList is ONLY editable if you create and use a custom ListModel which this
 * example DOES NOT provide.
 *
 * @author jlombardo
 */
public class PhilosophersJList2 extends JFrame {
   
   private DefaultListModel philosophers, philosophers2;
   private JList list;

   // PhilosophersJList constructor
   public PhilosophersJList2() 
   {
      super( "Favorite Philosophers" ); // sets window title

      // create a DefaultListModel to store and edit philosophers
      philosophers = new DefaultListModel();
      philosophers.addElement( "Socrates" );
      philosophers.addElement( "Plato" );
      philosophers.addElement( "Aristotle" );
      philosophers.addElement( "St. Thomas Aquinas" );
      philosophers.addElement( "Soren Kierkegaard" );
      philosophers.addElement( "Immanuel Kant" );
      philosophers.addElement( "Friedrich Nietzsche" ); 
      philosophers.addElement( "Hannah Arendt" );

      // create a JList for philosophers DefaultListModel
      list = new JList( philosophers );  
      
      // allow user to select only one philosopher at a time
      list.setSelectionMode( 
         ListSelectionModel.SINGLE_SELECTION );
      
      // create JButton for adding philosophers
      JButton addButton = new JButton( "Add Philosopher" );
      addButton.addActionListener(
         // Anonymous inner class
         new ActionListener() {
            
            public void actionPerformed( ActionEvent event ) 
            {
               // prompt user for new philosopher's name
               String name = JOptionPane.showInputDialog(
                  PhilosophersJList2.this, "Enter Name" );
               
               // add new philosopher to model
               philosophers.addElement( name );
            }
         }
      );
      
      // create JButton for removing selected philosopher
      JButton removeButton = 
         new JButton( "Remove Selected Philosopher" );
      
      removeButton.addActionListener(
    	 // Anonymous inner class
         new ActionListener() {
            
            public void actionPerformed( ActionEvent event ) 
            {
               // remove selected philosopher from model
               philosophers.removeElement( 
                  list.getSelectedValue() );
               
               if( list.getModel().getSize() == 0 ) {
            	   // switch to a new List model
            	      philosophers2 = new DefaultListModel();
            	      philosophers2.addElement( "John" );
            	      philosophers2.addElement( "Paul" );
            	      philosophers2.addElement( "George" );
            	      philosophers2.addElement( "Ringo" );
            	      
            	      list.setModel(philosophers2);
            	      philosophers = philosophers2;
            	      repaint();
               }
            }
         }
      );
      
      // lay out GUI components
      JPanel inputPanel = new JPanel();
      inputPanel.add( addButton );
      inputPanel.add( removeButton );
      
      Container container = getContentPane();       
      container.add( list, BorderLayout.CENTER );      
      container.add( inputPanel, BorderLayout.NORTH );
      
      setDefaultCloseOperation( EXIT_ON_CLOSE );      
      setSize( 400, 300 );
      setVisible( true );
      
   } // end PhilosophersJList constructor

   // execute application
   public static void main( String args[] ) 
   {
      new PhilosophersJList2();
   }
}
