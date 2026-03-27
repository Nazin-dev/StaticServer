package nazin.server;

import nazin.server.core.StaticServer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Server Started");
        int PORT = 8080;

        if (args.length > 0) {
            try {
                PORT = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Argumento inválido para porta, usando 8080");
            }
        }

        StaticServer.start(PORT);
    }
}
