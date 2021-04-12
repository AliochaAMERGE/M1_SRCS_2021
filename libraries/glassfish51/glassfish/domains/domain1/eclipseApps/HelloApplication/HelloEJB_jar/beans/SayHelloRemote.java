package beans;

import javax.ejb.Remote;

@Remote
public interface SayHelloRemote {

	String hello(String name);

}
