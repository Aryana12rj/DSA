# Write your MySQL query statement below
(
    SELECT u.name AS results
    FROM users u
    JOIN movierating m
        ON u.user_id=m.user_id
    GROUP BY u.user_id
    ORDER BY COUNT(u.user_id) DESC, u.name ASC 
    LIMIT 1
)
UNION ALL
(
    SELECT mo.title AS results
    FROM movies mo
    JOIN movierating m
        ON mo.movie_id=m.movie_id
    WHERE m.created_at BETWEEN '2020-02-01' AND '2020-02-29'
    GROUP BY mo.movie_id, mo.title
    ORDER BY AVG(m.rating) DESC, mo.title ASC 
    LIMIT 1
)