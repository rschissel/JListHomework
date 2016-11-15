package example1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * MVC architecture using JList with a DefaultListModel and standard
 * ActionListener implementation.
 *
 * JList is ONLY editable if you create and use a custom ListModel which this
 * example DOES NOT provide.
 * 
 * @author jlombardo
 */
public class PhilosophersJList extends JFrame implements ActionListener {
   
   private DefaultListModel philosophers, philosophers2;
   private JList list;
   private JButton addButton, removeButton;

   // PhilosophersJList constructor
   public PhilosophersJList() 
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
      addButton = new JButton( "Add Philosopher" );
      addButton.addActionListener(this);
      
      // create JButton for removing selected philosopher
      removeButton = new JButton( "Remove Selected Philosopher" );
      removeButton.addActionListener(this);
      
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

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addButton) {
           // prompt user for new philosopher's name
           String name = JOptionPane.showInputDialog(
              PhilosophersJList.this, "Enter Name" );

           // add new philosopher to model
           philosophers.addElement( name );

        } else if(e.getSource() == removeButton) {
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


   // execute application
   public static void main( String args[] )
   {
      new PhilosophersJList();
   }

}
