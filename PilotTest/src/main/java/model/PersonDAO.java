package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {

    private static final String SELECT_PEOPLE = "SELECT id,nombre FROM person";
    private static final String SELECT_BY_ID = "SELECT id,nombre FROM person WHERE id = ?";
    private static final String INSERT_PERSON = "INSERT INTO person(nombre) VALUES (?)";
    private static final String UPDATE_PERSON = "UPDATE person SET nombre = ? WHERE id = ?";
    private static final String DELETE_PERSON = "DELETE FROM person WHERE id = ?";

    public static List<PersonDTO> getPeople() {

        List<PersonDTO> people = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            conn = ConnectionDB.getConnection();
            ps = conn.prepareStatement(SELECT_PEOPLE);
            rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");

                people.add(new PersonDTO(id, nombre));

            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionDB.close(rs);
            ConnectionDB.close(ps);
            ConnectionDB.close(conn);
        }

        return people;
    }

    public static PersonDTO getPerson(PersonDTO person) {

        PersonDTO personById = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            conn = ConnectionDB.getConnection();
            ps = conn.prepareStatement(SELECT_BY_ID);

            ps.setInt(1, person.getId());

            rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");

                personById = new PersonDTO(id, nombre);

            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionDB.close(rs);
            ConnectionDB.close(ps);
            ConnectionDB.close(conn);
        }

        return personById;
    }

    public static boolean insertPerson(PersonDTO person) {

        int result = 0;

        Connection conn = null;
        PreparedStatement ps = null;

        try {

            conn = ConnectionDB.getConnection();
            ps = conn.prepareStatement(INSERT_PERSON);

            ps.setString(1, person.getNombre());

            result = ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionDB.close(ps);
            ConnectionDB.close(conn);
        }

        return result > 1;

    }

    public static boolean updatePerson(PersonDTO person) {

        int result = 0;

        Connection conn = null;
        PreparedStatement ps = null;

        try {

            conn = ConnectionDB.getConnection();
            ps = conn.prepareStatement(UPDATE_PERSON);

            ps.setString(1, person.getNombre());
            ps.setInt(2, person.getId());

            result = ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionDB.close(ps);
            ConnectionDB.close(conn);
        }

        return result > 1;

    }

    public static boolean deletePerson(PersonDTO person) {

        int result = 0;

        Connection conn = null;
        PreparedStatement ps = null;

        try {

            conn = ConnectionDB.getConnection();
            ps = conn.prepareStatement(DELETE_PERSON);

            ps.setInt(1, person.getId());

            result = ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ConnectionDB.close(ps);
            ConnectionDB.close(conn);
        }

        return result > 1;
    }

}
