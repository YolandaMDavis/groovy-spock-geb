package com.ymd.demo.got.service

import com.ymd.demo.got.model.House
import com.ymd.demo.got.model.Member

/**
 * Created by yolandad on 5/15/14.
 */
interface WarService {
    Member physicalMemberFight(List<Member> competitors)
    Member verbalMemberFight(List<Member> competitors)
    House physicalHouseFight(List<House> competitors)
    House verbalHouseFight(List<House> competitors)
    House battle(List<House> competitors)
    House war(List<House> competitors)
}