package com.ymd.demo.got.service.skill

import com.ymd.demo.got.model.House
import com.ymd.demo.got.model.Member
import com.ymd.demo.got.model.Skill

/**
 * Created by yolandad on 5/16/14.
 */
class LiteracySkillStrategy implements SkillStrategy{

    @Override
    List<Member> determinePlacesWithMembers(List<Member> members) {
        Collections.sort(members,Collections.reverseOrder(new Comparator<Member>() {
            @Override
            int compare(Member o1, Member o2) {
                return o1.sumSkills(Skill.LITERACY).compareTo(
                        o2.sumSkills(Skill.LITERACY)
                );
            }
        }))
        return members
    }

    @Override
    List<House> determinePlacesWithHouses(List<House> houses) {
        Collections.sort(houses,Collections.reverseOrder(new Comparator<House>() {
            @Override
            int compare(House o1, House o2) {
                return o1.overallAbility(Skill.LITERACY).compareTo(
                        o2.overallAbility(Skill.LITERACY)
                );
            }
        }))

        return houses
    }
}
