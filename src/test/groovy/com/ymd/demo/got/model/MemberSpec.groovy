package com.ymd.demo.got.model

import spock.lang.Ignore
import spock.lang.IgnoreIf
import spock.lang.Specification
import spock.lang.Stepwise

/**
 * Created by yolandad on 5/14/14.
 */
//Step through each test one at a time as defined
@Stepwise
class MemberSpec extends Specification {

    def "The member is alive"() {

        given: "There is a member named Tyrion who is alive"

        def member = new Member("Tyrion Lannister", Member.Status.ALIVE)

        when: "I invoke the isAlive check"

        def isAlive = member.alive

        then: "It shows he is alive"

        isAlive //check if true, (implicit assertion)

    }

    def "member is alive even if ill"() {
        setup:
        def member = new Member("Jon Snow", Member.Status.ILL)

        expect:
        member.alive
    }


    def "member can't be a ruler if he's dead"() {

        expect:
        (new Member("Robb Stark", Member.Status.DEAD)).rulePotential() == 0.00f

    }

    @Ignore
    def "member should be a successful ruler"() {

        given:

        def member = new Member("Arya Stark", Member.Status.ALIVE, SkillLevel.NOVICE, SkillLevel.EXPERT, SkillLevel.EXPERT, SkillLevel.EXPERT)

        when:

        def rulerPotential = member.rulePotential()


        then:
        //shows alot of detail if failure occurs (failed conditional, data involved)
        rulerPotential >= 70.00f


    }

    //Ignored based on operating system property.
    // very useful if looking at env properties
    @IgnoreIf({ os.macOs })
    def "member can still be a decent leader even if sick"() {

        given:

        def member = new Member("Jaime Lannister", Member.Status.ILL, SkillLevel.NOVICE, SkillLevel.EXPERT, SkillLevel.EXPERT, SkillLevel.EXPERT)
        System.out.println(System.getProperty("os.name"))

        when:

        def rulerPotential = member.rulePotential()


        then:
        rulerPotential >= 70.00f
        rulerPotential <= 80.00f
        //much easier to see what failed
        rulerPotential >= 70.00f && rulerPotential <= 80.00f
    }


}
