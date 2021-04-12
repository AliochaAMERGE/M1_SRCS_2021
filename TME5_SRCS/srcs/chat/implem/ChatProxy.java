package srcs.chat.implem;

import java.util.List;

public class ChatProxy implements Chat {

	private String nom;
	private int port;
	private MessageReceiver msg;
	
	public ChatProxy(String nom, int port, MessageReceiver msg) {
		this.nom = nom;
		this.port = port;
		this.msg = msg;
	}
	
	@Override
	public boolean subscribe(String pseudo, String host, int port) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int send(String pseudo, String message) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> listChatter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void unsubscribe(String pseudo) {
		// TODO Auto-generated method stub

	}

}
