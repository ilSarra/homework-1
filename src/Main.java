import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        String mapInputPath = "input/mappa.txt";
        String charactersInputPath = "input/pedine.txt";

        if(args.length == 2) {
            mapInputPath = args[1];
            charactersInputPath = args[0];
        }

        File mapInput = new File(mapInputPath);
        File charactersInput = new File(charactersInputPath);
        Map map = null;

        try {
            map = MapBuilder.buildMap(mapInput);
        } catch(IllegalArgumentException exception) {
            System.out.println("Si è verificato un errore nella creazione della mappa.");
            return;
        } catch(FileNotFoundException exception) {
            System.out.println("File " + mapInputPath + " non trovato.");
            return;
        } catch(WrongFileFormatException exception) {
            System.out.println("Il file " + mapInputPath + " è di un formato non valido");
            return;
        }

        try {
            MapBuilder.addCharacters(map, charactersInput);
        } catch(IllegalArgumentException exception) {
            System.out.println("Si è verificato un errore nel posizionamento dei personaggi nella mappa di gioco.");
            return;
        } catch(FileNotFoundException exception) {
            System.out.println("File " + charactersInputPath + " non trovato.");
            return;
        } catch(WrongFileFormatException exception) {
            System.out.println("Il file " + charactersInputPath + " è di un formato non valido");
            return;
        }

        System.out.println(map);

        System.out.println("Casella con maggior valore di difesa di giorno: " + map.getMaxDayDefenceCell());
    }
}
