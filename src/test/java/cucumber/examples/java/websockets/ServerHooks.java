package cucumber.examples.java.websockets;

import cucumber.api.java8.En;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class ServerHooks implements En {
    static final int PORT = 8887;

    private TemperatureServer temperatureServer;

    public ServerHooks(){
        Before(() -> {
            try {
                temperatureServer = new TemperatureServer(PORT).start();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        After(() -> {
            try {
                temperatureServer.stop();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
