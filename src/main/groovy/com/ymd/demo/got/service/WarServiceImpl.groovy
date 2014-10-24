package com.ymd.demo.got.service

import com.ymd.demo.got.model.House
import com.ymd.demo.got.model.Member
import com.ymd.demo.got.model.Skill
import com.ymd.demo.got.service.skill.SkillManager

/**
 * Created by yolandad on 5/15/14.
 */
class WarServiceImpl implements WarService{
    SkillManager skillManager
    def WarServiceImpl(SkillManager skillManager) {
        this.skillManager = skillManager
    }

    @Override
    Member physicalMemberFight(List<Member> competitors) {
        if(competitors.size() > 1)
           skillManager.determineMemberVictor(competitors,Skill.FIGHTING)
        else
            null
    }

    Member verbalMemberFight(List<Member> competitors) {
        if(competitors.size() > 1)
            skillManager.determineMemberVictor(competitors,Skill.LITERACY)
        else
            null
    }

    House physicalHouseFight(List<House> competitors){
        if(competitors.size() > 1){
            skillManager.determineHouseVictor(competitors,Skill.FIGHTING)
        }
        else
            null
    }

    House verbalHouseFight(List<House> competitors){
        if(competitors.size() > 1){
            skillManager.determineHouseVictor(competitors,Skill.LITERACY)
        }
        else
            null
    }

    House battle(List<House> competitors){
        if(competitors.size() > 1){
            House bestInFighting = skillManager.determineHouseVictor(competitors,Skill.FIGHTING)
            House bestInLeadership = skillManager.determineHouseVictor(competitors,Skill.LEADERSHIP)
            if(bestInFighting == bestInLeadership){
                bestInFighting
            }else{
                skillManager.determineHouseVictor([bestInFighting,bestInLeadership],Skill.DIPLOMACY)
            }
        }
        else null
    }

    House war(List<House> competitors){
        if(competitors.size() > 1){
            def bestInLeadership = skillManager.determineHouseVictor(competitors,Skill.LEADERSHIP)
            def bestInDiplomacy = skillManager.determineHouseVictor(competitors,Skill.DIPLOMACY)
            def bestInLiteracy = skillManager.determineHouseVictor(competitors,Skill.LITERACY)
            def topLeadership = [bestInLeadership,bestInDiplomacy,bestInLiteracy]
            def fightCompetitors = []
            topLeadership.each(){leader -> if(!leader.headOfHouse.isSick()) fightCompetitors.add(leader)}
            return skillManager.determineHouseVictor(fightCompetitors,Skill.FIGHTING)
        }
        else null
    }


}
