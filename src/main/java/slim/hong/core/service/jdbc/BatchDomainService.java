package slim.hong.core.service.jdbc;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SimplePropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;
import slim.hong.core.model.Member;

import java.util.List;

/**
 * @see https://docs.spring.io/spring-framework/reference/data-access/jdbc/advanced.html
 */
@Service
public class BatchDomainService {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public BatchDomainService(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int[] bulkInsert(List<Member> members) {
        String sql = "insert into member (username) values (:username)";

        SqlParameterSource[] params = members
                .stream()
                // .map(SimplePropertySqlParameterSource::new)
                .map(member -> toParamSource(member))
                .toArray(SqlParameterSource[]::new);

        return jdbcTemplate.batchUpdate(sql, params);
    }

    private SqlParameterSource toParamSource(Member member) {
        //TODO: MapSqlParameterSource
        return new SimplePropertySqlParameterSource(member);
    }

}
