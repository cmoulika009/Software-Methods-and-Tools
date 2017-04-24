package com.snakegame.testCases;

import static org.junit.Assert.*;

import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.psnbtech.Direction;
import org.psnbtech.SnakeGame;
import org.psnbtech.TileType;

public class SnakeGameTest {

	SnakeGame snakeGame;
	int actualFruitsEaten;
	int sizeNew = 0;
	int score = 0;
	int expectedScore;
	int actualScore = 0;
	boolean isPaused = true;
	Point head;

	@Before
	public void setUp() throws Exception {
		snakeGame = new SnakeGame();
		snakeGame.initSnakeGame();
	}

	@After
	public void tearDown() throws Exception {
		snakeGame = null;
	}

	@Test
	/*
	 * This test case checks is the Score is getting incremented if Snake hits
	 * Fruit
	 */
	public void testUpdateScore() {

		int fruitcnt = 5;

		/*
		 * First we are getting the current Fruit Position by executing
		 * spawnFruit()
		 */
		int oldScore = snakeGame.getScore();

		for (int i = 0; i < fruitcnt; i++) {
			snakeGame.spawnFruit();
			TileType fruitTileType = snakeGame.board.getTile(snakeGame.fruitTilePositionX,
					snakeGame.fruitTilePositionY);
			System.out.println(fruitTileType);

			/*
			 * Further we are setting the coordinates of Fruit to SnakeHead
			 * position Such that SnakeHead position is equal to Fruit Position
			 */
			head = new Point(snakeGame.fruitTilePositionX, ++snakeGame.fruitTilePositionY);
			snakeGame.snake.add(head);
			snakeGame.directions.add(Direction.North);

			/*
			 * Once the position of Snake is update we are executing
			 * updateGame() and further updateSnake() should return TileType as
			 * Fruit And in updateGame Score count has to be incremented based
			 * on NextFruitScore.
			 */
			snakeGame.updateGame();
			actualScore = snakeGame.getScore();
			System.out.println(snakeGame.updateSnake());// returns Fruit
		}

		System.out.println(snakeGame.getScore()); // Returns 500 as Snake ate 5
													// Fruits

		assertNotEquals(oldScore, actualScore); // 0 not equal to 500

	}

	@Test
	/*
	 * This test case executes spawnFruit() method and checking whether
	 * NextFruitScore is updating from 0 to 100 and also checking if TileType is
	 * getting set to Fruit for given Position. Further we are also checking if
	 * NextFruitScore is getting decremented when snake game is getting updated
	 * '10' times
	 */
	public void testUpdateNextFruitScore() {

		snakeGame.resetGame();

		int X_Board_Col_Cnt = snakeGame.board.COL_COUNT + 1;
		int Y_Board_Row_Cnt = snakeGame.board.ROW_COUNT + 1;

		/*
		 * spawnFruit() method is called such that the nextFruitScore has to be
		 * updated to 100 and TileType has to be set to Fruit
		 */
		snakeGame.spawnFruit();

		/*
		 * Getting Fruit Position and TileType
		 */
		int X_FruitPosition = snakeGame.fruitTilePositionX;
		int Y_FruitPosition = snakeGame.fruitTilePositionY;

		TileType fruitTileType = snakeGame.board.getTile(X_FruitPosition, Y_FruitPosition);

		/*
		 * Checking whether the coordinate positions set is greater than Board
		 * Dimensions
		 */
		assertNotEquals(X_Board_Col_Cnt, X_FruitPosition);
		assertNotEquals(Y_Board_Row_Cnt, Y_FruitPosition);

		assertEquals(TileType.Fruit, fruitTileType); // fruitTileType should
														// return Fruit

		/*
		 * Updating Game 'n' number of times i.e using updateGame() method As
		 * currentfruitscore > 10 the actualScore should be decremented n times
		 */

		int expectedFruitScore = snakeGame.getNextFruitScore() - 10;

		for (int i = 0; i < 10; i++) {
			snakeGame.updateGame();
		}
		int actualFruitScore = snakeGame.getNextFruitScore(); // must return 90

		assertEquals(expectedFruitScore, actualFruitScore); // Both has to be 90
															// as game updated
															// 10 times

	}

	@Test
	/*
	 * This test case checks is the Fruits Eaten count is getting incremented if
	 * Snake hits Fruit
	 */
	public void testUpdateFruitEaten() {

		int actualFruitsEaten = 0;
		int fruitcnt = 5;

		int expectedFruitsEaten = snakeGame.getFruitsEaten() + fruitcnt; // fruitcnt=5
		/*
		 * First we are getting the current Fruit Position by executing
		 * spawnFruit()
		 */
		for (int i = 0; i < fruitcnt; i++) {

			snakeGame.spawnFruit();

			/*
			 * Further we are setting the coordinates of Fruit to SnakeHead
			 * position Such that SnakeHead position is equal to Fruit Position
			 */
			head = new Point(snakeGame.fruitTilePositionX, snakeGame.fruitTilePositionY);
			snakeGame.snake.add(head);
			snakeGame.directions.add(Direction.North);
			snakeGame.board.setTile(head, TileType.Fruit);

			/*
			 * Once the position of Snake is update we are executing
			 * updateGame() and further updateSnake() should return TileType as
			 * Fruit And in updateGame FruitEaten count has to be incremented.
			 */
			snakeGame.updateGame();
			actualFruitsEaten = snakeGame.fruitsEaten;
			System.out.println(snakeGame.updateSnake());// returns Fruit
		}

		assertEquals(expectedFruitsEaten, actualFruitsEaten); // Fails as count
																// not
																// increasing

	}

	@Test
	/*
	 * This test case checks whether the Game is paused when Key Pressed = 'P'
	 */
	public void testPauseGame() {

		snakeGame.resetGame();
		System.out.println(snakeGame.isPaused());
		snakeGame.setFocusable(true);
		snakeGame.requestFocus();
		snakeGame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				e.setKeyCode(KeyEvent.VK_P);
				if (e.getKeyCode() == KeyEvent.VK_P) {
					isPaused = snakeGame.isPaused();
				}
			}
		});
		snakeGame.updateGame();

		assertTrue(isPaused); // should return True

	}

	@Test
	/*
	 * This test case is used to check if Snake size increases as Snake hits
	 * Fruit
	 */
	public void testUpdateSnakeSize() {

		snakeGame.resetGame();

		int sizeOld = 0;

		/*
		 * Start Updating The Snake such that Snake default size is set to 6
		 */
		for (int i = 0; i < 5; i++) {
			snakeGame.updateGame();
			sizeOld = snakeGame.snake.size();
		}

		/*
		 * Further we are setting the coordinates of Fruit to SnakeHead position
		 * Such that SnakeHead position is equal to Fruit Position
		 */
		snakeGame.spawnFruit();
		head = new Point(snakeGame.fruitTilePositionX, ++snakeGame.fruitTilePositionY);
		snakeGame.snake.add(head);
		snakeGame.directions.add(Direction.North);

		/*
		 * Once the position of Snake is update we are executing updateGame()
		 * and further updateSnake() should return TileType as Fruit And in
		 * updateGame Score count has to be incremented based on NextFruitScore.
		 */
		snakeGame.updateSnake();// returns Fruit
		sizeNew = snakeGame.snake.size();

		/*
		 * We are checking whether Snake Size is Increasing
		 */
		assertEquals(sizeOld + 1, sizeNew);

	}

	@Test
	/*
	 * This test case checks if the Game is getting ended if Snake hits Wall or
	 * SnakeBody
	 */
	public void testUpdateSnakeCollision() {

		/*
		 * Here we are setting head coordinates such that it is greater than
		 * Board coordinates so once execute updateGame() updateSnake() should
		 * return SnakeBody
		 */
		head = new Point(25, 25);
		snakeGame.snake.add(head);
		snakeGame.directions.add(Direction.North);
		snakeGame.updateGame();

		assertEquals(TileType.SnakeBody, snakeGame.updateSnake());

		/*
		 * As TileType is SnakeBody the GameOver should be True
		 */

		assertTrue(snakeGame.isGameOver());
	}
}
