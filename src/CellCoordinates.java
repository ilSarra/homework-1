
public class CellCoordinates {
    private Cell cell;
    private int x;
    private int y;

    public CellCoordinates(Cell cell, int x, int y) {
        this.cell = cell;
        this.x = x;
        this.y = y;
    }

    public Cell getCell() {
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