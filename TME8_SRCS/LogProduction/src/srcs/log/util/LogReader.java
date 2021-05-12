package srcs.log.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import srcs.log.DateLog;
import srcs.log.Log;
import srcs.log.Machine;

public class LogReader extends BufferedReader {
	private String name_machine;
	private BufferedReader in;

	public LogReader(String name_machine, BufferedReader in) {
		super(in);
		this.in = in;
		this.name_machine = name_machine;

	}

	public Log nextLog() {

		Log l = null;
		String str;

		try {
			while ((str = in.readLine()) != null) {
				l = new Log();
				int year = Parser.getYear(str);
				int month = Parser.getMonth(str);
				int day = Parser.getDay(str);
				int hour = Parser.getHour(str);
				int minute = Parser.getMinute(str);
				int second = Parser.getSecond(str);
				int millisecond = Parser.getMilliSecond(str);

				String level = Parser.getLevel(str);
				String nameClasse = Parser.getNameClasse(str);
				String message = Parser.getMessage(str);
				DateLog date = new DateLog();

				date.setAnnee(year);
				date.setMois(month);
				date.setJour(day);
				date.setHeure(hour);
				date.setMinute(minute);
				date.setSeconde(second);
				date.setMilliseconde(millisecond);

				l.setDatelog(date);
				l.setLevel(level);
				l.setNameClasse(nameClasse);
				l.setMessage(message);

				Machine machine = new Machine();
				machine.setNom(name_machine);

				l.setMachine(machine);
//				List<Log> logs = new ArrayList<>();
//				logs.add(l);

				machine.setLogs(l);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

		return l;
	}

}
