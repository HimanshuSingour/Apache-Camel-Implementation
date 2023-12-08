package com.apache.camel.Camel.Demo.process.impl;

import com.apache.camel.Camel.Demo.process.MessageProcessor;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BrowseCarFlagProcess implements MessageProcessor<Exchange> {
    @Override
    public void process(Exchange exchange) {


        public CarFlagResponseDTO carFlagBrowse (String eqpId, String stn333, String stnSt){
            CarFlagResponseDTO carFlagResponseDTO = new CarFlagResponseDTO();

            try {
                List<CarFlagData> carFlatDto = carFlagService.queryCarFlagTable(eqpId, stn333, stnSt);
                checkCarFlagEntries(carFlagResponseDTO, carFlatDto);
            } catch (Exception e) {
                carFlagResponseDTO.setMessages("Error Occurrred while processing the request, please contact adminstartion" + e.getMessage());
            }

            return carFlagResponseDTO;
        }

        private static void checkCarFlagEntries (CarFlagResponseDTO carFlagResponseDTO, List < CarFlagData > carFlagDto)
        {
            if (isNotEmpty(carFlagDto)) {
                carFlagResponseDTO.setCarFlagDataTable(carFlagDto);
                carFlagResponseDTO.setSuccessMessage("Messge car flag entry Displayed");
            } else {
                carFlagResponseDTO.setErrorMessage("Messge car flag entry not found");
            }
        }

    }
}
