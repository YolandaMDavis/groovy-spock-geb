package com.ymd.demo.got.model

import org.junit.Test
import spock.lang.Ignore

import static junit.framework.TestCase.assertTrue

/**
 * Created by yolandad on 6/25/14.
 */
class MemberUnit {

    @Test
    void testMemberIsAlive() {
        Member member = new Member("Tyrion Lannister", Member.Status.ALIVE)
        boolean isAlive = member.isAlive()
        assertTrue isAlive
    }

    @Test
    void testMemberIsAliveEvenIfIll() {

        Member member = new Member("Jon Snow", Member.Status.ILL)
        boolean isAlive = member.isAlive()
        assertTrue isAlive
    }

    @Test
    void testMemberCannotRuleIfDead() {
        //when it fails hard to see why?
        assertTrue((new Member("Robb Stark", Member.Status.DEAD)).rulePotential() == 0.00f)
    }

    @Test
    @Ignore
    void testMemberShouldBeSuccessfulRuler() {

        Member member = new Member("Arya Stark", Member.Status.ALIVE, SkillLevel.NOVICE, SkillLevel.EXPERT, SkillLevel.EXPERT, SkillLevel.EXPERT);

        Float rulerPotential = member.rulePotential()

        // not alot of detail ...what was rulerPotential value when failed?
        assertTrue rulerPotential >= 70.00f

    }

    @Test
    void testMemberCanStillLeadIfSick() {

        Member member = new Member("Jaime Lannister", Member.Status.ILL, SkillLevel.NOVICE, SkillLevel.EXPERT, SkillLevel.EXPERT, SkillLevel.EXPERT)
        Float rulerPotential = member.rulePotential()

        assertTrue rulerPotential >= 70.00f
        assertTrue rulerPotential <= 80.00f

        //ok less lines, but how can I easily determine what failed?
        assertTrue rulerPotential >= 70.00f && rulerPotential <= 80.00f
    }
}
