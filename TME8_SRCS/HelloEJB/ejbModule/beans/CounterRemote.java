package beans;

import javax.ejb.Remote;

@Remote
public interface CounterRemote {

	int getValue();

	void increment();

	void decrement();

}
