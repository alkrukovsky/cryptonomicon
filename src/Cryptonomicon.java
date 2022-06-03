import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class Cryptonomicon {

    private RatesRepository ratesRepository;
    private JsonDataLoader jsonDataLoader;
    public Cryptonomicon(RatesRepository ratesRepository, JsonDataLoader jsonDataLoader) {
        this.ratesRepository = ratesRepository;
        this.jsonDataLoader = jsonDataLoader;
    }

    private void showAvaiableCurrencies(File dir) {
        HashMap cryptaMap = ratesRepository.getAvailableCurrencies(dir);
        cryptaMap.forEach((key, value) -> System.out.println("\"" + key + "\": \"" + value + "\""));
    }

    private void showHelp() {
        try {
            FileReader fr = new FileReader("help.txt");
            BufferedReader reader = new BufferedReader(fr);
            String line;
            while ((line = reader.readLine()) != null) System.out.println(line);
        }
        catch (IOException e) {

        }
    }

    private void showRates(File dir, String [] params) {
        // ratesRepository = getRepository - возвращает репозиторий в зависимости от ключа json или csv
        System.out.println("target: " + params[0] + ",");
        System.out.println("rates:");
        HashMap cryptaMap = ratesRepository.findRates(dir, params);
        cryptaMap.forEach((key, value) -> System.out.println("    \"" + key + "\": " + value + ","));
    }

    private void showJsonRates(File dir, String [] params) {
        System.out.println("target: " + params[1] + ",");
        System.out.println("rates:");
        HashMap cryptaMap = jsonDataLoader.findRates(dir, params);
        cryptaMap.forEach((key, value) -> System.out.println("    \"" + key + "\": " + value + ","));
    }

    public static void main(String [] args) {
        String[] params = args;
        if (params.length == 0) {
            System.out.println("Use KEY --help");
            return;
        }
        String command = params[0];
        String pathName = "../resources/csv";
        if (command.equals("--json")) {
            pathName = "../resources/json";
        }
        File dir = new File(pathName);
        Cryptonomicon cryptonomicon = new Cryptonomicon(new RatesRepository(), new JsonDataLoader());

        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();

        if (command.equals("--list")) {
            cryptonomicon.showAvaiableCurrencies(dir);
        } else if (command.equals("--help")) {
            cryptonomicon.showHelp();
        } else if (command.equals("--json")) {
            cryptonomicon.showJsonRates(dir, params);
        } else {
            cryptonomicon.showRates(dir, params);
        }
    }

    private static void printMenu() {
        System.out.println("1 - CSV-data");
        System.out.println("0 - JSON-data");
    }
}
