package tai65133085.thspringboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/")
	public String helloWorld() {
		return "Hello World! Chào mừng bạn đến với Spring Boot!";
	}
}