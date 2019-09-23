
import java.io.FileWriter;
public class CSVWriter
{
    //Delimiter used in CSV file
   private static final String COMMA_DELIMITER = ",";
    //private static final String NEW_LINE_SEPARATOR = "\n";

    @SuppressWarnings("unchecked")
    public  void write(String droneCommand ) throws Exception {
 try {
            FileWriter fileWriter = new FileWriter("Mission.csv");

            //Add a new line separator after the header

            //Write a new student object list to the CSV file
            fileWriter.append(droneCommand);
            fileWriter.append(COMMA_DELIMITER);


            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }

    }
}