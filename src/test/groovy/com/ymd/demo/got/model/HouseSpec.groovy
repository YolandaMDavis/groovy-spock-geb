package com.ymd.demo.got.model

import spock.lang.Specification

/**
 * Created by yolandad on 5/14/14.
 */
class HouseSpec extends Specification{

    def house = new House()

    def setup(){
        def members = []
        def headOfHouse = new Member("Tywin Lannister",Member.Status.ALIVE,SkillLevel.EXPERT,SkillLevel.EXPERT,SkillLevel.SKILLED,SkillLevel.EXPERT)
        members << new Member("Tyrion Lannister",Member.Status.ALIVE,SkillLevel.NOVICE,SkillLevel.EXPERT,SkillLevel.SKILLED,SkillLevel.EXPERT)
        members << new Member("Cersei Lannister",Member.Status.ALIVE,SkillLevel.INEPT,SkillLevel.SKILLED,SkillLevel.EXPERT,SkillLevel.EXPERT)
        members << new Member("Jamie Lannister",Member.Status.ALIVE,SkillLevel.EXPERT,SkillLevel.SKILLED,SkillLevel.SKILLED,SkillLevel.EXPERT)
        members << headOfHouse

        house.headOfHouse = headOfHouse
        house.members = members
        house.soldiers = 100000
    }

    def "successfully obtain leadership ability"(){

        when:

        def leadershipAbility = house.overallAbility(Skill.LEADERSHIP)

        then:

        leadershipAbility != SkillLevel.INEPT

    }

    def "successfully obtain literacy ability"(){

        when:

        def literacyAbility = house.overallAbility(Skill.LITERACY)

        then:

        literacyAbility != SkillLevel.INEPT

    }

    def "get all the members names of the house"(){

        when:

        def names = house.memberNames()

        then:
        names.contains("Tyrion Lannister") && !names.contains("Sansa Stark")
    }

}
