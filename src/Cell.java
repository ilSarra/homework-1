import java.util.LinkedList;

import javax.naming.LimitExceededException;

public class Cell {
    private LinkedList<Character> characters;
    private String terrain;
    private int x;
    private int y;

    public Cell(String terrain) {
        characters = new LinkedList<>();
        this.terrain = new String(terrain);
    }

    public int getOgresNumber() {
        int ogresCounter = 0;

        for(Character character : characters) {
            if(character instanceof Ogre) {
                ogresCounter++;
            }
        }

        return ogresCounter;
    }

    public int getElvesNumber() {
        int elvesCounter = 0;

        for(Character character : characters) {
            if(character instanceof Elf) {
                elvesCounter++;
            }
        }

        return elvesCounter;
    }

    public int getDwarfsNummber() {
        int dwarfsCounter = 0;

        for(Character character : characters) {
            if(character instanceof Dwarf) {
                dwarfsCounter++;
            }
        }

        return dwarfsCounter;
    }

    public double getDayDefence() {
        double totalDefence = 0;

        for(Character character : characters) {
            totalDefence += character.getDayDefence(terrain);
        }

        return totalDefence;
    }

    public double getNightDefence() {
        double totalDefence = 0;

        for(Character character : characters) {
            totalDefence += character.getNightDefence(terrain);
        }

        return totalDefence;
    }

    public double getDayAttack() {
        double totalAttack = 0;

        for(Character character : characters) {
            totalAttack += character.getDayAttack(terrain);
        }

        return totalAttack;
    }

    public double getNightAttack() {
        double totalAttack = 0;

        for(Character character : characters) {
            totalAttack += character.getNightAttack(terrain);
        }

        return totalAttack;
    }

    public void addCharacter(Character character) throws LimitExceededException {
        if(characters.size() >= 5) {
            throw new LimitExceededException();
        }

        this.characters.add(character);
    }

    public LinkedList<Character> getCharacters() {
        return new LinkedList<Character>(characters);
    }

    public void setCharacters(LinkedList<Character> characters) throws IllegalArgumentException {
        if(!isValid(characters)) {
            throw new IllegalArgumentException();
        }

        this.characters.addAll(characters);
    }

    public String getTerrain() {
        return new String(terrain);
    }

    public void setTerrain(String terrain) throws IllegalArgumentException {
        if(!isValid(terrain)) {
            throw new IllegalArgumentException();
        }

        this.terrain = new String(terrain);
    }

    private boolean isValid(String terrain) {
        if(terrain == null) {
            return false;
        }

        return terrain.equals("pianura") || terrain.equals("bosco") || terrain.equals("montagna");
    }

    private boolean isValid(LinkedList<Character> characters) {
        if(characters == null) {
            return false;
        }

        return characters.size() <= 5;
    }

    public String toString() {
        return terrain;
    }
}
