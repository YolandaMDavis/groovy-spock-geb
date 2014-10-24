package com.ymd.demo.got.model;

/**
 * Created by yolandad on 5/14/14.
 */
public enum SkillLevel {
  INEPT(5.0f),NOVICE(10.0f),SKILLED(15.0f),EXPERT(20.0f);

  private float skillValue;

  SkillLevel(float skillValue){
    this.skillValue = skillValue;
  }

  public Float getSkillValue(){
    return skillValue;
  }
}

