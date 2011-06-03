package com.skorulis.soccer.core;

import forplay.core.Game;

public class Soccer implements Game{

  private SoccerWorld world;
  
  public static float physScale = 1 / 26.666667f;
  private int width = 600;
  private int height = 480;
  
  @Override
  public void init() {
    world = new SoccerWorld(600, 480, physScale);
  }

  @Override
  public void update(float delta) {
    world.update(delta);
  }

  @Override
  public void paint(float alpha) {
    world.paint(alpha);
  }

  @Override
  public int updateRate() {
    // TODO Auto-generated method stub
    return 0;
  }

}
