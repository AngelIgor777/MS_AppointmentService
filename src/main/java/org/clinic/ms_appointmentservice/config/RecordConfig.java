package org.clinic.ms_appointmentservice.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RecordConfig {
    @Bean
    public ModelMapper modelMapperBean(){
        return new ModelMapper();
    }

}
