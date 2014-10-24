package com.ymd.demo.got.service.skill

import com.ymd.demo.got.model.House
import com.ymd.demo.got.model.Member
import com.ymd.demo.got.model.Skill

/**
 * Created by yolandad on 5/16/14.
 */
class FightSkillStrategy implements SkillStrategy{

    private static Skill FIGHTSKILL = Skill.FIGHTING
    @Override
    List<Member> determinePlacesWithMembers(List<Member> members) {
        Collections.sort(members,Collections.reverseOrder(new Comparator<Member>() {
            @Override
            int compare(Member o1, Member o2) {
                return o1.sumSkills(FIGHTSKILL).compareTo(
                        o2.sumSkills(FIGHTSKILL)
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
                return o1.overallAbility(FIGHTSKILL).compareTo(
                        o2.overallAbility(FIGHTSKILL)
                );
            }
        }))

        return houses
    }

}
