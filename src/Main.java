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
            System.out.println("Il file " + mapInputPath + " è di un formato non supportato oppure contiene un errore.");
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
            System.out.println("Il file " + charactersInputPath + " è di un formato non valido oppure contiene un errore.");
            return;
        }

        System.out.println(map);

        System.out.println("Numero di Elfi nella mappa: " + map.getElvesNumber());
        System.out.println("Numero di Nani nella mappa: " + map.getDwarfsNumber());
        System.out.println("Numero di Orchi nella mappa: " + map.getOgresNumber());
        System.out.println("Casella con maggior valore di difesa di giorno: " + map.getMaxDayDefenceCell());
        System.out.println("Casella con maggior valore di difesa di notte: " + map.getMaxNightDefenceCell());
        System.out.println("Casella con maggior valore di attacco di giorno: " + map.getMaxDayAttackCell());
        System.out.println("Casella con maggior valore di attacco di notte: " + map.getMaxNightAttackCell());
        System.out.println("Casella con maggior numero di pezzi dello stesso tipo: " + map.getMaxCharacterTypeCell());
    }
}
