package sbjp.rest.sbjprestful.clientsever.response;

public class TokenReponse {
	
	private String accessToken;
	
    private String tokenType = "Bearer";

    public TokenReponse(String accessToken) {
        this.accessToken = accessToken;
    }

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
    
}
