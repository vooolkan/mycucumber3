package database_stepdefinition;

import io.cucumber.java.en.Given;

import java.sql.*;

public class DBRead {
    //URL FOR OUR SWL SERVER DATABASE
    String url = "jdbc:sqlserver://184.168.194.58:1433;databaseName=kaolapalacedb;user=Ahmet_User;password=Ahmet123!";
    String username="Ahmet_User";
    String password="Ahmet123!";

    Connection connection;//To connect to the database
    Statement statement;//To execute query and get the data
    ResultSet resultSet;

    @Given("user connects to the database")
    public void user_connects_to_the_database() throws SQLException {
        connection= DriverManager.getConnection(url,username,password);
        statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }

    @Given("user gets {string} the {string} table")
    public void user_gets_the_table(String string, String string2) throws SQLException {
        //Running the query to connect tHOTEL table.
        resultSet=statement.executeQuery("SELECT Name FROM dbo.tHOTEL");

    }

    @Given("user reads all rows in the {string} column")
    public void user_reads_all_rows_in_the_column(String string) throws SQLException {
        resultSet.next();//SKIPPING THE FIRST ROW. next() methods goes to teh next row
        resultSet.next();
        resultSet.next();
        Object object1=resultSet.getObject("Name");
        System.out.println(object1);
        resultSet.next();
        System.out.println(resultSet.getObject("Name"));
        resultSet.next();
        System.out.println(resultSet.getObject("Name"));

    }

    @Given("user gets the value in row {int} in {string} column and verifies the value is {string}")
    public void user_gets_the_value_in_row_in_column_and_verifies_the_value_is(Integer int1, String string, String string2) {
    }

}
