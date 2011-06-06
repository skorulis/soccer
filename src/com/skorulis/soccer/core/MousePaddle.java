package com.skorulis.soccer.core;

import java.util.ArrayList;
import static forplay.core.ForPlay.*;

import org.jbox2d.callbacks.ContactImpulse;
import org.jbox2d.callbacks.ContactListener;
import org.jbox2d.collision.Manifold;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;
import org.jbox2d.dynamics.contacts.Contact;

import com.skorulis.forplay.entities.Entity;
import com.skorulis.forplay.entities.EntityImageManager;
import com.skorulis.forplay.entities.Event;
import com.skorulis.forplay.entities.PhysicsComponent;
import com.skorulis.forplay.util.InputState;

import forplay.core.ImageLayer;
import forplay.core.Layer;

public class MousePaddle implements Entity,ContactListener{

  public static final float RADIUS = 20;
  PhysicsComponent physics;
  EntityImageManager imageMan;
  ImageLayer layer;
  
  public MousePaddle(float physScale,World world){ 
    physics = new PhysicsComponent(BodyType.DYNAMIC, physScale);
    physics.setFixtureDef(getFixtureDef());
    physics.createBody(world);
    
    imageMan = new EntityImageManager(this);
    layer = imageMan.makeImageLayer("images/ball.png");
    world.setContactListener(this);
  }
  
  @Override
  public void paint(float alpha) {
    physics.stdPaint(alpha, layer());
  }

  @Override
  public ArrayList<Event> update(float delta, InputState input) {
    physics.body().setTransform(input.pointer(), 0);
    
    
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
  
  public FixtureDef getFixtureDef() {
    FixtureDef fixtureDef = new FixtureDef();
    CircleShape circleShape = new CircleShape();
    circleShape.m_radius = RADIUS*physics.physScale();
    fixtureDef.shape = circleShape;
    fixtureDef.density = 0.4f;
    fixtureDef.friction = 0.00f;
    fixtureDef.restitution = 0.35f;
    fixtureDef.isSensor = true;
    
    circleShape.m_p.set(0, 0);
    return fixtureDef;
  }

  @Override
  public void beginContact(Contact contact) {
    log().debug("BEGIN");
    contact.getFixtureA()==
  }

  @Override
  public void endContact(Contact contact) {
    log().debug("END");
  }

  @Override
  public void preSolve(Contact contact, Manifold oldManifold) {

  }

  @Override
  public void postSolve(Contact contact, ContactImpulse impulse) {
  }

}
