package advisor;

import java.util.Scanner;

public class Controller {
    static boolean active;

    void startProgram() throws Exception {
        active = true;
        showMenu();
    }

    void showMenu() throws Exception {
        Scanner console = new Scanner(System.in);

        while(!console.hasNext("auth")) {
            if (console.nextLine().equals("exit")) {
                exit();
                break;
            }
            System.out.println("Please, provide access for application.");
        }

        while(active) {
            String[] commands = console.nextLine().split(" ");
            switch (commands[0]) {
                case "featured":
                    GetFeatured.getFeatured();
                    break;
                case "new":
                    GetNew.getNew();
                    break;
                case "categories":
                    GetCategories.getCategories();
                    break;
                case "playlists":
                    String categoryName = commands[1];
                    GetPlaylist.getPlaylist(categoryName);
                    break;
                case "auth":
                    Authorization auth = new Authorization();
                    auth.createServer();
                    auth.requestAuth();
                    break;
                case "exit":
                    exit();
                    break;
                default:
                    error();
            }
        }
    }

    void auth() {
        Authorization auth = new Authorization();
        auth.createServer();
        auth.requestAuth();
    }

    void error() {
        System.out.println("Unknown option, try again.");
    }

    void exit() {
        active = false;
        System.out.println("---GOODBYE!---");
    }
}
