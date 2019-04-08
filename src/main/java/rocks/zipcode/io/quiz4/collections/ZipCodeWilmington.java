package rocks.zipcode.io.quiz4.collections;

import java.util.*;

/**
 * @author leon on 11/12/2018.
 */
public class ZipCodeWilmington {
    private List<Student> students;

    public ZipCodeWilmington() {
        this(new ArrayList<>());
    }

    public ZipCodeWilmington(List<Student> students) {
        this.students = students;
    }

    public void enroll(Student student) {
        students.add(student);
    }

    public Boolean isEnrolled(Student student) {
        return students.contains(student);
    }

    public void lecture(double numberOfHours) {
        students.forEach(student -> student.learn(numberOfHours));
    }

    public Map<Student, Double> getStudyMap() {
        Map<Student, Double> studentStudyMap = new TreeMap<>();
        students.forEach(student -> studentStudyMap.put(student, student.getTotalStudyTime()));
        return studentStudyMap;
    }
}
