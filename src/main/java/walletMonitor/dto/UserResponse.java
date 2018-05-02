package walletMonitor.dto;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse extends BaseResponse {

	private UserDTO userDTO;
	
	
	
	
	public UserDTO getUserDTO() {
		return userDTO;
	}
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	public UserResponse() {
		super();
	}
	
	public UserResponse(UserDTO userDTO){
		this.userDTO = userDTO;
		this.setSuccess(true);
	}
	
	public UserResponse(BaseResponse br) {
		this.setSuccess(br.getSuccess());
		this.setTransaction_id(br.getTransaction_id());
		this.setReason_code(br.getReason_code());
		this.setReason_desc(br.getReason_desc());
	}

	public UserResponse(BaseResponse br, Boolean success) {
		this.setSuccess(success);
		this.setTransaction_id(br.getTransaction_id());
		this.setReason_code(br.getReason_code());
		this.setReason_desc(br.getReason_desc());
	}
}
