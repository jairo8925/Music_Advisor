package advisor;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class GetFeatured extends GetRequest {
    public static void getFeatured() {
        String path = Config.RESOURCE + "/v1/browse/featured-playlists";
        HttpRequest request = getRequest(path);
        List<SpotifyBeans> data = null;

        try {
            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            data = addPlaylists(response);
        } catch (InterruptedException | IOException e) { System.out.println("Error response"); }

        assert data != null;
        data.forEach(System.out::println);
    }
}