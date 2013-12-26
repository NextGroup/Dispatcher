package server.event_handler;

public class BEventHandler extends EventHandler {
    public String getHandle() {
        return "0x6001";
    }

    @Override
    public void printService(String nation, String city) {
        System.out.println("B Service print called...");
        System.out.println("Param -> nation :" + nation + " city : " + city);
    }
}
