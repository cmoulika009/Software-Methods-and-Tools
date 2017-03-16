package edu.moulika.logic;

import java.awt.Point;

import edu.moulika.Game.constants.TileType;
import edu.moulika.logic.SnakeGame;

public interface BoardInterface {

	int ROW_COUNT = 25;

	int COL_COUNT = 25;

	void init(SnakeGame game);

	public void clearBoard();

	public void setTile(Point point, TileType type);

	public void setTile(int x, int y, TileType type);

	public TileType getTile(int x, int y);

	// public void paintComponent(Graphics g);
}
