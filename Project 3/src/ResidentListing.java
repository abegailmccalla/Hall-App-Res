import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.util.Comparator;
import java.util.Collections;
import java.awt.Color;

public class ResidentListing extends JPanel {
    private JButton cmdEdit;
    private JButton cmdDelete;
    private JButton cmdSortHall;
    private JButton cmdSortFirstName;
    private JButton cmdSortFaculty;
    private JButton cmdClose;
    private JPanel pnlCommand;
    private JPanel pnlDisplay;
    private ArrayList<Resident> rslist;
    private ResidentListing thisForm;
    private JScrollPane scrollPane;

    private JTable table;
    private DefaultTableModel model;

    /**
     * The ResdisentListing Constructor that creates a GUI for listing the residents
     * in a table
     */
    public ResidentListing() {
        super(new GridLayout(2, 1));
        thisForm = this;

        pnlCommand = new JPanel();
        pnlDisplay = new JPanel();

        JLabel apHeader = new JLabel("List of Students Applying for/ Reserving a Hall");
        apHeader.setFont(new Font("Georgia", Font.BOLD, 18));

        rslist = loadResidents("resident.txt");

        String[] columns = { "First Name", "Last Name", "ID", "Age", "Sex", "Telephone",
                "Email", "Year", "Type", "Level", "Faculty", "Major", "Hall", "Room" };
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        TableColumn column7 = table.getColumnModel().getColumn(13);
        column7.setPreferredWidth(40);

        showTable(rslist);

        table.setPreferredScrollableViewportSize(new Dimension(700, rslist.size() * 15 + 50));
        table.setFillsViewportHeight(true);

        scrollPane = new JScrollPane(table);

        add(scrollPane);

        cmdDelete = new JButton("Delete Info");
        cmdEdit = new JButton("Edit Info");
        cmdSortFirstName = new JButton("Sort by First Name");
        cmdSortHall = new JButton("Sort by Hall");
        cmdSortFaculty = new JButton("Sort by Faculty");
        cmdClose = new JButton("Close");

        cmdDelete.addActionListener(new DeleteInfoListener());
        cmdEdit.addActionListener(new EditInfoListener());
        cmdSortFirstName.addActionListener(new SortNameListener());
        cmdSortHall.addActionListener(new SortHallListener());
        cmdSortFaculty.addActionListener(new SortFacultyListener());
        cmdClose.addActionListener(new CloseButtonListener());

        cmdEdit.setBackground(Color.GREEN);
        cmdDelete.setBackground(Color.YELLOW);
        cmdSortFirstName.setBackground(Color.ORANGE);
        cmdSortHall.setBackground(Color.MAGENTA);
        cmdSortFaculty.setBackground(Color.BLUE);
        cmdClose.setBackground(Color.RED);
        cmdEdit.setForeground(Color.WHITE);
        cmdDelete.setForeground(Color.WHITE);
        cmdSortFirstName.setForeground(Color.WHITE);
        cmdSortHall.setForeground(Color.WHITE);
        cmdSortFaculty.setForeground(Color.WHITE);
        cmdClose.setForeground(Color.WHITE);

        pnlCommand.add(cmdEdit);
        pnlCommand.add(cmdSortFirstName);
        pnlCommand.add(cmdSortHall);
        pnlCommand.add(cmdSortFaculty);
        pnlCommand.add(cmdDelete);
        pnlCommand.add(cmdClose);

        setPreferredSize(new Dimension(1920, 1080));
        add(pnlCommand);
        setVisible(true);

    }

    /**
     * The EditInfoListener class is an ActionListener that creates a new EditInfo
     * object when an
     * action is performed.
     */
    private class EditInfoListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            EditInfo edit = new EditInfo(thisForm, rslist);
        }
    }

    /**
     * The DeleteInfoListener class is an ActionListener that creates an EditInfo
     * object when an action
     * is performed.
     */
    private class DeleteInfoListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            EditInfo delete = new EditInfo(thisForm, rslist);
        }
    }

    public static Comparator<Resident> nameComparator = new Comparator<Resident>() {
        /**
         * The function compares two Resident objects based on their names.
         * 
         * @param rs1 A variable of type Resident representing the first resident to be
         *            compared.
         * @param rs2 The "rs2" parameter is an object of the "Resident" class, which is
         *            being compared
         *            to another object of the same class ("rs1") based on their names
         *            using the "compareTo"
         *            method.
         * @return The method is returning an integer value which is the result of
         *         comparing the names
         *         of two Resident objects (rs1 and rs2) using the compareTo() method of
         *         the String class. The
         *         returned value will be negative if rs1's name comes before rs2's name
         *         in lexicographic
         *         order, zero if they are equal, and positive if rs1's name comes after
         *         rs2's name in le
         */
        public int compare(Resident rs1, Resident rs2) {
            return rs1.getName().compareTo(rs2.getName());
        }
    };

    /**
     * This is a Java class that implements an ActionListener to sort a list and
     * display it in a table.
     */
    private class SortNameListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            model.setRowCount(0);
            Collections.sort(rslist, nameComparator);
            showTable(rslist);

        }
    }

    public static Comparator<Resident> hallComparator = new Comparator<Resident>() {
        /**
         * The function compares two Resident objects based on their hall attribute in a
         * case-insensitive manner.
         * 
         * @param rs1 The first parameter is an object of the class Resident, named rs1.
         * @param rs2 The parameter "rs2" is an object of the class "Resident". It is
         *            used in the
         *            "compare" method to compare the "hall" attribute of two Resident
         *            objects.
         * @return The method is returning an integer value that represents the
         *         comparison between the
         *         halls of two Resident objects. The value returned will be negative if
         *         the hall of the first
         *         Resident object (rs1) comes before the hall of the second Resident
         *         object (rs2) in
         *         alphabetical order, zero if the halls are the same, and positive if
         *         the hall of the first
         *         Resident object comes after the hall of the second Resident
         */
        public int compare(Resident rs1, Resident rs2) {
            return rs1.getHall().compareToIgnoreCase(rs2.getHall());
        }
    };

    /**
     * This is a Java class that implements an ActionListener to sort and display a
     * table using a
     * hallComparator.
     */
    private class SortHallListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            model.setRowCount(0);
            Collections.sort(rslist, hallComparator);
            showTable(rslist);
        }
    }

    public static Comparator<Resident> facultyComparator = new Comparator<Resident>() {
        /**
         * This Java function compares two Resident objects based on their faculty
         * attribute.
         * 
         * @param rs1 An object of the class Resident representing the first resident to
         *            be compared.
         * @param rs2 `rs2` is a parameter of type `Resident` in the `compare` method.
         *            It represents the
         *            second `Resident` object that is being compared to the first
         *            `Resident` object `rs1`.
         * @return The method is returning an integer value that represents the
         *         comparison between the
         *         faculties of two Resident objects. The value returned will be
         *         negative if the faculty of rs1
         *         comes before the faculty of rs2 in alphabetical order, zero if they
         *         are the same, and
         *         positive if the faculty of rs1 comes after the faculty of rs2 in
         *         alphabetical order.
         */
        public int compare(Resident rs1, Resident rs2) {
            return rs1.getFaculty().compareToIgnoreCase(rs2.getFaculty());
        }
    };

    /**
     * The SortFacultyListener class is an ActionListener that sorts a list of
     * faculty members and
     * displays them in a table.
     */
    private class SortFacultyListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            model.setRowCount(0);
            Collections.sort(rslist, facultyComparator);
            showTable(rslist);

        }

    }

    /**
     * This is a private class that implements the ActionListener interface and
     * exits the program when
     * the close button is clicked.
     */
    private class CloseButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            System.exit(0);

        }

    }

    /**
     * This function loads a list of residents from a file and returns an ArrayList
     * of Resident
     * objects.
     * 
     * @param rsfile The file path/name of the file containing the information of
     *               residents to be
     *               loaded.
     * @return An ArrayList of Resident objects is being returned.
     */
    private ArrayList<Resident> loadResidents(String rsfile) {
        Scanner scanner = null;
        ArrayList<Resident> rslist = new ArrayList<Resident>();
        try {
            scanner = new Scanner(new File(rsfile));
            while (scanner.hasNext()) {
                String[] nextLine = scanner.nextLine().split(" ");
                String name = nextLine[0] + " " + nextLine[1];
                int id = Integer.parseInt(nextLine[2]);
                int age = Integer.parseInt(nextLine[3]);
                String gender = nextLine[4];
                String tphone = nextLine[5];
                String email = nextLine[6];
                int year = Integer.parseInt(nextLine[7]);
                String type = nextLine[8];
                String gradlevel = nextLine[9];
                String faculty = nextLine[10];
                String major = nextLine[11];
                String hall = nextLine[12];
                String room = nextLine[13];

                Resident rs = new Resident(name, id, age, gender, tphone, email, year, type, gradlevel, faculty, major,
                        hall, room);
                rslist.add(rs);
            }

            scanner.close();
        } catch (IOException e) {
            System.out.println("no");
        }
        return rslist;
    }

    private void showTable(ArrayList<Resident> rsList) {
        if (rsList.size() > 0) {
            for (Resident rs : rsList) {
                addToTable(rs);
            }
        }
    }

    /**
     * The function adds a resident's information to a table in Java.
     * 
     * @param rs rs is an object of the class Resident.
     */
    private void addToTable(Resident rs) {
        String[] name = rs.getName().split(" ");
        String[] item = { name[0], name[1], "" + rs.getID(), "" + rs.getAge(), "" + rs.getGender(), "" +
                rs.getTphone(), "" + rs.getEmail(), "" + rs.getYear(), "" + rs.getType(), "" + rs.getLevel(),
                "" +
                        rs.getFaculty(),
                "" + rs.getMajor(), "" + rs.getHall(), "" + rs.getRoom() };

        model.addRow(item);

    }

    /**
     * This function creates a JFrame window to display a list of students applying
     * for or reserving a
     * hall.
     */
    public void showList() {
        JFrame frame = new JFrame("List of Students Applying for/ Reserving a Hall");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and set up the content pane.
        ResidentListing newContentPane = new ResidentListing();
        newContentPane.setOpaque(true); // content panes must be opaque
        frame.setContentPane(newContentPane);

        // Display the window.
        frame.pack();
        frame.setVisible(true);

    }

}
