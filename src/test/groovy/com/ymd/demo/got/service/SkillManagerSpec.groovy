package com.ymd.demo.got.service

import com.ymd.demo.got.model.Member
import com.ymd.demo.got.model.Skill
import com.ymd.demo.got.model.SkillLevel
import com.ymd.demo.got.service.skill.SkillManagerFactory
import spock.lang.Shared
import spock.lang.Specification

/**
 * Created by yolandad on 5/15/14.
 */
class SkillManagerSpec extends Specification {

    @Shared
    skillManager = SkillManagerFactory.getManager()
    @Shared
    members = [] //easy way to create an array list, no new ArrayList() blah blah

    def setupSpec() {
        members << new Member("Tyrion Lannister", Member.Status.ALIVE, SkillLevel.NOVICE, SkillLevel.EXPERT, SkillLevel.SKILLED, SkillLevel.EXPERT)
        members << new Member("Cersei Lannister", Member.Status.ALIVE, SkillLevel.INEPT, SkillLevel.SKILLED, SkillLevel.EXPERT, SkillLevel.EXPERT)
        members << new Member("Jamie Lannister", Member.Status.ALIVE, SkillLevel.EXPERT, SkillLevel.SKILLED, SkillLevel.SKILLED, SkillLevel.SKILLED)
    }

    def "should return a for a fight"() {

        when:
        def victor = skillManager.determineMemberVictor(members, Skill.FIGHTING)

        then:
        victor
        victor.name == "Jamie Lannister"

    }

    def "should have Tyrion in last place for a fight"() {

        when:
        def loser = skillManager.determineMemberLoser(members, Skill.FIGHTING)

        then:
        loser
        loser.name == "Cersei Lannister"

    }

    def "should have cersei as first place in diplomacy"() {

        when:
        def victor = skillManager.determineMemberVictor(members, Skill.DIPLOMACY)

        then:
        victor
        victor.name == "Cersei Lannister"

    }

    def "should have jamie losing in literacy"() {

        when:
        def loser = skillManager.determineMemberLoser(members, Skill.LITERACY)

        then:
        loser
        loser.name == "Jamie Lannister"

    }

}
