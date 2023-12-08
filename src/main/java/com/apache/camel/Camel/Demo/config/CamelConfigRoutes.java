package com.apache.camel.Camel.Demo.config;

import com.apache.camel.Camel.Demo.process.impl.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


@Configuration
@Slf4j
public class CamelConfigRoutes extends RouteBuilder {

    @Autowired
    private BrowseCarFlagProcess browseCarFlagProcess;


    @Override
    public void configure() {


        from("direct:getBrowse")
                .routeId("browse")
                .bean(browseCarFlagProcess)
                .end();



    }
}
