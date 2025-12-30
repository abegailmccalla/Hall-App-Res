import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TaylorHall implements HallOfResidence {
    private int numRoom;
    private int budget = 150000;
    private String aRoom;
    private int index, count;
    private Block blockA = new Block("TH", "A");
    private Block blockB = new Block("TH", "B");
    private Block blockC = new Block("TH", "C");
    private Block blockD = new Block("TH", "D");
    private ArrayList<Block> numBlocks = new ArrayList<Block>();
    // private ArrayList<String> bookedRooms = new ArrayList<String>();
    // `private Random random = new Random();` is creating a new instance of the
    // `Random` class, which
    // is used to generate random numbers. This is used in the `bookRoom` method to
    // randomly select a
    // block and room to book.
    private Random random = new Random();
    private Gender gnd;

    /**
     * The TaylorHall Constructor thar adds sums the number of rooms and add
     * all blocks to the arrayList 'numBlocks'.
     */
    public TaylorHall() {
        numRoom = blockA.getNumOfRooms() + blockB.getNumOfRooms() + blockC.getNumOfRooms() + blockD.getNumOfRooms();
        numBlocks.add(blockA);
        numBlocks.add(blockB);
        numBlocks.add(blockC);
        numBlocks.add(blockD);
    }

    /**
     * The function returns the number of rooms.
     * 
     * @return The method `numRooms()` is returning an integer value which
     *         represents the number of
     *         rooms.
     */
    public int numRooms() {
        return numRoom;
    }

    /**
     * The function returns the budget.
     * 
     * @return The method is returning an integer value which represents the budget.
     */
    public int getBudget() {
        return budget;
    }

    /**
     * The function books a room based on the gender and budget of the person, and
     * checks for room
     * availability in a file.
     * 
     * @param gender The gender of the person booking the room (either male or
     *               female).
     * @param budget The budget of the person trying to book a room.
     * @param rfile  The name of the file containing information about available
     *               rooms in a hall.
     * @return The method is returning a String variable named "aRoom", which
     *         represents the room
     *         number of the booked room.
     */
    public String bookRoom(Gender gender, int budget, String rfile) {
        Scanner scan;
        try {
            scan = new Scanner(new File(rfile));
            ArrayList<String> rooms = new ArrayList<String>();
            while (scan.hasNext()) {
                String[] lines = scan.nextLine().split(" ");
                String room = lines[13];
                rooms.add(room);
            }
            if (budget >= this.budget) {
                switch (gender) {
                    case male:
                        // randomizes the block number and assigns the value to index (eg. the first
                        // block in the list is given index 1)
                        index = random.nextInt(numBlocks.size());
                        /*
                         * assigns the variable 'block' to the index generated(eg. if there are 3 blocks
                         * in the list and the index is 2,
                         * 'block' would be assigned to the 2nd block in the list)
                         */
                        Block block = numBlocks.get(index);
                        /*
                         * assigns a random number based on the amount available in the arrayList (eg.
                         * if the size of the arrayList is 10, 'count'
                         * can be assigned any number from 1 to 10)
                         */
                        count = random.nextInt(block.getMRooms().size());
                        /* assigns the room number to 'aRoom' based on the value of count */
                        aRoom = block.getMRooms().get(count);
                        for (String rm : rooms) {
                            if (rm.equals(aRoom)) {
                                count = random.nextInt(block.getMRooms().size());
                                aRoom = block.getMRooms().get(count);
                            }
                        }
                        /*
                         * checks through the arrayList to find the room that matches to the value of
                         * 'aRoom' and add it to the arrayList 'bookedRooms'
                         * then removes it from the existing arrayList
                         */
                        /*
                         * for (int i = 0; i < numBlocks.size(); i++) {
                         * if (block == numBlocks.get(i)) {
                         * bookedRooms.add(block.getMRooms().get(count));
                         * block.getMRooms().remove(count);
                         * if (block.getMRooms().size()== 0){
                         * numBlocks.remove(index);}
                         * }
                         * }
                         */
                        break;

                    case female:
                        index = random.nextInt(numBlocks.size());
                        block = numBlocks.get(index);
                        count = random.nextInt(block.getFRooms().size());
                        aRoom = block.getFRooms().get(count);
                        for (String rm : rooms) {
                            if (rm.equals(aRoom)) {
                                count = random.nextInt(block.getMRooms().size());
                                aRoom = block.getMRooms().get(count);
                            }
                        }
                        /*
                         * for (int i = 0; i < numBlocks.size(); i++) {
                         * if (block == numBlocks.get(i)) {
                         * bookedRooms.add(numBlocks.get(i).getFRooms().get(count));
                         * numBlocks.get(i).getFRooms().remove(count);
                         * if (block.getFRooms().size()== 0){
                         * numBlocks.remove(index);}
                         * }
                         * }
                         */
                        break;
                }
            } else {
                // "You do not possess enough funds to book a room on this hall"
                aRoom = "";
            }
        } catch (FileNotFoundException fe) {
            System.out.println(fe.getMessage());
        } catch (ArrayIndexOutOfBoundsException ae) {
            // "No available rooms"
            aRoom = "";
        }
        return aRoom;

    }

    /**
     * The function reserves a room based on gender, budget, block name, and a file
     * containing room
     * information.
     * 
     * @param gender    The gender of the person reserving the room (either male or
     *                  female).
     * @param budget    The budget of the person trying to reserve a room.
     * @param blockName The name of the block where the room is to be reserved.
     * @param rfile     The name of the file containing information about available
     *                  rooms.
     * @return The method is returning a String variable named "aRoom", which
     *         represents the room
     *         number that has been reserved.
     */
    public String reserveRoom(Gender gender, int budget, String blockName, String rfile) {
        Scanner scan;
        try {
            scan = new Scanner(new File(rfile));
            ArrayList<String> rooms = new ArrayList<String>();
            while (scan.hasNext()) {
                String[] lines = scan.nextLine().split(" ");
                String room = lines[13];
                rooms.add(room);
            }
            if (budget >= this.budget) {
                switch (gender) {
                    case male:

                        Block block = getBlock(blockName);
                        /*
                         * assigns a random number based on the amount available in the arrayList (eg.
                         * if the size of the arrayList is 10, 'count'
                         * can be assigned any number from 1 to 10)
                         */
                        count = random.nextInt(block.getMRooms().size());
                        /* assigns the room number to 'aRoom' based on the value of count */
                        aRoom = block.getMRooms().get(count);
                        for (String rm : rooms) {
                            if (rm.equals(aRoom)) {
                                count = random.nextInt(block.getMRooms().size());
                                aRoom = block.getMRooms().get(count);
                            }
                        }
                        /*
                         * checks through the arrayList to find the room that matches to the value of
                         * 'aRoom' and add it to the arrayList 'bookedRooms'
                         * then removes it from the existing arrayList
                         */
                        /*
                         * for (int i = 0; i < numBlocks.size(); i++) {
                         * if (block == numBlocks.get(i)) {
                         * bookedRooms.add(block.getMRooms().get(count));
                         * block.getMRooms().remove(count);
                         * if (block.getMRooms().size()== 0){
                         * numBlocks.remove(index);}
                         * }
                         * }
                         */
                        break;
                    case female:
                        block = getBlock(blockName);
                        count = random.nextInt(block.getFRooms().size());
                        aRoom = block.getFRooms().get(count);
                        for (String rm : rooms) {
                            if (rm.equals(aRoom)) {
                                count = random.nextInt(block.getMRooms().size());
                                aRoom = block.getMRooms().get(count);
                            }
                        }
                        /*
                         * for (int i = 0; i < numBlocks.size(); i++) {
                         * if (block == numBlocks.get(i)) {
                         * bookedRooms.add(numBlocks.get(i).getFRooms().get(count));
                         * numBlocks.get(i).getFRooms().remove(count);
                         * if (block.getFRooms().size()== 0){
                         * numBlocks.remove(index);}
                         * }
                         * }
                         */
                        break;
                }
            } else {
                // "You do not possess enough funds to book a room on this hall"
                aRoom = "";
            }
        } catch (FileNotFoundException fe) {
            System.out.println(fe.getMessage());
        } catch (ArrayIndexOutOfBoundsException ae) {
            // "No available rooms"
            aRoom = "";
        }
        return aRoom;

    }

    /**
     * The function takes a string input and returns a Gender enum value based on
     * whether the input is
     * "male" or not.
     * 
     * @param gndd A string representing the gender of a person. It can be either
     *             "male" or "female".
     * @return The method is returning a Gender enum value based on the input string
     *         "gndd". If the
     *         input string is "male", it returns the Gender enum value "male". If
     *         the input string is anything
     *         else, it returns the Gender enum value "female".
     */
    public Gender getGender(String gndd) {
        if (gndd.equals("male")) {
            gnd = Gender.male;
        } else {
            gnd = Gender.female;
        }
        return gnd;
    }

    /**
     * The function returns a Block object based on the input block name.
     * 
     * @param blockName A string representing the name of a block. The method
     *                  returns the corresponding
     *                  Block object based on the input blockName.
     * @return The method is returning a Block object, which is determined based on
     *         the input parameter
     *         "blockName". The specific Block object that is returned depends on
     *         the value of "blockName". If
     *         "blockName" is equal to "A", the method returns the "blockA" object.
     *         If "blockName" is equal to
     *         "B", the method returns the "blockB" object. If "
     */
    public Block getBlock(String blockName) {
        Block bl;
        if (blockName.equals("A")) {
            bl = blockA;
        } else if (blockName.equals("B")) {
            bl = blockB;
        } else if (blockName.equals("C")) {
            bl = blockC;
        } else {
            bl = blockD;
        }
        return bl;
    }

}
