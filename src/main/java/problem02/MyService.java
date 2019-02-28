package problem02;

public class MyService extends BaseService {

	public void service(String state) {
		if(state=="낮") {
			String result = day();
			System.out.println(result);
		}else if(state=="오후"){
			String result = afternoon();
			System.out.println(result);
		}else if(state=="밤"){
			String result = night();
			System.out.println(result);
		}
	}
	
	public String day() {
		return "낮서비스시작";
	}
	public String afternoon() {
		return "오후서비스시작";
	}
	public String night() {
		return "밤서비스시작";
	}
}
