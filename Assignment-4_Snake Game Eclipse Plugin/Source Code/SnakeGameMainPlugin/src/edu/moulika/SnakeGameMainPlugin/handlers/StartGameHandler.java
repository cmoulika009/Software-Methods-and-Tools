package edu.moulika.SnakeGameMainPlugin.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import edu.moulika.gInterface.GameInterface;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class StartGameHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		
		IConfigurationElement[] config = Platform.getExtensionRegistry()
					.getConfigurationElementsFor("edu.moulika.SnakeGameMainPlugin.StartGame");
			try {
				for (IConfigurationElement e : config) {
					System.out.println("Evaluating extension Start Game Handler");
					final Object o = e.createExecutableExtension("SnakeGame");
						((GameInterface) o).startGame();	
				}
			} catch (CoreException ex) {
				System.out.println(ex.getMessage());
			}
		

		return null;
	}
}
