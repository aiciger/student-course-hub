package hbv.DTO;

import java.util.LinkedList;
import java.util.List;

public class KursDTO {
    private int id;
    private String name;
    private int semester;
    private List<PersonDTO> teilnehmer = new LinkedList<>();
    private List<StudiengangDTO> studiengaenge = new LinkedList<>();

    public String getName() {
        return this.name;
    }

    public List<StudiengangDTO> getStudiengaenge() {
        return studiengaenge;
    }

    public void setStudiengaenge(StudiengangDTO studiengang) {
        this.studiengaenge.add(studiengang);
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSemester() {
        return this.semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public List<PersonDTO> getTeilnehmer() {
        return teilnehmer;
    }

    public void setTeilnehmer(PersonDTO person) {
        this.teilnehmer.add(person);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public KursDTO() {

    }
}
