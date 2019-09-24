



public class Mission1 implements Mission  {

    @Override
    public void sendCommand () throws Exception {
        CSVWriter csvWriter =  new CSVWriter();
        csvWriter.write();
        CSVReader csvReader = new CSVReader();
        String[] requestArray= csvReader.read();
        Communicator communicator= new Communicator();
        for(int i=0;i<requestArray.length;i++){
          String droneMessage=requestArray[i];
            System.out.println(droneMessage);
            communicator.sendCommand(droneMessage);
        }
    }
}