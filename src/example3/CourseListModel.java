package example3;

import javax.swing.DefaultListModel;

/**
 *
 * @author jlombardo
 */
public class CourseListModel extends DefaultListModel {

    public CourseListModel() {
        // Defaults at startup
        addElement("Advanced Java");
        addElement("Distributed Java");
        addElement("Enterprise Java");
        addElement("Web App Dev Using ASP.NET");
    }

}
