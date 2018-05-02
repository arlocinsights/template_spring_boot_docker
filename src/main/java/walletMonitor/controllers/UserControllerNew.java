package walletMonitor.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import walletMonitor.dto.UserDTO;
import walletMonitor.dto.UserResponse;
import walletMonitor.exception.CustomExceptionEnum;
import walletMonitor.models.User;
import walletMonitor.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping(value = "/user")
public class UserControllerNew {

	@Autowired
	private UserService _userService;
	
	 private final Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/get-by-email", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<UserResponse> getByEmail(String email) {

		try {
			UserResponse res = _userService.getByEmail(email);

			HttpStatus statusCode = res.getSuccess().booleanValue() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
			ResponseEntity<UserResponse> response = new ResponseEntity<UserResponse>(res, statusCode);
			return response;

		} catch (Exception e) {
			// LOGGER.error("Request transaction id: " +
			// ThreadLocalManager.getTransactionId() + e);
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<UserResponse> getById(@PathVariable(value = "id") Long id) {
		  log.debug("debug level log");
		  log.info("info level log");
		  log.error("error level log");

		try {
			UserResponse res = _userService.getById(id);
			HttpStatus statusCode = res.getSuccess().booleanValue() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
			ResponseEntity<UserResponse> response = new ResponseEntity<UserResponse>(res, statusCode);
			return response;

		} catch (Exception e) {
			// LOGGER.error("Request transaction id: " +
			// ThreadLocalManager.getTransactionId() + e);
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<UserResponse> deleteById(@PathVariable(value = "id") Long id) {

		try {
			UserResponse res = _userService.deleteById(id);
			HttpStatus statusCode = res.getSuccess().booleanValue() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
			ResponseEntity<UserResponse> response = new ResponseEntity<UserResponse>(res, statusCode);
			return response;

		} catch (Exception e) {
			// LOGGER.error("Request transaction id: " +
			// ThreadLocalManager.getTransactionId() + e);
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<UserResponse> create(@Valid @RequestBody UserDTO detail) {

		try {
			UserResponse res;
			if (detail == null) {
				res = new UserResponse(CustomExceptionEnum.INVALID_REQUEST.getResponse());
				ResponseEntity<UserResponse> response = new ResponseEntity<UserResponse>(res, HttpStatus.BAD_REQUEST);
				return response;
			}
            res = _userService.create(detail);
			HttpStatus statusCode = res.getSuccess().booleanValue() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
			ResponseEntity<UserResponse> response = new ResponseEntity<UserResponse>(res, statusCode);
			return response;

		} catch (Exception e) {
			// LOGGER.error("Request transaction id: " +
			// ThreadLocalManager.getTransactionId() + e);
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<UserResponse> update(@Valid @RequestBody UserDTO detail) {

		try {
			UserResponse res;
			if (detail == null) {
				res = new UserResponse(CustomExceptionEnum.INVALID_REQUEST.getResponse());
				ResponseEntity<UserResponse> response = new ResponseEntity<UserResponse>(res, HttpStatus.BAD_REQUEST);
				return response;
			}
            res = _userService.update	(detail);
			HttpStatus statusCode = res.getSuccess().booleanValue() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
			ResponseEntity<UserResponse> response = new ResponseEntity<UserResponse>(res, statusCode);
			return response;

		} catch (Exception e) {
			// LOGGER.error("Request transaction id: " +
			// ThreadLocalManager.getTransactionId() + e);
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

} // class UserController
