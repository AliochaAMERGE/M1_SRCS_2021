package srcs.log;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class LogWatcher
 */
@Stateless
@LocalBean
public class LogWatcher implements LogWatcherRemote {

    /**
     * Default constructor. 
     */
    public LogWatcher() {
        // TODO Auto-generated constructor stub
    }

}
