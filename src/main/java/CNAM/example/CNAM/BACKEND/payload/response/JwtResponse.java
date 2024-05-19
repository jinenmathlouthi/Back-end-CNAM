package CNAM.example.CNAM.BACKEND.payload.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private int id;
	private String username;

	public JwtResponse(String accessToken, int id, String username, List<String> roles) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

}
