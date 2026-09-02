package hbv.View;

import java.util.List;

import hbv.MyLogger;
import hbv.DTO.KursDTO;
import hbv.DTO.StudiengangDTO;
import hbv.Enum.Path;

public class StudiengangView extends Html {

    public StudiengangView(String title) {
        super(title);
    }

    public void update(List<StudiengangDTO> studiengaenge) {
        init();
        appendBody("<h2>Studiengänge</h2>");
        appendBody("<table class='table text-white'><thead><tr><th scope='col'>Fachbereich</th></tr></thead><tbody>");
        for (StudiengangDTO s : studiengaenge) {
            String ui = String.format("<tr><td><a href='%s/%s/'>%s</a></td></tr>",
                    Path.STUDIENGANG.getPath(),
                    s.getName(),
                    s.getName());
            appendBody(ui);
        }
        appendBody("</tbody></table>");
    }

    public void update(StudiengangDTO studiengang) {
        init();
        setTitle(studiengang.getName());
        appendBody(String.format("<h2>%s</h2>", studiengang.getName()));
        appendBody(
                "<table class='table text-white'> <thead> <tr> <th scope='col'>Semester</th> <th scope='col'>Module</th><th scope='col'></th> </tr> </thead><tbody>");
        for (KursDTO k : studiengang.getKurse()) {
            String ui = String.format(
                    "<tr><td>%s</td><td>%s</td><td><a href='%s/%s' class='btn bg-white'>&#8618;</a></td></tr>",
                    k.getSemester(),
                    k.getName(),
                    Path.KURS.getPath(),
                    k.getName());
            appendBody(ui);
        }

        appendBody("</tbody></table>");
    }
}
