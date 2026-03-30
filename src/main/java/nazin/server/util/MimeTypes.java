package nazin.server.util;

import java.util.HashMap;
import java.util.Map;

public class MimeTypes {
    public static final Map<String, String> MIME_TYPES = new HashMap<>();

    static  {
        MIME_TYPES.put("default", "application/octet-stream");
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
    }

    public static String get(String extension) {
        return MIME_TYPES.getOrDefault(extension, MIME_TYPES.get("default"));
    }
}
