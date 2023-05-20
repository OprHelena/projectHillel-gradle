package ua.ithillet.lesson23;

import ua.ithillet.lesson22.HeroDto;
import ua.ithillet.lesson22.HeroService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerHandle implements Runnable {

    private final Socket socket;
    private final HeroService heroService;

    public ServerHandle(Socket socket, HeroService heroService) {
        this.socket = socket;
        this.heroService = heroService;
    }

    @Override
    public void run() {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String inputLine;

            while ((inputLine = in.readLine()) != null && !socket.isClosed()) {
                if (inputLine.equalsIgnoreCase("exit")) {
                    out.println("The server is shutting down...");
                    break;
                }
                String targetName = inputLine.trim();

                HeroDto heroDto = heroService.getHeroes()
                        .stream()
                        .filter(heroes -> heroes.getName().equalsIgnoreCase(targetName))
                        .findFirst()
                        .orElse(null);

                if (heroDto != null) {
                    out.println(heroDto.toString());
                } else {
                    out.println("Hero name not found.");
                }
            }
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
