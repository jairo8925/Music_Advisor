package advisor;

import java.util.Scanner;

public class Controller {
    static boolean active;

    void startProgram() {
        active = true;
        showMenu();
    }

    void showMenu() {
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

    void displayFeatured() {
        System.out.println("---FEATURED---");
        System.out.println("Mellow Morning");
        System.out.println("Wake Up and Smell the Coffee");
        System.out.println("Monday Motivation");
        System.out.println("Songs to Sing in the Shower");
    }

    void displayNew() {
        System.out.println("---NEW RELEASES---");
        System.out.println("Mountains [Sia, Diplo, Labrinth]");
        System.out.println("Runaway [Lil Peep]");
        System.out.println("The Greatest Show [Panic! At The Disco]");
        System.out.println("All Out Life [Slipknot]");
    }

    void displayCategories() {
        System.out.println("---CATEGORIES---");
        System.out.println("Top Lists");
        System.out.println("Pop");
        System.out.println("Mood");
        System.out.println("Latin");
    }

    void displayPlaylist(String name) {
        System.out.println("---" + name.toUpperCase() + " PLAYLISTS---");
        System.out.println("Walk Like A Badass");
        System.out.println("Rage Beats");
        System.out.println("Arab Mood Booster");
        System.out.println("Sunday Stroll");
    }

    void error() {
        System.out.println("Unknown option, try again.");
    }

    void exit() {
        active = false;
        System.out.println("---GOODBYE!---");
    }
}
