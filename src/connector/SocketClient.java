package connector;

import java.io.*;
import java.net.Socket;

/**
 * @author Arthur Kupriyanov
 */
public class SocketClient {
    private static Socket clientSocket; //сокет для общения

    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет
    private final String META_DATA_IDENTIFICATION = "--#";
    String additionalData = META_DATA_IDENTIFICATION + "program";
    public String getResponse(String request) {
        request = request + " " + additionalData;

        try {
            try {
                // адрес - локальный хост, порт - 4004, такой же как у сервера
                clientSocket = new Socket("localhost", 4004); // этой строкой мы запрашиваем
                // читать соообщения с сервера
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                // писать туда же
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                out.write(request + "\n"); // отправляем сообщение на сервер
                out.flush();
                String responsePart;
                StringBuilder sb = new StringBuilder();
                while((responsePart = in.readLine())!=null){
                    sb.append(responsePart).append("\n");
                }

                return sb.toString();
            } finally { // в любом случае необходимо закрыть сокет и потоки
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        return null;
    }

}

