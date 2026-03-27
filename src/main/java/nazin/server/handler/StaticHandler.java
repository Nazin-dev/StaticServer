package nazin.server.handler;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class StaticHandler implements HttpHandler{
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String INDEX_BEGIN = """
                <!DOCTYPE HTML>
                <html lang="en">
                
                <head>
                    <meta charset="utf-8">
                    <style type="text/css">
                        :root {
                            color-scheme: light dark;
                        }
                    </style>
                    <title>Directory listing for {{FILE_PATH}}</title>
                </head>
                
                <body>
                    <h1>Directory listing for {{FILE_PATH}}</h1>
                    <hr>
                    <ul>
                    <li> 
                        <a href="../">
                            ../
                        </a>
                    </li>
                """;

        String INDEX_FILE_NAME = """
                <li>
                    <a href="{{FILE_NAME}}">
                        {{FILE_NAME}}
                    </a>
                </li>
                """;

        String INDEX_END = """
                </ul>
                    <hr>
                </body>
                
                </html>
                """;


        String urlPath = exchange.getRequestURI().getPath();
        File target = new File( System.getProperty("user.dir") + urlPath);

        if (target.isFile()) {
            byte[] fileBytes = java.nio.file.Files.readAllBytes(target.toPath());

            Map<String, String> MIME_TYPES = new HashMap<>();

            MIME_TYPES.put("default", "text/html; charset=UTF-8");
            MIME_TYPES.put("html", "text/html; charset=UTF-8");
            MIME_TYPES.put("js", "text/javascript");
            MIME_TYPES.put("css", "text/css");
            MIME_TYPES.put("png", "image/png");
            MIME_TYPES.put("jpg", "image/jpeg");
            MIME_TYPES.put("jpeg", "image/jpeg");
            MIME_TYPES.put("gif", "image/gif");
            MIME_TYPES.put("ico", "image/x-icon");
            MIME_TYPES.put("svg", "image/svg+xml");
            MIME_TYPES.put("py", "text/x-python");
            MIME_TYPES.put("java", "text/x-java-source");

            String fileName = target.getName();
            String fileExtension = "";

            int i = fileName.lastIndexOf('.');
            if (i > 0) {
                fileExtension = fileName.substring(i + 1).toLowerCase();
            }

            String contentType = MIME_TYPES.getOrDefault(fileExtension, MIME_TYPES.get("default"));

            exchange.getResponseHeaders().set("Content-Type", contentType);
            exchange.sendResponseHeaders(200, fileBytes.length);
            exchange.getResponseBody().write(fileBytes);
            exchange.getResponseBody().close();

        } else if (target.isDirectory()) {
            File[] files = target.listFiles();
            StringBuilder fileContent = new StringBuilder(INDEX_BEGIN.replace("{{FILE_PATH}}", urlPath));

            assert files != null;
            for (File file : files) {

                String link = file.getName();

                if(file.isDirectory()) link += "/";
                fileContent.append(INDEX_FILE_NAME.replace("{{FILE_NAME}}", link));
            }

            fileContent.append(INDEX_END.replace("{{FILE_NAME}}", urlPath));


            byte[] responseBytes = fileContent.toString().getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
            exchange.sendResponseHeaders(200, responseBytes.length);
            exchange.getResponseBody().write(responseBytes);
            exchange.getResponseBody().close();

        } else {

            String response = "<h1>404 - Not Found</h1>";
            byte[] bytes = response.getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().set("Content-Type", "text/html");
            exchange.sendResponseHeaders(404, bytes.length);
            exchange.getResponseBody().write(bytes);
            exchange.getResponseBody().close();
        }
    }


}
