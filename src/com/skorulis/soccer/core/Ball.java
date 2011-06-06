package com.skorulis.soccer.core;

import java.util.ArrayList;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

import com.skorulis.forplay.entities.Entity;
import com.skorulis.forplay.entities.EntityImageManager;
import com.skorulis.forplay.entities.Event;
import com.skorulis.forplay.entities.PhysicsComponent;
import com.skorulis.forplay.util.InputState;

import forplay.core.Image;
import forplay.core.ImageLayer;
import forplay.core.Layer;
import static forplay.core.ForPlay.*;

public class Ball implements Entity{

  public static final float RADIUS = 40;
  PhysicsComponent physics;
  ImageLayer layer;
  EntityImageManager imageMan;
  
  public Ball(float physScale,World world) {
    physics = new PhysicsComponent(BodyType.DYNAMIC, physScale);
    physics.setFixtureDef(getFixtureDef());
    physics.createBody(world);
    physics.body().setTransform(new Vec2(150*physScale,-100*physScale), 0);
    
    imageMan = new EntityImageManager(this);
    layer = imageMan.makeImageLayer("images/ball.png"); 
  }
  
  public FixtureDef getFixtureDef() {
    FixtureDef fixtureDef = new FixtureDef();
    CircleShape circleShape = new CircleShape();
    circleShape.m_radius = RADIUS*physics.physScale();
    fixtureDef.shape = circleShape;
    fixtureDef.density = 0.4f;
    fixtureDef.friction = 0.00f;
    fixtureDef.restitution = 0.75f;
    fixtureDef.isSensor = false;
    circleShape.m_p.set(0, 0);
    return fixtureDef;
  }
  
  @Override
  public void paint(float alpha) {
    physics.stdPaint(alpha, layer());
  }

  @Override
  public ArrayList<Event> update(float delta, InputState input) {
    return null;
  }

  @Override
  public Layer layer() {
    return layer;
  }

  @Override
  public float width() {
    return RADIUS*2*physics.physScale();
  }

  @Override
  public float height() {
    return RADIUS*2*physics.physScale();
  }

  @Override
  public boolean alive() {
    return true;
  }

  @Override
  public Body body() {
    return physics.body();
  }

  
}
