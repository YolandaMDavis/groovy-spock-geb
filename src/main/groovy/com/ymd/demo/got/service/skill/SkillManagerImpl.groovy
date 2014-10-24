package com.ymd.demo.got.service.skill

import com.ymd.demo.got.model.House
import com.ymd.demo.got.model.Member
import com.ymd.demo.got.model.Skill

/**
 * Created by yolandad on 5/15/14.
 */
class SkillManagerImpl implements SkillManager{

    @Override
    Member determineMemberVictor(List<Member> competitors, Skill skill) {
       def strategy = SkillStrategyFactory.getStrategy(skill)
       def places = strategy.determinePlacesWithMembers(competitors)
       if(!places){
           return null
       }
       else{
           return places[0]
       }
    }

    @Override
    Member determineMemberLoser(List<Member> competitors, Skill skill) {
        def strategy = SkillStrategyFactory.getStrategy(skill)
        def places = strategy.determinePlacesWithMembers(competitors)
        if(!places){
            return null
        }
        else{
            return places[places.size() - 1]
        }
    }

    House determineHouseVictor(List<House> competitors, Skill skill){

        def strategy = SkillStrategyFactory.getStrategy(skill)
        def places = strategy.determinePlacesWithHouses(competitors)
        if(!places){
            return null
        }
        else{
            return places[places.size() - 1]
        }
    }

    House determineHouseLoser(List<House> competitors, Skill skill){

        def strategy = SkillStrategyFactory.getStrategy(skill)
        def places = strategy.determinePlacesWithHouses(competitors)
        if(!places){
            return null
        }
        else{
            return places[0]
        }
    }

    @Override
    List<Member> determineMemberPlaces(List<Member> competitors, Skill skill){
        def strategy = SkillStrategyFactory.getStrategy(skill)
        return strategy.determinePlacesWithMembers(competitors)
    }

    @Override
    List<House> determineHousePlaces(List<House> competitors, Skill skill){
        def strategy = SkillStrategyFactory.getStrategy(skill)
        return strategy.determinePlacesWithHouses(competitors)
    }


}
