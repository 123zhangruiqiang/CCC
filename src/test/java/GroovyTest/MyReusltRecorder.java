package GroovyTest;

import java.util.List;

public class MyReusltRecorder {

	String script_name;
	List<MethodInfo> list;
	Boolean result;
	public String getScript_name(){
		
		return script_name;
	}
	
	public void set_script_name(String script_name){
		
		this.script_name=script_name;
		
	}

	public List<MethodInfo> getList() {
		return list;
	}

	public void setList(List<MethodInfo> list) {
		this.list = list;
	}

	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}
	
	public String toString(){
		
		return "MyResultRecorder [script_name=" + script_name + ", list=" + list + ", result=" + result + "]";
		
	}
}
