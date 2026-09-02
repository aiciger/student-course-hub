package hbv.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import hbv.MyLogger;
import hbv.DTO.KursDTO;
import hbv.DTO.PersonDTO;

public class KursDAO implements DAOInterface<KursDTO> {
    Database database;

    public KursDAO() {
        database = new Database();
    }

    public KursDTO findKursUndTeilnehmer(String name) {
        KursDTO kurs = findByName(name);
        if (kurs == null) {
            return null;
        }

        final String JOIN_STATEMENT = "SELECT person.name FROM person INNER JOIN person_kurse ON person.id = person_kurse.person_id INNER JOIN kurse ON kurse.id = person_kurse.kurse_id WHERE kurse.name = ? ORDER BY person.name";

        try (Connection connection = database.connect();
                PreparedStatement statement = connection.prepareStatement(JOIN_STATEMENT)) {
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                PersonDTO person = new PersonDTO();
                person.setName(rs.getString("name"));
                kurs.setTeilnehmer(person);
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return kurs;
    }

    public void insertPersonToKurs(PersonDTO person, KursDTO kurs) {
        final String INSERT_STATEMENT = "INSERT INTO person_kurse(person_id, kurse_id) VALUES (?, ?)";

        try (Connection connection = database.connect();
                PreparedStatement statement = connection.prepareStatement(INSERT_STATEMENT)) {
            statement.setInt(1, person.getId());
            statement.setInt(2, kurs.getId());
            int rowCount = statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletePersonFromKurs(PersonDTO person, KursDTO kurs) {
        final String DELETE_STATEMENT = "DELETE FROM person_kurse WHERE person_id = ? AND kurse_id = ?";
        try (Connection connection = database.connect();
                PreparedStatement statement = connection.prepareStatement(DELETE_STATEMENT)) {
            statement.setInt(1, person.getId());
            statement.setInt(2, kurs.getId());
            int rowCount = statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<KursDTO> findAll() {
        return null;
    }

    @Override
    public KursDTO findById(int id) {
        final String SELECT_STATEMENT = "SELECT * FROM kurse WHERE id=?";
        KursDTO kurs = null;

        try (Connection connection = database.connect();
                PreparedStatement statement = connection.prepareStatement(SELECT_STATEMENT)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                kurs = new KursDTO();
                kurs.setId(rs.getInt("id"));
                kurs.setName(rs.getString("name"));
                kurs.setSemester(rs.getInt("semester"));
                return kurs;
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public KursDTO findByName(String name) {
        final String SELECT_STATEMENT = "SELECT * FROM kurse WHERE name=?";
        KursDTO kurs = null;

        try (Connection connection = database.connect();
                PreparedStatement statement = connection.prepareStatement(SELECT_STATEMENT)) {
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                kurs = new KursDTO();
                kurs.setId(rs.getInt("id"));
                kurs.setName(rs.getString("name"));
                kurs.setSemester(rs.getInt("semester"));
                return kurs;
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insert(KursDTO t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update(KursDTO t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(KursDTO t) {
        // TODO Auto-generated method stub
        return false;
    }
}
