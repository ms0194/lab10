package pk.edu.nust.seecs.gradebook;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import pk.edu.nust.seecs.gradebook.dao.CloDao;
import pk.edu.nust.seecs.gradebook.dao.ContentDao;
import pk.edu.nust.seecs.gradebook.dao.CourseDao;
import pk.edu.nust.seecs.gradebook.dao.TeacherDao;
import pk.edu.nust.seecs.gradebook.entity.Clo;
import pk.edu.nust.seecs.gradebook.entity.Content;
import pk.edu.nust.seecs.gradebook.entity.Course;
import pk.edu.nust.seecs.gradebook.entity.Student;
import pk.edu.nust.seecs.gradebook.entity.Teacher;

/**
 * My main App. 
 * <p>
 This executes everything.
 */

public class App {

    public static void main(String[] args) {
        CloDao clodao = new CloDao();
        TeacherDao teacher_dao =new TeacherDao();
        CourseDao course_dao = new CourseDao();
        ContentDao content_dao = new ContentDao();
        // Add new clo
        Clo clo = new Clo();
        clo.setName("CLO 1");
        clo.setDescription("Algorithmic problems");
        clo.setPlo("2");
        clodao.addClo(clo);
        clodao.updateClo(clo);
 
        Course course= new Course();
        Content content = new Content();
        Student student = new Student();
        Teacher teacher = new Teacher();
        
        Set set2 = new HashSet<Course>();
        set2.add(course);
        
        
        course.setClasstitle("ADV PROG");
        course.setCreditHours(4);
        course.setEndsOn(new GregorianCalendar(2016,Calendar.MARCH,26).getTime());
        course.setStartsOn(new GregorianCalendar(2016,Calendar.MARCH,7).getTime());
        
        
        content.setDescription("Fahad Satti ka Period");
        content.setEndtime(new GregorianCalendar(2016,Calendar.MARCH,8).getTime());
        content.setStarttime(new GregorianCalendar(2016,Calendar.MARCH,10).getTime());
        content.setTitle("lecture 1");
        content.setCourse(course);
        
        student.setCourses(set2);
        student.setName("Hassan Iftikhar");
        Set set = new HashSet<Student>();
        set.add(student);
        content.setStudents(set);
        List<Clo> list = new ArrayList<>();
        list.add(clo);
        content.setClo(list);
        Set set1 = new HashSet<Content>();
        set1.add(content);
        course.setContents(set1);
        teacher.setCourses(set2);
        teacher.setName("Umer Arif");
        course.setTeacher(teacher);
        
        
        teac_dao.addTeacher(teacher);
        cont_dao.addContent(content);
        cour_dao.addCourse(course);
        
        
       
        
        // Delete an existing clo
        //dao.deleteClo(1);

        // Get all clos
        for (Clo iter : clodao.getAllClos()) {
            System.out.println(iter);
        }

        // Get clo by id
        System.out.println(clodao.getCloById(1));

        
    }

}