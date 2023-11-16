import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    public static void main(String[] args) throws IOException {
        String musicUrl = "https://ru.drivemusic.me/dl/uEqXswwBXrPYuwBj11HcVw/1700167473/download_music/2019/06/machine-gun-kelly-yungblud-travis-barker-i-think-im-okay.mp3"; // Замените на URL музыки

        String fileName = "MGK_I_Think_Im_Okay.mp3";
        String savePath = "C:\\Users\\Shor\\Documents\\Music\\" + fileName;
        downloadMusic(musicUrl, savePath);
    }

    private static void downloadMusic(String musicFileUrl, String savePath) throws IOException {
        URL url = new URL(musicFileUrl);
        URLConnection connection = url.openConnection();
        try (InputStream in = new BufferedInputStream(connection.getInputStream());
             FileOutputStream out = new FileOutputStream(savePath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }
}