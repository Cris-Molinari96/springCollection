package com.example.testhibernate.dao;


import com.example.testhibernate.entity.Course;
import com.example.testhibernate.entity.Instructor;
import com.example.testhibernate.entity.InstructorDetails;

import java.util.List;

public interface InstructorRepo{

    public void save(Instructor instructor);

    public Instructor findInstructor(int id);

    public void deleteInstructor(int id);

    public InstructorDetails findInstructorDetails(int id);

    public void deleteInstructorDetails(int id);

    public void updateDetail(int id);

    public void addCourseInCourseTable(int id,Course Course);
    public void addListCourseInCourseTable(int id, List<Course> course);

    public void courseInstructor(int id);

    public void getCourseIdInstructor(int id);
    public void deleteCourse(int id);
    public void deleteCourseList(List<Integer> courseList);

    // * typedQuery
    public Course typedFindCourse(int id);
    public List<Course> typedFindCoursFromIdInstructor(int id);
}
