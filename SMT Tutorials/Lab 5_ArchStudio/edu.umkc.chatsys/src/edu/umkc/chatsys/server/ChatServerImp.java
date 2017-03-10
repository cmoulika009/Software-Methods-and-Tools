package edu.umkc.chatsys.server;

public class ChatServerImp implements IChatServerImp {
	private ChatServerArch _arch;

	public ChatServerImp() {
	}

	public void setArch(ChatServerArch arch) {
		_arch = arch;
	}

	public ChatServerArch getArch() {
		return _arch;
	}

	/*
	 * Myx Lifecycle Methods: these methods are called automatically by the
	 * framework as the bricks are created, attached, detached, and destroyed
	 * respectively.
	 */
	public void init() {
		// TODO Auto-generated method stub
	}

	public void begin() {
		// TODO Auto-generated method stub
	}

	public void end() {
		// TODO Auto-generated method stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	/*
	 * Implementation primitives required by the architecture
	 */

	public void sendMessage(String sender, String message) {
		// TODO Auto-generated method stub
		if (_arch.OUT_IChatListener != null) {
			_arch.OUT_IChatListener.messageSent(sender, message);
		}
	}
}