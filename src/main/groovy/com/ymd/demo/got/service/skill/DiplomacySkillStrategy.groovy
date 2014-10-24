package com.ymd.demo.got.service.skill

import com.ymd.demo.got.model.House
import com.ymd.demo.got.model.Member
import com.ymd.demo.got.model.Skill

/**
 * Created by yolandad on 5/16/14.
 */
class DiplomacySkillStrategy implements SkillStrategy{

    private static  Skill DIPLOMACY_SKILL = Skill.DIPLOMACY

    @Override
    List<Member> determinePlacesWithMembers(List<Member> members) {
        Collections.sort(members,Collections.reverseOrder(new Comparator<Member>() {
            @Override
            int compare(Member o1, Member o2) {
                def o1DiplomatVal = o1.sumSkills(DIPLOMACY_SKILL,Skill.LITERACY)
                def o2DiplomatVal = o2.sumSkills(DIPLOMACY_SKILL,Skill.LITERACY)
                return o1DiplomatVal.compareTo(o2DiplomatVal)
            }
        }))

        return members
    }

    @Override
    List<House> determinePlacesWithHouses(List<House> houses) {
        Collections.sort(houses,Collections.reverseOrder(new Comparator<House>() {
            @Override
            int compare(House o1, House o2) {
                def o1DiplomacyVal = o1.overallAbility(DIPLOMACY_SKILL,Skill.LITERACY)
                def o2DiplomacyVal = o2.overallAbility(Skill.DIPLOMACY,Skill.LITERACY)
                return o1DiplomacyVal.compareTo(o2DiplomacyVal)
            }
        }))

        return houses
    }
}
