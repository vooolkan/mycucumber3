package database_stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;

public class DBCreate_StepDefinitions {

    @Given("create a new hotel with the new data")
    public void create_a_new_hotel_with_the_new_data() {
        String create="INSERT INTO dbo.tHOTEL (Code, Name, Address, Phone, Email, IDGroup, CreateDate,CreateUser) VALUES ('678', 'NEW HOTEL', 'newaddress', '3333333', 'test@testemail.com', 10012, '2020-11-01 13:38:47.597',4)";
        DBUtils.executeQuery(create);

    }

    @Then("verify if the hotel is created")
    public void verify_if_the_hotel_is_created() {
        String read="SELECT Name FROM dbo.tHOTEL";
        //getColumnData is returning the list of data in certain column.
        //DBUtils.getColumnData(read,"Name").toString() will return ALL NAMES from the dbo.tHOTEL table
        Assert.assertTrue(DBUtils.getColumnData(read,"Name").toString().contains("NEW HOTEL"));
        DBUtils.closeConnection();

    }
}
