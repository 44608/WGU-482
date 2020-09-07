package Model;



public class outSourced extends Part {
    private static String companyName;

    /**
     * Constructor to create new out sourced parts
     * @param id
     * @param name
     * @param price
     * @param stock
     * @param min
     * @param max
     * @param companyName
     */
    public outSourced(int id, String name, double price, int stock, int min, int max, String companyName) {
        super(id, name, price, stock, min, max);
        setCompanyCompany(companyName);
    }

    /**
     *
     * @return company name of out sourced parts
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * sets a new company name for an out sourced part
     * @param companyName
     */

    public void setCompanyCompany(String companyName) {
        this.companyName = companyName;
    }


}
