SELECT COUNT(*) FROM books;
SELECT COUNT(*) FROM members;
SELECT COUNT(*) FROM issued_status;

SELECT m.member_name, b.book_title, i.issued_date
FROM issued_status i
JOIN members m ON i.issued_member_id = m.member_id
JOIN books b ON i.issued_book_isbn = b.isbn;

SELECT COUNT(*) AS total_issued FROM issued_status;

SELECT *
FROM issued_status i
LEFT JOIN return_status r 
ON i.issued_id = r.issued_id
WHERE r.issued_id IS NULL;

SELECT * FROM books;