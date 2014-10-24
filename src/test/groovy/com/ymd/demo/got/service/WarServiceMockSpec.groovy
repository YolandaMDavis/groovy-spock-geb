package com.ymd.demo.got.service

import com.ymd.demo.got.model.Member
import com.ymd.demo.got.model.Skill
import com.ymd.demo.got.service.skill.SkillManager
import spock.lang.Specification

/**
 * Created by yolandad on 5/15/14.
 */
class WarServiceMockSpec extends Specification{

    //in groovy when you do bdd/tdd IDE's tend to create missing classes in groovy
    //not java so keep that in mind

    def skillManager = Mock(SkillManager)

    def warService = new WarServiceImpl(skillManager)

    def "should successfully determine a single member as the winner of a fight with other members"(){

        given:
        def List<Member> members = []
        def Member victor = new Member()
        members << victor
        members << new Member()
        members << new Member()

        when:

        def Member winner = warService.physicalMemberFight(members)

        then:
        //can have different lots of choices to define cardinality
        //1 * - exactly 1
        //(1..3) - at least one no more than 3
        //(1.._) - one or more
        //_* - any number of calls
        1 * skillManager.determineMemberVictor(members,Skill.FIGHTING) >> victor
        winner
    }

    def "should deny victor if there is only person in a fight"(){
        given:
        def members = []
        members << new Member()

        when:
        def Member winner = warService.physicalMemberFight(members)

        then:
        //check if behavior did not occur
        0 * skillManager.determineMemberVictor(members,Skill.FIGHTING)
        !winner

    }

}
