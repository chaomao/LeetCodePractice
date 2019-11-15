--https://leetcode-cn.com/problems/duplicate-emails/

SELECT Email FROM Person group by Email having count(Email) > 1