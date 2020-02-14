package org.patrik.Game;

import java.nio.FloatBuffer;
import java.util.Random;

import org.lwjgl.*;
import org.lwjgl.opengl.*;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.*;
import org.patrik.Game.GameLogic;
import org.patrik.Game.GameLogic.Face;
import org.patrik.src.*;
import org.lwjgl.util.vector.*;

class RPG {
	
	private static long lastFrame;
	
	private static long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	
	protected static int getDelta() {
		long currentTime = getTime();
		int delta = (int) (currentTime - lastFrame);
		lastFrame = getTime();
		return delta;
	}
	
	public RPG() {
		try {
			Display.setDisplayMode(Display.getDesktopDisplayMode());
			Display.setTitle("TheTypicalRPG");
			Display.setVSyncEnabled(true);
			Display.setFullscreen(true);
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		LoadTextures.Textures();
		
		glMatrixMode (GL_PROJECTION);
		glLoadIdentity();
		
		gluPerspective(30.0f, (float) Display.getDisplayMode().getWidth() / (float) Display.getDisplayMode().getHeight(), 0.001f, 1000000.0f);
		glMatrixMode (GL_MODELVIEW);
		
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		
		glClearDepth(1.0f); 
        glEnable(GL_DEPTH_TEST); 
        glDepthFunc(GL_LEQUAL);
        
		lastFrame = getTime();
		
		while (!Display.isCloseRequested()) {
			
			GameLogic.gameLogic();
			
			Display.update();
			Display.sync(60);
		}
		
		Display.destroy();
	}
	
	public static void main(String[] args) {
		new RPG();
	}
}
