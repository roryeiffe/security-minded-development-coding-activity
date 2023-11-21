package com.revature.controller;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.SystemUser;
import com.revature.service.SystemUserService;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;


public class SystemUserController {
    private HttpServer server;
    private ObjectMapper objectMapper = new ObjectMapper();
    private SystemUserService systemUserService;

    public SystemUserController(HttpServer server,SystemUserService systemUserService) {
        this.systemUserService = systemUserService;
        this.server = server;
    }

    public void setEndpoints() {
        // set up POST endpoints for login and register:
        server.createContext("/login", this::login);
        server.createContext("/register", this::register);
    }

    /**
     * Registers the HTTP exchange.
     *
     * @param exchange the HTTP exchange to register
     */
    private void register(HttpExchange exchange) throws IOException {
        // ensure that this is a POST request:
        if (exchange.getRequestMethod().equals("POST")) {

            // get the request body:
            String requestBody = new String(exchange.getRequestBody().readAllBytes());
            SystemUser user = objectMapper.readValue(requestBody, SystemUser.class);

            // register the user:
            boolean success = systemUserService.register(user);
            // return the response:
            if (success) {
                exchange.sendResponseHeaders(200, 0);
                exchange.close();
            }
            else {
                exchange.sendResponseHeaders(400, 0);
                exchange.close();
            }
        }
        else {
            exchange.sendResponseHeaders(405, 0);
            exchange.close();
        }
        
        
    }

    /**
     * Logs in the user.
     *
     * @param exchange the HTTP exchange object
     */
    private void login(HttpExchange exchange) throws IOException {
        // ensure this is POST method:
        if (exchange.getRequestMethod().equals("POST")) {
            // get the request body:
            String requestBody = new String(exchange.getRequestBody().readAllBytes());
            SystemUser user = objectMapper.readValue(requestBody, SystemUser.class);

            // authenticate the user:
            SystemUser authenticatedUser = systemUserService.login(user.getUsername(), user.getPassword());

            // return the response:
            if (authenticatedUser != null) {
                exchange.sendResponseHeaders(200, 0);
                // send the authenticated user:
                String response = objectMapper.writeValueAsString(authenticatedUser);
                exchange.getResponseBody().write(response.getBytes());
                exchange.close();
            }
            else {
                exchange.sendResponseHeaders(400, 0);
                exchange.close();
            }
        }
        else {
            exchange.sendResponseHeaders(405, 0);
            exchange.close();
        }
    }
}
