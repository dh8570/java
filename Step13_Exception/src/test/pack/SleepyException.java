package test.pack;

/*
 * 개발자 정의 예외 클래스 생성
 */

public class SleepyException extends RuntimeException{
	public SleepyException(String msg) {
		super(msg);
	}
}
