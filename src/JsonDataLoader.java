import java.io.*;
import java.util.*;

public class JsonDataLoader {

    public HashMap<String, String> findRates(File dir, String [] params) {
        String fileName;
        HashMap<String,String> cryptaMap = new HashMap<String,String>();
        for(File item : dir.listFiles()) {
            fileName = item.getName().split("\\.")[0];
            if (fileName.equals(params[1])) {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(item));
                    int symbol = reader.read();
                    while (symbol != -1) {
                        char c = (char) symbol;
                        if ((c == ' ') || (c == '\t') || (c == '\n') || (symbol == 13)) {
                            symbol = reader.read();
                            continue;
                        }
                        System.out.println(c);
                        //System.out.println(symbol);
                        symbol = reader.read();
                    }
                    /*
                    String line = reader.readLine();
                    String[] crypta;
                    line = reader.readLine();
                    List<String> listOfCrypts = new ArrayList<String>();
                    listOfCrypts = Arrays.asList(params);
                    while (line != null) {
                        crypta = line.split(",");
                        if (listOfCrypts.contains(crypta[0]) && !(crypta[0].equals(params[0]))) {
                            cryptaMap.put(crypta[0], crypta[1]);
                        }
                        line = reader.readLine();
                    }
                    */
                } catch (IOException e) {

                } break;
            }
        }

        cryptaMap.put("1", "1");
        return cryptaMap;
    }
}
