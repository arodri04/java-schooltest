package com.lambdaschool.school.service;

import com.lambdaschool.school.SchoolApplication;
import com.lambdaschool.school.SchoolApplicationTests;
import com.lambdaschool.school.model.Course;
import com.lambdaschool.school.model.Instructor;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.lambdaschool.school.service.CourseService;
import javax.persistence.EntityNotFoundException;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SchoolApplication.class)
public class CourseServiceImplTest
{
    @Autowired
    private CourseService courseService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks((this));
    }

    @After
    public void tearDown() {
    }

    @Test
    public void findAll() {
        System.out.println(courseService.findAll().size());
        assertEquals(6, courseService.findAll().size());
    }

    @Test
    public void deleteFound() {
        courseService.delete(6);
        assertEquals(5, courseService.findAll().size());
    }

    @Test
    public void deleteNotFound()
    {


        courseService.delete(100);
        assertEquals(6, courseService.findAll().size());
    }

    @Test
    public void save()
    {
        ArrayList<Course> course = new ArrayList<>();
        Course c8 = new Course("ChickenFighting", null);
        Course addcourse = courseService.save(c8);

        assertNotNull(addcourse);

        Course foundCourse = courseService.findCourseById(addcourse.getCourseid());
        assertEquals(addcourse.getCoursename(), foundCourse.getCoursename());

    }

    @Test
    public void findCourseById() {
    }
}