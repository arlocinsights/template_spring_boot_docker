package walletMonitor.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

public class BaseResponse {

	private Boolean success;

	private String transaction_id;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String reason_code;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String reason_desc;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<ErrorDetail> errors;

	public BaseResponse() {
		transaction_id = walletMonitor.interceptor.ThreadLocalManager.getTransactionId();
	}

	public BaseResponse(BaseResponse baseResponse) {
		this.success = baseResponse.success;
		this.transaction_id = baseResponse.transaction_id;
		this.reason_code = baseResponse.reason_code;
		this.reason_desc = baseResponse.reason_desc;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getReason_code() {
		return reason_code;
	}

	public void setReason_code(String reason_code) {
		this.reason_code = reason_code;
	}

	public String getReason_desc() {
		return reason_desc;
	}

	public void setReason_desc(String reason_desc) {
		this.reason_desc = reason_desc;
	}

	public List<ErrorDetail> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorDetail> errors) {
		this.errors = errors;
	}

	
}