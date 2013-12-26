package server.event_handler;

public class AEventHandler extends EventHandler {
    public String getHandle() {
        return "0x5001";
    }

    @Override
    public void printService(String name, String age) {
        System.out.println("A Service print called...");
        System.out.println("Param -> name :" + name + " age : " + age);
    }
}
