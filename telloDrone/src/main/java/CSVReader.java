import java.io.BufferedReader;
import java.io.FileReader;




public class CSVReader {
    @SuppressWarnings("unchecked")
    public  String[] read() throws Exception {

        BufferedReader readCSV= new BufferedReader(new FileReader("Mission.csv"));
        String line;
        String[] requestArray =new String[0];
        while((line= readCSV.readLine()) != null){
            requestArray= line.split(",");

        }
        return requestArray;
    }


}