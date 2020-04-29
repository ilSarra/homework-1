import java.util.LinkedList;

public interface Map {
    public int getElvesNumber();
    public int getDwarfsNumber();
    public int getOgresNumber();
    public LinkedList<CellCoordinates> getMaxDayDefenceCell();
    public LinkedList<CellCoordinates> getMaxNightDefenceCell();
    public LinkedList<CellCoordinates> getMaxDayAttackCell();
    public LinkedList<CellCoordinates> getMaxNightAttackCell();
    public LinkedList<CellCoordinates> getMaxCharacterTypeCell();
}
