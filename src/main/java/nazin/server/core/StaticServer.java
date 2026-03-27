package nazin.server.core;
import nazin.server.handler.StaticHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

public class StaticServer {
    public static void start(int PORT) throws IOException {


        HttpServer server = HttpServer.create(
            new InetSocketAddress(PORT), 0
        );

        server.createContext("/", new StaticHandler());

        server.start();

        System.out.println("Server started in: http://localhost:" + PORT);
    }
}
