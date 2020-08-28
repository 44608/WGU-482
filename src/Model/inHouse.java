package Model;

public class inHouse extends Part {
    private static int machineID;

    public inHouse(int id, String name, double price, int stock, int min, int max, int machID) {
        super(id, name, price, stock, min, max);
        setMachineID(machID);
    }

    public int getMachineID() {
        return machineID;
    }

    public void setMachineID(int id) {
        this.machineID = id;
    }


}
