package com.azoth.jsf23;

import org.glassfish.internal.embedded.EmbeddedDeployer;
import org.glassfish.internal.embedded.Server;

public class Aplicacion {

    public static void main(String... args) throws Exception{
        Server.Builder builder = new Server.Builder("test");

        Server server = builder.build();
        server.createPort(9995);
        server.start();


    }


}
