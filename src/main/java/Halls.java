
public class Halls {
    public final int id;
    public final int rows;
    public final int seats;

    public Halls(int id, int rows, int seats){
        this.id = id;
        this.rows = rows;
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "[" + rows + ", " + seats + "]";
    }
}
