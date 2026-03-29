package nazin.server.util;

import java.util.HashMap;
import java.util.Map;

public class FileIcons {
    public static final Map<String, String> FILE_TYPES = new HashMap<>();

    static  {
        // 📁 Default
        FILE_TYPES.put("default", "file-earmark");

        // 📄 Documentos
        FILE_TYPES.put("pdf", "file-earmark-pdf");
        FILE_TYPES.put("txt", "file-earmark-text");
        FILE_TYPES.put("md", "file-earmark-text");
        FILE_TYPES.put("rtf", "file-earmark-text");

        // 🧑‍💻 Código
        FILE_TYPES.put("js", "file-earmark-code");
        FILE_TYPES.put("ts", "file-earmark-code");
        FILE_TYPES.put("java", "file-earmark-code");
        FILE_TYPES.put("py", "file-earmark-code");
        FILE_TYPES.put("c", "file-earmark-code");
        FILE_TYPES.put("cpp", "file-earmark-code");
        FILE_TYPES.put("cs", "file-earmark-code");
        FILE_TYPES.put("php", "file-earmark-code");
        FILE_TYPES.put("rb", "file-earmark-code");
        FILE_TYPES.put("go", "file-earmark-code");
        FILE_TYPES.put("rs", "file-earmark-code");

        // 🌐 Web
        FILE_TYPES.put("html", "file-earmark-code");
        FILE_TYPES.put("css", "file-earmark-code");
        FILE_TYPES.put("json", "file-earmark-code");
        FILE_TYPES.put("xml", "file-earmark-code");
        FILE_TYPES.put("yaml", "file-earmark-code");
        FILE_TYPES.put("yml", "file-earmark-code");

        // 🖼️ Imagens
        FILE_TYPES.put("png", "file-earmark-image");
        FILE_TYPES.put("jpg", "file-earmark-image");
        FILE_TYPES.put("jpeg", "file-earmark-image");
        FILE_TYPES.put("gif", "file-earmark-image");
        FILE_TYPES.put("svg", "file-earmark-image");
        FILE_TYPES.put("webp", "file-earmark-image");
        FILE_TYPES.put("bmp", "file-earmark-image");

        // 🎵 Áudio
        FILE_TYPES.put("mp3", "file-earmark-music");
        FILE_TYPES.put("wav", "file-earmark-music");
        FILE_TYPES.put("ogg", "file-earmark-music");

        // 🎬 Vídeo
        FILE_TYPES.put("mp4", "file-earmark-play");
        FILE_TYPES.put("avi", "file-earmark-play");
        FILE_TYPES.put("mkv", "file-earmark-play");
        FILE_TYPES.put("mov", "file-earmark-play");

        // 📦 Compactados
        FILE_TYPES.put("zip", "file-earmark-zip");
        FILE_TYPES.put("rar", "file-earmark-zip");
        FILE_TYPES.put("7z", "file-earmark-zip");
        FILE_TYPES.put("tar", "file-earmark-zip");
        FILE_TYPES.put("gz", "file-earmark-zip");

        // 📊 Planilhas / Office
        FILE_TYPES.put("xls", "file-earmark-spreadsheet");
        FILE_TYPES.put("xlsx", "file-earmark-spreadsheet");
        FILE_TYPES.put("csv", "file-earmark-spreadsheet");

        FILE_TYPES.put("doc", "file-earmark-word");
        FILE_TYPES.put("docx", "file-earmark-word");

        FILE_TYPES.put("ppt", "file-earmark-ppt");
        FILE_TYPES.put("pptx", "file-earmark-ppt");

        // ⚙️ Executáveis / sistema
        FILE_TYPES.put("exe", "file-earmark-binary");
        FILE_TYPES.put("sh", "file-earmark-code");
        FILE_TYPES.put("bat", "file-earmark-code");
    }
    public static String getIcon(String extension, boolean isDirectory) {
        if (isDirectory) {
            return "folder-fill";
        } else {
            return FILE_TYPES.getOrDefault(extension, FILE_TYPES.get("default"));
        }
    }
}
