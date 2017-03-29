package comp.SidePanel;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import comp.BoardPanel.BoardPanelImp;
import edu.main.SnakeGame.SnakeGame;

public class SidePanelImp extends JPanel implements ISidePanelImp
{
	private SidePanelArch _arch;
	
	private static final long serialVersionUID = -40557434900946408L;

	/**
	 * The large font to draw with.
	 */
	private static final Font LARGE_FONT = new Font("Tahoma", Font.BOLD, 20);

	/**
	 * The medium font to draw with.
	 */
	private static final Font MEDIUM_FONT = new Font("Tahoma", Font.BOLD, 16);

	/**
	 * The small font to draw with.
	 */
	private static final Font SMALL_FONT = new Font("Tahoma", Font.BOLD, 12);

	/**
	 * The SnakeGame instance.
	 */
	private SnakeGame game;

    public SidePanelImp (){
    }

    public SidePanelImp(SnakeGame game) {
		this.game = game;

		setPreferredSize(new Dimension(350, BoardPanelImp.ROW_COUNT * BoardPanelImp.TILE_SIZE));
		setBackground(Color.BLACK);
	}

	private static final int STATISTICS_OFFSET_PLAYER1 = 100;

	private static final int STATISTICS_OFFSET_PLAYER2 = 250;

	private static final int CONTROLS_OFFSET = 400;

	private static final int MESSAGE_STRIDE = 30;

	private static final int SMALL_OFFSET = 30;

	private static final int LARGE_OFFSET = 50;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		/*
		 * Set the color to draw the font in to white.
		 */
		g.setColor(Color.WHITE);

		/*
		 * Draw the game name onto the window.
		 */
		g.setFont(LARGE_FONT);
		g.drawString("Snake Game", getWidth() / 2 - g.getFontMetrics().stringWidth("Snake Game") / 2, 50);

		/*
		 * Draw the categories onto the window.
		 */
		g.setFont(MEDIUM_FONT);
		g.drawString("Statistics Player1 (Green)", SMALL_OFFSET, STATISTICS_OFFSET_PLAYER1);
		g.drawString("Statistics Player2 (Yellow)", SMALL_OFFSET, STATISTICS_OFFSET_PLAYER2);
		g.drawString("Controls", SMALL_OFFSET, CONTROLS_OFFSET);

		/*
		 * Draw the category content onto the window.
		 */
		g.setFont(SMALL_FONT);

		// Draw the content for the statistics category.
		int drawY = STATISTICS_OFFSET_PLAYER1;
		g.drawString("Total Score: " + game.getScore(), LARGE_OFFSET, drawY += MESSAGE_STRIDE);
		g.drawString("Fruit Eaten: " + game.getFruitsEaten(), LARGE_OFFSET, drawY += MESSAGE_STRIDE);
		g.drawString("Fruit Score: " + game.getNextFruitScore(), LARGE_OFFSET, drawY += MESSAGE_STRIDE);

		drawY = STATISTICS_OFFSET_PLAYER2;
		g.drawString("Total Score: " + game.getScorePlayer2(), LARGE_OFFSET, drawY += MESSAGE_STRIDE);
		g.drawString("Fruit Eaten: " + game.getFruitsEatenPlayer2(), LARGE_OFFSET, drawY += MESSAGE_STRIDE);
		g.drawString("Fruit Score: " + game.getNextFruitScore(), LARGE_OFFSET, drawY += MESSAGE_STRIDE);
		// Draw the content for the controls category.
		drawY = CONTROLS_OFFSET;
		g.drawString("Use Keys W,S,A,D for Player-1", LARGE_OFFSET, drawY += MESSAGE_STRIDE);
		g.drawString("Use ArrowKeys Up,Down,Left,Right for Player-2", LARGE_OFFSET, drawY += MESSAGE_STRIDE);
		g.drawString("Move Up: W / Up Arrowkey", LARGE_OFFSET, drawY += MESSAGE_STRIDE);
		g.drawString("Move Down: S / Down Arrowkey", LARGE_OFFSET, drawY += MESSAGE_STRIDE);
		g.drawString("Move Left: A / Left Arrowkey", LARGE_OFFSET, drawY += MESSAGE_STRIDE);
		g.drawString("Move Right: D / Right Arrowkey", LARGE_OFFSET, drawY += MESSAGE_STRIDE);
		g.drawString("Pause Game: P", LARGE_OFFSET, drawY += MESSAGE_STRIDE);
	}

	public void setArch(SidePanelArch arch){
		_arch = arch;
	}
	public SidePanelArch getArch(){
		return _arch;
	}

	/*
  	  Myx Lifecycle Methods: these methods are called automatically by the framework
  	  as the bricks are created, attached, detached, and destroyed respectively.
	*/	
	public void init(){
	    //TODO Auto-generated method stub
	}
	public void begin(){
		//TODO Auto-generated method stub
	}
	public void end(){
		//TODO Auto-generated method stub
	}
	public void destroy(){
		//TODO Auto-generated method stub
	}
}