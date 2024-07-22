package edu.jsp.btm.eca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserRepository repository;

	@PostMapping("/save")
	public ResponseEntity<ResponseStrcture<User>> saveUser(@RequestBody User user) {
		if (user.getPhoneNumber() > 999999999) {
			user = repository.save(user);

			ResponseStrcture<User> strcture = new ResponseStrcture<User>();
			strcture.setStatusCode(HttpStatus.CREATED.value());
			strcture.setMessage("User Created");
			strcture.setData(user);

			return new ResponseEntity<ResponseStrcture<User>>(strcture, HttpStatus.CREATED);
		}
		throw new InvaliedPhoneNumberException("Enter a Valied Phone Number");

	}
}
