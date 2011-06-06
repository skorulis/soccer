package com.skorulis.soccer.core;

import com.skorulis.forplay.util.InputState;

import forplay.core.Game;
import static forplay.core.ForPlay.*;

public class Soccer implements Game{

  private SoccerWorld world;
  private InputState input;
  
  public static float physScale = 1 / 26.666667f;
  private int width = 600;
  private int height = 480;
  private MousePaddle paddle;
  
  @Override
  public void init() {
    world = new SoccerWorld(width, height, physScale);
    Ball b = new Ball(physScale,world.world());
    world.addEntity(b);
    
    paddle = new MousePaddle(physScale, world.world());
    world.addEntity(paddle);
    
    input = new InputState(0,physScale);
    pointer().setListener(input);
    
  }

  @Override
  public void update(float delta) {
    delta/=1000.0f;
    world.update(delta,input);
  }

  @Override
  public void paint(float alpha) {
    world.paint(alpha);
  }

  @Override
  public int updateRate() {
    return 25;
  }

}
