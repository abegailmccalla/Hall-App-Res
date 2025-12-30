public class Resident implements Comparable<Resident> {
    public String name, gender, tphone, email, type, grad, faculty, major, hall, room;
    private int ID, age, yr;

    /**
     * The Resident Constructor that creates a new instance of this class
     * 
     * @param name    name of the resident
     * @param ID      id of the resident
     * @param age     age of the resident
     * @param gender  gender of the resident
     * @param tphone  phone number of the resident
     * @param email   email of the resident
     * @param yr      year of the resident
     * @param type    whether the resident is a new or returning student
     * @param grad    program level of the resident
     * @param faculty faculty of the resident
     * @param major   major of the resident
     * @param hall    hall of the resident
     * @param room    room number of the resident
     */
    public Resident(String name, int ID, int age, String gender, String tphone, String email, int yr, String type,
            String grad, String faculty, String major, String hall, String room) {
        this.name = name;
        this.ID = ID;
        this.age = age;
        this.gender = gender;
        this.tphone = tphone;
        this.email = email;
        this.yr = yr;
        this.type = type;
        this.grad = grad;
        this.faculty = faculty;
        this.major = major;
        this.hall = hall;
        this.room = room;
    }

    /**
     * The function returns the name of an object as a string.
     * 
     * @return The method `getName()` is returning a `String` value, which is the
     *         value of the variable
     *         `name`.
     */
    public String getName() {
        return name;
    }

    /**
     * This is a Java function that sets the name of an object.
     * 
     * @param name The parameter "name" is a String type variable that represents
     *             the name of an object
     *             or entity. The method "setName" takes a String parameter "name"
     *             and sets the value of the
     *             instance variable "name" to the value passed as an argument.
     */
    protected void setName(String name) {
        this.name = name;
    }

    /**
     * The function returns the ID of an object.
     * 
     * @return The method `getID()` is returning an integer value which represents
     *         the ID of an object.
     */
    public int getID() {
        return ID;
    }

    /**
     * This is a setter method in Java that sets the value of the ID variable.
     * 
     * @param ID ID is a variable of type int that represents the identification
     *           number of an object.
     *           The method setID() is used to set the value of this variable.
     */
    protected void setID(int ID) {
        this.ID = ID;
    }

    /**
     * The function returns the age of an object.
     * 
     * @return The method `getAge()` is returning the value of the `age` variable.
     */
    public int getAge() {
        return age;
    }

    /**
     * This is a setter method in Java that sets the age variable of an object to a
     * given value.
     * 
     * @param age age is an integer variable that represents the age of an object or
     *            entity. The method
     *            setAge() is used to set the value of the age variable.
     */
    protected void setAge(int age) {
        this.age = age;
    }

    /**
     * The function returns the gender of an object as a string.
     * 
     * @return The method `getGender()` is returning a `String` value, which is the
     *         gender of the
     *         object.
     */
    public String getGender() {
        return gender;
    }

    /**
     * This is a setter method in Java that sets the gender attribute of an object.
     * 
     * @param gender The parameter "gender" is a String variable that represents the
     *               gender of a
     *               person. The "setGender" method is used to set the value of this
     *               variable.
     */
    protected void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * The function returns the value of the variable "tphone" as a string.
     * 
     * @return The method is returning a String value which is the value of the
     *         variable `tphone`.
     */
    public String getTphone() {
        return tphone;
    }

    /**
     * This is a Java function that sets the value of a phone number variable.
     * 
     * @param tphone tphone is a variable of type String that represents the phone
     *               number of an object.
     *               The method setPhoneNum sets the value of the tphone variable to
     *               the value passed as a parameter.
     */
    protected void setPhoneNum(String tphone) {
        this.tphone = tphone;
    }

    /**
     * This function returns the email of an object.
     * 
     * @return The method `getEmail()` is returning a `String` value, which is the
     *         email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * This is a setter method in Java that sets the value of the email field in an
     * object.
     * 
     * @param email The email parameter is a String that represents the email
     *              address of a user. The
     *              setEmail method is a setter method that sets the value of the
     *              email instance variable to the
     *              value passed as a parameter.
     */
    protected void setEmail(String email) {
        this.email = email;
    }

    /**
     * The function returns the value of the variable "yr".
     * 
     * @return The method `getYear()` is returning an integer value which is the
     *         value of the variable
     *         `yr`.
     */
    public int getYear() {
        return yr;
    }

    /**
     * This is a Java function that sets the value of the "yr" variable.
     * 
     * @param yr yr is a private instance variable of the class that is being set
     *           using the setYear()
     *           method. It represents the year value of a particular object
     *           instance.
     */
    protected void setYear(int yr) {
        this.yr = yr;
    }

    /**
     * The function returns the type of an object as a string.
     * 
     * @return The method `getType()` is returning a `String` value. The specific
     *         value being returned
     *         depends on the implementation of the `type` variable.
     */
    public String getType() {
        return type;
    }

    /**
     * This is a Java function that sets the type of an object.
     * 
     * @param type The "type" parameter is a String data type that represents the
     *             type of an object or
     *             variable. The "setType" method is used to set the value of the
     *             "type" instance variable of an
     *             object to the specified value.
     */
    protected void setType(String type) {
        this.type = type;
    }

    /**
     * This function returns the value of the variable "grad" as a string.
     * 
     * @return The method `getLevel()` is returning the value of the variable
     *         `grad`.
     */
    public String getLevel() {
        return grad;
    }

    /**
     * This is a Java function that sets the level of a variable called "grad".
     * 
     * @param grad grad is a parameter of type String that represents the level or
     *             grade of something.
     *             The method setLevel takes in a String parameter grad and sets the
     *             instance variable grad to the
     *             value of the parameter.
     */
    protected void setLevel(String grad) {
        this.grad = grad;
    }

    /**
     * The function returns the faculty of a person.
     * 
     * @return The method `getFaculty()` is returning a `String` value, which is the
     *         value of the
     *         `faculty` variable.
     */
    public String getFaculty() {
        return faculty;
    }

    /**
     * This is a Java function that sets the faculty attribute of an object to a
     * given value.
     * 
     * @param faculty The parameter "faculty" is a String variable that represents
     *                the name of the
     *                faculty associated with a particular object or instance of a
     *                class. The method "setFaculty" is
     *                used to set the value of this variable for that object.
     */
    protected void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    /**
     * The function returns the major of a student.
     * 
     * @return The method `getMajor()` is returning a `String` value, which is the
     *         value of the `major`
     *         variable.
     */
    public String getMajor() {
        return major;
    }

    /**
     * This is a setter method in Java that sets the value of the "major" variable.
     * 
     * @param major The parameter "major" is a String type variable that represents
     *              the major of a
     *              student or any other person. The method "setMajor" is used to
     *              set the value of the "major"
     *              variable.
     */
    protected void setMajor(String major) {
        this.major = major;
    }

    /**
     * The function returns the value of the "hall" variable as a string.
     * 
     * @return The method `getHall()` is returning a `String` variable named `hall`.
     */
    public String getHall() {
        return hall;
    }

    /**
     * This is a setter method in Java that sets the value of a private variable
     * "hall".
     * 
     * @param hall The parameter "hall" is a String variable that represents the
     *             name or identifier of
     *             a hall. The method "setHall" sets the value of the instance
     *             variable "hall" to the value passed
     *             as a parameter.
     */
    protected void setHall(String hall) {
        this.hall = hall;
    }

    /**
     * The function returns the value of the "room" variable as a string.
     * 
     * @return The method `getRoom()` is returning a `String` value, which is the
     *         value of the variable
     *         `room`.
     */
    public String getRoom() {
        return room;
    }

    /**
     * This is a setter method in Java that sets the value of the "room" variable.
     * 
     * @param room The parameter "room" is a String variable that represents the
     *             name or identifier of
     *             a room. The method "setRoom" sets the value of the instance
     *             variable "room" to the value passed
     *             as a parameter.
     */
    protected void setRoom(String room) {
        this.room = room;
    }

    /**
     * The function returns a concatenated string of various attributes of an
     * object.
     * 
     * @return A concatenated string of various attributes of an object, likely
     *         representing a student
     *         or member of a university community. The specific attributes being
     *         returned include name, ID,
     *         age, gender, telephone number, email, year of study, type of student
     *         (e.g. undergraduate or
     *         graduate), level of study, faculty, major, hall of residence, and
     *         room number.
     */
    public String toString() {
        return getName() + " " + getID() + " " + getAge() + " " + getGender() + " " + getTphone() + " " + getEmail()
                + " " + getYear() + " " + getType() + " " + getLevel() + " " + getFaculty() + " " + getMajor() + " "
                + getHall() + " " + getRoom();
    }

    /**
     * The function compares the ID of the current resident object with the ID of
     * another resident
     * object and returns the difference.
     * 
     * @param other The "other" parameter is an object of the "Resident" class that
     *              is being compared
     *              to the current object.
     * @return The method is returning the result of subtracting the ID of the
     *         current resident object
     *         from the ID of the other resident object. However, the subtraction is
     *         reversed, so the result
     *         will be in descending order.
     */
    @Override
    public int compareTo(Resident other) {
        return other.getID() - this.getID();
    }

}
