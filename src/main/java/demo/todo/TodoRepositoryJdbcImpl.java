package demo.todo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//@Repository
public class TodoRepositoryJdbcImpl implements TodoRepository {

    @Inject
    JdbcTemplate jdbcTemplate;

    @Override
    public Todo findOne(Long aLong) {
        return jdbcTemplate.queryForObject(
                "SELECT todo_id, todo_title, finished, created_at, version " +
                        "WHERE todoId = :todoId",
                new RowMapper<Todo>() {
                    @Override
                    public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new Todo(rs.getLong("todo_id"),
                                rs.getString("todo_title"),
                                rs.getBoolean("finished"),
                                rs.getTimestamp("created_at"),
                                rs.getLong("version"));
                    }
                });
    }

//    @Override
//    public Todo findOne(Long aLong) {
//        return jdbcTemplate.queryForObject(
//                "SELECT todo_id, todo_title, finished, created_at, version " +
//                        "WHERE todoId = :todoId",
//                (rs, rowNum) -> new Todo(rs.getLong("todo_id"),
//                        rs.getString("todo_title"),
//                        rs.getBoolean("finished"),
//                        rs.getTimestamp("created_at"),
//                        rs.getLong("version")));
//    }

    @Override
    public <S extends Todo> S save(S s) {
        return null;
    }

    @Override
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public List<Todo> findAll() {
        return null;
    }

    @Override
    public List<Todo> findAll(Sort orders) {
        return null;
    }

    @Override
    public Page<Todo> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Todo> findAll(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public void delete(Todo todo) {

    }

    @Override
    public void delete(Iterable<? extends Todo> todos) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void flush() {

    }

    @Override
    public Todo saveAndFlush(Todo todo) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Todo> todos) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public <S extends Todo> List<S> save(Iterable<S> ses) {
        return null;
    }
}
