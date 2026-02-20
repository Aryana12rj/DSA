# Write your MySQL query statement below
WITH one_action_per_day AS (
	SELECT user_id, action_date, MAX(action) action
	FROM activity
	GROUP BY user_id, action_date
	HAVING COUNT(1) = 1
), find_consecutive_days AS (
	SELECT user_id, action_date, action,
    DATE_ADD(action_date, INTERVAL - row_number() over(partition by user_id order by action_date) DAY ) group_action_date
	FROM one_action_per_day
), filter_streak AS (
	SELECT user_id, action, 
	min(action_date) start_date,
	max(action_date) end_date,
	count(1) streak_length
	FROM find_consecutive_days
	GROUP BY user_id, action, group_action_date
	HAVING COUNT(1) > 4
)

SELECT user_id, action, streak_length, start_date, end_date
FROM filter_streak f
WHERE streak_length >= (SELECT MAX(streak_length) FROM filter_streak f1 WHERE f.user_id = f1.user_id)
ORDER BY streak_length DESC, user_id ASC