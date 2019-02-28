package problem03;

public class MyStack {
	
	private String[] buffer;
	int i=0;

	public MyStack( int size ) {
		buffer=new String[size];
	}
	
	private void sizeUp() {
		String temp[]=buffer;
		buffer=new String[i+1];
		for(int j=0;j<temp.length;j++) {
			buffer[j]=temp[j];
		}
	}
	
	public void push(String item) {
		if(i==buffer.length) {
			sizeUp();
		}
		buffer[i]=item;
		i++;
	}

	public String pop() {
		i--;
		if(i==-1) {
			return null;
		}
		return buffer[i];
	}

	public boolean isEmpty() {
		if(i>0) {
			return false;
		}else {
			i=0;
			return true;
		}
	}
	
	public int size() {
		return i;
	}
}