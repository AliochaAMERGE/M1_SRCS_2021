package beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class SayHello
 */
@Stateless
@LocalBean
public class SayHello implements SayHelloRemote {

    /**
     * Default constructor. 
     */
    public SayHello() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public String hello(String name) {
    	return "Hello "+name;
    }

}
