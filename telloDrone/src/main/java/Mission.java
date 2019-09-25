
public abstract class Mission {
    // ABSTRACT METHOD
    abstract void  sendCommand(String[] requestArray) throws Exception ;
    abstract void writeCSV () throws Exception ;
    abstract String[] readCSV () throws Exception;




public final void performMission()throws Exception{
  //  String[] requestArray=null;
    writeCSV();
    String[] requestArray=readCSV();
    sendCommand(requestArray);
}
}
