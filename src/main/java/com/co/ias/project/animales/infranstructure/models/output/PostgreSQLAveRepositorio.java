package com.co.ias.project.animales.infranstructure.models.output;

import com.co.ias.project.animales.aves.application.domain.Ave;
import com.co.ias.project.animales.aves.application.domain.valueObjs.AveId;
import com.co.ias.project.animales.aves.application.domain.valueObjs.AveNombreCientifico;
import com.co.ias.project.animales.aves.application.domain.valueObjs.AveNombreComun;
import com.co.ias.project.animales.aves.application.domain.valueObjs.AveNombreZona;
import com.co.ias.project.animales.aves.application.ports.output.AveRepositorio;
import com.co.ias.project.animales.infranstructure.logSystem.Log;
import com.co.ias.project.animales.infranstructure.models.AveDAO;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class PostgreSQLAveRepositorio implements AveRepositorio {

    private final DataSource dataSource;

    public PostgreSQLAveRepositorio(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void store(Ave ave) {
        String sql = "INSERT INTO \"TBL_AVES\" (nombre_comun, nombre_cientifico, nombre_zona, cantidad_confirmada) " +
                "values (?, ?, ?, ?)";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, ave.getAveNombreComun().getValue());
            preparedStatement.setString(2, ave.getAveNombreCientifico().getValue());
            preparedStatement.setString(3, ave.getAveNombreZona().getValue());
            preparedStatement.setInt(4, ave.getAveCantidadConfirmada().getValue());

            preparedStatement.execute();

        } catch (SQLException exception) {
            System.out.println("Error en la base de datos: "  + exception.getMessage());
            throw new RuntimeException("Error en la consulta en la base de datos! Detalles: ", exception);
        }
    }

    @Override
    public Optional<Ave> get(AveId aveId) {
        String sql = "Select * From \"TBL_AVES\" Where id = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, aveId.getValue());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                AveDAO aveDAO = AveDAO.fromResultSet(resultSet);
                Ave ave = aveDAO.toDomain();
                return Optional.of(ave);
            } else {
                return Optional.empty();
            }

        } catch (SQLException exception) {

            throw new RuntimeException("Error en la consulta en la base de datos! Detalles: ", exception);
        }
    }

    @Override
    public Optional<Ave> get(AveNombreComun aveNombreComun) {
        String sql = "Select * From \"TBL_AVES\" Where nombre_comun = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, aveNombreComun.getValue());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                AveDAO aveDAO = AveDAO.fromResultSet(resultSet);
                Ave ave = aveDAO.toDomain();
                return Optional.of(ave);
            } else {
                return Optional.empty();
            }

        } catch (SQLException exception) {

            throw new RuntimeException("Error en la consulta en la base de datos! Detalles: ", exception);
        }
    }

    @Override
    public Optional<Ave> get(AveNombreCientifico aveNombreCientifico) {
        String sql = "Select * From \"TBL_AVES\" Where nombre_cientifico = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, aveNombreCientifico.getValue());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                AveDAO aveDAO = AveDAO.fromResultSet(resultSet);
                Ave ave = aveDAO.toDomain();
                return Optional.of(ave);
            } else {
                return Optional.empty();
            }

        } catch (SQLException exception) {

            throw new RuntimeException("Error en la consulta en la base de datos! Detalles: ", exception);
        }
    }

    @Override
    public Optional<Ave> get(AveNombreZona aveNombreZona) {
        String sql = "Select * From \"TBL_AVES\" Where nombre_zona = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, aveNombreZona.getValue());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                AveDAO aveDAO = AveDAO.fromResultSet(resultSet);
                Ave ave = aveDAO.toDomain();
                return Optional.of(ave);
            } else {
                return Optional.empty();
            }

        } catch (SQLException exception) {

            throw new RuntimeException("Error en la consulta en la base de datos! Detalles: ", exception);
        }
    }

    @Override
    public void update(Ave ave) {
        String sql = "Update \"TBL_AVES\" Set nombre_comun = ?, nombre_cientifico = ?, nombre_zona = ?, " +
                "cantidad_confirmada = ? Where id = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, ave.getAveNombreComun().getValue());
            preparedStatement.setString(2, ave.getAveNombreCientifico().getValue());
            preparedStatement.setString(3, ave.getAveNombreZona().getValue());
            preparedStatement.setInt(4, ave.getAveCantidadConfirmada().getValue());
            preparedStatement.setLong(5, ave.getAveId().getValue());

            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            Log log = new Log(exception.getMessage(), "Error en la consulta en la base de datos!");
            log.logger();
            throw new RuntimeException("Error en la consulta en la base de datos! Detalles: ", exception);
        }
    }

    @Override
    public Boolean delete(AveId aveId) {
        String sql = "Delete from \"TBL_AVES\" Where id = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, aveId.getValue());

            Boolean result = preparedStatement.execute();

            return result;

        } catch (SQLException exception) {
            Log log = new Log(exception.getMessage(), "Error en la consulta en la base de datos!");
            throw  new RuntimeException("Error en la consulta en la base de datos!", exception);
        }
    }
}
