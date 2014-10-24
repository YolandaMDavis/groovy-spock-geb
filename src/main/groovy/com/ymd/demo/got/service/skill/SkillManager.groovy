package com.ymd.demo.got.service.skill

import com.ymd.demo.got.model.House
import com.ymd.demo.got.model.Member
import com.ymd.demo.got.model.Skill

/**
 * Created by yolandad on 5/15/14.
 */
interface SkillManager {
    Member determineMemberVictor(List<Member> competitors,Skill skill)
    Member determineMemberLoser(List<Member> competitors,Skill skill)
    House determineHouseVictor(List<House> competitors,Skill skill)
    House determineHouseLoser(List<House> competitors,Skill skill)
    List<Member> determineMemberPlaces(List<Member> competitors,Skill skill)
    List<House> determineHousePlaces(List<House> competitors,Skill skill)
}