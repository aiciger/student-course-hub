package hbv.DTO;

import java.util.LinkedList;
import java.util.List;

public class PersonDTO {
    private int id;
    private String name;
    private String password;
    private String role;
    private String studiengang;
    private List<KursDTO> kurse = new LinkedList<KursDTO>();
    

    public PersonDTO(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public PersonDTO() {
    }
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStudiengang() {
        return this.studiengang;
    }

    public void setStudiengang(String studiengang) {
        this.studiengang = studiengang;
    }

    public List<KursDTO> getKurse() {
        return kurse;
    }

    public void setKurse(List<KursDTO> kurs) {
        this.kurse = kurs;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
