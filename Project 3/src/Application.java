import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Application extends JPanel {
    private JButton cmdClose;
    private JButton cmdApply;
    private JButton cmdReserve;
    private JButton cmdAdminLogin;
    private JPanel panelCommand;
    private JPanel panelDisplay;
    private Application app;

    /**
     * The Application Constructor that will be used to create the home GUI
     */
    public Application() {

        panelCommand = new JPanel();
        panelDisplay = new JPanel();

        setBackground(Color.WHITE);

        // to display Application Header

        ImageIcon icon = new ImageIcon("uwicrest.jpg");
        Image logoImage = icon.getImage().getScaledInstance(50, 80, Image.SCALE_SMOOTH);
        ImageIcon scaledLogo = new ImageIcon(logoImage);
        JLabel logo = new JLabel(scaledLogo, SwingConstants.CENTER);

        JLabel header = new JLabel("   THE UNIVERSITY OF THE WEST INDIES, MONA CAMPUS", SwingConstants.CENTER);
        header.setFont(new Font("Georgia", Font.BOLD, 36));
        header.setBackground(Color.RED);
        header.setForeground(Color.WHITE);

        // to group crest and the school's name so it appears in one row
        Box hBox = Box.createHorizontalBox();
        hBox.add(Box.createHorizontalGlue());
        hBox.add(logo);
        hBox.add(Box.createHorizontalStrut(10));
        hBox.add(header);
        hBox.add(Box.createHorizontalGlue());
        panelDisplay.add(hBox);
        hBox.setBackground(Color.RED);
        hBox.setOpaque(true);

        JLabel subHeader = new JLabel("Hall of Residence Application/Reservation", SwingConstants.LEFT);
        subHeader.setFont(new Font("Georgia", Font.BOLD, 24));

        panelCommand.setBackground(Color.WHITE);
        panelDisplay.setLayout(new GridLayout(1, 2));

        // command buttons
        cmdClose = new JButton("Close");
        cmdApply = new JButton("Apply");
        cmdReserve = new JButton("Reserve");
        cmdAdminLogin = new JButton("Admin Login");

        // colour of buttons
        cmdApply.setBackground(Color.WHITE);
        cmdClose.setBackground(Color.RED);
        cmdClose.setForeground(Color.WHITE);
        cmdReserve.setBackground(Color.YELLOW);
        cmdApply.setForeground(Color.RED);
        cmdAdminLogin.setBackground(Color.CYAN);

        panelCommand.add(cmdApply);
        panelCommand.add(cmdReserve);
        panelCommand.add(cmdAdminLogin);
        panelCommand.add(cmdClose);

        cmdClose.addActionListener(new closeButtonListener());
        cmdApply.addActionListener(new ApplyButtonListener());
        cmdReserve.addActionListener(new ApplyButtonListener());
        cmdAdminLogin.addActionListener(new AdminButtonListener());

        add(panelDisplay, BorderLayout.CENTER);

        // to group the second header and the command buttons so it aligns better on the
        // frame
        Box vBox = Box.createVerticalBox();
        vBox.add(Box.createVerticalGlue());
        vBox.add(subHeader);
        subHeader.setAlignmentX(CENTER_ALIGNMENT);
        vBox.add(Box.createVerticalGlue());
        vBox.add(panelCommand);
        vBox.setAlignmentX(CENTER_ALIGNMENT);

        setPreferredSize(new Dimension(1200, 150));

        add(vBox, BorderLayout.SOUTH);
        setVisible(true);

        app = this;
    }

    /**
     * The function creates and displays a JFrame for a hall of residence
     * application/reservation
     * system.
     */
    public static void showApplication() {
        JFrame frame = new JFrame("Hall of Residence Application/Reservation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = 1200;
        int height = 300;
        frame.setBounds(center.x - width / 2, center.y - height / 2, width, height);
        Application app = new Application();
        // app.setOpaque(true);
        frame.setContentPane(app);

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * The main function uses SwingUtilities to run the showApplication function on
     * the event dispatch
     * thread.
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                showApplication();
            }
        });
    }

    /**
     * The closeButtonListener class is an ActionListener that exits the program
     * when the close button
     * is clicked.
     */
    private class closeButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    /**
     * The ApplyButtonListener class creates an instance of either the Apply or
     * Reserve class based on
     * the source of the ActionEvent.
     */
    private class ApplyButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent g) {
            if (g.getSource() == cmdApply) {
                Apply nsa = new Apply(app);
            } else {
                Reserve rsa = new Reserve(app);
            }
        }

    }

    /**
     * The AdminButtonListener class creates an instance of the AdminLogin class
     * when the
     * actionPerformed method is called.
     */
    private class AdminButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            AdminLogin admin = new AdminLogin(app);
        }
    }
}
