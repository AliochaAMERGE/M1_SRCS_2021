package srcs.interpretor;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

public class MyClassLoader extends ObjectInputStream{

	protected MyClassLoader(InputStream is) throws IOException {
		super(is);
	}
	
	@Override
	protected Class<?> resolveClass(final ObjectStreamClass objectStreamClass) {
		try {
			return Class.forName(objectStreamClass.getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
			
	}

}