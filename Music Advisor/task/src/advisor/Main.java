package advisor;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        boolean running = true;
        boolean access = false;
        while (running) {
            String[] choice = console.nextLine().split(" ");
            switch (choice[0]) {
                case "featured":
                    if (isAuthorized(access)) {
                        displayFeatured();
                    }
                    break;
                case "new":
                    if (isAuthorized(access)) {
                        displayNew();
                    }
                    break;
                case "categories":
                    if (isAuthorized(access)) {
                        displayCategories();
                    }
                    break;
                case "playlists":
                    if (isAuthorized(access)) {
                        displayPlaylist(choice[1]);
                    }
                    break;
                case "auth":
                    access = true;
                    authorize();
                    break;
                case "exit":
                    running = false;
                    System.out.println("---GOODBYE!---");
                    break;
            }
        }
    }

    public static void authorize() {
        System.out.println("---SUCCESS---");
        System.out.println("https://accounts.spotify.com/authorize?client_id=fdea9ae7b29147fa98559b2030212918&redirect_uri=https://www.example.com&response_type=code");
    }

    public static boolean isAuthorized(boolean access) {
        if (!access) {
            System.out.println("Please, provide access for application.");
            return false;
        } else {
            return true;
        }
    }

    public static void displayFeatured() {
        System.out.println("---FEATURED---");
        System.out.println("Mellow Morning");
        System.out.println("Wake Up and Smell the Coffee");
        System.out.println("Monday Motivation");
        System.out.println("Songs to Sing in the Shower");
    }

    public static void displayNew() {
        System.out.println("---NEW RELEASES---");
        System.out.println("Mountains [Sia, Diplo, Labrinth]");
        System.out.println("Runaway [Lil Peep]");
        System.out.println("The Greatest Show [Panic! At The Disco]");
        System.out.println("All Out Life [Slipknot]");
    }

    public static void displayCategories() {
        System.out.println("---CATEGORIES---");
        System.out.println("Top Lists");
        System.out.println("Pop");
        System.out.println("Mood");
        System.out.println("Latin");
    }

    public static void displayPlaylist(String name) {
        System.out.println("---" + name.toUpperCase() + " PLAYLISTS---");
        System.out.println("Walk Like A Badass");
        System.out.println("Rage Beats");
        System.out.println("Arab Mood Booster");
        System.out.println("Sunday Stroll");
    }
}
