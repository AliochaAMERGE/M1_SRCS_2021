package srcs.interpretor;

import java.util.List;
import java.io.PrintStream;

public class Echo implements Command {
	
	List<String> args;

	public Echo(List<String> args) {
		
		if(args.size() < 1) 
			 throw new IllegalArgumentException();
		
		this.args = args;
	}
	
	@Override
	public void execute(PrintStream out) {
		
        int size = args.size();
        for(int i = 1; i < size - 1; i++) {
            out.print(args.get(i)+" ");
        }
        out.print(args.get(size-1));
    }
}
