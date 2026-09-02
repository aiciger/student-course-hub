package hbv.DTO;

import java.util.LinkedList;
import java.util.List;

public class StudiengangDTO {
    private Integer id;
    private String name;
    private List<KursDTO> kurse = new LinkedList<KursDTO>();

    public String getName() {
        return name;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<KursDTO> getKurse() {
        return kurse;
    }

    public void setKurse(KursDTO kurs) {
        this.kurse.add(kurs);
    }


    public StudiengangDTO(String name) {
        this.name = name;
    }

    public StudiengangDTO() {
    }
}
