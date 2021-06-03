package com.example.videorental.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConstants {
	
    @Value("${app.contact-email-address}")
    public String CONTACT_EMAIL_ADDRESS;

    @Value("${app.url}")
    public String APP_URL;

    @Value("${app.name}")
    public String APP_NAME;

    @Value("${app.description}")
    public String APP_DESCRIPTION;

    @Value("${app.api-license-url}")
    public String APP_LICENSE_URL;

    @Value("${app.api-author}")
    public String APP_AUTHOR;

    @Value("${app.api-web-url}")
    public String APP_WEB_URL;

    @Value("${app.api-email}")
    public String APP_EMAIL;
    
    @Value("${app.api-version}")
    public String APP_VERSION;

    @Value("${app.product-name}")
    public String PRODUCT_NAME;

    private AppConstants() {
    }

}
