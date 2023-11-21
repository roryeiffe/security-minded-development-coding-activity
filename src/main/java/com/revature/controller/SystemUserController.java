package com.revature.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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


    // TODO Set up the endpoints for Login and Register using Gen AI:
    public void setEndpoints() {
    }


    // TODO: Implement the following method using Gen AI:
    /**
     * Registers the HTTP exchange.
     *
     * @param exchange the HTTP exchange to register
     */
    private void register(HttpExchange exchange) {
        
    }

    // TODO: Implement the following method using Gen AI:
    /**
     * Logs in the user.
     *
     * @param exchange the HTTP exchange object
     */
    private void login(HttpExchange exchange) {
        
    }
}
