



public class Mission1 extends Mission  {

    @Override
    public String[] readCSV () throws Exception {
        String[] requestArray;
        CSVReader csvReader = new CSVReader();
         requestArray= csvReader.read();
         return requestArray;

    }

    @Override
    public void writeCSV () throws Exception {
        CSVWriter csvWriter =  new CSVWriter();
        csvWriter.write();
    }


    @Override
    public void sendCommand (String[] requestArray) throws Exception{
         Communicator communicator= new Communicator();
        for(int i=0;i<requestArray.length;i++){
          String droneMessage=requestArray[i];
            System.out.println(droneMessage);
            communicator.sendCommand(droneMessage);
        }
    }
}