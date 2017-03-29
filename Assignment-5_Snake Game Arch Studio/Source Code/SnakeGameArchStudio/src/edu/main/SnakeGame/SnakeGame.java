package edu.main.SnakeGame;

/***********************************************************************************************
 * Program Name : Snake Game
 * 
 * Modification History:
 * 
 * Author                        Date            Version              Remarks
 * ---------------------     --------------    ------------        -------------
 *  Moulika Chadalavada       15-Mar2017         1.1vc        Changes as part of SMT Assignment
 *  
 *  
 ************************************************************************************************/

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JFrame;

//1.1vc starts
import comp.BoardPanel.BoardPanelImp;
import comp.SidePanel.SidePanelImp;
import comp.SnakeGame.SnakeGameArch;
import edu.game.constants.Direction;
import edu.game.constants.TileType;

/**
 * The {@code SnakeGame} class is responsible for handling much of the game's
 * logic.
 * 
 * @author Brendan Jones
 *
 */
public class SnakeGame extends JFrame {

	SnakeGameArch _arch;
	/**
	 * The Serial Version UID.
	 */
	private static final long serialVersionUID = 6678292058307426314L;

	/**
	 * The number of milliseconds that should pass between each frame.
	 */
	private static final long FRAME_TIME = 1000L / 50L;

	/**
	 * The minimum length of the snake. This allows the snake to grow right when
	 * the game starts, so that we're not just a head moving around on the
	 * board.
	 */
	private static final int MIN_SNAKE_LENGTH = 5;

	/**
	 * The maximum number of directions that we can have polled in the direction
	 * list.
	 */
	private static final int MAX_DIRECTIONS = 3;

	/**
	 * The BoardPanel instance.
	 */
	private BoardPanelImp board;// 1.1vc

	/**
	 * The SidePanel instance.
	 */
	private SidePanelImp side;// 1.1vc

	/**
	 * The random number generator (used for spawning fruits).
	 */
	private Random random;

	/**
	 * The Clock instance for handling the game logic.
	 */
	//private ClockImp logicTimer;// 1.1vc

	/**
	 * Whether or not we're running a new game.
	 */
	private boolean isNewGame;

	/**
	 * Whether or not the game is over.
	 */
	private boolean isGameOver;

	private boolean isGameOver2;

	/**
	 * Whether or not the game is paused.
	 */
	private boolean isPaused;

	/**
	 * The list that contains the points for the snake.
	 */
	private LinkedList<Point> snake;

	private LinkedList<Point> snakePlayer2;// 1.1vc

	/**
	 * The list that contains the queued directions.
	 */
	private LinkedList<Direction> directions;

	private LinkedList<Direction> directionsPlayer2;// 1.1vc

	/**
	 * The current score.
	 */
	private int score;

	private int scorePlayer2;// 1.1vc

	/**
	 * The number of fruits that we've eaten.
	 */
	private int fruitsEaten;

	private int fruitsEatenPlayer2;// 1.1vc

	/**
	 * The number of points that the next fruit will award us.
	 */
	private int nextFruitScore;

	/**
	 * Creates a new SnakeGame instance. Creates a new window, and sets up the
	 * controller input.
	 */
	public SnakeGame() {
		super("Snake Remake");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		/*
		 * Initialize the game's panels and add them to the window.
		 */
		this.board = new BoardPanelImp(this); // 1.1vc
		this.side = new SidePanelImp(this); // 1.1vc

		add(board, BorderLayout.CENTER);
		add(side, BorderLayout.EAST);

		/*
		 * Adds a new key listener to the frame to process input.
		 */
		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {

				/*
				 * If the game is not paused, and the game is not over...
				 * 
				 * Ensure that the direction list is not full, and that the most
				 * recent direction is adjacent to North before adding the
				 * direction to the list.
				 */

				// Key W to move Player1 Snake direction
				case KeyEvent.VK_W:
					if (!isPaused && !isGameOver) {
						if (directions.size() < MAX_DIRECTIONS) {
							Direction last = directions.peekLast();
							if (last != Direction.South && last != Direction.North) {
								directions.addLast(Direction.North);
							}
						}
					}
					break;

				// Keyboard UP arrow to move Player2 Snake direction
				case KeyEvent.VK_UP:

					if (!isPaused && !isGameOver2) {
						if (directionsPlayer2.size() < MAX_DIRECTIONS) {
							Direction last = directionsPlayer2.peekLast();
							if (last != Direction.South && last != Direction.North) {
								directionsPlayer2.addLast(Direction.North);
							}
						}
					}
					break;

				/*
				 * If the game is not paused, and the game is not over...
				 * 
				 * Ensure that the direction list is not full, and that the most
				 * recent direction is adjacent to South before adding the
				 * direction to the list.
				 */

				// Key S to move Player1 Snake direction

				case KeyEvent.VK_S:
					if (!isPaused && !isGameOver) {
						if (directions.size() < MAX_DIRECTIONS) {
							Direction last = directions.peekLast();
							if (last != Direction.North && last != Direction.South) {
								directions.addLast(Direction.South);
							}
						}
					}
					break;

				// Keyboard DOWN arrow to move Player2 Snake direction

				case KeyEvent.VK_DOWN:
					if (!isPaused && !isGameOver2) {
						if (directionsPlayer2.size() < MAX_DIRECTIONS) {
							Direction last = directionsPlayer2.peekLast();
							if (last != Direction.North && last != Direction.South) {
								directionsPlayer2.addLast(Direction.South);
							}
						}
					}
					break;

				/*
				 * If the game is not paused, and the game is not over...
				 * 
				 * Ensure that the direction list is not full, and that the most
				 * recent direction is adjacent to West before adding the
				 * direction to the list.
				 */

				// Key A to move Player1 Snake direction

				case KeyEvent.VK_A:
					if (!isPaused && !isGameOver) {
						if (directions.size() < MAX_DIRECTIONS) {
							Direction last = directions.peekLast();
							if (last != Direction.East && last != Direction.West) {
								directions.addLast(Direction.West);
							}
						}
					}
					break;

				// Keyboard LEFT arrow to move Player2 Snake direction

				case KeyEvent.VK_LEFT:
					if (!isPaused && !isGameOver2) {
						if (directionsPlayer2.size() < MAX_DIRECTIONS) {
							Direction last = directionsPlayer2.peekLast();
							if (last != Direction.East && last != Direction.West) {
								directionsPlayer2.addLast(Direction.West);
							}
						}
					}
					break;

				/*
				 * If the game is not paused, and the game is not over...
				 * 
				 * Ensure that the direction list is not full, and that the most
				 * recent direction is adjacent to East before adding the
				 * direction to the list.
				 */

				// Key D to move Player1 Snake direction

				case KeyEvent.VK_D:
					if (!isPaused && !isGameOver) {
						if (directions.size() < MAX_DIRECTIONS) {
							Direction last = directions.peekLast();
							if (last != Direction.West && last != Direction.East) {
								directions.addLast(Direction.East);
							}
						}
					}
					break;

				// Keyboard RIGHT arrow to move Player2 Snake direction

				case KeyEvent.VK_RIGHT:
					if (!isPaused && !isGameOver2) {
						if (directionsPlayer2.size() < MAX_DIRECTIONS) {
							Direction last = directionsPlayer2.peekLast();
							if (last != Direction.West && last != Direction.East) {
								directionsPlayer2.addLast(Direction.East);
							}
						}
					}
					break;

				/*
				 * If the game is not over, toggle the paused flag and update
				 * the logicTimer's pause flag accordingly.
				 */
				case KeyEvent.VK_P:
					if (!isGameOver || !isGameOver2) {
						isPaused = !isPaused;
						_arch.OUT_ClockInterface.setPaused(isPaused);
					}
					break;

				/*
				 * Reset the game if one is not currently in progress.
				 */
				case KeyEvent.VK_ENTER:
					if (isNewGame || isGameOver || isGameOver2) {
						resetGame();
					}
					break;
				}
			}

		});

		/*
		 * Resize the window to the appropriate size, center it on the screen
		 * and display it.
		 */
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * Starts the game running.
	 */
	public void startGame() {
		/*
		 * Initialize everything we're going to be using.
		 */
		this.random = new Random();
		this.snake = new LinkedList<>();
		this.snakePlayer2 = new LinkedList<>();// 1.1vc
		this.directions = new LinkedList<>();
		this.directionsPlayer2 = new LinkedList<>();// 1.1vc
		//this.logicTimer = new ClockImp(9.0f);
		this.isNewGame = true;

		// Set the timer to paused initially.
		_arch.OUT_ClockInterface.setPaused(true);

		/*
		 * This is the game loop. It will update and render the game and will
		 * continue to run until the game window is closed.
		 */
		while (true) {
			// Get the current frame's start time.
			long start = System.nanoTime();

			// Update the logic timer.
			_arch.OUT_ClockInterface.update();

			/*
			 * If a cycle has elapsed on the logic timer, then update the game.
			 */
			if (_arch.OUT_ClockInterface.hasElapsedCycle()) {
				updateGame();
				updateGamePlayer2();
			}

			// Repaint the board and side panel with the new content.
			board.repaint();
			side.repaint();

			/*
			 * Calculate the delta time between since the start of the frame and
			 * sleep for the excess time to cap the frame rate. While not
			 * incredibly accurate, it is sufficient for our purposes.
			 */
			long delta = (System.nanoTime() - start) / 1000000L;
			if (delta < FRAME_TIME) {
				try {
					Thread.sleep(FRAME_TIME - delta);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Updates the game's logic.
	 */
	private void updateGame() {
		/*
		 * Gets the type of tile that the head of the snake collided with. If
		 * the snake hit a wall, SnakeBody will be returned, as both conditions
		 * are handled identically.
		 */
		TileType collision = updateSnake();

		/*
		 * Here we handle the different possible collisions.
		 * 
		 * Fruit: If we collided with a fruit, we increment the number of fruits
		 * that we've eaten, update the score, and spawn a new fruit.
		 * 
		 * SnakeBody: If we collided with our tail (or a wall), we flag that the
		 * game is over and pause the game.
		 * 
		 * If no collision occurred, we simply decrement the number of points
		 * that the next fruit will give us if it's high enough. This adds a bit
		 * of skill to the game as collecting fruits more quickly will yield a
		 * higher score.
		 */
		if (collision == TileType.Fruit) {
			fruitsEaten++;
			score += nextFruitScore;
			spawnFruit();
		} else if (collision == TileType.SnakeBody) {
			isGameOver = true;
			_arch.OUT_ClockInterface.setPaused(true);
		}
		// 1.1vc starts
		else if (collision == TileType.SnakeBody2) {
			isGameOver = true;
			_arch.OUT_ClockInterface.setPaused(true);
		} // 1.1vc ends
		else if (nextFruitScore > 10) {
			nextFruitScore--;
		}
		// 1.1vc starts
		else if (fruitsEaten == 5) {
			isGameOver2 = true;
			_arch.OUT_ClockInterface.setPaused(true);
		}
		// 1.1vc ends
	}

	/**
	 * Updates the snake's position and size.
	 * 
	 * @return Tile tile that the head moved into.
	 */
	@SuppressWarnings("static-access")
	private TileType updateSnake() {

		/*
		 * Here we peek at the next direction rather than polling it. While not
		 * game breaking, polling the direction here causes a small bug where
		 * the snake's direction will change after a game over (though it will
		 * not move).
		 */
		Direction direction = directions.peekFirst();

		/*
		 * Here we calculate the new point that the snake's head will be at
		 * after the update.
		 */
		Point head = new Point(snake.peekFirst());
		switch (direction) {
		case North:
			head.y--;
			break;

		case South:
			head.y++;
			break;

		case West:
			head.x--;
			break;

		case East:
			head.x++;
			break;
		}

		/*
		 * If the snake has moved out of bounds ('hit' a wall), we can just
		 * return that it's collided with itself, as both cases are handled
		 * identically.
		 */
		if (head.x < 0 || head.x >= _arch.OUT_BoardPanelInterface.COL_COUNT || head.y < 0 || head.y >= _arch.OUT_BoardPanelInterface.ROW_COUNT) { // 1.1vc
			return TileType.SnakeBody; // Pretend we collided with our body.
		}

		/*
		 * Here we get the tile that was located at the new head position and
		 * remove the tail from of the snake and the board if the snake is long
		 * enough, and the tile it moved onto is not a fruit.
		 * 
		 * If the tail was removed, we need to retrieve the old tile again
		 * incase the tile we hit was the tail piece that was just removed to
		 * prevent a false game over.
		 */
		TileType old = board.getTile(head.x, head.y);
		if (old != TileType.Fruit && snake.size() > MIN_SNAKE_LENGTH) {
			Point tail = snake.removeLast();
			board.setTile(tail, null);
			old = board.getTile(head.x, head.y);
		}

		/*
		 * Update the snake's position on the board if we didn't collide with
		 * our tail:
		 * 
		 * 1. Set the old head position to a body tile. 2. Add the new head to
		 * the snake. 3. Set the new head position to a head tile.
		 * 
		 * If more than one direction is in the queue, poll it to read new
		 * input.
		 */
		if (old != TileType.SnakeBody) {
			board.setTile(snake.peekFirst(), TileType.SnakeBody);
			snake.push(head);
			board.setTile(head, TileType.SnakeHead);
			if (directions.size() > 1) {
				directions.poll();
			}
		}

		return old;
	}

	// 1.1vc starts update game logic for Player2
	private void updateGamePlayer2() {
		/*
		 * Gets the type of tile that the head of the snake collided with. If
		 * the snake hit a wall, SnakeBody will be returned, as both conditions
		 * are handled identically.
		 */
		TileType collision = updateSnakePlayer2();

		/*
		 * Here we handle the different possible collisions.
		 * 
		 * Fruit: If we collided with a fruit, we increment the number of fruits
		 * that we've eaten, update the score, and spawn a new fruit.
		 * 
		 * SnakeBody: If we collided with our tail (or a wall), we flag that the
		 * game is over and pause the game.
		 * 
		 * If no collision occurred, we simply decrement the number of points
		 * that the next fruit will give us if it's high enough. This adds a bit
		 * of skill to the game as collecting fruits more quickly will yield a
		 * higher score.
		 */
		if (collision == TileType.Fruit) {
			fruitsEatenPlayer2++;
			scorePlayer2 += nextFruitScore;
			spawnFruit();
		} else if (collision == TileType.SnakeBody2) {
			isGameOver2 = true;
			_arch.OUT_ClockInterface.setPaused(true);
		} else if (collision == TileType.SnakeBody) {
			isGameOver2 = true;
			_arch.OUT_ClockInterface.setPaused(true);
		} else if (fruitsEatenPlayer2 == 5) {
			isGameOver = true;
			_arch.OUT_ClockInterface.setPaused(true);
		} else if (nextFruitScore > 10) {
			nextFruitScore--;
		}
	}

	/**
	 * Updates the snake's position and size.
	 * 
	 * @return Tile tile that the head moved into.
	 */
	// Player update Snake position and size logic
	@SuppressWarnings("static-access")
	private TileType updateSnakePlayer2() {

		/*
		 * Here we peek at the next direction rather than polling it. While not
		 * game breaking, polling the direction here causes a small bug where
		 * the snake's direction will change after a game over (though it will
		 * not move).
		 */
		Direction direction = directionsPlayer2.peekFirst();

		/*
		 * Here we calculate the new point that the snake's head will be at
		 * after the update.
		 */
		Point head = new Point(snakePlayer2.peekFirst());
		switch (direction) {
		case North:
			head.y--;
			break;

		case South:
			head.y++;
			break;

		case West:
			head.x--;
			break;

		case East:
			head.x++;
			break;
		}

		/*
		 * If the snake has moved out of bounds ('hit' a wall), we can just
		 * return that it's collided with itself, as both cases are handled
		 * identically.
		 */
		if (head.x < 0 || head.x >= _arch.OUT_BoardPanelInterface.COL_COUNT || head.y < 0 || head.y >= _arch.OUT_BoardPanelInterface.ROW_COUNT) {// 1.1vc
																													// starts
			return TileType.SnakeBody2; // Pretend we collided with our body.
		}

		/*
		 * Here we get the tile that was located at the new head position and
		 * remove the tail from of the snake and the board if the snake is long
		 * enough, and the tile it moved onto is not a fruit.
		 * 
		 * If the tail was removed, we need to retrieve the old tile again
		 * incase the tile we hit was the tail piece that was just removed to
		 * prevent a false game over.
		 */
		TileType old = board.getTile(head.x, head.y);
		if (old != TileType.Fruit && snakePlayer2.size() > MIN_SNAKE_LENGTH) {
			Point tail = snakePlayer2.removeLast();
			board.setTile(tail, null);
			old = board.getTile(head.x, head.y);
		}

		/*
		 * Update the snake's position on the board if we didn't collide with
		 * our tail:
		 * 
		 * 1. Set the old head position to a body tile. 2. Add the new head to
		 * the snake. 3. Set the new head position to a head tile.
		 * 
		 * If more than one direction is in the queue, poll it to read new
		 * input.
		 */
		if (old != TileType.SnakeBody2) {
			board.setTile(snakePlayer2.peekFirst(), TileType.SnakeBody2);
			snakePlayer2.push(head);
			board.setTile(head, TileType.SnakeHead2);
			if (directionsPlayer2.size() > 1) {
				directionsPlayer2.poll();
			}
		}

		return old;
	}

	// 1.1vc ends
	/**
	 * Resets the game's variables to their default states and starts a new
	 * game.
	 */
	@SuppressWarnings("static-access")
	private void resetGame() {
		/*
		 * Reset the score statistics. (Note that nextFruitPoints is reset in
		 * the spawnFruit function later on).
		 */
		this.score = 0;
		this.fruitsEaten = 0;

		this.scorePlayer2 = 0; // 1.1vc
		this.fruitsEatenPlayer2 = 0; // 1.1vc

		/*
		 * Reset both the new game and game over flags.
		 */
		this.isNewGame = false;
		this.isGameOver = false;
		this.isGameOver2 = false;

		/*
		 * Create the head at the center of the board.
		 */
		Point head = new Point((_arch.OUT_BoardPanelInterface.COL_COUNT / 2) + 1, (_arch.OUT_BoardPanelInterface.ROW_COUNT / 2) + 1);

		Point head2 = new Point(_arch.OUT_BoardPanelInterface.COL_COUNT / 2, _arch.OUT_BoardPanelInterface.ROW_COUNT / 2); // 1.1vc

		/*
		 * Clear the snake list and add the head.
		 */
		snake.clear();
		snake.add(head);

		snakePlayer2.clear(); // 1.1vc
		snakePlayer2.add(head2); // 1.1vc

		/*
		 * Clear the board and add the head.
		 */
		board.clearBoard();
		board.setTile(head, TileType.SnakeHead);

		/*
		 * Clear the directions and add north as the default direction.
		 */
		directions.clear();
		directions.add(Direction.North);

		directionsPlayer2.clear();// 1.1vc
		directionsPlayer2.add(Direction.South);// 1.1vc

		/*
		 * Reset the logic timer.
		 */
		_arch.OUT_ClockInterface.reset();

		/*
		 * Spawn a new fruit.
		 */
		spawnFruit();
	}

	/**
	 * Gets the flag that indicates whether or not we're playing a new game.
	 * 
	 * @return The new game flag.
	 */
	public boolean isNewGame() {
		return isNewGame;
	}

	/**
	 * Gets the flag that indicates whether or not the game is over.
	 * 
	 * @return The game over flag.
	 */
	public boolean isGameOver() {
		return isGameOver;
	}

	public boolean isGameOver2() {
		return isGameOver2;
	}

	/**
	 * Gets the flag that indicates whether or not the game is paused.
	 * 
	 * @return The paused flag.
	 */
	public boolean isPaused() {
		return isPaused;
	}

	/**
	 * Spawns a new fruit onto the board.
	 */
	@SuppressWarnings("static-access")
	private void spawnFruit() {
		// Reset the score for this fruit to 100.
		this.nextFruitScore = 100;

		/*
		 * Get a random index based on the number of free spaces left on the
		 * board.
		 */
		int index = random.nextInt(_arch.OUT_BoardPanelInterface.COL_COUNT * _arch.OUT_BoardPanelInterface.ROW_COUNT - snake.size());

		/*
		 * While we could just as easily choose a random index on the board and
		 * check it if it's free until we find an empty one, that method tends
		 * to hang if the snake becomes very large.
		 * 
		 * This method simply loops through until it finds the nth free index
		 * and selects uses that. This means that the game will be able to
		 * locate an index at a relatively constant rate regardless of the size
		 * of the snake.
		 */
		int freeFound = -1;
		for (int x = 0; x < _arch.OUT_BoardPanelInterface.COL_COUNT; x++) {
			for (int y = 0; y < _arch.OUT_BoardPanelInterface.ROW_COUNT; y++) {
				TileType type = board.getTile(x, y);
				if (type == null || type == TileType.Fruit) {
					if (++freeFound == index) {
						board.setTile(x, y, TileType.Fruit);
						break;
					}
				}
			}
		}
	}

	/**
	 * Gets the current score.
	 * 
	 * @return The score.
	 */
	public int getScore() {
		return score;
	}

	// 1.1vc starts
	public int getScorePlayer2() {
		return scorePlayer2;
	}
	// 1.1vc ends

	/**
	 * Gets the number of fruits eaten.
	 * 
	 * @return The fruits eaten.
	 */
	public int getFruitsEaten() {
		return fruitsEaten;
	}

	// 1.1vc starts
	public int getFruitsEatenPlayer2() {
		return fruitsEatenPlayer2;
	}
	// 1.1vc ends

	/**
	 * Gets the next fruit score.
	 * 
	 * @return The next fruit score.
	 */
	public int getNextFruitScore() {
		return nextFruitScore;
	}

	/**
	 * Gets the current direction of the snake.
	 * 
	 * @return The current direction.
	 */
	public Direction getDirection() {
		return directions.peek();
	}

	// 1.1vc starts
	public Direction getDirection2() {
		return directionsPlayer2.peek();
	}
	// 1.1vc ends

	/**
	 * Entry point of the program.
	 * 
	 * @param args
	 *            Unused.
	 */
	public static void main(String[] args) {
		SnakeGame snake = new SnakeGame();
		snake.startGame();
	}

	public void setArchData(SnakeGameArch _arch) {
		// TODO Auto-generated method stub
		this._arch = _arch;

	}

}