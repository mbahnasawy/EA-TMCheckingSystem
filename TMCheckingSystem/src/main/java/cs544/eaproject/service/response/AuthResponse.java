package cs544.eaproject.service.response;

public class AuthResponse {
	private int status;
	private String token;
	private String message;
	

	public AuthResponse(String token, String message,int status) {
		this.status = status;
		this.token = token;
		this.message = message;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
