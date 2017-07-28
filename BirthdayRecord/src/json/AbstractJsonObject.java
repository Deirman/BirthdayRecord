package json;

import java.util.Date;

public class AbstractJsonObject {
	private  int code;  
    //msg  
    private String msg;  
  
    private Long time = new Date().getTime();


	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}  
	
}
