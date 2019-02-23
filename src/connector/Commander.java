package connector;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Arthur Kupriyanov
 */
public class Commander {

    public ArrayList<Map<String, String>> getNotificationsMapList(){

        SocketClient socketClient = new SocketClient();
        ArrayList<Map<String, String>> mapArray = new ArrayList<>();

        Object response = JSONValue.parse(socketClient.getResponse("note -s"));
        JSONObject jsonResponse = (JSONObject) response;

        for (Object key: jsonResponse.keySet()){
            JSONObject jsonNotification = (JSONObject) jsonResponse.get(key);
            Map<String, String> notification = new HashMap<>();

            for (Object innerKey: jsonNotification.keySet()){
                notification.put(String.valueOf(innerKey), String.valueOf(jsonNotification.get(innerKey)));
            }
            mapArray.add(notification);
        }

        return mapArray;
    }

    public ArrayList<String> getNotificationsList(){
        ArrayList<Map<String, String>> notifications = getNotificationsMapList();
        ArrayList<String> response = new ArrayList<>();

        for(Map<String, String> value: notifications){
            String message = null;
            String date = null;
            String authorID = null;
            String id = null;
            for(String key: value.keySet()){
                switch (key){
                    case "message":
                        message = value.get(key);
                        break;
                    case "date":
                        date = value.get(key);
                        break;
                    case "authorID":
                        authorID = value.get(key);
                        break;
                    case "id":
                        id = value.get(key);
                }
            }

            String s = message + "\n" +
                    "____________________\n" +
                    "Date: " + date + "\n" +
                    "AuthorID: " + authorID + "\n" +
                    "id: " + id;
            response.add(s);
        }

        return response;
    }
}
