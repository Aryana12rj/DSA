SELECT 
    id,
    CASE
        WHEN p_id IS NULL THEN 'Root'
        WHEN EXISTS (SELECT 1 FROM tree WHERE p_id = t.id) THEN 'Inner'
        ELSE 'Leaf'
    END AS type
FROM tree t
ORDER BY id;

