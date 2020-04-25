import java.util.ArrayList;
import java.util.LinkedList;

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

    public int getOgresNumber() {
        int ogresCounter = 0;

        for(ArrayList<Cell> row : cells) {
            for(Cell cell : row) {
                ogresCounter += cell.getOgresNumber();
            }
        }

        return ogresCounter;
    }

    public int getElfsNumber() {
        int elfsCounter = 0;

        for(ArrayList<Cell> row : cells) {
            for(Cell cell : row) {
                elfsCounter += cell.getElvesNumber();
            }
        }

        return elfsCounter;
    }

    public int getDwarfsNumber() {
        int dwarfsCounter = 0;

        for(ArrayList<Cell> row : cells) {
            for(Cell cell : row) {
                dwarfsCounter += cell.getDwarfsNummber();
            }
        }

        return dwarfsCounter;
    }

    public LinkedList<CellCoordinates> getMaxDayDefenceCell() {
        double maxDefence = 0;
        LinkedList<CellCoordinates> cellCoordinates = new LinkedList<>();

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Cell cell = cells.get(y).get(x);
                double dayDefence = cell.getDayDefence();

                if(dayDefence > maxDefence) {
                    cellCoordinates.clear();
                    cellCoordinates.add(new CellCoordinates(cell, x, y));
                }

                else if(dayDefence == maxDefence && maxDefence != 0) {
                    cellCoordinates.add(new CellCoordinates(cell, x, y));
                }
            }
        }

        return cellCoordinates;
    }

    public LinkedList<CellCoordinates> getMaxNightDefenceCell() {
        double maxDefence = 0;
        LinkedList<CellCoordinates> cellCoordinates = new LinkedList<>();

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Cell cell = cells.get(y).get(x);
                double nightDefence = cell.getNightDefence();

                if(nightDefence > maxDefence) {
                    cellCoordinates.clear();
                    cellCoordinates.add(new CellCoordinates(cell, x, y));
                }

                else if(nightDefence == maxDefence && maxDefence != 0) {
                    cellCoordinates.add(new CellCoordinates(cell, x, y));
                }
            }
        }

        return cellCoordinates;
    }

    public LinkedList<CellCoordinates> getMaxDayAttackCell() {
        double maxAttack = 0;
        LinkedList<CellCoordinates> cellCoordinates = new LinkedList<>();

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Cell cell = cells.get(y).get(x);
                double dayAttack = cell.getDayAttack();

                if(dayAttack > maxAttack) {
                    cellCoordinates.clear();
                    cellCoordinates.add(new CellCoordinates(cell, x, y));
                }

                else if(dayAttack == maxAttack && maxAttack != 0) {
                    cellCoordinates.add(new CellCoordinates(cell, x, y));
                }
            }
        }

        return cellCoordinates;
    }

    public LinkedList<CellCoordinates> getMaxNightAttackCell() {
        double maxAttack = 0;
        LinkedList<CellCoordinates> cellCoordinates = new LinkedList<>();

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Cell cell = cells.get(y).get(x);
                double nightAttack = cell.getNightAttack();

                if(nightAttack > maxAttack) {
                    cellCoordinates.clear();
                    cellCoordinates.add(new CellCoordinates(cell, x, y));
                }

                else if(nightAttack == maxAttack && maxAttack != 0) {
                    cellCoordinates.add(new CellCoordinates(cell, x, y));
                }
            }
        }

        return cellCoordinates;
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
