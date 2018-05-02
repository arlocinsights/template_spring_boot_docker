package walletMonitor.dto;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDetail {

	private String reason_code;

	private String reason_desc;

	private String field;

	private String value;

	public ErrorDetail() {
		super();
	}

	public ErrorDetail(String errorDesc, String field) {
		super();
		this.setReason_desc(errorDesc);
		this.field = field;
	}

	public ErrorDetail(BaseResponse baseResponse, String field) {
		super();
		this.reason_code = baseResponse.getReason_code();
		this.reason_desc = baseResponse.getReason_desc();
		this.field = field;
	}

	public ErrorDetail(BaseResponse baseResponse, String field, String value) {
		super();
		this.reason_code = baseResponse.getReason_code();
		this.reason_desc = baseResponse.getReason_desc();
		this.field = field;
		this.value = value;
	}

	public ErrorDetail(BaseResponse baseResponse) {
		super();
		this.reason_code = baseResponse.getReason_code();
		this.reason_desc = baseResponse.getReason_desc();
	}

	public ErrorDetail(ObjectError err) {
		this.setReason_desc(err.getDefaultMessage());
		if (err instanceof FieldError) {
			FieldError fieldErr = (FieldError) err;
			this.field = fieldErr.getField();
		} else {
			this.field = err.getObjectName();
		}

	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getReason_desc() {
		return reason_desc;
	}

	public void setReason_desc(String reason_desc) {
		this.reason_desc = reason_desc;
	}

	public String getReason_code() {
		return reason_code;
	}

	public void setReason_code(String reason_code) {
		this.reason_code = reason_code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}