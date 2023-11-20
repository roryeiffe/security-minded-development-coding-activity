package com.revature;

import com.revature.controller.SystemUserController;
import com.revature.repository.SystemUserRepository;
import com.revature.service.SystemUserService;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080),0);

        new SystemUserController(server, new SystemUserService(new SystemUserRepository())).setEndpoints();

        server.start();
    }

}
