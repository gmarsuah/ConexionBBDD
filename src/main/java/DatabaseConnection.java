import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // URL de conexión
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Agenda1";
    // Credenciales de la base de datos
    private static final String USER = "sa";
    private static final String PASSWORD = "sa";

    public static Connection getConnection() throws SQLException {
        // Registrar el controlador JDBC
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Establecer la conexión
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try (Connection connection = getConnection()) {
            if (connection != null) {
                System.out.println("Conexión establecida con éxito.");
            } else {
                System.out.println("Falló la conexión.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}