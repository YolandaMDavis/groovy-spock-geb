package com.ymd.demo.got.service.skill

import com.ymd.demo.got.model.Skill

/**
 * Created by yolandad on 5/16/14.
 */
class SkillStrategyFactory {
    static SkillStrategy getStrategy(Skill skill){

        if(skill == Skill.FIGHTING){
            new FightSkillStrategy()
        }
        else if(skill == Skill.LITERACY){
            new LiteracySkillStrategy()
        }
        else if (skill == Skill.DIPLOMACY)
        {
            new DiplomacySkillStrategy()
        }
        else if (skill == Skill.LEADERSHIP){
            new LeadershipSkillStrategy()
        }
        else null
    }
}
