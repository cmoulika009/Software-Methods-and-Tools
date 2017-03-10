package edu.umkc.chatsys.client;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClientImp extends JFrame implements ActionListener, IChatClientImp {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7063596364285472880L;

	private ChatClientArch _arch;

	JTextArea transcript;
	JTextField entryField;
	JButton sendButton;
	StringBuffer transcriptBuf;

	public ChatClientImp() {
		super();
	}

	public void setArch(ChatClientArch arch) {
		_arch = arch;
	}

	public ChatClientArch getArch() {
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
		transcriptBuf = new StringBuffer();
		transcript = new JTextArea();
		entryField = new JTextField(20);
		sendButton = new JButton("Send");
		sendButton.addActionListener(this);

		this.setTitle(_arch.getMyxBrickItems().getBrickName().toString());
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add("Center", transcript);

		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		bottomPanel.add(entryField);
		bottomPanel.add(sendButton);
		this.getContentPane().add("South", bottomPanel);

		this.addWindowListener(new WindowEventHandler());

		this.setSize(500, 400);
		this.setVisible(true);
		validate();
		repaint();
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

	public void messageSent(String sender, String message) {
		// TODO Auto-generated method stub
		addMessageToTranscript(sender + ": " + message);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String text = entryField.getText();
		if (!text.equals("")) {
			_arch.OUT_IChat.sendMessage(getTitle(), text);
		}
	}

	public void addMessageToTranscript(String text) {
		transcriptBuf.append(text);
		transcriptBuf.append(System.getProperty("line.separator"));
		transcript.setText(transcriptBuf.toString());
	}
}

class WindowEventHandler extends WindowAdapter {
	public void windowClosing(WindowEvent evt) {
		System.exit(0);
	}
}