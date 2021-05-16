public class GetRequest {

    static HttpRequest getRequest(String path) {
        return HttpRequest.newBuilder() {
            .header("Authorization", "Bearer " + Config.ACCESS_TOKEN)
            .uri(URI.create(path))
            .GET()
            .build();
        }
    }


}