package com.ymd.demo.got.service.skill

import com.ymd.demo.got.model.House
import com.ymd.demo.got.model.Member

/**
 * Created by yolandad on 5/16/14.
 */
public interface SkillStrategy {

    List<Member> determinePlacesWithMembers(List<Member>members)
    List<House> determinePlacesWithHouses(List<House> houses)
}