package rocks.zipcode.io.quiz4.collections;

/**
 * @author leon on 11/12/2018.
 */
public class Student implements Comparable<Student>{
    private Double totalAmountOfHoursLearned;
    private Integer id;
    public Student() {
        this(-1);
    }

    public Student(Integer id) {
        this.id = id;
        totalAmountOfHoursLearned = 0d;
    }

    public void learn(Double amountOfHours) {
        totalAmountOfHoursLearned += amountOfHours;
    }

    public Double getTotalStudyTime() {
        return totalAmountOfHoursLearned;
    }

    @Override
    public int compareTo(Student o) {
        return id - o.id;
    }
}
