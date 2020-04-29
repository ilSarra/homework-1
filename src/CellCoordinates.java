
public class CellCoordinates {
    private GameCell cell;
    private int x;
    private int y;

    public CellCoordinates(GameCell cell, int x, int y) {
        this.cell = cell;
        this.x = x;
        this.y = y;
    }

    public GameCell getCell() {
        return cell;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}