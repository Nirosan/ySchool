package org.yarlithub.yschool.classroom.core;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.yarlithub.yschool.repository.model.obj.yschool.Classroom;
import org.yarlithub.yschool.repository.model.obj.yschool.Division;
import org.yarlithub.yschool.repository.model.obj.yschool.Grade;
import org.yarlithub.yschool.repository.model.obj.yschool.Module;
import org.yarlithub.yschool.repository.services.data.DataLayerYschool;
import org.yarlithub.yschool.repository.services.data.DataLayerYschoolImpl;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jay Krish
 * Date: 10/25/13
 * Time: 12:20 AM
 * To change this template use File | Settings | File Templates.
 */


public class ClassroomHelper {

    DataLayerYschool dataLayerYschool = DataLayerYschoolImpl.getInstance();

    /**
     * Returns Classroom objects for the current year for the given grade.
     *
     * @param grade org.yarlithub.yschool.repository.model.obj.yschool.Grade
     * @param year  int year.
     * @return List of org.yarlithub.yschool.repository.model.obj.yschool.Classroom,
     *         empty list if no matching occurred.
     */
    public List<Classroom> getClassrooms(Grade grade, int year) {
        Criteria classroomCriteria = dataLayerYschool.createCriteria(Classroom.class);
        classroomCriteria.add(Restrictions.eq("year", year));
        classroomCriteria.add(Restrictions.eq("gradeIdgrade", grade));
        return classroomCriteria.list();
    }

    /**
     * Returns all grade entries.
     *
     * @return List of org.yarlithub.yschool.repository.model.obj.yschool.Grade;
     */
    public List<Grade> getAvailableGrades() {
        Criteria gradeCriteria = dataLayerYschool.createCriteria(Grade.class);
        return gradeCriteria.list();
    }

    /**
     * Returns all division entries.
     *
     * @return List of org.yarlithub.yschool.repository.model.obj.yschool.Division;
     */
    public List<Division> getAvailableDivisions() {
        Criteria divisionCriteria = dataLayerYschool.createCriteria(Division.class);
        return divisionCriteria.list();
    }

    /**
     * Returns all Modules entries.
     *
     * @return List of org.yarlithub.yschool.repository.model.obj.yschool.Module;
     */
    public List<Module> getAvailableModules() {
        Criteria moduleCriteria = dataLayerYschool.createCriteria(Module.class);
        return moduleCriteria.list();
    }

    /**
     * Returns all Modules entries for the specific grade.
     *
     * @return List of org.yarlithub.yschool.repository.model.obj.yschool.Module;
     */
    public List<Module> getAvailableModules(int gradeid) {
        Grade grade = dataLayerYschool.getGrade(gradeid);
        Criteria moduleCriteria = dataLayerYschool.createCriteria(Module.class);
        moduleCriteria.add(Restrictions.eq("gradeIdgrade", grade));
        return moduleCriteria.list();
    }

}
