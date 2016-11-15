package example2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * This class improves on the "B" version by using mutable, DefaultListModel models.
 * Although it's possible to refresh a JList by reinstnatiating it with
 * new values, a JList, once instantiated cannot be changed. This makes management
 * of the changes to each list difficult because each JList has to be reinstaniated
 * each time a change is made ... and those changes must be tracked. However, here
 * we use mutable models, making changes easy and eliminating the overhead of
 * reinstantiation. Also, fewer panels are needed, making our program smaller.
 * Also, this class responds to double clicks on items, eliminating
 * the need to click on a button -- a nice useability touch! Finally this class
 * removes items from one list and places them in the other, making for a more
 * intuitive selection process.
 * 
 * CLARIFICATION REGARDING BORDER_LAYOUT: If you enlarge the window, the center area 
 * gets as much of the available space as possible. The other areas expand only as much 
 * as necessary to fill all available space. Often, a container uses only one or two of 
 * the areas of the BorderLayout � just the center, or center and bottom, for example.
 * 
 * @author Jlombardo
 * @version 1.00
 */
public class TwoListsC extends JFrame implements ActionListener,
ListSelectionListener, MouseListener {
	private JScrollPane scrollCourses, scrollChoices;
	private Container c;
	private JList courseList, choiceList;
	private JButton selectBtn, removeBtn;
	private JPanel btnPanel, coursePanel, choicePanel;
	// These are needed if you want mutable lists
	private DefaultListModel courseModel, choiceModel;
	private String selection;
	
	/**
	 * Default constructor initializes GUI.
	 */
	public TwoListsC() {
		super("Select a Class");
		c = this.getContentPane();
		
		// ===== Create course List. The initial values could come from
		// anywhere, a database, a file, whatever, but here we'll
		// just hard code them in.
		courseModel = new DefaultListModel();
		courseModel.addElement("Advanced Java");
		courseModel.addElement("Distributed Java");
		courseModel.addElement("Enterprise Java");
		courseModel.addElement("Web App Dev Using ASP.NET");
		
		courseList = new JList(courseModel);
		courseList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		// Controls and fixes the list width
		courseList.setPrototypeCellValue("123456789ABCDEFGHIJKLMNOPQ");
		courseList.setToolTipText("Double-click an item or single click the button to Select");
		courseList.addMouseListener(this); // support double clicks
                courseList.addListSelectionListener(this);
		scrollCourses = new JScrollPane(courseList);
		coursePanel = new JPanel();
		coursePanel.setBorder(BorderFactory.createTitledBorder("Courses"));
		coursePanel.add(scrollCourses);
		c.add(coursePanel, BorderLayout.WEST);
		//gridPanel.add(coursePanel);
		
		// ====== Create buttons
		selectBtn = new JButton("Select >>");
		selectBtn.setToolTipText("Single click the button or double the item to Select");
		selectBtn.addActionListener(this);
                selectBtn.setEnabled(false);
		removeBtn = new JButton("<< Remove");
		removeBtn.setToolTipText("Single click the button or double the item to Remove");
		removeBtn.setEnabled(false);
		removeBtn.addActionListener(this);
		btnPanel = new JPanel(new FlowLayout());
		// Create some air at the top, to position buttons nicely
		btnPanel.setBorder(BorderFactory.createEmptyBorder(60,0,0,0));
		btnPanel.add(selectBtn);
		btnPanel.add(removeBtn);
		c.add(btnPanel, BorderLayout.CENTER);

		// ====== Create choice List
		choiceModel = new DefaultListModel();
		choiceList = new JList(choiceModel);
		choiceList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                choiceList.addListSelectionListener(this);
		// Controls and fixes the list width
		choiceList.setPrototypeCellValue("123456789ABCDEFGHIJKLMNOPQ");
		choiceList.setToolTipText("Double-click an item or single click the button to Remove");
		choiceList.addMouseListener(this); // support double clicks
		scrollChoices = new JScrollPane(choiceList);
		choicePanel = new JPanel();
		choicePanel.setBorder(BorderFactory.createTitledBorder("Choices"));
		choicePanel.add(scrollChoices);
		c.add(choicePanel, BorderLayout.EAST);
		
		// ===== Set window defaults
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,300);
		this.setVisible(true);
	}
	
	/**
	 * Provided by contract with ActionListener interface. 
	 * This event handler is for Button clicks only. Code is
	 * modularized as private methods for efficiency. On button
	 * click an item is removed from one JList and added to the other.
	 * 
	 * @param ae - an ActionEvent object carrying event info.
	 * Only button click events are handled.
	 */
	public void actionPerformed(ActionEvent ae) {
		if( ae.getSource() == selectBtn) {
			addSelectionToChoiceList();
		} else if( ae.getSource() == removeBtn) {
			removeSelectionFromChoiceList();
		}
	}

	/** 
	 * Provided by contract with MouseListener interface.
	 * This event handler is used to detect mouse double-clicks only.
	 * On double click, an item is removed from one JList and added
	 * to the other.
	 * 
	 * @param mce - a MouseEvent object carrying event info.
	 * Only mouse click events with a click count of 2 are handled.
	 */
	public void mouseClicked(MouseEvent mce) {
            if( mce.getClickCount() == 2) {
                    if( mce.getSource() == courseList ) {
                            addSelectionToChoiceList();
                    } else if( mce.getClickCount() == 2 && mce.getSource() == choiceList ) {
                            removeSelectionFromChoiceList();
                    } // end inner if

            } // end outer if
	} // end mouseClicked

	///////// PRIVATE UTILITY MODULARIZES CODE USE IN SEVERAL PLACES ////////
	// Remove an item from the Course List, add it to the Choice List
	// and enable disable buttons as necessary
	private void addSelectionToChoiceList() {
		selection = (String)courseList.getSelectedValue();
		choiceModel.addElement(selection);
		courseModel.remove(courseList.getSelectedIndex());
                selectBtn.setEnabled(false);

	}
	
	///////// PRIVATE UTILITY MODULARIZES CODE USE IN SEVERAL PLACES ////////
	// Remove an item from the Choice List, add it to the Course List
	// and enable disable buttons as necessary
	private void removeSelectionFromChoiceList() {
		courseModel.addElement( choiceList.getSelectedValue() );
		choiceModel.remove( choiceList.getSelectedIndex());
		removeBtn.setEnabled(false);
		
	}

	/**
	 * Start up the application and the GUI.
	 * @param args - not used.
	 */
	public static void main(String[] args) {
        try {
        	///// Sytem L&F using Swing API /////////////////
        	UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
         } catch (Exception e) {
            // Likely L&F class is not in the class path; ignore.
        	// Default L&F will be loaded in that case.
        }
		new TwoListsC();
	}
	
	
	///////////////////////////////////////////////////////////////////////////
	//////////// NOT USED -- BUT REQUIRED BY MouseListener Interface //////////
	///////////////////////////////////////////////////////////////////////////
	
	/** 
	 * NOT USED -- BUT REQUIRED BY MouseListener Interface
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	/** 
	 * NOT USED -- BUT REQUIRED BY MouseListener Interface
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	/** 
	 * NOT USED -- BUT REQUIRED BY MouseListener Interface
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	/** 
	 * NOT USED -- BUT REQUIRED BY MouseListener Interface
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

    public void valueChanged(ListSelectionEvent e) {
            if( e.getSource() == courseList ) {
                selectBtn.setEnabled(true);
                removeBtn.setEnabled(false);
            } else if(e.getSource() == choiceList) {
                selectBtn.setEnabled(false);
                removeBtn.setEnabled(true);
            }
    }

} // end class
