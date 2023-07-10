package pom.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseDto {
	String msg;
	
	public ResponseDto(String msg) {
		this.msg = msg;
	}

}
