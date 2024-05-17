package dao;
import model.Odontologo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import java.util.ArrayList;

import model.Paciente;
import org.apache.log4j.Logger;

public class OdontologoDAOH2 implements iDao<Odontologo> {
    private static final Logger logger= Logger.getLogger(OdontologoDAOH2.class);
    private static final String SQL_SELECT_ALL="SELECT * FROM ODONTOLOGOS";
    private static final String SQL_INSERT = "INSERT INTO Odontologos (matricula, nombre, apellido) VALUES (?, ?, ?)";


    @Override
    public Odontologo guardar(Odontologo odontologo) {
        logger.info("Iniciando operación de guardar un odontólogo");
        Connection connection = null;

        try{
            connection= BD.getConnection();
            PreparedStatement psinsert= connection.prepareStatement(SQL_INSERT);
            psinsert.setInt(1, odontologo.getId());
            psinsert.setInt(2, odontologo.getNumeroMatricula());
            psinsert.setString(3, odontologo.getNombre());
            psinsert.setString(4, odontologo.getApellido());
            psinsert.execute();
            logger.info("objeto guardado en la tabla");

        } catch(Exception e){
            logger.warn(e.getMessage());
        }
        return odontologo;


    }



    @Override
    public Odontologo buscarPorId(Integer id) {
        return null;
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public void actualizar(Odontologo odontologo) {

    }

    @Override
    public List<Odontologo> buscarTodos() {
        Connection connection = null;
        List<Odontologo> odontologos = new ArrayList<>();
        try {
            connection = BD.getConnection();
            PreparedStatement psselect = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = psselect.executeQuery();
            while (rs.next()) {
                Odontologo odontologo = new Odontologo(
                        rs.getInt("ID"),
                        rs.getInt("MATRICULA"),
                        rs.getString("NOMBRE"),
                        rs.getString("APELLIDO")

                );
                odontologos.add(odontologo);
            }
            logger.info("Se encontró la lista de  " + odontologos.size() + " odontólogos.");
        } catch (Exception e) {
            logger.warn(e.getMessage());
        }
        return odontologos;
    }





}
