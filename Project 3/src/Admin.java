public class Admin {
    private String fname, lname, password;
    private int ID;

    /**
     * Admin Constructor
     * 
     * @param fname    the administrator's first name
     * @param lname    The administrator's last name
     * @param ID       The administrator's identification number
     * @param password The administartor's password
     */
    public Admin(String fname, String lname, int ID, String password) {
        this.fname = fname;
        this.lname = lname;
        this.ID = ID;
        this.password = password;
    };

    /**
     * Accessor method getFname
     * 
     * @return the administrator's first name
     */
    public String getFName() {

        return fname;
    }

    /**
     * getLName Assesor Method
     * 
     * @return the administrator's last name
     */
    public String getLName() {
        return lname;
    }

    /**
     * The getID Assesor Method
     * 
     * @return the administrator's identification number
     */
    public int getID() {
        return ID;
    }

    /**
     * the getPassword Assesor Method
     * 
     * @return the adminstrator's password
     */
    public String getPassword() {
        return password;
    }
}
