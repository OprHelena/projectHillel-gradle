package ua.ithillet.lesson23;

import org.postgresql.ds.PGSimpleDataSource;
import ua.ithillet.lesson22.HeroFabric;
import ua.ithillet.lesson22.HeroService;

import javax.sql.DataSource;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HeroServer {

    private static DataSource dataSource() {
        PGSimpleDataSource ds = new PGSimpleDataSource();
        ds.setDatabaseName("heroes_adv");
        ds.setUser(PropertiesController.getEnvPropertyValue("user.name"));
        ds.setPassword("password");
        return ds;
    }

    public static void main(String[] args) throws IOException {

        DataSource dataSource = dataSource();
        HeroService heroService = HeroFabric.createService(dataSource);
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        try (ServerSocket serverSocket = new ServerSocket(8080)) {

            System.out.println("Connection successful");
            System.out.println("Listening on port 8080");

            while (true) {

                Socket socket = serverSocket.accept();
                executorService.execute(new ServerHandle(socket, heroService));
                System.out.println("Connection successful");
                System.out.println("Waiting for input ...");

            }
        } catch (IOException e) {
            throw new RuntimeException();
        } finally {
            executorService.shutdown();
        }
    }

}
