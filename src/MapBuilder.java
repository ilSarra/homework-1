import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MapBuilder {
    public static Map buildMap(File inputFile) throws IllegalArgumentException, FileNotFoundException, WrongFileFormatException {
        if(inputFile == null) {
            throw new IllegalArgumentException();
        }

        if(!inputFile.exists() || !inputFile.canRead()) {
            throw new FileNotFoundException();
        }

        Scanner scanner = new Scanner(inputFile);
        Map map = null;
        int width = 0;
        int height = 0;

        try {
            width = scanner.nextInt();
            height = scanner.nextInt();
        } catch(Exception exception) {
            throw new WrongFileFormatException();
        }

        map = new Map(width, height);

        for(int i = 0; i < width * height; i++) {
            try {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                String terrain = scanner.next();

                map.setCell(x, y, new Cell(terrain));
            } catch(Exception exception) {
                throw new WrongFileFormatException();
            }
        }

        scanner.close();;

        return map;
    }

    public static void addCharacters(Map map, File inputFile) throws IllegalArgumentException, FileNotFoundException, WrongFileFormatException {
        if(inputFile == null || map == null) {
            throw new IllegalArgumentException();
        }

        if(!inputFile.exists() || !inputFile.canRead()) {
            throw new FileNotFoundException();
        }

        Scanner scanner = new Scanner(inputFile);

        while(scanner.hasNextLine()) {
            try {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                String type = scanner.next();

                Character character = null;

                switch (type.toLowerCase()) {
                    case "orco":
                        character = new Ogre();
                        break;
                    case "nano":
                        character = new Dwarf();
                        break;
                    case "elfo":
                        character = new Elf();
                        break;
                }

                if(character == null) {
                    throw new WrongFileFormatException();
                }

                map.addCharacterToCell(x, y, character);
            } catch(Exception exception) {
                throw new WrongFileFormatException();
            }
        }
    }
}
