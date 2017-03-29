package edu.game.interfaces;

import java.awt.Graphics;
import java.awt.Point;

import edu.game.constants.TileType;

public interface BoardPanelInterface {
	int COL_COUNT = 32;
	int ROW_COUNT = 32;
	int TILE_SIZE = 0;
	public void clearBoard();
	public void setTile(Point point, TileType type);
	public void setTile(int x, int y, TileType type);
	public TileType getTile(int x, int y);
	public void paintComponent(Graphics g);
}
