import javax.naming.LimitExceededException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class GameMap implements Map {
    private int width;
    private int height;
    private ArrayList<ArrayList<GameCell>> cells;

    public GameMap(int width, int height) throws IllegalArgumentException {
        if(!(width > 0 && height > 0)) {
            throw new IllegalArgumentException();
        }

        this.width = width;
        this.height = height;
        cells = new ArrayList<>(height);

        for(int y = 0; y < height; y++) {
            ArrayList<GameCell> row = new ArrayList<>();

            for(int x = 0; x < width; x++) {
                row.add(null);
            }

            cells.add(row);
        }
    }

    public int getOgresNumber() {
        int ogresCounter = 0;

        for(ArrayList<GameCell> row : cells) {
            for(GameCell cell : row) {
                ogresCounter += cell.getOgresNumber();
            }
        }

        return ogresCounter;
    }

    public int getElvesNumber() {
        int elvesCounter = 0;

        for(ArrayList<GameCell> row : cells) {
            for(GameCell cell : row) {
                elvesCounter += cell.getElvesNumber();
            }
        }

        return elvesCounter;
    }

    public int getDwarfsNumber() {
        int dwarfsCounter = 0;

        for(ArrayList<GameCell> row : cells) {
            for(GameCell cell : row) {
                dwarfsCounter += cell.getDwarfsNumber();
            }
        }

        return dwarfsCounter;
    }

    public LinkedList<CellCoordinates> getMaxDayDefenceCell() {
        double maxDefence = 0;
        LinkedList<CellCoordinates> cellCoordinates = new LinkedList<>();

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                GameCell cell = cells.get(y).get(x);
                double dayDefence = cell.getDayDefence();

                if(dayDefence > maxDefence) {
                    maxDefence = dayDefence;
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
                GameCell cell = cells.get(y).get(x);
                double nightDefence = cell.getNightDefence();

                if(nightDefence > maxDefence) {
                    maxDefence = nightDefence;
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
                GameCell cell = cells.get(y).get(x);
                double dayAttack = cell.getDayAttack();

                if(dayAttack > maxAttack) {
                    maxAttack = dayAttack;
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
                GameCell cell = cells.get(y).get(x);
                double nightAttack = cell.getNightAttack();

                if(nightAttack > maxAttack) {
                    maxAttack = nightAttack;
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

    public LinkedList<CellCoordinates> getMaxCharacterTypeCell() {
        LinkedList<CellCoordinates> cellCoordinates = new LinkedList<>();
        int maxCounter = 0;

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                GameCell cell = cells.get(y).get(x);
                int[] counters = { cell.getOgresNumber(), cell.getDwarfsNumber(), cell.getElvesNumber() };
                Arrays.sort(counters);

                if(counters[2] > maxCounter) {
                    cellCoordinates.clear();
                    maxCounter = counters[2];
                    cellCoordinates.add(new CellCoordinates(cell, x, y));
                }

                else if(counters[2] == maxCounter) {
                    cellCoordinates.add(new CellCoordinates(cell, x, y));
                }
            }
        }

        return cellCoordinates;
    }

    public void addCharacterToCell(int x, int y, Character character) throws IllegalArgumentException, LimitExceededException {
        if(!isValid(x, y)) {
            throw new IllegalArgumentException();
        }

        cells.get(y).get(x).addCharacter(character);
    }

    public void setCell(int x, int y, GameCell cell) throws IllegalArgumentException {
        if(cell == null || !isValid(x, y)) {
            throw new IllegalArgumentException();
        }

        cells.get(y).set(x, cell);
    }

    public boolean isValid() {
        if(cells == null) {
            return false;
        }

        if(cells.contains(null)) {
            return false;
        }

        return true;
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < this.width && y >= 0 && y <= this.height;
    }

    public String toString() {
        String toString = "";

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                toString += "(" + x + ", " + y + ") " + cells.get(y).get(x) + "\n";
            }
        }

        return toString;
    }
}
