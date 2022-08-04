package ba.shop.phonestore.ejb.upload;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FileUploadDao {

    private static final String URL = "jdbc:mysql://localhost:4444/phone_store?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static final String SQL_INSERT = "INSERT INTO image_content (image) values (?)";

    public int uploadFile(InputStream file) {
        int row = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT)) {

            if (file != null) {
                // fetches input stream of the upload file for the blob column
                preparedStatement.setBlob(1, file);
            }

            // sends the statement to the database server
            row = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return row;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
