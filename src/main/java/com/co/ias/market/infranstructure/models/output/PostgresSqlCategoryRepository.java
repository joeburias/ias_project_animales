package com.co.ias.market.infranstructure.models.output;

import com.co.ias.market.categories.application.domain.Category;
import com.co.ias.market.categories.application.domain.valueObjs.CategoryId;
import com.co.ias.market.categories.application.ports.output.CategoryRepository;
import com.co.ias.market.infranstructure.logSystem.Log;
import com.co.ias.market.infranstructure.models.CategoryDAO;
import com.co.ias.market.infranstructure.models.ProductDAO;
import com.co.ias.market.products.application.domain.Product;
import com.co.ias.market.products.application.domain.valueObjs.ProductId;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class PostgresSqlCategoryRepository implements CategoryRepository {
    private final DataSource dataSource;

    public PostgresSqlCategoryRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void store(Category category) {
        String sql = "INSERT INTO categories (name, description, place, approval) values (?, ?, ?, ?)";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, category.getName().getValue());
            preparedStatement.setString(2, category.getDescription().getValue());
            preparedStatement.setString(3, category.getPlace().getValue());
            preparedStatement.setString(4, category.getApproval().getValue());

            preparedStatement.execute();

        } catch (SQLException exception) {
            System.out.println("Errror DB....: "  + exception.getMessage());
            throw new RuntimeException("Error queryng database", exception);
        }
    }

    @Override
    public Optional<Category> get(CategoryId categoryId) {
        String sql = "Select * From categories Where id = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, categoryId.getValue());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                CategoryDAO categoryDAO = CategoryDAO.fromResultSet(resultSet);
                //logic ---
                Category category = categoryDAO.toDomain();
                return Optional.of(category);
            } else {
                return Optional.empty();
            }

        } catch (SQLException exception) {

            throw new RuntimeException("Error queryn database", exception);
        }
    }

    @Override
    public void update(Category category) {
        String sql = "Update categories Set name = ?, description = ?, place = ?, approval = ? Where id = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, category.getName().getValue());
            preparedStatement.setString(2, category.getDescription().getValue());
            preparedStatement.setString(3, category.getPlace().getValue());
            preparedStatement.setString(4, category.getApproval().getValue());
            preparedStatement.setLong(5, category.getId().getValue());

            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            Log log = new Log(exception.getMessage(), "Error queryn database");
            log.logger();
            throw new RuntimeException("Error queryn database", exception);
        }
    }

    @Override
    public Boolean delete(CategoryId categoryId) {
        String sql = "Delete from categories Where id = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, categoryId.getValue());

            Boolean result = preparedStatement.execute();

            return result;

        } catch (SQLException exception) {
            Log log = new Log(exception.getMessage(), "Error queryn database");
            throw  new RuntimeException("Error queryng database", exception);
        }
    }
}
