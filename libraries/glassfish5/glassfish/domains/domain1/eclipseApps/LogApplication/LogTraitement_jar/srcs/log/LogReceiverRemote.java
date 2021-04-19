package srcs.log;

import javax.ejb.Remote;

@Remote
public interface LogReceiverRemote {
	public void newLog(Log l);

	public void newLogAsync(Log l);

	public Machine[] getMachines();

	public Log[] getLogs();

	public Log[] getLogsWithLevel(String level);

	public void mr_proper();

	public Log[] getLogsWithMachine(String name_machine);
}
