package hbv.View;

import java.util.List;

import hbv.DTO.KursDTO;
import hbv.DTO.PersonDTO;
import hbv.Enum.Path;

public class UserView extends Html {

    public UserView(String title) {
        super(title);
    }

    public void update(PersonDTO person) {
        init();
        setTitle(person.getName());
        appendBody(String.format("<h2>%s</h2>", person.getName()));
        appendBody(String.format("<h5>%s</h5>", person.getStudiengang()));
        appendBody(
                "<table class='table text-white'> <thead> <tr><th scope='col'>Aktive Module</th> </tr> </thead><tbody>");
        for (KursDTO k : person.getKurse()) {
            String ui = String.format(
                    "<tr><td>%s</td></tr>",
                    k.getName());
            appendBody(ui);
        }

        appendBody("</tbody></table>");
    }

    public void update(List<PersonDTO> userlist) {
        init();
        setTitle("Personen");
        appendBody("<h2>Liste aller Personen</h2>");
        appendBody("<p>" + userlist.size() + "</p>");
        appendBody(
                "<table class='table text-white'> <thead> <tr><th scope='col'>Name</th> </tr> </thead><tbody>");
        for (PersonDTO p : userlist) {
            String ui = String.format("<tr><td><a href='%s/%s'>%s</a></td><td></td></tr>", Path.USER.getPath(),
                    p.getName(), p.getName());
            appendBody(ui);
        }

        appendBody("</tbody></table>");
    }
}
