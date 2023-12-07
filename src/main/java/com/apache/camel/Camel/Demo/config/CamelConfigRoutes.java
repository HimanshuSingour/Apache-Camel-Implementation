package com.apache.camel.Camel.Demo.config;

import com.apache.camel.Camel.Demo.process.impl.GetStudentByNameAndEmailProcess;
import com.apache.camel.Camel.Demo.process.impl.GetStudentProcess;
import com.apache.camel.Camel.Demo.process.impl.MessageOccureProcess;
import com.apache.camel.Camel.Demo.process.impl.SaveStudentProcess;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


@Configuration
@Slf4j
public class CamelConfigRoutes extends RouteBuilder {

    @Autowired
    private SaveStudentProcess saveStudentProcess;

    @Autowired
    private GetStudentProcess getStudentProcess;

    @Autowired
    private GetStudentByNameAndEmailProcess getStudentByNameAndEmailProcess;

    @Autowired
    private MessageOccureProcess messageOccureProcess;


    @Override
    public void configure() {

        onException(Exception.class)
                .handled(true)
                .log(LoggingLevel.ERROR, log, "Exception occurred: ${exception.message}")
                .end();


        from("direct:saveStudent")
                .routeId("save_student")
                .bean(saveStudentProcess)
                .end();

        from("direct:getStudent")
                .routeId("get_student")
                .bean(getStudentProcess)
                .end();

        from("direct:getByParam")
                .routeId("get_name_email")
                .bean(getStudentByNameAndEmailProcess)
                .bean(messageOccureProcess)
                .end();

    }
}
