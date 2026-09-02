package hbv.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import hbv.DTO.KursDTO;
import hbv.DTO.PersonDTO;
import hbv.Enum.Studiengang;

public class PersonDAO implements DAOInterface<PersonDTO> {
    Database database;

    public PersonDAO() {
        database = new Database();
    }

    public boolean authenticate(PersonDTO person) {
        boolean state = false;
        try (Connection connection = database.connect();
                PreparedStatement statement = connection
                        .prepareStatement("SELECT * FROM person where name=? AND password=PASSWORD(?)")) {
            statement.setString(1, person.getName());
            statement.setString(2, person.getPassword());
            ResultSet rs = statement.executeQuery();
            state = rs.next();
            person.setId(rs.getInt("id"));
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return state;
    }

    public List<KursDTO> findKurseByTeilnehmer(String name) {
        final String JOIN_STATEMENT = "SELECT kurse.* FROM kurse INNER JOIN person_kurse ON kurse.id = person_kurse.kurse_id INNER JOIN person ON person.id = person_kurse.person_id WHERE person.name = ? ORDER BY kurse.name;";
        List<KursDTO> list = new LinkedList<>();

        try (Connection connection = database.connect();
                PreparedStatement statement = connection.prepareStatement(JOIN_STATEMENT)) {
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                KursDTO k = new KursDTO();
                k.setId(rs.getInt("id"));
                k.setName(rs.getString("name"));
                k.setSemester(rs.getInt("semester"));
                list.add(k);
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<PersonDTO> findAll() {
        final String SELECT_STATEMENT = "SELECT person.*, studiengang.name AS sname FROM person INNER JOIN studiengang ON person.studiengang_id = studiengang.id ORDER BY person.id";
        List<PersonDTO> list = new LinkedList<>();

        try (Connection connection = database.connect();
                PreparedStatement statement = connection.prepareStatement(SELECT_STATEMENT)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                PersonDTO person = new PersonDTO();
                person.setId(rs.getInt("id"));
                person.setName(rs.getString("name"));
                person.setRole(rs.getString("role"));
                person.setStudiengang(rs.getString("sname"));
                list.add(person);
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public PersonDTO findById(int id) {
        final String SELECT_STATEMENT = "SELECT person.*, studiengang.name AS sname FROM person LEFT JOIN studiengang ON person.studiengang_id = studiengang.id WHERE person.id =?";
        PersonDTO person = null;

        try (Connection connection = database.connect();
                PreparedStatement statement = connection.prepareStatement(SELECT_STATEMENT)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                person = new PersonDTO();
                person.setId(rs.getInt("id"));
                person.setName(rs.getString("name"));
                person.setRole(rs.getString("role"));
                person.setStudiengang(rs.getString("sname"));
                return person;
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PersonDTO findByName(String name) {
        final String SELECT_STATEMENT = "SELECT person.*, studiengang.name AS sname FROM person LEFT JOIN studiengang ON person.studiengang_id = studiengang.id WHERE person.name =?";
        PersonDTO person = null;

        try (Connection connection = database.connect();
                PreparedStatement statement = connection.prepareStatement(SELECT_STATEMENT)) {
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                person = new PersonDTO();
                person.setId(rs.getInt("id"));
                person.setName(rs.getString("name"));
                person.setRole(rs.getString("role"));
                person.setStudiengang(rs.getString("sname"));
                person.setKurse(findKurseByTeilnehmer(name));
                return person;
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insert(PersonDTO person) {
        final String INSERT_STATEMENT = "INSERT INTO person (name, password, studiengang_id) VALUES (?, PASSWORD(?), ?)";
        try (Connection connection = database.connect();
                PreparedStatement statement = connection.prepareStatement(INSERT_STATEMENT)) {
            statement.setString(1, person.getName());
            statement.setString(2, person.getPassword());
            statement.setInt(3, Studiengang.getID(person.getStudiengang()));

            int rowCount = statement.executeUpdate();
            if (rowCount == 1) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(PersonDTO t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(PersonDTO t) {
        // TODO Auto-generated method stub
        return false;
    }
}