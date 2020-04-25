import java.util.ArrayList;

public class Map {
    private int width;
    private int height;
    private ArrayList<ArrayList<Cell>> cells;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        cells = new ArrayList<>(height);

        for(ArrayList<Cell> row : cells) {
            row = new ArrayList<Cell>(width);
        }
    }

    public void setCell(int x, int y, Cell cell) throws IllegalArgumentException {
        if(cell == null || !isValid(x, y)) {
            throw new IllegalArgumentException();
        }

        cells.get(y).set(x, cell);
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < this.width && y >= 0 && y <= this.height;
    }
}
