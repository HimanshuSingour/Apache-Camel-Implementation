package com.apache.camel.Camel.Demo.service.carbrowse;

import com.apache.camel.Camel.Demo.service.CarBrowseService;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarBrowseSeviceImpl implements CarBrowseService {

    @Autowired
    private ProducerTemplate producerTemplate;


    @Override
    public CarFlagResponseDTO carFlagBrowse(String eqpId, String stn333, String stnSt) {

        producerTemplate.start();

        Exchange result = producerTemplate.send("direct:getBrowse", exchange -> {
            exchange.getIn().setHeader("eqpId", eqpId);
            exchange.getIn().setHeader("stn333", stn333);
            exchange.getIn().setHeader("stnSt", stnSt);
        });

        producerTemplate.stop();


        return null;
    }
}
