package com.skorulis.soccer.java;

import com.skorulis.soccer.core.Soccer;

import forplay.core.ForPlay;
import forplay.java.JavaAssetManager;
import forplay.java.JavaPlatform;

public class SoccerJava {

  public static void main(String[] args) {
    JavaAssetManager assets = JavaPlatform.register().assetManager();
    assets.setPathPrefix("src/com/skorulis/soccer/resources");
    ForPlay.run(new Soccer());
  }
  
}
