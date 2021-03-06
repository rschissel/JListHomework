/*
 * TwoListsD.java
 *
 * This example uses the Netbeans GUI editor and customizes code
 * creation to use external DefaultListModel implementations.
 */
package example3;

import javax.swing.DefaultListModel;

/**
 *
 * @author jlombardo
 */
public class TwoListsD extends javax.swing.JFrame {

    private DefaultListModel courseModel, choiceModel;
    private String selection;

    /**
     * Creates new form TwoListsD
     */
    public TwoListsD() {
        // Firt create the custom model objects
        courseModel = new CourseListModel();
        choiceModel = new ChoiceListModel();

        // Customize the JList model property before running this and
        // use the custom code creation feature in the CODE section of
        // the properties panel for the JList
        initComponents();
    }

    ///////// PRIVATE UTILITY MODULARIZES CODE USE IN SEVERAL PLACES ////////
    // Remove an item from the Course List, add it to the Choice List
    // and enable disable buttons as necessary
    private void addSelectionToChoiceList() {
        selection = (String) listCourses.getSelectedValue();
        choiceModel.addElement(selection);
        courseModel.remove(listCourses.getSelectedIndex());
        btnSelect.setEnabled(false);

    }

    ///////// PRIVATE UTILITY MODULARIZES CODE USE IN SEVERAL PLACES ////////
    // Remove an item from the Choice List, add it to the Course List
    // and enable disable buttons as necessary
    private void removeSelectionFromChoiceList() {
        courseModel.addElement(listChoices.getSelectedValue());
        choiceModel.remove(listChoices.getSelectedIndex());
        btnRemove.setEnabled(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listCourses = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        listChoices = new javax.swing.JList();
        btnSelect = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Courses"));

        listCourses.setModel(courseModel);
        listCourses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listCoursesMouseClicked(evt);
            }
        });
        listCourses.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listCoursesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listCourses);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Choices"));

        listChoices.setModel(choiceModel);
        listChoices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listChoicesMouseClicked(evt);
            }
        });
        listChoices.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listChoicesValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listChoices);

        btnSelect.setText("Select >>");
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });

        btnRemove.setText("<< Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnQuit.setText("Quit");
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnQuit)
                .addGap(258, 258, 258))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(btnSelect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRemove)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btnQuit)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        // TODO add your handling code here:
        addSelectionToChoiceList();
    }//GEN-LAST:event_btnSelectActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        removeSelectionFromChoiceList();
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void listCoursesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listCoursesValueChanged
        // TODO add your handling code here:
        btnSelect.setEnabled(true);
        btnRemove.setEnabled(false);
    }//GEN-LAST:event_listCoursesValueChanged

    private void listChoicesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listChoicesValueChanged
        // TODO add your handling code here:
        btnSelect.setEnabled(false);
        btnRemove.setEnabled(true);
    }//GEN-LAST:event_listChoicesValueChanged

    private void listCoursesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listCoursesMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            addSelectionToChoiceList();
        }
    }//GEN-LAST:event_listCoursesMouseClicked

    private void listChoicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listChoicesMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            removeSelectionFromChoiceList();
        }
    }//GEN-LAST:event_listChoicesMouseClicked

    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnQuitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TwoListsD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQuit;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSelect;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listChoices;
    private javax.swing.JList listCourses;
    // End of variables declaration//GEN-END:variables

}
