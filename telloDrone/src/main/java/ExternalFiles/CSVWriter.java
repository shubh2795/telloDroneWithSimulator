    package ExternalFiles;
import  java.util.Scanner;
import java.io.FileWriter;
public class CSVWriter
{
    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";


    public  void write() throws Exception {
 try {
            Scanner cin= new Scanner(System.in);
            String fileName= "Mission.csv";
            FileWriter fileWriter = new FileWriter(fileName);
            System.out.println("Enter the no. of commands");
            int noOfCommands= cin.nextInt();
            for(int i=0; i<noOfCommands;i++){
                String droneCommand= cin.next();
                fileWriter.append(droneCommand);
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            fileWriter.flush();
            fileWriter.close();

            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }

    }
}