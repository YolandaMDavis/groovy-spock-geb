package com.ymd.demo.got.service.skill

/**
 * Created by yolandad on 6/22/14.
 */
class SkillManagerFactory {

    public static SkillManager getManager(){
        return new SkillManagerImpl();
    }
}
