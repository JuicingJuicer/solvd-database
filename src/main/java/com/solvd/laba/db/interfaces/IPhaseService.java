package main.java.com.solvd.laba.db.interfaces;

import java.util.ArrayList;

import main.java.com.solvd.laba.db.model.Phase;

public interface IPhaseService {

	Phase getPhase(int id);

	ArrayList<Phase> getPhases();
}
