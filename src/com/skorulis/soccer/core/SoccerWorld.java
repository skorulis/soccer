package com.skorulis.soccer.core;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;

import com.skorulis.forplay.util.WorldUtil;

import forplay.core.DebugDrawBox2D;


public class SoccerWorld {

  private World world;
  private static boolean showDebugDraw = true;
  private DebugDrawBox2D debugDraw;
  private float width,height;
  
  public SoccerWorld(float width,float height,float physScale) {
    this.width = width*physScale;
    this.height = height*physScale;
    Vec2 gravity = new Vec2(0,80*physScale);
    world = new World(gravity, true);
    if(showDebugDraw) {
      debugDraw = WorldUtil.showDebugDraw(this.width,this.height,physScale,world);
    }
    WorldUtil.buildBounds(this.width, this.height, world);
  }
  
  public void paint(float alpha) {
    if (showDebugDraw) {
      debugDraw.getCanvas().canvas().clear();
      world.drawDebugData();
    }
  }
  
  public void update(float delta) {
    
  }
  
}
