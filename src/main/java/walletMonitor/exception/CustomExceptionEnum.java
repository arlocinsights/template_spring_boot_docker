package walletMonitor.exception;

import walletMonitor.dto.BaseResponse;

public enum CustomExceptionEnum {
	INVALID_REQUEST("400-001", "Invalid Request."),
	INVALID_REQUEST_PARAM("400-002", "Invalid Request Param."),
	
	VALIDATION_FAILURE("400-999", "Validation Failure"),
	
	
	INTERNAL_SYSTEM_EXCEPTION("900-001", "Internal system exception");
	
	private String exceptionCode;
	private String exceptionDescription;
	
	
	private CustomExceptionEnum(String exceptionCode, String exceptionDescription){
		this.setExceptionCode(exceptionCode);
		this.setExceptionDescription(exceptionDescription);
	}


	public String getExceptionDescription() {
		return exceptionDescription;
	}


	public void setExceptionDescription(String exceptionDescription) {
		this.exceptionDescription = exceptionDescription;
	}
	
	public BaseResponse	 getResponse(){
		
		BaseResponse ar = new BaseResponse();	
		ar.setReason_code(exceptionCode);
		ar.setReason_desc(exceptionDescription);
		ar.setSuccess(false);
		return ar;
	}

	public String getExceptionCode() {
		return exceptionCode;
	}


	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}
}
