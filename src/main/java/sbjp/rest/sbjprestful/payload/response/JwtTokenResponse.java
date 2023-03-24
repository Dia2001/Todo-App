package sbjp.rest.sbjprestful.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class JwtTokenResponse {
	
	private String accessToken;
	
    private String tokenType = "Bearer";

    public JwtTokenResponse(String accessToken) {
        this.accessToken = accessToken;
    }
    
}
