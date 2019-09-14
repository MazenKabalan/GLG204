package jpa;

import javax.persistence.*;


@Entity
@Table(
        name="Attendance",
        uniqueConstraints = @UniqueConstraint(columnNames ={ "LECTURE_LECTURE_ID", "PERSON_PERSON_ID"})
)
@NamedQueries({
        @NamedQuery(
                name = "selectAllAttendance",
                query = "SELECT a from Attendance a"),
        @NamedQuery(
                name = "selectAllStudents",
                query = "SELECT p FROM Person p JOIN Registration r ON p.person_id=r.person.person_id WHERE p.role.role_id = ?1"),
        @NamedQuery(
                name = "selectAllStudentsByCourse",
                query = "SELECT p FROM Person p JOIN Registration r ON p.person_id=r.person.person_id WHERE p.role.role_id = ?1 AND r.course.course_id = ?2"),
        @NamedQuery(
                name = "selectAllStudentsByLecture",
                query = "SELECT p FROM Person p JOIN Registration r ON p.person_id=r.person.person_id " +
                        "JOIN Lecture lec ON r.course.course_id = lec.course.course_id " +
                        "WHERE p.role.role_id = ?1 AND r.course.course_id = ?2  AND lec.lecture_id = ?3 ORDER BY p.firstName"),
        @NamedQuery(
                name = "selectStudentsByAttendance",
                query = "SELECT a FROM Attendance a JOIN Person p ON p.person_id=a.person.person_id WHERE p.role.role_id = ?1  AND a.lecture.lecture_id = ?2 ORDER BY p.firstName"),
        @NamedQuery(
                name = "selectStudentAttendanceByCourse",
                query = "SELECT a FROM Attendance a JOIN Person p ON p.person_id=a.person.person_id JOIN Lecture l ON l.lecture_id=a.lecture.lecture_id WHERE p.role.role_id = ?1  AND l.course.course_id = ?2  AND p.person_id = ?3 ORDER BY p.firstName")
})

public class Attendance
{
    @ManyToOne(cascade = CascadeType.MERGE)
    private Person person;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Lecture lecture;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long attendance_id;

    @Column(nullable = true)
    private boolean present;

    @Column(nullable = true)
    private double latitude;

    @Column(nullable = true)
    private double longitude;

    public Attendance()
    {
    }

    public Attendance(Person person, Lecture lecture, boolean present)
    {
        this.person = person;
        this.lecture = lecture;
        this.present = present;
  }

    public Long getAttendance_id()
    {
        return attendance_id;
    }

    public void setAttendance_id(Long id)
    {
        this.attendance_id = id;
    }

    public Person getPerson()
    {
        return person;
    }

    public void setPerson(Person person)
    {
        this.person = person;
    }

    public Lecture getLecture()
    {
        return lecture;
    }

    public void setLecture(Lecture lecture)
    {
        this.lecture = lecture;
    }


    public boolean getPresent()
    {
        return present;
    }
  
    public String getPresentFormated()
    {
        if (present) 
            return "Oui";
        else
            return "Non";
    }
  
    public void setPresent(boolean present)
    {
        this.present = present;
            
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    
    
}
