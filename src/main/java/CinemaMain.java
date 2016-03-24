import java.sql.SQLException;

public class CinemaMain {
    public static void main(String[] args) throws SQLException {
        CreateDB db = new CreateDB();
        db.createTables();
    }
}
