package hbv.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import hbv.MyLogger;
import hbv.DTO.KursDTO;
import hbv.DTO.StudiengangDTO;

public class StudiengangDAO implements DAOInterface<StudiengangDTO> {
    Database database;

    public StudiengangDAO() {
        database = new Database();
    }

    public StudiengangDTO findKurse(String name) {
        if (findByName(name) == null) {
            return null;
        }

        final String JOIN_STATEMENT = "SELECT kurse.semester, kurse.name FROM studiengang INNER JOIN studiengang_kurse ON studiengang.id = studiengang_kurse.studiengang_id INNER JOIN kurse ON kurse.id = studiengang_kurse.kurse_id WHERE studiengang.name = ?";

        StudiengangDTO studiengang = null;
        try (Connection connection = database.connect();
                PreparedStatement statement = connection.prepareStatement(JOIN_STATEMENT)) {
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            
            studiengang = new StudiengangDTO();
            studiengang.setName(name);
            while (rs.next()) {
                KursDTO kurs = new KursDTO();
                kurs.setName(rs.getString("name"));
                kurs.setSemester(rs.getInt("semester"));
                studiengang.setKurse(kurs);
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studiengang;
    }

    @Override
    public List<StudiengangDTO> findAll() {
        final String SELECT_STATEMENT = "SELECT * FROM studiengang";
        List<StudiengangDTO> list = new LinkedList<>();

        try (Connection connection = database.connect();
                PreparedStatement statement = connection.prepareStatement(SELECT_STATEMENT)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                StudiengangDTO studiengang = new StudiengangDTO();
                studiengang.setId(rs.getInt("id"));
                studiengang.setName(rs.getString("name"));
                list.add(studiengang);
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public StudiengangDTO findById(int id) {
        final String SELECT_STATEMENT = "SELECT * FROM studiengang WHERE id=?";
        StudiengangDTO studiengang = null;

        try (Connection connection = database.connect();
                PreparedStatement statement = connection.prepareStatement(SELECT_STATEMENT)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                studiengang = new StudiengangDTO();
                studiengang.setId(rs.getInt("id"));
                studiengang.setName(rs.getString("name"));
                return studiengang;
            }

            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public StudiengangDTO findByName(String name) {
        final String SELECT_STATEMENT = "SELECT * FROM studiengang WHERE name=?";
        StudiengangDTO studiengang = null;

        try (Connection connection = database.connect();
                PreparedStatement statement = connection.prepareStatement(SELECT_STATEMENT)) {
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                studiengang = new StudiengangDTO();
                studiengang.setId(rs.getInt("id"));
                studiengang.setName(rs.getString("name"));
                return studiengang;
            }

            rs.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean insert(StudiengangDTO t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update(StudiengangDTO t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(StudiengangDTO t) {
        // TODO Auto-generated method stub
        return false;
    }

}
