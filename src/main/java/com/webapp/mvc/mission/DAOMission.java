package com.webapp.mvc.mission;

import java.util.ArrayList;
import java.util.List;




public interface DAOMission {
    boolean insertMission(Mission mission);
    boolean updateMission(Mission mission);
    Mission findMissionById(int id);
    List<Mission> findAllMissions();
    boolean deleteMission(int id);
}
