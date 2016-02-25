import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CinemaModel {

    public void addHall(int nRows, int seats)throws SQLException {
        Connection c = DConnection.getConnection();
        PreparedStatement p = c.prepareStatement("INSERT INTO HALLS (NROWS, SEATS)" +
                "VALUES(?,?)");
        p.setInt(1, nRows);
        p.setInt(2, seats);
        p.executeUpdate();
        p.close();
    }

    public List<Halls> listHalls() throws SQLException {
        List<Halls> list = new ArrayList<Halls>();
        Connection c = DConnection.getConnection();
        PreparedStatement ps = c.prepareStatement("SELECT ID, NROWS, SEATS FROM HALLS");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            list.add(new Halls(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
        }
        rs.close();
        ps.close();
        return list;
    }

    List<Seances> find(String str) throws SQLException {
        Connection c = DConnection.getConnection();
        PreparedStatement find = c.prepareStatement("SELECT ID, STIME FROM SEANCES WHERE FILM=?");
        find.setString(1, str);
        ResultSet rs = find.executeQuery();
        List<Seances> result = new ArrayList<Seances>();
        while (rs.next()) {
            int id = rs.getInt(1);
            result.add(new Seances(0,null,null,0, 0,0));
        }
        return result;
    }

}
