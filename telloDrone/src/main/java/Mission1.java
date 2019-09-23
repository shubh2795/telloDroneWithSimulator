



public class Mission1 implements Mission  {

    @Override
    public String[] sendCommand () throws Exception {
        CSVWriter csvWriter =  new CSVWriter();
        csvWriter.write();
        CSVReader csvReader = new CSVReader();
        String[] requestArray= csvReader.read();
        return requestArray;
    }
}