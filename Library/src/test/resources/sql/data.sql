INSERT INTO books (id, title, content, path)
VALUES (1, 'Kubernetes в действии', 'content', '/home/roma/Documents/books/kuber/Kubernetes в действии.pdf'),
       (2, '1984', 'content', '/home/roma/Documents/books/Джордж Оруэлл/Оруэлл Джордж. 1984.fb2'),
       (3, 'Адамс 01 Путеводитель «Автостопом по Галактике»', 'content',
        '/home/roma/Documents/books/Дуглас Адамс/Автостопом по Галактике/Адамс 01 Путеводитель «Автостопом по Галактике».fb2');
SELECT SETVAL('books_id_seq', (SELECT MAX(id) FROM books));