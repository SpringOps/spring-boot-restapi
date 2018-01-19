package com.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.demo.config.Constants;
import com.demo.config.DefaultProfileUtil;

@ComponentScan
@EnableAutoConfiguration(exclude = { LiquibaseAutoConfiguration.class})
@EnableResourceServer
public class DemoServiceApp {

	private static final Logger LOGGER = LoggerFactory.getLogger(DemoServiceApp.class);

	@Inject
	private Environment env;

	/**
	 * Initializes demo-service.
	 * <p>
	 * Spring profiles can be configured with a program arguments
	 * --spring.profiles.active=your-active-profile
	 * <p>
	 * You can find more information on how profiles work with JHipster on
	 * <a href=
	 * "http://jhipster.github.io/profiles/">http://jhipster.github.io/profiles/</a>.
	 */
	@PostConstruct
	public void initApplication() {
		LOGGER.info("Running with Spring profile(s) : {}", Arrays.toString(env.getActiveProfiles()));
		Collection<String> activeProfiles = Arrays.asList(env.getActiveProfiles());
		if (activeProfiles.contains(Constants.SPRING_PROFILE_DEVELOPMENT)
				&& activeProfiles.contains(Constants.SPRING_PROFILE_PRODUCTION)) {
			LOGGER.error("You have misconfigured your application! It should not run "
					+ "with both the 'dev' and 'prod' profiles at the same time.");
		}
		if (activeProfiles.contains(Constants.SPRING_PROFILE_DEVELOPMENT)
				&& activeProfiles.contains(Constants.SPRING_PROFILE_CLOUD)) {
			LOGGER.error("You have misconfigured your application! It should not"
					+ "run with both the 'dev' and 'cloud' profiles at the same time.");
		}
	}

	/**
	 * Main method, used to run the application.
	 *
	 * @param args
	 *            the command line arguments
	 * @throws UnknownHostException
	 *             if the local host name could not be resolved into an address
	 */
	public static void main(String[] args) throws UnknownHostException {
		SpringApplication app = new SpringApplication(DemoServiceApp.class);
		DefaultProfileUtil.addDefaultProfile(app);
		Environment env = app.run(args).getEnvironment();
		LOGGER.info(
				"\n----------------------------------------------------------\n\t"
						+ "Application '{}' is running! Access URLs:\n\t" + "Local: \t\thttp://127.0.0.1:{}\n\t"
						+ "External: \thttp://{}:{}\n----------------------------------------------------------",
				env.getProperty("spring.application.name"), env.getProperty("server.port"),
				InetAddress.getLocalHost().getHostAddress(), env.getProperty("server.port"));

		String configServerStatus = env.getProperty("configserver.status");
		LOGGER.info(
				"\n----------------------------------------------------------\n\t"
						+ "Config Server: \t{}\n----------------------------------------------------------",
				configServerStatus == null ? "Not found or not setup for this application" : configServerStatus);
	}
	 
}
