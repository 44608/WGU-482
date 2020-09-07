package Model;

public class inHouse extends Part {
    private static int machineID;

    /**
     * Constructor to create in House parts
     * @param id
     * @param name
     * @param price
     * @param stock
     * @param min
     * @param max
     * @param machID
     */
    public inHouse(int id, String name, double price, int stock, int min, int max, int machID) {
        super(id, name, price, stock, min, max);
        setMachineID(machID);
    }

    /**
     * allows instances of in house parts to return their ID as an INT
     * @return
     */
    public int getMachineID() {
        return machineID;
    }

    /**
     * allows setting of new Machine ID to an in house part
     * @param id
     */
    public void setMachineID(int id) {
        this.machineID = id;
    }


}
