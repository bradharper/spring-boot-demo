package example.smallest.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

	@Value(value = "${test.property.message}")
	String propertyMessage="-unset-";

	@Value("${TEST.ENVIRONMENT.MESSAGE}")
	String environmentVariableMessage="-unset-";

	@Value("${TEST.SECRET.ENVIRONMENT.MESSAGE}")
	String secretEnvironmentVariableMessage="-unset-";

	@RequestMapping(method = RequestMethod.GET, produces = {"application/json"})
	public @ResponseBody String helloWorld() {
		

		return "Spring Boot Demo - \n"+propertyMessage+"\n"+environmentVariableMessage;
	}
}
