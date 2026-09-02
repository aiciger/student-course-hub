package hbv.View;

import hbv.DTO.KursDTO;
import hbv.DTO.PersonDTO;
import hbv.Enum.Path;

public class KursView extends Html {

    public KursView(String title) {
        super(title);
    }

    public void update(KursDTO kurs) {
        init();
        setTitle(kurs.getName());
        appendBody(String.format("<h2>%s</h2>", kurs.getName()));
        appendBody("Teilnehmerliste");
        appendBody("<table class='table text-white'><thead><tr><th scope='col'>" + kurs.getTeilnehmer().size()
                + " Teilnehmende</th>"
                + "<th scope='col' class='text-end'>"
                + "<a href='?join=true' class='btn bg-white'>Beitreten</a>"
                + "<a href='?join=false' class='btn mx-2 bg-white'>Verlassen</a>"
                + "</th></tr></thead><tbody>");
        for (PersonDTO p : kurs.getTeilnehmer()) {
            String ui = String.format("<tr><td><a href='%s/%s'>%s</a></td><td></td></tr>", Path.USER.getPath(),
                    p.getName(), p.getName());
            appendBody(ui);
        }
        appendBody("</tbody></table>");
    }
}
