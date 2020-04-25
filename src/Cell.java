import java.util.LinkedList;

import javax.naming.LimitExceededException;

public class Cell {
    private LinkedList<Character> characters;
    private String terrain;

    public Cell() {
        characters = new LinkedList<>();
        terrain = null;
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
}
