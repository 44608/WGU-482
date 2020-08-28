package Model;



public class outSourced extends Part {
    private static String companyName;

    public outSourced(int id, String name, double price, int stock, int min, int max, String companyName) {
        super(id, name, price, stock, min, max);
        setCompanyCompany(companyName);
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyCompany(String companyName) {
        this.companyName = companyName;
    }


}
