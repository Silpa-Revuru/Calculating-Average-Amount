package averageamount;

public class Info {

    private int companyCode;
    private int account;
    private String city;
    private String country;
    private String creditRating;
    private String currency;
    private double amount;

    public Info(int companyCode, int account, String city, String country, String creditRating, String currency, double amount) {
        this.companyCode = companyCode;
        this.account = account;
        this.city = city;
        this.country = country;
        this.creditRating = creditRating;
        this.currency = currency;
        this.amount = amount;
    }

    public int getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(int companyCode) {
        this.companyCode = companyCode;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(String creditRating) {
        this.creditRating = creditRating;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
