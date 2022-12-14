package com.mockwebserver.webclient.webclientproperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Properties {
    @Value("${web-client-config.uri}")
    public String uri;

}
