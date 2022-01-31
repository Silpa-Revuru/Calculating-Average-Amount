package averageamount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InfoTest {

    @Test
    void getCompanyCode() {
        Info information = new Info(2309,	6849224,"London",
                "UK","A","GBP",-398659337.540115);
        assertEquals(2309,information.getCompanyCode());

    }

    @Test
    void getAccount() {
        Info information = new Info(2309,	6849224,"London",
                "UK","A","GBP",-398659337.540115);
        assertEquals(6849224,information.getAccount());
    }

    @Test
    void getCity() {
        Info information = new Info(2309,	6849224,"London",
                "UK","A","GBP",-398659337.540115);
        assertEquals("London",information.getCity());
    }

    @Test
    void getCountry() {
        Info information = new Info(2309,	6849224,"London",
                "UK","A","GBP",-398659337.540115);
        assertEquals("UK",information.getCountry());
    }

    @Test
    void getCreditRating() {
        Info information = new Info(2309,	6849224,"London",
                "UK","A","GBP",-398659337.540115);
        assertEquals("A",information.getCreditRating());
    }

    @Test
    void getCurrency() {
        Info information = new Info(2309,	6849224,"London",
                "UK","A","GBP",-398659337.540115);
        assertEquals("GBP",information.getCurrency());
    }

    @Test
    void getAmount() {
        Info information = new Info(2309,	6849224,"London",
                "UK","A","GBP",-398659337.540115);
        assertEquals(-398659337.540115,information.getAmount());
    }
}