package Fit_Fusion.dao;

import java.sql.SQLException;
import java.util.List;

import Fit_Fusion.classes.WorkoutLog;

public abstract class WorkoutLogAbstractDAO {
  public abstract List<WorkoutLog> viewWorkoutLog(int id) throws SQLException;
  public abstract boolean addWorkoutLog(WorkoutLog workout) throws SQLException;
}