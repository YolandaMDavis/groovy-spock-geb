package com.ymd.demo.got.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by yolandad on 5/14/14.
 */
public class Member {

  private String name;
  private Status status;
  private HashMap<Skill, SkillLevel> skills;


  public Member() {
  }

  public Member(String name, Status status) {
    this.name = name;
    this.status = status;
  }

  public Member(String name, Status status, SkillLevel fighting, SkillLevel leadership, SkillLevel diplomacy, SkillLevel literacy) {
    this.name = name;
    this.status = status;
    this.skills = new HashMap<Skill, SkillLevel>();
    skills.put(Skill.FIGHTING, fighting);
    skills.put(Skill.LEADERSHIP, leadership);
    skills.put(Skill.DIPLOMACY, diplomacy);
    skills.put(Skill.LITERACY, literacy);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public Map<Skill, SkillLevel> getSkills() {
    return skills;
  }

  public void setSkills(HashMap<Skill, SkillLevel> skills) {
    this.skills = skills;
  }

  public Float sumSkills(Skill... skills) {
    Float summary = 0.0f;
    for (Skill skill : skills) {
      summary += getSkills().get(skill).getSkillValue();
    }
    return summary;
  }

  public boolean isAlive() {
    return status.equals(Status.ALIVE) || status.equals(Status.ILL);
  }

  public boolean isSick() {
    return status.equals(Status.ILL);
  }

  public boolean isDead() {
    return status.equals(Status.DEAD);
  }

  //could be a visitor pattern, but it ain't that serious folks
  public Float rulePotential() {
    Float potential = 0.0f;

    if (isAlive()) {
      if (!isSick()) {
        potential += 20.0f;
      }
      if (getSkills() != null) {
        potential += getSkills().get(Skill.LEADERSHIP).getSkillValue();
        potential += getSkills().get(Skill.LITERACY).getSkillValue();
        potential += getSkills().get(Skill.FIGHTING).getSkillValue();
        potential += getSkills().get(Skill.DIPLOMACY).getSkillValue();
      }
    }

    return potential;
  }

  @Override
  public String toString() {

    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Name: ");
    stringBuilder.append(getName());
    stringBuilder.append(", Status: ");
    stringBuilder.append(getStatus());
    stringBuilder.append(", Skills: {");

    Iterator<Skill> iterator = getSkills().keySet().iterator();

    while (iterator.hasNext()) {
      Skill skill = iterator.next();
      stringBuilder.append(" ");
      stringBuilder.append(skill.name());
      stringBuilder.append(": ");
      stringBuilder.append(getSkills().get(skill).name());
      if (iterator.hasNext()) {
        stringBuilder.append(", ");
      }
    }

    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  public enum Status {
    ALIVE, ILL, DEAD;
  }
}
