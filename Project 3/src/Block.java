import java.util.ArrayList;

public class Block {
    // number of rooms on a block
    private int nrooms = 50;
    private String room;
    private ArrayList<String> mrooms = new ArrayList<String>();
    private ArrayList<String> frooms = new ArrayList<String>();

    /**
     * 
     * @param hallName  the name of the hall
     * @param blockName the name of the block
     */
    public Block(String hallName, String blockName) {
        // to fill the first 20 rooms with males
        for (int i = 0; i < 20; i++) {
            room = hallName + " " + blockName + String.valueOf(i + 1);
            mrooms.add(room);
        }
        // the rest with females
        for (int i = 20; i < 50; i++) {
            room = hallName + " " + blockName + String.valueOf(i + 1);
            frooms.add(room);
        }
    }

    /**
     * @return number of rooms
     */
    public int getNumOfRooms() {
        return nrooms;
    }

    /**
     * 
     * @return male rooms
     */
    public ArrayList<String> getMRooms() {
        return mrooms;
    }

    /**
     * 
     * @return female rooms
     */
    public ArrayList<String> getFRooms() {
        return frooms;
    }
}
