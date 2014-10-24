package com.ymd.demo.got.model
/**
 * Created by yolandad on 5/14/14.
 */
class House {

    String name
    Member headOfHouse
    List<Member> members
    Integer soldiers

    House() {
    }

    House(String name, Member headOfHouse, List<Member> members, Integer soldiers) {
        this.name = name
        this.headOfHouse = headOfHouse
        this.members = members
        this.soldiers = soldiers
    }

    SkillLevel overallAbility(Skill...skill){
        Float averageAbility = 0.0f;
        for(Member member: getMembers()){
            averageAbility += member.sumSkills(skill);
        }

        averageAbility = members.size() == 0 ? 0.0f : averageAbility/getMembers().size()

        return ability(averageAbility);
    }

    private SkillLevel ability(Float skillValue){
        if(skillValue <= SkillLevel.INEPT.skillValue) SkillLevel.INEPT
        else if(skillValue > SkillLevel.INEPT.skillValue && skillValue <= SkillLevel.NOVICE.skillValue) SkillLevel.NOVICE
        else if(skillValue > SkillLevel.NOVICE.skillValue && skillValue <= SkillLevel.SKILLED.skillValue) SkillLevel.SKILLED
        else SkillLevel.EXPERT
    }

    List<String> memberNames(){
        //yo, seriously? why can't I write everything in groovy
        //this is a spread operator allowing you to invoke an operation on each option in a list
        //return results in a list of that results type.WTH.
        //In Java this would have been 4 - 5 lines at least
        return members*.name
    }


    @Override
    public String toString(){

        StringBuilder houseToString = new StringBuilder()
        houseToString.append("Name: ")
        houseToString.append(getName())
        houseToString.append(", HeadOfHouse: {")
        houseToString.append(getHeadOfHouse())
        houseToString.append(" } Members:[")
        for(member in members){
            houseToString.append(member)
        }
        houseToString.append("],Soldiers:")
        houseToString.append(getSoldiers())
        return houseToString.toString()

    }

}
