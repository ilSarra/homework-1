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
            int x, y = -1;
            String terrain = null;

            try {
                x = scanner.nextInt();
                y = scanner.nextInt();
                terrain = scanner.next();
            } catch(Exception exception) {
                throw new WrongFileFormatException();
            }

            map.setCell(x, y, new Cell(terrain));
        }

        scanner.close();

        return map;
    }
}
