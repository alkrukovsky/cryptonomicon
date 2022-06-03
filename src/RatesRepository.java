import java.io.*;
import java.util.*;


public class RatesRepository {

    public HashMap<String, String> getAvailableCurrencies(File dir) {
        HashMap<String,String> cryptaMap = new HashMap<String,String>();
        for(File item : dir.listFiles()) {
            try {
                FileReader fr = new FileReader(item);
                BufferedReader reader = new BufferedReader(fr);
                String line = reader.readLine();
                String[] crypta = line.split(",");
                cryptaMap.put(crypta[0], crypta[1]);
            }
            catch (IOException e) {

            }
        }
        return cryptaMap;
    }

    public HashMap<String, String> findRates(File dir, String [] params) {
        HashMap<String,String> cryptaMap = new HashMap<String,String>();
        for(File item : dir.listFiles()) {
            if (item.getName().equals(params[0])) {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(item));
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
                } catch (IOException e) {

                } break;
            }
        }
        return cryptaMap;
    }
}
