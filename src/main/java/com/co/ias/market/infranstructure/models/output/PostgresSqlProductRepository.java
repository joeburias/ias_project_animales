package com.co.ias.market.infranstructure.models.output;

import com.co.ias.market.infranstructure.logSystem.Log;
import com.co.ias.market.infranstructure.models.ProductDAO;
import com.co.ias.market.products.application.domain.Product;
import com.co.ias.market.products.application.domain.valueObjs.ProductId;
import com.co.ias.market.products.application.ports.output.ProductRepository;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class PostgresSqlProductRepository implements ProductRepository {

    private final DataSource dataSource;

    public PostgresSqlProductRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void store(Product product) {
        String sql = "INSERT INTO products (name, price, description, category) values (?, ?, ?, ?)";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, product.getName().getValue());
            preparedStatement.setInt(2, product.getPrice().getValue());
            preparedStatement.setString(3, product.getDescription().getValue());
            preparedStatement.setLong(4, product.getCategory().getValue());

            preparedStatement.execute();

        } catch (SQLException exception) {
            System.out.println("Errror DB....: "  + exception.getMessage());
            throw new RuntimeException("Error queryng database", exception);
        }
    }

    @Override
    public Optional<Product> get(ProductId productId) {
        String sql = "Select * From products Where id = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, productId.getValue());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                ProductDAO productDAO = ProductDAO.fromResultSet(resultSet);
                // logic ---
                Product product = productDAO.toDomain();
                return Optional.of(product);
            } else {
                return Optional.empty();
            }

        } catch (SQLException exception) {

            throw new RuntimeException("Error queryn database", exception);
        }

    }

    @Override
    public void update(Product product) {
        String sql = "Update products Set name = ?, price = ?, description = ?, category = ? Where id = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, product.getName().getValue());
            preparedStatement.setInt(2, product.getPrice().getValue());
            preparedStatement.setString(3, product.getDescription().getValue());
            preparedStatement.setLong(4, product.getCategory().getValue());
            preparedStatement.setLong(5, product.getId().getValue());

            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            Log log = new Log(exception.getMessage(), "Error queryn database");
            log.logger();
            throw new RuntimeException("Error queryn database", exception);
        }
    }

    @Override
    public Boolean delete(ProductId productId) {
        String sql = "Delete from products Where id = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, productId.getValue());

            Boolean result = preparedStatement.execute();

            return result;

        } catch (SQLException exception) {
            Log log = new Log(exception.getMessage(), "Error queryn database");
            throw  new RuntimeException("Error queryng database", exception);
        }
    }
}

