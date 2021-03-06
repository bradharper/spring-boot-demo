package example.smallest.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class WelcomeController {

	@Value(value = "${test.property.message:Default}")
	String propertyMessage="-unset-";

	@Value("${TEST.ENVIRONMENT.MESSAGE:Default}")
	String environmentVariableMessage="-unset-";


	@RequestMapping(method = RequestMethod.GET, produces = {"application/json"})
	public @ResponseBody String helloWorld() {
		
		StringBuffer allEnvironmentVars = new StringBuffer();

		Map<String, String> env = System.getenv();
		for (String envName : env.keySet()) {
			allEnvironmentVars.append(envName).append(" = ").append(env.get(envName)).append("\n");
		}

		return "*** Spring Boot Demo ***\n\n\n" +allEnvironmentVars.toString();
	}
}
