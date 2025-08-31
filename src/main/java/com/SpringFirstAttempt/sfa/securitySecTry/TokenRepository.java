package com.SpringFirstAttempt.sfa.securitySecTry;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TokenRepository {

    @Query(value = """
            select t from token t inner join user_2 on t.user.id=user_2.id where\s
            user_2.id=id and(t.is_expired = false and t.is_revoked=false)
            """)
    List<Token> findAllValidTokenByUserId(Integer id);

}
