package com.sdp.PP_SBProject;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer
{
	   @Override
	    public void addCorsMappings(CorsRegistry registry) 
	    {
	      registry.addMapping("/**") // Allow CORS 
	                .allowedOrigins("https://placementpulse-git-main-ksreevatsas-projects.vercel.app")
	                .allowedMethods("GET", "POST", "PUT", "DELETE")
	                .allowedHeaders("*")
	                .allowCredentials(true);
	    }
}
