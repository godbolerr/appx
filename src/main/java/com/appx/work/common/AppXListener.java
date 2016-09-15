package com.appx.work.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AppXListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppXListener.class);

    // @JmsListener(destination = "someQueue")
    public void processMessage(String content) {
        LOGGER.info("Received contents from someQueue " + content);
    }

}
