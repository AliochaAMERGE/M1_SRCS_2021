package beans;

import java.util.List;

import javax.ejb.Remote;

import log.Log;
import log.Machine;

@Remote
public interface LogReceiverRemote {
	public void newLog(Log l);
	public void newLogAsync(Log l);
	public Machine[] getMachines();
	public Log[] getLogs();
	public List<Log> getLogsWithLevel(String level);
	public void mr_proper();
	public Log[] getLogsWithMachine(String name_machine);
}
