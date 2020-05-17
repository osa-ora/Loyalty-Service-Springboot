package osa.ora.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class MyErrorController implements ErrorController {

	private final static String ERROR_PATH = "/error";
	/**
	 * Return JSON response with status code of the error
	 * @param request
	 * @return
	 */
	@RequestMapping(value = ERROR_PATH, produces = "application/json")
	@ResponseBody
	public ResponseEntity<?> error(HttpServletRequest request) {
		HttpStatus status = getStatus(request);
		ResponseEntity<?> response=new ResponseEntity("{\"Status\" : \""+status+"\"}",HttpStatus.INTERNAL_SERVER_ERROR);
		return response;
	}

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}
	/**
	 * Create HTTPStatus from the request statusCode
	 * @param request
	 * @return HttpStatus
	 * Copied from org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController 
	 */
	private HttpStatus getStatus(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if (statusCode == null) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		try {
			return HttpStatus.valueOf(statusCode);
		}
		catch (Exception ex) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
	}
}
