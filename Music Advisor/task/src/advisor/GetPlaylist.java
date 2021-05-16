package advisor;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class GetPlaylist extends GetRequest {
    public static JsonObject parseCategory() throws IOException, InterruptedException {

        HttpRequest request = GetRequest.getRequest(Config.RESOURCE + "/v1/browse/categories");

        HttpClient client = HttpClient.newBuilder().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return JsonParser.parseString(response.body()).getAsJsonObject();

    }


    public static void getPlaylist(String categoryName) throws Exception {

        String categoryID = "";

        var json = parseCategory();

        for (int i = 0; i < json.size(); i++) {

            var cat = json.get("categories").getAsJsonObject().get("items").getAsJsonArray();

            for (var element : cat) {
                var category = element.getAsJsonObject();
                if (categoryName.equals(category.get("name").getAsString())) {
                    categoryID = category.get("id").getAsString();
                    break;
                }
            }

        }

        //System.out.println(categoryID);
        String path = Config.RESOURCE + "/v1/browse/categories/" + categoryID + "/playlists";
        HttpRequest request = getRequest(path);
        List<SpotifyBeans> data = new ArrayList<>();

        try {
            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            //System.out.println(response.body());
            JsonObject jo = JsonParser.parseString(response.body()).getAsJsonObject();
            if (jo.toString().contains("404")) {
                System.out.println(jo.toString());
            } else {
                data = addPlaylists(response);
            }

        } catch (InterruptedException | IOException e) { System.out.println("Error response"); }

        data.forEach(System.out::println);
    }
}
