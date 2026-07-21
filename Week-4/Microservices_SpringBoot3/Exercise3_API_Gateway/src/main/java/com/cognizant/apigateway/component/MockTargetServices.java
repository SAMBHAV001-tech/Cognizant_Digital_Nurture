package com.cognizant.apigateway.component;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

@Component
public class MockTargetServices implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        startServer(8085, "Customer Service Response: Welcome Customer!");
        startServer(8086, "Billing Service Response: Invoice #1001 Paid.");
    }

    private void startServer(int port, String responseText) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                byte[] bytes = responseText.getBytes();
                exchange.sendResponseHeaders(200, bytes.length);
                OutputStream os = exchange.getResponseBody();
                os.write(bytes);
                os.close();
            }
        });
        server.setExecutor(null);
        server.start();
    }
}
