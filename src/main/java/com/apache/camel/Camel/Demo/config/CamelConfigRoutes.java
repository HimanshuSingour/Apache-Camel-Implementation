package com.apache.camel.Camel.Demo.config;

import com.apache.camel.Camel.Demo.process.MessageProcessor;
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
    private GetStudentByNameAndEmailProcess getStudentByNameAndEmailProcess;

    @Autowired
    private GetStudentProcess getStudentProcess;

    @Autowired
    private MessageOccureProcess messageOccureProcess;

    @Autowired
    private SaveStudentProcess saveStudentProcess;


    @Override
    public void configure() {


        from("direct:saveEmailName")
                .routeId("save_by_email_and_name")
                .bean(getStudentByNameAndEmailProcess)
                .end();

        from("direct:getStudent")
                .routeId("get_student")
                .bean(getStudentProcess)
                .end();

        from("direct:getMessage")
                .routeId("get_message")
                .bean(messageOccureProcess)
                .end();

        from("direct:saveStudent")
                .routeId("save_student")
                .bean(saveStudentProcess)
                .end();


    }
}
