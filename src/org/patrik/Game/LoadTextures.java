package org.patrik.Game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class LoadTextures {
	
	public static Texture playerDown;
	public static Texture playerUp;
	public static Texture playerLeft;
	public static Texture playerRight;
	
	public static Texture noTextureButton;
	
	public static Texture cameraButton;
	public static Texture cameraButtonPressed;
	
	public static Texture Tree;
	public static Texture Apple;
	
	public static Texture inventory_slot;
	
	public static Texture ground;
	
	public static void Textures() {
		playerDown = loadTexture("ManDown");
		playerUp = loadTexture("ManUp");
		playerLeft = loadTexture("ManLeft");
		playerRight = loadTexture("ManRight");
		
		noTextureButton = loadTexture("noTextureButton");
		
		cameraButton = loadTexture("CameraButton");
		cameraButtonPressed = loadTexture("CameraButtonPressed");
		
		Tree = loadTexture("Tree");
		Apple = loadTexture("Apple");
		
		inventory_slot = loadTexture("Inventory_slot");
		
		ground = loadTexture("Grass");
	}
	
	public static Texture loadTexture(String key) {
		try {
			return TextureLoader.getTexture("PNG", new FileInputStream(new File("res/" + key + ".png")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}