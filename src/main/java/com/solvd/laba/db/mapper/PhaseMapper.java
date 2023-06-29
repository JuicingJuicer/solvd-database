package main.java.com.solvd.laba.db.mapper;

import java.util.ArrayList;

import main.java.com.solvd.laba.db.model.Phase;

public interface PhaseMapper {

	Phase selectPhaseById(int id);

	ArrayList<Phase> selectPhases();
}
