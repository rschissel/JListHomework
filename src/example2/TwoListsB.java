package example2;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

/**
 * This class demonstrates an unsuccessful attempt at providing a dual JList
 * selection mechanism using immutable JList data models. By default, a JList
 * is instantiated with an immutable data model unless you specifically give
 * it a mutable one (see version "C"). Although it is possible to refresh an
 * immutable JList with new data by reinstantiating it, this class cannot
 * make this work efficiently because it would need a complex system for 
 * managing items.
 */
public class TwoListsB extends JFrame implements ActionListener, ListSelectionListener {
	private static final String[] COURSES = 
			{"Distributed Java", "Enterprise Java",
			 "Advanced Java", "Web App Dev Using ASP.NET"
			};
	private JScrollPane scrollCourses, scrollChoices;
	private Container c;
	private JList courseList, choiceList;
	private JButton selectBtn, removeBtn;
	private JPanel btnPanel, coursePanel, choicePanel, gridPanel;
	private String[] a;
	
	public TwoListsB() {
		super("Select a Class");
		c = this.getContentPane();
		gridPanel = new JPanel( new GridLayout(1,3) );
		c.add(gridPanel, BorderLayout.CENTER);
		
		// Create course List
		courseList = new JList(COURSES);
		courseList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		courseList.addListSelectionListener(this);
		scrollCourses = new JScrollPane(courseList);
		coursePanel = new JPanel( new BorderLayout() );
		coursePanel.setBorder(BorderFactory.createTitledBorder("Courses"));
		coursePanel.add(scrollCourses, BorderLayout.CENTER);
		gridPanel.add(coursePanel);
		
		// Create buttons
		selectBtn = new JButton("Select >>");
                selectBtn.setEnabled(false);
		selectBtn.addActionListener(this);
		removeBtn = new JButton("<< Remove");
		removeBtn.setEnabled(false);
		removeBtn.addActionListener(this);
		btnPanel = new JPanel(new GridLayout(2,1));
		btnPanel.add(selectBtn);
		btnPanel.add(removeBtn);
		gridPanel.add(btnPanel);

		// Create choice List
		choiceList = new JList();
		choiceList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                choiceList.addListSelectionListener(this);
		choiceList.setBackground(Color.WHITE);
		scrollChoices = new JScrollPane(choiceList);
		choicePanel = new JPanel( new BorderLayout() );
		choicePanel.setBorder(BorderFactory.createTitledBorder("Choices"));
		choicePanel.add(scrollChoices);
		gridPanel.add(choicePanel, BorderLayout.CENTER);
				
		// Set window defaults
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
            if( ae.getSource() == selectBtn) {
                String s = (String)courseList.getSelectedValue();
                a = new String[1];
                a[0] = s;
                choiceList = new JList(a);
                choiceList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                choiceList.addListSelectionListener(this);
                scrollChoices.setViewportView(choiceList);
                gridPanel.add(choicePanel, BorderLayout.CENTER);
                courseList.clearSelection();
                selectBtn.setEnabled(false);

            } else if( ae.getSource() == removeBtn) {
                choiceList = new JList();
                choiceList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                choiceList.addListSelectionListener(this);
                scrollChoices.setViewportView(choiceList);
                removeBtn.setEnabled(false);
            }
	}

	public static void main(String[] args) {
		new TwoListsB();
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
}